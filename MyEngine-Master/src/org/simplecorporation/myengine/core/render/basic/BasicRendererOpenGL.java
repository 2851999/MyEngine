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
	
	/* The method to render a filled rectangle */
	public static void renderFilledRectangle(float x , float y , float width , float height) {
		//Render the rectangle
		glBegin(GL_QUADS);
		glVertex2f(x , y);
		glVertex2f(x + width , y);
		glVertex2f(x + width , y + height);
		glVertex2f(x , y + height);
		glEnd();
	}
	
}