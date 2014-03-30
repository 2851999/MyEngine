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

import java.nio.FloatBuffer;

import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.opengl.OpenGLUtils;

import static org.lwjgl.opengl.GL11.*;

public class Material {
	
	/* The name of this material */
	public String name;
	
	/* The ambient colour of this material */
	public Colour ambientColour;
	
	/* The diffuse colour of this material */
	public Colour diffuseColour;
	
	/* The specular colour of this material */
	public Colour specularColour;
	
	/* The shininess of this material */
	public double shininess;
	
	/* The alpha colour value */
	public double alphaColourValue;
	
	/* The alpha texture map */
	public Image alphaTextureMap;
	
	/* The constructor */
	public Material(String name) {
		//Assign the variables
		this.name = name;
		this.ambientColour = null;
		this.diffuseColour = null;
		this.specularColour = null;
		this.shininess = 0;
		this.alphaColourValue = 1.0;
		this.alphaTextureMap = null;
	}
	
	/* The method used to apply the material */
	public void apply() {
		//Check to see whether the alpha texture has been set
		if (this.alphaTextureMap != null)
			//Bind the alpha texture map
			this.alphaTextureMap.getOpenGLImage().bind();
		//Check to see whether any of the colours should be used
		if (this.ambientColour != null) {
			//Get the float buffer for the colour
			FloatBuffer buffer = OpenGLUtils.getFlippedFloatBuffer(this.ambientColour.getFloatValues());
			//Set the material property
			glMaterial(GL_FRONT_AND_BACK, GL_AMBIENT, buffer);
		}
		if (this.diffuseColour != null) {
			//Get the float buffer for the colour
			FloatBuffer buffer = OpenGLUtils.getFlippedFloatBuffer(this.diffuseColour.getFloatValues());
			//Set the material property
			glMaterial(GL_FRONT_AND_BACK, GL_DIFFUSE, buffer);
		}
		if (this.specularColour != null) {
			//Get the float buffer for the colour
			FloatBuffer buffer = OpenGLUtils.getFlippedFloatBuffer(this.specularColour.getFloatValues());
			//Set the material property
			glMaterial(GL_FRONT_AND_BACK, GL_SPECULAR, buffer);
		}
		//Set the shininess material property
		glMaterialf(GL_FRONT_AND_BACK, GL_SHININESS, (float) this.shininess);
	}
	
}