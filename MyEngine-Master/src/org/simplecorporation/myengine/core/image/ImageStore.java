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

/**
 * The ImageStore is a <code>class</code> made up of static fields and
 * methods that can load and store image packs
 * to be used at a later date. When using Java2D (OpenGL = false)
 * there is a rendering flash when rendering an image for the
 * first time, this class can help prevent that issue.
 * {@link org.simplecorporation.myengine.core.image.ImagePack ImagePack}
 * stores image packs that can all be loaded at the
 * same time.
 * 
 * @see ImagePack
 */
public class ImageStore {
	
	/* The image packs */
	/**
	 * A <code>LinkedList</code> containing all of the
	 * {@link org.simplecorporation.myengine.core.image.ImagePack ImagePack}'s
	 * in the ImageStore
	 */
	private static LinkedList<ImagePack> imagePacks = new LinkedList<ImagePack>();
	
	/* The method to add an image pack */
	/**
	 * A method used to add an ImagePack to the ImageStore.
	 * @param imagePack The ImagePack to be added
	 * @see ImagePack
	 */
	public static void add(ImagePack imagePack) {
		imagePacks.add(imagePack);
	}
	
	/* The method to load all of the image packs */
	/**
	 * A method used to load all of the images in the ImageStore's
	 * ImagePacks's LinkedList
	 */
	public static void load() {
		for (int a = 0; a < imagePacks.size(); a++) {
			imagePacks.get(a).load();
		}
	}
	
	/* The method that returns an image pack given its name */
	/**
	 * A method that is used to get an ImagePack from the ImageStore's
	 * LinkedList of ImagePack's using the ImagePack's name
	 * @param name A String value representing the ImagePack's name
	 * @return The ImagePack (If found otherwise, null)
	 */
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
	/**
	 * A method that is used to get an ImagePack from the ImageStore's
	 * LinkedList of ImagePack's using the ImagePack's id
	 * @param name An integer value representing the ImagePack's id
	 * @return The ImagePack (If found otherwise, null)
	 */
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