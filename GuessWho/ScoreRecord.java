/*
* Author: Daniel.D
* Date: 25-01-2021
* Description: the attributes needed to construct a ScoreRecord
*/
package GuessWho;

public class ScoreRecord {
    public String name;
    public String time;
    public int guessCount;

    //constructor for ScoreRecord
    public ScoreRecord(String name, String time, int guessCount) {
        this.name = name;
        this.time = time;
        this.guessCount = guessCount;
    }
}
