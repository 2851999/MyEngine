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

public class Manifold {
	
	/* The first object in the collision (Object a) */
	public PhysicsObject2D objectA;
	
	/* The second object in the collision (Object b) */
	public PhysicsObject2D objectB;
	
	/* The penetration depth */
	public double penetrationDistance;
	
	/* The collision normal */
	public Vector2D normal;
	
	/* The vector between the two objects */
	public Vector2D n;
	
	/* The constructor */
	public Manifold() {
		//Assign the variables
		this.objectA = null;
		this.objectB = null;
		this.penetrationDistance = 0;
		this.normal = new Vector2D();
	}
	
}