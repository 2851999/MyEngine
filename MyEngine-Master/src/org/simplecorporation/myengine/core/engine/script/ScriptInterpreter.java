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

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class ScriptInterpreter {
	
	/* The constructor */
	public ScriptInterpreter() {
		
	}
	
	/* The method to interpret a line of code */
	public void interpretCode(String line , ScriptModule scriptModule , ScriptClass scriptClass , ScriptMethod scriptMethod ,
			LinkedList<ScriptVariable> variables , boolean inMethod) {
		//Check if the current line is a comment
		if (! line.startsWith(scriptModule.syntax.SYNTAX_COMMENT)) {
			//Split up the current line of code
			String[] split = line.split(" ");
			//Check each element in the list
			for (int a = 0; a < split.length; a++) {
				//Check if the current split is defining a variable
				//Make sure that $variable1 = $variable2 doesn't become "Value1" = "Value2"
				if (split[a].startsWith(scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_REFERNCE) && a != 0) {
					//Find the variable and put its value in the correct place
					split[a] = this.getVariable(split[a].substring(scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_REFERNCE.length()) ,
							scriptMethod.localVariables , scriptClass.publicVariables).value;
				}
			}
			//Check for a key word
			if ((split.length > 0 && split[0].equals(scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_DECLARATION)) ||
					(split.length > 1 && split[1].equals(scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_DECLARATION))) {
				//Parse the variable
				ScriptParser.parseVariable(split , variables , scriptModule.syntax , inMethod);
			} else {
				//Check the imported libraries for a key word
				for (int a = 0; a < scriptModule.importedLibraries.size(); a++) {
					//Check the current libraries key word against the first split of the code
					if (scriptModule.importedLibraries.get(a).libraryReference.equals(split[0]) ||
							scriptModule.importedLibraries.get(a).libraryShortReference.equals(split[0])) {
						//Recreate the line
						line = split[0];
						//Check if the list length is more than 1
						if (split.length > 1) {
							//Loop while there is more of the split left
							for (int b = 1; b < split.length; b++) {
								//Add onto the line
								line += " " + split[b];
							}
						}
						//Run the current line of code with the current library
						scriptModule.importedLibraries.get(a).parseCode(line);
					}
				}
			}
		}
	}
	
	/* The method to find a variable given its name */
	public ScriptVariable getVariable(String variableName , LinkedList<ScriptVariable> localVariables , LinkedList<ScriptVariable> publicVariables) {
		//The script variable
		ScriptVariable scriptVariable = null;
		//The boolean that represents whether the variable has been found
		boolean found = false;
		//Look at every local variable
		for (int a = 0; a < localVariables.size(); a++) {
			//Check the name of the current variable
			if (localVariables.get(a).name.equals(variableName)) {
				//Set the script variable
				scriptVariable = localVariables.get(a);
				//Set found to true
				found = true;
			}
		}
		//Check if the variable has already been found
		if (! found) {
			//Look at every public variable
			for (int a = 0; a < publicVariables.size(); a++) {
				//Check the name of the current variable
				if (publicVariables.get(a).name.equals(variableName)) {
					//Set the script variable
					scriptVariable = publicVariables.get(a);
					//Set found to true
					found = true;
				}
			}
		}
		//Check whether the script variable equals null
		if (scriptVariable == null) {
			//Log an error
			Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion , "ScriptParser getVariable() The variable with the name " + variableName + " was not found" , LogType.ERROR));
		}
		//Return the script variable
		return scriptVariable;
	}
	
}