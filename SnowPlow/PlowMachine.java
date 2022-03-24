package SnowPlow;

import java.util.Random;

public class PlowMachine {

    private  int[][] array;

    //constructor
    //filling up the grid
    public PlowMachine() {
        generateArray(); 
    }

    // Public methods

    public void plow(){
        int startingPoint = findFirstOne();
        
        if (startingPoint != -1) {
            clear(0, startingPoint); //giving the starting point to the plow method
        }
        
    }

    public void generateArray() {
        array = new int[8][8]; //2D array
        Random rand = new Random(); //random instance

        // Nested for loops to fill up the initial grid with 2 and 1s
        for (int i = 0; i < array.length; i++) { // array.length = size of how many arrays there are
            for (int j = 0; j < array[i].length; j++) { // array[i].length = size of each array
                array[i][j] = rand.nextInt(2) + 1; // Setting the randGen range 1-2
            }
        }
    }

    // Converting the entire grid into a string in HTML format. Due to JLabels using HTML
    public String arrayToHTMLFormat() {
        String arrayInString = "<html>";

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    arrayInString += "<span style=\"color:red\">0</span> "; 
                } else {
                    arrayInString += "<span style=\"color:white\">" + array[i][j] + "</span> ";
                }
            }
            arrayInString += "<br>"; //just a space character
        }
        return arrayInString;
    }

    // Private methods

    /**
    * Searches the first row for a "1".
    * @return the index of the first element with value of "1" found.
    */ 
    private int findFirstOne() {
        for (int i = 0; i < array[0].length; i++) {
            if (array[0][i] == 1) return i;
        }
        return -1;
    }

    // The clear method that turns all the 1s into 0s and also takes in the starting x y coordinates 
    private void clear(int x, int y) {
        array[x][y] = 0; // Replacing the x and y to 0

        if (x != 0 && array[x - 1][y] == 1) clear(x - 1, y); // Making sure the X is not 0, so we can run the 2nd condition, checking if the other element on the LEFT is 1. If so, we call clear with that element
        if (x != 7 && array[x + 1][y] == 1) clear(x + 1, y); // Making sure the X is not 7, so we can run the 2nd condition, checking if the other element on the RIGHT is 1. If so, we call clear with that element
        if (y != 0 && array[x][y - 1] == 1) clear(x, y - 1); // Making sure the X is not 0, so we can run the 2nd condition, checking if the other element on the TOP is 1. If so, we call clear with that element
        if (y != 7 && array[x][y + 1] == 1) clear(x, y + 1); // Making sure the X is not 7, so we can run the 2nd condition, checking if the other element on the BOTTOM is 1. If so, we call clear with that element

        if (x != 0 && y != 0 && array[x - 1][y - 1] == 1) clear(x - 1, y - 1); //Making sure X is not 0, so we can run the 2nd condition, making sure Y is not 0, then checking if the other element on the BOTTOM LEFT is 1. If so, we call clear with that element
        if (x != 7 && y != 7 && array[x + 1][y + 1] == 1) clear(x + 1, y + 1); //Making sure X is not 7, so we can run the 2nd condition, making sure Y is not 7, then checking if the other element on the TOP RIGHT is 1. If so, we call clear with that element
        if (x != 0 && y != 7 && array[x - 1][y + 1] == 1) clear(x - 1, y + 1); //Making sure X is not 0, so we can run the 2nd condition, making sure Y is not 7, then checking if the other element on the TOP LEFT is 1. If so, we call clear with that element
        if (x != 7 && y != 0 && array[x + 1][y - 1] == 1) clear(x + 1, y - 1); //Making sure X is not 7, so we can run the 2nd condition, making sure Y is not 0, then checking if the other element on the BOTTOM RIGHT is 1. If so, we call clear with that element
    }
}
