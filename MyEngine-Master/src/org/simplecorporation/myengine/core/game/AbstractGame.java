/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
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
		//Call all of the instances of GameMethods interfaces
		for (int a = 0; a < BaseGame.gameMethodsInterfaces.size(); a++)
			BaseGame.gameMethodsInterfaces.get(a).gameCreated();
	}
	
	/* Method from engine loop */
	public void engineStarted() {
		//Call the method for the game
		this.gameStarted();
		//Call all of the instances of GameMethods interfaces
		for (int a = 0; a < BaseGame.gameMethodsInterfaces.size(); a++)
			BaseGame.gameMethodsInterfaces.get(a).gameStarted();
	}
	
	/* Method from engine loop */
	public void engineUpdate() {
		//Call the method for the game
		this.gameUpdate();
		//Call all of the instances of GameMethods interfaces
		for (int a = 0; a < BaseGame.gameMethodsInterfaces.size(); a++)
			BaseGame.gameMethodsInterfaces.get(a).gameUpdate();
	}
	
	/* Method from engine loop */
	public void engineRender() {
		//Call the method for the game
		this.gameRender();
		//Call all of the instances of GameMethods interfaces
		for (int a = 0; a < BaseGame.gameMethodsInterfaces.size(); a++)
			BaseGame.gameMethodsInterfaces.get(a).gameRender();
	}
	
	/* Method from engine loop */
	public void engineStopped() {
		//Call the method for the game
		this.gameStopped();
		//Call all of the instances of GameMethods interfaces
		for (int a = 0; a < BaseGame.gameMethodsInterfaces.size(); a++)
			BaseGame.gameMethodsInterfaces.get(a).gameStopped();
	}
	
	/* Method from engine loop */
	public void engineClosing() {
		//Call the method for the game
		this.gameClosing();
		//Call all of the instances of GameMethods interfaces
		for (int a = 0; a < BaseGame.gameMethodsInterfaces.size(); a++)
			BaseGame.gameMethodsInterfaces.get(a).gameClosing();
	}
	
}