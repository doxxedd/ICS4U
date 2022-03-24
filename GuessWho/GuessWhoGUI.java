/*
* Author: Lucas.C
* Date: 26-01-2021
* Description: This class contains the entirety of the UI of the game
*/

package GuessWho;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GuessWhoGUI extends JFrame implements ActionListener {
    
    //Declare panels, labels, layouts, and buttons
    private GuessWho gw;
    private int status;
    private int characterWidth = 135;
    private int characterHeight = 245;
    private String questionString;
    private String playerName;
    private int highScore;
    private int lastScore;
    private Attribute aiQuestion;
    private int flipsLeft;

    private BoxLayout menuLayout;
    private FlowLayout frameLayout;
    private GridLayout characterLayout;
    private FlowLayout gameLayout;
    private BoxLayout consoleLayout;
    private BoxLayout questionLayout;
    private BoxLayout scoreLayout;
    private BoxLayout lossLayout;
    private BoxLayout creditLayout;
    private BoxLayout instructionLayout;
    
    private JPanel characterPanel;
    private JPanel boardPanel;
    private JPanel menuPanel;
    private JPanel scorePanel;
    private JPanel questionPanel;
    private JPanel consolePanel;
    private JPanel lossPanel;
    private JPanel instructionPanel;
    private JPanel creditPanel;
    
    private JLabel[][] characterLabel;
    private JLabel titleLabel;
    private JLabel highScoreLabel;
    private JLabel lastScoreLabel;
    private JLabel selectedImage;
    private JLabel selectedHeader;
    private JLabel consoleHeader;
    private JLabel consoleMessage;
    private JLabel newHighScoreLabel;
    private JLabel newLastScoreLabel;
    private JLabel winMessage;
    private JLabel lossMessage;
    private JLabel instructionHeader;
    private JLabel creditHeader;
    private JLabel instructionLabel;
    private JLabel creditLabel;
    private JLabel selectedAILabel;

    private JButton confirmQuestion;
    private JButton playButton;
    private JButton saveButton;
    private JButton menuButton;
    private JButton instructionButton;
    private JButton creditsButton;
    
    private JComboBox<String> questionOption;
    
    public GuessWhoGUI(String playerName) throws Exception{
        //store flips and selected person
        //set the game to start up at the menu panel
        //set title size and etc. for the jframe
        this.playerName = playerName;
        
        status = 0;
        setTitle("Guess Who");
        setSize(1920, 1020);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLayout = new FlowLayout();
        setLayout(frameLayout);

        //initiallize main panels
        //menu
        menuPanel = new JPanel();
        menuLayout = new BoxLayout(menuPanel, BoxLayout.Y_AXIS);
        menuPanel.setLayout(menuLayout);

        //board panel
        gameLayout = new FlowLayout();
        boardPanel = new JPanel(gameLayout);

        //score panel
        scorePanel = new JPanel();
        scoreLayout = new BoxLayout(scorePanel, BoxLayout.Y_AXIS);
        scorePanel.setLayout(scoreLayout);

        //loss panel
        lossPanel = new JPanel();
        lossLayout = new BoxLayout(lossPanel, BoxLayout.Y_AXIS);
        lossPanel.setLayout(lossLayout);

        //credit panel
        creditPanel = new JPanel();
        creditLayout = new BoxLayout(creditPanel, BoxLayout.Y_AXIS);
        creditPanel.setLayout(creditLayout);

        //instruction panel
        instructionPanel = new JPanel();
        instructionLayout = new BoxLayout(instructionPanel, BoxLayout.Y_AXIS);
        instructionPanel.setLayout(instructionLayout);

        resetGame();
        updateFrame();
    }

    public void updateFrame(){
        //call function to panel swap or refresh panel according to status
        if(status == 0) {
            displayMenu();
        }
        else if(status == 1) {
            displayBoard();
        }
        else if(status == 2){
            displayScore();
        }
        else if(status == 3){
            displayLoss();
        }
        else if(status == 4){
            displayCredit();
        }
        else if(status == 5){
            displayInstruction();
        }
        else {
            System.out.println("An error has occured");
        }
        setVisible(true);
    }

    public void displayMenu(){
        //main menu panel
        menuPanel.removeAll();

        titleLabel = new JLabel("Guess Who");
        highScoreLabel = new JLabel("High score: " + highScore);
        lastScoreLabel = new JLabel("Last score: " + lastScore);
        playButton = new JButton("Play");
        playButton.addActionListener(
        new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    status = 1;
                    resetGame();
                    menuPanel.setVisible(false);
                    updateFrame();
                }
                catch(Exception ex){
                    System.out.println("An error has occurred");
                }
            }
        });
        instructionButton = new JButton("Instructions");
        instructionButton.addActionListener(this);
        instructionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsButton = new JButton("Credits");
        creditsButton.addActionListener(this);
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Courier", Font.BOLD,80));
        playButton.setFont(new Font("Courier", Font.BOLD,80));
        creditsButton.setFont(new Font("Courier", Font.BOLD,80));
        instructionButton.setFont(new Font("Courier", Font.BOLD,80));
        highScoreLabel.setFont(new Font("Courier", Font.BOLD,40));
        lastScoreLabel.setFont(new Font("Courier", Font.BOLD,40));
        menuPanel.add(titleLabel);
        menuPanel.add(playButton);
        menuPanel.add(creditsButton);
        menuPanel.add(instructionButton);
        menuPanel.add(highScoreLabel);
        menuPanel.add(lastScoreLabel);
        
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lastScoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(menuPanel);

        menuPanel.setVisible(true);
    }

    public void displayCredit() {
        creditPanel.removeAll();

        creditHeader = new JLabel("Credits");
        creditLabel = new JLabel("<html>GUI: Lucas Shen<br>API: Danial<br>Project Management: Lucas Chau<br><br><br><br><br><br><br><br><br><br></html>");
        menuButton = new JButton("Back to menu");
        menuButton.addActionListener(this);

        creditHeader.setFont(new Font("Courier", Font.BOLD,40));
        creditHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditLabel.setFont(new Font("Courier", Font.BOLD,40));
        creditLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.setFont(new Font("Courier", Font.BOLD,40));
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        creditPanel.add(creditHeader);
        creditPanel.add(creditLabel);
        creditPanel.add(menuButton);

        add(creditPanel);

        creditPanel.setVisible(true);
    }

    public void displayInstruction(){
        instructionPanel.removeAll();

        instructionHeader = new JLabel("Instructions");
        String instructionString ="<html>- First to guess the opponent’s character wins<br>- You can only select the program provided questions<br>- Enter your display/username<br>- You will receive a random character and the game will begin<br>- You can choose the questions you want to ask in the box<br>- The game will flip the characters that don’t have the traits that you’ve asked<br>- The game will save the score you previously achieved and your highest score if you click 'Save Score'<br>- Highest 'Score' refers to least amount of guesses it took to guess the opponents character<br>- To check the saved scores, open 'scores.txt'<br>- The format in 'scores.txt' is as follows:<br>- Player name; Time they took from pressing play and winning in min:sec; # of guesses they took to win<br><br><br><br><br><br></html>";
        instructionLabel = new JLabel(instructionString);
        menuButton = new JButton("Back to menu");
        menuButton.addActionListener(this);

        instructionHeader.setFont(new Font("Courier", Font.BOLD,40));
        instructionHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructionLabel.setFont(new Font("Courier", Font.BOLD,30));
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.setFont(new Font("Courier", Font.BOLD,40));
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        instructionPanel.add(instructionHeader);
        instructionPanel.add(instructionLabel);
        instructionPanel.add(menuButton);

        add(instructionPanel);

        instructionPanel.setVisible(true);
    }

    public void displayBoard() {
        //board/game panel
        boardPanel.removeAll();

        characterLayout = new GridLayout(4,6);
        questionPanel = new JPanel();
        questionLayout = new BoxLayout(questionPanel, BoxLayout.Y_AXIS);
        questionPanel.setLayout(questionLayout);
        characterPanel = new JPanel(characterLayout);
        characterPanel.setSize(1220, 980);
        consolePanel = new JPanel();
        consoleLayout = new BoxLayout(consolePanel, BoxLayout.Y_AXIS);
        consolePanel.setLayout(consoleLayout);

        //Use characters array to import images of active characters
        characterLabel = new JLabel[4][6];

        String characterName;
        ImageIcon tempImageIcon;
        Image tempImage;
        Image modifiedImage;

        //Create the images of the characters
        flipsLeft = 0;

        for(int i = 0; i < characterLabel.length; i ++){
            for(int j = 0; j < characterLabel[i].length; j ++){
                characterName = EnumConverter.enumToString(gw.getBoardsForUI()[0].getFlips()[i*6+j].getPerson().getName());
                if(gw.getBoardsForUI()[0].getFlips()[i*6+j].getIsActive()){
                    tempImageIcon = new ImageIcon("GuessWhoImages/"+characterName+".jpg");
                }
                else{
                    tempImageIcon = new ImageIcon("GuessWhoImages/Cardback.jpg");
                }
                tempImage = tempImageIcon.getImage();
                modifiedImage = tempImage.getScaledInstance(characterWidth, characterHeight, java.awt.Image.SCALE_SMOOTH);
                tempImageIcon = new ImageIcon(modifiedImage);
                characterLabel[i][j] = new JLabel(tempImageIcon);          
                characterPanel.add(characterLabel[i][j]);
                if(gw.getBoardsForUI()[1].getFlips()[i*6+j].getIsActive()){
                    flipsLeft ++;
                }
            }
        }
        //TODO: here
        /*
        for(int i = 0; i < gw.getBoardsForUI()[0].getFlips().length; i ++){
            characterName = gw.getBoardsForUI()[0].getFlips()[i].getPerson().getName().toString();
            characterName = characterName.substring(0,1).toUpperCase() + characterName.substring(1).toLowerCase();
            if(gw.getBoardsForUI()[0].getFlips()[i].getIsActive()){
                tempImageIcon = new ImageIcon("GuessWhoImages/"+characterName+".jpg");
            }
            else{
                tempImageIcon = new ImageIcon("GuessWhoImages/Cardback.jpg");
            }
            tempImage = tempImageIcon.getImage();
            modifiedImage = tempImage.getScaledInstance(characterWidth, characterHeight, java.awt.Image.SCALE_SMOOTH);
            tempImageIcon = new ImageIcon(modifiedImage);
            characterLabel[i] = new JLabel(tempImageIcon);          
            characterPanel.add(characterLabel[i]);
            if(gw.getBoardsForUI()[1].getFlips()[i].getIsActive()){
                flipsLeft ++;
            }
        }
        */

        //Ask question button
        confirmQuestion = new JButton("Ask question");
        confirmQuestion.addActionListener(
            new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    //Check if anyone guessed the selected character
                    questionString = (String)questionOption.getSelectedItem();
                    GameState result = gw.questioning(EnumConverter.stringToEnum(questionString));
                    System.out.println(result.winner.toString());
                    if (result.winner == EnumWinner.PLAYER) {
                        //If player won, bring them to save score screen
                        status = 2;
                        boardPanel.setVisible(false);
                    }
                    else if(result.winner == EnumWinner.AI){
                        //If player lost, bring them to the loss screen
                        aiQuestion = result.AIsGuess;
                        status = 3;
                        boardPanel.setVisible(false);
                    }
                    else{
                        //If noone won, continue the game
                        aiQuestion = result.AIsGuess;
                    }
                }
                catch(Exception ex){
                    //If something goes wrong, output to console
                    System.out.println("An error has occurred");
                }
                updateFrame();
            }
        });

        confirmQuestion.setFont(new Font("Courier", Font.BOLD,40));
        confirmQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Pop up menu for player to selected question
        String[] options = new String[45];
        int counter = 0;
        for (Attribute attribute : Attribute.values()) { 
            if(counter < 21) options[counter] = EnumConverter.enumToString(attribute).toLowerCase();
            else options[counter] = EnumConverter.enumToString(attribute);
            counter++;
            if(counter > 44) break;
        }
        questionOption = new JComboBox<>(options);
        questionOption.setFont(new Font("Courier", Font.BOLD,20));
        questionOption.setPreferredSize(new Dimension(135, 40));
        questionOption.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        questionPanel.add(questionOption);
        questionPanel.add(confirmQuestion);

        //image showing the randomly selected character your opponent tries to guess
        selectedHeader = new JLabel("Selected character");
        selectedImage = new JLabel(new ImageIcon("GuessWhoImages/"+gw.getBoardsForUI()[0].getSelectedPerson()+".jpg"));
        selectedImage.setAlignmentX(Component.CENTER_ALIGNMENT);

        selectedHeader.setFont(new Font("Courier", Font.BOLD,30));
        selectedHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        questionPanel.add(selectedHeader);
        questionPanel.add(selectedImage);

        //Game director to inform user what is happening
        //Update consoleMessage based on what the player asked and how the game is going
        consoleHeader = new JLabel(" Game Director");
        consoleHeader.setFont(new Font("Courier", Font.BOLD,40));
        String consoleString = "";
        if(questionString.equals("")){
            consoleString += ("<html>Your selected character is " + EnumConverter.enumToString(gw.getBoardsForUI()[0].getSelectedPerson()) + "<br>");
        }
        else {
            consoleString += ("<html>You asked for " + questionString + "<br>");
        }

        if(aiQuestion != null) {
            if(aiQuestion.ordinal() <21) {
                consoleString += ("The AI asked for " + EnumConverter.enumToString(aiQuestion).toLowerCase() + "<br>");
            }
            else {
                consoleString += ("The AI asked if your character is " + EnumConverter.enumToString(aiQuestion) + "<br>");
            }
        }

        consoleString += ("  The AI has " + flipsLeft + " flips active</html>");
        
        consoleMessage = new JLabel(consoleString);
        consoleMessage.setFont(new Font("Courier", Font.BOLD,20));
        consolePanel.setPreferredSize(new Dimension(820, 980));
        consolePanel.setBackground(Color.LIGHT_GRAY);

        consolePanel.add(consoleHeader);
        consolePanel.add(consoleMessage);

        boardPanel.add(characterPanel);
        boardPanel.add(questionPanel);
        boardPanel.add(consolePanel);
        add(boardPanel);

        boardPanel.setVisible(true);
    }

    public void displayScore() {
        scorePanel.removeAll();
        //display score panel, if you win
        //this panel has a message you won, a button to save score and a button to go back to menu without saving score
        winMessage = new JLabel("Good job you won");
        winMessage.setFont(new Font("Courier", Font.BOLD,80));
        winMessage.setForeground(Color.GREEN);
        winMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        newHighScoreLabel = new JLabel("Highscore: " + highScore);
        newHighScoreLabel.setFont(new Font("Courier", Font.BOLD,40));
        newHighScoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        newLastScoreLabel = new JLabel("Your score: " + lastScore);
        newLastScoreLabel.setFont(new Font("Courier", Font.BOLD,40));
        newLastScoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Button for saving score
        saveButton = new JButton("Save score");
        saveButton.setFont(new Font("Courier", Font.BOLD,40));
        saveButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                    try {
                        //Save score and update game
                        status = 0;
                        resetGame();
                        scorePanel.setVisible(false);
                        updateFrame();
                    }
                    catch(Exception ex){
                        //
                        System.out.println("An error has occurred");
                    }
                }
            }
        );
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton = new JButton("Back to menu");
        menuButton.setFont(new Font("Courier", Font.BOLD,40));
        menuButton.addActionListener(this);
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        scorePanel.add(winMessage);
        scorePanel.add(newHighScoreLabel);
        scorePanel.add(newLastScoreLabel);
        scorePanel.add(saveButton);
        scorePanel.add(menuButton);

        add(scorePanel);
        
        scorePanel.setVisible(true);
    }

    public void displayLoss() {
        //display loss panel, if you lose
        //this panel has a message that you lost, what the ai's character is, an image of the ai's character and a back to menu button
        lossPanel.removeAll();

        lossMessage = new JLabel("<html>Good try, you lost<br>The AI's character is " + EnumConverter.enumToString(gw.getBoardsForUI()[1].getSelectedPerson()) +"<br></html>");
        lossMessage.setForeground(Color.RED);
        lossMessage.setFont(new Font("Courier", Font.BOLD,40));
        lossMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        selectedAILabel = new JLabel(new ImageIcon("GuessWhoImages/"+EnumConverter.enumToString(gw.getBoardsForUI()[1].getSelectedPerson())+".jpg"));
        selectedAILabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuButton = new JButton("Back to menu");
        menuButton.setFont(new Font("Courier", Font.BOLD,40));
        menuButton.addActionListener(this);
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        lossPanel.add(lossMessage);
        lossPanel.add(selectedAILabel);
        lossPanel.add(menuButton);

        add(lossPanel);
        lossPanel.setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        //store the button that was clicked
        String button = event.getActionCommand();
        if(button.equals("Back to menu")){
            //go back to menu from loss or victory screen without saving score
            status = 0;
            scorePanel.setVisible(false);
            lossPanel.setVisible(false);
            creditPanel.setVisible(false);
            instructionPanel.setVisible(false);
            updateFrame();
        }
        else if(button.equals("Credits")){
            //display credits
            status = 4;
            menuPanel.setVisible(false);
            updateFrame();
        }
        else if(button.equals("Instructions")){
            //display instructions
            status = 5;
            menuPanel.setVisible(false);
            updateFrame();
        }
    }

    public void resetGame() throws Exception{
        //resets guesswho and updates highscore and last score
        //resets labels to blank
        gw = new GuessWho(playerName);
        highScore = ScoreboardManager.getLeastGuesses();
        var scores = ScoreboardManager.getScores();
        if(scores.length > 0){
            lastScore = scores[scores.length-1].guessCount;
        }
        else{
            lastScore = 0;
        }
        questionString = "";
        aiQuestion = null;
    }
}