package HW2;
import java.util.Scanner;


public class MathGames {

// pythagorean theorem
public static double pythagoreanTheoremBP(double b, double p) {
    double c = Math.sqrt(Math.pow(b, 2) + Math.pow(p, 2));
    return c;
}

public static double pythagoreanTheoremBH(double b, double h) {
    double p = Math.sqrt(Math.pow(h, 2) - Math.pow(b, 2));
    return p;
}
public static double pythagoreanTheoremPH(double p, double h) {
    double b = Math.sqrt(Math.pow(h, 2) - Math.pow(p, 2));
    return b;
}

// Grade Calculator
public static String gradeCalc(double grade, String lettergrade) {
    grade = Math.ceil(grade);
    if (grade >= 90) {
       lettergrade = "A";
    } else if (grade >= 80) {
        lettergrade = "B";
    } else if (grade >= 70) {
        lettergrade = "C";
    } else if (grade >= 60) {
        lettergrade = "D";
    } else {
        lettergrade = "F";}

  return lettergrade;
}
    
// Tip Calculator

public static int calcTip(double total, double percentTip, int peopleSplit) {
    double splitTotal = total / peopleSplit;
    double tip = splitTotal * (percentTip / 100);
    int tipInt = (int) Math.ceil(tip);
    return tipInt;
}

// Main Method
    public static void main(String[] args){
        // pythagorean theorem
        int b;
        int p;
        int h;
        System.out.println("Pythagorean Theorem");
        System.out.println("Which side is missing?");
        System.out.println("1. Base");
        System.out.println("2. Perpendicular");
        System.out.println("3. Hypotenuse");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1) {
            System.out.println("Enter the Perpendicular");
            p = scan.nextInt();
            System.out.println("Enter the Hypotenuse");
            h = scan.nextInt();
            System.out.println("The Base is " + pythagoreanTheoremBH(p, h));
        } else if (choice == 2) {
            System.out.println("Enter the Base");
            b = scan.nextInt();
            System.out.println("Enter the Hypotenuse");
            h = scan.nextInt();
            System.out.println("The Perpendicular is " + pythagoreanTheoremPH(b, h));
        } else if (choice == 3) {
            System.out.println("Enter the Base");
            b = scan.nextInt();
            System.out.println("Enter the Perpendicular");
            p = scan.nextInt();
            System.out.println("The Hypotenuse is " + pythagoreanTheoremBP(b, p));
        } else {
            System.out.println("Invalid Choice");
        }
        // end of pythagorean theorem

        // grade calculator
        String lettergrade = " ";
        System.out.println("Grade Calculator");
        System.out.println("Enter your grade");
        double grade = scan.nextDouble();
        System.out.println("Your letter grade is a(n) " + gradeCalc(grade, lettergrade));
        // end of grade calculator

        // tip calculator
        System.out.println("Tip Calculator");
        System.out.println("Enter the total bill");
        double total = scan.nextDouble();
        System.out.println("Enter the percentage to tip");
        double percentTip = scan.nextDouble();
        System.out.println("Enter the number of people splitting the bill");
        int peopleSplit = scan.nextInt();
        int splitTip = calcTip(total, percentTip, peopleSplit);
        System.out.println("Each person should tip $" + splitTip);
        // end of tip calculator


        
    }







}