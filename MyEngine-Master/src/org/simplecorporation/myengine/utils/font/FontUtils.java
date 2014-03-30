package org.simplecorporation.myengine.utils.font;

import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.gui.font.bitmap.BitmapFont;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class FontUtils {
	
	/* The method to create a font */
	public static GUIFont buildGUIFont(String font , Colour colour , double size) {
		//Check what font to create
		if (! Settings.Android)
			return new GUIFont(JavaFontUtils.buildGUIFont(font , colour , size));
		else if (Settings.Android)
			return new GUIFont(AndroidFontUtils.buildGUIFont(font , colour , size));
		else
			return null;
	}
	
	/* The method to create a bitmap font */
	public static GUIFont createGUIBitmapFont(Image image , double size , int gridSize) {
		//The BitmapFont
		BitmapFont bitmapFont = new BitmapFont(image , size);
		//Set the grid size of the BitmapFont
		bitmapFont.gridWidth = gridSize;
		bitmapFont.gridHeight = gridSize;
		//Return the GUIFont
		return new GUIFont(bitmapFont);
	}
	
}