/*
* Author: Daniel Dinari
* Teacher: Ms. Andreghetti 
* Date: Sept 30, 2020
* Description: creates the tickets for the user and gives them the option to choose 7 numbers or have the 7 numbers be randomly generated for them. 
* The numbers must range between 1 and 79 without any duplicates. Output the selected numbers to the user in good form. Your solution must use arrays.
*/

package Tests;
import java.util.*;
public class Lotto779 {
    
    public static boolean contains(int[] array, int num) { //this method will check if a number entered is already in the array
        for (int i : array) {
            if (i == num) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randGen = new Random();
        int num;
        int[] array = new int[7];

        System.out.println("Do you want to generate the tickets? (y/n)");
        if (input.nextLine().equals("y")) {
            System.out.println("Numbers generated:");
            for (int i : array) {
                do {
                    num = randGen.nextInt(79) + 1; //generating numbers in range of 1-79
                } while (contains(array, num));
                i = num;
                
                System.out.println(i); //printing out the numbers generated
            }
        } else {
            System.out.println("Enter your 7 numbers:");
            
            //filling up the array with user input of 7 unique numbers
            for (int i = 0; i <array.length; i++) {
                do {
                    num = Integer.parseInt(input.nextLine());
                } while (contains(array, num));
                array[i] = num;
            }
            System.out.println("Your numbers are:"); 
            for (int i : array) {
                System.out.println(i + "\t");
            }
        }
    } 
}