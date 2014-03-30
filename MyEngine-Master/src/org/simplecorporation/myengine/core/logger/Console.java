/* ********************************************
 * SIMPLE CORPORATION
 * 
 * Simple Engine (SE)
 * 
 * COPYRIGHT @ 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.logger;

import org.simplecorporation.myengine.core.Settings;

public class Console {
	
	/* The static method used to print out something on a line */
	public static void println(String message) {
		//Check whether the engine is running on android
		if (Settings.Android)
			android.util.Log.d("MyEngine" , message);
		else if (! Settings.Android)
			System.out.println(message);
	}
	
}