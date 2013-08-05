/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui;

import org.simplecorporation.myengine.core.input.MouseInput;

public abstract class GUIButton extends GUIComponent {

	/* Is the button selected */
	private boolean selected;
	
	/* Is the button clicked */
	private boolean clicked;
	
	/* The constructor */
	public GUIButton(String name) {
		//Call the super constructor
		super(name);
		//Set selected and clicked to false
		this.selected = false;
		this.clicked = false;
	}
	
	/* The update method */
	public void update() {
		//Check the mouse and see whether the button is selected
		if (this.getBounds().contains(MouseInput.x , MouseInput.y))
			//Set selected to true
			this.selected = true;
		else
			//Set selected to false
			this.selected = false;
		
		//Check if the button is down
		if (MouseInput.isButtonDown(0) && this.selected)
			//Set clicked to true
			this.clicked = true;
		else
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
	
}