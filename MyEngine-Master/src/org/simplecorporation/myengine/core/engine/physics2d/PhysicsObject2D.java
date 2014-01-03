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

import org.simplecorporation.myengine.core.game.GameValues;
import org.simplecorporation.myengine.core.game2d.entity.Entity2D;
import org.simplecorporation.myengine.core.game2d.vector.Vector2D;

public class PhysicsObject2D extends PhysicsObjectValues2D {
	
	/* The object types */
	public static enum Type {
		AABB, Circle
	}
	
	/* This objects type */
	public Type type;
	
	/* Can this object move */
	public boolean canMove;
	
	/* Is this object affected by gravity */
	public boolean affectedByGravity;
	
	/* The entity for this object */
	public Entity2D entity;
	
	/* The constructor */
	public PhysicsObject2D(Entity2D entity, double mass , Type type) {
		//Assign the variables
		this.type = type;
		this.entity = entity;
		this.setMass(mass);
	}
	
	/* The method used to update the physics
	 * of this object */
	public void update(PhysicsScene2D scene) {
		//Add onto the velocity based on the acceleration of this
		//object (acceleration = change in velocity / time) the answer
		//is in m/s^2 so to change time into seconds times it by the
		//time between each frame
		this.entity.velocity.x += this.acceleration.x * GameValues.CURRENT_DELTA;
		this.entity.velocity.y += this.acceleration.y * GameValues.CURRENT_DELTA;
		
		//Update any other things (Inherited by other objects)
		this.updateAdditional(scene);
		
		//Update this entity
		this.entity.update();
	}
	
	/* The method used by other objects to update additional physics */
	public void updateAdditional(PhysicsScene2D scene) {
		
	}
	
	/* The method to get this objects AABB */
	public AABB getAABB() {
		//Create an AABB for this object and return it
		return new AABB(
				new Vector2D(this.entity.position.x, this.entity.position.y),
				new Vector2D(this.entity.position.x + this.entity.width, this.entity.position.y + this.entity.height));
	}
	
	/* The method to get this objects Circle */
	public Circle getCircle() {
		//Create a Circle for this object and return it
		return new Circle(
				new Vector2D(this.entity.position.x, this.entity.position.y),
				this.entity.width / 2);
	}
	
}