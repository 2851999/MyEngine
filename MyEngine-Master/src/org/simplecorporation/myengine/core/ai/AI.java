/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.ai;

public abstract class AI implements BaseAI {
	
	/* The name of the AI */
	public String name;
	
	/* The description of the AI*/
	public String description;
	
	/* The abstract void to run a certain operation */
	public abstract void run(String operation);
	
	/* The constructor */
	public AI(String name , String description) {
		//Assign the variables
		this.name = name;
		this.description = description;
	}
	
	/* Returns the name of the AI */
	public String getName() {
		//Return the name
		return this.name;
	}
	
	/* Returns the description of the AI */
	public String getDescription() {
		//Return the description
		return this.description;
	}
	
}