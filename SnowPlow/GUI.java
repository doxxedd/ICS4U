package SnowPlow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//the GUI class inheriting the JFrame.
public class GUI extends JFrame implements ActionListener {
    
    //creating class or instance variables
    GridLayout topLayout;
    GridLayout bottomLayout;
    GridLayout frameLayout;

    JPanel topPanel;
    JPanel bottomPanel;

    JButton plowButton;
    JButton resetButton;

    JLabel arrayLabel;

    PlowMachine plowMachine;
    
    //GUI constructor 
    public GUI() {
        //configuring window properties
        setTitle("The Best Java Plow Machine (dark theme edition)");
        setSize(500,600);
        

        plowMachine = new PlowMachine(); //creating an instance of the PlowMachine class

        //applying GridLayout manager
        frameLayout = new GridLayout(2,1);
        setLayout(frameLayout);

        // Top layout
        topPanel = new JPanel();
        topLayout = new GridLayout(1,1);
        topPanel.setLayout(topLayout);
        topPanel.setBackground(Color.black);

        arrayLabel = new JLabel (plowMachine.arrayToHTMLFormat(), SwingConstants.CENTER);
        arrayLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        topPanel.add(arrayLabel);
        
        add(topPanel);


        // Bottom layout
        bottomPanel = new JPanel();
        bottomLayout = new GridLayout(2,1);
        bottomPanel.setLayout(bottomLayout);
        bottomPanel.setBackground(Color.black);

        plowButton = new JButton( new AbstractAction("Plow") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                plowMachine.plow();
                arrayLabel.setText(plowMachine.arrayToHTMLFormat());
            }
        });
        plowButton.setBackground(Color.black);
        plowButton.setForeground(Color.white);

        bottomPanel.add(plowButton);

        resetButton = new JButton( new AbstractAction("Reset") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                plowMachine.generateArray();
                arrayLabel.setText(plowMachine.arrayToHTMLFormat());
            }
        });
        resetButton.setBackground(Color.black);
        resetButton.setForeground(Color.white);

        bottomPanel.add(resetButton);

        add(bottomPanel);

        setVisible(true); 
    }

    //the code below alone should have worked instead the action method calling in the bottom layout configuration. not sure why it didn't 
    @Override
    public void actionPerformed (ActionEvent event) {
        // System.out.println("actionPerformed is called");
        // String command = event.getActionCommand();

        // if (command.equals("plow")) {
        //     System.out.println("Plow in if in actionPerformed");
        //     plowMachine.plow();
        //     arrayLabel.setText(plowMachine.arrayToHTMLFormat());
        // }
        // else if (command.equals("reset")) {
        //     plowMachine.generateArray();
        //     arrayLabel.setText(plowMachine.arrayToHTMLFormat());
        // }
    }
}
