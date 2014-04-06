/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class OpenGLUtils {
	
	/* The method to clear the colour buffer */
	public static void clearColourBuffer() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}
	
	/* The method used to clear the depth buffer */
	public static void clearDepthBuffer() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
	}
	
	/* The method used to enable texture 2D */
	public static void enableTexture2D() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	
	/* The method used to disabled texture 2D */
	public static void disableTexture2D() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			GL11.glDisable(GL11.GL_TEXTURE_2D);
	}
	
	/* The method used to enable wire frame mode */
	public static void enableWireframeMode() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
	}
	
	/* The method used to disable wire frame mode */
	public static void disableWireframeMode() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
	}
	
	/* The method used to create an integer buffer for
	 * OpenGL using a float array */
	public static IntBuffer getIntegerBuffer(int[] data) {
		//Create the float buffer
		IntBuffer integerBuffer = BufferUtils.createIntBuffer(data.length);
		//Give the integer buffer the data
		integerBuffer.put(data);
		//Retrun the integer buffer
		return integerBuffer;
	}
	
	/* The method used to create a float buffer for OpenGL
	 * using a float array */
	public static FloatBuffer getFloatBuffer(float[] data) {
		//Create the float buffer
		FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(data.length);
		//Give the float buffer the data
		floatBuffer.put(data);
		//Return the float buffer
		return floatBuffer;
	}
	
	/* The method used to create a flipped integer buffer for
	 * OpenGL using an integer array */
	public static IntBuffer getFlippedIntegerBuffer(int[] data) {
		//Create the integer buffer
		IntBuffer integerBuffer = getIntegerBuffer(data);
		//Flip the buffer
		integerBuffer.flip();
		//Return the integer buffer
		return integerBuffer;
	}
	
	/* The method used to create a flipped float buffer for
	 * OpenGL using a float array */
	public static FloatBuffer getFlippedFloatBuffer(float[] data) {
		//Create the float buffer
		FloatBuffer floatBuffer = getFloatBuffer(data);
		//Flip the buffer
		floatBuffer.flip();
		//Return the float buffer
		return floatBuffer;
	}
	
	/* The method used to create a flipped float buffer for
	 * OpenGL using a colour */
	public static FloatBuffer getFlippedFloatBuffer(Colour colour) {
		//The float buffer
		FloatBuffer floatBuffer = null;
		//Create the float buffer
		floatBuffer = getFlippedFloatBuffer(colour.getFloatValues());
		//Return the float buffer
		return floatBuffer;
	}
	
	/* The method to get the OpenGL version */
	public static String getVersion() {
		//Make sure OpenGL is enabled
		if (! Settings.Android && Settings.Video.OpenGL)
			return GL11.glGetString(GL11.GL_VERSION);
		else
			return "";
	}
	
}