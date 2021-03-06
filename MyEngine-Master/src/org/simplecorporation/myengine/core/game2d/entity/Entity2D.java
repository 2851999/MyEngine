/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game2d.entity;

import java.awt.Rectangle;

import org.simplecorporation.myengine.core.game2d.point.Point2D;

import android.graphics.Rect;

public class Entity2D {
	
	/* The position of the entity */
	public Point2D position;
	
	/* The velocity of the entity */
	public Point2D velocity;
	
	/* The rotation of the entity */
	public double rotation;
	
	/* THe velocity of the rotation of the entity */
	public double  rotationVelocity;
	
	/* The width of the entity */
	public double width;
	
	/* The height of the entity */
	public double height;
	
	/* The constructor */
	public Entity2D() {
		//Set all of the variables
		this.position = new Point2D();
		this.velocity = new Point2D();
		this.rotation = 0;
		this.rotationVelocity = 0;
		this.width = 0;
		this.height = 0;
	}
	
	/* The constructor with the position given */
	public Entity2D(Point2D position) {
		//Set all of the variables
		this.position = position;
		this.velocity = new Point2D();
		this.rotation = 0;
		this.rotationVelocity = 0;
		this.width = 0;
		this.height = 0;
	}
	
	/* The constructor with the position and rotation given */
	public Entity2D(Point2D position , double rotation) {
		//Set all of the variables
		this.position = position;
		this.velocity = new Point2D();
		this.rotation = rotation;
		this.rotationVelocity = 0;
		this.width = 0;
		this.height = 0;
	}
	
	/* The constructor with the position and velocity given */
	public Entity2D(Point2D position , Point2D velocity) {
		//Set all of the variables
		this.position = position;
		this.velocity = velocity;
		this.rotation = 0;
		this.rotationVelocity = 0;
		this.width = 0;
		this.height = 0;
	}
	
	/* The constructor with the position and width and height given */
	public Entity2D(Point2D position , double width , double height) {
		//Set all of the variables
		this.position = position;
		this.velocity = new Point2D();
		this.rotation = 0;
		this.rotationVelocity = 0;
		this.width = width;
		this.height = height;
	}
	
	/* The constructor with the position and velocity and width and height given */
	public Entity2D(Point2D position , Point2D velocity , double width , double height) {
		//Set all of the variables
		this.position = position;
		this.velocity = velocity;
		this.rotation = 0;
		this.rotationVelocity = 0;
		this.width = width;
		this.height = height;
	}
	
	/* The update method */
	public void update() {
		//Add the velocity to the position
		this.position.add(this.velocity);
		//Add the rotation velocity to the rotation
		this.rotation += this.rotationVelocity;
	}
	
	/* The render method */
	public void render() {
		
	}
	
	/* Method that returns the bounds as a rectangle */
	public Rectangle getBounds() {
		return new Rectangle((int) this.position.x , (int) this.position.y , (int) this.width , (int) this.height);
	}
	
	/* Method that returns the bounds as a rectangle for android */
	public Rect getAndroidBounds() {
		return new Rect((int)this.position.x , (int)this.position.y , (int)this.position.x + (int)this.width , (int)this.position.y + (int)height);
	}
	
	/* Method to check for a collision between two entity's */
	public boolean collidesWith(Entity2D other) {
		return getBounds().intersects(other.getBounds());
	}
	
	/* The method to set the position */
	public void setPosition(Point2D position) {
		//Set the position
		this.position = position;
	}
	
	/* The method to set the position */
	public void setPosition(double x , double y) {
		//Set the position
		this.position = new Point2D(x , y);
	}
	
	/* The method to set the velocity */
	public void setVelocity(Point2D velocity) {
		//Set the velocity
		this.velocity =  velocity;
	}
	
	/* The method to set the x position */
	public void setX(double x) {
		//Set the x position
		this.position.setX(x);
	}
	
	/* The method to set the y position */
	public void setY(double y) {
		//Set the y position
		this.position.setY(y);
	}
	
	/* The method to set the x velocity */
	public void setVelocityX(double x) {
		//Set the x position
		this.velocity.setX(x);
	}
	
	/* The method to set the y velocity */
	public void setVelocityY(double y) {
		//Set the y velocity
		this.velocity.setY(y);
	}
	
	/* The method to set the rotation */
	public void setRotation(double rotation) {
		//Set the rotation
		this.rotation = rotation;
	}
	
	/* The method to set the rotation velocity */
	public void setRotationVelocity(double rotationVelocity) {
		//Set the rotation velocity
		this.rotationVelocity = rotationVelocity;
	}
	
	/* The method to set the width */
	public void setWidth(double width) {
		//Set the width
		this.width = width;
	}
	
	/* The method to set the height */
	public void setHeight(double height) {
		//Set the height
		this.height = height;
	}
	
	/* The method to get the position */
	public Point2D getPosition() {
		//Return the position
		return this.position;
	}
	
	/* The method to get the velocity */
	public Point2D getVelocity() {
		//Return the velocity
		return this.velocity;
	}
	
	/* The method to get the x position */
	public double getX() {
		//Return the x position
		return this.position.getX();
	}
	
	/* The method to get the y position */
	public double getY() {
		//Return the y position
		return this.position.getY();
	}
	
	/* The method to get the x velocity */
	public double getVelocityX() {
		//Return the x velocity
		return this.velocity.getX();
	}
	
	/* The method to get the y velocity */
	public double getVelocityY() {
		//Return the y velocity
		return this.velocity.getY();
	}
	
	/* THe method to get the rotation */
	public double getRotation() {
		//Return the rotation
		return this.rotation;
	}
	
	/* The method to get the rotation velocity */
	public double getRotationVelocity() {
		//Return the rotation velocity
		return this.rotationVelocity;
	}
	
	/* The method to get the width */
	public double getWidth() {
		//Return the width
		return width;
	}
	
	/* The method to get the height */
	public double getHeight() {
		//Return the height
		return height;
	}
	
}