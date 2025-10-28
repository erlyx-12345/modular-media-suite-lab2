package modularmedia;
public class WatermarkPlugin implements Plugin {
    public void apply(String title) {
        System.out.println("[WATERMARK] Watermark applied for: " + title);
    }
    public String getName() { return "Watermark Plugin"; }
}
