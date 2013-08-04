/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game.entity;

import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.point.Point2D;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;

public class ImageEntity2D extends AbstractEntity2D {
	
	/* The image of the entity */
	public Image image;
	
	/* The constructor */
	public ImageEntity2D() {
		//Call the super constructor
		super();
	}
	
	/* The constructor with the image given */
	public ImageEntity2D(Image image) {
		//Call the super constructor
		super();
		//Assign the image
		this.image = image;
		//Set the width and height
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
	}
	
	/* The constructor with the image and position given */
	public ImageEntity2D(Image image , Point2D position) {
		//Call the super constructor
		super(position);
		//Assign the image
		this.image = image;
		//Set the width and height
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
	}
	
	/* The constructor with the image and position and velocity given */
	public ImageEntity2D(Image image , Point2D position , Point2D velocity) {
		//Call the super constructor
		super(position , velocity);
		//Assign the image
		this.image = image;
		//Set the width and height
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
	}
	
	/* The constructor with the image and position and width and height given */
	public ImageEntity2D(Image image , Point2D position , double width , double height) {
		//Call the super constructor
		super(position , width , height);
		//Assign the image
		this.image = image;
		//Set the width and height
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
	}
	
	/* The constructor with the image and position and velocity and width and height given */
	public ImageEntity2D(Image image , Point2D position , Point2D velocity , double width , double height) {
		//Call the super constructor
		super(position , velocity , width , height);
		//Assign the image
		this.image = image;
		//Set the width and height
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
	}
	
	/* The entity's update method */
	public void entityUpdate() {
		
	}
	
	/* The entity's render method */
	public void entityRender() {
		//Render the image
		BasicRenderer.renderImage(this.image , this.position.x , this.position.y  , this.width , this.height);
	}
	
	/* The method to set the image */
	public void setImage(Image image) {
		//Set the image
		this.image = image;
	}
	
}