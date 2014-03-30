/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game3d.camera.skybox;

import org.simplecorporation.myengine.core.game3d.vector.Vector3D;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer3DOpenGL;

public class Skybox {
	
	/* The offset values */
	public double xOffset;
	public double yOffset;
	public double zOffset;
	
	/* The images for each side of the skybox */
	public Image[] images;
	
	/* The constructor given the offset values */
	public Skybox(double xOffset, double yOffset, double zOffset) {
		//Create the images array
		this.images = new Image[6];
		//Assign the offset values
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.zOffset = zOffset;
	}
	
	/* The constructor with the images given */
	public Skybox(double xOffset, double yOffset, double zOffset, Image image1, Image image2, Image image3, Image image4, Image image5, Image image6) {
		//Assign the images
		this.setImages(image1, image2, image3, image4, image5, image6);
		//Assign the offset values
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.zOffset = zOffset;
	}
	
	/* The constructor with the images array given */
	public Skybox(double xOffset, double yOffset, double zOffset, Image[] images) {
		//Assign the images
		this.setImages(images);
		//Assign the offset values
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.zOffset = zOffset;
	}
	
	/* The method used to render the skybox given a position */
	public void render(Vector3D position) {
		//Render the skybox
		BasicRenderer3DOpenGL.renderTexturedCube(this.images, position.multiply(-1).minus(new Vector3D(xOffset, yOffset, zOffset)), xOffset * 2, yOffset * 2, zOffset * 2);
	}
	
	/* The method used to set the images given the images */
	public void setImages(Image image1, Image image2, Image image3, Image image4, Image image5, Image image6) {
		//Assign the images
		this.setImages(new Image[] { image1, image2, image3, image4, image5, image6 });
	}
	
	/* The method used to set the images given the images array */
	public void setImages(Image[] images) {
		//Assign the images
		this.images = images;
	}
	
}