import java.util.Scanner;
import java.util.InputMismatchException;
public class E5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int check = null;
    
        try {
            check = scan.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Enter an integer!");
            return;
        }

        if (check >= 0) {

        }
    }
}