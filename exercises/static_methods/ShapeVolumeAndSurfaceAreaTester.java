import java.util.Scanner;

public class ShapeVolumeAndSurfaceAreaTester {
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

        System.out.println("Cube volume: " + Geometry.cubeVolume(h));
        System.out.println("Cube surface: " + Geometry.cubeSurface(h));
        System.out.println("Sphere volume: " + Geometry.sphereVolume(r));
        System.out.println("Sphere surface: " + Geometry.sphereSurface(r));
        System.out.println("Cylinder volume: " + Geometry.cylinderVolume(r, h));
        System.out.println("Cylinder surface: " + Geometry.cylinderSurface(r, h));
        System.out.println("Cone volume: " + Geometry.coneVolume(r, h));
        System.out.println("Cone surface: " + Geometry.coneSurface(r, h));

        scan.close();
    }
}