/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.font;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.logger.Log;
import org.simplecorporation.myengine.core.logger.LogType;
import org.simplecorporation.myengine.core.logger.Logger;

public class FontStore {
	
	/* The font packs */
	private static LinkedList<FontPack> fontPacks = new LinkedList<FontPack>();
	
	/* The method to add an font pack */
	public static void add(FontPack imagePack) {
		fontPacks.add(imagePack);
	}
	
	/* The method to load all of the font packs */
	public static void load() {
		for (int a = 0; a < fontPacks.size(); a++) {
			fontPacks.get(a).load();
		}
	}
	
	/* The method that returns a font pack given its name */
	public static FontPack getPackByName(String name) {
		//The font pack
		FontPack fontPack = null;
		//Loop
		for (int a = 0; a < fontPacks.size(); a++) {
			//Check if the current font pack has the right name
			if (fontPacks.get(a).getPackName().equals(name)) {
				//Assign the font pack
				fontPack = fontPacks.get(a);
				//Exit the loop
				break;
			}
		}
		//Check to see whether the font pack was found
		if (fontPack == null)
			//Log an error
			Logger.log(new Log("FontStore getPackByName()" , "The pack with the name " + name + " was not found" , LogType.ERROR));
		//Return the font pack
		return fontPack;
	}
	
	/* The method that returns an font pack given its id */
	public static FontPack getPackById(int id) {
		//The font pack
		FontPack fontPack = null;
		//Loop
		for (int a = 0; a < fontPacks.size(); a++) {
			//Check if the current font pack has the right id
			if (fontPacks.get(a).getPackId() == id) {
				//Assign the font pack
				fontPack = fontPacks.get(a);
				//Exit the loop
				break;
			}
		}
		//Check to see whether the font pack was found
		if (fontPack == null)
			//Log an error
			Logger.log(new Log("FontStore getPackById()" , "The pack with the id " + id + " was not found" , LogType.ERROR));
		//Return the font pack
		return fontPack;
	}
	
}