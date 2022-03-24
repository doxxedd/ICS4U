/*
* Author: Daniel Dinari
* Teacher: Ms. Andreghetti 
* Date: Sept 21, 2020
* Description: Write an algorithm that prompts the user to enter a number.
* Without using any Java API methods, write a method to reverse the number. Output the reversed number to the user.
*/

package G11_review;
import java.util.Scanner;
public class ReverseNum {

    public static int reverseCalculator (int num) { //method for returning the reverse number

        int reverseNum = 0;

        while(num != 0) { //Loop though the loop while num is not 0
            final int digit = num % 10; // gets the decimal points (0.1) (0.01) etc
            reverseNum = reverseNum * 10 + digit; // adds the digit back
            num = num / 10;
        }
        return reverseNum;
    }

    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in); // opening scanner

        System.out.println("Enter your number:");
        final int num = input.nextInt(); // getting user input

        System.out.println("Your number reversed is:" + reverseCalculator(num)); //calling the method

        input.close();
    }
}