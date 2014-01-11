/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.slider;

import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIRenderableSlider extends GUISlider {
	
	/* The colour of the slider bar */
	public Colour sliderBarColour;
	
	/* The constructor */
	public GUIRenderableSlider(String name , Colour sliderBarColour , GUIButton sliderButton , int sliderDirection) {
		//Call the super constructor
		super(name , sliderButton , sliderDirection);
		//Assign the variables
		this.sliderBarColour = sliderBarColour;
	}
	
	/* The method to render the component */
	protected void renderComponent() {
		//Set the colour
		BasicRenderer.setColour(this.sliderBarColour);
		//Render the slider bar
		BasicRenderer.renderFilledRectangle(this.position.x , this.position.y , this.width , this.height);
		//Set the colour to white
		BasicRenderer.setColour(Colour.WHITE);
		//Render the button
		this.sliderButton.render();
	}
	
}