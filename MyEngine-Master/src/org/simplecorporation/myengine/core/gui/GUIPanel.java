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

import java.util.LinkedList;

import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.game2d.vector.Vector2D;
import org.simplecorporation.myengine.core.logger.Log;
import org.simplecorporation.myengine.core.logger.LogType;
import org.simplecorporation.myengine.core.logger.Logger;
import org.simplecorporation.myengine.core.window.Window;
import org.simplecorporation.myengine.core.window.WindowListener;
import org.simplecorporation.myengine.core.window.WindowSizeChangedEvent;

public class GUIPanel implements WindowListener {
	
	/* The name of the panel */
	public String name;
	
	/* The position of this panel */
	public Vector2D position;
	
	/* The width of the panel */
	public double width;
	
	/* The height of the panel */
	public double height;
	
	/* Is this panel showing */
	public boolean showing;
	
	/* The components in the GUI */
	public LinkedList<GUIComponent> components;
	
	/* The constructor */
	public GUIPanel(String name) {
		//Set the name
		this.name = name;
		//Create the linked list
		this.components = new LinkedList<GUIComponent>();
		//Create the position
		this.position = new Vector2D();
		this.position.x = 0;
		this.position.y = 0;
		//Set the default width and height
		this.width = Settings.Window.Size.Width;
		this.height = Settings.Window.Size.Height;
		//Set showing to false
		this.showing = false;
		//Add this window listener
		Window.addListener(this);
	}
	
	/* The method to update the GUIPanel */
	public void updatePanel() {
		//Check that this panel is showing
		if (this.showing) {
			//Update all of the components
			for (int a = 0; a < this.components.size(); a++) {
				//Get the component
				GUIComponent component = this.components.get(a);
				//Make sure the component is completely visible in this panel
				if (component.position.x >= this.position.x && component.position.x + component.width <= this.position.x + this.width &&
						component.position.y >= this.position.y && component.position.y + component.height <= this.position.y + this.height) {
					//Make sure the component is shown
					component.visible = true;
					//Update the component
					component.update();
				} else {
					//Make sure the component is hidden
					component.visible = false;
				}
			}	
		}
	}
	
	/* The method to render the GUIPanel */
	public void renderPanel() {
		//Check that this panel is showing
		if (this.showing) {
			//Render all of the components
			for (int a = 0; a < this.components.size(); a++) {
				//Get the component
				GUIComponent component = this.components.get(a);
				//Make sure the component is completely visible in this panel
				if (component.position.x >= this.position.x && component.position.x + component.width <= this.position.x + this.width &&
						component.position.y >= this.position.y && component.position.y + component.height <= this.position.y + this.height) {
					//Make sure the component is shown
					component.visible = true;
					//Render the component
					component.render();
				} else {
					//Make sure the component is hidden
					component.visible = false;
				}
			}
		}
	}
	
	/* The method to show the GUI */
	public void showPanel() {
		//Set showing to true
		this.showing = true;
		//Set all of the components to show
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).visible = true;
	}
	
	/* The method to hide the GUI */
	public void hidePanel() {
		//Set showing to false
		this.showing = false;
		//Set all of the components to hide
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).visible = false;
	}
	
	/* The method to add a component */
	public void add(GUIComponent component) {
		//Set the components position in relation to this panel
		component.position.x += this.position.x;
		component.position.y += this.position.y;
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
	
	/* The method to set the panel's position */
	public void setPanelPosition(double x , double y) {
		//Get the change in the x and y position
		double changeX = x - this.position.x;
		double changeY = y - this.position.y;
		//Move this panel by the correct amount
		this.movePanel(changeX , changeY);
	}
	
	/* The method to move the panel by a certain amount */
	public void movePanel(double x , double y) {
		//Set the panels position
		this.position.x += x;
		this.position.y += y;
		//Move all of the components
		for (int a = 0; a < this.components.size(); a++) {
			this.components.get(a).position.x += x;
			this.components.get(a).position.y += y;
		}
	}
	
	/* The method called when the window size is changed */
	public void windowSizeChanged(WindowSizeChangedEvent e) {
		//Increase this panels width/height
		this.width += e.changeWidth;
		this.height += e.changeHeight;
	}
	
}