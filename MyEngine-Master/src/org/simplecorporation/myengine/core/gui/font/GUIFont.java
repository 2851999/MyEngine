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

import org.simplecorporation.myengine.core.gui.font.image.ImageFolderFont;
import org.simplecorporation.myengine.settings.Settings;

public class GUIFont {
	
	/* The font */
	public JavaGUIFont javaGUIFont;
	public AndroidGUIFont androidGUIFont;
	public ImageFolderFont imageFolderFont;
	
	/* The constructor of the font for java */
	public GUIFont(JavaGUIFont javaGUIFont) {
		//Set the font
		this.javaGUIFont = javaGUIFont;
	}
	
	/* The constructor of the font for android */
	public GUIFont(AndroidGUIFont androidGUIFont) {
		//Set the font
		this.androidGUIFont = androidGUIFont;
	}
	
	/* The constructor of the font for an ImageFolderFont */
	public GUIFont(ImageFolderFont imageFolderFont) {
		//Set the font
		this.imageFolderFont = imageFolderFont;
	}
	
	/* The method that renders the font */
	public void render(String text , double x , double y) {
		//Check what rendering mode to use
		if (this.imageFolderFont != null)
			//Render the image folder font
			this.imageFolderFont.render(text , x , y);
		else if (! Settings.Android) {
			//Render the text
			this.javaGUIFont.render(text , x , y);
		} else if (Settings.Android && ! Settings.Video.OpenGL)
			//Render the text
			this.androidGUIFont.render(text , x , y);
	}
	
	/* The method to get the width of a string */
	public double getWidth(String text) {
		if (this.imageFolderFont != null)
			return this.imageFolderFont.getWidth(text);
		else if (! Settings.Android)
			return this.javaGUIFont.getWidth(text);
		else if (Settings.Android && ! Settings.Video.OpenGL)
			return this.androidGUIFont.getWidth(text);
		else
			return 0;
	}
	
	/* The method to get the height of a string */
	public double getHeight(String text) {
		if (this.imageFolderFont != null)
			return this.imageFolderFont.getHeight(text);
		else if (! Settings.Android)
			return this.javaGUIFont.getHeight(text);
		else if (Settings.Android && ! Settings.Video.OpenGL)
			return this.androidGUIFont.getHeight(text);
		else
			return 0;
	}
	
	
}