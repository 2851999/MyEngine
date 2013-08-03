/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.input;

import org.simplecorporation.myengine.settings.Settings;

public class InputManager {
	
	/* The method to check the input */
	public static void checkInput() {
		//Check what rendering mode is being used
		if (Settings.Video.OpenGL)
			InputManagerLWJGL.checkInput();
		else
			InputManagerJava.checkInput();
	}
	
	/* The method to setup the keyboard and mouse */
	public static void create() {
		//Check what rendering mode is being used
		if (Settings.Video.OpenGL)
			InputManagerLWJGL.create();
		else
			InputManagerJava.create();
	}
	
	/* The method to destroy the keyboard and mouse */
	public static void destroy() {
		//Check what rendering mode is being used
		if (Settings.Video.OpenGL)
			InputManagerLWJGL.destroy();
		else
			InputManagerJava.destroy();
	}
	
}