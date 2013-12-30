/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.scrollbar;

import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIImageScrollBar extends GUIScrollBar {
	
	/* The image of the scroll bar */
	public Image scrollBarImage;
	
	/* The constructor */
	public GUIImageScrollBar(String name , Image scrollBarImage , GUIButton scrollBarButton , int sliderDirection ,
			double scrollAmount) {
		//Call the super constructor
		super(name , scrollBarButton , sliderDirection , scrollAmount);
		//Assign the variables
		this.scrollBarImage = scrollBarImage;
	}
	
	/* The method to render the component */
	protected void renderComponent() {
		//Set the colour to white
		BasicRenderer.setColour(Colour.WHITE);
		//Render the slider bar image
		BasicRenderer.renderImage(this.scrollBarImage , this.position.x , this.position.y , this.width , this.height);
		//Render the button
		this.sliderButton.render();
	}
	
}