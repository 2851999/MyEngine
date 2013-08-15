/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script.method;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.engine.script.Script;
import org.simplecorporation.myengine.core.engine.script.ScriptData;
import org.simplecorporation.myengine.core.engine.script.library.AbstractLibrary;
import org.simplecorporation.myengine.core.engine.script.library.LibraryDefault;
import org.simplecorporation.myengine.core.engine.script.parser.ScriptParser;
import org.simplecorporation.myengine.core.engine.script.variable.ScriptVariable;

public class ScriptMethod {
	
	/* The name of the method */
	public String methodName;
	
	/* The code in the method */
	public LinkedList<String> methodCode;
	
	/* The imported libraries */
	public LinkedList<AbstractLibrary> importedLibraries;
	
	/* The local variables */
	public LinkedList<ScriptVariable> localVariables;
	
	/* The script parser */
	public ScriptParser scriptParser;
	
	/* The constructor */
	public ScriptMethod(String methodName , LinkedList<String> methodCode ,
			LinkedList<AbstractLibrary> importedLibraries , ScriptParser scriptParser) {
		
		//Assign the variables
		this.methodName = methodName;
		this.methodCode = methodCode;
		this.importedLibraries = importedLibraries;
		this.scriptParser = scriptParser;
	}
	
	/* The method to run the code in the method */
	public void callMethod(Script script , LibraryDefault defaultLibrary , LinkedList<ScriptVariable> publicVariables) {
		//Create and clear the local variables
		this.localVariables = new LinkedList<ScriptVariable>();
		this.localVariables.clear();
		//Loop through the method's code
		for (int a = 0; a < this.methodCode.size(); a++) {
			//The line of code to be parsed
			String currentLine = this.methodCode.get(a);
			
			//Check the line of code
			if (this.methodCode.get(a).startsWith(ScriptData.SYNTAX_KEY_WORD_CALL)) {
				//The method name
				String methodName = currentLine.split(ScriptData.SYNTAX_KEY_WORD_CALL + " ")[1];
				//Call the method
				script.callMethod(methodName);
			} else if ((! currentLine.startsWith(ScriptData.SYNTAX_KEY_WORD_COMMENT)) &&
					(! currentLine.equals(""))) {
				
				//Get the first key word
				String firstKeyWord = currentLine.split(" ")[0];
				
				//Has the library been found
				boolean libraryFound = false;
				//Loop through the libraries
				for (int b = 0; b < this.importedLibraries.size(); b++) {
					//Check if the key word is correct
					if (this.importedLibraries.get(b).libraryKeyword.equals(firstKeyWord) ||
							this.importedLibraries.get(b).libraryName.equals(firstKeyWord)) {
						
						//Send the code to the library
						this.importedLibraries.get(b).parseCode(currentLine , publicVariables , this.localVariables);
						//The library has been found
						libraryFound = true;
						//Exit the loop
						break;
					}
				}
				//Check if the library wasn't found
				if (! libraryFound) {
					if (this.methodCode.get(a).startsWith(ScriptData.SYNTAX_KEY_WORD_VARIABLE_DECLARATION)) {
						//Split up the line
						String[] splitLine = this.methodCode.get(a).split(" ");
						//Get the variable name
						String variableName = splitLine[1];
						//The variables value
						String variableValue = "";
						//Check if the value has been set
						if (this.methodCode.get(a).contains("=")) {
							//Set the variable value
							for (int b = 3; b < splitLine.length; b++) {
								variableValue += splitLine[b] + " ";
							}
							//Clean up the value
							variableValue.trim();
						}
						//Create, set and add the variable
						ScriptVariable variable = new ScriptVariable(variableName);
						variable.value = variableValue;
						this.localVariables.add(variable);
					} else {
						//Send the code to the default library
						defaultLibrary.parseCode(currentLine , publicVariables , this.localVariables);
					}
				}
			}
		}
	}
	
}