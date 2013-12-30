/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.dropdownlist;

import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.gui.button.event.GUIButtonEvent;
import org.simplecorporation.myengine.core.gui.dropdownmenu.GUIDropDownMenu;

public class GUIDropDownList extends GUIDropDownMenu {
	
	/* The constructor */
	public GUIDropDownList(String name , GUIButton firstButton) {
		//Call the super constructor
		super(name , firstButton);
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
			//Add menu button to the list of buttons
			this.buttons.add(menuButton);
			//The new button
			GUIButton newButton = null;
			//Look at all of the buttons
			for (int a = 0; a < this.buttons.size(); a++) {
				//Check the name of the current button
				if (this.buttons.get(a).name.equals(e.getButtonName())) {
					//Set the new button
					newButton = this.buttons.get(a);
					//Remove the button from the list
					this.buttons.remove(a);
				}
			}
			//Set the menu button
			this.menuButton = newButton;
			//Close this menu
			this.menuOpen = false;
		}
	}
	
}