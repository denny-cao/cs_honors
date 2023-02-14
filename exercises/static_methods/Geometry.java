import java.util.Scanner;   
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;

public class Geometry {
    // Exercise 8.5
    
    public static double cubeVolume(double h) {
        return h * h * h;
    }

    public static double cubeSurface(double h) {
        return 6 * h * h;
    }

    public static double sphereVolume(double r) {
        return (4.0 / 3.0) * Math.PI * r * r * r;
    }

    public static double sphereSurface(double r) {
        return 4 * Math.PI * r * r;
    }

    public static double cylinderVolume(double r, double h) {
        return Math.PI * r * r * h;
    }

    public static double cylinderSurface(double r, double h) {
        return 2 * Math.PI * r * (r + h);
    }

    public static double coneVolume(double r, double h) {
        return (1.0 / 3.0) * Math.PI * r * r * h;
    }

    public static double coneSurface(double r, double h) {
        return Math.PI * r * (r + Math.sqrt(h * h + r * r));
    }

    // Exercise 8.9

    public static double perimeter(Ellipse2D.Double e) {
        double a = e.width;
        double b = e.height;

        double h = Math.pow((a - b) / (a + b), 2);
        
        // Ramanujan's approximation for the perimeter of an ellipse
        
        return Math.PI * (a + b) * (1 + 3 * h / (10 + Math.sqrt(4 - 3 * h)));

    }

    public static double area(Ellipse2D.Double e) {
        return Math.PI * e.width * e.height;
    }

    // Exercise 8.10

    public static double angle(Point2D.Double p, Point2D.Double q) {
        // Angle between the x-axis and the line joining two points, measured in degrees

        double angle = Math.toDegrees(Math.atan2(Math.abs(q.y - p.y), Math.abs(q.x - p.x)));

        return angle;
    }

    public static double slope(Point2D.Double p, Point2D.Double q) {
        // Slope of the line joining two points

        return (q.y - p.y) / (q.x - p.x);
    }

}