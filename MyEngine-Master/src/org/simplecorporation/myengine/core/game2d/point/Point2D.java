/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game2d.point;

public class Point2D {
	
	/* The x value */
	public double x;
	
	/* The y value */
	public double y;
	
	/* The constructor */
	public Point2D() {
		//Set the x and y values to 0
		this.x = 0;
		this.y = 0;
	}
	
	/* The constructor with the x and y values given */
	public Point2D(double x , double y) {
		//Assign the x and y values
		this.x = x;
		this.y = y;
	}
	
	/* The method that adds a point to this point */
	public void add(Point2D other) {
		//Add the two values
		this.x += other.x;
		this.y += other.y;
	}
	
	/* The method that minus's a point from this point */
	public void minus(Point2D other) {
		//Minus the two values
		this.x -= other.x;
		this.y -= other.y;
	}
	
	/* The method that multiply's this point using another point */
	public void multiply(Point2D other) {
		//Multiply the two values
		this.x *= other.x;
		this.y *= other.y;
	}
	
	/* The method that divides this point using another point */
	public void divide(Point2D other) {
		//Divide the two values
		this.x /= other.x;
		this.y /= other.y;
	}
	
	/* The method to clone this Point2D */
	public Point2D clone() {
		//Return a clone
		return new Point2D(x , y);
	}
	
	/* The method to set the x value */
	public void setX(double x) {
		//Set the x value
		this.x = x;
	}
	
	/* The method to set the y value */
	public void setY(double y) {
		//Set the y value
		this.y = y;
	}
	
	/* The method that returns the x value */
	public double getX() {
		return this.x;
	}
	
	/* The method that returns the y value */
	public double getY() {
		return this.y;
	}
	
}