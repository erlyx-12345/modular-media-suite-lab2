package modularmedia;
import java.util.*;

public class PluginChain {
    private List<Plugin> plugins = new ArrayList<>();

    public void addPlugin(Plugin p) {
        plugins.add(p);
        System.out.println("[PLUGIN] Plugin enabled: " + p.getName());
    }

    public void applyAll(String title) {
        for (Plugin p : plugins) p.apply(title);
    }
}
