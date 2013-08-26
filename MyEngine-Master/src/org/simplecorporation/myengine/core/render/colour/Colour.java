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
	public static final Colour BLACK = new Colour(0d , 0d , 0d , 1d);
	public static final Colour RED = new Colour(1d , 0d , 0d , 1d);
	public static final Colour ORANGE = new Colour(1d , 0.6470588235294118d , 0d , 1d);
	public static final Colour YELLOW = new Colour(1d , 1d , 0d , 1d);
	public static final Colour PINK = new Colour(1d , 0d , 1d , 1d);
	public static final Colour GREEN = new Colour(0d , 1d , 0d , 1d);
	public static final Colour LIGHT_BLUE = new Colour(0d , 1d , 1d , 1d);
	public static final Colour BLUE = new Colour(0d , 0d , 1d , 1d);
	public static final Colour WHITE = new Colour(1d , 1d , 1d , 1d);
	
	/* The red value */
	public double r;
	
	/* The green value */
	public double g;
	
	/* The blue value */
	public double b;
	
	/* The alpha value */
	public double a;
	
	/* The constructor of a colour */
	public Colour(double r , double g , double b , double a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	/* The method to clone this colour */
	public Colour clone() {
		return new Colour(this.r , this.g , this.b , this.a);
	}
	
}