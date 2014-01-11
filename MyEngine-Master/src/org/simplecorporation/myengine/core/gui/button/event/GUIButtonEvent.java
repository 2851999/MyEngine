/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.button.event;

import org.simplecorporation.myengine.core.event.Event;

public class GUIButtonEvent extends Event {
	
	/* The name of the event */
	public static final String EVENT_NAME = "GUIButtonEvent";
	
	/* The description of the event */
	public static final String EVENT_DESCRIPTION = "Event made by a Button";
	
	/* The name of the button that called the event */
	public String buttonName;
	
	/* The constructor of the event */
	public GUIButtonEvent(String buttonName) {
		//Call the super constructor
		super(EVENT_NAME , EVENT_DESCRIPTION);
		//Assign the variables
		this.buttonName = buttonName;
	}
	
	/* Returns the button name */
	public String getButtonName() {
		return this.buttonName;
	}
	
}