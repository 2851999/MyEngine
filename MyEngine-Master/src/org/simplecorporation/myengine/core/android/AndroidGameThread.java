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
	
	/* The boolean that states whether the game has already been created */
	public boolean gameAlreadyCreated;
	
	/* The surface holder */
	public SurfaceHolder surfaceHolder;
	
	/* The android game */
	public BaseGame androidGame;
	
	/* The android display */
	public AndroidDisplay androidDisplay;
	
	/* The constructor */
	public AndroidGameThread(SurfaceHolder surfaceHolder , BaseGame androidGame, AndroidDisplay androidDisplay) {
		//Assign the variables
		this.running = false;
		this.paused = false;
		this.gameAlreadyCreated = false;
		this.surfaceHolder = surfaceHolder;
		this.androidGame = androidGame;
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
		//Make sure the game hasn't already been created
		if (! this.gameAlreadyCreated) {
			//Assign 'gameAlreadyCreated' to true
			this.gameAlreadyCreated = true;
			//Start the game
			this.androidGame.create();
		}
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