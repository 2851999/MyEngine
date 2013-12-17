/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script.library.system;

import org.simplecorporation.myengine.core.engine.script.ScriptClass;
import org.simplecorporation.myengine.core.engine.script.ScriptInterpreter;
import org.simplecorporation.myengine.core.engine.script.ScriptLibrary;

public class LibrarySystem extends ScriptLibrary {
	
	/* The library name */
	public static final String LIBRARY_NAME = "LibrarySystem";
	
	/* The library description */
	public static final String LIBRARY_DESCRIPTION = "Library System (The system library)";
	
	/* The library package */
	public static final String LIBRARY_PACKAGE = "org.sl.java.system.System";
	
	/* The library reference */
	public static final String LIBRARY_REFERENCE = "System";
	
	/* The library short reference */
	public static final String LIBRARY_SHORT_REFERENCE = "System";
	
	/* The constructor */
	public LibrarySystem() {
		//Call the super constructor
		super(LIBRARY_NAME , LIBRARY_DESCRIPTION , LIBRARY_PACKAGE , LIBRARY_REFERENCE , LIBRARY_SHORT_REFERENCE);
	}
	
	/* The method used to parse code */
	public void parseCode(String line , ScriptClass scriptClass) {
		//Split the current line
		String[] split = line.split(" ");
		//Check the second split
		if (split[1].equals("println")) {
			System.out.println(ScriptInterpreter.getStringValue(split , 2));
		} else if (split[1].equals("print")) {
			System.out.print(ScriptInterpreter.getStringValue(split , 2));
		}
	}
	
	/* The method used to return a new instance of this library */
	public ScriptLibrary getInstance() {
		return new LibrarySystem();
	}
	
}