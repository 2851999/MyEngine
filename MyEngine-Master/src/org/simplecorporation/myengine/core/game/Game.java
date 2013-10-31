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

import java.util.LinkedList;

import org.simplecorporation.myengine.core.input.Input;
import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.input.event.MouseMotionEvent;
import org.simplecorporation.myengine.core.input.event.TouchEvent;
import org.simplecorporation.myengine.core.input.listener.InputListener;

public class Game extends AbstractGame implements InputListener {
	
	/* All of the instances of the GameMethods interface */
	public static LinkedList<GameMethodsInterface> gameMethodsInterfaces = new
			LinkedList<GameMethodsInterface>();
	
	/* The constructor */
	public Game() {
		
	}
	
	/* The method to create the game */
	public void createGame() {
		//Add this input listener
		Input.addListener(this);
		//Create the engine loop
		create();
	}
	
	/* Game method */
	public void gameCreated() {
		//Call all of the instances of GameMethods interfaces
		for (int a = 0; a < gameMethodsInterfaces.size(); a++)
			gameMethodsInterfaces.get(a).gameCreated();
	}
	
	/* Game method */
	public void gameStarted() {
		//Call all of the instances of GameMethods interfaces
		for (int a = 0; a < gameMethodsInterfaces.size(); a++)
			gameMethodsInterfaces.get(a).gameStarted();
	}
	
	/* Game method */
	public void gameUpdate() {
		//Call all of the instances of GameMethods interfaces
		for (int a = 0; a < gameMethodsInterfaces.size(); a++)
			gameMethodsInterfaces.get(a).gameUpdate();
	}
	
	/* Game method */
	public void gameRender() {
		//Call all of the instances of GameMethods interfaces
		for (int a = 0; a < gameMethodsInterfaces.size(); a++)
			gameMethodsInterfaces.get(a).gameRender();
	}
	
	/* Game method */
	public void gameStopped() {
		//Call all of the instances of GameMethods interfaces
		for (int a = 0; a < gameMethodsInterfaces.size(); a++)
			gameMethodsInterfaces.get(a).gameStopped();
	}
	
	/* Game method */
	public void gameClosing() {
		//Call all of the instances of GameMethods interfaces
		for (int a = 0; a < gameMethodsInterfaces.size(); a++)
			gameMethodsInterfaces.get(a).gameClosing();
	}
	
	/* Input method */
	public void onMousePressed(MouseEvent e) {
		
	}
	
	/* Input method */
	public void onMouseReleased(MouseEvent e) {
		
	}
	
	/* Input method */
	public void onMouseClicked(MouseEvent e) {
		
	}
	
	/* Input method */
	public void onMouseMoved(MouseMotionEvent e) {
		
	}
	
	/* Input method */
	public void onKeyPressed(KeyboardEvent e) {
		
	}
	
	/* Input method */
	public void onKeyReleased(KeyboardEvent e) {
		
	}
	
	/* Input method */
	public void onKeyTyped(KeyboardEvent e) {
		
	}
	
	/* Android input method */
	public void onTouch(TouchEvent e) {
		
	}
	
}