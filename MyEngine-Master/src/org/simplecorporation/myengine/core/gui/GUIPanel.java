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

public class GUIPanel {
	
	/* The name of the panel */
	public String name;
	
	/* The components in the GUI */
	public LinkedList<GUIComponent> components;
	
	/* The constructor */
	public GUIPanel(String name) {
		//Assign the name
		this.name = name;
		//Create the linked list
		this.components = new LinkedList<GUIComponent>();
	}
	
	/* The method to update the GUI */
	public void updatePanel() {
		//Update all of the components
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).update();
	}
	
	/* The method to render the GUI */
	public void renderPanel() {
		//Render all of the components
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).render();
	}
	
	/* The method to show the GUI */
	public void showPanel() {
		//Set all of the components to show
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).visible = true;
	}
	
	/* The method to hide the GUI */
	public void hidePanel() {
		//Set all of the components to hide
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).visible = false;
	}
	
	/* The method to add a component */
	public void add(GUIComponent component) {
		//Add the component to the linked list
		this.components.add(component);
	}
	
	/* The method that returns a component given its name */
	public GUIComponent get(String name) {
		//The component
		GUIComponent component = null;
		//Check the whole list
		for (int a = 0; a < this.components.size(); a++) {
			//Check if it has the right name
			if (this.components.get(a).name.equals(name))
				//Assign the component
				component = this.components.get(a);
		}
		//Check if the component is null
		if (component == null)
			//Log a message
			Logger.log(new Log("GUIPanel get()" , "The component with the name " + name + " was not found" , LogType.ERROR));
		//Return the component
		return component;
	}
	
}