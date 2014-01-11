/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script;

import java.util.LinkedList;

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class ScriptClass extends ScriptObject {
	
	/* The script module this class is in */
	public ScriptModule scriptModule;
	
	/* The public variables */
	public LinkedList<ScriptVariable> publicVariables;
	
	/* The methods within this class */
	public LinkedList<ScriptMethod> methods;
	
	/* The constructor */
	public ScriptClass(String name , Visibility visibility , ScriptModule scriptModule , LinkedList<String> code) {
		//Call the super constructor
		super(name , visibility);
		//Assign the variables
		this.scriptModule = scriptModule;
		this.publicVariables = new LinkedList<ScriptVariable>();
		this.methods = new LinkedList<ScriptMethod>();
		//Parse all of the methods
		this.methods = ScriptParser.parseMethods(code , this.scriptModule.syntax , this);
		//The inMethod boolean
		boolean inMethod = false;
		//Create any variables
		for (int a = 0; a < code.size(); a++) {
			//Split the current line
			String[] split = code.get(a).split(" ");
			//Check if the split has at least one value
			if (split.length > 0) {
				//Check if the first split is the method key word
				if (split[0].equals(this.scriptModule.syntax.SYNTAX_KEY_WORD_METHOD))
					//Set inMethod to true
					inMethod = true;
				else if (split.length > 1) {
					if (split[1].equals(this.scriptModule.syntax.SYNTAX_KEY_WORD_METHOD))
						//Set inMethod to true
						inMethod = true;
				}
			}
			//Check if the current line is defining a variable
			if (((split.length > 0 && split[0].equals(this.scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_DECLARATION)) ||
					(split.length > 1 && split[1].equals(this.scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_DECLARATION))) && ! inMethod)
				//Interpret the variable
				ScriptParser.parseVariable(split , this.publicVariables , this.scriptModule.syntax , false);
		}
	}
	
	/* The method that returns a method based on its name */
	public ScriptMethod getMethodByName(String name) {
		//The script method
		ScriptMethod method = null;
		//Look at all of the methods
		for (int a = 0; a < this.methods.size(); a++) {
			//Check if the current method has the correct name
			if (this.methods.get(a).name.equals(name.substring(0 , name.indexOf("(")) + "()") && this.methods.get(a).arguments.length == name.substring(name.indexOf("(") , name.length() - 1).split(",").length)
				//Assign the method
				method = this.methods.get(a);
		}
		//Check whether the method was found
		if (scriptModule == null)
			//Log an error
			Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion , "ScriptClass: The method with the name " + name + " was not found" , LogType.ERROR));
		//Return the method
		return method;
	}
	
}