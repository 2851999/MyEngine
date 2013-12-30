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

public class MouseEvent extends Event {
	
	/* The name of the event */
	public static final String EVENT_NAME = "Mouse Event";
	
	/* The description of the event */
	public static final String EVENT_DESCRIPTION = "Event from the mouse";
	
	/* Is a mouse button down */
	public boolean isLeftButton = false;
	public boolean isMiddleButton = false;
	public boolean isRightButton = false;
	
	/* The last and current position of the mouse */
	public double x;
	public double y;
	
	/* The constructor for a button pressed/released/clicked event */
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