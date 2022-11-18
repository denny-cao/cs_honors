import java.util.*;
import java.lang.*;

public class Exercises_6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Enter some text: ");
            String input = scan.nextLine();
            new Exercise_6_3(input);
            new Exercise_6_8(input);
            new Exercise_6_9(input);
            new Exercise_6_10(input);
            new Exercise_6_11(input);
        }
    }
}

class Exercise_6_3 {
    /*
     * Write a program that reads a line of input as a string and print:
     *  a) Only the uppercase letters in the string
     *  b) Every second letter of the string
     *  c) The string, with all vowels replaced by an underscore
     *  d) The number of vowels in the string
     *  e) The positions of all vowels in the string
     */

    private String input;
    private char[] inputArr;
    
    public Exercise_6_3(String input) {
        this.input = input;
        this.inputArr = new char[this.input.length()];
    
        for (int i = 0; i < this.input.length(); i++) {
        this.inputArr[i] = this.input.charAt(i);
        }
    
        this.onlyUpper();
        this.everySecond();
        this.vowelUnderscore();
        this.vowelCount();
        this.vowelPos();
    }
    
    public void onlyUpper() {
        System.out.print("6.3 a) Print only uppercase chars: ");
        for (char letter : this.inputArr) {
            if (isUpper(letter)) {
                System.out.print(letter);
            }
        }
        System.out.println();
    }
    
    public void everySecond() {
        System.out.print("6.3 b) Print every second char: ");
        for (int i = 1; i < this.input.length(); i += 2) {
        System.out.print(inputArr[i]);
        }
        System.out.println();
    }
    
    public void vowelUnderscore() {
        System.out.print("6.3 c) If vowel, underscore: ");
        for (char letter : this.inputArr) {
        if (isVowel(letter)) {
            System.out.print("_");
        } else {
            System.out.print(letter);
        }
        }
        System.out.println();
    }
    
    public void vowelCount() {
        System.out.print("6.3 d) Print vowel count: ");
        int vowels = 0;
        for (char letter : this.inputArr) {
        if (isVowel(letter)) {
            vowels++;
        }
        }
    
        System.out.printf("Vowels: %d \n", vowels);
    }
    
    public void vowelPos() {
        System.out.print("6.3 e) Print positions of vowels: ");
        for (int i = 0; i < this.input.length(); i++) {
        if (isVowel(this.input.charAt(i))) {
            System.out.printf("Position: %d, ", i);
        }
        }
        System.out.println();
    }
    
    public static boolean isUpper(char check) {
        if (check >= 65 && check <= 90) {
        return true;
        }
        return false;
    }
    
    public static boolean isVowel(char check) {
        char checkLower = (char) Character.toLowerCase(check);
    
        if (checkLower == 'a' || checkLower == 'e' || checkLower == 'i' || checkLower == 'o' || checkLower == 'u') {
        return true;
        }
    
        return false;
    }
}

class Exercise_6_8 {
    /* Write a program that reads a word and prints each character of the word on a sepa-
     * rate line. For example, if the user provides the input "Harry", the program prints 
     * h
     * a
     * r
     * r
     * y  */

    String input;

    public Exercise_6_8(String input) {
        this.input = input;
        
        this.split();
    }

    public void split() {
        System.out.println("6.8 Print each char: ");
        for (int i = 0; i < this.input.length(); i++) {
            System.out.println(this.input.charAt(i));
        }
    }
}

class Exercise_6_9 {
    /* Write a program that reads a word and prints the word in reverse. For example, if the
     * user provides the input "Harry", the program prints 
     * yrraH */
    private String input;

    public Exercise_6_9(String input) {
        this.input = input;

        this.reverse();
    }

    public void reverse() {
        System.out.print("6.9 Print backwards: ");
        for (int i = this.input.length() - 1; i >= 0; i--) {
            System.out.print(this.input.charAt(i));
        }
        System.out.println();
    } 
}

class Exercise_6_10 {
    /* Write a program that reads a word and prints the number of vowels in the word. For
     * this exercise, assume that a e i o u y are vowels. For example, if the user provides the
     * input "Harry", the program prints 2 vowels. */

     private String input;

     public Exercise_6_10(String input) {
        this.input = input;

        this.vowels();
     }

     public void vowels() {
        System.out.print("6.10 Print Vowels: ");
        for (int i = 0; i < this.input.length(); i++) {
            if (isVowel(this.input.charAt(i))) {
                System.out.print(this.input.charAt(i));
            }
        }
        System.out.println();
     }

     public static boolean isVowel(char check) {
        char checkLower = (char) Character.toLowerCase(check);
    
        if (checkLower == 'a' || checkLower == 'e' || checkLower == 'i' || checkLower == 'o' || checkLower == 'u' || checkLower == 'y') {
        return true;
        }
    
        return false;
    }
}

class Exercise_6_11 {
    /* Write a program that reads a word and prints all substrings, sorted by length. For
     * example, if the user provides the input "rum", the program prints
     * r
     * u
     * m
     * ru
     * um
     * rum */

    private String input;

    public Exercise_6_11(String input) {
        this.input = input;

        this.subStrings();
    }

    public void subStrings() {
        System.out.println("6.11 Print Substrings: ");
        for (int i = 0; i < this.input.length(); i++) {
            for (int j = 0; j < this.input.length() - i; j++) {
                System.out.println(this.input.substring(j, j+i+1));
            }
        }
    }
}
