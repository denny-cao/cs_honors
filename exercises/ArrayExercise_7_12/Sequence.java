import java.util.*;

public class Sequence {
    private int[] values;
    
    public Sequence(int size) {values = new int[size];}

    public void set(int i, int n) {values[i] = n;}

    public int getLength() {return values.length;}
    
    public String toString() {
        /* Convert sequence to string */

        return Arrays.toString(this.values);
    }

    public boolean isPermutation(Sequence other) {
        /* Check if sequence is a permutation */

        // Check if both sequences are the same length
        if (this.getLength() != other.getLength()) {
            return false;
        }

        // Create an array with size MAXELEMENT + 1 to store the number of times each element appears
        int[] count = new int[SequenceTester.MAXELEMENT + 1];

        // Loop through first sequence and increment the count of each element
        for (int i = 0; i < this.getLength(); i++) {
            count[this.values[i]]++;
        }

        // Loop through second sequence and decrement the count of each element
        for (int i = 0; i < other.getLength(); i++) {
            count[other.values[i]]--;
        }

        // Check if all elements have a count of 0
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

}