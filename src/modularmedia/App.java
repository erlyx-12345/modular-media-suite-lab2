package modularmedia;

import java.util.*;

public class App {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Header
        System.out.println("============================================================");
        System.out.println("              MODULAR MEDIA STREAMING SUITE");
        System.out.println("============================================================");
        System.out.println("Welcome to the Modular Media Suite!");
        System.out.println("This system lets you build and play a flexible playlist");
        System.out.println("using modular features and plugins.");
        System.out.println("============================================================");
        System.out.println();

        Playlist mainPlaylist = new Playlist("Main Playlist");

        // Main playlist creation
        boolean adding = true;
        while (adding) {
            System.out.println("Add media to playlist:");
            System.out.println("1. Local File");
            System.out.println("2. Remote Stream");
            System.out.println("3. HLS Stream");
            System.out.print("Enter choice: ");
            int srcChoice = Integer.parseInt(sc.nextLine());

            MediaSource source = switch (srcChoice) {
                case 1 -> {
                    System.out.print("Enter local filename: ");
                    yield new LocalFileSource(sc.nextLine());
                }
                case 2 -> {
                    System.out.print("Enter remote URL: ");
                    yield new RemoteStreamSource(sc.nextLine());
                }
                case 3 -> {
                    System.out.print("Enter HLS stream name: ");
                    yield new HlsStreamSource(sc.nextLine());
                }
                default -> throw new IllegalArgumentException("Invalid choice!");
            };

            System.out.println();
            System.out.println("Would you like to enable caching through a Proxy?");
            System.out.println("(This helps speed up loading by temporarily saving streams)");
            System.out.print("Use proxy cache? (y/n): ");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                source = new ProxyMediaSource(source);
                System.out.println("[OK] Proxy caching enabled  (Proxy Pattern)");
            }
            System.out.println("============================================================");

            // Renderer selection
            System.out.println("Choose how you want to render this media:");
            System.out.println("1. Software (CPU-based)");
            System.out.println("2. Hardware (GPU-based)");
            System.out.print("Enter choice: ");
            
            RenderingEngine engine;
            if (sc.nextLine().equals("2")) {
                engine = new GPURenderingEngine("RTX 3080", 10, true);
            } else {
                engine = new CPURenderingEngine(8, "x64");
            }
            
            MediaRenderer renderer = new RenderingBridge(engine);
            System.out.println("[OK] Renderer selected  (Bridge Pattern)");
            System.out.println("    Engine: " + ((RenderingBridge) renderer).getEngineDetails());
            System.out.println("============================================================");

            // Plugin selection
            PluginChain pluginChain = new PluginChain();
            System.out.println("Add extra playback features (plugins):");
            System.out.print("Add subtitles? (y/n): ");
            if (sc.nextLine().equalsIgnoreCase("y"))
                pluginChain.addPlugin(new SubtitlePlugin());

            System.out.print("Add equalizer? (y/n): ");
            if (sc.nextLine().equalsIgnoreCase("y"))
                pluginChain.addPlugin(new AudioEqualizerPlugin());

            System.out.print("Add watermark? (y/n): ");
            if (sc.nextLine().equalsIgnoreCase("y"))
                pluginChain.addPlugin(new WatermarkPlugin());
            System.out.println("============================================================");

            // Media title input
            System.out.print("Enter media title to display in playlist: ");
            String title = sc.nextLine();
            mainPlaylist.add(new MediaItem(title, source, renderer, pluginChain));

            System.out.print("Add another media file? (y/n): ");
            adding = sc.nextLine().equalsIgnoreCase("y");
            System.out.println("============================================================");
        }

        // Sub-playlist
        System.out.print("Do you want to add a sub-playlist? (y/n): ");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            System.out.println("[OK] Sub-playlist feature enabled  (Composite Pattern)");
            System.out.println("============================================================");
            Playlist subPlaylist = new Playlist("Sub Playlist");
            System.out.print("How many items in sub-playlist? ");
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                System.out.print("Enter sub-media title: ");
                String title = sc.nextLine();
                subPlaylist.add(new MediaItem(
                        title,
                        new LocalFileSource(title + ".mp4"),
                        new RenderingBridge(new CPURenderingEngine(4, "x64")),
                        new PluginChain()));
            }
            mainPlaylist.add(subPlaylist);
            System.out.println("============================================================");
        }

        // Playlist preview
        System.out.println();
        System.out.println(">>> YOUR CURRENT PLAYLIST");
        System.out.println("------------------------------------------------------------");
        mainPlaylist.display(0);
        System.out.println("============================================================");

        // Playback
        System.out.println();
        System.out.println(">>> Starting Playback...");
        System.out.println("============================================================");
        mainPlaylist.play();
        System.out.println("============================================================");
        System.out.println();
        System.out.println("[DONE] SESSION ENDED");
        System.out.println("============================================================");

    }
}
