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
import java.util.Map;

import javax.swing.*;

@SuppressWarnings("serial")
public class NameSurfer extends Program implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
		
		graph = new NameSurferGraph();
		add(graph);
	    
		//reading in of database
		try {
			implementedDataBase = new NameSurferDataBase("names-data.txt");
		} catch (IOException e) {
			throw new ErrorException(e);
		}
		
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
		
		if (e.getSource().equals(nameField)) {
			graph.addEntry(implementedDataBase.findEntry(nameField.getText()));
                } else if (e.getActionCommand().equals("Graph")) {
            graph.addEntry(implementedDataBase.findEntry(nameField.getText()));
		} else if (e.getActionCommand().equals("Clear")) {
			graph.clear();
                }
	}
	
	//INSTANCE VARIABLES
	private TextField nameField;
	private NameSurferDataBase implementedDataBase;
	private NameSurferGraph graph;
}
