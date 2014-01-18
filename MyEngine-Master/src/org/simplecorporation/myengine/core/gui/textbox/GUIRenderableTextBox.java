/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.textbox;

import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIRenderableTextBox extends GUITextBox {
	
	/* The background colour of the text box */
	public Colour backgroundColour;
	
	/* The outline colour of the text box */
	public Colour outlineColour;
	
	/* The constructor */
	public GUIRenderableTextBox(String name , Colour backgroundColour , Colour outlineColour , GUIFont font) {
		//Call the super constructor
		super(name, font);
		//Set the colours
		this.backgroundColour = backgroundColour;
		this.outlineColour = outlineColour;
	}
	
	/* The constructor */
	public GUIRenderableTextBox(String name , Colour backgroundColour , Colour outlineColour , GUIFont font , char maskCharacter) {
		//Call the super constructor
		super(name, font);
		//Set the colours
		this.backgroundColour = backgroundColour;
		this.outlineColour = outlineColour;
		//Set the font
		this.font = font;
		//Setup the character masking
		this.maskCharacter = maskCharacter;
		this.hideCharacters = true;
	}
	
	/* The method to render the text box */
	protected void renderComponent() {
		if (this.visible) {
			//Render the box
			BasicRenderer.setColour(this.outlineColour);
			BasicRenderer.renderFilledRectangle(this.position.x , this.position.y , this.width , this.height);
			BasicRenderer.setColour(this.backgroundColour);
			BasicRenderer.renderFilledRectangle(this.position.x + 1 , this.position.y + 1 , this.width - 2 , this.height - 2);
			
			//The colour of the text
			Colour renderColour = Colour.WHITE;
			
			//Check if the java font is null
			if (this.font.javaGUIFont != null)
				//Get the colour
				renderColour = this.font.javaGUIFont.colour;
			
			//Check if the cursor is showing
			if (this.cursorShown) {
				//Set the cursor colour
				BasicRenderer.setColour(this.cursorColour);
				//Render the cursor's rectangle
				BasicRenderer.renderFilledRectangle(this.cursorX, this.position.y + 2, 2, this.height - 4);
			}
			
			//Check if the java font  is null
			if (this.font.javaGUIFont != null)
				//Set the colour of the font
				this.font.javaGUIFont.colour = renderColour;
			
			//Render the text
			this.font.render(this.renderText , this.position.x + 4 ,
					(this.position.y + (this.height / 2)) - (this.font.getHeight(this.text) / 2));
		}
	}
	
}