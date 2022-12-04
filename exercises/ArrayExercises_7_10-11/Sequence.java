import java.util.*;

public class Sequence {
    private int[] values;
    
    public Sequence(int size) {values = new int[size];}

    public void set(int i, int n) {values[i] = n;}

    public int getLength() {return values.length;}

    public boolean equals(Sequence other) {
        /* Check two sequences have same values in same order */

        if (this.values.length == other.values.length) {
            for (int i = 0; i < this.values.length; i++) {
                if (this.values[i] != other.values[i]) {return false;}
            }
            return true;
        }
        return false;
    }

    public String toString() {
        /* Convert sequence to string */

        return Arrays.toString(this.values);
    }

    public boolean sameValues(Sequence order) {
        /* Check if values are equal, disregarding order and ignoring duplicates */

        // Create sets for both sequences
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();

        // Iterate through sequences of different lengths and add values to sets
        for (int i = 0; i < this.values.length; i++) {set1.add(this.values[i]);}
        for (int i = 0; i < order.values.length; i++) {set2.add(order.values[i]);}

        // Check if sets are equal
        return set1.equals(set2);
    }
}