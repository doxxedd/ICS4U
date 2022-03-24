/*
* Author: Lucas.C
* Date: 26-01-2021
* Description: The First window that appears when the game is run. The window asks for player's username then stores username which is later given to GuessWhoGUI.java
*/
package GuessWho;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsernameGUI extends JFrame implements ActionListener{
    //attributes for usernamegui
    private String username = "";

    public BoxLayout panelLayout;
    public JPanel panel;
    public JLabel instructionLabel;
    public JTextField inputField;
    public JButton confirmButton;

    public UsernameGUI(){
        //set title, size, and etc.
        setTitle("Guess Who");
        setSize(480, 150);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //display username panel
        panel = new JPanel();
        instructionLabel = new JLabel("Please enter a username, max 16 characters");
        instructionLabel.setFont(new Font("Courier", Font.BOLD,20));
        inputField = new JTextField();
        inputField.setFont(new Font("Courier", Font.BOLD,20));
        confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Courier", Font.BOLD,20));
        confirmButton.addActionListener(this);

        panel.add(instructionLabel);
        panel.add(inputField);
        panel.add(confirmButton);

        panelLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(panelLayout);

        add(panel);

        setVisible(true);
    }

    public String getUsername(){
        //username accessor
        return username;
    }

    public void actionPerformed(ActionEvent event) {
        //store button input
        String button = event.getActionCommand();

        if(button.equals("Confirm")){
            //store first 16 letters of username
            username = inputField.getText();
            if(username.length() > 16){
                username = username.substring(0,16);
            }
        }
    }

}
