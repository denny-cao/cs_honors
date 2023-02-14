import java.util.Random;

public class ArrayListExercisesTester {
    private static final int MAX_SEQUENCE_SIZE = 10;
    private static final int MAX_SEQUENCE_VALUE = 10;

    public static void randomPopulateSequence(Sequence seq) {
        Random rand = new Random();
        int size = rand.nextInt(MAX_SEQUENCE_SIZE - 1) + 1;
        for (int i = 0; i < size; i++) {
            seq.add(rand.nextInt(MAX_SEQUENCE_VALUE));
        }
    }
    
    public static void main(String[] args) {
        Sequence seq1 = new Sequence();
        Sequence seq2 = new Sequence();

        randomPopulateSequence(seq1);
        randomPopulateSequence(seq2);

        System.out.println("Sequence 1: " + seq1.toString());
        System.out.println("Sequence 2: " + seq2.toString());
        
        // Exercise 7.20
        System.out.println("7.20: Sequence 1 appended to Sequence 2: " + seq1.append(seq2).toString());

        // Exercise 7.21
        System.out.println("7.21: Sequence 1 alternating with Sequence 2: " + seq1.merge(seq2).toString());

        // Exercise 7.22
        System.out.println("7.22: Sequence 1 merged and sorted with Sequence 2: " + seq1.mergeSorted(seq2).toString());
    }
}