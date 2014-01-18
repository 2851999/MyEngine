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
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIImageTextBox extends GUITextBox {
	
	/* The image */
	public Image image;
	
	/* The constructor */
	public GUIImageTextBox(String name , Image image , GUIFont font) {
		//Call the super constructor
		super(name, font);
		//Set the image
		this.image = image;
	}
	
	/* The constructor */
	public GUIImageTextBox(String name , Image image , GUIFont font , char maskCharacter) {
		//Call the super constructor
		super(name, font);
		//Set the image
		this.image = image;
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
			BasicRenderer.setColour(Colour.WHITE);
			BasicRenderer.renderImage(this.image , this.position.x , this.position.y , this.width , this.height , this.rotation);
			
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