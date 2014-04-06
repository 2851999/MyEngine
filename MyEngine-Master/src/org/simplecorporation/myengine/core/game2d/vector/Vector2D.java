/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game2d.vector;

public class Vector2D {
	
	/* The x value */
	public double x;
	
	/* The y value */
	public double y;
	
	/* The constructor */
	public Vector2D() {
		//Set the x and y values to 0
		this.x = 0;
		this.y = 0;
	}
	
	/* The constructor with the x and y values given */
	public Vector2D(double x , double y) {
		//Assign the x and y values
		this.x = x;
		this.y = y;
	}
	
	/* The method that adds a vector to this vector then
	 * returns the vector */
	public Vector2D add(Vector2D other) {
		//Return the new vector
		return new Vector2D(this.x + other.x, this.y + other.y);
	}
	
	/* The method that adds a value to this vector then
	 * returns the vector */
	public Vector2D add(double value) {
		//Return the new vector
		return new Vector2D(this.x + value, this.y + value);
	}
	
	/* The method that minus's a vector from this vector then
	 * returns the vector */
	public Vector2D minus(Vector2D other) {
		//Return the new vector
		return new Vector2D(this.x - other.x, this.y - other.y);
	}
	
	/* The method that minus's a value to this vector then
	 * returns the vector */
	public Vector2D minus(double value) {
		//Return the new vector
		return new Vector2D(this.x - value, this.y - value);
	}
	
	/* The method that multiply's this vector using another vector then
	 * returns the vector */
	public Vector2D multiply(Vector2D other) {
		//Return the new vector
		return new Vector2D(this.x * other.x, this.y * other.y);
	}
	
	/* The method that multiply's this vector using a value then
	 * returns the vector */
	public Vector2D multiply(double value) {
		//Return the new vector
		return new Vector2D(this.x * value, this.y * value);
	}
	
	/* The method that divides this vector using another vector then
	 * returns the vector */
	public Vector2D divide(Vector2D other) {
		//Return the new vector
		return new Vector2D(this.x / other.x, this.y / other.y);
	}
	
	/* The method that divides this vector using a value then
	 * returns the vector */
	public Vector2D divide(double value) {
		//Return the new vector
		return new Vector2D(this.x / value, this.y / value);
	}
	
	/* The method to clone this Vector2D */
	public Vector2D clone() {
		//Return a clone
		return new Vector2D(x , y);
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
	
	/* The method to get this vector as a point */
	public Vector2D asPoint() {
		//The x and y values
		double newX = this.x;
		double newY = this.y;
		//Check if the x/y is less than 0
		if (newX < 0) newX *= -1;
		if (newY < 0) newY *= -1;
		//Return the new vector
		return new Vector2D(newX, newY);
	}
	
	/* The method to get this vector as a direction */
	public Vector2D asDirection() {
		//The new x and y values
		double newX = this.x;
		double newY = this.y;
		//Check if the x/y is more than/less than 0
		if (newX > 0) newX = 1;
		else if (newX < 0) newX = -1;
		if (newY > 0) newY = 1;
		else if (newY < 0) newY = -1;
		//Return the new vector
		return new Vector2D(newX, newY);
	}
	
	/* The method that returns this vectors magnitude (Length) */
	public double getLength() {
		//Return the value (a^2 + b^2 = c^2)
		return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}
	
	/* The method that returns this vectors magnitude (Length) squared */
	public double getLengthSquared() {
		//Return the value (a^2 + b^2 = c^2)
		return Math.pow(this.getLength(), 2);
	}
	
}