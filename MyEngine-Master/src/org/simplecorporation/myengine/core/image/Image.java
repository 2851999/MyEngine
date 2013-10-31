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
import java.io.InputStream;
import java.net.URL;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.core.window.JavaWindow;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.file.FileUtils;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Image {
	
	/* The image object for Java */
	private java.awt.Image javaImage;
	
	/* The image object for OpenGL */
	private Texture openGLImage;
	
	/* The image object for Android */
	private Bitmap androidImage;
	
	/* The default constructor */
	public Image() {
		
	}
	
	/* The constructor with the file path and format specified */
	public Image(String filePath , String format , boolean inFolder) {
		//Load the image
		load(filePath , format , inFolder);
	}
	
	/* The constructor for android */
	public Image(int id) {
		//Load the image
		load(id);
	}
	
	/* The method to load the image */
	public void load(String filePath , String format , boolean inFolder) {
		//Check what rendering mode is being used
		if (! Settings.Android && Settings.Video.OpenGL) {
			//Load the OpenGL image
			try {
				//Check if the image is in a folder
				if (inFolder)
					this.openGLImage = TextureLoader.getTexture(format , new FileInputStream(FileUtils.asFileString(filePath)));
				else
					this.openGLImage = TextureLoader.getTexture(format , getURLInputStream(filePath));
			} catch (FileNotFoundException e) {
				//Log a message
				Logger.log(new Log("Image load()" , "FileNotFound " + filePath , LogType.ERROR));
				e.printStackTrace();
			} catch (IOException e) {
				//Log a message
				Logger.log(new Log("Image load()" , "IOException " + filePath , LogType.ERROR));
				e.printStackTrace();
			}
		} else if (! Settings.Android && ! Settings.Video.OpenGL) {
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
	
	/* The method to load an image for android */
	public void load(int id) {
		//Set the image
		this.androidImage = BitmapFactory.decodeResource(AndroidStore.gameResources , id);
	}
	
	/* The method to get the URL of the image */
	public URL getURL(String filePath) {
		URL url = null;
		try {
			url = this.getClass().getResource(filePath);
		} catch (Exception e) {
			//Log a message
			Logger.log(new Log("Image getURL()" , "Exception when loading the image " + filePath , LogType.ERROR));
			e.printStackTrace();
		}
		return url;
	}
	
	/* The method to get the URL input stream of the image */
	public InputStream getURLInputStream(String filePath) {
		InputStream stream = null;
		try {
			stream = this.getClass().getResourceAsStream(filePath);
		} catch (Exception e) {
			//Log a message
			Logger.log(new Log("Image getURLInputStream()" , "Exception when loading the image " + filePath , LogType.ERROR));
			e.printStackTrace();
		}
		return stream;
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
	
	/* Returns the android image */
	public Bitmap getAndroidImage() {
		//Return the image
		return this.androidImage;
	}
	
	/* The method that returns the width of the image */
	public int getWidth() {
		//Return the right image's width
		if (Settings.Video.OpenGL)
			return this.openGLImage.getImageWidth();
		else if (! Settings.Android)
			return this.javaImage.getWidth(JavaWindow.frame);
		else if (Settings.Android)
			return this.androidImage.getWidth();
		else
			return 0;
	}
	
	/* The method that returns the height of the image */
	public int getHeight() {
		//Return the right image's height
		if (Settings.Video.OpenGL)
			return this.openGLImage.getImageHeight();
		else if (! Settings.Android)
			return this.javaImage.getHeight(JavaWindow.frame);
		else if (Settings.Android)
			return this.androidImage.getHeight();
		else
			return 0;
	}
	
}