/*
* Author: Daniel.D, Lucas.C, Lucas.S
* Date: 13-01-2021
* Description: A tester class which is used for debugging and testing all of the major functions of this project. To test a method, uncomment in main. 
* Please refer to the Changes and Monitoring document for expected and actual results. All functions work currently work as expected.
*/
package GuessWho;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws Exception {

        //TestUsernameGUI();
        //TestGuessWhoGUI();
        //TestFileManager();
        //TestPerson();
        //TestFlip();
        //TestBoard();
        //TestAI();
        //TestTimer();
        //TestCharacterManager();
    }

    private static void TestUsernameGUI() throws Exception {
        boolean loop = true;
        UsernameGUI gui = new UsernameGUI();
        while(loop){
            System.out.print("");
            if(!gui.getUsername().equals("")){
                loop = false;
            }
        }
        String username = gui.getUsername();
        gui.setVisible(false);
        gui = null;

        GuessWhoGUI guessWhoGUI = new GuessWhoGUI(username);
    }

    private static void TestGuessWhoGUI() throws Exception{
        GuessWhoGUI gui = new GuessWhoGUI("Playername");
    }

    private static void printBoard(Board board){
        System.out.println("--------------------------------\nSelected person: " + board.getSelectedPerson());
        for (int i = 0; i < 24; i+=6) {
            String[] lines = new String[3];
            lines[0] = "";
            lines[1] = "";
            lines[2] = "";
            for (int j = 0; j < 6; j++) {
                lines[0] += board.getFlips()[i + j].getIsActive()?"---ACTIVE---   ":"-NOT ACTIVE-   ";
                lines[1] += board.getFlips()[i + j].getPerson().getName() + " ".repeat(12 - board.getFlips()[i + j].getPerson().getName().toString().length()) + "   ";
                lines[2] += "------------   ";
            }
            System.out.println(lines[0] + "\n" + lines[1] + "\n" + lines[2] + "\n\n");
        }
        System.out.println("--------------------------------\n");
    }

    private static void TestTimer() throws InterruptedException {
        Timer t = new Timer();
        TimeUnit.SECONDS.sleep(83);
        System.out.println("It should be 1:23: " + t.getElapsedTime());
    }

    private static void TestFileManager() throws Exception{
        for (Person p : CharacterManager.getCharactersInArray()) {
            System.out.println("\n" + p.getName() + ":");
            for (Attribute a : p.getAttributes()) {
                System.out.println(a);
            }
        }
    }

    private static void TestPerson(){
        Person p = new Person(Attribute.ALEJANDRO, Arrays.asList(new Attribute[]{Attribute.BEARD, Attribute.BROWN_EYES, Attribute.BIG_LIPS}));
        System.out.println("(getName)       Should be ALEJANDRO: " + p.getName());
        System.out.println("(hasAttribute)  Should be true:" + p.hasAttribute(Attribute.BEARD));
        System.out.println("(hasAttribute)  Should be false:" + p.hasAttribute(Attribute.SMALL_LIPS));
    }

    private static void TestFlip(){
        Flip f = new Flip(new Person(Attribute.ALEJANDRO, Arrays.asList(new Attribute[]{Attribute.BEARD, Attribute.BROWN_EYES, Attribute.BIG_LIPS})));
        System.out.println("(getIsActive)               Should be active:" + f.getIsActive());
        f.flipDown();
        System.out.println("(flipDown)                  Should not be active:" + f.getIsActive());
        f = new Flip(new Person(Attribute.ALEJANDRO, Arrays.asList(new Attribute[]{Attribute.BEARD, Attribute.BROWN_EYES, Attribute.BIG_LIPS})));
        f.flipDownIfHasAttribute(Attribute.ALEJANDRO);
        System.out.println("(flipDownIfHasAttribute)    Should be active:" + f.getIsActive());
        f.flipDownIfHasAttribute(Attribute.BEARD);
        System.out.println("(flipDownIfHasAttribute)    Should not be active:" + f.getIsActive());
    }

    private static void TestBoard() throws Exception {
        Board b = new Board(CharacterManager.getCharactersInArray(), Attribute.ALEJANDRO);
        b.flipDownPeopleWithoutAttributeAsked(Attribute.MUSTACHE);
        System.out.println("(flipDownPeopleWithoutAttribute) Should be only 4 people not active:");
        for (Flip f : b.getFlips()) {
            System.out.println(f.getIsActive() + ":" + f.getPerson().getName());
        }
    }
    
    private static void TestAI() throws Exception{
        AI ai = new AI();
        Board b = new Board(CharacterManager.getCharactersInArray(), Attribute.ALEJANDRO);
        System.out.println("(getAttribute) Should be short and straight hair" + ai.getAttribute(b));
    }
}
