import java.util.Random;

public class ArrayExercise_7_10 {
    final static int MAXSIZE = 3;
    final static int MAXELEMENT = 5;
    
    public static void populateSequence(Sequence seq) {
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
        seq.print();
        seq2.print();

        // Print if both sequences are equal
        System.out.printf("Sequences are equal: %b", seq.equals(seq2));
    }
}