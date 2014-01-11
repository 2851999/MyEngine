/* *********************************************
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
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIRenderableScrollBar extends GUIScrollBar {
	
	/* The colour of the scroll bar */
	public Colour scrollBarColour;
	
	/* The constructor */
	public GUIRenderableScrollBar(String name , Colour scrollBarColour , GUIButton scrollBarButton , int sliderDirection ,
			double scrollAmount) {
		//Call the super constructor
		super(name , scrollBarButton , sliderDirection , scrollAmount);
		//Assign the variables
		this.scrollBarColour = scrollBarColour;
	}
	
	/* The method to render the component */
	protected void renderComponent() {
		//Set the colour
		BasicRenderer.setColour(this.scrollBarColour);
		//Render the slider bar
		BasicRenderer.renderFilledRectangle(this.position.x , this.position.y , this.width , this.height);
		//Set the colour to white
		BasicRenderer.setColour(Colour.WHITE);
		//Render the button
		this.sliderButton.render();
	}
	
}