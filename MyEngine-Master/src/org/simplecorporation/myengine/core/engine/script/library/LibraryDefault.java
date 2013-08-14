/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script.library;

import org.simplecorporation.myengine.core.engine.script.ScriptData;

public class LibraryDefault {
	
	/* The constructor */
	public LibraryDefault() {
		
	}
	
	/* The method called to parse a line of code */
	public void parseCode(String line) {
		//Split up the line
		String[] splitLine = line.split(ScriptData.SYNTAX_KEY_WORD_SEPERATOR);
		//Check the first key word
		if (splitLine[0].equals("System")) {
			//Check what the second key word is
			if (splitLine[1].equals("print")) {
				//Print out a message
				System.out.print(line.split("print ")[1]);
			} else if (splitLine[1].equals("println")) {
				//Print out a message
				System.out.println(line.split("println ")[1]);
			}
		}
	}
	
}