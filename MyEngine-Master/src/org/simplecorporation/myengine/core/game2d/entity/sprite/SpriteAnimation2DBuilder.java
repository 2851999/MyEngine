/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game2d.entity.sprite;

import org.simplecorporation.myengine.core.image.Image;

public class SpriteAnimation2DBuilder {
	
	/* The method to build a sprite animation using a string array */
	public SpriteAnimation2D buildSpriteAnimation2D(String[] spriteAnimationArray) {
		//Get the name of the animation
		String spriteAnimationName = spriteAnimationArray[0];
		//Get the id of the animation
		int spriteAnimationId = Integer.parseInt(spriteAnimationArray[1]);
		//The delay between frames
		long timeBetweenFrames = Long.parseLong(spriteAnimationArray[2]);
		//The format of the images
		String imageFormat = spriteAnimationArray[3];
		//Are the images in a folder
		boolean inFolder = spriteAnimationArray[4].equals("true");
		//The array of images
		Image[] images = new Image[spriteAnimationArray.length - 5];
		//Get the images of the animation
		for (int a = 5; a < spriteAnimationArray.length; a++) {
			//Create the image
			images[a - 5] = new Image(spriteAnimationArray[a] , imageFormat , inFolder);
		}
		//Create and return the sprite animation
		return new SpriteAnimation2D(spriteAnimationName , spriteAnimationId , images , timeBetweenFrames);
	}
	
	/* The method to build a path and number of images */
	public SpriteAnimation2D buildSpriteAnimation2D(String spriteAnimationName , int spriteAnimationId , String imagePath , int numberOfImages ,
			boolean inFolder , long timeBetweenFrames) {
		//The image array
		Image[] images = new Image[numberOfImages];
		//Create the images
		for (int a = 0; a < numberOfImages; a++) {
			images[a] = new Image(imagePath + (a + 1) + ".png" , "PNG" , inFolder);
		}
		//Create and return the sprite animation
		return new SpriteAnimation2D(spriteAnimationName , spriteAnimationId , images , timeBetweenFrames);
	}
	
}