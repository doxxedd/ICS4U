/*
* Author: Daniel.D
* Date: 25-01-2021
* Description: Timer class used for when saving the player's score in 'scores.txt'
*/
package GuessWho;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;

public class Timer {
    LocalTime startTime;

    //timer starts when the player starts the game. This function retrieves the local time of the system
    public Timer() {
        startTime = LocalTime.now();
    }

    //function that returns the difference between local time when timer method started and calculates the difference of when this method is called
    public String getElapsedTime(){
        return MINUTES.between(startTime, LocalTime.now()) + ":" + (SECONDS.between(startTime, LocalTime.now()) - MINUTES.between(startTime, LocalTime.now())*60);
    }
}
