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

import org.simplecorporation.myengine.core.engine.script.ScriptData;
import org.simplecorporation.myengine.core.engine.script.file.ScriptFile;
import org.simplecorporation.myengine.core.engine.script.library.AbstractLibrary;
import org.simplecorporation.myengine.core.engine.script.library.Library;
import org.simplecorporation.myengine.core.engine.script.method.ScriptMethod;
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
			if (fileText.get(a).startsWith(ScriptData.SYNTAX_KEY_WORD_IMPORT)) {
				//Get the import's name and add it to the imported libraries if possible
				AbstractLibrary library = null;
				//The library's package
				String libraryPackage = fileText.get(a).split(
						ScriptData.SYNTAX_KEY_WORD_IMPORT + " ")[1];
				//Get the library
				library = Library.getLibrary(libraryPackage);
				//Check if the library was found
				if (library == null)
					//Log a message
					Logger.log("ScriptParser.parseImportedLibraries()", "Library/Libraries not found " + libraryPackage);
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
			if (fileText.get(a).startsWith(ScriptData.SYNTAX_KEY_WORD_METHOD)) {
				//Get the method name
				String methodName = fileText.get(a).split(ScriptData.SYNTAX_KEY_WORD_METHOD + " ")[1];
				//Remove the declaration keyword from the method name but leave brackets
				//for passing data between method later on both using the script
				//to script and java to script possibly even script to java
				methodName = methodName.substring(0 , methodName.length() - 1);
				//The method code linked list
				LinkedList<String> methodCode = new LinkedList<String>();
				//The current line of the method
				int currentLine = a + 1;
				//While loop
				while (! fileText.get(currentLine).equals(ScriptData.SYNTAX_KEY_WORD_METHOD_END)) {
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
	
}