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

import javax.microedition.khronos.opengles.GL10;

import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.android.AndroidStore;

import android.opengl.GLU;

public class OpenGLSetupUtilsAndroid {
	
	/* The method to setup an orthographic view */
	public static void setupOrtho(float znear , float zfar) {
		AndroidStore.gl10.glMatrixMode(GL10.GL_PROJECTION);
		AndroidStore.gl10.glLoadIdentity();
		AndroidStore.gl10.glOrthof(0 , Settings.Window.Size.Width , Settings.Window.Size.Height ,
				0 , znear , zfar);
		AndroidStore.gl10.glMatrixMode(GL10.GL_MODELVIEW);
		AndroidStore.gl10.glLoadIdentity();
	}
	
	/* The method to setup a perspective view */
	public static void setupPerspective(float fov , float znear , float zfar) {
		AndroidStore.gl10.glMatrixMode(GL10.GL_PROJECTION);
		AndroidStore.gl10.glLoadIdentity();
		GLU.gluPerspective(AndroidStore.gl10, fov, Settings.Window.Size.Width / Settings.Window.Size.Height, znear, zfar);
		AndroidStore.gl10.glMatrixMode(GL10.GL_MODELVIEW);
		AndroidStore.gl10.glLoadIdentity();
	}
	
	/* The method to setup blending to remove alpha */
	public static void setupRemoveAlpha() {
		AndroidStore.gl10.glEnable(GL10.GL_BLEND);
		AndroidStore.gl10.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	}
	
	/* The method used to setup depth testing */
	public static void setupDepthTest() {
		AndroidStore.gl10.glEnable(GL10.GL_DEPTH_TEST);
	}
	
}