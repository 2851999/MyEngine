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
	
	/* The method to close the window */
	public static void close() {
		//Check what window is being used
		if (Settings.Video.OpenGL) {
			//Close the window
			OpenGLWindow.close();
		} else {
			//Close the window
			JavaWindow.close();
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
	
	/* Is the window still visible */
	public static boolean isVisble() {
		//Check what window is being used
		if (Settings.Video.OpenGL) {
			//Return whether the window is visible
			return OpenGLWindow.isVisible();
		} else {
			//Return whether the window is visible
			return JavaWindow.isVisible();
		}
	}
	
	/* Is a close requested */
	public static boolean isCloseRequested() {
		//Check what window is being used
		if (Settings.Video.OpenGL) {
			//Return the correct value
			return OpenGLWindow.isCloseRequested();
		} else {
			//Return the correct value
			return JavaWindow.isCloseRequested();
		}
	}
	
}