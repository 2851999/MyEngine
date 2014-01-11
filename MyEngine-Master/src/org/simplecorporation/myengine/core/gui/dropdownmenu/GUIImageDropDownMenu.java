/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.dropdownmenu;

import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;

public class GUIImageDropDownMenu extends GUIDropDownMenu {
	
	/* The background image */
	public Image backgroundImage;
	
	/* The constructor */
	public GUIImageDropDownMenu(String name , GUIButton menuButton , Image backgroundImage) {
		//Call the super constructor
		super(name , menuButton);
		//Assign the variables
		this.backgroundImage = backgroundImage;
		
	}
	
	/* The method called to render this component */
	public void renderComponent() {
		//Check if this menu is open
		if (this.menuOpen) {
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
	}
	
}