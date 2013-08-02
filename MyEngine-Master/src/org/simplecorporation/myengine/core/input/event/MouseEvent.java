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

public class MouseEvent extends Event {
	
	/* The name of the event */
	private static final String NAME = "Mouse Event";
	
	/* The description of the event */
	private static final String DESCRIPTION = "A mouse event";
	
	/* Event variables */
	private int mouseX;
	private int mouseY;
	private int mouseLastX;
	private int mouseLastY;
	private int mouseChangeX;
	private int mouseChangeY;
	
	private boolean isClicked;
	private int buttonClicked;
	
	/* The default constructor */
	public MouseEvent() {
		super(NAME , DESCRIPTION);
	}
	
	/* The constructor for a mouse clicked event */
	public MouseEvent(int mouseX , int mouseY , int buttonClicked) {
		super(NAME , DESCRIPTION);
		
		//Assign the variables
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		this.buttonClicked = buttonClicked;
		this.isClicked = true;
	}
	
	/* The constructor for a mouse movement event */
	public MouseEvent(int mouseX , int mouseY , int mouseLastX , int mouseLastY) {
		super(NAME , DESCRIPTION);
		
		//Assign the variables
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		this.mouseLastX = mouseLastX;
		this.mouseLastY = mouseLastY;
		
		//Work out the change in the mouse position
		this.mouseChangeX = mouseX - mouseLastX;
		this.mouseChangeY = mouseY - mouseLastY;
	}
	
	/* Return the variables */
	public int getX() { return mouseX; }
	public int getY() { return mouseY; }
	public int getLastX() { return mouseLastX; }
	public int getLastY() { return mouseLastY; }
	public int getChangeX() { return mouseChangeX; }
	public int getChangeY() { return mouseChangeY; }
	
	public boolean isClicked() { return isClicked; }
	public int getButtonClicked() { return buttonClicked; }
	
}