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

public class ScriptVariable extends ScriptObject {
	
	/* The value of this variable */
	public String value;
	
	/* The constructor */
	public ScriptVariable(String name , Visibility visibility) {
		//Call the super constructor
		super(name , visibility);
		//Assign the variables
		this.value = "";
	}
	
}