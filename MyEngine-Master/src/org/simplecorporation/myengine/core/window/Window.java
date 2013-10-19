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

import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.settings.Settings;

public class Window {
	
	/* The method to create the window */
	public static void create() {
		//Check weather OpenGL is being used
		if (Settings.Video.OpenGL)
			//Create the OpenGL window
			OpenGLWindow.create();
		else
			//Create the Java window
			JavaWindow.create();
	}
	
	/* The method to close the window */
	public static void close() {
		//Check what window is being used
		if (Settings.Video.OpenGL)
			//Close the OpenGL window
			OpenGLWindow.close();
		else
			//Close the Java window
			JavaWindow.close();
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
	
	/* The method to set the window icon */
	public static void setIcon(Image[] images) {
		//Check what window is being used
		if (Settings.Video.OpenGL)
			//Set the OpenGL window icon
			OpenGLWindow.setIcon(images);
		else
			//Set the Java window icon
			JavaWindow.setIcon(images);
	}
	
	/* Is the window still visible */
	public static boolean isVisble() {
		//Check what window is being used
		if (Settings.Video.OpenGL)
			//Return whether the OpenGL window is visible
			return OpenGLWindow.isVisible();
		else
			//Return whether the Java window is visible
			return JavaWindow.isVisible();
		
	}
	
	/* Is a close requested */
	public static boolean isCloseRequested() {
		//Check what window is being used
		if (Settings.Video.OpenGL)
			//Return the correct value
			return OpenGLWindow.isCloseRequested();
		else
			//Return the correct value
			return JavaWindow.isCloseRequested();
	}
	
}