/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

@SuppressWarnings("serial")
public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
		
		//initialise color arraylist
		for (int i = 0; i < 10; i++) {
		lineColors.add(Color.BLACK);
		lineColors.add(Color.RED);
		lineColors.add(Color.BLUE);
		lineColors.add(Color.MAGENTA);
		lineColors.add(Color.GREEN);
		}
		
		
		//	 You fill in the rest //
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		//displayedEntries.clear();
		
		ArrayList<NameSurferEntry> toRemove = new ArrayList<NameSurferEntry>();
	    for (NameSurferEntry e : displayedEntries) {
	        toRemove.add(e);
	    }
	    displayedEntries.removeAll(toRemove);
	    update();
		
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		displayedEntries.add(entry);
		update();
	}
	
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		
		//delete all objects
		removeAll();
		
		//reassemble display according to list of entries
		drawGrid();
		
		//draw any necessary entry lines
		drawEntryLines();
		
	}
	
	private void drawEntryLines() {
		
		//for every entry, draw a line, cycling through the colours
		for (int i = 0; i < displayedEntries.size(); i++) {
			
			NameSurferEntry currentEntry = displayedEntries.get(i);
			
			Color currentColor = lineColors.get(i+1); // IT DOES WORK :D
			
			double rankHeight = (getHeight() - 40.0) / 1000.0; // STUPID ME: NEVER DIVIDE A DOUBLE BY AN INTEGER; LOST 2 HOURS ON THIS PROBLEM
			double periodWidth = (getWidth() / 11);
			
			//create start point at height of corresponding rank
			GPoint currentPoint = new GPoint(periodWidth * 0, (rankHeight * currentEntry.getRank(0) + 20));
			//create the end point of the segment with the Y-rank of the next period
			GPoint nextPoint = new GPoint(periodWidth * 1, (rankHeight * currentEntry.getRank(1) + 20));
			
			for (int k = 0; k < 10; k++) {
				
				int rank = currentEntry.getRank(k);
				int nrank = currentEntry.getRank(k + 1);
				int n2rank = currentEntry.getRank(k + 2);
				
				//if the rank is 0, then set it's Y coordinate to be at the bottom of the graph
				if (rank == 0) {
					currentPoint.setLocation(periodWidth * k, (getHeight() - 20));
				}
				
				//if the rank is 0, then set it's Y coordinate to be at the bottom of the graph
				if (nrank == 0) {
					nextPoint.setLocation(periodWidth * (k + 1),
							(getHeight() - 20));
				} else {
					nextPoint.setLocation(nextPoint.getX(), 20 + (nrank * rankHeight));
				}
				
				//draw a segment from start point to end point
				GLine currentSegment = new GLine(currentPoint.getX(),
						currentPoint.getY(), nextPoint.getX(), nextPoint.getY());
				currentSegment.setColor(currentColor);
				add(currentSegment);
				
				//set and add label
				String labelText = currentEntry.getName();
				if (rank == 0) {
					labelText += " *";
				} else {
					labelText += " " + rank;
				}
				GLabel currentLabel = new GLabel(labelText);
				currentLabel.setColor(currentColor);
				
				GPoint labelPosition = new GPoint (currentPoint.getX() + 5, currentPoint.getY() - 10);
				
				add(currentLabel, labelPosition);
				
				currentPoint.setLocation(nextPoint.getX(), nextPoint.getY());
				nextPoint.setLocation(periodWidth * (k + 2), (rankHeight * n2rank + 20));
			}
			
		}
		
	}

	private void drawGrid() {
		
		//draw 11 vertical lines
		
		for (int i = 0; i < 11; i++) {
			GLine vline = new GLine((i * (getWidth()/11)), 0, (i * (getWidth()/11)), getHeight());
			add(vline);
		}
		
		//draw 2 horizontal lines
		
		add(new GLine(0, 20, getWidth(), 20));
		add(new GLine(0, getHeight() - 20, getWidth(), getHeight() - 20));
		
		//draw labels
		int decade = 1900;
		for (int i = 0; i < 11; i++) {
			add(new GLabel("" + (decade + (i * 10)), ((getWidth() / 11) * i) + 5, getHeight() - 5));
		}
		
	}

	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
	public static ArrayList<NameSurferEntry> displayedEntries = new ArrayList<NameSurferEntry>();
	private ArrayList<Color> lineColors = new ArrayList<Color>();

}
