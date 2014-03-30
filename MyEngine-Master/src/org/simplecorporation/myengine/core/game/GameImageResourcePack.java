/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game;

import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.image.ImagePack;

public class GameImageResourcePack extends GameResourcePack {
	
	/* The image file type */
	public String fileType;
	
	/* The constructor */
	public GameImageResourcePack(String name, boolean inFolder, String fileType) {
		//Call the super constructor
		super(name, inFolder);
		//Assign the variables
		this.fileType = fileType;
	}
	
	/* The method to create the ImageResourcePack and return it */
	public ImagePack getImagePack(int id) {
		//The image pack
		ImagePack imagePack = new ImagePack(this.name, id);
		//Look at every directory in the directories list
		for (int a = 0; a < this.resources.size(); a++) {
			//Create and add the current resource to the image pack
			imagePack.add(this.resources.get(a).name, a, new Image(this.resources.get(a).name, this.fileType, this.inFolder));
		}
		//Return the image pack
		return imagePack;
	}
	
}