/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

//temp console

public class NameSurfer extends ConsoleProgram implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
	    
		//reading in of database
		
		// initialization of interactors
		
		nameField = new JTextField(30);
		nameField.addActionListener(this);
		JButton graphButton = new JButton ("Graph");
		JButton clearButton = new JButton ("Clear");
		
		add (new JLabel("Name: "), SOUTH);
		add (nameField, SOUTH);
		add (graphButton, SOUTH);
		add (clearButton, SOUTH);
		
		addActionListeners();
		
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(nameField)) chosenFirstName = nameField.getText();
		
		else if (e.getActionCommand().equals("Graph")) {
			chosenFirstName = nameField.getText();
			println("Graph: " + "\"" + chosenFirstName + "\"");
		}
			
		else if (e.getActionCommand().equals("Clear")) 
			println("Clear all.");
	}
	
	//INSTANCE VARIABLES
	private String chosenFirstName = "";
	private JTextField nameField;
}
