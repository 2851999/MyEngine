/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.image;

import java.util.LinkedList;

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class ImageStore {
	
	/* The image packs */
	private static LinkedList<ImagePack> imagePacks = new LinkedList<ImagePack>();
	
	/* The method to add an image pack */
	public static void add(ImagePack imagePack) {
		imagePacks.add(imagePack);
	}
	
	/* The method to load all of the image packs */
	public static void load() {
		for (int a = 0; a < imagePacks.size(); a++) {
			imagePacks.get(a).load();
		}
	}
	
	/* The method that returns an image pack given its name */
	public static ImagePack getPackByName(String name) {
		//The image pack
		ImagePack imagePack = null;
		//Loop
		for (int a = 0; a < imagePacks.size(); a++) {
			//Check if the current image pack has the right name
			if (imagePacks.get(a).getPackName().equals(name)) {
				//Assign the image pack
				imagePack = imagePacks.get(a);
				//Exit the loop
				break;
			}
		}
		//Check to see whether the image pack was found
		if (imagePack == null)
			//Log an error
			Logger.log(new Log("ImageStore getPackByName()" , "The pack with the name " + name + " was not found" , LogType.ERROR));
		//Return the image pack
		return imagePack;
	}
	
	/* The method that returns an image pack given its id */
	public static ImagePack getPackById(int id) {
		//The image pack
		ImagePack imagePack = null;
		//Loop
		for (int a = 0; a < imagePacks.size(); a++) {
			//Check if the current image pack has the right id
			if (imagePacks.get(a).getPackId() == id) {
				//Assign the image pack
				imagePack = imagePacks.get(a);
				//Exit the loop
				break;
			}
		}
		//Check to see whether the image pack was found
		if (imagePack == null)
			//Log an error
			Logger.log(new Log("ImageStore getPackById()" , "The pack with the id " + id + " was not found" , LogType.ERROR));
		//Return the image pack
		return imagePack;
	}
	
}