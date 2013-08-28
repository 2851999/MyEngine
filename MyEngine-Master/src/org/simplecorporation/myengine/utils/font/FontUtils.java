package org.simplecorporation.myengine.utils.font;

import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class FontUtils {
	
	/* The method to create a font from its name */
	public static GUIFont buildGUIFont(String font , Colour colour , double size) {
		//Check what font to create
		if (! Settings.Android)
			return new GUIFont(JavaFontUtils.buildGUIFont(font , colour , size));
		else if (Settings.Android)
			return new GUIFont(AndroidFontUtils.buildGUIFont(font , colour , size));
		else
			return null;
	}
	
}