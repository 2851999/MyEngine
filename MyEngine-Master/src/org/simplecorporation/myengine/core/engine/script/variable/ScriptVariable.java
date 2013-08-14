/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script.variable;

public class ScriptVariable {
	
	/* The variables name */
	public String name;
	
	/* The variables value */
	public String value;
	
	/* The constructor of a variable */
	public ScriptVariable(String name) {
		//Assign the values
		this.name = name;
		this.value = "";
	}
	
}