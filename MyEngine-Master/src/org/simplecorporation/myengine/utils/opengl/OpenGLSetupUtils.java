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
import org.lwjgl.util.glu.GLU;
import org.simplecorporation.myengine.settings.Settings;

public class OpenGLSetupUtils {
	
	/* The method to setup an orthographic view */
	public static void setupOrtho(float znear , float zfar) {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL) {
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0 , Settings.Window.Size.Width , Settings.Window.Size.Height ,
					0 , znear , zfar);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
		}
	}
	
	/* The method to setup a perspective view */
	public static void setupPerspective(float fov , float znear , float zfar) {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL) {
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GLU.gluPerspective(fov , Settings.Window.Size.Width / Settings.Window.Size.Height ,
					znear , zfar);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
		}
	}
	
	/* The method to setup blending to remove alpha */
	public static void setupRemoveAlpha() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL) {
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA , GL11.GL_ONE_MINUS_SRC_ALPHA);
		}
	}
	
	/* The method used to setup depth testing */
	public static void setupDepthTest() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			GL11.glEnable(GL11.GL_DEPTH_TEST);
	}
	
}