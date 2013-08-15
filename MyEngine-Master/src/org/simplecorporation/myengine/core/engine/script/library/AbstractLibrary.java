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

import java.util.LinkedList;

import org.simplecorporation.myengine.core.engine.script.variable.ScriptVariable;

public abstract class AbstractLibrary extends Library {
	
	/* The abstract method called to use code */
	public abstract void parseCode(String line , LinkedList<ScriptVariable> publicVariables , LinkedList<ScriptVariable> localVariables);
	
	/* The constructor */
	public AbstractLibrary(String libraryName , String libraryDescription ,
			String libraryPackage , String libraryKeyword) {
		//Call the super constructor
		super(libraryName , libraryDescription , libraryPackage , libraryKeyword);
	}
	
}