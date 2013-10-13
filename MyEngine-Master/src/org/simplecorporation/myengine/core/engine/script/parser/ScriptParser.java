/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script.parser;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.engine.script.file.ScriptFile;
import org.simplecorporation.myengine.core.engine.script.library.AbstractLibrary;
import org.simplecorporation.myengine.core.engine.script.library.Library;
import org.simplecorporation.myengine.core.engine.script.method.ScriptMethod;
import org.simplecorporation.myengine.core.engine.script.variable.ScriptVariable;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class ScriptParser {
	
	/* The script file */
	public ScriptFile scriptFile;
	
	/* The constructor of the parser */
	public ScriptParser(ScriptFile scriptFile) {
		//Assign the script file
		this.scriptFile = scriptFile;
	}
	
	/* The method to parse the imported libraries */
	public LinkedList<AbstractLibrary> parseImportedLibraries() {
		//The imported libraries linked list
		LinkedList<AbstractLibrary> importedLibraries = new LinkedList<AbstractLibrary>();
		
		//Get the file text
		LinkedList<String> fileText = this.scriptFile.getFileText();
		
		//Loop through the text
		for (int a = 0; a < fileText.size(); a++) {
			//Check if the line starts with the import keyword
			if (fileText.get(a).startsWith(this.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_IMPORT)) {
				//Get the import's name and add it to the imported libraries if possible
				AbstractLibrary library = null;
				//The library's package
				String libraryPackage = fileText.get(a).split(
						this.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_IMPORT + " ")[1];
				//Get the library
				library = Library.getLibrary(libraryPackage);
				//Check if the library was found
				if (library == null)
					//Log a message
					Logger.log(new Log("ScriptParser.parseImportedLibraries()", "Library/Libraries not found " + libraryPackage , LogType.ERROR));
				//Add the library to the linked list
				importedLibraries.add(library);
			}
		}
		
		//Return the imported libraries
		return importedLibraries;
	}
	
	/* The method to parse the methods */
	public LinkedList<ScriptMethod> parseMethods(LinkedList<AbstractLibrary> importedLibraries) {
		//The methods linked list
		LinkedList<ScriptMethod> scriptMethods = new LinkedList<ScriptMethod>();
		
		//Get the file text
		LinkedList<String> fileText = this.scriptFile.getFileText();
		
		//Loop through the text
		for (int a = 0; a < fileText.size(); a++) {
			//Check if this current line is defining a method
			if (fileText.get(a).startsWith(this.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_METHOD)) {
				//Get the method name
				String methodName = fileText.get(a).split(this.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_METHOD + " ")[1];
				//Remove the declaration keyword from the method name but leave brackets
				//for passing data between method later on both using the script
				//to script and java to script possibly even script to java
				methodName = methodName.substring(0 , methodName.length() - 1);
				//The method code linked list
				LinkedList<String> methodCode = new LinkedList<String>();
				//The current line of the method
				int currentLine = a + 1;
				//While loop
				while (! fileText.get(currentLine).equals(this.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_METHOD_END)) {
					//Add the current line to the method code
					methodCode.add(fileText.get(currentLine));
					//Increment a
					currentLine++;
				}
				//Create the method and add it to the methods linked list
				scriptMethods.add(new ScriptMethod(methodName , methodCode ,
						importedLibraries , this));
			}
		}
		
		//Return the script methods
		return scriptMethods;
	}
	
	/* The method to parse the public variables */
	public LinkedList<ScriptVariable> parsePublicVariables() {
		//The variables linked list
		LinkedList<ScriptVariable> publicVariables = new LinkedList<ScriptVariable>();
		
		//The file text
		LinkedList<String> fileText = this.scriptFile.getFileText();
		
		//Boolean that states whether the parser is looking in a method
		boolean inMethod = false;
		
		//Loop through the file text
		for (int a = 0; a < fileText.size(); a++) {
			//Check if the parser is looking in a method
			if (fileText.get(a).startsWith(this.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_METHOD))
				//Set inMethod to true
				inMethod = true;
			else if (fileText.get(a).startsWith(this.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_METHOD_END))
				//Set inMethod to false
				inMethod = false;
			
			//Make sure the parser is not in a method
			if (! inMethod && ! fileText.get(a).startsWith(this.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_METHOD_END)) {
				//Check if a variable has been declared
				if (fileText.get(a).startsWith(this.scriptFile.scriptSyntax.SYNTAX_KEY_WORD_VARIABLE_DECLARATION)) {
					//Split up the line
					String[] splitLine = fileText.get(a).split(" ");
					//Get the variable name
					String variableName = splitLine[1];
					//The variables value
					String variableValue = "";
					//Check if the value has been set
					if (fileText.get(a).contains("=")) {
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
					publicVariables.add(variable);
				}
			}
		}
		
		//Return the public variables
		return publicVariables;
	}
	
}