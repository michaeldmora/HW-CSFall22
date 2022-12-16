package HW4;
import java.util.Scanner;

public class Arrays {

    public static void Arraysums() {
        // Create an array to store the numbers that the user inputs
        int[] numbers = new int[1000];
        int total = 0;
        int count = 0;
    
        while (true) {
            System.out.println("I will add up the numbers you give me, type 0 to stop!");
            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();
            System.out.println("Number: " + num);
    
            // Add the number to the array and increment the total
            numbers[count] = num;
            total += num;
    
            System.out.println("The total so far is " + total);
            if (num == 0) {
                System.out.println("TOTAL ENDED --- The total is " + total);
    
                // Output the array
                System.out.print("Array: {");
                for (int i = 0; i < count; i++) {
                    System.out.print(numbers[i] + ", ");
                }
                System.out.println(numbers[count] + "}");
    
                break;
            }
    
            // Increment the count to keep track of how many numbers have been added to the array
            count++;
        }
    }
    


    public static String bruteForce(String password){
        String answer = "";
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')','<','>','/','?'};
    
        for (int i = 0; i < password.length(); i++) { // loop through the password and check if the character is in the alphabet 
            char c = password.charAt(i); 
            for (int j = 0; j < alphabet.length; j++) { // if it is, add it to the answer
                if (c == alphabet[j]) {
                    answer += c;
                    break;
                }
            }
        }
    
        return answer; 
    }
    
    
   
    public static int[] sorter(int[] nums) {
        int[] sortedArray = new int[nums.length]; // new array to put sorted numbers in
    
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) { // find the smallest number in the array and put it in the first index and so on
                if (nums[i] > nums[j]) {                
                    int temp = nums[i];                   
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    
        for (int i = 0; i < nums.length; i++) { // put sorted numbers in new array
            sortedArray[i] = nums[i];
        }
        return sortedArray;
        
    }
    



    public static void main(String[] args) {
        // Tester main method for your methods
        System.out.println("Hello World!");
        // sum of arrays
         Arraysums();
         // bruteforce
        System.out.println(bruteForce("ZZZZ"));
        // sorter
        int[] nums = {9,10,2,5,3,4,7,8}; // unsorted array
        int[] sorted = sorter(nums);
        System.out.print("Sorted Array: { ");
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
        }
        System.out.print("}"); 

     


    }

    
}