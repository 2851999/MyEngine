/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script;

import java.util.LinkedList;

public class ScriptCleaner {
	
	/* The constructor */
	public ScriptCleaner() {
		
	}
	
	/* The method to remove whitespace from the beginning and end
	 * of a line */
	public LinkedList<String> removeWhitespace(LinkedList<String> fileText) {
		//Go through all of the file text
		for (int a = 0; a < fileText.size(); a++) {
			//Check the beginning of the line for whitespace
			if (fileText.get(a).startsWith(" ") || fileText.get(a).startsWith("\t")) {
				//Remove all of the whitespace at the beginning of the current line
				while (fileText.get(a).startsWith(" ") || fileText.get(a).startsWith("\t"))
					fileText.set(a , fileText.get(a).substring(1 , fileText.get(a).length()));
			}
			if (fileText.get(a).endsWith(" ") || fileText.get(a).endsWith("\t")) {
				//Remove all of the whitespace at the end of the current line
				while (fileText.get(a).endsWith(" ") || fileText.get(a).endsWith("\t"))
					fileText.set(a , fileText.get(a).substring(0 , fileText.get(a).length() - 1));
			}
		}
		//Return the file text
		return fileText;
	}
	
}