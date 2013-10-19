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

import org.simplecorporation.myengine.core.image.Image;
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

	/* The method to render an image */
	public static void renderImage(Image image , double x , double y) {
		//Bind the texture
		image.getOpenGLImage().bind();
		//Render the image
		glBegin(GL_QUADS);
		glTexCoord2d(0 , 0);
		glVertex2d(x , y);
		glTexCoord2d(1 , 0);
		glVertex2d(x + image.getWidth() , y);
		glTexCoord2d(1 , 1);
		glVertex2d(x + image.getWidth() , y + image.getHeight());
		glTexCoord2d(0 , 1);
		glVertex2d(x , y + image.getHeight());
		glEnd();
	}

	/* The method to render an image with a specified width and height */
	public static void renderImage(Image image , double x , double y , double width , double height) {
		//Bind the texture
		image.getOpenGLImage().bind();
		//Render the image
		glBegin(GL_QUADS);
		glTexCoord2d(0 , 0);
		glVertex2d(x , y);
		glTexCoord2d(1 , 0);
		glVertex2d(x + width , y);
		glTexCoord2d(1 , 1);
		glVertex2d(x + width , y + height);
		glTexCoord2d(0 , 1);
		glVertex2d(x , y + height);
		glEnd();
	}
	
	/* The method to render an image with a specified x, y, width, height, imageX, imageY, imageWidth, imageHeight */
	public static void renderImage(Image image , double x , double y , double width , double height , double imageX , double imageY ,
			double imageWidth , double imageHeight) {
		//Bind the texture
		image.getOpenGLImage().bind();
		//Render the image
		glBegin(GL_QUADS);
		glTexCoord2d(imageX / image.getWidth() , imageY / image.getHeight());
		glVertex2d(x , y);
		glTexCoord2d((imageX / image.getWidth()) + (1.0 / (image.getWidth() / imageWidth)) , imageY / image.getHeight());
		glVertex2d(x + width , y);
		glTexCoord2d((imageX / image.getWidth()) + (1.0 / (image.getWidth() / imageWidth)) , (imageY / image.getHeight()) + (1.0 / (image.getHeight() / imageHeight)));
		glVertex2d(x + width , y + height);
		glTexCoord2d(imageX / image.getWidth() , (imageY / image.getHeight()) + (1.0 / (image.getHeight() / imageHeight)));
		glVertex2d(x , y + height);
		glEnd();
	}
	
}