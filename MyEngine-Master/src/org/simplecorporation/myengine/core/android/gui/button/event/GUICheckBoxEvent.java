/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android.gui.button.event;

import org.simplecorporation.myengine.core.android.gui.checkbox.GUICheckBox;
import org.simplecorporation.myengine.core.input.event.Event;

public class GUICheckBoxEvent extends Event {
	
	/* The name of the event */
	public static final String EVENT_NAME = "GUICheckBoxButtonEvent";
	
	/* The description of the event */
	public static final String EVENT_DESCRIPTION = "Event made when a check box is toggled";
	
	/* The button that called the event */
	public GUICheckBox checkBox;
	
	/* The name of the button that called the event */
	public String checkBoxName;
	
	/* Is it checked */
	public boolean checked;
	
	/* The constructor of the event */
	public GUICheckBoxEvent(GUICheckBox checkBox , String checkBoxName , boolean checked) {
		//Call the super constructor
		super(EVENT_NAME , EVENT_DESCRIPTION);
		//Assign the variables
		this.checkBox = checkBox;
		this.checkBoxName = checkBoxName;
	}
	
	/* Returns the button */
	public GUICheckBox getCheckBox() {
		return this.checkBox;
	}
	
	/* Returns the button name */
	public String getCheckBoxName() {
		return this.checkBoxName;
	}
	
	/* Returns whether the button is checked */
	public boolean isChecked() {
		return this.checked;
	}
	
}