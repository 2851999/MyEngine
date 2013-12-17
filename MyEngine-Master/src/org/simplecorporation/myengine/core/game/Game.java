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
import org.simplecorporation.myengine.core.input.event.ScrollEvent;
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
	
	/* The method to add a game method interface */
	public static void addGameMethodsInterface(GameMethodsInterface gameMethodsInterface) {
		//Add it to the list
		gameMethodsInterfaces.add(gameMethodsInterface);
	}
	
	/* Game method */
	public void gameCreated() {
		
	}
	
	/* Game method */
	public void gameStarted() {
		
	}
	
	/* Game method */
	public void gameUpdate() {
		
	}
	
	/* Game method */
	public void gameRender() {
		
	}
	
	/* Game method */
	public void gameStopped() {
		
	}
	
	/* Game method */
	public void gameClosing() {
		
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
	
	/* Input method */
	public void onScroll(ScrollEvent e) {
		
	}
	
	/* Android input method */
	public void onTouch(TouchEvent e) {
		
	}
	
}