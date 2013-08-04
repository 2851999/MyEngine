/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game;

import org.simplecorporation.myengine.core.engine.loop.EngineLoop;

public abstract class AbstractGame extends EngineLoop {
	
	/* The abstract methods for a game */
	public abstract void gameCreated();
	public abstract void gameStarted();
	public abstract void gameUpdate();
	public abstract void gameRender();
	public abstract void gameStopped();
	public abstract void gameClosing();
	

	/* Method from engine loop */
	public void engineCreated() {
		//Call the method for the game
		this.gameCreated();
	}
	
	/* Method from engine loop */
	public void engineStarted() {
		//Call the method for the game
		this.gameStarted();
	}
	
	/* Method from engine loop */
	public void engineUpdate() {
		//Call the method for the game
		this.gameUpdate();
	}
	
	/* Method from engine loop */
	public void engineRender() {
		//Call the method for the game
		this.gameRender();
	}
	
	/* Method from engine loop */
	public void engineStopped() {
		//Call the method for the game
		this.gameStopped();
	}
	
	/* Method from engine loop */
	public void engineClosing() {
		//Call the method for the game
		this.gameClosing();
	}
	
}