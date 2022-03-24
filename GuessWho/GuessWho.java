/*
* Author: Daniel.D
* Date: 12-01-2021
* Description: The class that ties in all major logics of the game
*/
package GuessWho;

import java.util.*;

public class GuessWho {
    //declare board arrays and class level instances
    private Board[] boards = new Board[2];
    private AI ai = new AI();
    private Timer timer;
    private String playerName;
    private int guessCount = 0;
    private Person[] characters;
    private Attribute lastQuestion = Attribute.NOTSET;
    private EnumWinner winner = EnumWinner.NONE;

    private int activeBoard = 0; // Player 0, AI 1

    //GuessWho instantiates the boards given player name
    public GuessWho(String playerName) throws Exception {

        this.playerName = playerName;

        timer = new Timer(); //starts timer 

        Random randGen = new Random(); //new random instance 

        characters = CharacterManager.getCharactersInArray(); //gets all the characters that are stored in array from CharacterManager and stores in characters

        //gives both AI and player their selected person (that has to be guessed) which is taken from the enums in the attribute class
        boards[0] = new Board(characters, Attribute.values()[randGen.nextInt(24) + 21]);
        boards[1] = new Board(characters, Attribute.values()[randGen.nextInt(24) + 21]); 
    }

    // Getter method of boards to be used with GUI
    public Board[] getBoardsForUI(){
        return boards;
    }

    // Call this method when asking a question. Determines the winner, adds scores to file, updates the status of flips when given attribute asked. Returns GameState
    public GameState questioning(Attribute attribute) throws Exception {

        // Runs if the player or AI asks for a name
        if (attribute.ordinal() > 20) {
            // Runs if it's the players turn
            if (activeBoard == 0) {
                if (boards[1].getSelectedPerson() == attribute) {
                    ScoreboardManager.addScore(new ScoreRecord(playerName, timer.getElapsedTime(), guessCount)); //saves players score using the addScore method in ScoreboardManager.java
                    return new GameState(Attribute.NOTSET, EnumWinner.PLAYER, new ScoreRecord(playerName, timer.getElapsedTime(), guessCount));
                }
                else{
                    boards[activeBoard].flipDownPeopleWithAttributeAsked(attribute); //if the players board does not contain attribute asked then flip down people with the attribute asked
                }
            }
            // Runs if it's the AIs turn
            else {
                if (boards[0].getSelectedPerson() == attribute) {
                    System.out.println("AI won");
                    winner = EnumWinner.AI;
                    return new GameState(attribute, EnumWinner.AI, null);
                }
                else{
                    boards[activeBoard].flipDownPeopleWithAttributeAsked(attribute); //if the AI's board does not contain attribute asked then flip down people with the attribute asked
                }
            }
        }


        

        // Players swapping turns
        if (activeBoard == 0) {

            for (Person p : characters) {
                if(boards[1].getSelectedPerson() == p.getName()){
                    if(p.hasAttribute(attribute)){
                        boards[activeBoard].flipDownPeopleWithoutAttributeAsked(attribute);
                        System.out.println("Flipped down all the people without " + attribute);
                    }
                    else{
                        boards[activeBoard].flipDownPeopleWithAttributeAsked(attribute);
                        System.out.println("Flipped down all the people with " + attribute);
                    }
                }
            }
            activeBoard = 1;
            System.out.println("ActiveBoard is set to AI");
        }
        else{
            for (Person p : characters) {
                if(boards[0].getSelectedPerson() == p.getName()){
                    if(p.hasAttribute(attribute)){
                        boards[activeBoard].flipDownPeopleWithoutAttributeAsked(attribute);
                        System.out.println("Flipped down all the people without " + attribute);
                    }
                    else{
                        boards[activeBoard].flipDownPeopleWithAttributeAsked(attribute);
                        System.out.println("Flipped down all the people with " + attribute);
                    }
                }
            }
            activeBoard = 0;
            System.out.println("ActiveBoard is set to player");
        }

        //if active board is set to AI then they use the questioning method to ask question
        if (activeBoard == 1) {
            guessCount++;
            System.out.println("AI starts to question");
            lastQuestion = ai.getAttribute(boards[1]);
            questioning(lastQuestion);
        }
        
        return new GameState(lastQuestion, winner, null); 
    }
}