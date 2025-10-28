package modularmedia;
public interface MediaComponent {
    void play();
    default void display(int indent) {}
}
