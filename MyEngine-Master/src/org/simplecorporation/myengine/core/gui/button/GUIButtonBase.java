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
import org.simplecorporation.myengine.core.gui.button.listener.GUIButtonListener;

public abstract class GUIButtonBase extends GUIComponent {

	/* Is the button selected */
	public boolean selected;
	
	/* Is the button clicked */
	public boolean clicked;
	
	/* The button listeners */
	public LinkedList<GUIButtonListener> listeners;
	
	/* The constructor */
	public GUIButtonBase(String name) {
		//Call the super constructor
		super(name);
		//Set selected and clicked to false
		this.selected = false;
		this.clicked = false;
		//Create the linked list
		this.listeners = new LinkedList<GUIButtonListener>();
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