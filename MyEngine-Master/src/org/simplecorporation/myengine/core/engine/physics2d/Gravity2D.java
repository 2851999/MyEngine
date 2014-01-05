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

import org.simplecorporation.myengine.core.game2d.entity.Entity2D;
import org.simplecorporation.myengine.core.game2d.vector.Vector2D;

public class Gravity2D extends PhysicsObject2D {
	
	/* The gravitational constant */
	public static double GRAVITATIONAL_CONSTANT = 6.67384*Math.pow(10, -11);
	
	/* The current gravitational constant */
	public double g;
	
	/* The pixels in a meter */
	public double pixelsInMeter;
	
	/* The constructor */
	public Gravity2D(Entity2D entity, double mass, Type type) {
		//Call the super constructor
		super(entity, mass, type);
		//Assign the variables
		this.g = GRAVITATIONAL_CONSTANT;
		this.pixelsInMeter = 1;
	}
	
	/* The method used by objects to update additional physics */
	public void updateAdditional(PhysicsScene2D scene) {
		//Look at every object in the scene
		for (int count = 0; count < scene.physicsObjects.size(); count++) {
			//Make sure the current object isn't this
			if (scene.physicsObjects.get(count) != this) {
				//Get the current physics object
				PhysicsObject2D currentPhysicsObject = scene.physicsObjects.get(count);
				//Apply gravity to the current object
				this.applyGravity(currentPhysicsObject);
			}
		}
	}
	
	/* The method used to apply gravity to an object */
	public void applyGravity(PhysicsObject2D physicsObject) {
		//Make sure the object can be affected by gravity
		if (physicsObject.affectedByGravity) {
			//Calculate the centre of this object as a vector
			Vector2D centreOfThis = new Vector2D((this.entity.position.x + this.entity.width) / 2, (this.entity.position.y + this.entity.height) / 2);
			//Calculate the centre of the other object
			Vector2D centreOfOther = new Vector2D((physicsObject.entity.position.x + physicsObject.entity.width) / 2, (physicsObject.entity.position.y + physicsObject.entity.height) / 2);
			
			//Create point versions of the vectors
			Vector2D centreOfThisPoint = centreOfThis.asPoint();
			Vector2D centreOfOtherPoint = centreOfOther.asPoint();
			
			//To calculate distance between two objects you need to use pythagorus's theorem
			//NOTE using square root is not very efficient and may impact on the performance
			
			//a^2 + b^2 = c^2
			
			//Work out the value of a and b
			double a = centreOfThisPoint.y - centreOfOtherPoint.y;
			double b = centreOfThisPoint.x - centreOfOtherPoint.x;
			
			//Work out the direction this should move (needed later)
			Vector2D directionToMove = new Vector2D(b, a).asDirection();
			
			//Work out the value of c
			double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
			
			//Work out the value of r (Divide by pixels in a meter)
			double r = c / this.pixelsInMeter;
			
			//Calculate the force of gravity
			//F = G * (m1*m2 / r^2)
			double f = this.g * ((this.mass * physicsObject.mass) / r);
			
			//Calculate the require acceleration (F=MA, A = F/M)
			physicsObject.acceleration.x += (f / this.mass) * directionToMove.x;
			physicsObject.acceleration.y += (f / this.mass) * directionToMove.y;
			
			//Check if the acceleration direction should be changed
			if (physicsObject.acceleration.asDirection().x != directionToMove.x)
				physicsObject.acceleration.x *= -1;
			if (physicsObject.acceleration.asDirection().y != directionToMove.y)
				physicsObject.acceleration.y *= -1;
		}
	}
	
}