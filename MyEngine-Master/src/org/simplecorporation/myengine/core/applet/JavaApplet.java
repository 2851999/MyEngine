/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.applet;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.RenderVariablesJava;
import org.simplecorporation.myengine.core.window.Window;
import org.simplecorporation.myengine.core.window.WindowSizeChangedEvent;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class JavaApplet {
	
	/* The applet instance */
	public static java.applet.Applet applet;
	
	/* The buffered image */
	public static BufferedImage backBuffer;
	
	/* The graphics 2D */
	public static Graphics2D g2d;
	
	/* The max FPS to know when it has been changed */
	public static int maxFPS;
	
	/* The wait time to limit the FPS */
	public static long waitTime;
	
	/* The last frame */
	public static long lastFrameTime;
	
	/* The last second */
	public static long lastFPSSecond;
	
	/* The FPS counter */
	public static long frameCount;
	
	/* The method to create the applet */
	public static void create() {
		//Create the Applet
		applet = new java.applet.Applet();
		//Set the attributes of the frame
		applet.setSize(640 , 480);
		applet.setVisible(true);
		
		//Set the maximum FPS
		maxFPS = Settings.Video.MaxFPS;
		
		//Check if the max FPS is 0
		if (maxFPS == 0)
			//Set the wait time
			waitTime = 0;
		else
			//Set the wait time
			waitTime = 1000 / maxFPS;
		
		//Set the last frame's time
		lastFrameTime = System.currentTimeMillis();
		//Set the lastFPSSecond
		lastFPSSecond = System.currentTimeMillis();
		//Set the frame count
		frameCount = 0;
		
		//Update the window to the right settings
		updateSettings();
	}
	
	/* The method to close the applet */
	public static void close() {
		//Close the window
		applet.setVisible(false);
		//Set frame to nothing
		applet = null;
	}
	
	/* The method to set the applet to the right settings */
	public static void updateSettings() {
		//The current screen size
		float appletWidth = applet.getWidth();
		float appletHeight = applet.getHeight();
		//Check if the window settings are right
		if (applet.getWidth() - applet.getInsets().left + applet.getInsets().right != Settings.Window.Size.Width ||
				applet.getHeight() + applet.getInsets().top + applet.getInsets().bottom != Settings.Window.Size.Height) {
			//Setup the window
			//Set the screen size
			applet.setSize((int)Settings.Window.Size.Width + applet.getInsets().left + applet.getInsets().right , (int)Settings.Window.Size.Height + applet.getInsets().top + applet.getInsets().bottom);
		}
		
		//Check if the graphics object has been created and the buffered image is the right size
		if (g2d == null || backBuffer == null || backBuffer.getWidth() != applet.getWidth() || backBuffer.getHeight() != applet.getHeight()) {
			//Create the back buffer and the graphics 2D objects
			backBuffer = new BufferedImage(applet.getWidth() , applet.getHeight() , BufferedImage.TYPE_INT_RGB);
			g2d = backBuffer.createGraphics();
			RenderVariablesJava.g2d = g2d;
			RenderVariablesJava.backBuffer = backBuffer;
			RenderVariablesJava.container = applet;
		}
		
		//Check if the max FPS has changed since it was last set
		if (maxFPS != Settings.Video.MaxFPS) {
			//Set the max FPS
			maxFPS = Settings.Video.MaxFPS;
			//Check if the max FPS is 0
			if (maxFPS == 0)
				//Set the wait time
				waitTime = 0;
			else
				//Set the wait time
				waitTime = 1000 / maxFPS;
		}
		//Check if the screen size has changed
		if (appletWidth != applet.getWidth() || appletHeight != applet.getHeight()) {
			//Call an event
			Window.callWindowSizeChangedEvent(new WindowSizeChangedEvent(appletWidth , appletHeight , applet.getWidth() , applet.getHeight()));
		}
	}
	
	/* The method to update the applet graphics */
	public static void updateGraphics() {
		//Paint the back buffer to the applet
		applet.getGraphics().drawImage(backBuffer , applet.getInsets().left , applet.getInsets().top , applet);
		
		//Set the last frame
		lastFrameTime = System.currentTimeMillis();
		
		//Check the FPS
		frameCount ++;
		if (System.currentTimeMillis() - lastFPSSecond >= 1000) {
			long fps = frameCount;
			frameCount = 0;
			lastFPSSecond = System.currentTimeMillis();
			
			//Check whether the maximum FPS isn't equal to 0
			if (maxFPS != 0) {
				//Check whether the FPS is higher or lower than the maximum
				if (fps > maxFPS) {
					waitTime ++;
				} else if (fps < maxFPS) {
					waitTime --;
				}
			}
		}
		
		//Make the system wait
		try {
			//Make sure the wait time isn't 0 or less
			if (waitTime <= 0)
				Thread.sleep(0);
			else
				Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			//Log a message
			Logger.log(new Log("JavaApplet updateGraphics()" , "InterruptedException" , LogType.ERROR));
			e.printStackTrace();
		}
	}
	
	/* The method to set the cursor image */
	public static void setCursor(Image image , int pointX , int pointY , String cursorName) {
		//Set the cursor
		applet.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(image.getJavaImage() , new Point(pointX , pointY) , cursorName));
	}
	
	/* The method to centre the window */
	public static void centre() {
		//Get the screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//Centre the window by setting its location
		applet.setLocation((int)(screenSize.width / 2) - (int)(Settings.Window.Size.Width / 2) , (int)(screenSize.height / 2) - (int)(Settings.Window.Size.Height / 2));
	}
	
	/* Is the window still visible */
	public static boolean isVisible() {
		return applet.isVisible();
	}
	
}