/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.window;

import org.simplecorporation.myengine.core.event.Event;

public class WindowSizeChangedEvent extends Event {
	
	/* The name of the event */
	public static final String EVENT_NAME = "WindowSizeChanged Event";
	
	/* The description of the event */
	public static final String EVENT_DESCRIPTION = "Event from the Window";
	
	/* The windows old width */
	public float oldWidth;
	
	/* The windows old height */
	public float oldHeight;
	
	/* The windows new width */
	public float newWidth;
	
	/* The windows new height */
	public float newHeight;
	
	/* The windows change in width */
	public float changeWidth;
	
	/* The windows change in height */
	public float changeHeight;
	
	/* The method to create a keyboard event */
	public WindowSizeChangedEvent(float oldWidth , float oldHeight , float newWidth , float newHeight) {
		//Call the super constructor
		super(EVENT_NAME , EVENT_DESCRIPTION);
		//Assign the variables
		this.oldWidth = oldWidth;
		this.oldHeight = oldHeight;
		this.newWidth = newWidth;
		this.newHeight = newHeight;
		this.changeWidth = this.newWidth - this.oldWidth;
		this.changeHeight = this.newHeight - this.oldHeight;
	}
	
}