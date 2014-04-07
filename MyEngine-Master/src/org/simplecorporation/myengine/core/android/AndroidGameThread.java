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

import org.simplecorporation.myengine.core.game.BaseGame;
import org.simplecorporation.myengine.core.input.InputManager;

import android.view.SurfaceHolder;

public class AndroidGameThread extends Thread {
	
	/* Is the thread running */
	public boolean running;
	
	/* Is the thread paused */
	public boolean paused;
	
	/* The surface holder */
	public SurfaceHolder surfaceHolder;
	
	/* The android game */
	public BaseGame androidGame;
	
	/* The android display */
	public AndroidDisplay androidDisplay;
	
	/* The constructor */
	public AndroidGameThread(SurfaceHolder surfaceHolder , BaseGame androidGame, AndroidDisplay androidDisplay) {
		//Set running to false
		this.running = false;
		//Set paused to false
		this.paused = false;
		//Assign the surface holder
		this.surfaceHolder = surfaceHolder;
		//Assign the android game
		this.androidGame = androidGame;
		//Assign the android display
		this.androidDisplay = androidDisplay;
	}
	
	/* The method to set the running variable */
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	/* Returns whether the thread is running */
	public boolean isRunning() {
		return this.running;
	}
	
	/* The run method */
	public void run() {
		//Set the game canvas to null
		AndroidStore.gameCanvas = null;
		//Start the game
		this.androidGame.create();
		//Run while the variable running is true
		while (running) {
			//Check if the thread is paused and make sure the android display has been created
			if (! this.paused && this.androidDisplay.created) {
				//Check the input
				InputManager.checkInput();
				//Try statement
				try {
					//Set the game canvas
					AndroidStore.gameCanvas = this.surfaceHolder.lockCanvas();
					synchronized (this.surfaceHolder) {
						//Update/Render the game
						this.androidGame.tick();
					}
				} finally {
					//Check that the canvas isn't null
					if (AndroidStore.gameCanvas != null) {
						this.surfaceHolder.unlockCanvasAndPost(AndroidStore.gameCanvas);
					}
				}
			}
		}
	}
	
}