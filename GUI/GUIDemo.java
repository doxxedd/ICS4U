package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIDemo extends JFrame { //class extending Jframe. turning the program into a program that is describing the frame
    
    //class or instance variables go here
    JButton okButton;
    JTextField text1;
    JTextField text2;
    JTextField text3;
    JLabel nameLabel;
    JPanel topPanel;
    JPanel bottomPanel;


    public GUIDemo() {
        setTitle("Hello World!");
        setSize(300,250);
        
        //applying basic layout manager
        setLayout(new FlowLayout());

        topPanel = new JPanel();

        //creating component
        JButton okButton = new JButton("ok");
        add(okButton); //adding the component to the frame


        //create 3 text fields
        text1 = new JTextField();
        text2 = new JTextField("Default Text");
        text3 = new JTextField(30);
        
        //create name label
        nameLabel = new JLabel("Name: ");

        //adding the text fields to the frame
        topPanel.add(text1);
        topPanel.add(text2);

        //add the whole panel to the frame
        add(topPanel);

        bottomPanel = new JPanel();
        bottomPanel.add(nameLabel);
        bottomPanel.add(text3);

        setVisible(true); //must be the last line of your constructor
    }
}