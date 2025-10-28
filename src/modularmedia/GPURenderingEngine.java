package modularmedia;

// Bridge Pattern - Concrete implementation
public class GPURenderingEngine implements RenderingEngine {
    private final String gpuModel;
    private final int memoryGB;
    private final boolean supportsRayTracing;
    
    public GPURenderingEngine(String gpuModel, int memoryGB, boolean supportsRayTracing) {
        this.gpuModel = gpuModel;
        this.memoryGB = memoryGB;
        this.supportsRayTracing = supportsRayTracing;
    }
    
    @Override
    public void processFrame(String title) {
        System.out.println("[GPU-ENGINE] Processing frame via " + gpuModel + " (" + memoryGB + "GB): " + title);
    }
    
    @Override
    public String getEngineType() {
        return "GPU (" + gpuModel + ", " + memoryGB + "GB" + 
               (supportsRayTracing ? ", Ray Tracing" : "") + ")";
    }
    
    @Override
    public int getPerformanceLevel() {
        return memoryGB * 500 + (supportsRayTracing ? 1000 : 0); // Performance score
    }
    
    @Override
    public boolean supportsHardwareAcceleration() {
        return true;
    }
}
