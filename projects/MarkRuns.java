/* Assignment Specifications:
 * A run is a sequence of adjacent repeated values. Write a program that
 * generates a sequence of 20 random die tosses in an array and that prints the
 * die values, marking the runs by including them in parentheses, like this:
 * 1 2 (5 5) 3 1 2 4 3 (2 2 2 2) 3 6 (5 5) 6 3 1
 * 
 * Use the following pseudocode:
 * Set a boolean variable inRun to false
 * For each valid index i in the array
 *  If inRun
 *      Print ).
 *      inRun = false.
 *  If not inRun
 *      If values[i] is the same as the following value
 *          Print (.
 *         inRun = true.
 *  Print values[i].
 * If inRun, print ).
 */

 import java.util.Random;

 public class MarkRuns {
    public static final int TOSS = 20;

    public static int[] randomDieTosses(int tosses) {
        /* Generate array of length tosses and populate with dice rolls (1-6) */

        Random rand = new Random();
        int[] values = new int[tosses];
        for (int i = 0; i < tosses; i++) {
            values[i] = rand.nextInt(6) + 1;
        }
        return values;
    }

    public static void main(String[] args) {
        int[] values = randomDieTosses(TOSS);

        boolean inRun = false;

        for (int i = 0; i < TOSS; i++) {
            // Check if start of a run and print ( if so
            if (i < TOSS - 1 && values[i] == values[i + 1] && !inRun) {
                System.out.print("(");
                inRun = true;
            }
            
            System.out.print(values[i]);

            // Check if end of a run and print ) if so
            if (i < TOSS - 1 && values[i] != values[i + 1] && inRun) {
                System.out.print(")");
                inRun = false;
            }
            
            // Print space if not last value (Formatting purposes)
            if (i != TOSS - 1) {
                System.out.print(" ");
            }
        }

        // Check if last value is part of a run and print ) if so
        if (inRun) {
            System.out.print(")");
        }
        
        System.out.println();
    }
 }