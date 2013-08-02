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

import java.awt.Color;

import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.core.window.JavaWindow;

public class BasicRendererJava {
	
	/* The method to set the colour */
	public static void setColour(Colour colour) {
		//Get the Graphics object and set the colour
		JavaWindow.g2d.setColor(new Color(colour.r , colour.g , colour.b , colour.a));
	}
	
}