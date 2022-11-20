/*
 * 




 */

/* Question 1: Toys Are Fun is looking to increase prices for many of its products. They would like a program that takes the current price and outputs a new price based on a percentage increase value. The program should also output the difference in the old price and new price. The user should enter the percentage as a decimal value. 
*/
import java.util.Scanner;

public class ToysAreFun {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Get current price
        System.out.print("Enter current price: ");
        float current = in.nextFloat();

        // Get percentage increase
        System.out.print("Enter percent increase: ");
        float percent = in.nextFloat();
        
        // Compute new value
        float updated = current * (1 + percent);
        float difference = updated - current;

        // Print new price and how much increased
        System.out.printf("New price: %.2f\n", updated);
        System.out.printf("Difference: %.2f\n", difference);
    }
}

/* 
 Question 1: Toys Are Fun is looking to increase prices for many of its products. They would like a program that takes the current price and outputs a new price based on a percentage increase value. The program should also output the difference in the old price and new price. The user should enter the percentage as a decimal value. 
 */

/*
 Question 2: Dellso Incorporated wants a program to help calculate the bonus amount for its employees. The bonus amount is determined by a percentage multiplied by the current annual salary. Format the outputs for 2 decimal places using printf formatting. 
 */
import java.util.Scanner;

public class Dellso {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Get current salary
        System.out.print("Enter current salary: ");
        float current = in.nextFloat();
        
        // Get percentage
        System.out.print("Enter percentage increase: ");
        float percent = in.nextFloat();

        // Get bonus and print
        float bonus = current * percent;
        System.out.prinf("Bonus Amount: %.2f\n", bonus);
    }
}

/*
 Question 3: Universal Heating and Cooling sells air conditioner units. They want a program to help keep track of inventory each month. The program should input the beginning inventory for the month, and adjust for both the amount that is sold and if there are any products returned.  The program should then display the ending inventory. 
 */

import java.util.Scanner;

public class UniversalHeatingAndCooling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Get beginning inventory
        System.out.print("Enter the amount of air conditioner units: ");
        int inventory = in.nextInt();

        // Get amount sold
        System.out.print("Enter the amount of units sold: ");
        int sold = in.nextInt();

        // Get amount returned
        System.out.print("Enter the amount of units returned: ");
        int returned = in.nextInt();

        // Get inventory at end of month and print
        int ending = inventory - sold + returned;
        System.out.printf("Amount of units left: %d", ending);
    }
}

/*
 Question 4: The Everyday Tile company installs tile into homes and charges by the square foot. They want a program that determines the total cost based on a square foot price. The program should use length and width of a room to determine the area and then multiply the area by the square foot price. The total area and total cost should be displayed. 
 */

import java.util.Scanner;

public class EverydayTile {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Get square foot price
        float sqftPrice = in.nextFloat();

        // Get dimensions
        System.out.print("Enter length (in ft): ");
        float length = in.nextFloat();
        System.out.print("Enter width (in ft): ");
        float width = in.nextFloat();
        float area = length * width;

        float total = area * sqftPrice;
        
        System.out.printf("Total Area: %f\n", area);
        System.out.printf("Total Cost: %f\n", total);
    }
}

/*
 Question 5: A music venue has 3 seating options. There is the balcony, the floor, and the orchestra seating categories. The venue would like a program that calculates and displays the total revenue for each seating category as well as the total revenue for all tickets sold for a given event. The cost for balcony is $15, floor tickets are $30, and orchestra tickets are $25.
 */

import java.util.Scanner;

public class MusicVenue {
    public static void main(String[] args) {
        // Costs for each seating option
        final int BALCONY = 15;
        final int FLOOR = 30;
        final int ORCHESTRA = 25;

        Scanner in = new Scanner(System.in);
        
        // Get number of tickets sold for each seating option
        System.out.print("Enter number of balcony tickets sold: ");
        int balcTickets = in.nextInt();

        System.out.print("Enter number of floor tickets sold: ");
        int floorTickets = in.nextInt();

        System.out.print("Enter number of orchestra tickets sold: ");
        int orchestraTickets = in.nextInt();

        // Compute revenues 
        int balcRevenue = balcTickets * BALCONY;
        int floorRevenue = floorTickets * FLOOR;
        int orchestraRevenue = orchestraTickets * ORCHESTRA;
        int total = balcRevenue + floorRevenue + orchestraRevenue;

        // Print revenue by seating category
        System.out.printf("Revenue for balcony seats: %d\n", balcRevenue);
        System.out.printf("Revenue for floor seats: %d\n", floorRevenue);
        System.out.printf("Revenue for orchestra seats: %d\n", orchestraRevenue);

        System.out.printf("Total revenue: %d", total);
    }
}
