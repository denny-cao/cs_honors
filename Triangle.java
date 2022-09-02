import java.util.Scanner;
import java.lang.Math;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double perimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public double area() {
        double semiPerm = perimeter() / 2;

        return Math.sqrt(semiPerm * (semiPerm - this.side1) * (semiPerm - this.side2) * (semiPerm - this.side3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter side 1: ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter side 2: ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter side 3: ");
        double side3 = scanner.nextDouble();

        scanner.close();

         Triangle tri = new Triangle(side1, side2, side3);

        System.out.println(tri.area());
    }
}
 