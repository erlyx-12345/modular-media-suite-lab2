package modularmedia;
import java.util.*;

public class ProxyMediaSource implements MediaSource {
    private MediaSource realSource;
    private List<String> cachedChunks = null;

    public ProxyMediaSource(MediaSource realSource) {
        this.realSource = realSource;
    }

    @Override
    public String getDescription() {
        return "proxy(" + realSource.getDescription() + ")";
    }

    @Override
    public List<String> getChunks() {
        if (cachedChunks == null) {
            System.out.println("[CACHE] Cache miss - Fetching from real source...");
            cachedChunks = new ArrayList<>(realSource.getChunks());
        } else {
            System.out.println("[CACHE] Cache hit - Using cached stream chunks");
        }
        return cachedChunks;
    }
}
