/*
* Author: Daniel.D
* Date: 14-01-2021
* Description: Board referrs to the board that both the player and AI have containing 24 flips and a selected person.
*/
package GuessWho;

public class Board {

    //a board contains 24 flips
    private Flip[] flips = new Flip[24];

    //contains a selected character
    private Attribute selectedPerson;
    
    //Constructor for board. Takes in a person array of characters in the guess who game and the 
    //selected person that the opposing player will try to guess. puts all characters into an array of flips. 
    public Board(Person[] characters, Attribute selectedPerson) {

        this.selectedPerson = selectedPerson; 

        for(int i = 0; i < 24; i ++) {
            flips[i] = new Flip(characters[i]);
        }
    }

    //eliminates the flips that should be inactive after a certain question is asked. Takes in any attributes.
    public void flipDownPeopleWithoutAttributeAsked(Attribute attribute){
        for (Flip f : flips) {
            f.flipDownIfDoesntHaveAttribute(attribute);
        }
    }
    
    //eliminates the flips that should be inactive after a certain question is asked. Takes in any attributes.
    public void flipDownPeopleWithAttributeAsked(Attribute attribute){
        for (Flip f : flips) {
            f.flipDownIfHasAttribute(attribute);
        }
    }

    //getter method of the status of all the flips on the board
    public Flip[] getFlips(){
        return flips;
    }

    //getter method of the selected person that the opposing player is trying to guess.
    public Attribute getSelectedPerson(){
        return selectedPerson;
    }
}