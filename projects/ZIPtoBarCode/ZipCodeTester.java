/* For faster sorting of letters, the United States Postal Service encourages companies
that send large volumes of mail to use a bar code denoting the ZIP code (see
Figure 8).
The encoding scheme for a five-digit ZIP
code is shown in Figure 8. There are
full-height frame bars on each side. The five
encoded digits are followed by a check digit,
which is computed as follows: Add up all
digits, and choose the check digit to make the
sum a multiple of 10. For example, the sum of
the digits in the ZIP code 95014 is 19, so the
check digit is 1 to make the sum equal to 20.
Each digit of the ZIP code, and the check
digit, is encoded according to the table at
right, where 0 denotes a half bar and 1 a full

bar. Note that they represent all combina-
tions of two full and three half bars. The digit

can be computed easily from the bar code
using the column weights 7, 4, 2, 1, 0. For
example, 01100 is
0 × 7 + 1 × 4 + 1 × 2 + 0 × 1 + 0 × 0 = 6
The only exception is 0, which would yield
11 according to the weight formula.
Write a program that asks the user for a ZIP code and prints the bar code. Use : for
half bars, | for full bars. For example, 95014 becomes
||:|:::|:|:||::::::||:|::|:::|||
(Alternatively, write a graphical application that draws real bars.)
Your program should also be able to carry out the opposite conversion: Translate
bars into their ZIP code, reporting any errors in the input format or a mismatch of
the digits. */


import java.util.Scanner;

public class ZipCodeTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a zip code: ");
        String zip = in.nextLine();
        System.out.println("Bar code: " + new Zip(zip).toBarCode().getBarCode());

        System.out.print("Enter a bar code: ");
        String barCode = in.nextLine();
        System.out.println("Zip code: " + new BarCode(barCode).toZip().getZip());

        in.close();
    }
}