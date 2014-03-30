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

import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.opengl.OpenGLUtils;

public class LightData {
	
	/* The ambient light value */
	public Colour ambientLight;
	
	/* The diffuse light value */
	public Colour diffuseLight;
	
	/* The specular light value */
	public Colour specularLight;
	
	/* The constructor */
	public LightData() {
		//Assign the variables
		this.ambientLight = new Colour(0d, 0d, 0d, 1d);
		this.diffuseLight = new Colour(0d, 0d, 0d, 1d);
		this.specularLight = new Colour(0d, 0d, 0d, 1d);
	}
	
	/* The constructor with the light values given */
	public LightData(Colour ambientLight, Colour diffuseLight, Colour specularLight) {
		//Assign the variables
		this.ambientLight = ambientLight;
		this.diffuseLight = diffuseLight;
		this.specularLight = specularLight;
	}
	
	/* The methods used to get the OpenGL flipped float buffer values
	 * of colours inside the light */
	public FloatBuffer getAmbientLight() { return OpenGLUtils.getFlippedFloatBuffer(this.ambientLight); }
	public FloatBuffer getDiffuseLight() { return OpenGLUtils.getFlippedFloatBuffer(this.diffuseLight); }
	public FloatBuffer getSpecularLight() { return OpenGLUtils.getFlippedFloatBuffer(this.specularLight); }
	
}