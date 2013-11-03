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

public class TouchEvent extends Event {
	
	/* The event down */
	public static final int EVENT_DOWN = 0;
	
	/* The event up */
	public static final int EVENT_UP = 1;
	
	/* The name of the event */
	public static final String EVENT_NAME = "Touch Event";
	
	/* The description of the event */
	public static final String EVENT_DESCRIPTION = "Event from android";
	
	/* Is a mouse button down */
	public boolean isDown = false;
	public boolean isUp = false;
	
	/* The last and current position of the mouse */
	public double x;
	public double y;
	
	/* The constructor for a button pressed/released/clicked event */
	public TouchEvent(int event , double x , double y) {
		//Call the super constructor
		super(EVENT_NAME , EVENT_DESCRIPTION);
		//Check what button is pressed and assign it
		if (event == 0)
			this.isDown = true;
		else if (event == 1)
			this.isUp = true;
		//Assign the x and y position
		this.x = x;
		this.y = y;
	}
	
	/* The method to return the buttons's id */
	public int getEvent() {
		//Check what button it is then return the value
		if (this.isDown)
			return 0;
		else if (this.isUp)
			return 1;
		else
			return -1;
	}
	
}