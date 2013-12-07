/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game2d.entity;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.effect.Effect;
import org.simplecorporation.myengine.core.game2d.vector.Vector2D;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public abstract class AbstractEntity2D extends Entity2D {
	
	/* The effects linked list */
	public LinkedList<Effect> effects;
	
	/* The abstract method for update */
	protected abstract void entityUpdate();
	
	/* The abstract method for render */
	protected abstract void entityRender();
	
	/* The constructor */
	public AbstractEntity2D() {
		//Call the super constructor
		super();
		//Create the effects linked list
		this.effects = new LinkedList<Effect>();
	}
	
	/* The constructor with the position given */
	public AbstractEntity2D(Vector2D position) {
		//Call the super constructor
		super(position);
		//Create the effects linked list
		this.effects = new LinkedList<Effect>();
	}
	
	/* The constructor with the position and velocity given */
	public AbstractEntity2D(Vector2D position , Vector2D velocity) {
		//Call the super constructor
		super(position , velocity);
		//Create the effects linked list
		this.effects = new LinkedList<Effect>();
	}
	
	/* The constructor with the position and width and height given */
	public AbstractEntity2D(Vector2D position , double width , double height) {
		//Call the super constructor
		super(position , width , height);
		//Create the effects linked list
		this.effects = new LinkedList<Effect>();
	}
	
	/* The constructor with the position and velocity and width and height given */
	public AbstractEntity2D(Vector2D position , Vector2D velocity , double width , double height) {
		//Call the super constructor
		super(position , velocity , width , height);
		//Create the effects linked list
		this.effects = new LinkedList<Effect>();
	}
	
	/* The update method */
	public void update() {
		//Add the velocity to the position
		this.position.add(this.velocity);
		//Add the rotation velocity to the rotation
		this.rotation += this.rotationVelocity;
		//Update all of the effects
		for (int a = 0; a < this.effects.size(); a++) {
			this.effects.get(a).updateEffect();
		}
		//Call the update method
		this.entityUpdate();
	}
	
	/* The render method */
	public void render() {
		//Apply all of the effects
		for (int a = 0; a < this.effects.size(); a++) {
			this.effects.get(a).applyEffect();
		}
		//Call the render method
		this.entityRender();
	}
	
	/* The method to get an effect by its name */
	public Effect getEffectByName(String name) {
		//The effect
		Effect effect = null;
		//Loop
		for (int a = 0; a < this.effects.size(); a++) {
			//Check the name
			if (this.effects.get(a).getName().equals(name)) {
				//Set the effect
				effect = this.effects.get(a);
				//Break out of the loop
				break;
			}
		}
		//Check if the found effect is null
		if (effect == null)
			//Log a message
			Logger.log(new Log("AbstractEntity getEffectByName()" , "Effect not found by the name " + name , LogType.ERROR));
		//Return the effect
		return effect;
	}
	
	/* The method to get an effect by its name */
	public Effect getEffectById(int id) {
		//The effect
		Effect effect = null;
		//Loop
		for (int a = 0; a < this.effects.size(); a++) {
			//Check the name
			if (this.effects.get(a).getId() == id) {
				//Set the effect
				effect = this.effects.get(a);
				//Break out of the loop
				break;
			}
		}
		//Check if the found effect is null
		if (effect == null)
			//Log a message
			Logger.log(new Log("AbstractEntity getEffectByName()" , "Effect not found by the id " + id , LogType.ERROR));
		//Return the effect
		return effect;
	}
	
}