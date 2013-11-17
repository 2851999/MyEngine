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

import org.simplecorporation.myengine.core.engine.script.library.LibrarySystem;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class ScriptLibraries {
	
	/* All of the available libraries */
	public static LinkedList<ScriptLibrary> libraries = new LinkedList<ScriptLibrary>();
	
	/* The method to locate and add all of the libraries */
	public static void addAllLibraries() {
		//Add all of the libraries
		libraries.add(new LibrarySystem());
	}
	
	/* The method to get a library by its package */
	public static ScriptLibrary getLibraryByPackage(String libraryPackage) {
		//The library
		ScriptLibrary scriptLibrary = null;
		//Look at all of the available libraries
		for (int a = 0; a < libraries.size(); a++) {
			//Check the package of the current library
			if (libraries.get(a).libraryPackage.startsWith(libraryPackage))
				//Assign the script library
				scriptLibrary = libraries.get(a);
		}
		//Check if the script library was found
		if (scriptLibrary == null) {
			//Log an error
			Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion , "getLibraryByPackage() The library with the package" +
					libraryPackage + " was not found" , LogType.ERROR));
		}
		//Return the script library
		return scriptLibrary;
	}
	
}