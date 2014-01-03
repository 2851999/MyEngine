/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.applet;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.settings.Settings;

public class Applet {
	
	/* The method to create the applet */
	public static void create() {
		//Check weather OpenGL is being used
		if (! Settings.Android && Settings.Video.OpenGL)
			//Create the OpenGL applet
			OpenGLApplet.create();
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Create the Java applet
			JavaApplet.create();
	}
	
	/* The method to close the applet */
	public static void close() {
		//Check what applet is being used
		if (! Settings.Android && Settings.Video.OpenGL)
			//Close the OpenGL applet
			OpenGLApplet.close();
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Close the Java applet
			JavaApplet.close();
	}
	
	/* The method to update the applet */
	public static void update() {
		//Check what applet has been made
		if (! Settings.Android && Settings.Video.OpenGL) {
			//Update the OpenGL applet
			OpenGLApplet.updateSettings();
			OpenGLApplet.updateGraphics();
		} else if (! Settings.Android && ! Settings.Video.OpenGL) {
			//Update the Java applet
			JavaApplet.updateSettings();
			JavaApplet.updateGraphics();
		}
	}
	
	/* The method to set the cursor image */
	public static void setCursor(Image image , int pointX , int pointY , String cursorName) {
		//Check what applet is being used
		if (! Settings.Android && Settings.Video.OpenGL)
			//Set the cursor for the OpenGL applet
			OpenGLApplet.setCursor(image, pointX, pointY, cursorName);
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Set the cursor for the Java applet
			JavaApplet.setCursor(image, pointX, pointY, cursorName);
	}
	
	/* The method to centre the applet */
	public static void centre() {
		//Check what applet is being used
		if (! Settings.Android && Settings.Video.OpenGL)
			//Centre the OpenGL applet
			OpenGLApplet.centre();
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Centre the Java applet
			JavaApplet.centre();
	}
	
	/* Is the applet still visible */
	public static boolean isVisible() {
		//Check what applet is being used
		if (! Settings.Android && Settings.Video.OpenGL)
			//Return whether the OpenGL applet is visible
			return OpenGLApplet.isVisible();
		else if (! Settings.Android && ! Settings.Video.OpenGL)
			//Return whether the Java applet is visible
			return JavaApplet.isVisible();
		else
			return false;
	}
	
	/* Is a close requested */
	public static boolean isCloseRequested() {
		//Return false because there is no warning when the applet is closed
		return false;
	}
	
}