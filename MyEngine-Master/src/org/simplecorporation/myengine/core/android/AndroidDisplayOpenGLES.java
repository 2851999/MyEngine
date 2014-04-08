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

import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.android.input.AndroidInput;
import org.simplecorporation.myengine.core.game.BaseGame;
import org.simplecorporation.myengine.core.input.InputManager;
import org.simplecorporation.myengine.utils.ScreenUtils;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class AndroidDisplayOpenGLES extends GLSurfaceView {
	
	/* The android game */
	public BaseGame androidGame;
	
	/* The boolean that states whether the game has already been created */
	public boolean gameAlreadyCreated;
	
	/* The constructor */
	public AndroidDisplayOpenGLES(Activity gameActivity , BaseGame androidGame) {
		//Call the super constructor
		super(gameActivity);
		
		//Add the callback
		this.getHolder().addCallback(this);
		
		//Assign the variables
		AndroidStore.gameActivity = gameActivity;
		this.androidGame = androidGame;
		this.gameAlreadyCreated = false;
		
		//Create the renderer
		this.setRenderer(new AndroidRendererOpenGLES(this, this.androidGame));
		
		//Set the surface view focusable
		this.setFocusable(true);
		
		//Create the input
		InputManager.create();
		//Set the size of the screen in the settings based on the value of fullscreen
		if (Settings.Window.Fullscreen) {
			Settings.Window.Size.Width = ScreenUtils.getScreenWidth();
			Settings.Window.Size.Height = ScreenUtils.getScreenHeight();
		} else {
			//Set the size of the screen in the settings
			Settings.Window.Size.Width = this.getWidth();
			Settings.Window.Size.Height = this.getHeight();
		}
		//Set the game resources
		AndroidStore.gameResources = this.getResources();
		//Make sure the game hasn't already been created
		if (! this.gameAlreadyCreated) {
			//Assign 'gameAlreadyCreated' to true
			this.gameAlreadyCreated = true;
			//Create the game
			this.androidGame.create();
		}
	}
	
	/* Called to change the display */
	public void changeDisplay(int width , int height) {
		//Set the size of the screen in the settings based on the value of fullscreen
		if (Settings.Window.Fullscreen) {
			Settings.Window.Size.Width = ScreenUtils.getScreenWidth();
			Settings.Window.Size.Height = ScreenUtils.getScreenHeight();
		} else {
			//Set the size of the screen in the settings
			Settings.Window.Size.Width = this.getWidth();
			Settings.Window.Size.Height = this.getHeight();
		}
	}
	
	/* Called when the surface is destroyed */
	public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
		Log.d("HELLO", "SURFACE DESTROYED");
	}
	
	/* The on touch method NOTE: DO NOT MOVE, IF YOU MOVE THIS THIS
	 * TO AndroidActivity, the coordinates given will include the title
	 * bar and the engine will not work properly when fullscreen = false */
	public boolean onTouchEvent(MotionEvent e) {
		//Call the touch event
		AndroidInput.callTouchEvent(e);
		//The event was handled
		return true;
	}
	
}