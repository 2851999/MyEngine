/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.opengl;

import static org.lwjgl.opengl.GL11.*;

import org.simplecorporation.myengine.core.Settings;

public class DisplayList {
	
	/* The method used to start to generate a display list */
	public static int generate() {
		int handle = 0;
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL) {
			handle = glGenLists(1);
			glNewList(handle, GL_COMPILE);
		}
		return handle;
	}
	
	/* The method used to stop generating a display list */
	public static void end() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			glEndList();
	}
	
	/* The method used to render a list */
	public static void render(int handle) {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			glCallList(handle);
	}
	
}