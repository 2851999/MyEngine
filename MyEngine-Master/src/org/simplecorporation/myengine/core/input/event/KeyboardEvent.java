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

public class KeyboardEvent extends Event {
	
	/* The name of the event */
	private static final String NAME = "Keyboard Event";
	
	/* The description of the event */
	private static final String DESCRIPTION = "A keyboard event";
	
	/* Event variables */
	private char lastCharPressed;
	private int lastKeyPressed;
	
	/* The default constructor */
	public KeyboardEvent() {
		super(NAME , DESCRIPTION);
	}
	
	/* The constructor for a key pressed/released event */
	public KeyboardEvent(char lastCharPressed , int lastKeyPressed) {
		super(NAME , DESCRIPTION);
		
		//Assign the variables
		this.lastCharPressed = lastCharPressed;
		this.lastKeyPressed = lastKeyPressed;
	}
	
	/* Return the variables */
	public char getKeyChar() { return lastCharPressed; }
	public int getKeyCode() { return lastKeyPressed; }
	
}