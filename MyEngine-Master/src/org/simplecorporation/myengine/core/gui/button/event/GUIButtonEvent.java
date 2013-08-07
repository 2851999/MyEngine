/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.button.event;

import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.input.event.Event;

public class GUIButtonEvent extends Event {
	
	/* The name of the event */
	public static final String EVENT_NAME = "GUIButtonEvent";
	
	/* The description of the event */
	public static final String EVENT_DESCRIPTION = "Event made by a Button";
	
	/* The button that called the event */
	public GUIButton button;
	
	/* The name of the button that called the event */
	public String buttonName;
	
	/* The constructor of the event */
	public GUIButtonEvent(GUIButton button , String buttonName) {
		//Call the super constructor
		super(EVENT_NAME , EVENT_DESCRIPTION);
		//Assign the variables
		this.button = button;
		this.buttonName = buttonName;
	}
	
	/* Returns the button */
	public GUIButton getButton() {
		return this.button;
	}
	
	/* Returns the button name */
	public String getButtonName() {
		return this.buttonName;
	}
	
}