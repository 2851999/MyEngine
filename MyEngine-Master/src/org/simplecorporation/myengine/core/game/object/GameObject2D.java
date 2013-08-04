/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game.object;

import org.simplecorporation.myengine.core.game.entity.AbstractEntity2D;
import org.simplecorporation.myengine.core.point.Point2D;

public class GameObject2D extends AbstractEntity2D {
	
	/* EFFECTS LINKED LIST WILL GO HERE */
	
	/* The constructor */
	public GameObject2D() {
		//Call the super constructor
		super();
	}
	
	/* The constructor with the position given */
	public GameObject2D(Point2D position) {
		//Call the super constructor
		super(position);
	}
	
	/* The constructor with the position and velocity given */
	public GameObject2D(Point2D position , Point2D velocity) {
		//Call the super constructor
		super(position , velocity);
	}
	
	/* The constructor with the position and width and height given */
	public GameObject2D(Point2D position , double width , double height) {
		//Call the super constructor
		super(position , width , height);
	}
	
	/* The constructor with the position and velocity and width and height given */
	public GameObject2D(Point2D position , Point2D velocity , double width , double height) {
		//Call the super constructor
		super(position , velocity , width , height);
	}
	
	/* The entity's update method */
	public void entityUpdate() {
		
	}
	
	/* The entity's render method */
	public void entityRender() {
		
	}
	
}