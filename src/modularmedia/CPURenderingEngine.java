package modularmedia;

// Bridge Pattern - Concrete implementation
public class CPURenderingEngine implements RenderingEngine {
    private final int cores;
    private final String architecture;
    
    public CPURenderingEngine(int cores, String architecture) {
        this.cores = cores;
        this.architecture = architecture;
    }
    
    @Override
    public void processFrame(String title) {
        System.out.println("[CPU-ENGINE] Processing frame via " + cores + "-core " + architecture + ": " + title);
    }
    
    @Override
    public String getEngineType() {
        return "CPU (" + cores + " cores, " + architecture + ")";
    }
    
    @Override
    public int getPerformanceLevel() {
        return cores * 100; // Performance score based on cores
    }
    
    @Override
    public boolean supportsHardwareAcceleration() {
        return false;
    }
}
