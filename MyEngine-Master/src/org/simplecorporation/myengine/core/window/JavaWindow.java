/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.window;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class JavaWindow {
	
	/* The JFrame */
	public static JFrame frame;
	
	/* The buffered image */
	public static BufferedImage backBuffer;
	
	/* The graphics 2D */
	public static Graphics2D g2d;
	
	/* Is close requested */
	public static boolean isCloseRequested;
	
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
	
	/* The method to create the window */
	public static void create() {
		//Create the JFrame
		frame = new JFrame();
		//Set the attributes of the frame
		frame.setTitle("MyEngine Window");
		frame.setSize(640 , 480);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		//Add a listener to check whether the window is closing
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				//Set is close requested to true
				isCloseRequested = true;
			}
		});
		
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
	
	/* The method to close the window */
	public static void close() {
		//Close the window
		frame.setVisible(false);
		frame.dispose();
		//Set frame to nothing
		frame = null;
	}
	
	/* The method to set the window to the right settings */
	public static void updateSettings() {
		//Check if the window settings are right
		if (frame.getTitle() != Settings.Window.Title || frame.getWidth() != Settings.Window.Size.Width ||
				frame.getHeight() != Settings.Window.Size.Height || frame.isUndecorated() != Settings.Window.Fullscreen ||
				frame.isUndecorated() != ! Settings.Window.Border) {
			//Setup the window
			frame.setTitle(Settings.Window.Title);
			//Check if the window should be full screen
			if (Settings.Window.Fullscreen) {
				//Make the window full screen
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				//Make the window full screen
				if (frame.isUndecorated() != Settings.Window.Fullscreen && (frame.getWidth() != screenSize.width || frame.getHeight() != screenSize.height )) {
					//Set the window width and height
					frame.setSize(screenSize);
					//Make the window undecorated
					frame.dispose();
					frame.setUndecorated(true);
					frame.setVisible(true);
				}
				//Set the window width and height in the Settings
				Settings.Window.Size.Width = frame.getWidth();
				Settings.Window.Size.Height = frame.getHeight();
			} else {
				//Set the screen size
				frame.setSize((int)Settings.Window.Size.Width , (int)Settings.Window.Size.Height);
				//Check if the window should have a borders
				if (frame.isUndecorated() == Settings.Window.Border) {	
					frame.dispose();
					frame.setUndecorated(! Settings.Window.Border);
					frame.setVisible(true);
				}
			}
		}
		
		//Check if the graphics object has been created and the buffered image is the right size
		if (g2d == null || backBuffer == null || backBuffer.getWidth() != frame.getWidth() || backBuffer.getHeight() != frame.getHeight()) {
			//Create the back buffer and the graphics 2D objects
			backBuffer = new BufferedImage(frame.getWidth() , frame.getHeight() , BufferedImage.TYPE_INT_RGB);
			g2d = backBuffer.createGraphics();
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
	}
	
	/* The method to update the window graphics */
	public static void updateGraphics() {
		//Paint the back buffer to the window
		frame.getGraphics().drawImage(backBuffer , 0 , 0 , frame);
		
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
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			//Log a message
			Logger.log(new Log("JavaWindow updateGraphics()" , "InterruptedException" , LogType.ERROR));
			e.printStackTrace();
		}
	}
	
	/* The method to set the cursor image */
	public static void setCursor(Image image , int pointX , int pointY , String cursorName) {
		//Set the cursor
		frame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(image.getJavaImage() , new Point(pointX , pointY) , cursorName));
	}
	
	/* The method to centre the window */
	public static void centre() {
		//Get the screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//Centre the window by setting its location
		frame.setLocation((int)(screenSize.width / 2) - (int)(Settings.Window.Size.Width / 2) , (int)(screenSize.height / 2) - (int)(Settings.Window.Size.Height / 2));
	}
	
	/* The method to set the window icon */
	public static void setIcon(Image[] images) {
		frame.setIconImage(images[0].getJavaImage());
	}
	
	/* Is the window still visible */
	public static boolean isVisible() {
		return frame.isVisible();
	}
	
	/* Is a close requested */
	public static boolean isCloseRequested() {
		return isCloseRequested;
	}
	
}