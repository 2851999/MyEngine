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

import org.simplecorporation.myengine.core.Settings;

public class OpenGLSetupUtils {
	
	/* The method to setup an orthographic view */
	public static void setupOrtho(float znear , float zfar) {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			OpenGLSetupUtilsLWJGL.setupOrtho(znear, zfar);
		else if (Settings.Android && Settings.Video.OpenGL)
			OpenGLSetupUtilsAndroid.setupOrtho(znear, zfar);
	}
	
	/* The method to setup a perspective view */
	public static void setupPerspective(float fov , float znear , float zfar) {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			OpenGLSetupUtilsLWJGL.setupPerspective(fov, znear, zfar);
		else if (Settings.Android && Settings.Video.OpenGL)
			OpenGLSetupUtilsAndroid.setupPerspective(fov, znear, zfar);
	}
	
	/* The method to setup blending to remove alpha */
	public static void setupRemoveAlpha() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			OpenGLSetupUtilsLWJGL.setupRemoveAlpha();
		else if (Settings.Android && Settings.Video.OpenGL)
			OpenGLSetupUtilsAndroid.setupRemoveAlpha();
	}
	
	/* The method used to setup depth testing */
	public static void setupDepthTest() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			OpenGLSetupUtilsLWJGL.setupDepthTest();
		else if (Settings.Android && Settings.Video.OpenGL)
			OpenGLSetupUtilsAndroid.setupDepthTest();
	}
	
}