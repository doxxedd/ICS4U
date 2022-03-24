package SnowPlow;

/*
* Author: Daniel Dinari
* Teacher: Ms. Andreghetti 
* Date: October 23, 2020
* Description: 
*/

import java.util.*;

public class Console {
    static int[][] array; 

    private static void generateArray() { 
        array = new int[8][8]; //2D array
        Random rand = new Random();

        // Nested for loops to fill up the initial grid with 2 and 1s
        for (int i = 0; i < array.length; i++) { // array.length = size of how many arrays there are
            for (int j = 0; j < array[i].length; j++) { // array[i].length = size of each array
                array[i][j] = rand.nextInt(2) + 1; // Setting the randGen range 1-2
            }
        }
    }

    //searching the first row of the 2D array to find the first "1"
    private static int findFirstOne() {
        for (int i = 0; i < array[0].length; i++) {
            if (array[0][i] == 1) return i;
        }
        return -1;
    }

    //the clear method that turns all the 1s into 0s
    private static void clear(int x, int y) {
        array[x][y] = 0;
        if (x != 0 && array[x - 1][y] == 1) clear(x - 1, y);
        if (x != 7 && array[x + 1][y] == 1) clear(x + 1, y);
        if (y != 0 && array[x][y - 1] == 1) clear(x, y - 1);
        if (y != 7 && array[x][y + 1] == 1) clear(x, y + 1);

        if (x != 0 && y != 0 && array[x - 1][y - 1] == 1) clear(x - 1, y - 1);
        if (x != 7 && y != 7 && array[x + 1][y + 1] == 1) clear(x + 1, y + 1);
        if (x != 0 && y != 7 && array[x - 1][y + 1] == 1) clear(x - 1, y + 1);
        if (x != 7 && y != 0 && array[x + 1][y - 1] == 1) clear(x + 1, y - 1);
    }

    private static void displayArray() {
        String arrayInString = ""; //empty string

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                arrayInString += array[i][j] + "⠀"; //invisible character 
            }
            arrayInString += "\n";
        }
        System.out.println(arrayInString);
    }
    public static void main(String[] args) {
        generateArray();
        displayArray();
        
        int startingPoint = findFirstOne();
        
        if (startingPoint == -1) {
            System.out.println();
            return; // Ends the program (stops main)
        }
        clear(0, startingPoint);

        displayArray();
    }
}