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

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.settings.Settings;

public class OpenGLUtils {
	
	/* The method to clear the colour buffer */
	public static void clearColourBuffer() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}
	
	/* The method used to clear the depth buffer */
	public static void clearDepthBuffer() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
	}
	
	/* The method used to enable texture 2D */
	public static void enableTexture2D() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	
	/* The method used to disabled texture 2D */
	public static void disableTexture2D() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			GL11.glDisable(GL11.GL_TEXTURE_2D);
	}
	
	/* The method to get the OpenGL version */
	public static String getVersion() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			return GL11.glGetString(GL11.GL_VERSION);
		else
			return "";
	}
	
}