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

public class MouseEvent {
	
	/* Is a mouse button down */
	public boolean isLeftButton = false;
	public boolean isMiddleButton = false;
	public boolean isRightButton = false;
	
	/* The last and current position of the mouse */
	public double x;
	public double y;
	
	/* The constructor for a button pressed/released/clicked event */
	public MouseEvent(int button , double x , double y) {
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
	
}