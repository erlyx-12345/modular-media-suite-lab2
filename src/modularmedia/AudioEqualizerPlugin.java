package modularmedia;
public class AudioEqualizerPlugin implements Plugin {
    public void apply(String title) {
        System.out.println("[EQUALIZER] Audio Equalizer applied for: " + title);
    }
    public String getName() { return "Audio Equalizer Plugin"; }
}
