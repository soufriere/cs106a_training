package handout07Interactors;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.*;

import acm.graphics.*;
import acm.program.*;

@SuppressWarnings("serial")
public class BoxDiagram extends GraphicsProgram{

	public void init() {
		displayButtons();
		addActionListeners();

		//TODO make draggable
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("ADD")) {
			
			//create box
			GCompound canvasBox = createBox(tf.getText());
			
			//add box to HashMap
			map.put(tf.getText(), canvasBox);
			
			//add box to canvas
			int x = (int) (getWidth() - canvasBox.getWidth()) / 2;
			int y = (int) (getHeight() - canvasBox.getHeight()) / 2;
			add(canvasBox, x, y);
			
		} else if (e.getActionCommand().equals("REMOVE")) {
			
			//remove box with name
			if (map.get(tf.getText()) != null) {remove(map.get(tf.getText()));}; //if box exists, remove it 
			
		} else {
			
			for( String name: map.keySet() )
		    {
				remove(map.get(name));
		    }
		 
			
			
		}
		
	}

	private GCompound createBox(String text) {
		
		// GCompound
		GCompound box = new GCompound();
		
		// create GRect
		GRect rect = new GRect(BOX_WIDTH, BOX_HEIGHT);
		box.add(rect);
		
		// add GLabel
		GLabel label = new GLabel(text);
		int x = (int) (rect.getWidth() - label.getWidth()) / 2;
		int y = 30; //manual entry, somehow calculation didn't work as it does for width
		box.add(label, x, y);
		
		map.put(text, box);
		
		return box;
		
	}

	private void displayButtons() {
		
		//label
		add(new JLabel("Name:"), SOUTH);
		
		//textfield
		tf = new JTextField(30);
		tf.addActionListener(this);
		add(tf, SOUTH);
		
		//ADD REMOVE CLEAR
		add(new JButton("ADD"), SOUTH);
		add(new JButton("REMOVE"), SOUTH);
		add(new JButton("CLEAR"), SOUTH);
		
	}
	
	//IVARS
	private JTextField tf;
	public static final int BOX_WIDTH = 100;
	public static final int BOX_HEIGHT = 50;
	public HashMap<String, GCompound> map = new HashMap<String, GCompound>();

	
	
}
