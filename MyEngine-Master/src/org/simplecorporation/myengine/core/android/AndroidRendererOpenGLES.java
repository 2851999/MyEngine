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
	public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
		
	}
	
	/* The method called when this surface is changed */
	public void onSurfaceChanged(GL10 gl10, int width, int height) {
		//Change the display
		this.androidDisplay.changeDisplay(width, height);
	}
	
	/* The method called to draw the frame */
	public void onDrawFrame(GL10 gl10) {
		//Assign the 'gl10' object in the AndroidStore
		AndroidStore.gl10 = gl10;
		//Update and render the game
		this.androidGame.engineUpdate();
		this.androidGame.engineRender();
	}
	
}