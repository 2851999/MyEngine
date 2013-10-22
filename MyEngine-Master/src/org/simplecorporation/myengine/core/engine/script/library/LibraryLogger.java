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

import org.simplecorporation.myengine.core.engine.script.file.ScriptFile;
import org.simplecorporation.myengine.core.engine.script.variable.ScriptVariable;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
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
	public void parseCode(ScriptFile currentFile , String currentLine , LinkedList<ScriptVariable> publicVariables , LinkedList<ScriptVariable> localVariables) {
		//Replace the variables
		currentLine = this.replaceVariables(currentFile , currentLine , publicVariables, localVariables);
		//Split up the line
		String[] splitLine = currentLine.split(currentFile.scriptSyntax.SYNTAX_KEY_WORD_SEPARATOR);
		//Check what the second key word is
		if (splitLine[1].equals("log")) {
			//The log type
			LogType logType = LogType.INFORMATION;
			//The string from the script
			String logTypeString = getVariableValue(splitLine , 3);
			//Check what log type to use
			if (logTypeString.equals("INFORMATION"))
				//Set the log type
				logType = LogType.INFORMATION;
			else if (logTypeString.equals("WARNING"))
				//Set the log type
				logType = LogType.WARNING;
			else if (logTypeString.equals("ERROR"))
				//Set the log type
				logType = LogType.ERROR;
			else if (logTypeString.equals("DEBUG"))
				//Set the log type
				logType = LogType.DEBUG;
			//Log a message
			Logger.log(new Log(getVariableValue(splitLine , 1) , getVariableValue(splitLine , 2) , logType));
		}
	}
	
}