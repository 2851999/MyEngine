/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android;

import org.simplecorporation.myengine.core.android.input.AndroidInput;
import org.simplecorporation.myengine.core.game.Game;
import org.simplecorporation.myengine.core.input.InputManager;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.screen.ScreenUtils;

import android.app.Activity;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class AndroidDisplay extends SurfaceView implements SurfaceHolder.Callback {
	
	/* The android game */
	public Game androidGame;
	
	/* The android game thread */
	public AndroidGameThread androidGameThread;
	
	/* The constructor */
	public AndroidDisplay(Activity gameActivity , Game androidGame) {
		//Call the super constructor
		super(gameActivity);
		
		//Add the callback
		this.getHolder().addCallback(this);
		
		//Set the game activity in the AndroidStore
		AndroidStore.gameActivity = gameActivity;
		
		//Set the android game
		this.androidGame = androidGame;
		
		//Create the android game thread
		this.androidGameThread = new AndroidGameThread(this.getHolder() ,this.androidGame);
		
		//Set the surface view focusable
		this.setFocusable(true);
	}
	
	/* Called when the surface is created */
	public void surfaceCreated(SurfaceHolder surfaceHolder) {
		//Create the input
		InputManager.create();
		//Set the size of the screen in the settings if full screen
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
		//Create the game
		this.androidGame.gameCreated();
		//Create the paint object
		AndroidStore.gamePaint = new Paint();
		//Start the android game thread
		this.androidGameThread.setRunning(true);
		this.androidGameThread.start();
	}
	
	/* Called when the surface is changed */
	public void surfaceChanged(SurfaceHolder surfaceHolder , int format , int width , int height) {
		//Set the size of the screen in the settings
		Settings.Window.Size.Width = ScreenUtils.getScreenWidth();
		Settings.Window.Size.Height = ScreenUtils.getScreenHeight();
	}
	
	/* Called when the surface is destroyed */
	public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
		//Should the loop continue
		boolean retry = true;
		while(retry) {
			//Try and catch statement
			try {
				//Stop the game
				this.androidGame.gameStopped();
				//Close the game
				this.androidGame.gameClosing();
				//Join the thread
				this.androidGameThread.join();
				//Stop the while loop
				retry = false;
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	/* The on touch method */
	public boolean onTouchEvent(MotionEvent e) {
		//Call the touch event
		AndroidInput.callTouchEvent(e);
		//The event was handled
		return true;
	}
	
}