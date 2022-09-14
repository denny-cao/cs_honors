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
        /* Compute area using Heron's formula
         * https://www.mathsisfun.com/geometry/herons-formula.html
         */

        double semiPerm = this.perimeter() / 2;

        return Math.sqrt(semiPerm * (semiPerm - this.side1) * (semiPerm - this.side2) * (semiPerm - this.side3));
    }

    public static void main(String args[]) {
        double side1 = Double.parseDouble(args[0]);
        double side2 = Double.parseDouble(args[1]);
        double side3 = Double.parseDouble(args[2]);

        Triangle tri = new Triangle(side1, side2, side3);
        System.out.println(tri.area());
    }
}
