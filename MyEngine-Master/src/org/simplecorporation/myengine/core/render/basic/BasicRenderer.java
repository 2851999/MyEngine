/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.render.basic;

import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class BasicRenderer {
	
	/* The method to set the colour */
	public static void setColour(Colour colour) {
		//Find out what rendering mode to use
		if (! Settings.Android && Settings.Video.OpenGL)
			//Set the colour of OpenGL
			BasicRenderer2DOpenGL.setColour(colour);
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Set the colour of Java
			BasicRenderer2DJava.setColour(colour);
		else if (Settings.Android && ! Settings.Video.OpenGL)
			//Set the colour of Android
			BasicRenderer2DAndroid.setColour(colour);
	}
	
	/* The method to render an unfilled rectangle */
	public static void renderRectangle(double x , double y , double width , double height) {
		//Render an unfilled 2D rectangle
		BasicRenderer2D.renderRectangle(x, y, width, height);
	}
	
	/* The method to render a filled rectangle */
	public static void renderFilledRectangle(double x , double y , double width , double height) {
		//Render a filled 2D rectangle
		BasicRenderer2D.renderFilledRectangle(x, y, width, height);
	}
	
	/* The method to render a line */
	public static void renderLine(double startx , double starty , double endx , double endy) {
		//Render a 2D line
		BasicRenderer2D.renderLine(startx, starty, endx, endy);
	}
	
	/* The method to render an image */
	public static void renderImage(Image image , double x , double y) {
		//Render the 2D image
		BasicRenderer2D.renderImage(image , x , y);
		//Check to see whether to render the box around the image
		if (Settings.Debugging.ShowImageBoxes)
			BasicRenderer2D.renderRectangle(x, y, image.getWidth(), image.getHeight());
	}
	
	/* The method to render an image with a rotation */
	public static void renderImage(Image image , double x , double y , double rotation) {
		//Render the 2D image
		BasicRenderer2D.renderImage(image , x , y , rotation);
		//Check to see whether to render the box around the image
		if (Settings.Debugging.ShowImageBoxes)
			BasicRenderer2D.renderRectangle(x, y, image.getWidth(), image.getHeight());
	}
	
	/* The method to render an image with a specified width and height */
	public static void renderImage(Image image , double x , double y , double width , double height) {
		//Render the 2D image
		BasicRenderer2D.renderImage(image , x , y , width , height);
		//Check to see whether to render the box around the image
		if (Settings.Debugging.ShowImageBoxes)
			BasicRenderer2D.renderRectangle(x, y, width, height);
	}
	
	/* The method to render an image with a specified width, height and rotation */
	public static void renderImage(Image image , double x , double y , double width , double height , double rotation) {
			//Render the 2D image
			BasicRenderer2D.renderImage(image , x , y , width , height , rotation);
			//Check to see whether to render the box around the image
			if (Settings.Debugging.ShowImageBoxes)
				BasicRenderer2D.renderRectangle(x, y, width, height);
	}
	
	/* The method to render an image with a specified x, y, width, height, imageX, imageY, imageWidth, imageHeight */
	public static void renderImage(Image image , double x , double y , double width , double height , double imageX , double imageY ,
			double imageWidth , double imageHeight) {
		//Render the 2D image
		BasicRenderer2D.renderImage(image , x , y , width , height , imageX , imageY , imageWidth , imageHeight);
		//Check to see whether to render the box around the image
		if (Settings.Debugging.ShowImageBoxes)
			BasicRenderer2D.renderRectangle(x, y, width, height);
	}
	
}