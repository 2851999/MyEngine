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

import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

/**
 * The ImagePack <code>class</code> can load and store images
 * to be used at a later date. When using Java2D (OpenGL = false)
 * there is a rendering flash when rendering an image for the
 * first time, this class can help prevent that issue.
 */
public class ImagePack {
	
	/**
	 * The name of the <code>ImagePack</code>
	 */
	/* The name of the image pack */
	private String packName;
	
	/**
	 * The id of the <code>ImagePack</code>
	 */
	/* Id of the image pack */
	private int packId;
	
	/**
	 * A <code>LinkedList</code> containing all of the images in the
	 * <code>ImagePack</code>
	 * 
	 * @see Image
	 */
	/* The images in the image pack */
	private LinkedList<Image> images;
	
	/**
	 * A <code>LinkedList</code> containing all of the images names in
	 * the <code>ImagePack</code>
	 */
	/* The image names in the image pack */
	private LinkedList<String> imageNames;
	
	
	/**
	 * A <code>LinkedList</code> containing all of the images id's in
	 * the <code>ImagePack</code>
	 */
	/* The image id in the image pack */
	private LinkedList<Integer> imageIds;
	
	/**
	 * Constructor for <code>ImagePack</code>
	 * @param packName A <code>String</code> used to identify the
	 *                 ImagePack
	 * @param packId   An integer used to identity the
	 *                 ImagePack
	 */
	/* The constructor of an image pack */
	public ImagePack(String packName , int packId) {
		//Assign the variables
		this.packName = packName;
		this.packId = packId;
		this.images = new LinkedList<Image>();
		this.imageNames = new LinkedList<String>();
		this.imageIds = new LinkedList<Integer>();
	}
	
	/**
	 * This method adds an Image to the ImagePack.
	 * @param name  A <code>String</code> used to identify the given Image
	 * @param id    An integer used to identify the given Image
	 * @param image The Image to add to this ImagePack
	 */
	/* The method to add an image to the images */
	public void add(String name , int id , Image image) {
		this.imageNames.add(name);
		this.imageIds.add(id);
		this.images.add(image);
	}
	
	/**
	 * This method returns an Image in this ImagePack using the name
	 * of the image.
	 * @param name A <code>String</code> used to identify the Image
	 * @return An Image
	 * @see Image
	 */
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
	
	/**
	 * This method returns an Image in this ImagePack using the id
	 * of the image.
	 * @param name An integer used to identify the Image
	 * @return An Image
	 * @see Image
	 */
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
	
	/**
	 * This method is used to load all of the Image's in this ImagePack
	 * When using Java2D (OpenGL = false) there is a rendering flash
	 * when rendering an image for the first time, this method can help
	 * prevent that issue.
	 */
	/* The method to load all the images */
	public void load() {
		//Render all of the images once
		for (int a = 0; a < this.images.size(); a++) {
			//Render the current image
			BasicRenderer.renderImage(this.images.get(a) , 0 , 0 , 10 , 10);
		}
	}
	
	/**
	 * This method returns the ImagePack's name
	 * @return A <code>String</code> value of this ImagePack's name
	 */
	/* The method to get the pack name */
	public String getPackName() {
		return this.packName;
	}
	
	/**
	 * This method returns the ImagePack's id
	 * @return A integer value of this ImagePack's id
	 */
	/* The method to get the pack id */
	public int getPackId() {
		return this.packId;
	}
	
}