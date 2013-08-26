/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android.gui.font;

import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

import android.graphics.Rect;
import android.graphics.Typeface;

public class GUIFont {
	
	/* The font */
	public Typeface typeface;
	
	/* The font size */
	public double size;
	
	/* The colour */
	public Colour colour;
	
	/* The constructor of the font */
	public GUIFont(Typeface typeface , Colour colour , double size) {
		//Set the typeface
		this.typeface = typeface;
		
		//Set the colour and size
		this.colour = colour;
		this.size = size;
	}
	
	/* The method that renders the font */
	public void render(String text , double x , double y) {
		//Check what rendering mode to use
		if (Settings.Android && ! Settings.Video.OpenGL) {
			//Set the size and colour
			AndroidStore.gamePaint.setTextSize((float)this.size);
			BasicRenderer.setColour(this.colour);
			//Set the typeface
			AndroidStore.gamePaint.setTypeface(this.typeface);
			//Render the text
			AndroidStore.gameCanvas.drawText(text , (float)x , (float)y , AndroidStore.gamePaint);
		}
	}
	
	/* The method to get the width of a string */
	public double getWidth(String text) {
		if (Settings.Android && ! Settings.Video.OpenGL) {
			Rect bounds = new Rect();
			AndroidStore.gamePaint.setTextSize((float)this.size);
			AndroidStore.gamePaint.setTypeface(this.typeface);
			AndroidStore.gamePaint.getTextBounds(text , 0 , text.length() , bounds);
			return bounds.width();
		} else
			return 0;
	}
	
	/* The method to get the height of a string */
	public double getHeight(String text) {
		if (Settings.Android && ! Settings.Video.OpenGL) {
			Rect bounds = new Rect();
			AndroidStore.gamePaint.setTextSize((float)this.size);
			AndroidStore.gamePaint.setTypeface(this.typeface);
			AndroidStore.gamePaint.getTextBounds(text , 0 , text.length() , bounds);
			return bounds.height();
		} else
			return 0;
	}
	
	
}