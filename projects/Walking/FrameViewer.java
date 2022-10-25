import java.swing.JFrame;

public class FrameViewer {
    private int width;
    private int height;
    private String title;
    private JFrame frame = new JFrame();
    public FrameViewer(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;

        this.updateTitle();
        this.updateSize();

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public void updateTitle() {
        frame.setTitle(this.title);
    }

    public void updateSize() {
        frame.setSize(width, height);
    }
}