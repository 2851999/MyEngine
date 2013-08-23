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

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class GUI {
	
	/* The components in the GUI */
	public LinkedList<GUIPanel> panels;
	
	/* The constructor */
	public GUI() {
		//Create the linked list
		this.panels = new LinkedList<GUIPanel>();
	}
	
	/* The method to update the GUI */
	public void updateGUI() {
		//Update all of the components
		for (int a = 0; a < this.panels.size(); a++)
			this.panels.get(a).updatePanel();
	}
	
	/* The method to render the GUI */
	public void renderGUI() {
		//Render all of the components
		for (int a = 0; a < this.panels.size(); a++)
			this.panels.get(a).renderPanel();
	}
	
	/* The method to show the GUI */
	public void show() {
		//Set all of the components to show
		for (int a = 0; a < this.panels.size(); a++)
			this.panels.get(a).showPanel();
	}
	
	/* The method to hide the GUI */
	public void hide() {
		//Set all of the components to hide
		for (int a = 0; a < this.panels.size(); a++)
			this.panels.get(a).hidePanel();
	}
	
	/* The method to add a component */
	public void add(GUIPanel panel) {
		//Add the component to the linked list
		this.panels.add(panel);
	}
	
	/* The method that returns a component given its name */
	public GUIPanel get(String name) {
		//The component
		GUIPanel panel = null;
		//Check the whole list
		for (int a = 0; a < this.panels.size(); a++) {
			//Check if it has the right name
			if (this.panels.get(a).name.equals(name))
				//Assign the component
				panel = this.panels.get(a);
		}
		//Check if the component is null
		if (panel == null)
			//Log a message
			Logger.log(new Log("GUI get()" , "The panel with the name " + name + " was not found" , LogType.ERROR));
		//Return the component
		return panel;
	}
	
}