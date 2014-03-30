/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game2d.entity;

import org.simplecorporation.myengine.core.image.Image;

public class AnimatedImageEntity2D extends ImageEntity2D {
	
	/* The images */
	public Image[] images;
	
	/* The wait time between images */
	public long waitTime;
	
	/* The current image */
	public int currentImage;
	
	/* The last time */
	public long lastTime;
	
	/* Should the animation repeat */
	public boolean repeat;
	
	/* Is the animation running */
	public boolean running;
	
	/* The constructor */
	public AnimatedImageEntity2D(Image[] images , long waitTime) {
		//Assign the variables
		this.images = images;
		this.waitTime = waitTime;
		this.currentImage = 0;
		this.lastTime = System.currentTimeMillis();
		this.repeat = false;
		this.running = false;
		
		//Assign the first image
		this.setImage(this.images[0]);
	}
	
	/* The update method */
	protected void entityUpdate() {
		//Check if the animation is running
		if (this.running) {
			//Check if the right time has passed
			if (System.currentTimeMillis() - this.lastTime >= this.waitTime) {
				//Check if the animation has finished
				if (this.currentImage >= this.images.length - 1) {
					//Check if it should repeat
					if (this.repeat) {
						//Reset the animation
						this.currentImage = 0;
					} else {
						this.running = false;
					}
				} else {
					//Increase the image
					this.currentImage ++;
				}
				//Set the image
				this.setImage(this.images[this.currentImage]);
				//Set the last time
				this.lastTime = System.currentTimeMillis();
			}
		}
	}
	
	/* The method to start the animation */
	public void start() {
		//Set the variables
		this.currentImage = 0;
		this.running = true;
	}
	
	/* The method to start the animation from the desired frame */
	public void start(int frame) {
		//Set the variables
		this.currentImage = frame;
		this.running = true;
	}
	
	/* The method to stop the animation */
	public void stop() {
		//Set running to false
		this.running = false;
	}
	
	/* The method to reset the animation */
	public void reset() {
		//Reset the variables
		this.running = false;
		this.currentImage = 0;
		this.setImage(this.images[0]);
	}
	
	/* The method to reset the animation to a desired frame */
	public void reset(int frame) {
		//Reset the variables
		this.running = false;
		this.currentImage = frame;
		this.setImage(this.images[frame]);
	}
	
}