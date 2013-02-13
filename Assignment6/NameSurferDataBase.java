/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

import java.io.*;
import java.util.HashMap;

import acm.util.ErrorException;

public class NameSurferDataBase implements NameSurferConstants {
	
/* Constructor: NameSurferDataBase(filename) */
/**
 * Creates a new NameSurferDataBase and initializes it using the
 * data in the specified file.  The constructor throws an error
 * exception if the requested file does not exist or if an error
 * occurs as the file is being read.
 * @throws IOException 
 */
	public NameSurferDataBase(String filename) throws IOException {
		
		BufferedReader br = null;
		database = new HashMap<String,NameSurferEntry>();
				
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(filename));
 
			while ((sCurrentLine = br.readLine()) != null) {
				currentEntry = new NameSurferEntry(sCurrentLine);
				String name = currentEntry.getName().toLowerCase();
				database.put(name,currentEntry);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
		
	
	
/* Method: findEntry(name) */
/**
 * Returns the NameSurferEntry associated with this name, if one
 * exists.  If the name does not appear in the database, this
 * method returns null.
 */
	public NameSurferEntry findEntry(String name) {
		if (database.get(name.toLowerCase()) == null) {
			return null;
		} else return database.get(name.toLowerCase());
		
	}
	
	
	public int HashMapSize() {
		return database.size();
	}
	
	public HashMap<String, NameSurferEntry> database;
	private NameSurferEntry currentEntry;
	
	
}


