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

import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.image.Image;

public class BasicRenderer2D {
	
	/* The method to render an unfilled rectangle */
	public static void renderRectangle(double x , double y , double width , double height) {
		//Find out what rendering mode to use
		if (! Settings.Android && Settings.Video.OpenGL)
			//Render an unfilled rectangle using OpenGL
			BasicRenderer2DOpenGL.renderRectangle(x , y , width , height);
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Render an unfilled rectangle using Java
			BasicRenderer2DJava.renderRectangle(x , y , width , height);
		else if (Settings.Android && ! Settings.Video.OpenGL)
			//Render an unfilled rectangle using Android
			BasicRenderer2DAndroid.renderRectangle(x , y , width , height);
		else if (Settings.Android && Settings.Video.OpenGL)
			//Render an unfilled rectangle using Android OpenGL ES
			BasicRenderer2DOpenGLES.renderRectangle(x, y, width, height);
	}
	
	/* The method to render a filled rectangle */
	public static void renderFilledRectangle(double x , double y , double width , double height) {
		//Find out what rendering mode to use
		if (! Settings.Android && Settings.Video.OpenGL)
			//Render a filled rectangle using OpenGL
			BasicRenderer2DOpenGL.renderFilledRectangle(x , y , width , height);
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Render a filled rectangle using Java
			BasicRenderer2DJava.renderFilledRectangle(x , y , width , height);
		else if (Settings.Android && ! Settings.Video.OpenGL)
			//Render a filled rectangle using android
			BasicRenderer2DAndroid.renderFilledRectangle(x , y , width , height);
		else if (Settings.Android && Settings.Video.OpenGL)
			//Render an filled rectangle using Android OpenGL ES
			BasicRenderer2DOpenGLES.renderFilledRectangle(x, y, width, height);
	}
	
	/* The method to render a line */
	public static void renderLine(double startx , double starty , double endx , double endy) {
		//Find out what rendering mode to use
		if (! Settings.Android && Settings.Video.OpenGL)
			//Render a line using OpenGL
			BasicRenderer2DOpenGL.renderLine(startx , starty , endx , endy);
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Render a line using Java
			BasicRenderer2DJava.renderLine(startx , starty , endx , endy);
		else if (Settings.Android && ! Settings.Video.OpenGL)
			//Render a line using Android
			BasicRenderer2DAndroid.renderLine(startx , starty , endx , endy);
		else if (Settings.Android && Settings.Video.OpenGL)
			//Render a line using Android OpenGL ES
			BasicRenderer2DOpenGLES.renderLine(startx, starty, endx, endy);
	}
	
	/* The method to render an image */
	public static void renderImage(Image image , double x , double y) {
		//Find out what rendering mode to use
		if (! Settings.Android && Settings.Video.OpenGL)
			//Render the image using OpenGL
			BasicRenderer2DOpenGL.renderImage(image , x , y);
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Render the image using Java
			BasicRenderer2DJava.renderImage(image , x , y);
		else if (Settings.Android && ! Settings.Video.OpenGL)
			//Render the image using Android
			BasicRenderer2DAndroid.renderImage(image , x , y);
		else if (Settings.Android && Settings.Video.OpenGL)
			//Render the image using Android OpenGL ES
			BasicRenderer2DOpenGLES.renderImage(image, x, y);
	}
	
	/* The method to render an image with a rotation */
	public static void renderImage(Image image , double x , double y , double rotation) {
		//Find out what rendering mode to use
		if (! Settings.Android && Settings.Video.OpenGL)
			//Render the image using OpenGL
			BasicRenderer2DOpenGL.renderImage(image , x , y , rotation);
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Render the image using Java
			BasicRenderer2DJava.renderImage(image , x , y , rotation);
		else if (Settings.Android && ! Settings.Video.OpenGL)
			//Render the image using Android
			BasicRenderer2DAndroid.renderImage(image , x , y , rotation);
		else if (Settings.Android && Settings.Video.OpenGL)
			//Render the image using Android OpenGL ES
			BasicRenderer2DOpenGLES.renderImage(image, x, y, rotation);
	}
	
	/* The method to render an image with a specified width and height */
	public static void renderImage(Image image , double x , double y , double width , double height) {
		//Find out what rendering mode to use
		if (! Settings.Android && Settings.Video.OpenGL)
			//Render the image using OpenGL
			BasicRenderer2DOpenGL.renderImage(image , x , y , width , height);
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Render the image using Java
			BasicRenderer2DJava.renderImage(image , x , y , width , height);
		else if (Settings.Android && ! Settings.Video.OpenGL)
			//Render the image using Android
			BasicRenderer2DAndroid.renderImage(image , x , y , width , height);
		else if (Settings.Android && Settings.Video.OpenGL)
			//Render the image using Android OpenGL ES
			BasicRenderer2DOpenGLES.renderImage(image, x, y, width, height);
	}
	
	/* The method to render an image with a specified width, height and rotation */
	public static void renderImage(Image image , double x , double y , double width , double height , double rotation) {
		//Find out what rendering mode to use
		if (! Settings.Android && Settings.Video.OpenGL)
			//Render the image using OpenGL
			BasicRenderer2DOpenGL.renderImage(image , x , y , width , height , rotation);
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Render the image using Java
			BasicRenderer2DJava.renderImage(image , x , y , width , height , rotation);
		else if (Settings.Android && ! Settings.Video.OpenGL)
			//Render the image using Android
			BasicRenderer2DAndroid.renderImage(image , x , y , width , height , rotation);
		else if (Settings.Android && Settings.Video.OpenGL)
			//Render the image using Android OpenGL ES
			BasicRenderer2DOpenGLES.renderImage(image, x, y, width, height, rotation);
	}
	
	/* The method to render an image with a specified x, y, width, height, imageX, imageY, imageWidth, imageHeight */
	public static void renderImage(Image image , double x , double y , double width , double height , double imageX , double imageY ,
			double imageWidth , double imageHeight) {
		//Find out what rendering mode to use
		if (! Settings.Android && Settings.Video.OpenGL)
			//Render the image using OpenGL
			BasicRenderer2DOpenGL.renderImage(image , x , y , width , height , imageX , imageY , imageWidth , imageHeight);
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Render the image using Java
			BasicRenderer2DJava.renderImage(image , x , y , width , height , imageX , imageY , imageWidth , imageHeight);
		else if (Settings.Android && ! Settings.Video.OpenGL)
			//Render the image using Android
			BasicRenderer2DAndroid.renderImage(image , x , y , width , height , imageX , imageY , imageWidth , imageHeight);
		else if (Settings.Android && Settings.Video.OpenGL)
			//Render the image using Android OpenGL ES
			BasicRenderer2DOpenGLES.renderImage(image, x, y, width , height , imageX , imageY , imageWidth , imageHeight);
	}
	
}