/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game;

import java.util.LinkedList;

public class GameResourcePack {
	
	/* The name of this resource pack */
	public String name;
	
	/* Are the resources in this pack in a folder */
	public boolean inFolder;
	
	/* The list of directories for each file in this pack */
	public LinkedList<GameResource> resources;
	
	/* The constructor */
	public GameResourcePack(String name, boolean inFolder) {
		//Assign the variables
		this.name = name;
		this.inFolder = inFolder;
		this.resources = new LinkedList<GameResource>();
	}
	
	/* The method to add a resource directory */
	public void addResource(GameResource gameResource) {
		//Add the game resource to the list
		this.resources.add(gameResource);
	}
	
}