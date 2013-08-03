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

public class MouseMotionEvent {
	
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
		//Assign all the variables
		this.startx = startx;
		this.starty = starty;
		this.endx = endx;
		this.endy = endy;
		this.dx = endx - startx;
		this.dy = endy - starty;
	}
	
}