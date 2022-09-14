import java.util.Scanner;

public class Exercise_2_2 {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    String day = scan.nextLine();
    String date = scan.nextLine();
    String month = scan.nextLine();
    String year = scan.nextLine();

    printAmerican(day, date, month, year);
    printEuropean(day, date, month, year);

    scan.close();
  }

  public static void printAmerican(String day, String date, String month, String year) {
    System.out.printf("%s, %s, %s, %s \n", day, month, date, year);
  }

  public static void printEuropean(String day, String date, String month, String year) {
    System.out.printf("%s, %s, %s, %s \n", day, date, month, year); 
  }
}