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
	
	/* The constructor */
	public AI(String name , String description) {
		//Assign the variables
		this.name = name;
		this.description = description;
	}
	
}