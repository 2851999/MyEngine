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
	public GUIRenderableTextBox(String name , Colour backgroundColour , Colour outlineColour , GUIFont font) {
		//Call the super constructor
		super(name);
		//Set the colours
		this.backgroundColour = backgroundColour;
		this.outlineColour = outlineColour;
		//Set the font
		this.font = font;
	}
	
	/* The constructor */
	public GUIRenderableTextBox(String name , Colour backgroundColour , Colour outlineColour , GUIFont font , char maskCharacter) {
		//Call the super constructor
		super(name);
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
			
			//The text to be rendered
			String renderText = this.text;
			
			//The colour of the text
			Colour renderColour = Colour.WHITE;
			
			//Check if the java font is null
			if (this.font.javaGUIFont != null)
				//Get the colour
				renderColour = this.font.javaGUIFont.colour;
			
			//Check if the characters are hidden
			if (this.hideCharacters) {
				//Set the rendered text to nothing
				renderText = "";
				//Loop the text's length
				for (int a = 0; a < this.text.length(); a++)
					//Add the masked character
					renderText += this.maskCharacter;
			}
			
			//Check if the default text should be rendered
			if (this.text.equals("") && ! this.defaultText.equals("") && ! this.selected) {
				//Set the rendered text
				renderText = this.defaultText;
				//Set the colour
				//renderColour.a = renderColour.a / 2; THIS LINE STOPPED RENDERING (I DONT KNOW HOW TO FIX)
			}
			
			//Check to see if the text fits in the box
			if (this.font.getWidth(renderText) > this.width - this.font.fontSize / 2) {
				//Set the render text
				int beginIndex = 1;
				//While the text is too long
				while (this.font.getWidth(renderText.substring(beginIndex)) > this.width - this.font.fontSize / 2) {
					//Increase the begin index if possible
					if (renderText.length() > beginIndex + 1)
						beginIndex ++;
				}
				//Set the text
				renderText = renderText.substring(beginIndex);
			}
			
			//Check if the cursor is showing
			if (this.cursorShown) {
				//Add the cursor
				renderText += "|";
			}
			
			//Check if the java font  is null
			if (this.font.javaGUIFont != null)
				//Set the colour of the font
				this.font.javaGUIFont.colour = renderColour;
			
			//Render the text
			if (Settings.Video.OpenGL)
				this.font.render(renderText , this.position.x + 4 ,
						(this.position.y + (this.height / 2)) - (this.font.getHeight(this.text) / 2));
			else
				//Not a clue why it can't be the same as OpenGL
				this.font.render(renderText , this.position.x + 4 ,
						(this.position.y + (this.height / 2)) + (this.font.getHeight(this.text) / 4));
		}
	}
	
}