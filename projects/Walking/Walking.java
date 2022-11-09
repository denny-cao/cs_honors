import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Arc2D;
import javax.swing.JComponent;
import java.util.List;
import java.util.ArrayList;

public class Walking extends JComponent {
    /*
     * This class will paint the current frame
     * - Create getter methods to get current joint positions
     * - Create setter methods to set joint positions
     * - Combine all setters into one method which runs
     *   draw afterwards.
     */
    
    // Legs
    private List<Line2D.Double> legs = new ArrayList<Line2D.Double>();
    
    // Torso
    private Rectangle.Double body = new Rectangle.Double();
    
    // Face: Head, Eyes, Mouth
    private Ellipse2D.Double face = new Ellipse2D.Double();

    private List<Ellipse2D.Double> eyes = new ArrayList<Ellipse2D.Double>();
  
    private Arc2D.Double mouth = new Arc2D.Double(); 

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
    }

    // Getter methods
    public List<Line2D.Double> getLegs() {
        return this.legs;
    }

    public Rectangle.Double getBody() {
        return this.body;
    }

    public Ellipse2D.Double getFace() {
        return this.face;
    }

    public List<Ellipse2D.Double> getEyes() {
        return this.eyes;
    }

    public Arc2D.Double getMouth() {
        return this.mouth;
    }
}

