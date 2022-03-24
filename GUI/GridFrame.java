package GUI;

import java.awt.*;
import javax.swing.*;

public class GridFrame extends JFrame {
    JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	
	JPanel panel1;
	JPanel panel2;

	GridLayout panel1Layout;
	GridLayout panel2Layout;
	GridLayout frameLayout;
	
	JLabel label1;
	JLabel label2;
	JTextField text1;
	JTextField text2;
	JButton button;

	public GridFrame() {
		setTitle("Grid Demo");
		setSize(500, 600);
		
		frameLayout = new GridLayout(2,1);
		setLayout(frameLayout);

		// create the buttons
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		button3 = new JButton("Button 3");
		button4 = new JButton("Long-named Button 4");
		button5 = new JButton("5");
		
		panel1 = new JPanel();
		
		panel1Layout = new GridLayout(3, 2);
				
		panel1.setLayout(panel1Layout); // apply the layout manager to the frame
		
		// add all the individual components
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		panel1.add(button5);
		
		// add panel 1 to frame
		add(panel1);
		
		// create and configure panel 2
		panel2 = new JPanel();
		panel2Layout = new GridLayout(2, 3);
		panel2.setLayout(panel2Layout);
		
		label1 = new JLabel("Label 1:");
		label2 = new JLabel("Label 2:");
		
		text1 = new JTextField(10);
		text2 = new JTextField(10);
		
		button = new JButton("Apply Changes");
		
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(new JLabel()); // empty label
		panel2.add(text1);
		panel2.add(text2);
		panel2.add(button);
		
		add(panel2);

		setVisible(true);
    }
    
}