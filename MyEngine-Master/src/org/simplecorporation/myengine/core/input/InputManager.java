/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.input;

import org.simplecorporation.myengine.settings.Settings;

public class InputManager {
	
	/* The android input */
	private static InputManagerAndroid inputManagerAndroid;
	
	/* The java input */
	private static InputManagerJava inputManagerJava;
	
	/* The method to check the input */
	public static void checkInput() {
		//Check what rendering mode is being used
		if (! Settings.Android && Settings.Video.OpenGL)
			InputManagerLWJGL.checkInput();
		else if (! Settings.Android)
			inputManagerJava.checkInput();
		else if (Settings.Android)
			inputManagerAndroid.checkInput();
	}
	
	/* The method to setup the keyboard and mouse */
	public static void create() {
		//Check what rendering mode is being used
		if (! Settings.Android && Settings.Video.OpenGL)
			InputManagerLWJGL.create();
		else if (! Settings.Android) {
			inputManagerJava = new InputManagerJava();
			inputManagerJava.create();
		} else if (Settings.Android) {
			inputManagerAndroid = new InputManagerAndroid();
			inputManagerAndroid.create();
		}
	}
	
	/* The method to destroy the keyboard and mouse */
	public static void destroy() {
		//Check what rendering mode is being used
		if (! Settings.Android && Settings.Video.OpenGL)
			InputManagerLWJGL.destroy();
		else if (! Settings.Android)
			inputManagerJava.destroy();
		else if (Settings.Android)
			inputManagerAndroid.destroy();
	}
	
}