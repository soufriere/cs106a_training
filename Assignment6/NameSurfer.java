/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import acm.util.ErrorException;

import java.awt.TextField;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

//temp console

@SuppressWarnings("serial")
public class NameSurfer extends ConsoleProgram implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
	    
		//reading in of database
		try {
			NameSurferDataBase implementedDataBase = new NameSurferDataBase("names-data.txt");
		} catch (IOException e) {
			throw new ErrorException(e);
		}
		
		/*TEST CODE FOR STRING RETURNING AND NAMESURFERENTRY 
		 * String line = "Sam 0 1 2 3 4 5 6 7 8 9";
		 * NameSurferEntry Sam = new NameSurferEntry(line);*/
		
		// initialization of interactors
		nameField = new TextField(30);
		JButton graphButton = new JButton ("Graph");
		JButton clearButton = new JButton ("Clear");
		
		add (new JLabel("Name: "), SOUTH);
		add (nameField, SOUTH);
		add (graphButton, SOUTH);
		add (clearButton, SOUTH);
		
		addActionListeners();
		nameField.addActionListener(this);

	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(nameField)) {chosenFirstName = nameField.getText();
		
                } else if (e.getActionCommand().equals("Graph")) {
			chosenFirstName = nameField.getText();
			println("Graph: " + "\"" + chosenFirstName + "\"");
		} else if (e.getActionCommand().equals("Clear")) {
			println("Clear all.");
                }
	}
	
	//INSTANCE VARIABLES
	private String chosenFirstName = "";
	private TextField nameField;
}
