/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.simplecorporation.myengine.core.gui.font.JavaGUIFont;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class JavaFontUtils {
	
	/* The method to build a font */
	public static Font buildFont(String font , double size) {
		return new Font(font , Font.PLAIN , (int)size);
	}
	
	/* The method to build a GUIFont */
	public static JavaGUIFont buildGUIFont(String font , Colour colour , double size) {
		return buildGUIFont(buildFont(font , 1) , colour , size);
	}
	
	/* The method to build a GUIFont */
	public static JavaGUIFont buildGUIFont(Font font , Colour colour , double size) {
		return new JavaGUIFont(font , colour , size);
	}
	
	/* The method to get a font from a file */
	public static Font getFont(String fontPath) {
		//Default font
		Font font = buildFont("Arial" , 12);
		try {
			//Load font from file path
			font = Font.createFont(Font.TRUETYPE_FONT , new FileInputStream(fontPath));
		} catch (FileNotFoundException e) {
			Logger.log(new Log("FontUtils getFont()" , "File not found: " + fontPath , LogType.ERROR));
			e.printStackTrace();
		} catch (FontFormatException e) {
			Logger.log(new Log("FontUtils getFont()" , "Font format exception: " + fontPath , LogType.ERROR));
			e.printStackTrace();
		} catch (IOException e) {
			Logger.log(new Log("FontUtils getFont()" , "IOException: " + fontPath , LogType.ERROR));
			e.printStackTrace();
		}
		return font;
	}
	
}