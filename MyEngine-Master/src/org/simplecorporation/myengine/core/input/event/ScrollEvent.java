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

public class ScrollEvent extends Event {
	
	/* The name of the event */
	public static final String EVENT_NAME = "Scroll Event";
	
	/* The description of the event */
	public static final String EVENT_DESCRIPTION = "Scroll event from Android/PC";
	
	/* The distance x and the distance y */
	public double distancex;
	public double distancey;
	
	/* The constructor */
	public ScrollEvent(double distancex , double distancey) {
		//Call the super constructor
		super(EVENT_NAME , EVENT_DESCRIPTION);
		//Assign all the variables
		this.distancex = distancex;
		this.distancey = distancey;
	}
	
}