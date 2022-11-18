import java.util.Random;

public class Array_Exercise_7_1 {
    final static int MAX = 200;
    public static int[] nums = new int[10];

    public static void printArray() {
        System.out.print("Original Array: ");
        for(int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }

    public static int[] populateArrayRandom() {
        // Populate nums array with random intgers

        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(MAX + 1);
        }
        return nums;

    }
    public static void evenIndex() {
        // Print even indices

        System.out.print("Every element at an even index: ");
        for (int i = 0; i < nums.length; i += 2) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }

    public static void evenElement() {
        // Print even elements

        System.out.print("Every even element: ");
        for (int num : nums) {
            if (num % 2 == 0) {
                System.out.printf("%d ", num);
            }
        }
        System.out.println();
    }

    public static void reverseElements() {
        // Print elements in reverse order

        System.out.print("All elements in reverse order: ");
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }

    public static void firstLast() {
        // Print first and last element 

        System.out.print("First and last elements: ");
        System.out.printf("First: %d, Last: %d\n",nums[0], nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        int[] nums = populateArrayRandom();
        
        printArray();
        evenIndex();
        evenElement();
        reverseElements();
        firstLast();
    }
}