/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.window;

import org.simplecorporation.myengine.settings.Settings;

public class Window {
	
	/* The method to create the window */
	public static void create() {
		//Check weather OpenGL is being used
		if (Settings.Video.OpenGL) {
			OpenGLWindow.create();
		} else {
			JavaWindow.create();
		}
	}
	
	/* The method to update the window */
	public static void update() {
		//Check what window has been made
		if (Settings.Video.OpenGL) {
			//Update the OpenGL window
			OpenGLWindow.updateSettings();
			OpenGLWindow.updateGraphics();
		} else {
			//Update the Java window
			JavaWindow.updateSettings();
			JavaWindow.updateGraphics();
		}
	}
	
}