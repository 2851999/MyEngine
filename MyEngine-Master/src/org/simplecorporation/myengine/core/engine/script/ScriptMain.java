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

public class ScriptMain {
	
	/* The constructor */
	public ScriptMain(String[] args) {
		//Check the arguments
		if (args.length == 0)
			//Create a new instance of the ScriptConsole
			new ScriptConsole();
	}
	
	/* The main method */
	public static void main(String[] args) {
		//Create a new instance of this class
		new ScriptMain(args);
	}
	
}