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

        // Check if same length
        if (this.getLength() != other.getLength()) {return false;}

        // Create HashMap to store occurrences of each element for one sequence
        HashMap<Integer, Integer> occurrences = new HashMap<Integer, Integer>();

        // Populate HashMap with occurrences
        for (int i = 0; i < this.getLength(); i++) {
            if (occurrences.containsKey(this.values[i])) {occurrences.put(this.values[i], occurrences.get(this.values[i]) + 1);} 
            else {occurrences.put(this.values[i], 1);}
        }

        // Check if other sequence has the same occurrences
        for (int i = 0; i < other.getLength(); i++) {
            if (occurrences.containsKey(other.values[i])) {
                if (occurrences.get(other.values[i]) == 0) {return false;} 
                else {occurrences.put(other.values[i], occurrences.get(other.values[i]) - 1);}
            } 
            else {return false;}
        }

        return true;
    }
}