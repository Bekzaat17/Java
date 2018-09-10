package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class simpleGUI extends JFrame {

	private JButton button = new JButton("Press");
	private JTextField input = new JTextField("", 10);
	private JLabel label = new JLabel(" Input:");
	private JRadioButton radio1 = new JRadioButton("This");
	private JRadioButton radio2 = new JRadioButton("That");
	private JCheckBox check = new JCheckBox("Check", false);
	
	public simpleGUI () {
		super("Simple Example");
		this.setBounds(100, 100, 250, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3, 2, 2, 2));
		container.add(label);
		container.add(input);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		container.add(radio1);
		container.add(radio2);
		radio2.setSelected(true);
		container.add(check);
		container.add(button);
		button.addActionListener(new ButtonEventListener ());
	}

		class ButtonEventListener implements ActionListener {
			public void actionPerformed (ActionEvent e){
			String message = "";
			message = "Button was pressed\n"
					+ "InputText is: " + input.getText() + "\n"
					+ (radio1.isSelected() ? "This " : "That ") + "is selected\n"
					+ "Checkbox is " + (check.isSelected() ? "checked" : "unchecked");
			JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
			}
			}
	}

