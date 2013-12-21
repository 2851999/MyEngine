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
	
	/* The interpreter */
	public ScriptInterpreter interpreter;
	
	/* The different arguments */
	public String[] arguments;
	
	/* The constructor */
	public ScriptMethod(String name , Visibility visibility , ScriptClass scriptClass , LinkedList<String> code) {
		//Call the super constructor
		super(name.substring(0 , name.indexOf("(")) + "()" , visibility);
		//Assign the variables
		this.scriptClass = scriptClass;
		this.localVariables = new LinkedList<ScriptVariable>();
		this.code = code;
		//Create the interpreter
		this.interpreter = new ScriptInterpreter();
		//Create the different arguments
		this.arguments = name.substring(name.indexOf("(") + 1 , name.length() - 1).split(",");
	}
	
	/* The method to run this method */
	public void run(String[] newArguments) {
		//Clear all of the local variables
		this.localVariables = new LinkedList<ScriptVariable>();
		//Add the argument variables
		for (int a = 0; a < this.arguments.length; a++) {
			//Make sure the argument exists then make sure it is a variable and not another type of object
			if (! this.arguments[a].equals("") && this.arguments[a].startsWith(this.scriptClass.scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_REFERNCE)) {
				//The script variable
				ScriptVariable variable = new ScriptVariable(this.arguments[a].replace(this.scriptClass.scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_REFERNCE , "") , ScriptObject.Visibility.PRIVATE);
				//Set the value
				variable.value = newArguments[a];
				//Add the variable to the local variables
				this.localVariables.add(variable);
			}
		}
		//Run each line of code
		for (int a = 0; a < this.code.size(); a++) {
			//Run the current line of code using the interpreter
			this.interpreter.interpretCode(this.code.get(a) , this.scriptClass.scriptModule.script , this.scriptClass.scriptModule , this.scriptClass , this , this.localVariables , true);
		}
	}
	
}