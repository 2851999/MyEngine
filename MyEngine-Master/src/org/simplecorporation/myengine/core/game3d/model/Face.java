/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game3d.model;

import org.simplecorporation.myengine.core.game3d.vector.Vector3D;

public class Face {
	
	/* The vertex in the face, three indices not vertices or normals */
	public Vector3D vertex;
	
	/* The normal of the face */
	public Vector3D normal;
	
	/* The constructor */
	public Face() {
		//Assign the variables
		this.vertex = new Vector3D();
		this.normal = new Vector3D();
	}
	
	/* The constructor with the vertex and normal given */
	public Face(Vector3D vertex, Vector3D normal) {
		//Assign the variables
		this.vertex = vertex;
		this.normal = normal;
	}
	
}