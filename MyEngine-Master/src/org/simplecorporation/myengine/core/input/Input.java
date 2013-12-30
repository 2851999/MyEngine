/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.input;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.input.event.MouseMotionEvent;
import org.simplecorporation.myengine.core.input.event.ScrollEvent;
import org.simplecorporation.myengine.core.input.event.TouchEvent;
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
	
	/* The method to call the on scroll method */
	public static void callOnScroll(ScrollEvent e) {
		//Call all of the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onScroll(e);
		}
	}
	
	/* The method to call the on touch method */
	public static void callOnTouch(TouchEvent e) {
		//Call all of the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onTouch(e);
		}
	}
	
}