/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script.library.game;

import org.simplecorporation.myengine.core.engine.script.ScriptClass;
import org.simplecorporation.myengine.core.engine.script.ScriptLibrary;
import org.simplecorporation.myengine.core.game.BaseGame;

public class LibraryGame extends ScriptLibrary {
	
	/* The library name */
	public static final String LIBRARY_NAME = "LibraryGame";
	
	/* The library description */
	public static final String LIBRARY_DESCRIPTION = "Library Game (The game library)";
	
	/* The library package */
	public static final String LIBRARY_PACKAGE = "org.sl.java.game.Game";
	
	/* The library reference */
	public static final String LIBRARY_REFERENCE = "Game";
	
	/* The library short reference */
	public static final String LIBRARY_SHORT_REFERENCE = "Game";
	
	/* An instance of the game */
	public BaseGame game;
	
	/* The constructor */
	public LibraryGame() {
		//Call the super constructor
		super(LIBRARY_NAME , LIBRARY_DESCRIPTION , LIBRARY_PACKAGE , LIBRARY_REFERENCE , LIBRARY_SHORT_REFERENCE);
	}
	
	/* The method used to parse code */
	public void parseCode(String line , ScriptClass scriptClass) {
		//Split the current line
		String[] split = line.split(" ");
		//Check the second split
		if (split[1].equals("create")) {
			//Create a new instance of the game
			this.game = new BaseGame();
			this.game.createGame();
		}
	}
	
	/* The method used to return a new instance of this library */
	public ScriptLibrary getInstance() {
		return new LibraryGame();
	}
	
}