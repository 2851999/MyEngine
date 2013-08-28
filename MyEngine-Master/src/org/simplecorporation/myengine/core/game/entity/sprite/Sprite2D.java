/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game.entity.sprite;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.game.entity.ImageEntity2D;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class Sprite2D extends ImageEntity2D {
	
	/* The animations */
	public LinkedList<SpriteAnimation2D> animations;
	
	/* The current animation */
	public SpriteAnimation2D currentAnimation;
	
	/* The default image for when the animation is not running */
	public Image defaultImage;
	
	/* The constructor */
	public Sprite2D(Image image) {
		//Call the super constructor
		super(image);
		//Create the animations linked list
		this.animations = new LinkedList<SpriteAnimation2D>();
		//Set the current animation to null
		this.currentAnimation = null;
		//Set the default image
		this.defaultImage = image;
	}
	
	/* The entity's update method */
	protected void entityUpdate() {
		//Check if the animation is running
		if (this.currentAnimation != null) {
			if (this.currentAnimation.running) {
				//Update the animation
				this.currentAnimation.update();
				//Set the image
				this.image = this.currentAnimation.images[this.currentAnimation.currentImage];
			} else {
				//Set the default image
				this.image = defaultImage;
				//Set the current animation to null
				this.currentAnimation = null;
			}
		}
	}
	
	/* The method to start an animation */
	public void startAnimation(SpriteAnimation2D spriteAnimation) {
		//Set the current animation
		this.currentAnimation = spriteAnimation;
		//Start the animation
		this.currentAnimation.start();
	}
	
	/* The method to start an animation given its starting frame */
	public void startAnimation(SpriteAnimation2D spriteAnimation , int start) {
		//Set the current animation
		this.currentAnimation = spriteAnimation;
		//Start the animation
		this.currentAnimation.start(start);
	}
	
	/* The method to stop the current animation */
	public void stopAnimation() {
		//Make sure the current animation is not null
		if (this.currentAnimation != null)
			//Stop the animation
			this.currentAnimation.stop();
	}
	
	/* The method to get an animation based on its name */
	public SpriteAnimation2D getAnimationByName(String name) {
		//The sprite animation
		SpriteAnimation2D spriteAnimation = null;
		
		//Loop
		for (int a = 0; a < this.animations.size(); a++) {
			//Check the name of the current animation in the list
			if (this.animations.get(a).name.equals(name)) {
				//Set the sprite animation
				spriteAnimation = this.animations.get(a);
				//Exit the loop
				break;
			}
		}
		
		//Check if the sprite animation wasn't found
		if (spriteAnimation == null)
			//Log a message
			Logger.log(new Log("Sprite2D getAnimationByName()" , "The animation " + name + " was not found" , LogType.ERROR));
		
		//Return the animation
		return spriteAnimation;
	}
	
	/* The method to get an animation based on its id */
	public SpriteAnimation2D getAnimationById(int id) {
		//The sprite animation
		SpriteAnimation2D spriteAnimation = null;
		
		//Loop
		for (int a = 0; a < this.animations.size(); a++) {
			//Check the name of the current animation in the list
			if (this.animations.get(a).id == id) {
				//Set the sprite animation
				spriteAnimation = this.animations.get(a);
				//Exit the loop
				break;
			}
		}
		
		//Check if the sprite animation wasn't found
		if (spriteAnimation == null)
			//Log a message
			Logger.log(new Log("Sprite2D getAnimationById()" , "The animation " + id + " was not found" , LogType.ERROR));
		
		//Return the animation
		return spriteAnimation;
	}
	
	/* The method to add an animation */
	public void addAnimation(SpriteAnimation2D spriteAnimation) {
		//Add the animation
		this.animations.add(spriteAnimation);
	}
	
}