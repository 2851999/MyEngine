/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.render.colour;

public class Colour {
	
	/* The predefined colours */
	public static final Colour BLACK = new Colour(0d , 0d , 0d , 1d);
	public static final Colour GREY = new Colour(0.2d , 0.2d , 0.2d , 1d);
	public static final Colour LIGHT_GREY = new Colour(0.45d , 0.45d , 0.45d , 1d);
	public static final Colour RED = new Colour(1d , 0d , 0d , 1d);
	public static final Colour ORANGE = new Colour(1d , 0.6470588235294118d , 0d , 1d);
	public static final Colour YELLOW = new Colour(1d , 1d , 0d , 1d);
	public static final Colour PINK = new Colour(1d , 0d , 1d , 1d);
	public static final Colour GREEN = new Colour(0d , 1d , 0d , 1d);
	public static final Colour BLUE = new Colour(0d , 0d , 1d , 1d);
	public static final Colour LIGHT_BLUE = new Colour(0d , 1d , 1d , 1d);
	public static final Colour WHITE = new Colour(1d , 1d , 1d , 1d);
	
	/* The red value */
	public double r;
	
	/* The green value */
	public double g;
	
	/* The blue value */
	public double b;
	
	/* The alpha value */
	public double a;
	
	/* The constructor of a colour r,g,b using doubles*/
	public Colour(double r , double g , double b) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = 1.0;
	}
	
	/* The constructor of a colour r,g,b,a using doubles */
	public Colour(double r , double g , double b , double a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	/* The method used to create and return a colour using 3 integers */
	public static Colour create(int r, int g, int b) {
		return new Colour(
				(double)((double) r / (double) 255) ,
				(double)((double) g / (double) 255) ,
				(double)((double) b / (double) 255));
	}
	
	/* The method used to create and return a colour using 4 integers */
	public static Colour create(int r, int g, int b, int a) {
		return new Colour(
				(double)((double) r / (double) 255) ,
				(double)((double) g / (double) 255) ,
				(double)((double) b / (double) 255) ,
				(double)((double) a / (double) 255));
	}
	
	/* The method to clone this colour */
	public Colour clone() {
		return new Colour(this.r , this.g , this.b , this.a);
	}
	
	/* The get/set methods */
	
	public void setColour(Colour colour) {
		this.setR(colour.getR());
		this.setG(colour.getG());
		this.setB(colour.getB());
		this.setA(colour.getA());
	}
	
	public void setColour(int r , int g , int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public void setColour(int r , int g , int b , int a) {
		this.r = r / 255;
		this.g = g / 255;
		this.b = b / 255;
		this.a = a / 255;
	}
	
	public void setColour(double r , double g , double b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public void setColour(double r , double g , double b , double a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public double[] getValues() {
		return new double[] { this.r, this.g, this.b, this.a };
	}
	
	public float[] getFloatValues() {
		return new float[] { (float) this.r, (float) this.g, (float) this.b, (float) this.a };
	}
	
	public void setR(int r) { this.r = r / 255; }
	public void setR(double r) { this.r = r; }
	public void setG(int g) { this.g = g / 255; }
	public void setG(double g) { this.g = g; }
	public void setB(int b) { this.b = b / 255; }
	public void setB(double b) { this.b = b; }
	public void setA(int a) { this.a = a / 255; }
	public void setA(double a) { this.a = a; }
	
	public double getR() { return this.r; }
	public double getG() { return this.g; }
	public double getB() { return this.b; }
	public double getA() { return this.a; }
	
	
}