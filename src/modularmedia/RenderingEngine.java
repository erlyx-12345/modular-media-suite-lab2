package modularmedia;

// Bridge Pattern - Implementation interface
public interface RenderingEngine {
    void processFrame(String title);
    String getEngineType();
    int getPerformanceLevel();
    boolean supportsHardwareAcceleration();
}
