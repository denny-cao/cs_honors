import java.util.*;

public class Sequence {
    private ArrayList<Integer> values;
    public Sequence() { values = new ArrayList<Integer>(); }
    public void add(int n) { values.add(n); }
    public String toString() { return values.toString(); } 

    /* Exercise 7.20: Add a method that creates a new sequence, appending 
     * this and the other sequence, without modifying either sequence. 
     */

    public Sequence append(Sequence other) {
        Sequence newSequence = new Sequence();

        newSequence.values.addAll(this.values);
        newSequence.values.addAll(other.values);

        return newSequence;
    }

    /* Exercise 7.21: Add a method that merges two sequences, alternating
     * elements from both sequences. If one sequence is shorter than the
     * other, then alternate as long as you can and then append the remaining
     * elements from the longer sequence.
     */

     public Sequence merge(Sequence other) {
            Sequence newSequence = new Sequence();

            // Create a pointer to the longer sequence
            boolean thisLonger = this.values.size() > other.values.size();
            Sequence pointerLonger = thisLonger ? this : other;
            Sequence pointerShorter = thisLonger ? other : this;

            for (int i = 0; i < this.values.size() && i < other.values.size(); i++) {
                newSequence.add(this.values.get(i));
                newSequence.add(other.values.get(i));
            }

            // If both sequences are the same size, this loop will not run
            for (int i = pointerShorter.values.size(); i < pointerLonger.values.size(); i++) {
                newSequence.add(pointerLonger.values.get(i));
            }

            return newSequence;
     }
    
     /* Exercise 7.22: Add a method that merges two sorted sequences, producing
      * a new sorted sequence. Keep an index into each sequence, indicating
      how much of it has been processed already. Each time, append the smallest
      unprocessed value from either sequence, then advance the index.
     */

     public Sequence mergeSorted(Sequence other) {
        Sequence newSequence = this.append(other);
        
        // Sort the new sequence
        Collections.sort(newSequence.values);

        return newSequence;
     }
}
