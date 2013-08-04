/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game.entity;

import org.simplecorporation.myengine.core.point.Point2D;

public class Entity2D {
	
	/* The position of the entity */
	public Point2D position;
	
	/* The velocity of the entity */
	public Point2D velocity;
	
	/* The width of the entity */
	public double width;
	
	/* The height of the entity */
	public double height;
	
	/* The constructor */
	public Entity2D() {
		//Set all of the variables
		this.position = new Point2D();
		this.velocity = new Point2D();
		this.width = 0;
		this.height = 0;
	}
	
	/* The constructor with the position given */
	public Entity2D(Point2D position) {
		//Set all of the variables
		this.position = position;
		this.velocity = new Point2D();
		this.width = 0;
		this.height = 0;
	}
	
	/* The constructor with the position and velocity given */
	public Entity2D(Point2D position , Point2D velocity) {
		//Set all of the variables
		this.position = position;
		this.velocity = velocity;
		this.width = 0;
		this.height = 0;
	}
	
	/* The constructor with the position and width and height given */
	public Entity2D(Point2D position , double width , double height) {
		//Set all of the variables
		this.position = position;
		this.velocity = new Point2D();
		this.width = width;
		this.height = height;
	}
	
	/* The constructor with the position and velocity and width and height given */
	public Entity2D(Point2D position , Point2D velocity , double width , double height) {
		//Set all of the variables
		this.position = position;
		this.velocity = velocity;
		this.width = width;
		this.height = height;
	}
	
	/* The update method */
	public void update() {
		//Add the velocity to the position
		this.position.add(this.velocity);
	}
	
	/* The render method */
	public void render() {
		
	}
	
}