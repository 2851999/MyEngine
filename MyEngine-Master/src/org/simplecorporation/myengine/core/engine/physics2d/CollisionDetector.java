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

import org.simplecorporation.myengine.core.engine.physics2d.PhysicsObject2D.Type;
import org.simplecorporation.myengine.core.game2d.vector.Vector2D;


public class CollisionDetector {
	
	/* The last manifold created */
	public Manifold manifold;
	
	/* The constructor */
	public CollisionDetector() {
		//Create the manifold
		this.manifold = new Manifold();
	}
	
	/* The method called to check a collision between two physics objects */
	public boolean checkCollision(PhysicsObject2D objectA, PhysicsObject2D objectB) {
		//Make sure both objects are affected by collisions
		if (objectA.affectedByCollisions && objectB.affectedByCollisions) {
			//Check the object types
			if (objectA.type == Type.AABB && objectB.type == Type.AABB) {
				//Check for a collision
				return this.checkAABBvsAABB(objectA, objectB);
			} else if (objectA.type == Type.Circle && objectB.type == Type.Circle) {
				//Check for a collision
				return this.checkCirclevsCircle(objectA, objectB);
			} else if ((objectA.type == Type.Circle && objectB.type == Type.AABB) || (objectA.type == Type.AABB || objectB.type == Type.Circle)) {
				//The AABB object
				PhysicsObject2D box = null;
				//The circle object
				PhysicsObject2D circle = null;
				//Check which one is the circle
				if (objectA.type == Type.Circle) {
					circle = objectA;
					box = objectB;
				} else if (objectB.type == Type.Circle) {
					circle = objectB;
					box = objectA;
				}
				//Check for a collision
				return this.checkAABBvsCircle(box, circle);
			}
		}
		//Return false because one/both of the objects are not affected by collisions
		return false;
	}
	
	/* The method used to check a collision between two AABB's using SAT */
	public boolean checkAABBvsAABB(PhysicsObject2D a, PhysicsObject2D b) {
		//Create a new manifold
		this.manifold = new Manifold();
		//Set the objects in the manifold
		this.manifold.objectA = a;
		this.manifold.objectB = b;
		//The AABB's
		AABB boxA = a.getAABB();
		AABB boxB = b.getAABB();
		//Get the vector between the objects (Might need to be centre of objects)
		Vector2D n = new Vector2D(b.entity.position.x + b.entity.width / 2, b.entity.position.y + b.entity.height / 2)
						.minus(new Vector2D(a.entity.position.x + a.entity.width / 2, a.entity.position.y + a.entity.height / 2));
		//Assign the manifold's n value
		this.manifold.n = n;
		//Calculates half extents along the x axis for each object
		double aExtentX = (boxA.max.x - boxA.min.x) / 2;
		double bExtentX = (boxB.max.x - boxB.min.x) / 2;
		//Calculate half extents along the x axis
		double xOverlap = aExtentX + bExtentX - Math.abs(n.x);
		//SAT test on the x axis
		if (xOverlap > 0) {
			//Calculate half of the extents along the y axis for each object 
			double aExtentY = (boxA.max.y - boxA.min.y) / 2;
			double bExtentY = (boxB.max.y - boxB.min.y) / 2;
			//Calculate the overlap on the y axis
			double yOverlap = aExtentY + bExtentY - Math.abs(n.y);
			//SAT test on y axis
			if (yOverlap > 0) {
				//Find out which axis is the axis with the least penetration (>) didn't work
				if (xOverlap < yOverlap) {
					//Point towards B knowing that n points from A to B
					if (n.x < 0)
						//Set the normal in the manifold
						this.manifold.normal = new Vector2D(-1, 0);
					else
						//Set the normal in the manifold (0,0) didn't work
						this.manifold.normal = new Vector2D(1, 0);
					//Set the penetration distance in the manifold
					this.manifold.penetrationDistance = xOverlap;
					//Return true as there has been a collision
					return true;
				} else {
					//Point towards B knowing that n points from A to B
					if (n.y < 0)
						//Set the normal in the manifold
						this.manifold.normal = new Vector2D(0, -1);
					else
						//Set the normal in the manifold
						this.manifold.normal = new Vector2D(0, 1);
					//Set the penetration distance in the manifold
					this.manifold.penetrationDistance = yOverlap;
					//Return true as there has been a collision
					return true;
				}
			}
		}
		//Return false as there has not been a collision
		return false;
	}
	
