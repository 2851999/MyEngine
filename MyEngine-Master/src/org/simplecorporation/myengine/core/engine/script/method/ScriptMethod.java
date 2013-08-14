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
import org.simplecorporation.myengine.core.engine.script.parser.ScriptParser;

public class ScriptMethod {
	
	/* The name of the method */
	public String methodName;
	
	/* The code in the method */
	public LinkedList<String> methodCode;
	
	/* The imported libraries */
	public LinkedList<AbstractLibrary> importedLibraries;
	
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
	public void callMethod(Script script) {
		//Loop through the method's code
		for (int a = 0; a < this.methodCode.size(); a++) {
			//Check the line of code
			if (this.methodCode.get(a).startsWith(ScriptData.SYNTAX_KEY_WORD_CALL)) {
				//The method name
				String methodName = this.methodCode.get(a).split(ScriptData.SYNTAX_KEY_WORD_CALL + " ")[1];
				//Call the method
				script.callMethod(methodName);
			} else if ((! this.methodCode.get(a).startsWith(ScriptData.SYNTAX_KEY_WORD_COMMENT)) &&
					(! this.methodCode.get(a).equals(""))) {
				//Get the first key word
				String firstKeyWord = this.methodCode.get(a).split(" ")[0];
				//Loop through the libraries
				for (int b = 0; b < this.importedLibraries.size(); b++) {
					//Check if the key word is correct
					if (this.importedLibraries.get(b).libraryKeyword.equals(firstKeyWord) ||
							this.importedLibraries.get(b).libraryName.equals(firstKeyWord)) {
						//Send the code to the library
						this.importedLibraries.get(b).parseCode(this.methodCode.get(a));
						//Exit the loop
						break;
					}
				}
			}
		}
	}
	
}