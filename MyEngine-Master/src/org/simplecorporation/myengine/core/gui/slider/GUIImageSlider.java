/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.slider;

import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIImageSlider extends GUISlider {
	
	/* The image of the slider bar */
	public Image sliderBarImage;
	
	/* The constructor */
	public GUIImageSlider(String name , Image sliderBarImage , GUIButton sliderButton , int sliderDirection) {
		//Call the super constructor
		super(name , sliderButton , sliderDirection);
		//Assign the variables
		this.sliderBarImage = sliderBarImage;
	}
	
	/* The method to render the component */
	protected void renderComponent() {
		//Set the colour to white
		BasicRenderer.setColour(Colour.WHITE);
		//Render the slider bar
		BasicRenderer.renderImage(this.sliderBarImage , this.position.x , this.position.y , this.width , this.height);
		//Render the button
		this.sliderButton.render();
	}
	
}