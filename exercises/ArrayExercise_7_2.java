import java.lang.Math;

public class ArrayMethods {
    private int[] values;
    private final int lastIndex = values.length - 1;

    public ArrayMethods(int[] initialValues) {
        this.values = initialValues;
    }
    
    public void printArray(String exercise) {
        System.out.printf("%s: ", exercise);
        for (int num : values) {
            System.out.print(num);
        }
        System.out.println();
    }

    public void swapFirstLast() {
        int temp = this.values[0];

        this.values[0] = this.values[this.lastIndex];
        this.values[this.lastIndex] = temp;
    }

    public void shiftRight() {
        int temp = this.values[this.lastIndex]; // Last element

        for (int i = this.lastIndex; i > 0; i--) {
            this.values[i] = this.values[i-1];
        }

        this.values[0] = temp; // Place last element in first index
    }

    public void zeroEvenElements() {
        for (int i = 0; i < this.lastIndex; i++) {
            if (this.values[i] % 2 == 0) {
                this.values[i] = 0;
            }
        }
    }

    public void largestNeighbor() {
        for (int i = 1; i < this.lastIndex - 1; i++) {
            if (this.values[i - 1] >= this.values[i + 1]) {
                this.values[i] = this.values[i - 1];
            }
            else {
                this.values[i] = this.values[i + 1];
            }
        }
    }

    public void removeMiddle() {
        int skip = 0;

        if (this.values.length % 2 == 0) {
            int[] temp = new int[this.values.length - 2];
            
            for (int i = 0; i < this.lastIndex; i++) {
                if (i != (this.values.length / 2) || i != (this.values.length / 2 - 1)) {
                    temp[i + skip] = this.values[i];
                }
                else {
                    skip++;
                }
            }
        }

        else {
            int[] temp = new int[this.lastIndex];

            for (int i = 0; i < this.lastIndex; i++) {
                if (i != this.lastIndex / 2) {
                    temp[i + step] = this.values[i];
                }
                else {
                    step++;
                }
            }
        }
    }

    public 
}