package modularmedia;
import java.util.*;

public class LocalFileSource implements MediaSource {
    private String filename;

    public LocalFileSource(String filename) { this.filename = filename; }

    @Override
    public String getDescription() { return "local file: " + filename; }

    @Override
    public List<String> getChunks() {
        return List.of("Intro scene", "Main content", "Closing credits");
    }
}
