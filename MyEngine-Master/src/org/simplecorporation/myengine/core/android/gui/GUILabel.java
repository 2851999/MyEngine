/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android.gui;

import org.simplecorporation.myengine.core.android.gui.font.GUIFont;

public class GUILabel extends GUIComponent {
	
	/* The text */
	public String text;
	
	/* The font */
	public GUIFont font;
	
	/* The constructor */
	public GUILabel(String name , String text , GUIFont font) {
		//Call the super constructor
		super(name);
		//Assign the variables
		this.text = text;
		this.font = font;
	}
	
	/* The update method */
	public void updateComponent() {
		
	}
	
	/* The render method */
	public void renderComponent() {
		//Render the text
		this.font.render(this.text , this.position.x , this.position.y);
	}
	
}