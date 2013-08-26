/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.button;

import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class JavaGUIRenderableButton extends JavaGUIButton {
	
	/* The text */
	public String text;
	
	/* The colours */
	public Colour[] colours;
	
	/* The font */
	public GUIFont font;
	
	/* The constructor */
	public JavaGUIRenderableButton(String name , String text , Colour[] colours , GUIFont font) {
		//Call the super constructor
		super(name);
		//Assign the text
		this.text = text;
		//Assign the colours
		this.colours = colours;
		//Assign the font
		this.font = font;
	}
	
	/* The method to render the button */
	protected void renderComponent() {
		//The current image
		Colour current = null;
		//Render the right colour
		if (! this.selected && ! this.clicked)
			current = this.colours[0];
		else if (this.selected && this.colours.length > 1)
			current = this.colours[1];
		else if (this.clicked && this.colours.length > 2)
			current = this.colours[2];
		//Render the rectangle
		BasicRenderer.setColour(current);
		BasicRenderer.renderFilledRectangle(this.position.x , this.position.y , this.width , this.height);
		//Render the font
		if (Settings.Video.OpenGL)
			this.font.render(this.text , (this.position.x + (this.width) / 2) - (this.font.getWidth(this.text) / 2) ,
					(this.position.y + (this.height / 2)) - (this.font.getHeight(this.text) / 2));
		else
			//Not a clue why it can't be the same as OpenGL
			this.font.render(this.text , (this.position.x + (this.width) / 2) - (this.font.getWidth(this.text) / 2) ,
					(this.position.y + (this.height / 2)) + (this.font.getHeight(this.text) / 4));
	}
	
}