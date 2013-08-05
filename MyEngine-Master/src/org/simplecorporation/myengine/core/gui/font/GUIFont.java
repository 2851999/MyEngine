/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.font;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.core.window.JavaWindow;
import org.simplecorporation.myengine.settings.Settings;

public class GUIFont {
	
	/* The font */
	public Font font;
	
	/* The font size */
	public float size;
	
	/* The colour */
	public Colour colour;
	
	/* The constructor of the font */
	public GUIFont(Font font , Colour colour , float size) {
		//Set the font
		this.font = font;
		
		//Set the colour and size
		this.colour = colour;
		this.size = size;
	}
	
	/* The method that renders the font */
	public void render(String text , double x , double y) {
		//Check what rendering mode to use
		if (Settings.Video.OpenGL) {
			//Create the true type font
			TrueTypeFont trueTypeFont = new TrueTypeFont(this.font.deriveFont(size) , Settings.Video.AntiAliasing);
			//Render the text
			trueTypeFont.drawString((float)x , (float)y , text , new Color((float)this.colour.r , (float)this.colour.g , (float)this.colour.b , (float)this.colour.a));
		} else {
			//Set the size of the font
			this.font.deriveFont(size);
			//Set the colour
			BasicRenderer.setColour(this.colour);
			//Render the text
			JavaWindow.g2d.drawString(text , (float) x , (float) y);
		}
	}
	
	/* The method to get the width of a string */
	public double getWidth(String text) {
		TrueTypeFont trueTypeFont = new TrueTypeFont(this.font.deriveFont(size) , false);
		return trueTypeFont.getWidth(text);
	}
	
	/* The method to get the height of a string */
	public double getHeight(String text) {
		TrueTypeFont trueTypeFont = new TrueTypeFont(this.font.deriveFont(size) , false);
		return trueTypeFont.getHeight(text);
	}
	
	
}