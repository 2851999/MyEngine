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

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public abstract class ScriptLibrary {
	
	/**********************************************************************
	 * NOTE TO SELF
	 **********************************************************************
	 * Use libraries to do basic functions using syntax like:
	 * 
	 * BasicRenderer render rectangle 0 10 10 0
	 * 
	 * In code you will be able to import other files written in the
	 * Scripting language. Possible syntax:
	 * 
	 * Renderer.renderRectangle(0,10,10,0)
	 * 
	 * OR
	 * 
	 * Renderer renderer = new Renderer()
	 * renderer.renderRectangle(0,10,10,0)
	 * 
	 * And so on
	 */
	
	/* The name of the library */
	public String libraryName;
	
	/* The description of the library */
	public String libraryDescription;
	
	/* The package the library is in */
	public String libraryPackage;
	
	/* The reference of this library */
	public String libraryReference;
	
	/* The short hand reference of this library */
	public String libraryShortReference;
	
	/* The constructor */
	public ScriptLibrary(String libraryName, String libraryDescription , String libraryPackage ,
			String libraryReference , String libraryShortReference) {
		//Assign the variables
		this.libraryName = libraryName;
		this.libraryDescription = libraryDescription;
		this.libraryPackage = libraryPackage;
		this.libraryReference = libraryReference;
		this.libraryShortReference = libraryShortReference;
	}
	
	/* The method to get a string value from a split line */
	public String getStringValue(String[] split , int start) {
		//The string
		String string = "";
		//Check if the string is a string
		if (split[start].startsWith("\"")) {
			//Set the first part of the string
			string = split[start];
			//Check if the string is longer
			if (! split[start].endsWith("\"") || split[start].endsWith("\\" + "\"")) {
				//Loop to add all of the other parts of the string
				for (int a = start + 1; a < split.length; a++) {
					//Add the next part of the string
					string += " " + split[a];
				}
			} else {
				Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion ,
						"getStringValue() Invalid string (If using \" before a space make sure you put \\ infront of it" , LogType.ERROR));
			}
			//Remove the ""
			string = string.substring(1 , string.length() - 1);
		} else {
			//Log an error
			Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion , "The split " + split[start] + " is not part of a string" , LogType.ERROR));
		}
		//Return the string
		return string;
	}
	
	/* The method to parse a line of code */
	public abstract void parseCode(String line);
	
	/* The method that returns a new instance of itself */
	public abstract ScriptLibrary getInstance();
	
}