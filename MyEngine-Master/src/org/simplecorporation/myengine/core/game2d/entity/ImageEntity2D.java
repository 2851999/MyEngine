/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game2d.entity;

import org.simplecorporation.myengine.core.game2d.vector.Vector2D;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

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
	public ImageEntity2D(Image image , Vector2D position) {
		//Call the super constructor
		super(position);
		//Assign the image
		this.image = image;
		//Set the width and height
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
	}
	
	/* The constructor with the image and position and velocity given */
	public ImageEntity2D(Image image , Vector2D position , Vector2D velocity) {
		//Call the super constructor
		super(position , velocity);
		//Assign the image
		this.image = image;
		//Set the width and height
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
	}
	
	/* The constructor with the image and position and width and height given */
	public ImageEntity2D(Image image , Vector2D position , double width , double height) {
		//Call the super constructor
		super(position , width , height);
		//Assign the image
		this.image = image;
		//Set the width and height
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
	}
	
	/* The constructor with the image and position and velocity and width and height given */
	public ImageEntity2D(Image image , Vector2D position , Vector2D velocity , double width , double height) {
		//Call the super constructor
		super(position , velocity , width , height);
		//Assign the image
		this.image = image;
		//Set the width and height
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
	}
	
	/* The entity's update method */
	protected void entityUpdate() {
		
	}
	
	/* The entity's render method */
	protected void entityRender() {
		//Set the colour
		BasicRenderer.setColour(Colour.WHITE);
		//Render the image
		BasicRenderer.renderImage(this.image , this.position.x , this.position.y  , this.width , this.height , this.rotation);
	}
	
	/* The method to set the image */
	public void setImage(Image image) {
		//Set the image
		this.image = image;
	}
	
}