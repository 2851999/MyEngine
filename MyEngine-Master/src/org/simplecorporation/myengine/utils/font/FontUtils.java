/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.logger.Logger;

public class FontUtils {
	
	/* The method to build a font */
	public static Font buildFont(String font , float size) {
		return new Font(font , Font.PLAIN , (int)size);
	}
	
	/* The method to build a GUIFont */
	public static GUIFont buildGUIFont(String font , Colour colour , float size) {
		return buildGUIFont(buildFont(font , 1) , colour , size);
	}
	
	/* The method to build a GUIFont */
	public static GUIFont buildGUIFont(Font font , Colour colour , float size) {
		return new GUIFont(font , colour , size);
	}
	
	/* The method to get a font from a file */
	public static Font getFont(String fontPath) {
		//Default font
		Font font = new Font("Arial" , Font.PLAIN , 12);
		try {
			//Load font from file path
			font = Font.createFont(Font.TRUETYPE_FONT , new FileInputStream(fontPath));
		} catch (FileNotFoundException e) {
			Logger.log("FontUtils getFont()" , "File not found: " + fontPath);
			e.printStackTrace();
		} catch (FontFormatException e) {
			Logger.log("FontUtils getFont()" , "Font format exception: " + fontPath);
			e.printStackTrace();
		} catch (IOException e) {
			Logger.log("FontUtils getFont()" , "IOException: " + fontPath);
			e.printStackTrace();
		}
		return font;
	}

	
}