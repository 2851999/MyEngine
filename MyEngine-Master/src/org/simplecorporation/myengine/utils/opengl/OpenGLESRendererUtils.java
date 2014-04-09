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

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

import android.opengl.GLUtils;

public class OpenGLESRendererUtils {
	
	/* The static method used to render something using OpenGL ES (GL10) 
	 * verticesArray = each vertex defined in a float array
	 * texturesArray = the texture coordinates to use
	 * orderArray = the draw order e.g. 0, 1, 2, 3
	 * colour = the colour to render each vertex
	 * texture = the image instance to use
	 * renderMode = the render mode to use e.g. GL_LINES */
	public static void render(float[] verticesArray, float[] texturesArray, short[] orderArray, Colour colour, Image texture, int dimensions, int renderMode) {
		//Get an instance of GL10 from the AndroidStore
		GL10 gl = AndroidStore.gl10;
		//Create the vertices buffer
		FloatBuffer vertices = createBuffer(verticesArray);
		//Create the colour buffer for each vertex
		FloatBuffer colourToUse = getColour(colour, verticesArray.length / dimensions);
		//Create the buffer for the texture coordinates
		FloatBuffer textures = createBuffer(texturesArray);
		//Create the buffer for the order
		ShortBuffer order = createBuffer(orderArray);
		
		//Enable 2D textures
		gl.glEnable(GL10.GL_TEXTURE_2D);
		
		//Bind the image
		int textureId = bindTexture(gl, texture);
		
		//Tell OpenGL where the texture is
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);
		
		//Tell OpenGL ES to render the points clockwise
		gl.glFrontFace(GL10.GL_CW);
		
		//Enable the array needed to render
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		
		//Setup the vertex pointer
		gl.glVertexPointer(dimensions, GL10.GL_FLOAT, 0, vertices);
		
		//Setup the texture pointer
		gl.glTexCoordPointer(dimensions, GL10.GL_FLOAT, 0, textures);
		
		//Setup the colour pointer
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, colourToUse);
		
		//Draw the elements
		gl.glDrawElements(renderMode, verticesArray.length / dimensions, GL10.GL_UNSIGNED_SHORT, order);
		
		//Disable the things used to render
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		
		//Disable 2D textures
		gl.glDisable(GL10.GL_TEXTURE_2D);
		
		gl.glDeleteTextures(1, new int[] { textureId }, 0);
	}
	
	/* The static method used to render something using OpenGL ES (GL10) 
	 * verticesArray = each vertex defined in a float array
	 * orderArray = the draw order e.g. 0, 1, 2, 3
	 * colour = the colour to render each vertex
	 * renderMode = the render mode to use e.g. GL_LINES */
	public static void render(float[] verticesArray, short[] orderArray, Colour colour, int dimensions, int renderMode) {
		//Get an instance of GL10 from the AndroidStore
		GL10 gl = AndroidStore.gl10;
		//Create the vertices buffer
		FloatBuffer vertices = createBuffer(verticesArray);
		//Create the colour buffer for each vertex
		FloatBuffer colourToUse = getColour(colour, verticesArray.length / dimensions);
		//Create the buffer for the order
		ShortBuffer order = createBuffer(orderArray);
		
		//Tell OpenGL ES to render the points clockwise
		gl.glFrontFace(GL10.GL_CW);
		
		//Enable the array needed to render
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		
		//Setup the vertex pointer
		gl.glVertexPointer(dimensions, GL10.GL_FLOAT, 0, vertices);
		
		//Setup the colour pointer
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, colourToUse);
		
		//Draw the elements
		gl.glDrawElements(renderMode, verticesArray.length / dimensions, GL10.GL_UNSIGNED_SHORT, order);
		
		//Disable the things used to render
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
	
	/* The static method used to bind an image given the image and return the id of that image */
	public static int bindTexture(GL10 gl, Image image) {
		//Set the id to -1
		int id = -1;
		
		//Create the array to store the texture pointer
		int[] texturePointers = new int[1];
		//Generate the texture
		//1 = number of textures
		//0 = offset (Starting index in the array)
		gl.glGenTextures(1, texturePointers, 0);
		//Assign the id
		id = texturePointers[0];
		
		//Bind the texture pointer (id) to the array
		gl.glBindTexture(GL10.GL_TEXTURE_2D, id);
		
		//NOTE: Future, add video setting to change render quality
		//GL_LINEAR = blurred, better performance
		//GL_NEAREST = crisper, slower performance
		
		//Setup the parameters
		//MAG = Magnification
		//MIN = Minification (Opposite of MAG)
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
		
		//Bind the bitmap to the texture id
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, image.getAndroidImage(), 0);
		
		//Return the id of the image
		return id;
	}
	
	/* The static method used to create a FloatBuffer given the array */
	public static FloatBuffer createBuffer(float[] values) {
		//Create the ByteBuffer (4 Bytes in float)
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(values.length * Float.SIZE);
		//Setup the order
		byteBuffer.order(ByteOrder.nativeOrder());
		//Create the float buffer
		FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
		//Add all of the value to the float buffer
		floatBuffer.put(values);
		//Set the first position to read from for the first element
		floatBuffer.position(0);
		//Return the float buffer
		return floatBuffer;
	}
	
	/* The static method used to create a ShortBuffer given the array */
	public static ShortBuffer createBuffer(short[] values) {
		//Create the ByteBuffer (2 Bytes in short)
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(values.length * Short.SIZE);
		//Setup the order
		byteBuffer.order(ByteOrder.nativeOrder());
		//Create the short buffer
		ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
		//Add all of the value to the short buffer
		shortBuffer.put(values);
		//Set the first position to read from for the first element
		shortBuffer.position(0);
		//Return the short buffer
		return shortBuffer;
	}
	
	/* The static method used to get the current colour as a float buffer
	 * colour = colour to use
	 * times = number of colours to create (Typically 1 for each vertex */
	public static FloatBuffer getColour(Colour colour, int times) {
		//Create the values for each vertices (4 values for each colour)
		float[] values = new float[times * 4];
		//Create the counter and assign it to 0
		int i = 0;
		//Keep going as long as the counter is less than the values array's length
		while (i < values.length) {
			//Assign the first value, red
			values[i] = (float) colour.r;
			//Assign the second value, green
			values[i + 1] = (float) colour.g;
			//Assign the third value, blue
			values[i + 2] = (float) colour.b;
			//Assign the fourth value, alpha
			values[i + 3] = (float) colour.a;
			//There are 4 values in each colour so add on 4 to the counter
			i += 4;
		}
		//Return the colour as a FloatBuffer
		return createBuffer(values);
	}
	
}