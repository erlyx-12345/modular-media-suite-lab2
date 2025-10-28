package modularmedia;

// Structural pattern - Composition of rendering features
public class RenderingCapabilities {
    private final RenderingEngine engine;
    
    public RenderingCapabilities(RenderingEngine engine) {
        this.engine = engine;
    }
    
    public String getRenderingInfo() {
        return "Rendering via " + engine.getEngineType();
    }
    
    public boolean supportsAdvancedFeatures() {
        return engine.getPerformanceLevel() > 500;
    }
    
    public String getFeatureList() {
        StringBuilder features = new StringBuilder();
        features.append("High Performance");
        
        if (engine.supportsHardwareAcceleration()) {
            features.append(", Hardware Acceleration");
        }
        
        if (engine.getPerformanceLevel() > 1000) {
            features.append(", Ultra Quality");
        }
        
        return features.toString();
    }
    
    public int getPerformanceScore() {
        return engine.getPerformanceLevel();
    }
    
    public boolean isHardwareAccelerated() {
        return engine.supportsHardwareAcceleration();
    }
}
