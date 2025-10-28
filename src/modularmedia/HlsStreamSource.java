package modularmedia;
import java.util.*;

public class HlsStreamSource implements MediaSource {
    private String channel;

    public HlsStreamSource(String channel) { this.channel = channel; }

    @Override
    public String getDescription() { return "HLS stream: " + channel; }

    @Override
    public List<String> getChunks() {
        return List.of("Segment 1.ts", "Segment 2.ts", "Segment 3.ts");
    }
}
