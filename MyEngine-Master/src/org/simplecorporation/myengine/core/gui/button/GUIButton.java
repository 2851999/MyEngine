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

import org.simplecorporation.myengine.core.gui.GUIComponent;
import org.simplecorporation.myengine.core.gui.button.event.GUIButtonEvent;
import org.simplecorporation.myengine.core.gui.button.listener.GUIButtonListener;
import org.simplecorporation.myengine.core.input.MouseInput;

public abstract class GUIButton extends GUIComponent {

	/* Is the button selected */
	public boolean selected;
	
	/* Is the button clicked */
	public boolean clicked;
	
	/* The button listeners */
	public LinkedList<GUIButtonListener> listeners;
	
	/* The constructor */
	public GUIButton(String name) {
		//Call the super constructor
		super(name);
		//Set selected and clicked to false
		this.selected = false;
		this.clicked = false;
		//Create the linked list
		this.listeners = new LinkedList<GUIButtonListener>();
	}
	
	/* The update method */
	public void updateComponent() {
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
				this.listeners.get(a).buttonClicked(new GUIButtonEvent(this , this.name));
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
	
	/* The method that returns whether the button is clicked */
	public boolean isClicked() {
		//Check whether the button is visible
		if (this.visible) {
			//Check if the button has been clicked
			if (this.clicked) {
				//Set clicked to false then return true
				this.clicked = false;
				return true;
			} else {
				//Return false
				return false;
			}
		} else
			//Return false
			return false;
	}
	
	/* The method to add a listener to the button */
	public void addListener(GUIButtonListener listener) {
		//Add the listener to the linked list
		this.listeners.add(listener);
	}
	
}