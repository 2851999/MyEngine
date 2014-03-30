/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.loop;

import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.applet.Applet;
import org.simplecorporation.myengine.core.game.GameValues;
import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.input.InputManager;
import org.simplecorporation.myengine.core.logger.Log;
import org.simplecorporation.myengine.core.logger.LogType;
import org.simplecorporation.myengine.core.logger.Logger;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.core.window.Window;
import org.simplecorporation.myengine.utils.SystemInfo;
import org.simplecorporation.myengine.utils.font.FontUtils;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;
import org.simplecorporation.myengine.utils.opengl.OpenGLUtils;

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
	
	/* The current delta */
	public double delta;
	
	/* The default font */
	public GUIFont font;
	
	/* The default constructor */
	public EngineLoop() {
		
	}
	
	/* The create method */
	public void create() {
		//Check if this is on android
		if (! Settings.Android && ! Settings.Applet) {
			//Create the window
			Window.create();
			//Create the input
			InputManager.create();
		} else if (! Settings.Android && Settings.Applet) {
			//Create the applet
			Applet.create();
			//Create the input
			InputManager.create();
		}
		//Check if not on Android and using OpenGL
		if (! Settings.Android && Settings.Video.OpenGL)
			//Log the OpenGL version
			Logger.log(new Log("MyEngine", "OpenGL V" + OpenGLUtils.getVersion(), LogType.INFORMATION));
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
		//Set the delta
		this.delta = 0;
		//Set the default font (Arial)
		this.font = FontUtils.buildGUIFont("Arial" , Colour.WHITE , 10);
		//Check if using android
		if (! Settings.Android && ! Settings.Applet) {
			//While the window is open
			while (! Window.isCloseRequested()) {
				//Run a cycle of the loop
				this.tick();
			}
			//Call the engineStopped method
			this.engineStopped();
			//Destroy the input
			InputManager.destroy();
			//Close the window
			Window.close();
			//Call the engineClosing method
			this.engineClosing();
			//Exit the program
			System.exit(0);
		} else if (! Settings.Android && Settings.Applet) {
			//While the applet is open
			while (! Applet.isCloseRequested()) {
				//Run a cycle of the loop
				this.tick();
			}
			//When the browser closes, no time to save or anything
			//so don't bother calling any of the methods mentioned
			//above
		}
	}
	
	/* Method called in the main loop */
	public void tick() {
		//Check the input
		InputManager.checkInput();
		
		//Update the engine
		this.engineUpdate();
		//Render the engine
		this.engineRender();
		
		//Make sure OpenGL is in an orthographic view
		OpenGLSetupUtils.setupOrtho(-1, 1);
		
		//Check if the debug info should be drawn
		if (Settings.Debugging.ShowInfo) {
			//Setup the remove alpha to allow the rendering of text when using OpenGL
			OpenGLSetupUtils.setupRemoveAlpha();
			//Render some information using the default font
			this.font.render("DEBUGGING" , 0 , 0);
			this.font.render("FPS: " + getFPS() , 0 , 12);
			this.font.render("Memory Usage: " + ((SystemInfo.getMaxMemory() / (1024 * 1024)) - (SystemInfo.getFreeMemory() / (1024 * 1024))) , 0 , 24);
			this.font.render("Processors: " + SystemInfo.getAvailableProcessors() , 0 , 36);
			this.font.render("OpenGL: " + Settings.Video.OpenGL , 0 , 48);
		}
		
		//Check if this is on android or an applet
		if (! Settings.Android && ! Settings.Applet)
			//Update the window
			Window.update();
		else if (! Settings.Android && Settings.Applet)
			//Update the applet
			Applet.update();
		
		//The current time
		long currentTime = this.getTime();
		//Work out the delta
		this.delta = (double)currentTime - (double)this.lastFrameTime;
		
		//Set the last frame
		this.lastFrameTime = getTime();
		
		//Check the FPS
		frameCount ++;
		if (getTime() - this.lastFPSSecond >= 1000) {
			this.fps = this.frameCount;
			this.frameCount = 0;
			this.lastFPSSecond = getTime();
		}
		
		//Set the current FPS and Delta values in the GameValues class
		GameValues.CURRENT_FPS = this.getFPS();
		GameValues.CURRENT_DELTA = this.getDelta();
	}
	
	/* Method to get the current system time */
	public long getTime() {
		return System.currentTimeMillis();
	}
	
	/* The method to get the delta */
	public double getDelta() {
		//Return the delta
		return delta;
	}
	
	/* The method to return the current FPS */
	public long getFPS() {
		return this.fps;
	}
	
}