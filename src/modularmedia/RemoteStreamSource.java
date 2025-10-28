package modularmedia;
import java.util.*;

public class RemoteStreamSource implements MediaSource {
    private String url;

    public RemoteStreamSource(String url) { this.url = url; }

    @Override
    public String getDescription() { return "remote stream: " + url; }

    @Override
    public List<String> getChunks() {
        return List.of("Header data", "Stream block 1", "Stream block 2", "End of stream");
    }
}
