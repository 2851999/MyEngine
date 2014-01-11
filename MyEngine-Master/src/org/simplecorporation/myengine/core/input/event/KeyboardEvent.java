/* *********************************************
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

/**
 * The KeyboardEvent <code>class</code> stores information about a keyboard event
 */
public class KeyboardEvent extends Event {
	
	/* The name of the event */
	/**
	 * This string is the name of this event used by the Event <code>class</code>.
	 * Used to identify what kind of event this is.
	 * @see Event
	 */
	public static final String EVENT_NAME = "Keyboard Event";
	
	/* The description of the event */
	/**
	 * This string is the description of this event used by the Event
	 * <code>class</code>
	 * @see Event
	 */
	public static final String EVENT_DESCRIPTION = "Event from the keyboard";
	
	/* The key's char */
	/**
	 * This character is the character of the key associated with this KeyboardEvent
	 */
	public char keyChar;
	
	/* The key's code */
	/**
	 * This integer is the key code of the key associated with this KeyboardEvent
	 * in MyEngine format (Represented in KeyboardInput)
	 * @see KeyboardInput
	 */
	public int keyCode;
	
	/* The method to create a keyboard event */
	/**
	 * This constructor takes the event's key's character and key code and creates an
	 * Event
	 * @param keyChar The character of the key associated with this KeyboardEvent
	 * @param keyCode The integer value representing the key code of the key
	 *                associated with this KeyboardEvent
	 */
	public KeyboardEvent(char keyChar , int keyCode) {
		//Call the super constructor
		super(EVENT_NAME , EVENT_DESCRIPTION);
		//Assign the variables
		this.keyChar = keyChar;
		this.keyCode = keyCode;
	}
	
	/* Returns the key's character */
	/**
	 * This method returns the character of the key associated with this Event
	 * @return The character of the key associated with this Event
	 */
	public char getCharacter() {
		return this.keyChar;
	}
	
	/* Returns the key's code */
	/**
	 * This method returns the key code of the key associated with this Event
	 * @return The integer value representing the key code of the key
	 *         associated with this Event
	 */
	public int getCode() {
		return this.keyCode;
	}
	
}