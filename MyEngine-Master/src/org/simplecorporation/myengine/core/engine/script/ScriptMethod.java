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

public class ScriptMethod extends ScriptObject {
	
	/* The class this method is in */
	public ScriptClass scriptClass;
	
	/* The local variables */
	public LinkedList<ScriptVariable> localVariables;
	
	/* The code within the method */
	public LinkedList<String> code;
	
	/* The parser */
	public ScriptParser parser;
	
	/* The constructor */
	public ScriptMethod(String name , Visibility visibility , ScriptClass scriptClass , LinkedList<String> code) {
		//Call the super constructor
		super(name , visibility);
		//Assign the variables
		this.scriptClass = scriptClass;
		this.localVariables = new LinkedList<ScriptVariable>();
		this.code = code;
		//Create the parser
		this.parser = new ScriptParser();
	}
	
	/* The method to run this method */
	public void run() {
		//Clear all of the local variables
		this.localVariables = new LinkedList<ScriptVariable>();
		//Run each line of code
		for (int a = 0; a < this.code.size(); a++) {
			//Run the current line of code using the parser
			this.parser.parseCode(this.code.get(a) , this.scriptClass.scriptModule , this.scriptClass , this , this.localVariables , true);
		}
	}
	
}