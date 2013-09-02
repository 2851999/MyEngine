/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.image;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class ImagePack {
	
	/* The name of the image pack */
	private String packName;
	
	/* Id of the image pack */
	private int packId;
	
	/* The images in the image pack */
	private LinkedList<Image> images;
	
	/* The image names in the image pack */
	private LinkedList<String> imageNames;
	
	/* The image id in the image pack */
	private LinkedList<Integer> imageIds;
	
	/* The constructor of an image pack */
	public ImagePack(String packName , int packId) {
		//Assign the variables
		this.packName = packName;
		this.packId = packId;
		this.images = new LinkedList<Image>();
		this.imageNames = new LinkedList<String>();
		this.imageIds = new LinkedList<Integer>();
	}
	
	/* The method to add an image to the images */
	public void add(String name , int id , Image image) {
		this.imageNames.add(name);
		this.imageIds.add(id);
		this.images.add(image);
	}
	
	/* The method to get an image given its name */
	public Image getImageByName(String name) {
		//The image
		Image image = null;
		//Loop
		for (int a = 0; a < this.imageNames.size(); a++) {
			//Check if the current name equals the name given
			if (this.imageNames.get(a).equals(name)) {
				//Assign the image
				image = this.images.get(a);
				//Exit the loop
				break;
			}
		}
		//Check to see whether the image was found
		if (image == null)
			//Log an error
			Logger.log(new Log("ImagePack getImageByName()" , "The image with the name " + name + " was not found" , LogType.ERROR));
		//Return the image
		return image;
	}
	
	/* The method to get an image given its id */
	public Image getImageById(int id) {
		//The image
		Image image = null;
		//Loop
		for (int a = 0; a < this.imageIds.size(); a++) {
			//Check if the current id equals the id given
			if (this.imageIds.get(a) == id) {
				//Assign the image
				image = this.images.get(a);
				//Exit the loop
				break;
			}
		}
		//Check to see whether the image was found
		if (image == null)
			//Log an error
			Logger.log(new Log("ImagePack getImageById()" , "The image with the id " + id + " was not found" , LogType.ERROR));
		//Return the image
		return image;
	}
	
	/* The method to load all the images */
	public void load() {
		//Render all of the images once
		for (int a = 0; a < this.images.size(); a++) {
			//Render the current image
			BasicRenderer.renderImage(this.images.get(a) , 0 , 0 , 10 , 10);
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