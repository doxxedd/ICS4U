package GUI;

import javax.swing.*;
import java.awt.*;

public class BoxFrame extends JFrame{
    // declare all the relevant components/variables
	
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	
	BoxLayout frameLayout;
	JPanel panel;
	
	
	public BoxFrame() {
		setTitle("Box Demo");
		setSize(300, 200);
		
		panel = new JPanel();
		
		// create the buttons
		button1 = new JButton("Button 1");
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		button2 = new JButton("Button 2");
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		button3 = new JButton("Button 3");
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		button4 = new JButton("Long-named Button 4");
		button4.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		button5 = new JButton("5");
		button5.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// create the layout manager
		frameLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		
		
		panel.setLayout(frameLayout); // set the layout on the frame
		
		// add all the individual components
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		
		add(panel);
		
		
		setVisible(true);
		
	}
}
