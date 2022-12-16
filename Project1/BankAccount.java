package Project1;
import java.util.Scanner;

/*
 * This is a Java Doc
 * This is a multi-line comment
 *  
 * Our BankAccount class will represent a bank account
 * It will have a balance and a name
 * It will have methods to deposit and withdraw money
 * It will have a method to print the balance
 * it will have a menu that the user can interact with
 * 
 * 
 */

public class BankAccount {
    private double balance;
    private String name;
    private double interestRate = 0.01;
    private int period = 4; // quarterly


    // Constructor
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
        if (this.balance >= 10000) {
            System.out.println("You have reached the minimum balance for a savings account. Would you like to open one? (y/n)");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("1. Compound Interest");
                System.out.println("2. Flat Rate Interest");
                int choice = input.nextInt();
                if (choice == 1) {
                    interestRate = 0.0001;
                    period = 4;
                } else if (choice == 2) {
                    interestRate = 0.001;
                }
            }
        }
    }
    
    public BankAccount(String name) {
        this.name = name;
        this.balance = 0;
    }
    public BankAccount(double balance){
        this.balance = balance;
        this.name = "No Name";
    }
    // Default Constructor
    // Make a BankAccount without Specifying any parameters
    public BankAccount(){
        this.balance = 0;
        this.name = "No Name";
    }

    // Create getters and setters for balance
    public double getBalance() {
        return balance;
    }

    // Create a method for printing the balance as a String
    public String printBalance() {
        return "Your Balance is: $" + balance;
    }

    // public void setBalance(double balance) {
    //     this.balance = balance;
    // }
    // Set balance is flawed in that we would never
    // be able to actually set the balance. Instead we need 
    // to create methods to deposit and withdraw money

    // Create getters and setters for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    

    // Create a method to deposit money
    public void deposit(double amount) {
        this.balance += amount;
        // above is the same as this.balance = this.balance + amount;
        // balance is 10,000
        // amount  is 2,000
        // balance = balance + amount
        // 10000 = 10000 + 2000
    }

    // Create a method to withdraw money
    public void withdraw(double amount) {
        this.balance -= amount;
        // above is the same as this.balance = this.balance - amount;
        // balance is 10,000
        // amount  is 2,000
        // balance = balance - amount
        // 10000 = 10000 - 2000
    }

    // Create a method that will subtract a monthly fee from the balance
    // This method will take a double as an argument
    // This method will subtract the fee from the balance
    public void monthlyFee(double fee) {
        withdraw(fee);
    }


    // Create a method that will calculate the interest on the balance using compound interest
    // P(1 + R/n)^(nt) - P 
    // P = Principal
    // R = Rate
    // n = number of times interest is compounded per year (annum)
    // t = number of years
    // This method will take a double as an argument
    // This method will return a double

    // P can be this.balance or getBalance() if you would like to use a getter


    public void calcInterest(double principal, int time, double rate, int annum){
        double amount = principal * Math.pow(1+ (rate/annum), annum*time);
        double roundedamount = Math.round(amount * 100.0) / 100.0;
        double compinterest = amount - principal;
        compinterest = Math.round(compinterest * 100.0) / 100.0;
        System.out.println("Current Rate is: "+rate+"%");
        System.out.println("Current Period is: "+annum+" times per year");
        System.out.println("Selected Time is: "+time+" years");
        System.out.println("Compound Interest after " + time + " years: $" + compinterest);
        System.out.println("Amount after " + time + " years: $" + roundedamount);
    }





    public void printMenu() {
        System.out.println("1. Print Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Calculate Compound Interest");
        System.out.println("5. Calculate Simple Interest");
        System.out.println("6. Transfer Money");
        System.out.println("7. Quit");
        System.out.println("Enter a number: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.println(printBalance());
            printMenu();
        } else if (choice == 2) {
            System.out.println("Enter an amount to deposit: ");
            double amount = input.nextDouble();
            deposit(amount);
            System.out.println("Deposit successful. New balance is " + getBalance());
            printMenu();
        } else if (choice == 3) {
            System.out.println("Enter an amount to withdraw: ");
            double amount = input.nextDouble();
            overdraft(amount); // utilizes overdraft method instead of withdrawl method just in case the user tries to withdraw more than they have
            System.out.println("Withdrawal successful. New balance is " + getBalance());
            printMenu();
        } else if (choice == 4) {
            System.out.println("Enter principal amount: ");
            double principal = input.nextDouble();
            System.out.println("Enter number of years: ");
            int time = input.nextInt();
            calcInterest(principal, time, interestRate, period);
            printMenu();
        } else if (choice == 5) {
            System.out.println("Enter principal amount: ");
            double principal = input.nextDouble();
            System.out.println("Enter number of years: ");
            int time = input.nextInt();
            calcSimpleInterest(principal, time, interestRate);
            printMenu();
        } else if (choice == 6) {
            System.out.println("Enter account name: ");
            String nothing = input.nextLine();// this is because it skips the input
            String name = input.nextLine();
            BankAccount accountTransfer = new BankAccount(name); // meaningless test account for transfers
            System.out.println("Enter amount to transfer: ");
            double amount = input.nextDouble();
            transferMoney(accountTransfer, amount);
            System.out.println("Transfer successful. New balance is " + getBalance());
            printMenu();
        } else if (choice == 7) {
            System.out.println("Thank you for using our services. Goodbye.");
        } else {
            System.out.println("Invalid input. Please try again.");
            printMenu();
        }
    }
    

    public void overdraft(double amount) { // if they withdrawl more money than they have it will prompt them to see if they want to withdrawl the money and pay the overdraft fee
        if (this.balance <= 0 && this.balance - amount < 0) {
            System.out.println("Warning: Withdrawing this amount will result in a negative balance and a $35 overdraft fee.");
            System.out.println("Are you sure you want to proceed? (y/n)");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                withdraw(amount);
                withdraw(35);
            }
        } else {
            withdraw(amount);
        }
    }
    
    public void transferMoney(BankAccount toAccount, double amount) { // withdrawls money from users account and adds it to the test transfer account in the menu method
        withdraw(amount);
        toAccount.deposit(amount);
    }

    public void calcSimpleInterest(double principal, int time, double rate) {
        double amount = principal * (1 + rate * time);
        double interest = amount - principal;
        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Selected Time is: " + time + " years");
        System.out.println("Simple Interest after " + time + " years: $" + interest);
        System.out.println("Amount after " + time + " years: $" + amount);
    }
    

















}