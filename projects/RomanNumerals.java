/*
 * Numbers are formed according to the following rules:
 *  - Only numbers up to 3,999 are represented
 *  - As in the decimal system, the thousands, hundreds, tens, and ones are expressed separately
 *  - https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.unrv.com%2Fculture%2Froman-numerals.php&psig=AOvVaw15y8KJ12G0NeHE_ArEzrd-&ust=1664640355899000&source=images&cd=vfe&ved=0CAwQjRxqFwoTCPCf4NryvPoCFQAAAAAdAAAAABAD
 */

import java.util.Scanner;
import java.util.LinkedHashMap;

public class RomanNumerals {
    final private LinkedHashMap<Integer, String>ROMANNUMS = new LinkedHashMap<Integer, String>()
    {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    private int number;
    private String roman = "";

    public static void main(String[] args) {
        RomanNumerals num = new RomanNumerals();
        num.displayRoman();
    }
    
    public RomanNumerals() {
        setNum();
        convertRoman();
    }

    public void setNum() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter an integer: ");

        if (scan.hasNextInt()) {
            int temp = scan.nextInt();
            if (temp >= 3999 || temp <= 0) {
                System.out.println("Integer must be between 0 and 3999!");
                setNum();
            }
            else {
                this.number = temp;
            }
        }
        
        else {
            System.out.println("Integer must be between 0 and 3999!");
            setNum();
        }

        scan.close();
    }

    public void convertRoman() {
        int temp = this.number;
        String roman = "";

        for (Integer i: this.ROMANNUMS.keySet()) {
            if (temp - i >= 0) {
                int repeats = (temp / i); 
                temp -= i * repeats;
                roman += this.ROMANNUMS.get(i).repeat(repeats);
            }
            if (temp == 0) {
                this.roman = roman;
            }
        }
    }
    
    public void displayRoman() {
        System.out.println(this.roman);
    }
}