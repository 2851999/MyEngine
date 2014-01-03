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

public class CollisionResolver {
	
	/* The constructor */
	public CollisionResolver() {
		
	}
	
	/* The method used to resolve a collision */
	public void resolveCollision(Manifold manifold) {
		//Calculate the relative velocity
		Vector2D rv = manifold.objectB.entity.velocity.minus(manifold.objectA.entity.velocity);
		//Calculate the relative velocity in terms of the normal direction
		double velAlongNormal = PhysicsUtils.calculateDotProduct(rv, manifold.normal);
		//Make sure the velocities are going towards each other
		if (! (velAlongNormal > 0)) {
			//Calculate resitution (elasticity)
			double e = Math.min(manifold.objectA.restitution, manifold.objectB.restitution);
			//Calculate the impulse scalar
			double j = -(1 + e) * velAlongNormal;
			j /= 1 / manifold.objectA.mass + 1 / manifold.objectB.mass;
			//Apply impulse
			Vector2D impulse = manifold.normal.multiply(j);
			manifold.objectA.entity.velocity = manifold.objectA.entity.velocity.minus(impulse.multiply(manifold.objectA.inverseMass));
			manifold.objectB.entity.velocity = manifold.objectB.entity.velocity.add(impulse.multiply(manifold.objectB.inverseMass));
			//Apply positional correction (May not be needed)
			//this.positionalCorrection(manifold);
		}
	}
	
	/* The method used to correct the object positions
	 * using linear projection. Error caused by [Floating point error IEEE754]
	 * NOTE: May not be needed*/
	public void positionalCorrection(Manifold manifold) {
		//The percentage (Usually 20 - 80 %)
		double percent = 0.2;
		//The penetration threshold (Stops objects moving rapidly when on top of each other)
		double slop = 0.01;
		//The correction amount
		Vector2D correction = manifold.n.multiply(Math.max(manifold.penetrationDistance - slop, 0.0f) / (manifold.objectA.inverseMass + manifold.objectB.inverseMass) * percent);
		//Apply the correction
		manifold.objectA.entity.position = manifold.objectA.entity.position.minus(correction.multiply(manifold.objectA.inverseMass));
		manifold.objectB.entity.position = manifold.objectB.entity.position.add(correction.multiply(manifold.objectB.inverseMass));
	}
	
}