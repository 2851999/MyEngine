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

import java.io.File;
import java.util.LinkedList;

import org.simplecorporation.myengine.utils.file.FileUtils;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class ScriptModule {
	
	/* The script this module belongs to */
	public Script script;
	
	/* The script file that contains the code used in this module */
	public ScriptFile file;
	
	/* The script syntax (PASS TO SCRIPTCLASS WHEN MAKING A CLASS) */
	public ScriptSyntax syntax;
	
	/* The package of the module */
	public String packageName;
	
	/* The classes within this module (ScriptFile) */
	public LinkedList<ScriptClass> classes;
	
	/* The imported libraries */
	public LinkedList<ScriptLibrary> importedLibraries;
	
	/* The constructor */
	public ScriptModule(Script script , ScriptFile file , boolean inFolder , String scriptDirectory) {
		//Assign the variables
		this.script = script;
		this.file = file;
		//Create the classes list
		this.classes = new LinkedList<ScriptClass>();
		//Create the imported libraries list
		this.importedLibraries = new LinkedList<ScriptLibrary>();
		//Check whether the file text linked list is equal to null
		if (this.file.fileText == null) {
			//Read the file the ScriptFile points to
			this.file.read();
		}
		//Create the script cleaner object
		ScriptCleaner scriptCleaner = new ScriptCleaner();
		//Remove all of the whitespace
		this.file.fileText = scriptCleaner.removeWhitespace(this.file.fileText);
		//Create the syntax
		this.syntax = new ScriptSyntax();
		//Check the first line of the code in this module
		if (this.file.fileText.get(0).startsWith("SYNTAX: ")) {
			//The syntax file path
			String syntaxFilePath = this.file.filePath.replace(new File(this.file.filePath).getName() , this.file.fileText.get(0).split(": ")[1]);
			//Set the syntax
			this.syntax.setSyntax(syntaxFilePath , true);
		}
		//Current count in the code
		int count = 0;
		//Set the package name
		this.packageName = "";
		//While loop (Run until inside class)
		while (! this.file.fileText.get(count).startsWith(this.syntax.SYNTAX_KEY_WORD_PUBLIC) &&
				! this.file.fileText.get(count).startsWith(this.syntax.SYNTAX_KEY_WORD_PRIVATE)) {
			//Check if the current line starts with the import keyword
			if (this.file.fileText.get(count).startsWith(this.syntax.SYNTAX_KEY_WORD_IMPORT)) {
				//The imported library
				ScriptLibrary library = null;
				//Locate and set the library
				library = ScriptLibraries.getLibraryByPackage(this.file.fileText.get(count).split(" ")[1]);
				//Check if the library was found
				if (library == null) {
					//Check the package has been set
					if (packageName != null && ! packageName.equals("")) {
						//Get the location of the new module to add
						String newModuleLocation = FileUtils.asFileString(scriptDirectory);
						//Split the package by the .'s
						String[] split = this.file.fileText.get(count).split(" ")[1].split("\\.");
						//Add on to the module location
						for (int a = 0; a < split.length; a++) {
							newModuleLocation += "\\" + split[a];
						}
						//Check if the location exists
						if (! FileUtils.doesExist(newModuleLocation + ".sl")) {
							//Make sure inFolder is false
							inFolder = false;
							//Set the location of the new module to add
							newModuleLocation = "/scriptfiles";
							//Split the package by the .'s
							split = this.file.fileText.get(count).split(" ")[1].split("\\.");
							//Add on to the module location
							for (int a = 0; a < split.length; a++) {
								newModuleLocation += "\\" + split[a];
							}
						}
						//Add a new module to the modules
						script.scriptModules.add(new ScriptModule(script , new ScriptFile(newModuleLocation + ".sl" , inFolder) , inFolder , scriptDirectory));
						//Check whether the script module was added correctly
						if (script.scriptModules.getLast() == null)
							//Log an error
							Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion , "ScriptModule The library/module with the package " +
									newModuleLocation + ".sl was not found" , LogType.ERROR));
					} else {
						//Log an error
						Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion , "ScriptModule package must be set before any imports" , LogType.ERROR));
					}
				} else {
					//Add a new instance of the library
					this.importedLibraries.add(library.getInstance());
				}
		} else if (this.file.fileText.get(count).startsWith(this.syntax.SYNTAX_KEY_WORD_PACKAGE))
				//Set the package name
				this.packageName = this.file.fileText.get(count).split(" ")[1];
			//Add 1 to the count
			count ++;
		}
		//Parse the classes
		this.classes = ScriptParser.parseClasses(this.file.fileText , syntax , this);
	}
	
	/* The method to get a class from its name */
	public ScriptClass getClassByName(String name) {
		//The script class
		ScriptClass scriptClass = null;
		//Search all of the classes in this module
		for (int a = 0; a < this.classes.size(); a++) {
			//Check the current classes name
			if (this.classes.get(a).name.equals(name))
				//Assign the script class
				scriptClass = this.classes.get(a);
		}
		//Check if the script class was found
		if (scriptClass == null)
			//Log an error
			Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion, "getClassByName() the class " + name +
					" was not found in the module " + new File(this.file.filePath).getName() , LogType.ERROR));
		//Return the script class
		return scriptClass;
	}
	
	/* The method to get a method from its name */
	public ScriptMethod getMethodByName(String name) {
		//The method
		ScriptMethod scriptMethod = null;
		//Search all of the classes in this module
		for (int a = 0; a < this.classes.size(); a++) {
			//Check the current classes methods
			for (int b = 0; b < this.classes.get(a).methods.size(); b++) {
				//Check the current methods name
				if (this.classes.get(a).methods.get(b).name.equals(name))
					//Set the method
					scriptMethod = this.classes.get(a).methods.get(b);
			}
		}
		//Check if the script class was found
		if (scriptMethod == null)
			//Log an error
			Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion, "getMethodByName() the method " + name +
					" was not found in the module " + new File(this.file.filePath).getName() , LogType.ERROR));
		//Return the script class
		return scriptMethod;
	}
	
	/* The method that returns the module name */
	public String getName() {
		//Return the name of the file (Also remove the file extension)
		return new File(this.file.filePath).getName().split(".")[0];
	}
	
}