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

import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class BasicRenderer {
	
	/* The method to set the colour */
	public static void setColour(Colour colour) {
		//Find out what rendering mode to use
		if (Settings.Video.OpenGL)
			//Set the colour of OpenGL
			BasicRendererOpenGL.setColour(colour);
		else
			//Set the colour of Java
			BasicRendererJava.setColour(colour);
	}
	
	/* The method to render an unfilled rectangle */
	public static void renderRectangle(double x , double y , double width , double height) {
		//Find out what rendering mode to use
		if (Settings.Video.OpenGL)
			//Render an unfilled rectangle using OpenGL
			BasicRendererOpenGL.renderRectangle(x , y , width , height);
		else
			//Render an unfilled rectangle using Java
			BasicRendererJava.renderRectangle(x , y , width , height);
	}
	
	/* The method to render a filled rectangle */
	public static void renderFilledRectangle(double x , double y , double width , double height) {
		//Find out what rendering mode to use
		if (Settings.Video.OpenGL)
			//Render a filled rectangle using OpenGL
			BasicRendererOpenGL.renderFilledRectangle(x , y , width , height);
		else
			//Render a filled rectangle using Java
			BasicRendererJava.renderFilledRectangle(x , y , width , height);
	}
	
	/* The method to render a line */
	public static void renderLine(double startx , double starty , double endx , double endy) {
		//Find out what rendering mode to use
		if (Settings.Video.OpenGL)
			//Render a line using OpenGL
			BasicRendererOpenGL.renderLine(startx , starty , endx , endy);
		else
			//Render a line using Java
			BasicRendererJava.renderLine(startx , starty , endx , endy);
	}
	
}