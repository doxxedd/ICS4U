/*
* Author: Daniel Dinari
* Date: Sept 17, 2020
* Description: <Make a higher and lower game. 
* The computer generates a random number between 1 and 100, the user guesses. 
* The computer will say whether or not it's higher or lower. 
* Repeat this until the user guesses correctly. 
* Let the user know with a message when their guess is correct.>
*/

package G11_review;
import java.util.*;
public class RandGen {
	public static void main (String[] args) {
		Scanner input  = new Scanner(System.in); //creating the scanner class
		
		Random randGen = new Random(); //creating the random num gen class
		int randNum = randGen.nextInt(100) + 1;
		int response = 0;
		
		do { //looping the following once before stopping if condition is met
			System.out.println("What is your guess?");
			response = input.nextInt(); //taking user input
		
			if (response > randNum) {
				System.out.println("Number was lower");
			} else if (response < randNum) {
				System.out.println("Number was higher");
			} else {
				System.out.println("You have guessed correctly!");
			}
		} while (response != randNum); //looping the loop while their answer is not correct
	
		input.close(); //closing the scanner
	}
}