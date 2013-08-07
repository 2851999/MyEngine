/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.button;

import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIImageCheckBox extends GUICheckBox {
	
	/* The images */
	public Image[] images;
	
	/* The constructor */
	public GUIImageCheckBox(String name , Image[] images) {
		//Call the super constructor
		super(name);
		//Set the default values of the variables
		this.images = images;
		//Set the width and height of the box
		this.width = images[0].getWidth();
		this.height = images[0].getHeight();
	}
	
	/* The render method */
	public void render() {
		//Render the check box based on whether it is checked or not
		
		//Set the colour to white
		BasicRenderer.setColour(Colour.WHITE);
		
		//The image to be rendered
		Image renderImage = null;
		
		//Check what image should be used then set it
		if (this.checked && this.selected && this.images.length == 4) {
			renderImage = this.images[3];
		} else if (this.checked && ! this.selected && this.images.length == 4) {
			renderImage = this.images[2];
		} else if (this.selected && this.images.length == 4) {
			renderImage = this.images[1];
		} else if (this.checked && this.images.length == 2) {
			renderImage = this.images[1];
		} else if (this.checked && this.images.length == 3) {
			renderImage = this.images[2];
		} else if (this.selected && this.images.length == 3) {
			renderImage = this.images[1];
		} else {
			renderImage = this.images[0];
		}
		
		BasicRenderer.renderImage(renderImage , this.position.x , this.position.y , this.width , this.height);
		
	}
	
}