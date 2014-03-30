/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.opengl.light;

import java.nio.FloatBuffer;

import org.simplecorporation.myengine.core.game3d.vector.Vector3D;
import org.simplecorporation.myengine.utils.opengl.OpenGLUtils;

import static org.lwjgl.opengl.GL11.*;

public class Light {
	
	/* The light numbers */
	public static final int LIGHT_0 = GL_LIGHT0;
	public static final int LIGHT_1 = GL_LIGHT1;
	public static final int LIGHT_2 = GL_LIGHT2;
	public static final int LIGHT_3 = GL_LIGHT3;
	public static final int LIGHT_4 = GL_LIGHT4;
	public static final int LIGHT_5 = GL_LIGHT5;
	public static final int LIGHT_6 = GL_LIGHT6;
	public static final int LIGHT_7 = GL_LIGHT7;
	
	/* The different kinds of light */
	public static final int LIGHT_PER_VERTEX_DIRECTIONAL = 0;
	public static final int LIGHT_PER_VERTEX_POINT = 1;
	public static final int LIGHT_PER_VERTEX_SPOT = 2;
	
	public static final int LIGHT_PER_FRAGMENT_DIRECTIONAL = 3;
	public static final int LIGHT_PER_FRAGMENT_POINT = 4;
	public static final int LIGHT_PER_FRAGMENT_SPOT = 5;
	
	/* The position of this light */
	public Vector3D position;
	
	/* The rotation of this light */
	public Vector3D rotation;
	
	/* The light number */
	public int lightNumber;
	
	/* The type of light this is */
	public int type;
	
	/* The light data within this light */
	public LightData data;
	
	/* The constructor */
	public Light(int type, int lightNumber) {
		//Assign the variables
		this.position = new Vector3D();
		this.rotation = new Vector3D();
		this.lightNumber = lightNumber;
		this.type = type;
		this.data = new LightData();
		//Load this light
		this.load();
	}
	
	/* The constructor with the light data given */
	public Light(int type, int lightNumber, LightData data) {
		//Assign the variables
		this.position = new Vector3D();
		this.rotation = new Vector3D();
		this.type = type;
		this.data = data;
		//Load this light
		this.load();
	}
	
	/* The method used to load this light */
	public void load() {
		
	}
	
	/* The method used to render this light */
	public void render() {
		//Calculate the value of the position of this light
		FloatBuffer lightPosition = OpenGLUtils.getFlippedFloatBuffer(new float[] {
				(float) this.position.x,
				(float) this.position.y,
				(float) this.position.z
		});
		//Set the light values
		glLight(this.lightNumber, GL_AMBIENT, this.data.getAmbientLight());
		glLight(this.lightNumber, GL_DIFFUSE, this.data.getDiffuseLight());
		glLight(this.lightNumber, GL_SPECULAR, this.data.getSpecularLight());
		glLight(this.lightNumber, GL_POSITION, lightPosition);
	}
	
	/* The 'setter' and 'getter' methods */
	public void setPosition(Vector3D position) { this.position = position; }
	public void setRotation(Vector3D rotation) { this.rotation = rotation; }
	public void setLightNumber(int lightNumber) { this.lightNumber = lightNumber; }
	public void setType(int type) { this.type = type; }
	public void setData(LightData data) { this.data = data; }
	public Vector3D getPosition() { return this.position; }
	public Vector3D getRotation() { return this.rotation; }
	public int getLightNumber() { return this.lightNumber; }
	public int getType() { return this.type; }
	public LightData getData() { return this.data; }
	
}