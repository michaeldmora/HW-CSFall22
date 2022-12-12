package HW3;

import java.util.Scanner;

public class Loops {


    public static boolean loopE(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'e'){
                count++;
            }
        }
        return count >= 1 && count <= 3;

    }

   
    public static String stringTimes(String str, int n) {
        String newStr = "";
        for (int i = 0; i < n; i++) {
            newStr += str;
        }
        return newStr;
           
       }
    

    public static String stringZ(String str){
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'z') {
                newStr += str.charAt(i);
            }
        }
        return newStr;
       
    }

 
    public static void sums(){
        int total = 0;
        while (true) {
            System.out.println("I will add up the numbers you give me, type 0 to stop!");
            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();
            System.out.println("Number: " + num);
            total += num;
            System.out.println("The total so far is " + total);
            if (num == 0) {
                System.out.println("TOTAL ENDED --- The total is " + total);
                break;
            }
        }
    }


    public static void main(String[] args) {
        // Add code to help test your methods here
        System.out.println("Start of Main");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a word or phrase and I will tell you if it has between 1 and 3 e's");
        String phrase = scan.nextLine();
        if (loopE(phrase) == true) {
            System.out.println("Your input does have between 1 and 3 e's");
        } else {
            System.out.println("Your input does not have between 1 and 3 e's");
        }
        
        System.out.println("Enter a word that you would like to be repeated:");
        String str = scan.nextLine();
        System.out.println("How many times do you want to repeat the word?");
        int n = scan.nextInt();
        System.out.println(stringTimes(str, n));

        System.out.println("Enter a word or phrase and I will remove all the z's");
        String phrase2= "";
        phrase2 = scan.nextLine();
        // Kept skipping over this line, so I had to add it twice, could not figure out why
        // https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
        phrase2 = scan.nextLine();
        System.out.println(stringZ(phrase2));

        sums();
    }
    

}