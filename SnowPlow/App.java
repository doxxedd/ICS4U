/*
* Author: Daniel Dinari
* Teacher: Ms. Andreghetti 
* Date: October 30th, 2020
* Description: Snowplow that scans the top row of a grid array filled with random 1s and 2s all the way through.
* After finding the first "1" in the top row, it will turn all the other 1s "touching" the first "1" to 0s.
* All in a GUI that has a "plow" (runs the program turning all 1s to 0s that are touching) and "reset" button that (regenerates the full grid with a new set of 1s and 2s)
*/

package SnowPlow;

public class App {
    public static void main(String[] args) {
        new GUI(); //startup
    }
}