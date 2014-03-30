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
 * The MouseEvent <code>class</code> stores information about a mouse event
 */
public class MouseEvent extends Event {
	
	/* The name of the event */
	/**
	 * This string is the name of this event used by the Event <code>class</code>.
	 * Used to identify what kind of event this is.
	 * @see Event
	 */
	public static final String EVENT_NAME = "Mouse Event";
	
	/* The description of the event */
	/**
	 * This string is the description of this event used by the Event
	 * <code>class</code>
	 * @see Event
	 */
	public static final String EVENT_DESCRIPTION = "Event from the mouse";
	
	/* Is a mouse button down */
	/**
	 * A boolean value representing whether the left mouse button is down at the time
	 * this event was made
	 */
	public boolean isLeftButton = false;
	/**
	 * A boolean value representing whether the middle mouse button is down at the time
	 * this event was made
	 */
	public boolean isMiddleButton = false;
	/**
	 * A boolean value representing whether the right mouse button is down at the time
	 * this event was made
	 */
	public boolean isRightButton = false;
	
	/* The last and current position of the mouse */
	/**
	 * The x position of the position this event occurred on the screen
	 */
	public double x;
	/**
	 * The y position of the position this event occurred on the screen
	 */
	public double y;
	
	/* The constructor for a button pressed/released/clicked event */
	/**
	 * This constructor takes the event's mouse button position of the mouse event
	 * and creates an Event
	 * @param button An integer  value representing the button that is associated
	 *               with this Event
	 * @param x      The x position of where this event occurred on the screen
	 * @param y      The y position of where this event occurred on the screen
	 */
	public MouseEvent(int button , double x , double y) {
		//Call the super constructor
		super(EVENT_NAME , EVENT_DESCRIPTION);
		//Check what button is pressed and assign it
		if (button == 0)
			this.isLeftButton = true;
		else if (button == 1)
			this.isRightButton = true;
		else if (button == 2)
			this.isMiddleButton = true;
		//Assign the x and y position
		this.x = x;
		this.y = y;
	}
	
	/* The method to return the buttons's id */
	/**
	 * This method returns an integer value representing the mouse button that
	 * is associated with this Event
	 * @return An integer representing the mouse button that is associated with
	 *         this Event
	 */
	public int getButton() {
		//Check what button it is then return the value
		if (this.isLeftButton)
			return 0;
		else if (this.isRightButton)
			return 1;
		else if (this.isMiddleButton)
			return 2;
		else
			return -1;
	}
	
}