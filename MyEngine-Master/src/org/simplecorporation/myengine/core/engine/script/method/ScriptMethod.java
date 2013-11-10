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
			if (this.methodCode.get(a).startsWith(script.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_CALL)) {
				//The method name
				String methodName = currentLine.split(script.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_CALL + " ")[1];
				//Call the method
				script.callMethod(methodName);
			} else if ((! currentLine.startsWith(script.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_COMMENT)) &&
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
						this.importedLibraries.get(b).parseCode(script.scriptFile , currentLine , publicVariables , this.localVariables);
						//The library has been found
						libraryFound = true;
						//Exit the loop
						break;
					}
				}
				//Check if the library wasn't found
				if (! libraryFound) {
					if (this.methodCode.get(a).startsWith(script.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_VARIABLE_DECLARATION)) {
						//Split up the line
						String[] splitLine = this.methodCode.get(a).split(" ");
						//Get the variable name
						String variableName = splitLine[1];
						//The variables value
						String variableValue = "";
						//Set the variable value
						variableValue = getVariableValue(splitLine , 3);
						//Create, set and add the variable
						ScriptVariable variable = new ScriptVariable(variableName);
						variable.value = variableValue;
						this.localVariables.add(variable);
					} else if (isVariable(currentLine , publicVariables , this.localVariables)) {
						//Check the operation
						String[] splitLine = currentLine.split(" ");
						if (splitLine[1].equals("="))
							getVariable(splitLine[0] , publicVariables , this.localVariables).value = getVariableValue(splitLine , 2);
					} else {
						//Send the code to the default library
						defaultLibrary.parseCode(script.scriptFile , currentLine , publicVariables , this.localVariables);
					}
				}
			}
		}
	}
	
	/* The method to check if the start of a line is a variable */
	public boolean isVariable(String line , LinkedList<ScriptVariable> publicVariables , LinkedList<ScriptVariable> localVariables) {
		//The name of the possible variable
		String variableName = line.split(" ")[0];
		//Does the line start with a variable
		boolean isVariable = false;
		//Loop through the public variables
		for (int a = 0; a < publicVariables.size(); a++){
			//Check if the current variable has the right name
			if (publicVariables.get(a).name.equals(variableName))
				//Set is variable to true
				isVariable = true;
		}
		//Loop through the local variables
		for (int a = 0; a < localVariables.size(); a++){
			//Check if the current variable has the right name
			if (localVariables.get(a).name.equals(variableName))
				//Set is variable to true
				isVariable = true;
		}
		//Return the value
		return isVariable;
	}
	
	/* The method to get a variable */
	public ScriptVariable getVariable(String variableName , LinkedList<ScriptVariable> publicVariables , LinkedList<ScriptVariable> localVariables) {
		//The variable
		ScriptVariable variable = null;
		//Loop through the public variables
		for (int a = 0; a < publicVariables.size(); a++){
			//Check if the current variable has the right name
			if (publicVariables.get(a).name.equals(variableName))
				//Set is variable to true
				variable = publicVariables.get(a);
		}
		//Loop through the local variables
		for (int a = 0; a < localVariables.size(); a++){
			//Check if the current variable has the right name
			if (localVariables.get(a).name.equals(variableName))
				//Set is variable to true
				variable = localVariables.get(a);
		}
		//Return the variable
		return variable;
	}
	
	/* The method to get a variable's value from a line */
	public String getVariableValue(String[] splitLine , int start) {
		//The variable value
		String variableValue = "";
		//Set the variable value
		for (int b = start; b < splitLine.length; b++) {
			variableValue += splitLine[b] + " ";
		}
		//Clean up the value
		variableValue.trim();
		//Return the variables value
		return variableValue;
	}
	
	/* The method to check if a variable is a double */
	public boolean isDouble(String value) {
		//The boolean value
		boolean isDouble = false;
		try {
			Double.parseDouble(value);
			isDouble = true;
		} catch (NumberFormatException e) {
			isDouble = false;
		}
		//Return the value
		return isDouble;
	}
	
}