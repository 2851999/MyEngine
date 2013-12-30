/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.render.basic;

import java.awt.Color;
import java.awt.geom.AffineTransform;

import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.core.window.JavaWindow;

public class BasicRendererJava {
	
	/* The method to set the colour */
	public static void setColour(Colour colour) {
		//Get the Graphics object and set the colour
		JavaWindow.g2d.setColor(new Color((float)colour.r , (float)colour.g , (float)colour.b , (float)colour.a));
	}
	
	/* The method to render an unfilled rectangle */
	public static void renderRectangle(double x , double y , double width , double height) {
		//Render the rectangle
		JavaWindow.g2d.drawRect((int) x , (int) y , (int) width , (int) height);
	}
	
	/* The method to render a filled rectangle */
	public static void renderFilledRectangle(double x , double y , double width , double height) {
		//Render the rectangle
		JavaWindow.g2d.fillRect((int) x , (int) y , (int) width , (int) height);
	}
	
	/* The method to render a line */
	public static void renderLine(double startx , double starty , double endx , double endy) {
		//Render the line
		JavaWindow.g2d.drawLine((int) startx , (int) starty , (int) endx , (int) endy);
	}
	
	/* The method to render an image */
	public static void renderImage(Image image , double x , double y) {
		//Render the image
		JavaWindow.g2d.drawImage(image.getJavaImage() , (int) x , (int) y , JavaWindow.frame);
	}
	
	/* The method to render an image with a rotation */
	public static void renderImage(Image image , double x , double y , double rotation) {
		//Setup the AffineTransform
		AffineTransform at =  new AffineTransform();
		at.translate(x , y);
		at.rotate(Math.toRadians(rotation) , image.getWidth() / 2 , image.getHeight() / 2);
		//Render the image
		JavaWindow.g2d.drawImage(image.getJavaImage() , at , JavaWindow.frame);
	}
	
	/* The method to render an image with a specified width and height */
	public static void renderImage(Image image , double x , double y , double width , double height) {
		//Render the image
		JavaWindow.g2d.drawImage(image.getJavaImage() , (int) x , (int) y , (int) width , (int) height , JavaWindow.frame);
	}
	
	/* The method to render an image with a specified width, height and rotation */
	public static void renderImage(Image image , double x , double y , double width , double height , double rotation) {
		//Setup the AffineTransform
		AffineTransform at =  new AffineTransform();
		at.translate(x , y);
		at.rotate(Math.toRadians(rotation) , width / 2 , height / 2);
		at.scale(width / image.getWidth() , height / image.getHeight());
		//Render the image
		JavaWindow.g2d.drawImage(image.getJavaImage() , at , JavaWindow.frame);
	}
	
	/* The method to render an image with a specified x, y, width, height, imageX, imageY, imageWidth, imageHeight */
	public static void renderImage(Image image , double x , double y , double width , double height , double imageX , double imageY ,
			double imageWidth , double imageHeight) {
		//Render the image
		JavaWindow.g2d.drawImage(image.getJavaImage() , (int) x , (int) y , (int) x + (int) width , (int) y + (int) height , (int) imageX , (int) imageY ,
				(int) imageX + (int) imageWidth , (int) imageY + (int) imageHeight , JavaWindow.frame);
	}
	
}