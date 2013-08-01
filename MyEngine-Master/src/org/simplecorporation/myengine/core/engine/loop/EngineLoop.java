/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.loop;

import org.lwjgl.Sys;
import org.simplecorporation.myengine.core.window.Window;

public abstract class EngineLoop {
	
	/* The method for the engine being created */
	public abstract void engineCreated();
	
	/* The method for the engine being started */
	public abstract void engineStarted();
	
	/* The method for the engine being updated */
	public abstract void engineUpdate();
	
	/* The method for the engine being rendered */
	public abstract void engineRender();
	
	/* The method for the engine being stopped */
	public abstract void engineStopped();
	
	/* The method for the engine closing */
	public abstract void engineClosing();
	
	/* The last frame */
	public long lastFrameTime;
	
	/* The last second */
	public long lastFPSSecond;
	
	/* The FPS counter */
	public long frameCount;
	
	/* The current FPS */
	public long fps;
	
	/* The default constructor */
	public EngineLoop() {
		
	}
	
	/* The create method */
	public void create() {
		//Create the window
		Window.create();
		//Call the engineCreated event
		this.engineCreated();
		//Start the engine loop
		this.start();
	}
	
	/* The start method */
	public void start() {
		//Set the last frame's time
		this.lastFrameTime = getTime();
		//Set the lastFPSSecond
		this.lastFPSSecond = getTime();
		//Set the frame count and FPS
		this.frameCount = 0;
		this.fps = 0;
		//While the window is open
		while (! Window.isCloseRequested()) {
			//Update the engine
			this.engineUpdate();
			//Render the engine
			this.engineRender();
			
			//Update the window
			Window.update();
			
			//Set the last frame
			this.lastFrameTime = getTime();
			
			//Check the FPS
			frameCount ++;
			if (getTime() - this.lastFPSSecond >= 1000) {
				this.fps = this.frameCount;
				this.frameCount = 0;
				this.lastFPSSecond = getTime();
				System.out.println(getFPS());
			}
		}
		//Call the engineStopped method
		this.engineStopped();
		//Close the window
		Window.close();
		//Call the engineClosing method
		this.engineClosing();
		//Exit the program
		System.exit(0);
	}
	
	/* Method to get the current system time */
	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	/* The method to get the delta */
	public double getDelta() {
		//The current time
		long currentTime = this.getTime();
		//Work out the delta
		double delta = (double)currentTime - (double)this.lastFrameTime;
		//Return the delta
		return delta;
	}
	
	/* The method to return the current FPS */
	public long getFPS() {
		return this.fps;
	}
	
}