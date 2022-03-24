package OOP;

import java.util.Scanner;

public class MySavings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PiggyBank bank = new PiggyBank();

        boolean stillRunning = true;
        while (stillRunning) {
            
            System.out.println("\n1. Show total in bank");
            System.out.println("2. Add a nickel.");
            System.out.println("3. Add a dime.");
            System.out.println("4. Add a quarter.");
            System.out.println("5. Add a loonie.");
            System.out.println("6. Add a toonie.");
            System.out.println("7. Take money out of the bank.");
            System.out.println("Enter 0 to quit");
            
            String response = input.nextLine();

            switch (response) {
                case "1":
                    System.out.println("\nThere is $" + bank.totalAmount() + "in your piggy bank.");
                    break;
                
                case "2":
                    bank.addCoin(new Nickel());
                    break;
                
                case "3":
                    bank.addCoin(new Dime());
                    break;
                
                case "4":
                    bank.addCoin(new Quarter());
                    break;
                
                case "5":
                    bank.addCoin(new Loonie());
                    break;
                
                case "6":
                    bank.addCoin(new Toonie());
                    break;
                
                case "7":
                    //not done yet
                    break;
                
                case "0": 
                    System.out.println("Exiting...");
                    stillRunning = false;
                    break;
                
                default:
                    System.out.println("Unknown command.");
                    break;
            }
        }
    }
}