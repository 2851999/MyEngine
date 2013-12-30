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
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;

public class GUIImageDropDownList extends GUIDropDownList {
	
	
	/* The overlay image */
	public Image overlayImage;
	
	/* The background image */
	public Image backgroundImage;
	
	/* The constructor */
	public GUIImageDropDownList(String name , GUIButton menuButton , Image overlayImage) {
		//Call the super constructor
		super(name , menuButton);
		//Assign the variables
		this.overlayImage = overlayImage;
		this.backgroundImage = null;
	}
	
	/* The method called to render this component */
	public void renderComponent() {
		//Check if this menu is open
		if (this.menuOpen && this.backgroundImage != null) {
			//Render the background
			BasicRenderer.renderImage(
					this.backgroundImage ,
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
		//Render the overlay if it is set
		if (this.overlayImage != null) {
			//Render the background
			BasicRenderer.renderImage(
					this.overlayImage ,
					this.position.x ,
					this.position.y ,
					this.menuButton.width ,
					this.menuButton.height);
		}
	}
	
}