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

import java.util.LinkedList;

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class FontPack {
	
	/* The name of the font pack */
	private String packName;
	
	/* Id of the font pack */
	private int packId;
	
	/* The images in the font pack */
	private LinkedList<GUIFont> fonts;
	
	/* The image names in the font pack */
	private LinkedList<String> fontNames;
	
	/* The image id in the font pack */
	private LinkedList<Integer> fontIds;
	
	/* The constructor of an font pack */
	public FontPack(String packName , int packId) {
		//Assign the variables
		this.packName = packName;
		this.packId = packId;
		this.fonts = new LinkedList<GUIFont>();
		this.fontNames = new LinkedList<String>();
		this.fontIds = new LinkedList<Integer>();
	}
	
	/* The method to add an font to the fonts */
	public void add(String name , int id , GUIFont font) {
		this.fontNames.add(name);
		this.fontIds.add(id);
		this.fonts.add(font);
	}
	
	/* The method to get a font given its name */
	public GUIFont getFontByName(String name) {
		//The font
		GUIFont font = null;
		//Loop
		for (int a = 0; a < this.fontNames.size(); a++) {
			//Check if the current name equals the name given
			if (this.fontNames.get(a).equals(name)) {
				//Assign the font
				font = this.fonts.get(a);
				//Exit the loop
				break;
			}
		}
		//Check to see whether the font was found
		if (font == null)
			//Log an error
			Logger.log(new Log("FontPack getFontByName()" , "The font with the name " + name + " was not found" , LogType.ERROR));
		//Return the font
		return font;
	}
	
	/* The method to get a font given its id */
	public GUIFont getFontById(int id) {
		//The font
		GUIFont font = null;
		//Loop
		for (int a = 0; a < this.fontIds.size(); a++) {
			//Check if the current id equals the id given
			if (this.fontIds.get(a) == id) {
				//Assign the font
				font = this.fonts.get(a);
				//Exit the loop
				break;
			}
		}
		//Check to see whether the font was found
		if (font == null)
			//Log an error
			Logger.log(new Log("ImagePack getFontById()" , "The font with the id " + id + " was not found" , LogType.ERROR));
		//Return the font
		return font;
	}
	
	/* The method to load all the fonts */
	public void load() {
		//Render all of the fonts once
		for (int a = 0; a < this.fonts.size(); a++) {
			//Render the current font
			this.fonts.get(a).render("FONT" , 0 , 0);
		}
	}
	
	/* The method to get the pack name */
	public String getPackName() {
		return this.packName;
	}
	
	/* The method to get the pack id */
	public int getPackId() {
		return this.packId;
	}
	
}