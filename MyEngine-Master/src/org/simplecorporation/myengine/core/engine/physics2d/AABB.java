/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.physics2d;

import org.simplecorporation.myengine.core.game2d.vector.Vector2D;

public class AABB {
	
	/* The minimum point */
	public Vector2D min;
	
	/* The maximum point */
	public Vector2D max;
	
	/* The constructor */
	public AABB() {
		//Assign the variables
		this.min = new Vector2D();
		this.max = new Vector2D();
	}
	
	/* The constructor with the two vectors given */
	public AABB(Vector2D min, Vector2D max) {
		//Assign the variables
		this.min = min;
		this.max = max;
	}
	
}