import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Dimension;

public class GrowSquarePrinter {
    private Rectangle shape;
    
    public GrowSquarePrinter(Dimension dims, Point pos) {
        this.shape = new Rectangle(pos, dims);
    }

    public void printLocation() {
        System.out.println(this.shape);
    }

    public void translate(int x, int y) {
        this.shape.translate(x, y);
    }

    public void growSameCorner(int h, int v) {
        /*
        https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html
        Grow method:
            - args: int h, int v
            - change: Upper-left corner: (x-h, y-v)
                      Width += 2h
                      Height += 2v
        */

        this.shape.grow(h, v);

        this.shape.translate(h, v);     // Maintain Same Upper-Left Corner
    }
    
    public static void main(String[] args) { 
        /*
        Write a GrowSquarePrinter program that constructs a Rectangle object square
        representing a square with top-left corner (100, 100) and side
        length 50, prints its location by calling System.out.println(square),
        applies the translate and grow methods, and calls System.out.
        println(square) again. The calls to translate and grow should
        modify the square so that it has twice the size and the same
        top-left corner as the original. If the squares were drawn, they
        would look like the figure at right.
        Your program will not produce a drawing. It will simply print the locations of square
        before and after calling the mutator methods.
        */

        Dimension dims = new Dimension(50, 50);
        Point pos = new Point(100, 100);
        GrowSquarePrinter rect = new GrowSquarePrinter(dims, pos);

        rect.printLocation();

  
        rect.growSameCorner(dims.width / 2, dims.height / 2);       // Twice size, same upper-left corner

        rect.printLocation();
    }
}