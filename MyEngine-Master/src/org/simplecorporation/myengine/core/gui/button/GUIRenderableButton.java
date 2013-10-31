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

import java.util.LinkedList;

import org.simplecorporation.myengine.core.gui.button.listener.GUIButtonListener;
import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class GUIRenderableButton extends GUIButton {
	
	/* The text */
	public String text;
	
	/* The colours */
	public Colour[] colours;
	
	/* The font */
	public GUIFont font;
	
	/* The constructor */
	public GUIRenderableButton(String name , String text , Colour[] colours , GUIFont font) {
		//Call the super constructor
		super(name);
		//Assign the text
		this.text = text;
		//Assign the colours
		this.colours = colours;
		//Assign the font
		this.font = font;
		//Set selected and clicked to false
		this.selected = false;
		this.clicked = false;
		//Create the linked list
		this.listeners = new LinkedList<GUIButtonListener>();
	}
	
	/* The method to render the button */
	protected void renderComponent() {
		//The current image
		Colour current = this.colours[0];
		//Render the right colour
		if (! this.selected && ! this.clicked)
			current = this.colours[0];
		else if (this.selected && this.colours.length > 1 && ! Settings.Android)
			current = this.colours[1];
		else if (this.clicked && this.colours.length > 2)
			current = this.colours[2];
		//Buttons on android can't be selected so for android colour 2 in
		//the list is shown when the button is clicked
		else if (this.clicked && Settings.Android && colours.length > 1)
			current = this.colours[1];
		//Render the rectangle
		BasicRenderer.setColour(current);
		BasicRenderer.renderFilledRectangle(this.position.x , this.position.y , this.width , this.height);
		//Render the font
		if (Settings.Video.OpenGL)
			this.font.render(this.text , (this.position.x + (this.width) / 2) - (this.font.getWidth(this.text) / 2) ,
					(this.position.y + (this.height / 2)) - (this.font.getHeight(this.text) / 2));
		else
			//Different because there is a problem with Java rendering y=0 not on screen
			this.font.render(this.text , (this.position.x + (this.width) / 2) - (this.font.getWidth(this.text) / 2) ,
					(this.position.y + (this.height / 2)) + (this.font.getHeight(this.text) / 4));
	}
	
}