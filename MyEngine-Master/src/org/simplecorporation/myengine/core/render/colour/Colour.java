/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.render.colour;

public class Colour {
	
	/* The predefined colours */
	public static final Colour BLACK = new Colour(0f , 0f , 0f , 1f);
	public static final Colour RED = new Colour(1f , 0f , 0f , 1f);
	public static final Colour YELLOW = new Colour(1f , 1f , 0f , 1f);
	public static final Colour PINK = new Colour(1f , 0f , 1f , 1f);
	public static final Colour GREEN = new Colour(0f , 1f , 0f , 1f);
	public static final Colour LIGHT_BLUE = new Colour(0f , 1f , 1f , 1f);
	public static final Colour BLUE = new Colour(0f , 0f , 1f , 1f);
	public static final Colour WHITE = new Colour(1f , 1f , 1f , 1f);
	
	/* The red value */
	public float r;
	
	/* The green value */
	public float g;
	
	/* The blue value */
	public float b;
	
	/* The alpha value */
	public float a;
	
	/* The constructor of a colour */
	public Colour(float r , float g , float b , float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
}