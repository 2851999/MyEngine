/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.opengl;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.settings.Settings;

public class OpenGLUtils {
	
	/* The method to clear the colour buffer */
	public static void clearColourBuffer() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		}
	}
	
}