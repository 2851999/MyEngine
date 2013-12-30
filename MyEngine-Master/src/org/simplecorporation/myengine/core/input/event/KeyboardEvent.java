/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.input.event;

import org.simplecorporation.myengine.core.event.Event;

public class KeyboardEvent extends Event {
	
	/* The name of the event */
	public static final String EVENT_NAME = "Keyboard Event";
	
	/* The description of the event */
	public static final String EVENT_DESCRIPTION = "Event from the keyboard";
	
	/* The key's char */
	public char keyChar;
	
	/* The key's code */
	public int keyCode;
	
	/* The method to create a keyboard event */
	public KeyboardEvent(char keyChar , int keyCode) {
		//Call the super constructor
		super(EVENT_NAME , EVENT_DESCRIPTION);
		//Assign the variables
		this.keyChar = keyChar;
		this.keyCode = keyCode;
	}
	
	/* Returns the key's character */
	public char getCharacter() {
		return this.keyChar;
	}
	
	/* Returns the key's code */
	public int getCode() {
		return this.keyCode;
	}
	
}