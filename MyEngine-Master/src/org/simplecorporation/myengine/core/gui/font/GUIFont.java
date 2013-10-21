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

import org.simplecorporation.myengine.core.gui.font.bitmap.BitmapFont;
import org.simplecorporation.myengine.settings.Settings;

public class GUIFont {
	
	/* The font */
	public JavaGUIFont javaGUIFont;
	public AndroidGUIFont androidGUIFont;
	public BitmapFont bitmapFont;
	
	/* The font size */
	public double fontSize;
	
	/* The constructor of the font for java */
	public GUIFont(JavaGUIFont javaGUIFont) {
		//Set the font
		this.javaGUIFont = javaGUIFont;
		//Set the font size
		this.fontSize = this.javaGUIFont.fontSize;
	}
	
	/* The constructor of the font for android */
	public GUIFont(AndroidGUIFont androidGUIFont) {
		//Set the font
		this.androidGUIFont = androidGUIFont;
		//Set the font size
		this.fontSize = this.androidGUIFont.fontSize;
	}
	
	/* The constructor of the font for an ImageFolderFont */
	public GUIFont(BitmapFont bitmapFont) {
		//Set the font
		this.bitmapFont = bitmapFont;
		//Set the font size
		this.fontSize = this.bitmapFont.fontSize;
	}
	
	/* The method that renders the font */
	public void render(String text , double x , double y) {
		//Check what rendering mode to use
		if (this.bitmapFont != null) {
			//Set the font size
			this.bitmapFont.fontSize = this.fontSize;
			//Render the image folder font
			this.bitmapFont.render(text , x , y);
		} else if (! Settings.Android) {
			//Set the font size
			this.javaGUIFont.fontSize = this.fontSize;
			//Render the text
			this.javaGUIFont.render(text , x , y);
		} else if (Settings.Android && ! Settings.Video.OpenGL) {
			//Set the font size
			this.androidGUIFont.fontSize = this.fontSize;
			//Render the text
			this.androidGUIFont.render(text , x , y);
		}
	}
	
	/* The method to get the width of a string */
	public double getWidth(String text) {
		if (this.bitmapFont != null) {
			//Set the font size
			this.bitmapFont.fontSize = this.fontSize;
			return this.bitmapFont.getWidth(text);
		} else if (! Settings.Android) {
			//Set the font size
			this.javaGUIFont.fontSize = this.fontSize;
			return this.javaGUIFont.getWidth(text);
		} else if (Settings.Android && ! Settings.Video.OpenGL) {
			//Set the font size
			this.androidGUIFont.fontSize = this.fontSize;
			return this.androidGUIFont.getWidth(text);
		} else
			return 0;
	}
	
	/* The method to get the height of a string */
	public double getHeight(String text) {
		if (this.bitmapFont != null) {
			//Set the font size
			this.bitmapFont.fontSize = this.fontSize;
			return this.bitmapFont.getHeight(text);
		} else if (! Settings.Android) {
			//Set the font size
			this.javaGUIFont.fontSize = this.fontSize;
			return this.javaGUIFont.getHeight(text);
		} else if (Settings.Android && ! Settings.Video.OpenGL) {
			//Set the font size
			this.androidGUIFont.fontSize = this.fontSize;
			return this.androidGUIFont.getHeight(text);
		} else
			return 0;
	}
	
	
}