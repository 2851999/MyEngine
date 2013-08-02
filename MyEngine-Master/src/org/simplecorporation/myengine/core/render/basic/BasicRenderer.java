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
	
}