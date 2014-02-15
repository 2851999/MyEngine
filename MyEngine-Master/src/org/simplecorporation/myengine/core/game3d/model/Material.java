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

import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class Material {
	
	/* The name of this material */
	public String name;
	
	/* The ambient colour of this material */
	public Colour ambientColour;
	
	/* The diffuse colour of this material */
	public Colour diffuseColour;
	
	/* The specular colour of this material */
	public Colour specularColour;
	
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
		this.alphaColourValue = 1.0;
		this.alphaTextureMap = null;
	}
	
	/* The method used to apply the material */
	public void apply() {
		//Check to see whether the alpha texture has been set
		if (this.alphaTextureMap != null)
			//Bind the alpha texture map
			this.alphaTextureMap.getOpenGLImage().bind();
	}
	
}