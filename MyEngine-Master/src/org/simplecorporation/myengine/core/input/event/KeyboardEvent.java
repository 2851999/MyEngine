/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.input.event;

public class KeyboardEvent {
	
	/* The key's char */
	public char keyChar;
	
	/* The key's code */
	public int keyCode;
	
	/* The method to create a keyboard event */
	public KeyboardEvent(char keyChar , int keyCode) {
		//Assign the variables
		this.keyChar = keyChar;
		this.keyCode = keyCode;
	}
	
}