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

import org.simplecorporation.myengine.core.engine.script.file.ScriptFile;
import org.simplecorporation.myengine.core.engine.script.library.AbstractLibrary;
import org.simplecorporation.myengine.core.engine.script.method.ScriptMethod;
import org.simplecorporation.myengine.core.engine.script.parser.ScriptParser;
import org.simplecorporation.myengine.utils.logger.Logger;

public class Script {
	
	/* The script file */
	public ScriptFile scriptFile;
	
	/* The imported libraries */
	public LinkedList<AbstractLibrary> importedLibraries;
	
	/* The methods */
	public LinkedList<ScriptMethod> scriptMethods;
	
	/* The parser */
	public ScriptParser scriptParser;
	
	/* The constructor of the script */
	public Script(String filePath) {
		//Create the script file
		this.scriptFile = new ScriptFile(filePath);
		//Read the script file
		this.scriptFile.read();
		//Create the script parser
		this.scriptParser = new ScriptParser(scriptFile);
	}
	
	/* The method to parse the script */
	public void parse() {
		//Parse the imported libraries
		this.importedLibraries = this.scriptParser.parseImportedLibraries();
		//Parse the methods
		this.scriptMethods = this.scriptParser.parseMethods(this.importedLibraries);
	}
	
	/* The method to call a certain method */
	public void callMethod(String methodName) { 
		//The method
		ScriptMethod method = null;
		//Loop through all of the methods
		for (int a = 0; a < this.scriptMethods.size(); a++) {
			//Check the method name and see whether it matches
			if (this.scriptMethods.get(a).methodName.equals(methodName)) {
				//Set the method
				method = this.scriptMethods.get(a);
				//Exit the loop
				break;
			}
		}
		//Check that the method was found
		if (method == null)
			//Log a message
			Logger.log("Script callMethod()" , "The method " + methodName + " was not found");
		
		//Call the method
		method.callMethod(this);
	}
	
}