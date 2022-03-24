/*
* Author: Daniel.D
* Date: 22-01-2021
* Description: Updates the status of the game when given ScoreRecord and the attribute that the AI guessed
*/
package GuessWho;

public class GameState {
    public EnumWinner winner;
    public ScoreRecord scoreRecord;
    public Attribute AIsGuess;

    // takes in the enumWinner, ScoreRecord and the attribute that the AI guessed, then returns the updated status of the game
    public GameState(Attribute AIsGuess, EnumWinner winner, ScoreRecord scoreRecord) {
        this.AIsGuess = AIsGuess;
        this.winner = winner;
        this.scoreRecord = scoreRecord;
    }
}
