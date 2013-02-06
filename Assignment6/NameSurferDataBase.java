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
				String name = currentEntry.getName();
				//BREAKS HERE - NOW RESOLVED?
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
		
		/*BufferedReader rd = null;
			try {
				rd = new BufferedReader(new FileReader(filename));
			} catch (FileNotFoundException e2) {
				throw new ErrorException(e2);
			}
			
			while (true) {
				
					String line;
					
					try {
						line = rd.readLine();
						currentEntry = new NameSurferEntry(line);
						database.put(currentEntry.getName().toLowerCase(), currentEntry);
					} catch (IOException e) {
						rd.close();
						throw new ErrorException(e);
					}
					
					//BREAKS HERE
					
					if (line == null) {
						try {
							rd.close();
						} catch (IOException e1) {
							rd.close();
							throw new ErrorException(e1);
						}
						break;
					}
				}	*/
	}
		
	
	
/* Method: findEntry(name) */
/**
 * Returns the NameSurferEntry associated with this name, if one
 * exists.  If the name does not appear in the database, this
 * method returns null.
 */
	public NameSurferEntry findEntry(String name) {
		name = name.toLowerCase();
		if (database.get(name) != null) {
			return database.get(name);
		} else return null;
	}
	
	public HashMap<String,NameSurferEntry> database;
	private NameSurferEntry currentEntry;
	
	
}


