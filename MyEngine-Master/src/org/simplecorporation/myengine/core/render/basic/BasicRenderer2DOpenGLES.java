/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.render.basic;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class BasicRenderer2DOpenGLES {
	
	/* The current colour set to its default value (White) */
	private static Colour currentColour = new Colour(1.0, 1.0, 1.0, 1.0);

	/* The method to set the colour */
	public static void setColour(Colour colour) {
		//Assign the current colour
		currentColour = colour;
	}

	/* The method to render an unfilled rectangle */
	public static void renderRectangle(double x , double y , double width , double height) {
		//Get the instance of GL10
		GL10 gl = AndroidStore.gl10;
		//Get the float buffer for the vertices
		FloatBuffer vertices = createBuffer(new float[] {
				(float) x, (float) y,
				(float) x + (float) width, (float) y,
				(float) x + (float) width, (float) y,
				(float) x + (float) width, (float) y + (float) height,
				(float) x + (float) width, (float) y + (float) height,
				(float) x, (float) y + (float) height,
				(float) x, (float) y + (float) height,
				(float) x, (float) y
		});
		//Get the float buffer for the colour
		FloatBuffer colour = getColour(8);
		//Get the short buffer for the order
		ShortBuffer order = createBuffer(new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		});
		//Tell OpenGLES to render the points clockwise
		gl.glFrontFace(GL10.GL_CW);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		
		//2 = Dimensions
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertices);
		
		//Use the colour 4 = Number of values (rgba)
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, colour);
		
		//Draw the elements 4 = Number of points
		gl.glDrawElements(GL10.GL_LINES, 8, GL10.GL_UNSIGNED_SHORT, order);
		
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}

	/* The method to render a filled rectangle */
	public static void renderFilledRectangle(double x , double y , double width , double height) {
		
	}

	/* The method to render a line */
	public static void renderLine(double startx , double starty , double endx , double endy) {
		
	}

	/* The method to render an image */
	public static void renderImage(Image image , double x , double y) {
		
	}
	
	/* The method to render an image with a rotation */
	public static void renderImage(Image image , double x , double y , double rotation) {
		
	}
	
	/* The method to render an image with a specified width and height */
	public static void renderImage(Image image , double x , double y , double width , double height) {
		
	}
	
	/* The method to render an image with a specified width, height and rotation */
	public static void renderImage(Image image , double x , double y , double width , double height , double rotation) {
		
	}
	
	/* The method to render an image with a specified x, y, width, height, imageX, imageY, imageWidth, imageHeight */
	public static void renderImage(Image image , double x , double y , double width , double height , double imageX , double imageY ,
			double imageWidth , double imageHeight) {
		
	}
	
	/* The method used to create a FloatBuffer given the array */
	private static FloatBuffer createBuffer(float[] values) {
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
	
	/* The method used to create a ShortBuffer given the array */
	private static ShortBuffer createBuffer(short[] values) {
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
	
	/* The method used to get the current colour as a float buffer */
	private static FloatBuffer getColour(int times) {
		//Create the values for each vertices (4 values for each colour)
		float[] values = new float[times * 4];
		//Create the counter and assign it to 0
		int i = 0;
		//Keep going as long as the counter is less than the values array's length
		while (i < values.length) {
			//Assign the first value, red
			values[i] = (float) currentColour.r;
			//Assign the second value, green
			values[i + 1] = (float) currentColour.g;
			//Assign the third value, blue
			values[i + 2] = (float) currentColour.b;
			//Assign the fourth value, alpha
			values[i + 3] = (float) currentColour.a;
			//There are 4 values in each colour so add on 4 to the counter
			i += 4;
		}
		//Return the colour as a FloatBuffer
		return createBuffer(values);
	}
	
}