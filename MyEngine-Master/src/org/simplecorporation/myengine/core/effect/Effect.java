/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.effect;

public abstract class Effect {
	
	/* The name of the effect */
	public String name;
	
	/* The description of the effect */
	public String description;
	
	/* The id of the effect */
	public int id;
	
	/* The abstract method to update the effect */
	public abstract void updateEffect();
	
	/* The abstract method to apply the effect */
	public abstract void applyEffect();
	
	/* The abstract method to start the effect */
	public abstract void startEffect();
	
	/* The abstract method to stop the effect */
	public abstract void stopEffect();
	
	/* The constructor of an effect */
	public Effect(String name , String description , int id) {
		//Assign the variables
		this.name = name;
		this.description = description;
		this.id = id;
	}
	
	/* The method that returns the name */
	public String getName() {
		//Return the name
		return this.name;
	}
	
	/* The method that returns the description */
	public String getDescription() {
		//Return the description
		return this.description;
	}
	
	/* The method that returns the id */
	public int getId() {
		//Return the id
		return this.id;
	}
	
}