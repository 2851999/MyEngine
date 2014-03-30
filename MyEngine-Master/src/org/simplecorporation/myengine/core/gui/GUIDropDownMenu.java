/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui;

import java.util.ArrayList;
import java.util.List;

import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.rectangle.Rectangle;

public class GUIDropDownMenu extends GUIComponent implements GUIButtonListener {
	
	/* The menu button */
	public GUIButton menuButton;
	
	/* The buttons in the drop down menu */
	public List<GUIButton> buttons;
	
	/* The boolean that represents whether the drop down list is open */
	public boolean menuOpen;
	
	/* The boolean used to determine whether the menu can be toggled */
	public boolean canMenuToggle;
	
	/* The height of this menu when the buttons are shown */
	public double fullHeight;
	
	/* The constructor */
	public GUIDropDownMenu(String name , GUIButton menuButton, GUIRenderer renderer) {
		//Call the super constructor
		super(name, renderer);
		//Assign the variables
		this.menuButton = menuButton;
		this.menuOpen = false;
		this.canMenuToggle = true;
		this.height = menuButton.height;
		this.fullHeight = menuButton.height;
		//Add this button listener to the menu button
		this.menuButton.addListener(this);
		//Create the buttons linked list
		this.buttons = new ArrayList<GUIButton>();
	}
	
	/* The method called to update this component */
	public void updateComponent() {
		//Set the menu buttons position and width
		this.menuButton.position.x = this.position.x;
		this.menuButton.position.y = this.position.y;
		this.menuButton.width = this.width;
		//Make sure the menu button is visible
		this.menuButton.visible = this.visible;
		//Update the menu button if it is set
		if (this.menuButton != null)
			this.menuButton.update();
		//Check if the menu is open
		if (this.menuOpen)
			//Make sure the menu button is selected
			this.menuButton.buttonSelected = true;
		//The y position
		double y = this.position.y + this.menuButton.height;
		//Go through all of the buttons
		for (int a = 0; a < this.buttons.size(); a++) {
			//Make sure that the button is visible if needed
			this.buttons.get(a).visible = this.visible && this.menuOpen;
			//Check if the menu is open
			if (this.menuOpen) {
				//Make sure the button is in the correct place
				this.buttons.get(a).position.x = this.position.x;
				this.buttons.get(a).position.y = y;
				//Set the width of the button
				this.buttons.get(a).width = this.width;
				//Add onto the y position
				y += this.buttons.get(a).height;
				//Update the current button
				this.buttons.get(a).update();
			}
		}
	}
	
	/* The method called to render this component */
	public void renderComponent() {
		//Set the render index
		this.renderIndex = 0;
		//Render the background
		this.renderer.render(this);
		//Render the menu button if it is set
		if (this.menuButton != null)
			this.menuButton.render();
		//(Increases performance) make sure that the buttons
		//are only rendered if this menu is open
		if (this.menuOpen) {
			//Go through all of the buttons
			for (int a = 0; a < this.buttons.size(); a++)
				//Render the current button
				this.buttons.get(a).render();
		}
	}
	
	/* The method called when a button is clicked */
	public void buttonClicked(GUIButtonEvent e) {
		//Check whether the menu button has the same name as
		//the one clicked
		if (this.menuButton != null && e.getButtonName().equals(this.menuButton.name)  && this.canMenuToggle) {
			//Stop the event repeating
			this.canMenuToggle = false;
			//Toggle the menu open boolean
			this.menuOpen = ! this.menuOpen;
		} else if (! e.getButtonName().equals(this.menuButton.name)) {
			//Close this menu
			this.menuOpen = false;
		}
	}
	
	/* The method used to add a button to the buttons
	 * in this drop down menu */
	public void addButton(GUIButton button) {
		//Add this listener to the button
		button.addListener(this);
		//Add onto the height
		this.fullHeight += button.height;
		//Add the button to the buttons linked list
		this.buttons.add(button);
	}
	
	/* The method called when a mouse button is pressed */
	public void onMousePressed(MouseEvent e) {
		//Make sure this menu is visible
		if (this.visible) {
			//Check if the mouse was clicked in this drop down menu's area
			if (! new Rectangle(this.position.x, this.position.y, this.width, this.fullHeight).contains(e.x , e.y)) {
				//Close this menu
				this.menuOpen = false;
			}
		}
	}
	
	/* The method called when a mouse button is released */
	public void onMouseReleased(MouseEvent e) {
		//Make sure this menu is visible
		if (this.visible) {
			//Enable the menu toggle
			this.canMenuToggle = true;
		}
	}
	
}