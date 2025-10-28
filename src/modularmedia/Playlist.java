package modularmedia;
import java.util.*;

public class Playlist implements MediaComponent {
    private String name;
    private List<MediaComponent> items = new ArrayList<>();

    public Playlist(String name) { this.name = name; }
    public void add(MediaComponent item) { items.add(item); }

    @Override
    public void play() {
        System.out.println("[PLAYLIST] Playing Playlist: " + name);
        for (MediaComponent item : items) item.play();
        System.out.println("[COMPLETE] Finished " + name);
    }

    @Override
    public void display(int indent) {
        System.out.println(" ".repeat(indent) + "> " + name);
        for (MediaComponent item : items) item.display(indent + 3);
    }
}
