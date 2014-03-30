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

import org.simplecorporation.myengine.core.logger.Log;
import org.simplecorporation.myengine.core.logger.LogType;
import org.simplecorporation.myengine.core.logger.Logger;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;

/**
 * The ImagePack <code>class</code> can load and store images
 * to be used at a later date. When using Java2D (OpenGL = false)
 * there is a rendering flash when rendering an image for the
 * first time, this class can help prevent that issue.
 */
public class ImagePack {
	
	/* The name of the image pack */
	/**
	 * The name of the <code>ImagePack</code>
	 */
	private String packName;
	
	/* Id of the image pack */
	/**
	 * The id of the <code>ImagePack</code>
	 */
	private int packId;
	
	/* The images in the image pack */
	/**
	 * A <code>LinkedList</code> containing all of the images in the
	 * <code>ImagePack</code>
	 * 
	 * @see Image
	 * 	 */
	private LinkedList<Image> images;
	
	/* The image names in the image pack */
	/**
	 * A <code>LinkedList</code> containing all of the images names in
	 * the <code>ImagePack</code>
	 */
	private LinkedList<String> imageNames;
	
	/* The image id in the image pack */
	/**
	 * A <code>LinkedList</code> containing all of the images id's in
	 * the <code>ImagePack</code>
	 */
	private LinkedList<Integer> imageIds;
	
	/* The constructor of an image pack */
	/**
	 * Constructor for <code>ImagePack</code>
	 * @param packName A <code>String</code> used to identify the
	 *                 ImagePack
	 * @param packId   An integer used to identity the
	 *                 ImagePack
	 */
	public ImagePack(String packName , int packId) {
		//Assign the variables
		this.packName = packName;
		this.packId = packId;
		this.images = new LinkedList<Image>();
		this.imageNames = new LinkedList<String>();
		this.imageIds = new LinkedList<Integer>();
	}
	
	/* The method to add an image to the images */
	/**
	 * This method adds an Image to the ImagePack.
	 * @param name  A <code>String</code> used to identify the given Image
	 * @param id    An integer used to identify the given Image
	 * @param image The Image to add to this ImagePack
	 */
	public void add(String name , int id , Image image) {
		this.imageNames.add(name);
		this.imageIds.add(id);
		this.images.add(image);
	}
	
	/* The method to get an image given its name */
	/**
	 * This method returns an Image in this ImagePack using the name
	 * of the image.
	 * @param name A <code>String</code> used to identify the Image
	 * @return An Image
	 * @see Image
	 */
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
	/**
	 * This method returns an Image in this ImagePack using the id
	 * of the image.
	 * @param name An integer used to identify the Image
	 * @return An Image
	 * @see Image
	 */
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
	/**
	 * This method is used to load all of the Image's in this ImagePack
	 * When using Java2D (OpenGL = false) there is a rendering flash
	 * when rendering an image for the first time, this method can help
	 * prevent that issue.
	 */
	public void load() {
		//Render all of the images once
		for (int a = 0; a < this.images.size(); a++) {
			//Render the current image
			BasicRenderer.renderImage(this.images.get(a) , 0 , 0 , 10 , 10);
		}
	}
	
	/* The method to get the pack name */
	/**
	 * This method returns the ImagePack's name
	 * @return A <code>String</code> value of this ImagePack's name
	 */
	public String getPackName() {
		return this.packName;
	}
	
	/* The method to get the pack id */
	/**
	 * This method returns the ImagePack's id
	 * @return A integer value of this ImagePack's id
	 */
	public int getPackId() {
		return this.packId;
	}
	
}