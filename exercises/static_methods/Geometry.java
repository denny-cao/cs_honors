import java.util.Scanner;   

/*
 * Write static methods:
 * cubeVolume(double h)
 * cubeSurface(double h)
 * sphereVolume(double r)
 * sphereSurface(double r)
 * cylinderVolume(double r, double h)
 * cylinderSurface(double r, double h)
 * coneVolume(double r, double h)
 * coneSurface(double r, double h)
 */

public class Geometry {
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
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Input validation. Double only. Prompt for r and h.

        System.out.print("Enter a number for radius: ");

        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input. Enter a number: ");
            scan.next();
        }

        double r = scan.nextDouble();

        System.out.print("Enter a number for height: ");

        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input. Enter a number: ");
            scan.next();
        }

        double h = scan.nextDouble();

        // Print results

        System.out.println("Cube volume: " + cubeVolume(h));
        System.out.println("Cube surface: " + cubeSurface(h));
        System.out.println("Sphere volume: " + sphereVolume(r));
        System.out.println("Sphere surface: " + sphereSurface(r));
        System.out.println("Cylinder volume: " + cylinderVolume(r, h));
        System.out.println("Cylinder surface: " + cylinderSurface(r, h));
        System.out.println("Cone volume: " + coneVolume(r, h));
        System.out.println("Cone surface: " + coneSurface(r, h));
    }
}