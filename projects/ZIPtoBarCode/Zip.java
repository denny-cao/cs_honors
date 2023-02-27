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
import java.util.Map;

public class Zip {
    private String zip; // Use String to avoid leading 0s

    // Reverse the inside map. Make the key the value and the value the key
    public static final Map<Integer, Map<Integer, Integer>> DIGITWEIGHTS = Map.of(
        1, Map.of(7, 0,
                  4, 0,
                  2, 0,
                  1, 1,
                  0, 1),
        2, Map.of(7, 0,
                  4, 0,
                  2, 1,
                  1, 0,
                  0, 1),
        3, Map.of(7, 0,
                  4, 0,
                  2, 1,
                  1, 1,
                  0, 1),
        4, Map.of(7, 0,
                  4, 1,
                  2, 0,
                  1, 0,
                  0, 0),
        5, Map.of(7, 0,
                  4, 1,
                  2, 0,
                  1, 1,
                  0, 1),
        6, Map.of(7, 0,
                  4, 1,
                  2, 1,
                  1, 0,
                  0, 0),
        7, Map.of(7, 1,
                  4, 0,
                  2, 0,
                  1, 0,
                  0, 0),
        8, Map.of(7, 1,
                  4, 0,
                  2, 0,
                  1, 1,
                  0, 1),
        9, Map.of(7, 1,
                  4, 0,
                  2, 1,
                  1, 0,
                  0, 0),
        0, Map.of(7, 1,
                  4, 1,
                  2, 0,
                  1, 0,
                  0, 0)
    );

    public Zip(String zip) {
        if (!isValidZip(zip)) {
            throw new IllegalArgumentException("Invalid zip code");
        }
        this.zip = zip;
    }

    public BarCode toBarCode() {
        /* Convert zip code to bar code using DIGITWEIGHTS */
        StringBuilder barCode = new StringBuilder();
        barCode.append("|"); // Left frame bar

        for (char c : zip.toCharArray()) {
            int digit = Character.getNumericValue(c);
            Map<Integer, Integer> weights = DIGITWEIGHTS.get(digit);
            for (int i = 7; i >= 0; i--) {
                if (weights.get(i) == 0) {
                    barCode.append(":");
                } else {
                    barCode.append("|");
                }
            }
        }

        // Add check digit
        int checkDigit = checkDigit();
        Map<Integer, Integer> weights = DIGITWEIGHTS.get(checkDigit);
        for (int i = 7; i >= 0; i--) {
            if (weights.get(i) == 0) {
                barCode.append(":");
            } else {
                barCode.append("|");
            }
        }

        barCode.append("|"); // Right frame bar

        return new BarCode(barCode.toString());
    }

    public static boolean isValidZip(String zip) {
        // Check if 5 digits
        if (zip.length() != 5) {
            return false;
        }
        
        // Check if all digits
        for (char c : zip.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public int checkDigit() {
        /* Add up all digits and choose check digit to make sum a multiple of 10 */

        int sum = 0;
        
        for (char c : zip.toCharArray()) {
            sum += Character.getNumericValue(c);
        }

        return 10 - (sum % 10);
    }
}

