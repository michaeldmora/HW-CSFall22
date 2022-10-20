package HW1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Start of HW1");

        
        System.out.println("Hello World");
        System.out.println(2+3);
       
        Pyramid.Output();


        
        Adlibs adlibs = new Adlibs();
        System.out.println("Time for madlibs!");
        System.out.println("Enter your name: ");
        String name = scan.nextLine();
        System.out.println("Enter your age: ");
        int age = scan.nextInt();
        System.out.println("Enter your favorite movie: ");
        scan.nextLine();
        String movie = scan.nextLine();
        System.out.println("Enter your favorite number: ");
        int number = scan.nextInt();

      
        System.out.println(adlibs.story(name, age, movie, number));

       
        System.out.println(Replace.charReplace("I am cool", 5, 'f'));








    }
}
