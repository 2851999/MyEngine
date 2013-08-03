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

import org.lwjgl.input.Keyboard;

public class KeyboardInput {
	
	/* The method to check if a key is down */
	public static boolean isKeyDown(int key) {
		return Keyboard.isKeyDown(key);
	}
	
}