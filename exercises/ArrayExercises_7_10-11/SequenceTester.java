import java.util.Random;

public class SequenceTester {
    final static int MAXSIZE = 3;
    final static int MAXELEMENT = 5;
    
    public static void populateSequence(Sequence seq) {
        // Populate sequence with random integers
        
        for (int i = 0; i < seq.getLength(); i++) {
            seq.set(i, new Random().nextInt(MAXELEMENT + 1));
        }
    }
    public static void main(String[] args) {
        // Create sequence with random size between 2 and 10
        Sequence seq = new Sequence(new Random().nextInt(MAXSIZE - 1) + 2);

        // Create another sequence with random size between 2 and 10
        Sequence seq2 = new Sequence(new Random().nextInt(MAXSIZE - 1) + 2);

        // Populate both sequences with random integers
        populateSequence(seq);
        populateSequence(seq2);

        // Print both sequences
        System.out.printf("First sequence: %s\n", seq.toString());
        System.out.printf("Second sequence: %s\n", seq2.toString());

        // Print if both sequences are equal
        System.out.printf("7.10: Sequences are equal: %b\n", seq.equals(seq2));
        
        // Print if both sequences have the same values
        System.out.printf("7.11: Sequences have the same values: %b\n", seq.sameValues(seq2));
    }
}