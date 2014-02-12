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

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;

import org.simplecorporation.myengine.core.game3d.vector.Vector3D;

public class Model {
	
	/* The vertices in this model */
	public List<Vector3D> vertices;
	
	/* The normals in this model */
	public List<Vector3D> normals;
	
	/* The faces in this model */
	public List<Face> faces;
	
	/* The constructor */
	public Model() {
		//Assign the variables
		this.vertices = new ArrayList<Vector3D>();
		this.normals = new ArrayList<Vector3D>();
		this.faces = new ArrayList<Face>();
	}
	
	/* The constructor with the vertices, normals and the faces given */
	public Model(List<Vector3D> vertices, List<Vector3D> normals, List<Face> faces) {
		//Assign the variables
		this.vertices = vertices;
		this.normals = normals;
		this.faces = faces;
	}
	
	/* The method used to draw this model using OpenGL */
	public void render() {
		//Begin drawing (Triangles)
		glBegin(GL_TRIANGLES);
		//Go through each face
		for (int a = 0; a < this.faces.size(); a++) {
			//Get the current face in the list
			Face face = this.faces.get(a);
			//The faces hold the indexes of the vertices and normals and
			//don't hold the values them selves
			//-1 because the index starts with 0 and not 1
			Vector3D n1 = this.normals.get((int) face.normal.x - 1);
			Vector3D n2 = this.normals.get((int) face.normal.y - 1);
			Vector3D n3 = this.normals.get((int) face.normal.z - 1);
			//Get the vertices
			Vector3D v1 = this.vertices.get((int) face.vertex.x - 1);
			Vector3D v2 = this.vertices.get((int) face.vertex.y - 1);
			Vector3D v3 = this.vertices.get((int) face.vertex.z - 1);
			//Call the normal function for future lighting and other
			//calculations that may require the normal vector
			//and render each vertex
			glNormal3d(n1.x, n1.y, n1.z);
			glVertex3d(v1.x, v1.y, v1.z);
			glNormal3d(n2.x, n2.y, n2.z);
			glVertex3d(v2.x, v2.y, v2.z);
			glNormal3d(n3.x, n3.y, n3.z);
			glVertex3d(v3.x, v3.y, v3.z);
		}
		//End the drawing
		glEnd();
	}
	
}