/*
* Author: Daniel.D, Lucas S
* Date: 25-01-2021
* Description: This is the main class that when ran, starts a fully functional game of guess who with logic and GUI integration
*/

package GuessWho;

public class Main {

    //Main startup of the program
    public static void main(String[] args) throws Exception {
        boolean loop = true;
        UsernameGUI gui = new UsernameGUI(); //new instance of UsernameGUI with name gui
        
        //this loop waits until username is entered
        while(loop){
            System.out.print("");
            if(!gui.getUsername().equals("")){
                loop = false;
            }
        }

        String username = gui.getUsername(); //username is stored 
        
        //getUsername window is now hidden
        gui.setVisible(false); 
        gui = null;

        GuessWhoGUI guessWhoGUI = new GuessWhoGUI(username); //new instance of GuessWhoGUI is created with username given to it from the previous window
    }
}