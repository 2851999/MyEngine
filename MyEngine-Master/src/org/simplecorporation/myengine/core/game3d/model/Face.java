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
	
	/* The vertices in this face */
	public Vector3D vertices;
	
	/* The normals in this face */
	public Vector3D normals;
	
	/* The texture coordinates in this face */
	public Vector3D textures;
	
	/* The material of this face */
	public Material material;
	
	/* The default constructor */
	public Face() {
		//Assign the variables
		this.vertices = new Vector3D();
		this.normals = new Vector3D();
		this.textures = new Vector3D();
	}
	
	/* The constructor with the vertices, normals and textures given */
	public Face(Vector3D vertices, Vector3D normals, Vector3D textures) {
		//Assign the variables
		this.vertices = vertices;
		this.normals = normals;
		this.textures = textures;
	}
	
	/* The constructor with the vertices, normals, textures and material given */
	public Face(Vector3D vertices, Vector3D normals, Vector3D textures, Material material) {
		//Assign the variables
		this.vertices = vertices;
		this.normals = normals;
		this.textures = textures;
		this.material = material;
	}
	
	/* The 'setter' and 'getter' methods */
	public void setVertices(Vector3D vertices) { this.vertices = vertices; }
	public void setNormals(Vector3D normals) { this.normals = normals; }
	public void setTextures(Vector3D textures) { this.textures = textures; }
	public void setMaterial(Material material) { this.material = material; }
	public Vector3D getVertices() { return this.vertices; }
	public Vector3D getNormals() { return this.normals; }
	public Vector3D getTextures() { return this.textures; }
	public Material getMaterial() { return this.material; }
	
	
}