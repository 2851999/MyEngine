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

public abstract class AbstractEntity2D extends Entity2D {
	
	/* The abstract method for update */
	public abstract void entityUpdate();
	
	/* The abstract method for render */
	public abstract void entityRender();
	
	/* The constructor */
	public AbstractEntity2D() {
		//Call the super constructor
		super();
	}
	
	/* The constructor with the position given */
	public AbstractEntity2D(Point2D position) {
		//Call the super constructor
		super(position);
	}
	
	/* The constructor with the position and velocity given */
	public AbstractEntity2D(Point2D position , Point2D velocity) {
		//Call the super constructor
		super(position , velocity);
	}
	
	/* The constructor with the position and width and height given */
	public AbstractEntity2D(Point2D position , double width , double height) {
		//Call the super constructor
		super(position , width , height);
	}
	
	/* The constructor with the position and velocity and width and height given */
	public AbstractEntity2D(Point2D position , Point2D velocity , double width , double height) {
		//Call the super constructor
		super(position , velocity , width , height);
	}
	
	/* The update method */
	public void update() {
		//Add the velocity to the position
		this.position.add(this.velocity);
		//Call the update method
		this.entityUpdate();
	}
	
	/* The render method */
	public void render() {
		//Call the render method
		this.entityRender();
	}
	
}