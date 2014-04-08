/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import org.simplecorporation.myengine.core.game.BaseGame;

import android.opengl.GLSurfaceView;
import android.util.Log;

public class AndroidRendererOpenGLES implements GLSurfaceView.Renderer {
	
	/* The display */
	public AndroidDisplayOpenGLES androidDisplay;
	
	/* The game */
	public BaseGame androidGame;
	
	/* The constructor */
	public AndroidRendererOpenGLES(AndroidDisplayOpenGLES androidDisplay, BaseGame androidGame) {
		//Assign the variables
		this.androidDisplay = androidDisplay;
		this.androidGame = androidGame;
	}
	
	/* The method called when this surface is created */
	public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
		Log.d("HELLO", "SURFACE CREATED");
		gl.glClearColor(1f, 0f, 0f, 1f);
	}
	
	/* The method called when this surface is changed */
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		//Change the display
		this.androidDisplay.changeDisplay(width, height);
	}
	
	/* The method called to draw the frame */
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		//Update and render the game
		this.androidGame.engineUpdate();
		this.androidGame.engineRender();
	}
	
}