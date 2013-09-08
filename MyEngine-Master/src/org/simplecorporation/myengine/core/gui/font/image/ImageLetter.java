/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.font.image;

import org.simplecorporation.myengine.core.image.Image;

public class ImageLetter extends Image {
	
	/* The letter character */
	public char character;
	
	/* The constructor */
	public ImageLetter(char character , String imagePath , String imageFormat , boolean inFolder) {
		//Call the super constructor
		super(imagePath , imageFormat , inFolder);
		//Set the character
		this.character = character;
	}
	
}