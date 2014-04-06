/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game3d.camera;

import static org.lwjgl.opengl.GL11.*;

import org.simplecorporation.myengine.core.game3d.vector.Vector3D;

public class Camera {
	
	/* The position of the camera */
	public Vector3D position;
	
	/* The rotation of the camera */
	public Vector3D rotation;
	
	/* The last position */
	public Vector3D lastPosition;
	
	/* The last rotation */
	public Vector3D lastRotation;
	
	/* The constructor */
	public Camera() {
		//Assign the variables
		this.position = new Vector3D();
		this.rotation = new Vector3D();
		this.lastPosition = new Vector3D();
		this.lastRotation = new Vector3D();
	}
	
	/* The constructor with the position and rotation given */
	public Camera(Vector3D position, Vector3D rotation) {
		//Assign the variables
		this.position = position;
		this.rotation = rotation;
		this.lastPosition = new Vector3D();
		this.lastRotation = new Vector3D();
	}
	
	/* This method uses the view of this camera */
	public void useView() {
		//Set the rotation
		glRotated(this.rotation.x, 1, 0, 0);
		glRotated(this.rotation.y, 0, 1, 0);
		glRotated(this.rotation.z, 0, 0, 1);
		//Set the position (Translation)
		glTranslated(this.position.x, this.position.y, this.position.z);
	}
	
	/* This method is used to move the camera a certain distance
	 * on the x axis using the rotation */
	public void moveX(double amount) {
		//Move the camera
		this.position.x += amount * Math.cos(Math.toRadians(this.rotation.x));
		this.position.z += amount * Math.sin(Math.toRadians(this.rotation.y));
	}
	
	/* This method is used to move the camera a certain distance
	 * on the z axis */
	public void moveZ(double amount) {
		//Move the camera
		this.position.x += amount * Math.cos(Math.toRadians(this.rotation.y + 90));
		this.position.y += amount * Math.sin(Math.toRadians(this.rotation.x));
		this.position.z += amount * Math.sin(Math.toRadians(this.rotation.y + 90));
	}
	
	/* The method to create a duplicate camera */
	public static Camera createCamera(Camera camera) {
		return new Camera(camera.position, camera.rotation);
	}
	
}