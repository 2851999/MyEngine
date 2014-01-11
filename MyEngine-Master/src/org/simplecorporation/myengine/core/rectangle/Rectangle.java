/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.rectangle;

public class Rectangle {
	
	/* The rectangles x position */
	public double x;
	
	/* The rectangles y position */
	public double y;
	
	/* The rectangles width */
	public double width;
	
	/* The rectangles height */
	public double height;
	
	/* The constructor */
	public Rectangle() {
		//Set the variables
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
	}
	
	/* The constructor with the position, width and height given */
	public Rectangle(double x , double y , double width , double height) {
		//Set the variables
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/* The method to check whether a point is contained within the rectangle */
	public boolean contains(double x , double y) {
		//Return whether the coordinates are contained within this rectangle
		return (x > this.x && y > this.y && x < this.x + this.width && y < this.y + this.height);
	}
	
	/* The method to check whether another rectangle intersects this rectangle */
	public boolean intersects(Rectangle other) {
		//Check if the rectangle's points are contained in this rectangle
		if (this.contains(other.x , other.y)
				|| this.contains(other.x + other.width , other.y)
				|| this.contains(other.x + other.width , other.y + other.height)
				|| this.contains(other.x , other.y + other.height)) {
			return true;
		} else
			return false;
	}
	
	/* The 'get' and 'set' methods */
	public void setX(double x) { this.x = x; }
	public void setY(double y) { this.y = y; }
	public void setPosition(double x , double y) { this.x = x; this.y = y; }
	public void setWidth(double width) { this.width = width; }
	public void setHeight(double height) { this.height = height; }
	public void setSize(double width , double height) { this.width = width; this.height = height; }
	
	public double getX() { return this.x; }
	public double getY() { return this.y; }
	public double getWidth() { return this.width; }
	public double getHeight() { return this.height; }
	
}