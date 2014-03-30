/* ********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils;

import org.simplecorporation.myengine.core.Settings;

public class Console {
	
	/* The static method used to print out something on a line */
	public static void println(String message) {
		//Check whether the engine is running on android
		if (Settings.Android)
			//Log the message on Android
			android.util.Log.d("MyEngine" , message);
		else if (! Settings.Android)
			//Log the message on PC
			System.out.println(message);
	}
	
}