/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.textbox;

import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class GUIImageTextBox extends GUITextBox {
	
	/* The image */
	public Image image;
	
	/* The font */
	public GUIFont font;
	
	/* The constructor */
	public GUIImageTextBox(String name , Image image , GUIFont font) {
		//Call the super constructor
		super(name);
		//Set the image
		this.image = image;
		//Set the font
		this.font = font;
	}
	
	/* The method to render the text box */
	public void renderComponent() {
		if (this.visible) {
			
			//Check to see if the text fits in the box
			if (this.font.getWidth(this.text) > this.width - 4)
				//Remove the last letter
				this.text = this.text.substring(0 , this.text.length() - 1);
			
			//Render the box
			BasicRenderer.setColour(Colour.WHITE);
			BasicRenderer.renderImage(this.image , this.position.x , this.position.y , this.width , this.height);
			
			//The text to be rendered
			String renderedText = this.text;
			
			//The colour of the text
			Colour renderColour = this.font.colour.clone();
			
			//The font
			GUIFont renderFont = new GUIFont(this.font.font , this.font.colour , this.font.size);
			
			//Check if the characters are hidden
			if (this.hideCharacters) {
				//Set the rendered text to nothing
				renderedText = "";
				//Loop the text's length
				for (int a = 0; a < this.text.length(); a++)
					//Add the masked character
					renderedText += this.maskCharacter;
			}
			
			//Check if the default text should be rendered
			if (this.text.equals("") && ! this.defaultText.equals("") && ! this.selected) {
				//Set the rendered text
				renderedText = this.defaultText;
				//Set the colour
				renderColour.a = renderColour.a / 2;
			}
			
			//Check if the cursor is showing
			if (this.cursorShown) {
				//Add the cursor
				renderedText += "|";
			}
			
			//Set the colour of the font
			renderFont.colour = renderColour;
			
			//Render the text
			if (Settings.Video.OpenGL)
				renderFont.render(renderedText , this.position.x + 2 ,
						(this.position.y + (this.height / 2)) - (this.font.getHeight(this.text) / 2));
			else
				//Not a clue why it can't be the same as OpenGL
				renderFont.render(renderedText , this.position.x + 2 ,
						(this.position.y + (this.height / 2)) + (this.font.getHeight(this.text) / 4));
		}
	}
	
}