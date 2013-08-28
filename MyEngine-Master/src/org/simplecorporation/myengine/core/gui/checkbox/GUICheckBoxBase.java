/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.checkbox;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.gui.GUIComponent;
import org.simplecorporation.myengine.core.gui.button.listener.GUICheckBoxListener;

public abstract class GUICheckBoxBase extends GUIComponent {

	/* Is the button selected */
	public boolean selected;
	
	/* Is the button clicked */
	public boolean clicked;
	
	/* Is this checked */
	public boolean checked;
	
	/* The last time clicked */
	public long lastTimeClicked;
	
	/* The wait time for being clicked */
	public long clickedWait;
	
	/* The size of the check */
	public double checkWidth;
	public double checkHeight;
	
	/* The button listeners */
	public LinkedList<GUICheckBoxListener> listeners;
	
	/* The constructor */
	public GUICheckBoxBase(String name) {
		//Call the super constructor
		super(name);
		//Set selected, clicked and checked to false
		this.selected = false;
		this.clicked = false;
		this.checked = false;
		
		//Set the default clicked wait time
		this.clickedWait = 0;
		
		//Set the last time clicked to the current time
		this.lastTimeClicked = System.currentTimeMillis();
		
		//Create the linked list
		this.listeners = new LinkedList<GUICheckBoxListener>();
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
	
	/* The method that returns whether the button is checked */
	public boolean isChecked() {
		//Return the value
		return this.checked;
	}
	
	/* The method to add a listener to the button */
	public void addListener(GUICheckBoxListener listener) {
		//Add the listener to the linked list
		this.listeners.add(listener);
	}
	
}