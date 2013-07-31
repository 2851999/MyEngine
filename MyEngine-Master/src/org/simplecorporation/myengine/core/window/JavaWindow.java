package org.simplecorporation.myengine.core.window;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import org.simplecorporation.myengine.settings.Settings;

public class JavaWindow {
	
	/* The JFrame */
	public static JFrame frame;
	
	/* The buffered image */
	public static BufferedImage backBuffer;
	
	/* The graphics 2D */
	public static Graphics2D g2d;
	
	/* The method to create the window */
	public static void create() {
		//Create the JFrame
		frame = new JFrame();
		//Set the attributes of the frame
		frame.setTitle("MyEngine Window");
		frame.setSize(640 , 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		//Update the window to the right settings
		updateSettings();
	}
	
	/* The method to set the window to the right settings */
	public static void updateSettings() {
		//Check if the window settings are right
		if (frame.getTitle() != Settings.Window.Title || frame.getWidth() != Settings.Window.Size.Width ||
				frame.getHeight() != Settings.Window.Size.Height || frame.isUndecorated() != Settings.Window.Fullscreen) {
			//Setup the window
			frame.setTitle(Settings.Window.Title);
			//Check if the window should be full screen
			if (Settings.Window.Fullscreen) {
				//Make the window full screen
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				//Set the window width and height
				frame.setSize(screenSize);
				//Make the window full screen
				if (frame.isUndecorated() != Settings.Window.Fullscreen) {
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
				//Make sure the window isn't full screen
				if (frame.isUndecorated() != Settings.Window.Fullscreen) {
					//Make the window decorated
					frame.dispose();
					frame.setUndecorated(false);
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
	}
	
	/* The method to update the window graphics */
	public static void updateGraphics() {
		//Paint the back buffer to the window
		frame.getGraphics().drawImage(backBuffer , 0 , 0 , frame);
	}
	
}