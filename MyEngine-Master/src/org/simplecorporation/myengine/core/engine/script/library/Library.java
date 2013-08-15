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

public class Library {
	
	/* All the available libraries */
	public static LinkedList<AbstractLibrary> libraries = new LinkedList<AbstractLibrary>();
	
	/* The name of the library */
	public String libraryName;
	
	/* The description of the library */
	public String libraryDesctription;
	
	/* The package of the library */
	public String libraryPackage;
	
	/* The key word of the library */
	public String libraryKeyword;
	
	/* The constructor */
	public Library(String libraryName , String libraryDescription ,
			String libraryPackage , String libraryKeyword) {
		//Assign the variables
		this.libraryName = libraryName;
		this.libraryDesctription = libraryDescription;
		this.libraryPackage = libraryPackage;
		this.libraryKeyword = libraryKeyword;
	}
	
	/* The method that adds all of the libraries to the libraries
	   linked list */
	public static void findAndAddLibraries() {
		//Add the libraries
		libraries.add(new LibraryBasicRenderer());
		libraries.add(new LibraryLogger());
		libraries.add(new LibraryMessageBox());
	}
	
	/* The method to find and return a library given its package name */
	public static AbstractLibrary getLibrary(String libraryPackage) {
		//The library
		AbstractLibrary library = null;
		
		//Loop through the libraries
		for (int a = 0; a < libraries.size(); a++) {
			//Check if the current library has the right name
			if (libraries.get(a).libraryPackage.startsWith(libraryPackage)) {
				//Set the library
				library = libraries.get(a);
				//Exit the loop
				break;
			}
		}
		
		//Return the library
		return library;
	}
	
	/* The method to replace a variable if needed */
	public String replaceVariables(String currentLine , LinkedList<ScriptVariable> publicVariables , LinkedList<ScriptVariable> localVariables) {
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
					String variableValue = getVariable(variableName , publicVariables , localVariables).value;
					//Set the current split line
					splitLine[c] = variableValue;
				}
				//Add current split line to the current line
				currentLine += splitLine[c] + " ";
			}
		}
		//Return the line
		return currentLine;
	}
	
	/* The method to get a variable given its name */
	public ScriptVariable getVariable(String name , LinkedList<ScriptVariable> publicVariables , LinkedList<ScriptVariable> localVariables) {
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
		for (int b = 0; b < localVariables.size(); b++) {
			//Check the name
			if (localVariables.get(b).name.equals(name)) {
				//Set the variable
				variable = localVariables.get(b);
				//Exit the loop
				break;
			}
		}
		//Return the variable
		return variable;
	}
	
	/* The method to get a variable value from a variable string */
	public String getVariableValue(String[] variableString , int stringNum) {
		//The value
		String variableValue = "";
		//Continue?
		boolean shouldContinue = true;
		//Find the start
		int start = 0;
		int stringStartCount = 0;
		int stringEndCount = 0;
		int stringCount = 0;
		
		//Loop to find the start of the requested string
		for (int a = 0; a < variableString.length; a++) {
			if (variableString[a].startsWith("\"")) {
				stringStartCount ++;
				if (stringCount + 1 == stringNum)
					start = a;
			}
			if (variableString[a].endsWith("\"")) {
				stringEndCount ++;
				if (stringStartCount == stringEndCount && stringStartCount > 0)
					stringCount ++;
			}
		}
		
		//Loop
		for (int a = start; a < variableString.length; a++) {
			if (shouldContinue) {
				//Add the value
				variableValue += variableString[a] + " ";
				//Remove the "
				variableValue = variableValue.replaceAll("\"" , "");
				//Check if the current line ends with a "
				if (variableString[a].endsWith("\""))
					//Set should continue to false
					shouldContinue = false;
			}
		}
		//Trim
		variableValue = variableValue.trim();
		//Return the value
		return variableValue;
	}
	
}