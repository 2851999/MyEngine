/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android;

public interface AndroidGame {
	
	/* The method to create the game */
	public void gameCreated();
	
	/* The method to update the game */
	public void gameUpdate();
	
	/* The method to render the game */
	public void gameRender();
	
	/* The method to destroy the game */
	public void gameDestroy();
	
}