/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.image;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.simplecorporation.myengine.core.window.JavaWindow;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.file.FileUtils;
import org.simplecorporation.myengine.utils.logger.Logger;

public class Image {
	
	/* The image object for Java */
	private java.awt.Image javaImage;
	
	/* The image object for OpenGL */
	private Texture openGLImage;
	
	/* The default constructor */
	public Image() {
		
	}
	
	/* The constructor with the file path and format specified */
	public Image(String filePath , String format , boolean inFolder) {
		//Load the image
		load(filePath , format , inFolder);
	}
	
	/* The method to load the image */
	public void load(String filePath , String format , boolean inFolder) {
		//Check what rendering mode is being used
		if (Settings.Video.OpenGL) {
			//Load the OpenGL image
			try {
				//Check if the image is in a folder
				if (inFolder)
					this.openGLImage = TextureLoader.getTexture(format , new FileInputStream(FileUtils.asFileString(filePath)));
				else
					//NOTE COULD BE VERY WRONG IF THERE IS AN ERROR MAKE A NOTE IN THE ISSUES SECTION
					this.openGLImage = TextureLoader.getTexture(format , new FileInputStream(filePath));
			} catch (FileNotFoundException e) {
				//Log a message
				Logger.log("Image load()" , "FileNotFound " + filePath);
				e.printStackTrace();
			} catch (IOException e) {
				//Log a message
				Logger.log("Image load()" , "IOException " + filePath);
				e.printStackTrace();
			}
		} else {
			//Load the Java image after checking if the image is in a folder
			if (inFolder) {
				Toolkit tk = Toolkit.getDefaultToolkit();
				this.javaImage = tk.getImage(FileUtils.asFileString(filePath));
			} else {
				Toolkit tk = Toolkit.getDefaultToolkit();
				this.javaImage = tk.getImage(getURL(filePath));
			}
		}
	}
	
	/* The method to get the URL of the image */
	public URL getURL(String filePath) {
		URL url = null;
		try {
			url = this.getClass().getResource(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	
	/* Returns the Java image */
	public java.awt.Image getJavaImage() {
		//Return the image
		return this.javaImage;
	}
	
	/* Returns the OpenGL image */
	public Texture getOpenGLImage() {
		//Return the image
		return this.openGLImage;
	}
	
	/* The method that returns the width of the image */
	public int getWidth() {
		//Return the right image's width
		if (Settings.Video.OpenGL)
			return this.openGLImage.getImageWidth();
		else
			return this.javaImage.getWidth(JavaWindow.frame);
	}
	
	/* The method that returns the height of the image */
	public int getHeight() {
		//Return the right image's height
		if (Settings.Video.OpenGL)
			return this.openGLImage.getImageHeight();
		else
			return this.javaImage.getHeight(JavaWindow.frame);
	}
	
}