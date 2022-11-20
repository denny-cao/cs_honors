import java.util.*;

public class ArrayMethods {
    private int[] values;
    private int[] copy;
    private int lastIndex;

    public ArrayMethods(int[] initialValues) {
        this.values = initialValues;
        this.copy =  Arrays.copyOf(initialValues, initialValues.length);
        this.lastIndex = initialValues.length - 1;
    }
    
    public void printArray(String exercise) {
        /* Print the current values array. Takes exercise descriptor as input. */

        System.out.println(exercise + ": " + Arrays.toString(this.values));
    }

    public void resetArray() {
        /* Reset array to original. */

        this.values = Arrays.copyOf(this.copy, this.copy.length);
    }

    public void swapFirstLast() {
        /* Exercise a. Swap first and last elements in the array. */

        this.values[0] = this.values[this.lastIndex];
        this.values[this.lastIndex] = this.copy[0];

        this.printArray("Swap first and last elements");
        this.resetArray();
    }

    public void shiftRight() {
        /* Exercise b. Shift all elements by one to the right and move the last element into the first position. */

        for (int i = this.lastIndex; i > 0; i--) {this.values[i] = this.values[i-1];}

        this.values[0] = this.copy[this.lastIndex]; // Place last element in first index

        this.printArray("Shift elements right");
        this.resetArray();
    }

    public void zeroEvenElements() {
        /* Exercise c. Replace all even elements with 0. */
        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] % 2 == 0) {this.values[i] = 0;}
        }

        this.printArray("Make all even elements 0");
        this.resetArray();
    }

    public void largestNeighbor() {
        /* Exercise d. Replace each element except the first and last by the larger of its two neighbors. */
        
        for (int i = 1; i < this.lastIndex; i++) {
            if (this.copy[i - 1] >= this.copy[i + 1]) {this.values[i] = this.copy[i - 1];}
            else {this.values[i] = this.copy[i + 1];}
        }

        this.printArray("Largest neighbor");
        this.resetArray();
    }

    public void removeMiddle() {
        /* Exercise e. Remove the middle element if the array is odd, or the middle two elements if the length is even. */
        
        int upperBoundFirst = (this.values.length - 1) / 2;
        int lowerBoundSecond = this.values.length / 2;
                            
        int newSize = 2 * upperBoundFirst;

        int[] temp = new int[newSize];

        // First half
        for (int i = 0; i < upperBoundFirst; i++) {
            temp[i] = this.values[i];
        }

        // Second half
        for (int i = lowerBoundSecond + 1; i < this.values.length; i++) {
            int currentIndex = this.values.length % 2 == 0 ? i - 2 : i - 1; // If even, subtract 2, else subtract 1
            temp[currentIndex] = this.values[i];
        }

        this.values = temp;

        this.printArray("Remove middle element(s)");
        this.resetArray();
    }

    public void bubbleEven() {
        /* Exercise f. Move all even elements to the front, otherwise preserving the order of the elements. */
        
        int tempIndex = 0;

        // Move evens to front
        for (int i = 0; i < this.values.length; i++) {
            if (this.copy[i] % 2 == 0) {this.values[tempIndex++] = this.copy[i];}
        }

        // Move odds behind evens
        for (int i = 0; i < this.values.length; i++) {
            if (this.copy[i] % 2 != 0) {this.values[tempIndex++] = this.copy[i];} 
        }

        this.printArray("move even elements to front");
        this.resetArray();
    }

    public int secondLargest() {
        /* Exercise g. Return the second-largest element in the array. */
        
        int max = Integer.MIN_VALUE; 
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] > max) {
                secondMax = max;
                max = this.values[i];
            }
            else if (this.values[i] <= max && this.values[i] > secondMax) {secondMax = this.values[i];}
        }

        return secondMax;
    }

    public boolean isSorted() {
        /* Exercise h. Return true if the array is currently sorted in increasing order. */
        
        for (int i = 1; i < this.values.length; i++) {
            if (this.values[i] < this.values[i - 1]) {return false;}
        }
        return true;
    }

    public boolean containsAdjacentDuplicates() {
        /* Exercise i. Return true if the array contains two adjacent duplicate elements. */
        
        for (int i = 1; i < this.values.length; i++) {
            if (this.values[i] == this.values[i - 1]) {return true;}
        }
        return false;
    }

    public boolean containsDuplicates() {
        /* Exercise j. Return true if the array contains duplicate elements. */
        
        Set<Integer> temp = new HashSet<Integer>();

        for (int num : this.values) {
            if (temp.contains(num)) {return true;}
            temp.add(num);
        }
        return false;
    }
}