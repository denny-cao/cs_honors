import java.util.Scanner;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;

public class GeometryTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Exercise 8.9:");
        // Input validation. Double only. Prompt for r and h.
        
        System.out.print("Enter a length for the major axis: ");

        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input. Enter a number: ");
            scan.next();
        }

        double width = scan.nextDouble();

        System.out.print("Enter a length for the minor axis: ");

        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input. Enter a number: ");
            scan.next();
        }

        double height = scan.nextDouble();

        // Create an ellipse object
        
        Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, width, height);

        // Print results

        System.out.println("Perimeter: " + Geometry.perimeter(ellipse));
        System.out.println("Area: " + Geometry.area(ellipse));
        
        System.out.println("Exercise 8.10:");

        // Input validation. Double only. Prompt x and y for 2 points.

        System.out.print("Enter a number for x1: ");

        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input. Enter a number: ");
            scan.next();
        }

        double x1 = scan.nextDouble();

        System.out.print("Enter a number for y1: ");

        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input. Enter a number: ");
            scan.next();
        }

        double y1 = scan.nextDouble();

        System.out.print("Enter a number for x2: ");

        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input. Enter a number: ");
            scan.next();
        }

        double x2 = scan.nextDouble();

        System.out.print("Enter a number for y2: ");

        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input. Enter a number: ");
            scan.next();
        }

        double y2 = scan.nextDouble();

        // Create a point object

        Point2D.Double point1 = new Point2D.Double(x1, y1);
        Point2D.Double point2 = new Point2D.Double(x2, y2);

        // Print results
        
        System.out.println("Angle with horizontal: " + Geometry.angle(point1, point2));
        System.out.println("Slope: " + Geometry.slope(point1, point2));

        scan.close();
    }
}
