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
	
	/* The vertices in the model */
	public List<Vector3D> vertices;
	
	/* The normals in the model */
	public List<Vector3D> normals;
	
	/* The texture coordinates */
	public List<Vector3D> textures;
	
	/* The faces in the model */
	public List<Face> faces;
	
	/* The materials in the model */
	public List<Material> materials;
	
	/* The default constructor */
	public Model() {
		//Assign the variables
		this.vertices = new ArrayList<Vector3D>();
		this.normals = new ArrayList<Vector3D>();
		this.textures = new ArrayList<Vector3D>();
		this.faces = new ArrayList<Face>();
		this.materials = new ArrayList<Material>();
	}
	
	/* The constructor with the vertices, normals, texture coordinate and faces given */
	public Model(List<Vector3D> vertices, List<Vector3D> normals, List<Vector3D> textures, List<Face> faces, List<Material> materials) {
		//Assign the variables
		this.vertices = vertices;
		this.normals = normals;
		this.textures = textures;
		this.faces = faces;
		this.materials = materials;
	}
	
	/* The method used to render this model */
	public void render() {
		//Start drawing the triangles
		glBegin(GL_TRIANGLES);
		//Go through each face in the faces list
		for (int i = 0; i < this.faces.size(); i++)
			//Render the current face
			this.renderFace(this.faces.get(i));
		//Finish drawing the triangles
		glEnd();
	}
	
	/* The method used to render a face */
	public void renderFace(Face face) {
		//Check to see whether the face has a material
		if (face.material != null) {
			//Apply the material
			face.material.apply();
		}
		//Render each face vertex
		renderFaceVertex(face, 1, 0, 0);
		renderFaceVertex(face, 0, 1, 0);
		renderFaceVertex(face, 0, 0, 1);
	}
	
	/* The method used to render a vertex */
	public void renderFaceVertex(Face face, int x, int y, int z) {
		//Check to see whether the normals for this face exists
		if (face.normals != null) {
			//The normals should be used
			
			//The normal index
			int normalIndex = 0;
			//Check which coordinate should be used
			if (x == 1 && y == 0 && z == 0)
				normalIndex = ((int) face.normals.x) - 1;
			if (x == 0 && y == 1 && z == 0)
				normalIndex = ((int) face.normals.y) - 1;
			if (x == 0 && y == 0 && z == 1)
				normalIndex = ((int) face.normals.z) - 1;
			//Get the normal
			Vector3D n = this.normals.get(normalIndex);
			//Use the normal
			glNormal3d(n.x, n.y, n.z);
		}
		
		//Check to see whether the texture coordinates for this face exists
		if (face.textures != null) {
			//The textures should be used
			
			//The texture index
			int textureIndex = 0;
			//Check which coordinate should be used
			if (x == 1 && y == 0 && z == 0)
				textureIndex = ((int) face.textures.x) - 1;
			if (x == 0 && y == 1 && z == 0)
				textureIndex = ((int) face.textures.y) - 1;
			if (x == 0 && y == 0 && z == 1)
				textureIndex = ((int) face.textures.z) - 1;
			//Get the texture
			Vector3D t = this.textures.get(textureIndex);
			//Use the texture coordinates
			glTexCoord3d(t.x, t.y, t.z);
		}
		
		//The vertex index
		int vertexIndex = 0;
		//Check which coordinate should be used
		if (x == 1 && y == 0 && z == 0)
			vertexIndex = ((int) face.vertices.x) - 1;
		if (x == 0 && y == 1 && z == 0)
			vertexIndex = ((int) face.vertices.y) - 1;
		if (x == 0 && y == 0 && z == 1)
			vertexIndex = ((int) face.vertices.z) - 1;
		//Get the vertex
		Vector3D v = this.vertices.get(vertexIndex);
		//Render the vertex
		glVertex3d(v.x, v.y, v.z);
	}
	
	/* The method used to get a material using its name */
	public Material getMaterial(String name) {
		//The material
		Material material = null;
		//Go through the list
		loop: for (int a = 0; a < this.materials.size(); a++) {
			//Check the name of the current material in the list
			if (this.materials.get(a).name.equals(name)) {
				//Set the material
				material = this.materials.get(a);
				//Break out of the loop
				break loop;
			}
		}
		//Return the material
		return material;
	}
	
	/* The methods used to add a certain value */
	public void addVertex(Vector3D vertex) { this.vertices.add(vertex); }
	public void addNormal(Vector3D normal) { this.normals.add(normal); }
	public void addTexture(Vector3D texture) { this.textures.add(texture); }
	public void addFace(Face face) { this.faces.add(face); }
	public void addMaterial(Material material) { this.materials.add(material); }
	
	/* The 'setter' and 'getter' methods */
	public void setVertices(List<Vector3D> vertices) { this.vertices = vertices; }
	public void setNormals(List<Vector3D> normals) { this.normals = normals; }
	public void setTextures(List<Vector3D> textures) { this.textures = textures; }
	public void setFaces(List<Face> faces) { this.faces = faces; }
	public void setMaterials(List<Material> materials) { this.materials = materials; }
	public List<Vector3D> getVertices() { return this.vertices; }
	public List<Vector3D> getNormals() { return this.normals; }
	public List<Vector3D> getTextures() { return this.textures; }
	public List<Face> getFaces() { return this.faces; }
	public List<Material> getMaterials() { return this.materials; }
	
}