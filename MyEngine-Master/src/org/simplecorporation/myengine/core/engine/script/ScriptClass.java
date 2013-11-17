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
		//Create a parser object
		ScriptParser scriptParser = new ScriptParser();
		//Parse all of the methods
		this.methods = scriptParser.parseMethods(code , this.scriptModule.syntax , this);
	}
	
}