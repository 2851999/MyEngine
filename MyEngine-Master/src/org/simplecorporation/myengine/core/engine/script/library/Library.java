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

public class Library {
	
	/* All the available libraries */
	public static LinkedList<AbstractLibrary> libraries = new LinkedList<AbstractLibrary>();
	
	/* The name of the library */
	public String libraryName;
	
	/* The description of the library */
	public String libraryDesctription;
	
	/* The package of the library */
	public String libraryPackage;
	
	/* The key word of the library */
	public String libraryKeyword;
	
	/* The constructor */
	public Library(String libraryName , String libraryDescription ,
			String libraryPackage , String libraryKeyword) {
		//Assign the variables
		this.libraryName = libraryName;
		this.libraryDesctription = libraryDescription;
		this.libraryPackage = libraryPackage;
		this.libraryKeyword = libraryKeyword;
	}
	
	/* The method that adds all of the libraries to the libraries
	   linked list */
	public static void findAndAddLibraries() {
		//Add the libraries
		libraries.add(new LibraryBasicRenderer());
	}
	
	/* The method to find and return a library given its package name */
	public static AbstractLibrary getLibrary(String libraryPackage) {
		//The library
		AbstractLibrary library = null;
		
		//Loop through the libraries
		for (int a = 0; a < libraries.size(); a++) {
			//Check if the current library has the right name
			if (libraries.get(a).libraryPackage.startsWith(libraryPackage)) {
				//Set the library
				library = libraries.get(a);
				//Exit the loop
				break;
			}
		}
		
		//Return the library
		return library;
	}
	
}