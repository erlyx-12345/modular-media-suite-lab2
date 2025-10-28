package modularmedia;
import java.util.List;

public interface MediaSource {
    String getDescription();
    List<String> getChunks();
}
