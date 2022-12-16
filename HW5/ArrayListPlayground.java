package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListPlayground {
    public static void main(String[] args) {
        System.out.println("Start of HW5");
       
        
        ArrayList<Integer> nums = new ArrayList<Integer>(15);
        for(int i = 0; i < 15; i++){
            nums.add((int)(Math.random()*100));
        }
        System.out.println(nums.get(10));
        nums.set(5, 99);
        nums.set(13, 15);
        nums.set(2, 6);
        nums.set(9, nums.get(13) + nums.get(2));
        System.out.println(nums);

    

        ArrayList<String> days = new ArrayList<String>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
        System.out.println(days);
        System.out.println(days.get(1) + " " + days.get(3) );
        Collections.rotate(days, 1);    // Moves each element to the right by 1
        System.out.println(days);


        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        int num = 1;
        while(num != 0){
            System.out.println("Enter a number: ");
            num = input.nextInt();
            numbers.add(num);
        }
        System.out.println("Largest number: " + Collections.max(numbers));// prints the largest number
        System.out.println("Smallest number: " + Collections.min(numbers)); // prints the smallest number
        Collections.sort(numbers); // sorts the array
        System.out.println(numbers);
        if(numbers.size()%3==0){
            for(int i=0;i<numbers.size();i++)
            {
                System.out.print(numbers.get(i)+" ");   // If the the array is dividable by 3, it prints the array in a 3x3 matrix
                if((i+1)%3==0)
                {
                    System.out.println();
                }
            }
        }else{
            System.out.println("Please enter 2 more numbers to create the matrix..."); // If the array is not dividable by 3, it asks the user to enter 2 more numbers
            int num2 = 1;
            while(num2 != 0){
                System.out.println("Enter a number: ");
                num2 = input.nextInt();
                numbers.add(num2);
            }
            for(int i=0;i<numbers.size();i++)
            {
                System.out.print(numbers.get(i)+" ");
                if((i+1)%3==0)
                {
                    System.out.println();
                }
            }
        }

    
    }
}
