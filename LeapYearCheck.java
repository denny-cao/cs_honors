import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.lang.Math;

public class LeapYearCheck {
    final static int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    private int year;

    public LeapYearCheck() {
        setYear();
    }

    public void setYear() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Year: ");
            int year = scan.nextInt();
            
            // Ensure year is or above 1000. Otherwise, rerun.
            if (year >= 1000) {
                this.year = year;
                scan.close();
            }
            else {
                setYear();
            }
        } catch (InputMismatchException e) {
            scan.close();
            setYear();
        }
    }

    public void displayLeap() {
        /*
         * Display the leap year. State wether it was, is, will be, was not, is not, or will not be.
         */

        String fill;

        int yearGap = this.year - currentYear;
        
        /*
         * tense:
         *  1: future
         *  0: past
         *  -1: current
         */

        int tense = yearGap == 0 ? 0 : yearGap / Math.abs(yearGap);

        if (tense == 0) fill = "is";
        else if (tense > 0) fill = "will";
        else fill = "was";

        if (!this.isLeap()) fill += " not";

        if (tense > 0) fill += " be";

        System.out.printf("%d %s a leap year. \n", this.year, fill);
        
    }

    public boolean isLeap() {
        return isGregorian() ? isGregLeap() : isJulLeap(); 
    }

    public boolean isGregorian() {
        /*
         * Returns if the input year is Gregorian. Otherwise, it is Julian.
         */
        return this.year >= 1586;
    }

    public boolean isGregLeap() {
        return ((this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 ==0);
    }

    public boolean isJulLeap() {
        return this.year % 4 == 0;
    }

    public static void main(String[] args) {
        /* Leap Year 1900 / 4 not leap year... 2100 / 4 not leap year
         * 6 hours 11 mins
         * before 1586: divisible by 4
         * after 1586: check if divisible by 4 then check further... also divisible by 100 -> Dount count as leap year
         divisible by 400: regardless divisible by 100, still count as leap
         * Goal: Ask input number has to be 4 digit number and represents a year. figure out if was a leap year, will be a leap year, or not
         */

        LeapYearCheck leapCheck = new LeapYearCheck();
        leapCheck.displayLeap();
    }

}