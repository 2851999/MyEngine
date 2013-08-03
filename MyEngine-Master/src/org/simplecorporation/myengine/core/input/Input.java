/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.input;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.input.event.MouseMotionEvent;
import org.simplecorporation.myengine.core.input.listener.InputListener;

public class Input {
	
	/* The input listeners */
	public static LinkedList<InputListener> inputListeners = new LinkedList<InputListener>();
	
	/* The method to add an input listener */
	public static void addListener(InputListener listener) {
		//Add the listener
		inputListeners.add(listener);
	}
	
	/* The method to call a mouse pressed event */
	public static void callMousePressed(MouseEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onMousePressed(e);
		}
	}
	
	/* The method to call a mouse released event */
	public static void callMouseReleased(MouseEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onMouseReleased(e);
		}
	}
	
	/* The method to call a mouse clicked event */
	public static void callMouseClicked(MouseEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onMouseClicked(e);
		}
	}
	
	/* The method to call a mouse moved event */
	public static void callMouseMoved(MouseMotionEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onMouseMoved(e);
		}
	}
	
	/* The method to call a mouse dragged event */
	public static void callMouseDragged(MouseMotionEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onMouseDragged(e);
		}
	}
	
	/* The method to call a key pressed event */
	public static void callKeyPressed(KeyboardEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onKeyPressed(e);
		}
	}
	
	/* The method to call a key released event */
	public static void callKeyReleased(KeyboardEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onKeyReleased(e);
		}
	}
	
	/* The method to call a key typed event */
	public static void callKeyTyped(KeyboardEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onKeyTyped(e);
		}
	}
	
}