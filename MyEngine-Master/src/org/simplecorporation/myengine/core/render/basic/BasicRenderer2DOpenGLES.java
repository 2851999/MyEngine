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

import javax.microedition.khronos.opengles.GL10;

import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.opengl.OpenGLESRendererUtils;

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
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) x, (float) y,
				(float) x + (float) width, (float) y,
				(float) x + (float) width, (float) y,
				(float) x + (float) width, (float) y + (float) height,
				(float) x + (float) width, (float) y + (float) height,
				(float) x, (float) y + (float) height,
				(float) x, (float) y + (float) height,
				(float) x, (float) y
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, currentColour, 2, GL10.GL_LINES);
	}

	/* The method to render a filled rectangle */
	public static void renderFilledRectangle(double x , double y , double width , double height) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) x, (float) y,
				(float) x + (float) width, (float) y,
				(float) x + (float) width, (float) y,
				(float) x + (float) width, (float) y + (float) height,
				(float) x + (float) width, (float) y + (float) height,
				(float) x, (float) y + (float) height,
				(float) x, (float) y + (float) height,
				(float) x, (float) y
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, currentColour, 2, GL10.GL_TRIANGLE_FAN);
	}

	/* The method to render a line */
	public static void renderLine(double startx , double starty , double endx , double endy) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) startx, (float) starty,
				(float) endx, (float) endy
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, currentColour, 2, GL10.GL_LINES);
	}

	/* The method to render an image */
	public static void renderImage(Image image , double x , double y) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) x, (float) y,
				(float) x + (float) image.getWidth(), (float) y,
				(float) x + (float) image.getWidth(), (float) y,
				(float) x + (float) image.getWidth(), (float) y + (float) image.getHeight(),
				(float) x + (float) image.getWidth(), (float) y + (float) image.getHeight(),
				(float) x, (float) y + (float) image.getHeight(),
				(float) x, (float) y + (float) image.getHeight(),
				(float) x, (float) y
		};
		//Get the float array for the texture coordinates
		float[] textures = new float[] {
				0, 0,
				1f, 0f,
				1f, 0f,
				1f, 1f,
				1f, 1f,
				0f, 1f,
				0f, 1f,
				0f, 0f
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, textures, order, currentColour, image, 2, GL10.GL_TRIANGLE_FAN);
	}
	
	/* The method to render an image with a rotation */
	public static void renderImage(Image image , double x , double y , double rotation) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) x, (float) y,
				(float) x + (float) image.getWidth(), (float) y,
				(float) x + (float) image.getWidth(), (float) y,
				(float) x + (float) image.getWidth(), (float) y + (float) image.getHeight(),
				(float) x + (float) image.getWidth(), (float) y + (float) image.getHeight(),
				(float) x, (float) y + (float) image.getHeight(),
				(float) x, (float) y + (float) image.getHeight(),
				(float) x, (float) y
		};
		//Get the float array for the texture coordinates
		float[] textures = new float[] {
				0, 0,
				1f, 0f,
				1f, 0f,
				1f, 1f,
				1f, 1f,
				0f, 1f,
				0f, 1f,
				0f, 0f
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		
		//Rotate the image
		AndroidStore.gl10.glPushMatrix();
		AndroidStore.gl10.glTranslatef((float) (x + image.getWidth() / 2) , (float) (y + image.getHeight() / 2) , 0f);
		AndroidStore.gl10.glRotatef((float)rotation , 0f , 0f , 1f);
		AndroidStore.gl10.glTranslatef((float) -(x + image.getWidth() / 2) , (float) -(y + image.getHeight() / 2) , 0f);
		//Render the shape
		OpenGLESRendererUtils.render(vertices, textures, order, currentColour, image, 2, GL10.GL_TRIANGLE_FAN);
		
		AndroidStore.gl10.glPopMatrix();
	}
	
	/* The method to render an image with a specified width and height */
	public static void renderImage(Image image , double x , double y , double width , double height) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) x, (float) y,
				(float) x + (float) width, (float) y,
				(float) x + (float) width, (float) y,
				(float) x + (float) width, (float) y + (float) height,
				(float) x + (float) width, (float) y + (float) height,
				(float) x, (float) y + (float) height,
				(float) x, (float) y + (float) height,
				(float) x, (float) y
		};
		//Get the float array for the texture coordinates
		float[] textures = new float[] {
				0, 0,
				1f, 0f,
				1f, 0f,
				1f, 1f,
				1f, 1f,
				0f, 1f,
				0f, 1f,
				0f, 0f
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, textures, order, currentColour, image, 2, GL10.GL_TRIANGLE_FAN);
	}
	
	/* The method to render an image with a specified width, height and rotation */
	public static void renderImage(Image image , double x , double y , double width , double height , double rotation) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) x, (float) y,
				(float) x + (float) width, (float) y,
				(float) x + (float) width, (float) y,
				(float) x + (float) width, (float) y + (float) height,
				(float) x + (float) width, (float) y + (float) height,
				(float) x, (float) y + (float) height,
				(float) x, (float) y + (float) height,
				(float) x, (float) y
		};
		//Get the float array for the texture coordinates
		float[] textures = new float[] {
				0, 0,
				1f, 0f,
				1f, 0f,
				1f, 1f,
				1f, 1f,
				0f, 1f,
				0f, 1f,
				0f, 0f
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		
		//Rotate the image
		AndroidStore.gl10.glPushMatrix();
		AndroidStore.gl10.glTranslatef((float) (x + width / 2) , (float) (y + height / 2) , 0f);
		AndroidStore.gl10.glRotatef((float)rotation , 0f , 0f , 1f);
		AndroidStore.gl10.glTranslatef((float) -(x + width / 2) , (float) -(y + height / 2) , 0f);
		
		//Render the shape
		OpenGLESRendererUtils.render(vertices, textures, order, currentColour, image, 2, GL10.GL_TRIANGLE_FAN);
		
		AndroidStore.gl10.glPopMatrix();
	}
	
	/* The method to render an image with a specified x, y, width, height, imageX, imageY, imageWidth, imageHeight */
	public static void renderImage(Image image , double x , double y , double width , double height , double imageX , double imageY ,
			double imageWidth , double imageHeight) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) x, (float) y,
				(float) x + (float) width, (float) y,
				(float) x + (float) width, (float) y,
				(float) x + (float) width, (float) y + (float) height,
				(float) x + (float) width, (float) y + (float) height,
				(float) x, (float) y + (float) height,
				(float) x, (float) y + (float) height,
				(float) x, (float) y
		};
		//Get the float array for the texture coordinates
		float[] textures = new float[] {
				(float) imageX / (float)image.getWidth(), (float) imageY / (float)image.getHeight(),
				((float)imageX / (float)image.getWidth()) + (1.0f / ((float) image.getWidth() / (float) imageWidth)), (float) imageY / (float)image.getHeight(), //HERE
				((float)imageX / (float)image.getWidth()) + (1.0f / ((float) image.getWidth() / (float) imageWidth)), (float) imageY / (float)image.getHeight(),
				((float)imageX / (float)image.getWidth()) + (1.0f / ((float) image.getWidth() / (float) imageWidth)), ((float) imageY / (float) image.getHeight()) + ((float) 1.0 / ((float) image.getHeight() / (float) imageHeight)),
				((float)imageX / (float)image.getWidth()) + (1.0f / ((float) image.getWidth() / (float) imageWidth)), ((float) imageY / (float) image.getHeight()) + ((float) 1.0 / ((float) image.getHeight() / (float) imageHeight)),
				(float) imageX / (float)image.getWidth(), ((float) imageY / (float) image.getHeight()) + ((float) 1.0 / ((float) image.getHeight() / (float) imageHeight)), //HERE
				(float) imageX / (float)image.getWidth(), ((float) imageY / (float) image.getHeight()) + ((float) 1.0 / ((float) image.getHeight() / (float) imageHeight)),
				(float) imageX / (float)image.getWidth(), (float) imageY / (float)image.getHeight()
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, textures, order, currentColour, image, 2, GL10.GL_TRIANGLE_FAN);
	}
	
}