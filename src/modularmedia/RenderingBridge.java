package modularmedia;

// Bridge Pattern - Abstraction that uses the implementation
public class RenderingBridge implements MediaRenderer {
    private final RenderingEngine engine;
    private final RenderingCapabilities capabilities;
    
    public RenderingBridge(RenderingEngine engine) {
        this.engine = engine;
        this.capabilities = new RenderingCapabilities(engine);
    }
    
    @Override
    public void render(String title) {
        // Structural composition: Bridge uses engine + capabilities
        System.out.println("[RENDERER] " + capabilities.getRenderingInfo() + " - " + title);
        engine.processFrame(title);
        
        // Additional structural features
        if (capabilities.supportsAdvancedFeatures()) {
            System.out.println("[RENDERER] Advanced features enabled: " + capabilities.getFeatureList());
        }
    }
    
    public RenderingCapabilities getCapabilities() {
        return capabilities;
    }
    
    public String getEngineDetails() {
        return engine.getEngineType() + " (Performance: " + engine.getPerformanceLevel() + ")";
    }
}
