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

public class Script {
	
	/* The modules in this script */
	public LinkedList<ScriptModule> scriptModules;
	
	/* The constructor */
	public Script(String scriptFile) {
		//Add all of the libraries
		ScriptLibraries.addAllLibraries();
		//Create the script modules linked list
		this.scriptModules = new LinkedList<ScriptModule>();
		//Get the main script module
		scriptModules.add(new ScriptModule(this , new ScriptFile(scriptFile)));
	}
	
	/* The constructor */
	public Script(String scriptDirectory , String mainModule) {
		//Add all of the libraries
		ScriptLibraries.addAllLibraries();
		//Create the script modules linked list
		this.scriptModules = new LinkedList<ScriptModule>();
		//The location of the main class
		String mainModulePath = scriptDirectory;
		//Check that it is in a package
		if (mainModule.contains(".")) {
			//Split the main class into its individual packages
			String[] packages = mainModule.split(".");
			//Look at every package
			for (int a = 0; a < packages.length; a++) {
				//Add the current package onto the main module path
				mainModulePath += "/" + packages[a];
			}
		} else {
			//Set the main module path 
			mainModulePath = scriptDirectory + "/" + mainModule;
		}
		//Get the main script module
		scriptModules.add(new ScriptModule(this , new ScriptFile(mainModulePath + ".sl")));
		//Run the main method in the main script module
		scriptModules.getLast().getMethodByName("main").run();
	}
	
}