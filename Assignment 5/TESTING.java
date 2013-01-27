/** This program displays a histogram of 10-step categories from 0 to 100 in a TXT file
 * containing in each line one integer between 0 and 100.
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import acm.program.*;
import acm.util.*;

@SuppressWarnings("serial")

public class TESTING extends ConsoleProgram{
	
	
public void run() {
	
	int[] dice = {2,3,4,5,6};
	println("The score is "+ checkCategories(13, dice));
	
}
	
	private int checkCategories(int i, int[] dice) {

	//check the lower scores from 1 to 6

		if (i <= 6) {
			
			boolean contains = false;
			for (int oneDice : dice) {if (oneDice == i) contains = true;};
			if (contains == true) {
				
				int result = 0;
				for (int oneDice : dice) { //cycle through the dices
					
					if (oneDice == i) {	//for each dice that's equivalent to the category
						result += oneDice; //increment the result once
						}
					
				}
				return result;
				
			} else return 0;

		} else if (i == THREE_OF_A_KIND) {
			
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			for (Integer oneDice1 : dice) { 
				
				//assign the numbers on the dice to hashmap
				if (m.containsKey(oneDice1)) m.put(oneDice1, (m.get(oneDice1) + 1));
				else m.put(oneDice1, 1);
			}
				
				//check if contains number 3
				if (m.containsValue(3)) {
					int result = 0;
					for (Integer oneDice2 : dice) {result += oneDice2;};
					return result;
					}
				else return 0;
				
			} else if (i == FOUR_OF_A_KIND) {
				
				Map<Integer, Integer> m = new HashMap<Integer, Integer>();
				for (Integer oneDice3 : dice) { 
					
					//assign the numbers on the dice to hashmap
					if (m.containsKey(oneDice3)) m.put(oneDice3, (m.get(oneDice3) + 1));
					else m.put(oneDice3, 1);
				}
					
					//check if contains number 4
					if (m.containsValue(4)) {
						int result = 0;
						for (Integer oneDice4 : dice) {result += oneDice4;};
						return result;
						}
					else return 0;
		
		} else if (i == FULL_HOUSE) {
			
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			for (Integer oneDice5 : dice) { 
				
				//assign the numbers on the dice to hashmap
				if (m.containsKey(oneDice5)) m.put(oneDice5, (m.get(oneDice5) + 1));
				else m.put(oneDice5, 1);
			}
				
				//check if contains numbers 3 & 2
				if (m.containsValue(3) && m.containsValue(2)) {
					return 25;
					}
				else return 0;
				
		} else if (i == YAHTZEE) {
			
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			for (Integer oneDice6 : dice) { 
				
				//assign the numbers on the dice to hashmap
				if (m.containsKey(oneDice6)) {
					m.put(oneDice6, (m.get(oneDice6) + 1));
				}
				else m.put(oneDice6, 1);
			}
				
				//check if contains number 5
				if (m.containsValue(5)) {
					return 50;
					}
				else return 0;
				
		} else if (i == CHANCE) {
			int result = 0;
			for (Integer oneDice7 : dice) result += oneDice7;
			return result;
		
		} else if (i == SMALL_STRAIGHT) {
			for (int oneDice8 : dice) { 
					
				if (aContains(oneDice8, dice)
						&& aContains(oneDice8 + 1, dice)
						&& aContains(oneDice8 + 2, dice)
						&& aContains(oneDice8 + 3, dice)) {
					return 30;
				}
				else return 0;
			}
		
		} else if (i == LARGE_STRAIGHT) {
			for (int oneDice9 : dice) {
				if (aContains(oneDice9, dice)
						&& aContains(oneDice9 + 1, dice)
						&& aContains(oneDice9 + 2, dice)
						&& aContains(oneDice9 + 3, dice)
						&& aContains(oneDice9 + 4, dice)) {
					return 40;
				};
				};
			
				return 0;
			};
			
			return 0;
	}
	
	private boolean aContains(int i, int[] array) {
		for (int oneDice : array) {
			if (oneDice == i) {
				return true;
				}
		}
		return false;
	}
	
	public static final int ONES = 1;
	public static final int TWOS = 2;
	public static final int THREES = 3;
	public static final int FOURS = 4;
	public static final int FIVES = 5;
	public static final int SIXES = 6; 
	public static final int UPPER_SCORE = 7;
	public static final int UPPER_BONUS = 8;
	public static final int THREE_OF_A_KIND = 9;
	public static final int FOUR_OF_A_KIND = 10;
	public static final int FULL_HOUSE = 11;
	public static final int SMALL_STRAIGHT = 12;
	public static final int LARGE_STRAIGHT = 13;
	public static final int YAHTZEE = 14;
	public static final int CHANCE = 15;
	public static final int LOWER_SCORE = 16;
	public static final int TOTAL = 17;
	
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private int[] dice = new int[5];
	private RandomGenerator rgen = new RandomGenerator();

}
