/*
* Author: Daniel Dinari
* Teacher: Ms. Andreghetti 
* Date: Sept 23, 2020
* Description: prompt the user to enter a natural number from 1 to 10 
* (stop entering numbers when the user enters a number outside the range). 
* The procedure will output the number of the times each number was entered.
*/

package G11_review;

import java.util.*;
import java.util.stream.*;

public class Level2bArrayExercises {

    static Scanner input = new Scanner(System.in);

    public static void countOccurrences(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter a number from 1 to 10: (# outside the range will stop your input)"); //prompt
            int response = Integer.parseInt(input.nextLine()); //doing this to avoid the enter character not being detected
            
            if (response < 1 || response > 10) break; //if response is out of range, it will stop the program
            array[response-1]++; //counting using array as counter
        }
    }

    public static void countOccurrences2(int[] array) {
        for (int i = 10; i < array.length; i++) {
            System.out.println("Enter a number from 15 to 25: (# outside the range will stop your input)"); //prompt
            int response = Integer.parseInt(input.nextLine()); //doing this to avoid the enter character not being detected
            
            if (response < 15 || response > 25) break; //if response is out of range, it will stop the program
            array[response-1]++; //counting using array as counter
        }
    }

    public static void totals(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter a number from 0 to 99: (# outside the range will stop your input)"); //prompt
            int response = Integer.parseInt(input.nextLine()); //doing this to avoid the enter character not being detected
            
            if (response < 0 || response > 99) break; //if response is out of range, it will stop the program
            array[response-1]++; //counting using array as counter
        }

        // int sum = 0;
        // for (int i = 0; (i < array.length) && (i <= 10); i++) {
        //     sum += array[i];
        // }

        // for (int i = 0; i < array.length; i++) {
        //     IntStream.range(array[1], array[10]).map(array[i] -> array[i]).sum();
        // }

        // System.out.println(sum);
    }
    public static void main(String[] args) {
        //initializing arrays for the methods above
        int[] array = new int[10];
        int[] array2 = new int[25];
        int[] array3 = new int[99];

        //1-10 array display
        countOccurrences(array);
        System.out.println("\n");
        System.out.println("#\tOccurrences");
        for (int i = 0; i < array.length; i++) {
            System.out.println((i+1) + "\t\t" + array[i]);
        }
        System.out.println("\n");

        //15-25 array display
        countOccurrences2(array2);
        System.out.println("\n");
        System.out.println("#\tOccurrences");
        for (int i = 14; i < array2.length; i++) {
            System.out.println((i+1) + "\t\t" + array2[i]);
        }
        System.out.println("\n");

        //0-99 array display
        totals(array3);
        System.out.println("\n");   
    }
}
