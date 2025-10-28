package modularmedia;
public class SubtitlePlugin implements Plugin {
    public void apply(String title) {
        System.out.println("[SUBTITLES] Subtitles enabled for: " + title);
    }
    public String getName() { return "Subtitle Plugin"; }
}
