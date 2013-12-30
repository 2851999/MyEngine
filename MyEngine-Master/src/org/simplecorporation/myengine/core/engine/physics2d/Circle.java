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

public class Circle {
	
	/* The position of this circle */
	public Vector2D position;
	
	/* The radius of this circle */
	public double radius;
	
	/* The constructor */
	public Circle() {
		//Assign the variables
		this.position = new Vector2D();
		this.radius = 0;
	}
	
	/* The constructor with the position and radius given */
	public Circle(Vector2D position, double radius) {
		//Assign the variables
		this.radius = radius;
		this.position = position;
	}
	
}