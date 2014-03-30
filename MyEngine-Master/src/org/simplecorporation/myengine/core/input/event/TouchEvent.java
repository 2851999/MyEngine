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
 * The TouchEvent <code>class</code> stores information about a touch event (Android)
 */
public class TouchEvent extends Event {
	
	/* The event down */
	public static final int EVENT_DOWN = 0;
	
	/* The event up */
	public static final int EVENT_UP = 1;
	
	/* The name of the event */
	/**
	 * This string is the name of this event used by the Event <code>class</code>.
	 * Used to identify what kind of event this is.
	 * @see Event
	 */
	public static final String EVENT_NAME = "Touch Event";
	
	/* The description of the event */
	/**
	 * This string is the description of this event used by the Event
	 * <code>class</code>
	 * @see Event
	 */
	public static final String EVENT_DESCRIPTION = "Event from android";
	
	/* Is the touch direction */
	/**
	 * A boolean representing whether the touch was going down
	 */
	public boolean isDown = false;
	/**
	 * A boolean representing whether the touch was going up
	 */
	public boolean isUp = false;
	
	/* The last and current position of the touch event */
	/**
	 * The x position of the touch event
	 */
	public double x;
	/**
	 * The y position of the touch event
	 */
	public double y;
	
	/* The constructor for a button pressed/released/clicked event */
	/**
	 * This constructor takes the event's direction and position  and creates an Event
	 * @param event The type of event representing the direction of the touch
	 * @param x     The x position of the touch event
	 * @param y     The y position of the touch event
	 */
	public TouchEvent(int event , double x , double y) {
		//Call the super constructor
		super(EVENT_NAME , EVENT_DESCRIPTION);
		//Check what button is pressed and assign it
		if (event == EVENT_DOWN)
			this.isDown = true;
		else if (event == EVENT_UP)
			this.isUp = true;
		//Assign the x and y position
		this.x = x;
		this.y = y;
	}
	
	/* The method to return the buttons's id */
	/**
	 * This method is used to get the direction of the event
	 * @return An integer representing the direction of the event
	 */
	public int getEvent() {
		//Check what button it is then return the value
		if (this.isDown)
			return EVENT_DOWN;
		else if (this.isUp)
			return EVENT_UP;
		else
			return -1;
	}
	
}