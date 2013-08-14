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
			
			//Check if the line has a variable reference
			if (currentLine.contains(ScriptData.SYNTAX_KEY_WORD_VARIABLE_REFERENCE)) {
				//The split line
				String[] splitLine = currentLine.split(" ");
				//The variable name
				String variableName = "";
				//Set the current line to nothing
				currentLine = "";
				//Loop through the split line
				for (int c = 0; c < splitLine.length; c++) {
					//Check if this contains the variable
					if (splitLine[c].contains(ScriptData.SYNTAX_KEY_WORD_VARIABLE_REFERENCE)) {
						//Set the variable name
						variableName = splitLine[c].split(ScriptData.SYNTAX_KEY_WORD_VARIABLE_REFERENCE)[1];
						//The variable value
						String variableValue = getVariable(variableName , publicVariables).value;
						//Set the current split line
						splitLine[c] = variableValue;
					}
					//Add current split line to the current line
					currentLine += splitLine[c] + " ";
				}
			}
			
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
						this.importedLibraries.get(b).parseCode(currentLine);
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
							variableValue = splitLine[3];
						}
						//Create, set and add the variable
						ScriptVariable variable = new ScriptVariable(variableName);
						variable.value = variableValue;
						this.localVariables.add(variable);
					} else {
						//Send the code to the default library
						defaultLibrary.parseCode(currentLine);
					}
				}
			}
		}
	}
	
	/* The method to get a variable given its name */
	public ScriptVariable getVariable(String name , LinkedList<ScriptVariable> publicVariables) {
		//The variable
		ScriptVariable variable = null;
		//Loop through the public variables
		for (int a = 0; a < publicVariables.size(); a++) {
			//Check the name
			if (publicVariables.get(a).name.equals(name)) {
				//Set the variable
				variable = publicVariables.get(a);
				//Exit the loop
				break;
			}
		}
		//Loop through the public variables
		for (int b = 0; b < this.localVariables.size(); b++) {
			//Check the name
			if (this.localVariables.get(b).name.equals(name)) {
				//Set the variable
				variable = this.localVariables.get(b);
				//Exit the loop
				break;
			}
		}
		//Return the variable
		return variable;
	}
	
}