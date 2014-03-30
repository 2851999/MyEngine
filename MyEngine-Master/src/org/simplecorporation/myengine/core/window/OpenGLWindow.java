/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.window;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.ByteBuffer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;
import org.simplecorporation.myengine.utils.messagebox.MessageBox;

public class OpenGLWindow {
	
	/* Has the window been created */
	public static boolean windowCreated;
	
	/* The method to create the window */
	public static void create() {
		try {
			//Set window created to false
			windowCreated = false;
			//Set the attributes of the window
			Display.setTitle("MyEngine Window");
			Display.setDisplayMode(new DisplayMode(640 , 480));
			Display.setResizable(false);
			//Set VSync enabled if this is changed while running it
			//the engine will need to restart
			Display.setVSyncEnabled(Settings.Video.VSync);
			//Update the window to the right settings
			updateSettings();
			//Create the display
			Display.create();
			//Set windowCreated to true
			windowCreated = true;
		} catch (LWJGLException e) {
			//Log a message
			//Display an error message box
			MessageBox.showErrorMessage("LWJGL Exception" , "Error in OpenGLWindow create()");
			Logger.log(new Log("OpenGLWindow create()" , "LWJGL Exception" , LogType.ERROR));
			e.printStackTrace();
		}
	}
	
	/* The method to close the window */
	public static void close() {
		//Close the window
		Display.destroy();
	}
	
	/* The method to set the window to the right settings */
	public static void updateSettings() {
		//The current screen size
		float windowWidth = Display.getWidth();
		float windowHeight = Display.getHeight();
		try {
			//Check if the window settings are right
			if (Display.getTitle() != Settings.Window.Title || (Display.getWidth() != Settings.Window.Size.Width ||
					Display.getHeight() != Settings.Window.Size.Height && Display.isFullscreen() != Settings.Window.Fullscreen) || Display.isFullscreen() != Settings.Window.Fullscreen) {
				//Setup the window
				Display.setTitle(Settings.Window.Title);
				//Check if the window should be full screen
				if (Settings.Window.Fullscreen) {
					//Make the window full screen
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					
					//Find and set the right display mode
					Display.setDisplayMode(getFullscreenDisplayMode(screenSize.width , screenSize.height));
					
					//Make the window full screen
					if (Display.isFullscreen() != Settings.Window.Fullscreen) {
						//Make the window full screen
						Display.setFullscreen(true);
					}
					//Set the window width and height in the Settings
					Settings.Window.Size.Width = Display.getWidth();
					Settings.Window.Size.Height = Display.getHeight();
				} else {
					//Set the screen size
					Display.setDisplayMode(new DisplayMode((int)Settings.Window.Size.Width , (int)Settings.Window.Size.Height));
					//Set VSync to false
					Display.setVSyncEnabled(false);
					//Make sure the window isn't full screen
					if (Display.isFullscreen() != Settings.Window.Fullscreen) {
						Display.setFullscreen(false);
					}
				}
			}
		} catch (LWJGLException e) {
			//Log a message
			Logger.log(new Log("OpenGLWindow updateSettings()" , "LWJGL Exception" , LogType.ERROR));
			//Display an error message box
			MessageBox.showErrorMessage("LWJGL Exception" , "Error in OpenGLWindow updateSettings()");
			e.printStackTrace();
		}
		//Check if the screen size has changed
		if (windowWidth != Display.getWidth() || windowHeight != Display.getHeight()) {
			//Make sure the display has been created
			if (windowCreated && Display.isActive()) {
				//Make sure OpenGL changes its resolution
				GL11.glScissor(0 , 0 , Display.getWidth() , Display.getHeight());
				GL11.glViewport(0 , 0 , Display.getWidth() , Display.getHeight());
			}
			//Set the settings
			Settings.Window.Size.Width = Display.getWidth();
			Settings.Window.Size.Height = Display.getHeight();
			//Call an event
			Window.callWindowSizeChangedEvent(new WindowSizeChangedEvent(windowWidth , windowHeight , Settings.Window.Size.Width , Settings.Window.Size.Height));
		}
	}
	
	/* The method to update the window graphics */
	public static void updateGraphics() {
		//Update the display and sync it
		Display.update();
		Display.sync(Settings.Video.MaxFPS);
	}
	
	/* The methods used to get a display mode for fullscreen */
	public static DisplayMode getFullscreenDisplayMode(int width , int height) {
 
		try {
			DisplayMode targetDisplayMode = null;
			DisplayMode[] modes = Display.getAvailableDisplayModes();
			int freq = 0;

			for (int i = 0; i< modes.length; i++) {
				DisplayMode current = modes[i];

				if ((current.getWidth() == width) && (current.getHeight() == height)) {
					if ((targetDisplayMode == null) || (current.getFrequency() >= freq)) {
						if ((targetDisplayMode == null) || (current.getBitsPerPixel() > targetDisplayMode.getBitsPerPixel())) {
							targetDisplayMode = current;
							freq = targetDisplayMode.getFrequency();
						}
					}
					
					if ((current.getBitsPerPixel() == Display.getDesktopDisplayMode().getBitsPerPixel()) &&
					    (current.getFrequency() == Display.getDesktopDisplayMode().getFrequency())) {
						targetDisplayMode = current;
						break;
					}
				}
			}
			
			//Return the display mode that hopefully has been found
			return targetDisplayMode;
 
		} catch (LWJGLException e) {
			//Log a message
			Logger.log(new Log("OpenGLWindow getFullscreenDisplayMode()" , "LWJGL Exception" , LogType.ERROR));
			//Display an error message box
			MessageBox.showErrorMessage("LWJGL Exception" , "Error in OpenGLWindow getFullscreenDisplayMode()");
			e.printStackTrace();
		}
		
		//Return new display mode
		return new DisplayMode(width , height);
	}
	
	/* The method to set the cursor image */
	public static void setCursor(Image image , int pointX , int pointY , String cursorName) {
		//NOT FINISHED YET
	}
	
	/* The method to centre the window */
	public static void centre() {
		//Get the screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//Centre the window by setting its location
		Display.setLocation((int)(screenSize.width / 2) - (int)(Settings.Window.Size.Width / 2) , (int)(screenSize.height / 2) - (int)(Settings.Window.Size.Height / 2));
	}
	
	/* The method to set the window icon */
	public static void setIcon(Image[] images) {
		ByteBuffer buffer1 = ByteBuffer.wrap(images[0].getOpenGLImage().getTextureData());
		ByteBuffer buffer2 = ByteBuffer.wrap(images[1].getOpenGLImage().getTextureData());
		Display.setIcon(new ByteBuffer[] { buffer1 , buffer2 });
	}
	
	/* Is the window still visible */
	public static boolean isVisible() {
		return Display.isVisible();
	}
	
	/* Is a close requested */
	public static boolean isCloseRequested() {
		return Display.isCloseRequested();
	}
	
}