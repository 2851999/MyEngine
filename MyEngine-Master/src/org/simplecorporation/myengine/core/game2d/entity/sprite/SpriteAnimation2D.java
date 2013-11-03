/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game2d.entity.sprite;

import org.simplecorporation.myengine.core.game2d.entity.AnimatedImageEntity2D;
import org.simplecorporation.myengine.core.image.Image;

public class SpriteAnimation2D extends AnimatedImageEntity2D {
	
	/* The name of the animation */
	public String name;
	
	/* The id of the animation */
	public int id;
	
	/* The constructor */
	public SpriteAnimation2D(String name , int id , Image[] images , long timeBetweenFrame) {
		//Call the super constructor
		super(images , timeBetweenFrame);
		//Assign the variables
		this.name = name;
		this.id = id;
	}
	
}