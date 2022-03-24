package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //for ActionListener

public class HelloWorldFrame extends JFrame implements ActionListener {
    // class level declaration of components
	JButton okButton;
	JTextField text1;
	JTextField text2;
	JTextField text3;
	
	JLabel nameLabel;
	
	JPanel topPanel;
	JPanel bottomPanel;
	
	public HelloWorldFrame() {
		setTitle("Hello World");
		setSize (300, 250);
		
		// apply basic layout manager for the frame
		setLayout(new FlowLayout());
		
		topPanel = new JPanel(); // create a panel
		
		// component creation
		okButton = new JButton("Ok");
		okButton.addActionListener(this); // adds the frame class as an action listener to the button
		
		
		topPanel.add(okButton); // add the component to the frame
		
		// create the 3 text fields
		text1 = new JTextField();
		text2 = new JTextField("Default Text");
		text3 = new JTextField(15);
		
		// create name label
		nameLabel = new JLabel("Name: ");
		
		// add the text fields to the frame
		topPanel.add(text1);
		topPanel.add(text2);
		
		// add the whole panel to the frame
		add(topPanel);
		
		// create bottom panel
		bottomPanel = new JPanel();
		
		bottomPanel.add(nameLabel);
		bottomPanel.add(text3);
		
		// add bottom panel to frame
		add(bottomPanel);
		
		setVisible(true); // MUST be the last line of your constructor!
	}
	
	// more methods that will do stuff for the user
	
	public void actionPerformed(ActionEvent event) {
	    String command = event.getActionCommand();
	   
	    if (command.equals("Ok")) {
	        System.out.println("ok button pressed");
	    }
    }
    
}