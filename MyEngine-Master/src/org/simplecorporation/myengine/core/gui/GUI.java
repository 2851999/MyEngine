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

import java.util.LinkedList;

public class GUI {
	
	/* The components in the GUI */
	public LinkedList<GUIComponent> components;
	
	/* The constructor */
	public GUI() {
		//Create the linked list
		this.components = new LinkedList<GUIComponent>();
	}
	
	/* The method to update the GUI */
	public void updateGUI() {
		//Update all of the components
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).update();
	}
	
	/* The method to render the GUI */
	public void renderGUI() {
		//Render all of the components
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).render();
	}
	
	/* The method to show the GUI */
	public void show() {
		//Set all of the components to show
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).visible = true;
	}
	
	/* The method to hide the GUI */
	public void hide() {
		//Set all of the components to hide
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).visible = false;
	}
	
}