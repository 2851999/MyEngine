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
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class GUIRenderableTextBox extends GUITextBox {
	
	/* The background colour of the text box */
	public Colour backgroundColour;
	
	/* The outline colour of the text box */
	public Colour outlineColour;
	
	/* The font */
	public GUIFont font;
	
	/* The constructor */
	public GUIRenderableTextBox(String name , GUIFont font) {
		//Call the super constructor
		super(name);
		//Set the colours
		this.backgroundColour = Colour.WHITE;
		this.outlineColour = Colour.BLACK;
		//Set the font
		this.font = font;
	}
	
	/* The method to update the text box */
	public void update() {
		
	}
	
	
	/* The method to render the text box */
	public void render() {
		if (this.visible) {
			//Render the box
			BasicRenderer.setColour(this.outlineColour);
			BasicRenderer.renderFilledRectangle(this.position.x , this.position.y , this.width , this.height);
			BasicRenderer.setColour(this.backgroundColour);
			BasicRenderer.renderFilledRectangle(this.position.x + 1 , this.position.y + 1 , this.width - 2 , this.height - 2);
			
			//The text to be rendered
			String renderedText = this.text;
			
			//Check if the characters are hidden
			if (this.hideCharacters) {
				//Set the rendered text to nothing
				renderedText = "";
				//Loop the text's length
				for (int a = 0; a < this.text.length(); a++)
					//Add the masked character
					renderedText += this.maskCharacter;
			}
			
			//Render the text
			if (Settings.Video.OpenGL)
				this.font.render(renderedText , this.position.x + 2 ,
						(this.position.y + (this.height / 2)) - (this.font.getHeight(this.text) / 2));
			else
				//Not a clue why it can't be the same as OpenGL
				this.font.render(renderedText , this.position.x + 2 ,
						(this.position.y + (this.height / 2)) + (this.font.getHeight(this.text) / 4));
		}
	}
	
}