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
 * The ScrollEvent <code>class</code> stores information about a scroll event
 */
public class ScrollEvent extends Event {
	
	/* The name of the event */
	/**
	 * This string is the name of this event used by the Event <code>class</code>.
	 * Used to identify what kind of event this is.
	 * @see Event
	 */
	public static final String EVENT_NAME = "Scroll Event";
	
	/* The description of the event */
	/**
	 * This string is the description of this event used by the Event
	 * <code>class</code>
	 * @see Event
	 */
	public static final String EVENT_DESCRIPTION = "Scroll event from Android/PC";
	
	/* The distance x and the distance y */
	/**
	 * The distance of the scroll along the x axis
	 */
	public double distancex;
	/**
	 * The distance of the scroll along the y axis
	 */
	public double distancey;
	
	/* The constructor */
	/**
	 * This constructor takes the event's distance and creates an Event
	 * @param distancex The distance of the scroll along the x axis
	 * @param distancey The distance of the scroll along the y axis
	 */
	public ScrollEvent(double distancex , double distancey) {
		//Call the super constructor
		super(EVENT_NAME , EVENT_DESCRIPTION);
		//Assign all the variables
		this.distancex = distancex;
		this.distancey = distancey;
	}
	
}