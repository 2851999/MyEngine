/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.checkbox;

import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIRenderableCheckBox extends GUICheckBox {
	
	/* The colour of the check box */
	public Colour checkBoxColour;
	
	/* The colour of the check */
	public Colour checkColour;
	
	/* The constructor */
	public GUIRenderableCheckBox(String name , Colour checkBoxColour , Colour checkColour) {
		//Call the super constructor
		super(name);
		//Set the default values of the variables
		this.checkBoxColour = checkBoxColour;
		this.checkColour = checkColour;
		this.checkWidth = 0;
		this.checkHeight = 0;
	}
	
	/* The render method */
	protected void renderComponent() {
		//Render the check box based on whether it is checked or not
		
		//The box
		BasicRenderer.setColour(this.checkBoxColour);
		BasicRenderer.renderFilledRectangle(this.position.x , this.position.y , this.width , this.height);
		
		//The check (if needed)
		if (this.checked) {
			//Set the colour
			BasicRenderer.setColour(this.checkColour);
			//Is the width/height the default values
			if (this.checkWidth == 0 || this.checkHeight == 0)
				//Render the box
				BasicRenderer.renderFilledRectangle(this.position.x + 4 , this.position.y + 4 , this.width - 8 , this.height - 8);
			else
				//Render the box
				BasicRenderer.renderFilledRectangle((this.position.x + (this.width / 2)) - (this.checkWidth / 2) ,
						(this.position.y + (this.height / 2)) - (this.checkHeight / 2) , this.checkWidth , this.checkHeight);
		}
	}
	
}