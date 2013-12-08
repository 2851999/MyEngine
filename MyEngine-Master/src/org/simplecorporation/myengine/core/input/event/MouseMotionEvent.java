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

import org.simplecorporation.myengine.core.event.Event;

public class MouseMotionEvent extends Event {
	
	/* The name of the event */
	public static final String EVENT_NAME = "Keyboard Event";
	
	/* The description of the event */
	public static final String EVENT_DESCRIPTION = "Event from the keyboard";
	
	/* The start position of the mouse */
	public double startx;
	public double starty;
	/* The end position of the mouse */
	public double endx;
	public double endy;
	/* The delta x and the delta y */
	public double dx;
	public double dy;
	
	/* The constructor */
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