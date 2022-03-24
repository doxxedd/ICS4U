package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Challenge extends JFrame implements ActionListener {
    
    //declaring all instances or variables
    JPanel topPanel;
    JPanel bottomPanel;
    JButton clicked;
    
    GridLayout topLayout;
    GridLayout bottomLayout;
    GridLayout frameLayout;
    
    JButton[] buttons100;
    boolean[] buttonPressed; 

    JLabel messageLabel;
    JLabel buttonPressedLabel;

    public Challenge() {
        setTitle("Challenge Task");
        setSize(800,600);

        //creating and applying the layout
        frameLayout = new GridLayout(2,1); //2 rows, 1 column
        setLayout(frameLayout);

        //create and configure the top panel (buttons)
        buttons100 = new JButton[100];
        buttonPressed = new boolean[100]; //already false

        topPanel = new JPanel();
        topLayout = new GridLayout (10,10);
        topPanel.setLayout(topLayout);

        for (int i = 0; i < buttons100.length; i++) {
            buttons100[i] = new JButton ( String.valueOf(i + 1)); //1 - 100 range
            buttons100[i].addActionListener(this); //registering this frame as an actionlistenter 
            topPanel.add(buttons100[i]);
        }

        add(topPanel); //adding top panel to the frame

        //creating and configuring bottom panel
        bottomPanel = new JPanel();
        bottomLayout = new GridLayout (1,2);
        bottomPanel.setLayout(bottomLayout);

        messageLabel = new JLabel("Button Clicked:");
        buttonPressedLabel = new JLabel();

        bottomPanel.add(messageLabel);
        bottomPanel.add(buttonPressedLabel);

        add(bottomPanel); //adding bottom panel to the frame

        setVisible(true);
    }
    public void actionPerformed (ActionEvent event) {
        String command = event.getActionCommand();

        int buttonNum = Integer.valueOf(command);

        if (!buttonPressed[buttonNum - 1]) {
            buttonPressedLabel.setText(command); //updating the text of this label
            buttonPressed[buttonNum - 1] = true;
        } else buttonPressedLabel.setText("Already pressed.");
    }
}