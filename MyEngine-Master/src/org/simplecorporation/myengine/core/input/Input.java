/* *********************************************
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

/**
 * The Input <code>class</code> is a class composed of static fields and methods
 * used to store InputListener's and call events from within them
 * @see InputListener
 */
public class Input {
	
	/**
	 * This LinkedList stores all the input listeners added to Input
	 */
	/* The input listeners */
	public static LinkedList<InputListener> inputListeners = new LinkedList<InputListener>();
	
	/**
	 * Method used to add an InputListener
	 * @param listener An instance of InputListener
	 * @see InputListener
	 */
	/* The method to add an input listener */
	public static void addListener(InputListener listener) {
		//Add the listener
		inputListeners.add(listener);
	}
	
	/**
	 * Calls a MousePressed event in every InputListener stored in
	 * Input
	 * @param e The MouseEvent to pass to the InputListener's
	 */
	/* The method to call a mouse pressed event */
	public static void callMousePressed(MouseEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onMousePressed(e);
		}
	}
	
	/**
	 * Calls a MosueReleased event in every InputListener stored in
	 * Input
	 * @param e The MouseEvent to pass to the InputListener's
	 */
	/* The method to call a mouse released event */
	public static void callMouseReleased(MouseEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onMouseReleased(e);
		}
	}
	
	/**
	 * Calls a MouseClicked event in every InputListener stored in
	 * Input
	 * @param e The MouseEvent to pass to the InputListener's
	 */
	/* The method to call a mouse clicked event */
	public static void callMouseClicked(MouseEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onMouseClicked(e);
		}
	}
	
	/**
	 * Calls a MouseMoved event in every InputListener stored in
	 * Input
	 * @param e The MouseMotionEvent to pass to the InputListener's
	 */
	/* The method to call a mouse moved event */
	public static void callMouseMoved(MouseMotionEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onMouseMoved(e);
		}
	}
	
	/**
	 * Calls a KeyPressed event in every InputListener stored in
	 * Input
	 * @param e The KeyboardEvent to pass to the InputListener's
	 */
	/* The method to call a key pressed event */
	public static void callKeyPressed(KeyboardEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onKeyPressed(e);
		}
	}
	
	/**
	 * Calls a KeyReleased event in every InputListener stored in
	 * Input
	 * @param e The KeyboardEvent to pass to the InputListener's
	 */
	/* The method to call a key released event */
	public static void callKeyReleased(KeyboardEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onKeyReleased(e);
		}
	}
	
	/**
	 * Calls a KeyTyped event in every InputListener stored in
	 * Input
	 * @param e The KeyboardEvent to pass to the InputListener's
	 */
	/* The method to call a key typed event */
	public static void callKeyTyped(KeyboardEvent e) {
		//Call all the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onKeyTyped(e);
		}
	}
	
	/**
	 * Calls a scroll event in every InputListener stored in
	 * Input
	 * @param e The ScrollEvent to pass to the InputListener's
	 */
	/* The method to call the on scroll method */
	public static void callOnScroll(ScrollEvent e) {
		//Call all of the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onScroll(e);
		}
	}
	
	/**
	 * Calls a touch event in every InputListener stored in
	 * Input (Android)
	 * @param e The TouchEvent to pass to the InputListener's
	 */
	/* The method to call the on touch method */
	public static void callOnTouch(TouchEvent e) {
		//Call all of the listeners
		for (int a = 0; a < inputListeners.size(); a++) {
			inputListeners.get(a).onTouch(e);
		}
	}
	
}