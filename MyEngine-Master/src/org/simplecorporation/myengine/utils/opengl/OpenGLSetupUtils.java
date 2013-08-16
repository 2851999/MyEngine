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
import org.lwjgl.util.glu.GLU;
import org.simplecorporation.myengine.settings.Settings;

public class OpenGLSetupUtils {
	
	/* The method to setup an orthographic view */
	public static void setupOrtho(float znear , float zfar) {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0 , Settings.Window.Size.Width , Settings.Window.Size.Height ,
				0 , znear , zfar);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	/* The method to setup a perspective view */
	public static void setupPerspective(float fov , float znear , float zfar) {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GLU.gluPerspective(fov , Settings.Window.Size.Width / Settings.Window.Size.Height ,
				znear , zfar);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
}