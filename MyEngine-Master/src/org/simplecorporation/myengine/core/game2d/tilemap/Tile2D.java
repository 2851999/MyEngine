/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game2d.tilemap;

import org.simplecorporation.myengine.core.game2d.entity.ImageEntity2D;
import org.simplecorporation.myengine.core.image.Image;

public class Tile2D extends ImageEntity2D {
	
	/* The tile type enum */
	public static enum Type {
		AIR, SOLID
	}
	
	/* The name of this tile */
	public String name;
	
	/* The id of this tile */
	public int id;
	
	/* The tile type */
	public Type type;
	
	/* The constructor of a tile */
	public Tile2D(Image image, String name, int id, Type type) {
		//Call the super constructor
		super(image);
		//Assign the variables
		this.name = name;
		this.id = id;
		this.type = type;
	}
	
}