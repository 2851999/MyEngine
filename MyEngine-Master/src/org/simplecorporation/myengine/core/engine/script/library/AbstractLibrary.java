/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script.library;

public abstract class AbstractLibrary extends Library {
	
	/* The abstract method called to use code */
	public abstract void parseCode(String line);
	
	/* The constructor */
	public AbstractLibrary(String libraryName , String libraryDescription ,
			String libraryPackage , String libraryKeyword) {
		//Call the super constructor
		super(libraryName , libraryDescription , libraryPackage , libraryKeyword);
	}
	
}