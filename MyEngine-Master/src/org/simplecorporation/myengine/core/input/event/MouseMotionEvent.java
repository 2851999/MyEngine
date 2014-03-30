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
 * The MouseMotionEvent <code>class</code> stores information about a mouse motion
 * event
 */
public class MouseMotionEvent extends Event {
	
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
	
	/* The start position of the mouse */
	/**
	 * The starting x position of the mouse motion event
	 */
	public double startx;
	/**
	 * The starting y position of the mouse motion event
	 */
	public double starty;
	/* The end position of the mouse */
	/**
	 * The ending x position of the mouse motion event
	 */
	public double endx;
	/**
	 * The ending y position of the mouse motion event
	 */
	public double endy;
	/* The delta x and the delta y */
	/**
	 * The change in x position of the mouse motion event calculated
	 * by using endx - startx
	 */
	public double dx;
	/**
	 * The change in y position of the mouse motion event calculated
	 * by using endy - starty
	 */
	public double dy;
	
	/* The constructor */
	/**
	 * This constructor takes the event's mouse starting position and the mouse
	 * ending position of the mouse motion event and creates an Event
	 * @param startx The starting x position of the mouse
	 * @param starty The starting y position of the mouse
	 * @param endx   The ending x position of the mouse
	 * @param endy   The ending y position of the mouse
	 */
	public MouseMotionEvent(double startx , double starty , double endx , double endy) {
		//Call the super constructor
		super(EVENT_NAME , EVENT_DESCRIPTION);
		//Assign all the variables
		this.startx = startx;
		this.starty = starty;
		this.endx = endx;
		this.endy = endy;
		this.dx = endx - startx;
		this.dy = endy - starty;
	}
	
}