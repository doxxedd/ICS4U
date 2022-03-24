/*
* Author: Daniel.D, Lucas.C
* Date: 25-01-2021
* Description: This class is responsible for adding scores, reading current scores, and getting the highest score (least guesses) all from the 'scores.txt' file
*/
package GuessWho;

import java.util.*;

public class ScoreboardManager {

    private static String path = "scores.txt"; //this is the text file that will contain the scores of each player along with time completion after they choose to save score

    //Example of how each line under scores is read
    //name;minute:second;#ofguesses

    //returns current scores from file after reading all lines using the readAllLines method from FileManager
    public static ScoreRecord[] getScores() throws Exception {
        String[] lines = FileManager.readAllLines(path);
        List<ScoreRecord> scoreRecords = new ArrayList<ScoreRecord>();

        for (String line : lines) {
            String[] lineParts = line.split(";");
            scoreRecords.add(new ScoreRecord(lineParts[0], lineParts[1], Integer.parseInt(lineParts[2])));
        }

        return scoreRecords.toArray(new ScoreRecord[scoreRecords.size()]);
    }

    //adds a score using 
    public static void addScore(ScoreRecord score) throws Exception{
        List<ScoreRecord> scoreRecords = new ArrayList<ScoreRecord>();

        for (ScoreRecord scoreRecord : getScores()) {
            scoreRecords.add(scoreRecord);
        }

        scoreRecords.add(score);

        saveScores(scoreRecords.toArray(new ScoreRecord[scoreRecords.size()]));
    }

    //Example of how each line under scores is written
    //name;minute:second;#ofguesses
    private static void saveScores(ScoreRecord[] scoreRecords) throws Exception {
        List<String> lines = new ArrayList<String>();
        
        for (ScoreRecord sr : scoreRecords) {
            lines.add(sr.name + ";" + sr.time + ";" + sr.guessCount);
        }

        FileManager.writeAllLines(path, lines.toArray(new String[lines.size()]));
    }

    //returning the least amount of guesses in the scores.txt file (used for displaying highscore)
    public static int getLeastGuesses() throws Exception {
        var scores = getScores();
        if(scores.length > 0) {
            int min = scores[0].guessCount;
            for (ScoreRecord sc : scores) {
                if (sc.guessCount < min) min = sc.guessCount;
            }
            return min;
        }
        return 0;
    }

}