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

import java.util.LinkedList;

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class Script {
	
	/* The modules in this script */
	public LinkedList<ScriptModule> scriptModules;
	
	/* The constructor */
	public Script(String scriptDirectory , String mainModule , boolean inFolder) {
		//Add all of the libraries
		ScriptLibraries.addAllLibraries();
		//Create the script modules linked list
		this.scriptModules = new LinkedList<ScriptModule>();
		//The location of the main class
		String mainModulePath = scriptDirectory;
		//Check that it is in a package
		if (mainModule.contains(".")) {
			//Split the main class into its individual packages
			String[] packages = mainModule.split("\\.");
			//Look at every package
			for (int a = 0; a < packages.length; a++) {
				//Add the current package onto the main module path
				mainModulePath += "\\" + packages[a];
			}
		} else {
			//Set the main module path 
			mainModulePath = scriptDirectory + "\\" + mainModule;
		}
		//Get the main script module
		scriptModules.add(new ScriptModule(this , new ScriptFile(mainModulePath + ".sl" , inFolder) , inFolder , scriptDirectory));
		//Run the main method in the main script module
		scriptModules.getLast().getMethodByName("main()").run(null);
	}
	
	/* The method to run a specific method */
	public void runMethod(String moduleName , String className , String methodName) {
		//The class that has the method to be run
		ScriptClass scriptClass = this.getModuleByName(moduleName).getClassByName(className);
		//Run the method in the class
		scriptClass.getMethodByName(methodName).run(methodName.substring(methodName.indexOf("(") + 1 , methodName.length() - 1).split(","));
	}
	
	/* The method to run a specific class */
	public void runClass(String moduleName , String className) {
		//The class that has the method to be run
		ScriptClass scriptClass = this.getModuleByName(moduleName).getClassByName(className);
		//Run the method in the class
		scriptClass.getMethodByName("main()").run(null);
	}
	
	/* The method to run a specific module */
	public void runClass(String moduleName) {
		//The class that has the method to be run
		ScriptModule scriptModule = this.getModuleByName(moduleName);
		//Run the method in the class
		scriptModule.getMethodByName("main()").run(null);
	}
	
	/* The method that returns a class based on its name */
	public ScriptClass getClassByName(String name) {
		//The script class
		ScriptClass scriptClass = null;
		//Look at all of the modules
		for (int a = 0; a < this.scriptModules.size(); a++) {
			//Look at all of the classes
			for (int b = 0; b < this.scriptModules.get(a).classes.size(); b++) {
				//Check if the class has the right name
				if (this.scriptModules.get(a).classes.get(b).name.equals(name)) {
					//Set the class
					scriptClass = this.scriptModules.get(a).classes.get(b);
				}
			}
		}
		//Check whether the class was found
		if (scriptClass == null)
			//Log an error
			Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion , "Script: The class with the name " + name + " was not found" , LogType.ERROR));
		//Return the script class
		return scriptClass;
	}
	
	/* The method that returns a module based on its name */
	public ScriptModule getModuleByName(String name) {
		//The script module
		ScriptModule scriptModule = null;
		//Look at all of the modules
		for (int a = 0; a < this.scriptModules.size(); a++) {
			//Check if the current module has the right name
			if (this.scriptModules.get(a).getName().equals(name))
				//Assign the script module
				scriptModule = this.scriptModules.get(a);
		}
		//Check whether the module was found
		if (scriptModule == null)
			//Log an error
			Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion , "Script: The module with the name " + name + " was not found" , LogType.ERROR));
		//Return the script module
		return scriptModule;
	}
	
	/* The method that returns a module based on its package */
	public ScriptModule getModuleByPackage(String packageName) {
		//The script module
		ScriptModule scriptModule = null;
		//Look at all of the modules
		for (int a = 0; a < this.scriptModules.size(); a++) {
			//Check if the current module has the right package
			if (this.scriptModules.get(a).packageName.equals(packageName))
				//Assign the script module
				scriptModule = this.scriptModules.get(a);
		}
		//Check whether the module was found
		if (scriptModule == null)
			//Log an error
			Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion , "Script: The module with the package " + packageName + " was not found" , LogType.ERROR));
		//Return the script module
		return scriptModule;
	}
	
}