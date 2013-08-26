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

import org.simplecorporation.myengine.core.gui.button.event.GUICheckBoxEvent;
import org.simplecorporation.myengine.core.gui.button.listener.GUICheckBoxListener;
import org.simplecorporation.myengine.core.input.MouseInput;
import org.simplecorporation.myengine.core.input.event.MouseEvent;

public abstract class JavaGUICheckBox extends GUICheckBoxBase {
	
	/* The constructor */
	public JavaGUICheckBox(String name) {
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
			
		} else
			//Set clicked to false
			this.clicked = false;
	}
	
	/* The mouse released event */
	public void onMouseReleased(MouseEvent e) {
		//Check that this is visible and selected
		if (this.visible && this.selected) {
			//Check if the wait is over
			if (System.currentTimeMillis() - this.lastTimeClicked >= this.clickedWait) {
				//Set the last time
				this.lastTimeClicked = System.currentTimeMillis();
				//Set clicked to true
				this.clicked = true;
				//Set toggle checked
				this.checked = ! this.checked;
				//Call the event
				for (int a = 0; a < this.listeners.size(); a++) {
					this.listeners.get(a).checkBoxToggled(new GUICheckBoxEvent(this.name , this.checked));
				}
			}
		}
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