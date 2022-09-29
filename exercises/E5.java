import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math;
import java.util.Set;

public class E5 {
    public static void main(String[] args) {
        ;
    }
    
    public static String sign(float num) {
        /*
         * Print sign of number.
         */

        if (num > 0) {
            return "positive";
        }
        else if (num < 0) {
            return "negative";
        } 
        else {
            return "zero";
        }
    }

    public static void e5_1() {
        /*
         * Write a program that reads an integer and prints whether
         * it is negative, zero, or positive.
        */

        Scanner scan = new Scanner(System.in);
        int check = null;
    
        try {
            System.out.print("Enter an integer: ");
            check = scan.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Input not an integer!");
            scan.close();
            return;
        }

        System.out.println(sign(check));
        scan.close();
    }

    public static void e5_2() {
        /*
         * Write a program that reads a floating-point number and prints
         * "zero" if the number is zero. Otherwise, print "positive" or 
         * "negative". Add "small" if the absolute value of the number
         * is less than 1, or "large" if it exceeds 1,000,000.
        */

        Scanner scan = new Scanner(System.in);
        float check = null;

        try {
            System.out.print("Enter a float: ");
            check = scan.nextFloat();
        } catch(InputMismatchException e) {
            System.out.println("Input not a float!");
            scan.close();
            return;
        }

        String extra = "";
        
        if (Math.abs(check) < 1) {
            extra = "small";
        }
        else if (Math.abs(check) > 1e6) {
            extra = "large";
        }

        System.out.printf("%s %s", sign(check), extra);
        scan.close();
    }

    public static void e5_3() {
        /*
         * Write a program that reads an integer and prints how many digits the
         * number has, by checking whether the number is >= 10, >= 100, and so on.
         * (Assume that all integers are less than ten billion.) If the number is
         * negative, first multiply it with -1.
        */

        Scanner scan = new Scanner(System.in);
        int check = 0;
        int digits = 0;
        
        try {
            System.out.print("Enter an integer: ");
            check = Math.abs(scan.nextInt());
        } catch(InputMismatchException e) {
            System.out.println("Input not an integer!");
            scan.close();
            return;
        }

        while (check != 0) {
            check /= 10;
            digits++;
        }

        System.out.println(digits);
        scan.close();
    }

    public static void e5_4(int inputCount) {
        /* 
         * Write a program that reads three numbers and prints "all the same" if
         * they are all the same, "all different" if they are all different, and
         * "neither" otherwise.
        */

        Scanner scan = new Scanner(System.in);
        int check;

        Set<Integer> numSet = new HashSet<Integer>();
        
        for (int i = 0 ; i < inputCount - 1; i++) {
            try {
                System.out.print("Enter an integer: ");
                check = Math.abs(scan.nextInt());
            } catch(InputMismatchException e) {
                System.out.println("Input not an integer!");
                scan.close();
                return;
            }

            if (!numSet.contains(check)) {
                numSet.add(check);
            }
        }

        /* 
         * Cardinality of set will inform if all same or all different;
         * Cardinality of 1: All same
         * Cardinality of inputCount: All distinct
         * Else: Neither
         * Switch probably better here since there are only 3 cases, but
         * use conditionals for larger input size
        */ 

        int cardinality = numSet.size();
        
        if (cardinality == 1) {
            System.out.println("all the same");
        }
        else if (cardinality == inputCount) {
            System.out.println("all different");
        }
        else {
            System.out.println("neither");
        }

        scan.close();
    }

    public static void e5_5(int inputCount) {
        /* 
         * Write a program that reads three numbers and prints "increasing"
         * if they are in increasing order, "decreasing" if they are in 
         * decreasing order, and "neither" otherwise. Here, "increasing"
         * means "strictly increasing", with each value larger than its
         * predecessor. The sequence 3 4 4 would not be considered increasing.
         */

        Scanner scan = new Scanner(System.in);
        int previous;
        int current;
        boolean increasing;

        Set<Integer> numSet = new HashSet<Integer>();
        
        for (int i = 0; i < inputCount - 1; i++) {
            try {
                System.out.print("Enter an integer: ");
                current = Math.abs(scan.nextInt());
            } catch(InputMismatchException e) {
                System.out.println("Input not an integer!");
                scan.close();
                return;
            }

            previous = current;
        }
    }
}
