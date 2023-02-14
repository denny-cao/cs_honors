/* Magic squares. An n x n matrix that is filled with the numbers
 * 1,2,3,...,n^2 is a magic square if the sum of the elements in 
 * each row, in each column, and in the two diagonals is the same
 * value. Write a program that reads in 16 values from the keyboard
 * and tests whether they form a magic square when put into a 4x4
 * array. You need to test two features:
 * 1. Does each of the numbers 1,2,...,16 occur in the user input?
 * 2. When the numbers are put into a square, are the sums of the rows,
 * columns, and diagonals equal to each other?
 */

import java.util.*;

public class MagicSquare {
    private final int SIZE = 4;
    private final int MAX = SIZE * SIZE;
    private final int MIN = 1;
    private final int MAGIC_SUM = SIZE * (MAX + MIN) / 2;

    private int[][] square = new int[SIZE][SIZE];

    public MagicSquare() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter " + MAX + " numbers between " + MIN + " and " + MAX + ":");

        // Create a set that inputs are added to
        Set<Integer> set = new HashSet<Integer>();

        // Populate the square
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                while (true) {
                    int input = scan.nextInt();
                    if (input >= MIN && input <= MAX && !set.contains(input)) {
                        square[i][j] = input;
                        set.add(input);
                        break;
                    }
                    else {
                        System.out.println("Invalid input. Try again.");
                    }
                }
            }
        }

        // Print array
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%d ", square[i][j]);
            }
            System.out.println();
        }

        scan.close();
    }

    public boolean isMagic() {
        /* Test if the sums of the rows, columns, and diagonals are equal */
        int diagonalSum = 0;
        int antiDiagonalSum = 0;

        for (int i = 0; i < this.SIZE; i++) {
            diagonalSum += square[i][i];
            antiDiagonalSum += square[i][this.SIZE - i - 1];

            int rowSum = 0;
            int colSum = 0;
            
            for (int j = 0; j < this.SIZE; j++) {
                rowSum += square[i][j];
                colSum += square[j][i];
            }

            if (rowSum != this.MAGIC_SUM || colSum != this.MAGIC_SUM) {
                return false;
            }
        }

        if (diagonalSum != this.MAGIC_SUM || antiDiagonalSum != this.MAGIC_SUM) {
            return false;
        }

        return true;
    }
}