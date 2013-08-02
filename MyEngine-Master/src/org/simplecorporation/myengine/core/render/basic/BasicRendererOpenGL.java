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
		glColor4d(colour.r , colour.g , colour.b , colour.a);
	}
	
	/* The method to render an unfilled rectangle */
	public static void renderRectangle(double x , double y , double width , double height) {
		//Render the rectangle
		glBegin(GL_LINES);
		glVertex2d(x , y);
		glVertex2d(x + width , y);
		glVertex2d(x + width , y);
		glVertex2d(x + width , y + height);
		glVertex2d(x + width , y + height);
		glVertex2d(x , y + height);
		glVertex2d(x , y + height);
		glVertex2d(x , y);
		glEnd();
	}
	
	/* The method to render a filled rectangle */
	public static void renderFilledRectangle(double x , double y , double width , double height) {
		//Render the rectangle
		glBegin(GL_QUADS);
		glVertex2d(x , y);
		glVertex2d(x + width , y);
		glVertex2d(x + width , y + height);
		glVertex2d(x , y + height);
		glEnd();
	}
	
	/* The method to render a line */
	public static void renderLine(double startx , double starty , double endx , double endy) {
		//Render the line
		glBegin(GL_LINES);
		glVertex2d(startx , starty);
		glVertex2d(endx , endy);
		glEnd();
	}
	
}