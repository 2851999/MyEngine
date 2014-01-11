/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script;

public abstract class ScriptLibrary {
	/* ********************************************************************
	 * NOTE TO SELF
	 * ********************************************************************
	 * Use libraries to do basic functions using syntax like:
	 * 
	 * BasicRenderer render rectangle 0 10 10 0
	 * 
	 * In code you will be able to import other files written in the
	 * Scripting language. Possible syntax:
	 * 
	 * Renderer.renderRectangle(0,10,10,0)
	 * 
	 * OR
	 * 
	 * Renderer renderer = new Renderer()
	 * renderer.renderRectangle(0,10,10,0)
	 * 
	 * And so on
	 */
	/* The name of the library */
	public String libraryName;
	
	/* The description of the library */
	public String libraryDescription;
	
	/* The package the library is in */
	public String libraryPackage;
	
	/* The reference of this library */
	public String libraryReference;
	
	/* The short hand reference of this library */
	public String libraryShortReference;
	
	/* The constructor */
	public ScriptLibrary(String libraryName, String libraryDescription , String libraryPackage ,
			String libraryReference , String libraryShortReference) {
		//Assign the variables
		this.libraryName = libraryName;
		this.libraryDescription = libraryDescription;
		this.libraryPackage = libraryPackage;
		this.libraryReference = libraryReference;
		this.libraryShortReference = libraryShortReference;
	}
	
	/* The method to parse a line of code */
	public abstract void parseCode(String line , ScriptClass scriptClass);
	
	/* The method that returns a new instance of itself */
	public abstract ScriptLibrary getInstance();
	
}