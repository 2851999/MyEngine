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

import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUILabel extends GUIComponent {
	
	/* The text */
	public String text;
	
	/* The constructor */
	public GUILabel(String name , String text , GUIFont font) {
		//Call the super constructor
		super(name, new GUIRenderer(new Colour[] {}, font));
		//Assign the variables
		this.text = text;
		this.width = this.renderer.font.getWidth(this.text);
	}
	
	/* The update method */
	public void updateComponent() {
		
	}
	
	/* The render method */
	public void renderComponent() {
		//Render the text
		this.renderer.font.render(this.text , this.position.x , this.position.y);
	}
	
}