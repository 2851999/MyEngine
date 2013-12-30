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
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIRenderableDropDownList extends GUIDropDownList {
	
	/* The background colour */
	public Colour backgroundColour;
	
	/* The constructor */
	public GUIRenderableDropDownList(String name , GUIButton menuButton , Colour backgroundColour) {
		//Call the super constructor
		super(name , menuButton);
		//Assign the variables
		this.backgroundColour = backgroundColour;
		
	}
	
	/* The method called to render this component */
	public void renderComponent() {
		//Check if this menu is open
		if (this.menuOpen) {
			//Set the colour of the background
			BasicRenderer.setColour(this.backgroundColour);
			//Render the background
			BasicRenderer.renderFilledRectangle(
					this.position.x ,
					this.position.y ,
					this.width ,
					this.height);
		}
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
	
}