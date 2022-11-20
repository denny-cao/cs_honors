import java.util.Random;

public class ArrayExercise_7_1 {
    final static int MAX = 200;
    private int[] nums = new int[10];

    public ArrayExercise_7_1() {
        // Populate nums array with random integers
        Random rand = new Random();
        
        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = rand.nextInt(MAX + 1);
        }

        // Run methods
        printOriginal();
        evenIndex();
        evenElement();
        reverseElements();
        firstLast();
    }
    
    public void printOriginal() {
        // Print original array

        System.out.print("Original Array: ");
        for (int num : this.nums) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }

    public void evenIndex() {
        // Print even indices

        System.out.print("Every element at an even index: ");

        for (int i = 0; i < this.nums.length; i += 2) {
            System.out.printf("%d ", this.nums[i]);
        }

        System.out.println();
    }

    public void evenElement() {
        // Print even elements

        boolean hasEven = false;
        System.out.print("Every even element: ");

        for (int num : this.nums) {
            if (num % 2 == 0) {
                System.out.printf("%d ", num);
                hasEven = true;
            }
        }

        if (!hasEven) {
            System.out.print("There are no even elements!");
        }

        System.out.println();
    }

    public void reverseElements() {
        // Print elements in reverse order

        System.out.print("All elements in reverse order: ");

        for (int i = this.nums.length - 1; i >= 0; i--) {
            System.out.printf("%d ", this.nums[i]);
        }

        System.out.println();
    }

    public void firstLast() {
        // Print first and last element 

        System.out.print("First and last elements: ");
        System.out.printf("First: %d, Last: %d\n",this.nums[0], this.nums[this.nums.length - 1]);
    }

    public static void main(String[] args) {
        new ArrayExercise_7_1();
    }
}