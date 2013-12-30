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

import org.simplecorporation.myengine.core.engine.script.library.game.LibraryBasicRenderer;
import org.simplecorporation.myengine.core.engine.script.library.game.LibraryGame;
import org.simplecorporation.myengine.core.engine.script.library.game.LibrarySettings;
import org.simplecorporation.myengine.core.engine.script.library.system.LibrarySystem;

public class ScriptLibraries {
	
	/* All of the available libraries */
	public static LinkedList<ScriptLibrary> libraries = new LinkedList<ScriptLibrary>();
	
	/* The method to locate and add all of the libraries */
	public static void addAllLibraries() {
		//Add all of the libraries
		libraries.add(new LibrarySystem());
		libraries.add(new LibraryGame());
		libraries.add(new LibrarySettings());
		libraries.add(new LibraryBasicRenderer());
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
		//Return the script library
		return scriptLibrary;
	}
	
}