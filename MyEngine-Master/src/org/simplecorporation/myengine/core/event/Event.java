/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.event;

public class Event {
	
	/* The event name */
	private String name;
	
	/* The event description */
	private String description;
	
	/* The event constructor */
	public Event(String name , String description) {
		//Assign the variables
		this.name = name;
		this.description = description;
	}
	
	/* Returns the name of the event */
	public String getName() {
		return name;
	}
	
	/* Returns the description of the event */
	public String getDescription() {
		return description;
	}
	
}