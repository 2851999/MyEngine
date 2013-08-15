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

import java.util.LinkedList;

import org.simplecorporation.myengine.core.engine.script.ScriptData;
import org.simplecorporation.myengine.core.engine.script.variable.ScriptVariable;
import org.simplecorporation.myengine.utils.logger.Logger;

public class LibraryLogger extends AbstractLibrary {
	
	/* The name of this library */
	public static final String NAME = "Logger";
	
	/* The description of this library */
	public static final String DESCRIPTION = "The Logger Library";
	
	/* The package of this library */
	public static final String PACKAGE = "org.simplecorporation.myengine.utils.logger.Logger";
	
	/* The key word of this library */
	public static final String KEYWORD = "Logger";
	
	/* The constructor */
	public LibraryLogger() {
		//Call the super constructor
		super(NAME , DESCRIPTION , PACKAGE , KEYWORD);
	}
	
	/* The method called to parse a line of code */
	public void parseCode(String line , LinkedList<ScriptVariable> publicVariables , LinkedList<ScriptVariable> localVariables) {
		//Replace the variables
		line = this.replaceVariables(line , publicVariables, localVariables);
		//Split up the line
		String[] splitLine = line.split(ScriptData.SYNTAX_KEY_WORD_SEPERATOR);
		//Check what the second key word is
		if (splitLine[1].equals("log")) {
			//Log a message
			Logger.log(getVariableValue(splitLine , 1) , getVariableValue(splitLine , 2));
		}
	}
	
}