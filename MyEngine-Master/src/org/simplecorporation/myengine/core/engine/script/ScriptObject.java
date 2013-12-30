/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script;

public class ScriptObject {
	
	/* The enum for the visibility of this object */
	public static enum Visibility {
		PUBLIC , PRIVATE
	}
	
	/* The name of this object */
	public String name;
	
	/* The visibility of this object */
	public Visibility visibility;
	
	/* The constructor */
	public ScriptObject(String name , Visibility visibility) {
		//Assign the variables
		this.name = name;
		this.visibility = visibility;
	}
	
}