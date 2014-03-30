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

import org.simplecorporation.myengine.core.Settings;

/**
 * The InputManager <code>class</code> is used to manage input both on
 * PC and on Android.
 */
public class InputManager {
	
	/* The android input */
	/**
	 * A static instance of the Android InputManager
	 */
	private static InputManagerAndroid inputManagerAndroid;
	
	/* The java input */
	/**
	 * A static instance of the Java (PC) InputManager
	 */
	private static InputManagerJava inputManagerJava;
	
	/* The method to check the input */
	/**
	 * A method used to check the input using the appropriate
	 * input manager
	 */
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
	/**
	 * A method used to create the input manager instances and
	 * setup to be ready for receiving input
	 */
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
	/**
	 * A method used to destroy the input
	 */
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