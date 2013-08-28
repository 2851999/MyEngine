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
import org.simplecorporation.myengine.core.gui.font.JavaGUIFont;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class JavaGUIRenderableTextBox extends JavaGUITextBox {
	
	/* The background colour of the text box */
	public Colour backgroundColour;
	
	/* The outline colour of the text box */
	public Colour outlineColour;
	
	/* The font */
	public JavaGUIFont font;
	
	/* The constructor */
	public JavaGUIRenderableTextBox(String name , GUIFont font) {
		//Call the super constructor
		super(name);
		//Set the colours
		this.backgroundColour = Colour.WHITE;
		this.outlineColour = Colour.BLACK;
		//Set the font
		this.font = font.javaGUIFont;
	}
	
	/* The method to render the text box */
	protected void renderComponent() {
		if (this.visible) {
			
			//Check to see if the text fits in the box
			if (this.font.getWidth(this.text) > this.width - 4)
				//Remove the last letter
				this.text = this.text.substring(0 , this.text.length() - 1);
			
			//Render the box
			BasicRenderer.setColour(this.outlineColour);
			BasicRenderer.renderFilledRectangle(this.position.x , this.position.y , this.width , this.height);
			BasicRenderer.setColour(this.backgroundColour);
			BasicRenderer.renderFilledRectangle(this.position.x + 1 , this.position.y + 1 , this.width - 2 , this.height - 2);
			
			//The text to be rendered
			String renderedText = this.text;
			
			//The colour of the text
			Colour renderColour = this.font.colour.clone();
			
			//The font
			JavaGUIFont renderFont = new JavaGUIFont(this.font.font , this.font.colour , this.font.size);
			
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