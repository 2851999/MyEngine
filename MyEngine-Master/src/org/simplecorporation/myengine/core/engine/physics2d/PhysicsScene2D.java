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

import java.util.LinkedList;

public class PhysicsScene2D {
	
	/* The physics objects in this scene */
	public LinkedList<PhysicsObject2D> physicsObjects;
	
	/* The collision detector object */
	public CollisionDetector collisionDetector;
	
	/* The collision resolver object */
	public CollisionResolver collisionResolver;
	
	/* The constructor */
	public PhysicsScene2D() {
		//Assign the variables
		this.physicsObjects = new LinkedList<PhysicsObject2D>();
		this.collisionDetector = new CollisionDetector();
		this.collisionResolver = new CollisionResolver();
	}
	
	/* The method called to update the scene */
	public void update() {
		//Update all of the physics objects
		for (int a = 0; a < this.physicsObjects.size(); a++) {
			//Update the current physics object in the list
			this.physicsObjects.get(a).update(this);
			//Get the current physics object
			PhysicsObject2D objectA = this.physicsObjects.get(a);
			//Check all of the other objects
			for (int b = 0; b < this.physicsObjects.size(); b++) {
				//Make sure the current object is not the same as ObjectA
				if (a != b) {
					//Get the second object
					PhysicsObject2D objectB = this.physicsObjects.get(b);
					//Check for a collision
					if (this.collisionDetector.checkCollision(objectA, objectB))
						//Resolve the collisions
						this.collisionResolver.resolveCollision(this.collisionDetector.manifold);
				}
			}
		}
	}
	
	/* The method called to render the scene */
	public void render() {
		//Render all of the objects
		for (int a = 0; a < this.physicsObjects.size(); a++) {
			//Render the current physics object in the list
			this.physicsObjects.get(a).entity.render();
		}
	}
	
	/* The method used to add a physics object to this scene */
	public void add(PhysicsObject2D physicsObject2D) {
		//Add the physics object to the objects in this scene
		this.physicsObjects.add(physicsObject2D);
	}
	
	/* The method used to clear this scene */
	public void clear() {
		//Clear this scene
		this.physicsObjects.clear();
	}
	
	/* The method used to get the objects in this scene */
	public LinkedList<PhysicsObject2D> getObjects() {
		//Return the physics objects linked list
		return this.physicsObjects;
	}
	
}