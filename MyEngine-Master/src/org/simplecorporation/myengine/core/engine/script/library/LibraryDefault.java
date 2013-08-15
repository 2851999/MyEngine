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

public class LibraryDefault extends Library {
	
	/* The constructor */
	public LibraryDefault() {
		super("LibraryDefault" , "" , "" , "");
	}
	
	/* The method called to parse a line of code */
	public void parseCode(String line , LinkedList<ScriptVariable> publicVariables , LinkedList<ScriptVariable> localVariables) {
		//Replace the variables
		line = this.replaceVariables(line , publicVariables, localVariables);
		//Split up the line
		String[] splitLine = line.split(ScriptData.SYNTAX_KEY_WORD_SEPERATOR);
		//Check the first key word
		if (splitLine[0].equals("System")) {
			//Check what the second key word is
			if (splitLine[1].equals("print")) {
				//Print out a message
				System.out.print(getVariableValue(splitLine , 1));
			} else if (splitLine[1].equals("println")) {
				//Print out a message
				System.out.println(getVariableValue(splitLine , 1));
			}
		}
	}
	
}