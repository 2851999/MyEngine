/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.render.basic;

import static org.lwjgl.opengl.GL11.*;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class BasicRendererOpenGL {
	
	/* The method to set the colour */
	public static void setColour(Colour colour) {
		//Set the colour of OpenGL
		glColor4f(colour.r , colour.g , colour.b , colour.a);
	}
	
}