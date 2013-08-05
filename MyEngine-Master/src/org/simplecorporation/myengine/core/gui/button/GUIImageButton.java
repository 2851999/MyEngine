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

import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;

public class GUIImageButton extends GUIButton {
	
	/* The text */
	public String text;
	
	/* The images */
	public Image[] images;
	
	/* The font */
	public GUIFont font;
	
	/* The constructor */
	public GUIImageButton(String name , String text , Image[] images , GUIFont font) {
		//Call the super constructor
		super(name);
		//Assign the text
		this.text = text;
		//Assign the images
		this.images = images;
		//Assign the font
		this.font = font;
		//Set the width and height of the button
		this.width = images[0].getWidth();
		this.height = images[0].getHeight();
	}
	
	/* The method to render the button */
	public void render() {
		//The current image
		Image current = null;
		//Render the right image
		if (! this.selected && ! this.clicked)
			current = this.images[0];
		else if (this.selected && this.images.length > 1)
			current = this.images[1];
		else if (this.clicked && this.images.length > 2)
			current = this.images[2];
		//Render the image
		BasicRenderer.renderImage(current , this.position.x , this.position.y , this.width , this.height);
		//Render the font
		this.font.render(this.text , (this.position.x + (this.width) / 2) - (this.font.getWidth(this.text) / 2) ,
				(this.position.y + (this.height / 2)) - (this.font.getHeight(this.text) / 2));
		System.out.println(this.font.getHeight(this.text));
	}
	
}