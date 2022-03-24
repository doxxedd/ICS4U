/*
* Author: Daniel.D
* Date: 17-01-2021
* Description: This class contains the entire process that the AI takes to ask the best question based on 50% attribute strategy
*/
package GuessWho;

import java.util.*;

public class AI {
    
    //the strategic process that the AI takes to determine what question to ask. Takes in board object and outputs the attribute that is best to ask
    public Attribute getAttribute(Board board){

        int[] attributeCounts = new int[Attribute.values().length];

        List<Flip> activeFlips = new ArrayList<Flip>();

        // Getting all the active flips
        for (Flip f : board.getFlips()) {
            if(f.getIsActive() == false) continue;
            activeFlips.add(f);
        }

        // If there are less than 4 active flips, the AI will guess the name of one of the active flips randomly
        if (activeFlips.size() < 4) {
            Random randGen = new Random();
            return activeFlips.get(randGen.nextInt(activeFlips.size())).getPerson().getName();
        }
        
        // Gets how many times the different attributes appear
        for (Flip f : activeFlips) {
            for (Attribute a : f.getPerson().getAttributes()) {
                attributeCounts[Arrays.asList(Attribute.values()).indexOf(a)]++;
            }
        }

        // Gets the attribute that is common among close to 50% of the characters (eliminates close to 50% if asked)
        for (int i = 0; i < activeFlips.size()/2; i++) {
            for (int j = 0; j < attributeCounts.length; j++) {
                if((attributeCounts[j] + i == activeFlips.size()/2) || (attributeCounts[j] - i == activeFlips.size()/2)){
                    return Attribute.values()[j];
                }
            }
        }
        // If something goes wrong (the code should not reach here)
        return Attribute.NOTSET;
    }
}