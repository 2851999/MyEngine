/* *********************************************
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

public class PhysicsObjectValues2D {
	
	/* The mass of the object */
	public double mass;
	
	/* The inverse mass of the object */
	public double inverseMass;
	
	/* The acceleration of the object */
	public Vector2D acceleration;
	
	/* The restitution (elasticity) */
	public double restitution;
	
	/* The default constructor */
	public PhysicsObjectValues2D() {
		//Assign the variables
		this.mass = 0;
		this.inverseMass = 0;
		this.acceleration = new Vector2D();
		this.restitution = 0;
	}
	
	/* The method used to set the mass of this object */
	public void setMass(double mass) {
		//Assign the mass and inverse mass
		this.mass = mass;
		//Check the mass value
		if (this.mass == 0)
			//Set the inverse mass to 0 (Avoid / by 0 error) (Mass = 0 = Infinite Mass)	
			this.inverseMass = 0;
		else
			//Set the inverse mass
			this.inverseMass = 1 / this.mass;
	}
	
}