package modularmedia;
import java.util.List;

public class MediaItem implements MediaComponent {
    private String title;
    private MediaSource source;
    private MediaRenderer renderer;
    private PluginChain plugins;

    public MediaItem(String title, MediaSource source,
                     MediaRenderer renderer, PluginChain plugins) {
        this.title = title;
        this.source = source;
        this.renderer = renderer;
        this.plugins = plugins;
    }

    @Override
    public void play() {
        System.out.println("[LOADING] Loading " + source.getDescription());
        List<String> chunks = source.getChunks();

        for (int i = 0; i < chunks.size(); i++) {
            String chunk = chunks.get(i);
            System.out.println("[STREAM] Streaming chunk " + (i + 1) + ": " + chunk);
            plugins.applyAll(title);
            renderer.render(title + " [" + chunk + "]");
            try { Thread.sleep(400); } catch (InterruptedException ignored) {}
        }

        System.out.println("[COMPLETE] Finished playing: " + title);
        System.out.println("------------------------------------------------------------");
    }

    @Override
    public void display(int indent) {
        System.out.println(" ".repeat(indent) + "- " + title);
    }
}
