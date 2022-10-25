import java.util.Scanner;
import java.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

public class Walking {
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

    public 
}

