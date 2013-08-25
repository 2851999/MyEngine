/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.android;

public interface AndroidGame {
	
	/* The method to create the game */
	public void createGame();
	
	/* The method to update the game */
	public void updateGame();
	
	/* The method to render the game */
	public void renderGame();
	
	/* The method to destroy the game */
	public void destroyGame();
	
}