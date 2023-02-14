import java.util.Random;

/* 
 * Write Java statements for performing the following tasks with an array declared as:
 * int[][] values = new int[ROWS][COLS];
 * - Fill all entries with 0
 * - Fill elements alternately with 0s and 1s in a checkerboard pattern
 * - Fill only the elements in the top and bottom rows with zeroes
 * - Compute the sum of all elements
 * - Print the array in tabular form
 */

 public class ReviewTwoDimArrays {
    private static Random rand = new Random();
    private static final int ROWS = rand.nextInt(8) + 2;
    private static final int COLS = rand.nextInt(8) + 2;
    
    public static void zeroArray(int[][] array) {
        /* Fill all entries with 0 */
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = 0;
            }
        }
    }

    public static void checkerboard(int[][] array) {
        /* Fill elements alternately with 0s and 1s in a checkerboard pattern */
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if ((row + col) % 2 == 0) {
                    array[row][col] = 0;
                } else {
                    array[row][col] = 1;
                }
            }
        }
    }

    public static void zeroTopBottom(int[][] array) {
        /* Fill only the elements in the top and bottom rows with zeroes */
        for (int column = 0; column < array[0].length; column++) {
            array[0][column] = 0;
            array[array.length - 1][column] = 0;
        }
    }

    public static int sumArray(int[][] array) {
        /* Compute the sum of all elements */
        int sum = 0;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                sum += array[row][col];
            }
        }
        return sum;
    }

    public static void printArray(int[][] array) {
        /* Print the array in tabular form */
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] values = new int[ROWS][COLS];
        System.out.println("Zero array: ");
        zeroArray(values);
        printArray(values);
        System.out.println("Checkerboard: ");
        checkerboard(values);
        printArray(values);
        System.out.println("Zero top and bottom: ");
        zeroTopBottom(values);
        printArray(values);
        System.out.println("Sum of all elements: " + sumArray(values));
    }
 }