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

/**
 * The InputManager <code>class</code> is used to manage input both on
 * PC and on Android.
 */
public class InputManager {
	
	/**
	 * A static instance of the Android InputManager
	 */
	/* The android input */
	private static InputManagerAndroid inputManagerAndroid;
	
	/**
	 * A static instance of the Java (PC) InputManager
	 */
	/* The java input */
	private static InputManagerJava inputManagerJava;
	
	/**
	 * A method used to check the input using the appropriate
	 * input manager
	 */
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
	
	/**
	 * A method used to create the input manager instances and
	 * setup to be ready for receiving input
	 */
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
	
	/**
	 * A method used to destroy the input
	 */
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