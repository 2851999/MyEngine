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

import org.lwjgl.BufferUtils;

public class OpenGLBufferUtils {
	
	/* The method to create an flip a float buffer with 4 values */
	public static FloatBuffer createFlipBuffer4f(float v1 , float v2 , float v3 , float v4) {
		//The float buffer
		FloatBuffer buffer = BufferUtils.createFloatBuffer(4);
		//Put the values into the buffer
		buffer.put(new float[] { v1 , v2 , v3 , v4 });
		//Flip the buffer
		buffer.flip();
		//Return the buffer
		return buffer;
	}
	
}