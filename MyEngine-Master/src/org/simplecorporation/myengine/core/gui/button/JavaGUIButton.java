/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.button;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.gui.button.event.GUIButtonEvent;
import org.simplecorporation.myengine.core.gui.button.listener.GUIButtonListener;
import org.simplecorporation.myengine.core.input.MouseInput;

public abstract class JavaGUIButton extends GUIButtonBase {
	
	/* The constructor */
	public JavaGUIButton(String name) {
		//Call the super constructor
		super(name);
		//Set selected and clicked to false
		this.selected = false;
		this.clicked = false;
		//Create the linked list
		this.listeners = new LinkedList<GUIButtonListener>();
	}
	
	/* The update method */
	protected void updateComponent() {
		//Check the mouse and see whether the button is selected
		if (this.getBounds().contains(MouseInput.x , MouseInput.y))
			//Set selected to true
			this.selected = true;
		else {
			//Set selected to false
			this.selected = false;
			//Check if the button is clicked
			if (this.clicked)
				//Set clicked to false
				this.clicked = false;
		}
		
		//Check if the button is down
		if (MouseInput.isButtonDown(0) && this.selected) {
			//Set clicked to true
			this.clicked = true;
			//Call the event
			for (int a = 0; a < this.listeners.size(); a++) {
				this.listeners.get(a).buttonClicked(new GUIButtonEvent(this.name));
			}
		} else
			//Set clicked to false
			this.clicked = false;
	}
	
	/* The method that returns whether the button is selected */
	public boolean isSelected() {
		//Check whether the button is visible
		if (this.visible)
			//Return the value
			return this.selected;
		else
			//Return false
			return false;
	}
	
}