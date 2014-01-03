/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
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

/**
 * The Image <code>class</code> can load and store an image for use on PC
 * and android.
 * <p>
 * An <code>Image</code> can be used by
 * {@link org.simplecorporation.myengine.core.render.basic.BasicRenderer BasicRenderer}
 * to render it to the screen
 */
public class Image {
	
	/* The image object for Java */
	private java.awt.Image javaImage;
	
	/* The image object for OpenGL */
	private Texture openGLImage;
	
	/* The image object for Android */
	private Bitmap androidImage;
	
	/**
	 * The default constructor for <code>Image</code>
	 * It doesn't do anything. In order to load an image you must use
	 * {@link #load(String filePath , String format , boolean inFolder)}
	 * unless you are developing for android, in which case, you should use
	 * {@link #load(int id)}
	 */
	/* The default constructor */
	public Image() {
		
	}
	
	/**
	 * The constructor which will load the image automatically.
	 * This constructor should only be used when loading an image on
	 * a PC
	 * @param filePath This is a string representing the path to the
	 *                 image file, this includes its extension
	 * @param format   This is a string representing the  format of the
	 *                 image file e.g. PNG
	 * @param inFolder This is a boolean value that states whether the
	 *                 image file is in a folder. If it is false, it will
	 *                 be assumed to be inside a .jar, or in the same path
	 *                 as the main class
	 * @see load(String filePath , String format , boolean inFolder)
	 */
	/* The constructor with the file path and format specified */
	public Image(String filePath , String format , boolean inFolder) {
		//Load the image
		load(filePath , format , inFolder);
	}
	
	/**
	 * The constructor which will load the image automatically.
	 * This constructor should on be used when loading an image on Android
	 * @param id      This is an integer value that is used to locate the
	 *                image on Android. e.g. R.drawable.myimage
	 * @see load(int id)
	 */
	/* The constructor for android */
	public Image(int id) {
		//Load the image
		load(id);
	}
	
	/** This method is used to load an image on a PC.
	 * 
	 * @param filePath This is a string representing the path to the
	 *                 image file, this includes its extension
	 * @param format   This is a string representing the  format of the
	 *                 image file e.g. PNG
	 * @param inFolder This is a boolean value that states whether the
	 *                 image file is in a folder. If it is false, it will
	 *                 be assumed to be inside a .jar, or in the same path
	 *                 as the main class
	 */
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
	
	/**
	 * This method is used to load an image on Android.
	 * 
	 * @param id      This is an integer value that is used to locate the
	 *                image on Android. e.g. R.drawable.myimage
	 */
	/* The method to load an image for android */
	public void load(int id) {
		//Set the image
		this.androidImage = BitmapFactory.decodeResource(AndroidStore.gameResources , id);
	}
	
	/**
	 * This method is used to turn a string into a URL, it is used when
	 * loading an image.
	 * 
	 * @param filePath This is a string representing the path to the
	 *                 image file, this includes its extension
	 * @return This method return a URL, created using the String
	 */
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
	
	/**
	 * The method used to get an InputStream using a certain file path
	 * @param filePath This is a string that is used to create the
	 *                 InputStream
	 * @return         The input stream created using the file path
	 */
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
	
	/**
	 * Returns the Java Image
	 * @return Image
	 */
	/* Returns the Java image */
	public java.awt.Image getJavaImage() {
		//Return the image
		return this.javaImage;
	}
	
	/**
	 * Returns the OpenGL image (Texture)
	 * @return Texture
	 */
	/* Returns the OpenGL image */
	public Texture getOpenGLImage() {
		//Return the image
		return this.openGLImage;
	}
	
	/**
	 * Returns the Android image (Bitmap)
	 * @return Bitmap
	 */
	/* Returns the android image */
	public Bitmap getAndroidImage() {
		//Return the image
		return this.androidImage;
	}
	
	/**
	 * Checks what image should have been created then returns the
	 * width of that image
	 * @return Integer representing the width of the image
	 */
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
	
	/**
	 * Checks what image should have been created then returns the
	 * height of that image
	 * @return Integer representing the height of the image
	 */
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