	/* The method used to check a collision between two Circles
	 * NOTE: Not using square root to increase performance */
	public boolean checkCirclevsCircle(PhysicsObject2D a, PhysicsObject2D b) {
		//Create a new manifold
		this.manifold = new Manifold();
		//The circles
		Circle circleA = a.getCircle();
		Circle circleB = b.getCircle();
		//Get the vector between the objects (Might need to be centre of objects)
		Vector2D n = new Vector2D(b.entity.position.x + b.entity.width / 2, b.entity.position.y + b.entity.height / 2)
						.minus(new Vector2D(a.entity.position.x + a.entity.width / 2, a.entity.position.y + a.entity.height / 2));
		//Assign the manifold 'n' variable
		this.manifold.n = n;
		//The total of both of the circles radius's
		double r = circleA.radius + circleB.radius;
		//Times r by it self (Square it)
		r *= r;
		
		//Check whether the objects are colliding
		if (! (n.getLengthSquared() > r)) {
			//The circles have collided so create the manifold
			
			//Get the magnitude (Length) of the distance vector
			double d = n.getLength();
			
			//Set the objects in the manifold
			this.manifold.objectA = a;
			this.manifold.objectB = b;
			
			//Check if the distance between the circles are not 0
			if (d != 0) {
				//Calculate the penetration distance
				//Difference between radius and distance
				this.manifold.penetrationDistance = r - d;
				//Calculate the normal (Could be t/d)
				this.manifold.normal = n.asDirection();
				//Return true
				return true;
			} else {
				//Choose random but consistent values
				this.manifold.penetrationDistance = circleA.radius;
				this.manifold.normal = new Vector2D(1, 0);
				//Return true
				return true;
			}
		} else {
			//No collision, return false
			return false;
		}
	}
	
	/* The method used to check a collision between an AABB and a Circle */
	public boolean checkAABBvsCircle(PhysicsObject2D a, PhysicsObject2D b) {
		//Create a new manifold
		this.manifold = new Manifold();
		//The circles
		AABB box = a.getAABB();
		Circle circle = b.getCircle();
		//Get the vector between the objects (Might need to be centre of objects)
		Vector2D n = new Vector2D(b.entity.position.x + b.entity.width / 2, b.entity.position.y + b.entity.height / 2)
						.minus(new Vector2D(a.entity.position.x + a.entity.width / 2, a.entity.position.y + a.entity.height / 2));
		//Assign the manifold 'n' variable
		this.manifold.n = n;
		//Set the objects in the manifold
		this.manifold.objectA = a;
		this.manifold.objectB = b;
		//The closest point on A to centre of B
		//MUST WORK OUT VALUE OF N HERE AS WELL OTHERWISE INSIDE ALWAYS EQUAL TO 2
		Vector2D closest = new Vector2D(b.entity.position.x + b.entity.width / 2, b.entity.position.y + b.entity.height / 2)
						.minus(new Vector2D(a.entity.position.x + a.entity.width / 2, a.entity.position.y + a.entity.height / 2));
		//Calculate half extents along each axis
		double xExtent = (box.max.x - box.min.x) / 2;
		double yExtent = (box.max.y - box.min.y) / 2;
		//Clamp the closest point to the edges of the AABB
		closest.x = PhysicsUtils.clampValue(-xExtent, xExtent, closest.x);
		closest.y = PhysicsUtils.clampValue(-yExtent, yExtent, closest.y);
		//The boolean that states whether one object is inside the other
		boolean inside = false;
		//Circle is inside the AABB, so clamp the circles centre to the closest edge
		if ((n.x == closest.x) && (n.y == closest.y)) {
			//Set inside to true
			inside = true;
			//Find closest axis
			if (Math.abs(n.x) > Math.abs(n.y)) {
				//Clamp to the closest extent
				if (closest.x > 0)
					//Assign the closest x
					closest.x = xExtent;
				else
					//Assign the closest x
					closest.x = -xExtent;
				//Y is shorter
			} else {
				//Clamp to the closest extent
				if (closest.y > 0)
					//Assign the closest y
					closest.y = yExtent;
				else
					//Assign the closest y
					closest.y = -yExtent;
			}
		}
		
		//Calculate the normal vector
		Vector2D normal = n.minus(closest);
		//Get the normal length
		double d = normal.getLengthSquared();
		//Get the radius of the circle
		double r = circle.radius;
		
		//Radius is shorter than distance to closest point and Circle not inside the AABB
		if (d > r * r && !inside) {
			//Return false
			return false;
		} else {
			//Square root the normal length again
			d = Math.sqrt(d);
			//Check if the collision normal needs to be flipped to point outside
			//(Circle inside the AABB)
			if (inside) {
				//Set the normal vector in the manifold
				this.manifold.normal = new Vector2D(-n.asDirection().x, -n.asDirection().y);
				//Set the penetration distance in the manifold
				this.manifold.penetrationDistance = r + d;
			} else {
				//Set the normal vector in the manifold
				this.manifold.normal = n.asDirection();
				//Set the penetration distance in the manifold
				this.manifold.penetrationDistance = r + d;
			}
			//Return true as a collision has occurred
			return true;
		}
	}
	
}