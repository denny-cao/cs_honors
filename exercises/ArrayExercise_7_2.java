import java.util.Random;

public class ArrayExercise_7_2 {
    final static int MAXSIZE = 10;
    final static int MINSIZE = 2;
    final static int MAXELEMENT = 100;

    public static int[] populateArray() {
        /* Populate array with random integers. */

        Random rand = new Random();

        int arraySize = rand.nextInt(MAXSIZE - MINSIZE + 1) + MINSIZE; // Random array size between MINSIZE and MAXSIZE
        
        int[] nums = new int[arraySize]; 

        for (int i = 0; i < arraySize; i++) {nums[i] = rand.nextInt(MAXELEMENT + 1);} // Random numbers between 0 and MAXELEMENT

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = populateArray();

        ArrayMethods exercise = new ArrayMethods(nums); 

        exercise.printArray("Original"); 
        exercise.swapFirstLast();
        exercise.shiftRight();
        exercise.zeroEvenElements();
        exercise.largestNeighbor();
        exercise.removeMiddle();
        exercise.bubbleEven();
        System.out.printf("The second largest element is: %d\n", exercise.secondLargest());
        System.out.printf("Array is sorted: %b\n", exercise.isSorted());
        System.out.printf("Array contains adjacent duplicates: %b\n", exercise.containsAdjacentDuplicates());
        System.out.printf("Array contains duplicates: %b\n", exercise.containsDuplicates());
    }
}