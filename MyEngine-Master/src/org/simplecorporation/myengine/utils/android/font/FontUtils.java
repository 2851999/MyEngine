package org.simplecorporation.myengine.utils.android.font;

import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.core.android.gui.font.GUIFont;
import org.simplecorporation.myengine.core.render.colour.Colour;

import android.graphics.Typeface;

public class FontUtils {
	
	/* The method to build a font for android */
	public static Typeface buildFont(String font) {
		return Typeface.create(font , Typeface.NORMAL);
	}
	
	/* The method to build a GUIFont for android */
	public static GUIFont buildGUIFont(String font , Colour colour , double size) {
		return buildGUIFont(buildFont(font) , colour , size);
	}
	
	/* The method to build a GUIFont for android */
	public static GUIFont buildGUIFont(Typeface font , Colour colour , double size) {
		return new GUIFont(font , colour , size);
	}
	
	/* The method to get a font for android from a file */
	public static Typeface getFont(String fontPath) {
		//Default font
		Typeface typeface = buildFont("Arial");
		
		//Make sure the font file is in at least the assets folder assets/fonts/NAME.TTF
		//Create the typeface
		typeface = Typeface.createFromAsset(AndroidStore.gameActivity.getAssets() , fontPath);
		
		//Return the font
		return typeface;
	}
}

