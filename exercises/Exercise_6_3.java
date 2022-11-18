/*
 * Write a program that reads a line of input as a string and print:
 *  a) Only the uppercase letters in the string
 *  b) Every second letter of the string
 *  c) The string, with all vowels replaced by an underscore
 *  d) The number of vowels in the string
 *  e) The positions of all vowels in the string
 */

import java.util.*;
import java.lang.*;

public class Exercise_6_3 {
  String input;
  char[] inputArr;

  public Exercise_6_3() {
    Scanner scan = new Scanner(System.in);
    this.input = scan.nextLine();
    this.inputArr = new char[this.input.length()];

    for (int i = 0; i < this.input.length(); i++) {
      this.inputArr[i] = this.input.charAt(i);
    }

    onlyUpper();
    everySecond();
    vowelUnderscore();
    vowelCount();
    vowelPos();

    scan.close();
  }

  public void onlyUpper() {
    for (char letter : this.inputArr) {
      if (isUpper(letter)) {
        System.out.print(letter);
      }
    }
    System.out.println();
  }

  public void everySecond() {
    for (int i = 0; i < this.input.length(); i += 2) {
      System.out.print(inputArr[i]);
    }
    System.out.println();
  }

  public void vowelUnderscore() {
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
    int vowels = 0;
    for (char letter : this.inputArr) {
      if (isVowel(letter)) {
        vowels++;
      }
    }

    System.out.printf("Vowels: %d \n", vowels);
  }

  public void vowelPos() {
    for (int i = 0; i < this.input.length(); i++) {
      if (isVowel(this.input.charAt(i))) {
        System.out.printf("Position: %d \n", i);
      }
    }
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

  public static void main(String[] args) {
    new Exercise_6_3();
  }
}