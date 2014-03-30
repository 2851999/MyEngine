/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game3d.vector;

public class Vector3D {
	
	/* The x value */
	public double x;
	
	/* The y value */
	public double y;
	
	/* The z value */
	public double z;
	
	/* The constructor */
	public Vector3D() {
		//Set the x, y and z values to 0
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	/* The constructor with the x, y and z values given */
	public Vector3D(double x , double y , double z) {
		//Assign the x, y and z values
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/* The method that adds a vector to this vector then
	 * returns the vector */
	public Vector3D add(Vector3D other) {
		//Return the new vector
		return new Vector3D(this.x + other.x, this.y + other.y, this.x + other.z);
	}
	
	/* The method that adds a value to this vector then
	 * returns the vector */
	public Vector3D add(double value) {
		//Return the new vector
		return new Vector3D(this.x + value, this.y + value, this.z + value);
	}
	
	/* The method that minus's a vector from this vector then
	 * returns the vector */
	public Vector3D minus(Vector3D other) {
		//Return the new vector
		return new Vector3D(this.x - other.x, this.y - other.y, this.z - other.z);
	}
	
	/* The method that minus's a value to this vector then
	 * returns the vector */
	public Vector3D minus(double value) {
		//Return the new vector
		return new Vector3D(this.x - value, this.y - value, this.z - value);
	}
	
	/* The method that multiply's this vector using another vector then
	 * returns the vector */
	public Vector3D multiply(Vector3D other) {
		//Return the new vector
		return new Vector3D(this.x * other.x, this.y * other.y, this.z * other.z);
	}
	
	/* The method that multiply's this vector using a value then
	 * returns the vector */
	public Vector3D multiply(double value) {
		//Return the new vector
		return new Vector3D(this.x * value, this.y * value, this.z * value);
	}
	
	/* The method that divides this vector using another vector then
	 * returns the vector */
	public Vector3D divide(Vector3D other) {
		//Return the new vector
		return new Vector3D(this.x / other.x, this.y / other.y, this.z / other.z);
	}
	
	/* The method that divides this vector using a value then
	 * returns the vector */
	public Vector3D divide(double value) {
		//Return the new vector
		return new Vector3D(this.x / value, this.y / value, this.z / value);
	}
	
	/* The method to clone this Vector3D */
	public Vector3D clone() {
		//Return a clone
		return new Vector3D(x , y, z);
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
	
	/* The method to set the z value */
	public void setZ(double z) {
		//Set the z value
		this.z = z;
	}
	
	/* The method that returns the x value */
	public double getX() {
		return this.x;
	}
	
	/* The method that returns the y value */
	public double getY() {
		return this.y;
	}
	
	/* The method that returns the z value */
	public double getZ() {
		return this.z;
	}
	
	/* The method to get this vector as a point */
	public Vector3D asPoint() {
		//The x, y and z values
		double newX = this.x;
		double newY = this.y;
		double newZ = this.z;
		//Check if the x/y/z is less than 0
		if (newX < 0) newX *= -1;
		if (newY < 0) newY *= -1;
		if (newZ < 0) newZ *= -1;
		//Return the new vector
		return new Vector3D(newX, newY, newZ);
	}
	
	/* The method to get this vector as a direction */
	public Vector3D asDirection() {
		//The new x, y and z values
		double newX = this.x;
		double newY = this.y;
		double newZ = this.z;
		//Check if the x/y/z is more than/less than 0
		if (newX > 0) newX = 1;
		else if (newX < 0) newX = -1;
		if (newY > 0) newY = 1;
		else if (newY < 0) newY = -1;
		if (newZ > 0) newZ = 1;
		else if (newZ < 0) newZ = -1;
		//Return the new vector
		return new Vector3D(newX, newY, newZ);
	}
	
}