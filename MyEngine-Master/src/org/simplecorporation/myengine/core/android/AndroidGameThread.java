/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android;

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
	public AndroidGame androidGame;
	
	/* The constructor */
	public AndroidGameThread(SurfaceHolder surfaceHolder , AndroidGame androidGame) {
		//Set running to false
		this.running = false;
		//Set paused to false
		this.paused = false;
		//Assign the surface holder
		this.surfaceHolder = surfaceHolder;
		//Assign the android game
		this.androidGame = androidGame;
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
		//Run while the variable running is true
		while (running) {
			//Check if the thread is paused
			if (! this.paused) {
				//Check the input
				InputManager.checkInput();
				//Set the game canvas to null
				AndroidStore.gameCanvas = null;
				//Try statement
				try {
					//Set the game canvas
					AndroidStore.gameCanvas = this.surfaceHolder.lockCanvas();
					synchronized (this.surfaceHolder) {
						//Update the game
						this.androidGame.gameUpdate();
						//Render the game
						this.androidGame.gameRender();
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