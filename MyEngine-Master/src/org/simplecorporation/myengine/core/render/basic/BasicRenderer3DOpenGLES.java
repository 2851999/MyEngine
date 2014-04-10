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

import org.simplecorporation.myengine.core.game3d.vector.Vector3D;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.opengl.OpenGLESRendererUtils;

public class BasicRenderer3DOpenGLES {
	
	/* The method used to render a rectangle using the top right and bottom
	 * left co-ordinates given as 3D Vectors */
	public static void renderRectangle(Vector3D tl, Vector3D br) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) tl.x, (float) tl.y, (float) tl.z,
				(float) br.x, (float) tl.y, (float) (tl.z + ((br.z - tl.z) / 2)),
				(float) br.x, (float) tl.y, (float) (tl.z + ((br.z - tl.z) / 2)),
				(float) br.x, (float) br.y, (float) br.z,
				(float) br.x, (float) br.y, (float) br.z,
				(float) tl.x, (float) br.y, (float) (tl.z + ((br.z - tl.z) / 2)),
				(float) tl.x, (float) br.y, (float) (tl.z + ((br.z - tl.z) / 2)),
				(float) tl.x, (float) tl.y, (float) tl.z
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, BasicRenderer.currentColour, 3, GL10.GL_LINES);
	}
	
	/* The method used to render a rectangle using the position vector, width and
	 * height */
	public static void renderRectangle(Vector3D position, double width, double height) {
		//Render the rectangle in the 3D world
		renderRectangle(position, new Vector3D(position.x + width, position.y + height, position.z));
	}
	
	/* The method used to render a filled rectangle using the top right and bottom
	 * left co-ordinates given as 3D Vectors */
	public static void renderFilledRectangle(Vector3D tl, Vector3D br) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) tl.x, (float) tl.y, (float) tl.z,
				(float) br.x, (float) tl.y, (float) (tl.z + ((br.z - tl.z) / 2)),
				(float) br.x, (float) tl.y, (float) (tl.z + ((br.z - tl.z) / 2)),
				(float) br.x, (float) br.y, (float) br.z,
				(float) br.x, (float) br.y, (float) br.z,
				(float) tl.x, (float) br.y, (float) (tl.z + ((br.z - tl.z) / 2)),
				(float) tl.x, (float) br.y, (float) (tl.z + ((br.z - tl.z) / 2)),
				(float) tl.x, (float) tl.y, (float) tl.z
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, BasicRenderer.currentColour, 3, GL10.GL_TRIANGLE_FAN);
	}
	
	/* The method used to render a filled rectangle using the position vector,
	 * width and height */
	public static void renderFilledRectangle(Vector3D position, double width, double height) {
		//Render the rectangle in the 3D world
		renderFilledRectangle(position, new Vector3D(position.x + width, position.y + height, position.z));
	}
	
	/* The method used to render a 3D cube given its position, width, height and depth */
	public static void renderCube(Vector3D position, double width, double height, double depth) {
		renderCubeTop(position, width, height, depth, GL10.GL_LINES);
		renderCubeBottom(position, width, height, depth, GL10.GL_LINES);
		renderCubeFront(position, width, height, depth, GL10.GL_LINES);
		renderCubeBack(position, width, height, depth, GL10.GL_LINES);
		renderCubeLeft(position, width, height, depth, GL10.GL_LINES);
		renderCubeRight(position, width, height, depth, GL10.GL_LINES);
	}
	
	/* The method used to render a filled 3D cube given its position, width, height and depth */
	public static void renderFilledCube(Vector3D position, double width, double height, double depth) {
		renderCubeTop(position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderCubeBottom(position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderCubeFront(position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderCubeBack(position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderCubeLeft(position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderCubeRight(position, width, height, depth, GL10.GL_TRIANGLE_FAN);
	}
	
	/* The method used to render a filled 3D cube given its position, width, height, depth and colours */
	public static void renderFilledCube(Vector3D position, double width, double height, double depth, Colour[] colours) {
		BasicRenderer.setColour(colours[0]);
		renderCubeTop(position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		BasicRenderer.setColour(colours[1]);
		renderCubeBottom(position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		BasicRenderer.setColour(colours[2]);
		renderCubeFront(position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		BasicRenderer.setColour(colours[3]);
		renderCubeBack(position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		BasicRenderer.setColour(colours[4]);
		renderCubeLeft(position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		BasicRenderer.setColour(colours[5]);		
		renderCubeRight(position, width, height, depth, GL10.GL_TRIANGLE_FAN);
	}
	
	/* The method used to render a textured 3D cube given its texture, position, width, height and depth */
	public static void renderTexturedCube(Image image, Vector3D position, double width, double height, double depth) {
		renderTexturedCubeTop(image, position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderTexturedCubeBottom(image, position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderTexturedCubeFront(image, position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderTexturedCubeBack(image, position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderTexturedCubeLeft(image, position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderTexturedCubeRight(image, position, width, height, depth, GL10.GL_TRIANGLE_FAN);
	}
	
	/* The method used to render a textured 3D cube given its textures, position, width, height and depth */
	public static void renderTexturedCube(Image[] images, Vector3D position, double width, double height, double depth) {
		renderTexturedCubeTop(images[0], position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderTexturedCubeBottom(images[1], position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderTexturedCubeFront(images[2], position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderTexturedCubeBack(images[3], position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderTexturedCubeLeft(images[4], position, width, height, depth, GL10.GL_TRIANGLE_FAN);
		renderTexturedCubeRight(images[5], position, width, height, depth, GL10.GL_TRIANGLE_FAN);
	}
	
	/* The method used to render a side of a cube */
	private static void renderCubeTop(Vector3D position, double width, double height, double depth, int mode) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) position.x, (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) (position.y + height),(float) (position.z + depth),
				(float) (position.x + width), (float) (position.y + height),(float) (position.z + depth),
				(float) position.x, (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) (position.y + height), (float) position.z
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, BasicRenderer.currentColour, 3, mode);
	}
	
	/* The method used to render a side of a cube */
	private static void renderCubeBottom(Vector3D position, double width, double height, double depth, int mode) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) position.x, (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) position.y, (float) position.z,
				(float) (position.x + width), (float) position.y, (float) position.z,
				(float) (position.x + width), (float) position.y, (float) (position.z + depth),
				(float) (position.x + width), (float) position.y, (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) position.z
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, BasicRenderer.currentColour, 3, mode);
	}
	
	/* The method used to render a side of a cube */
	private static void renderCubeFront(Vector3D position, double width, double height, double depth, int mode) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) position.x, (float) position.y, (float) (position.z + depth),
				(float) (position.x + width), (float) position.y, (float) (position.z + depth),
				(float) (position.x + width), (float) position.y, (float) (position.z + depth),
				(float) (position.x + width), (float) (position.y + height), (float) (position.z + depth),
				(float) (position.x + width), (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) (position.z + depth),
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, BasicRenderer.currentColour, 3, mode);
	}
	
	/* The method used to render a side of a cube */
	private static void renderCubeBack(Vector3D position, double width, double height, double depth, int mode) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) position.x, (float) position.y, (float) position.z,
				(float) (position.x + width), (float) position.y, (float) position.z,
				(float) (position.x + width), (float) position.y, (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) position.z,
				(float) position.x, (float) (position.y + height), (float) position.z,
				(float) position.x, (float) (position.y + height), (float) position.z,
				(float) position.x, (float) position.y, (float) position.z,
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, BasicRenderer.currentColour, 3, mode);
	}
	
	/* The method used to render a side of a cube */
	private static void renderCubeLeft(Vector3D position, double width, double height, double depth, int mode) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) position.x, (float) position.y, (float) position.z,
				(float) position.x, (float) (position.y + height), (float) position.z,
				(float) position.x, (float) (position.y + height), (float) position.z,
				(float) position.x, (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) position.z,
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, BasicRenderer.currentColour, 3, mode);
	}
	
	/* The method used to render a side of a cube */
	private static void renderCubeRight(Vector3D position, double width, double height, double depth, int mode) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) (position.x + width), (float) position.y, (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) (position.z + depth),
				(float) (position.x + width), (float) (position.y + height), (float) (position.z + depth),
				(float) (position.x + width), (float) position.y, (float) (position.z + depth),
				(float) (position.x + width), (float) position.y, (float) (position.z + depth),
				(float) (position.x + width), (float) position.y, (float) position.z,
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, BasicRenderer.currentColour, 3, mode);
	}
	
	/* The method used to render a side of a cube */
	private static void renderTexturedCubeTop(Image texture, Vector3D position, double width, double height, double depth, int mode) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) position.x, (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) (position.y + height),(float) (position.z + depth),
				(float) (position.x + width), (float) (position.y + height),(float) (position.z + depth),
				(float) position.x, (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) (position.y + height), (float) position.z
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
		OpenGLESRendererUtils.render(vertices, textures, order, BasicRenderer.currentColour, texture, 3, mode);
	}
	
	/* The method used to render a side of a cube */
	private static void renderTexturedCubeBottom(Image texture, Vector3D position, double width, double height, double depth, int mode) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) position.x, (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) position.y, (float) position.z,
				(float) (position.x + width), (float) position.y, (float) position.z,
				(float) (position.x + width), (float) position.y, (float) (position.z + depth),
				(float) (position.x + width), (float) position.y, (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) position.z
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
		OpenGLESRendererUtils.render(vertices, textures, order, BasicRenderer.currentColour, texture, 3, mode);
	}
	
	/* The method used to render a side of a cube */
	private static void renderTexturedCubeFront(Image texture, Vector3D position, double width, double height, double depth, int mode) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) position.x, (float) position.y, (float) (position.z + depth),
				(float) (position.x + width), (float) position.y, (float) (position.z + depth),
				(float) (position.x + width), (float) position.y, (float) (position.z + depth),
				(float) (position.x + width), (float) (position.y + height), (float) (position.z + depth),
				(float) (position.x + width), (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) (position.z + depth),
		};
		//Get the float array for the texture coordinates
		float[] textures = new float[] {
				0f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 0f,
				1f, 0f,
				0f, 0f,
				0f, 0f,
				0f, 1f
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, textures, order, BasicRenderer.currentColour, texture, 3, mode);
	}
	
	/* The method used to render a side of a cube */
	private static void renderTexturedCubeBack(Image texture, Vector3D position, double width, double height, double depth, int mode) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) position.x, (float) position.y, (float) position.z,
				(float) (position.x + width), (float) position.y, (float) position.z,
				(float) (position.x + width), (float) position.y, (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) position.z,
				(float) position.x, (float) (position.y + height), (float) position.z,
				(float) position.x, (float) (position.y + height), (float) position.z,
				(float) position.x, (float) position.y, (float) position.z,
		};
		//Get the float array for the texture coordinates
		float[] textures = new float[] {
				0f, 1f,
				1f, 1f,
				1f, 1f,
				1f, 0f,
				1f, 0f,
				0f, 0f,
				0f, 0f,
				0f, 1f
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, textures, order, BasicRenderer.currentColour, texture, 3, mode);
	}
	
	/* The method used to render a side of a cube */
	private static void renderTexturedCubeLeft(Image texture, Vector3D position, double width, double height, double depth, int mode) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) position.x, (float) position.y, (float) position.z,
				(float) position.x, (float) (position.y + height), (float) position.z,
				(float) position.x, (float) (position.y + height), (float) position.z,
				(float) position.x, (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) (position.y + height), (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) (position.z + depth),
				(float) position.x, (float) position.y, (float) position.z,
		};
		//Get the float array for the texture coordinates
		float[] textures = new float[] {
				1f, 1f,
				1f, 0f,
				1f, 0f,
				0f, 0f,
				0f, 0f,
				0f, 1f,
				0f, 1f,
				1f, 1f
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, textures, order, BasicRenderer.currentColour, texture, 3, mode);
	}
	
	/* The method used to render a side of a cube */
	private static void renderTexturedCubeRight(Image texture, Vector3D position, double width, double height, double depth, int mode) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) (position.x + width), (float) position.y, (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) position.z,
				(float) (position.x + width), (float) (position.y + height), (float) (position.z + depth),
				(float) (position.x + width), (float) (position.y + height), (float) (position.z + depth),
				(float) (position.x + width), (float) position.y, (float) (position.z + depth),
				(float) (position.x + width), (float) position.y, (float) (position.z + depth),
				(float) (position.x + width), (float) position.y, (float) position.z,
		};
		//Get the float array for the texture coordinates
		float[] textures = new float[] {
				1f, 1f,
				1f, 0f,
				1f, 0f,
				0f, 0f,
				0f, 0f,
				0f, 1f,
				0f, 1f,
				1f, 1f
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, textures, order, BasicRenderer.currentColour, texture, 3, mode);
	}
	
	/* The method used to render an image using the top right and bottom
	 * left co-ordinates given as 3D Vectors */
	public static void renderImage(Image image, Vector3D tl, Vector3D br) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) tl.x, (float) tl.y, (float) tl.z,
				(float) br.x, (float) tl.y, (float) (tl.z + ((br.z - tl.z) / 2)),
				(float) br.x, (float) tl.y, (float) (tl.z + ((br.z - tl.z) / 2)),
				(float) br.x, (float) br.y, (float) br.z,
				(float) br.x, (float) br.y, (float) br.z,
				(float) tl.x, (float) br.y, (float) (tl.z + ((br.z - tl.z) / 2)),
				(float) tl.x, (float) br.y, (float) (tl.z + ((br.z - tl.z) / 2)),
				(float) tl.x, (float) tl.y, (float) tl.z,
		};
		//Get the float array for the texture coordinates
		float[] textures = new float[] {
				1f, 1f,
				0f, 1f,
				0f, 1f,
				0f, 0f,
				0f, 0f,
				1f, 0f,
				1f, 0f,
				1f, 1f
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, textures, order, BasicRenderer.currentColour, image, 3, GL10.GL_TRIANGLE_FAN);
	}
	
	/* The method used to render an image using the position vector, width and
	 * height */
	public static void renderImage(Image image, Vector3D position, double width, double height) {
		//Render the image in the 3D world
		renderImage(image, position, new Vector3D(position.x + width, position.y + height, position.z));
	}
	
	/* The method used to render an image using the position vector */
	public static void renderImage(Image image, Vector3D position) {
		//Render the image in the 3D world
		renderImage(image, position, new Vector3D(position.x + image.getWidth(), position.y + image.getHeight(), position.z));
	}
	
	/* The method used to render a triangle using its 3 vertices */
	public static void renderTriangle(Vector3D v1, Vector3D v2, Vector3D v3) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) v1.x, (float) v1.y, (float) v1.z,
				(float) v2.x, (float) v2.y, (float) v2.z,
				(float) v2.x, (float) v2.y, (float) v2.z,
				(float) v3.x, (float) v3.y, (float) v3.z,
				(float) v3.x, (float) v3.y, (float) v3.z,
				(float) v1.x, (float) v1.y, (float) v1.z
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2, 3, 4, 5, 6
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, BasicRenderer.currentColour, 3, GL10.GL_LINES);
	}
	
	/* The method used to render a filled triangle using its 3 vertices */
	public static void renderFilledTriangle(Vector3D v1, Vector3D v2, Vector3D v3) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) v1.x, (float) v1.y, (float) v1.z,
				(float) v2.x, (float) v2.y, (float) v2.z,
				(float) v3.x, (float) v3.y, (float) v3.z,
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, order, BasicRenderer.currentColour, 3, GL10.GL_TRIANGLES);
	}
	
	/* The method used to render a filled triangle using its 3 vertices */
	public static void renderTexturedTriangle(Image image, Vector3D v1, Vector3D v2, Vector3D v3) {
		//Get the float array for the vertices
		float[] vertices = new float[] {
				(float) v1.x, (float) v1.y, (float) v1.z,
				(float) v2.x, (float) v2.y, (float) v2.z,
				(float) v3.x, (float) v3.y, (float) v3.z,
		};
		//Get the float array for the texture coordinates
		float[] textures = new float[] {
				0f, 0f,
				0f, 1f,
				1f, 1f
		};
		//Get the short array for the order
		short[] order = new short[] {
				0, 1, 2
		};
		//Render the shape
		OpenGLESRendererUtils.render(vertices, textures, order, BasicRenderer.currentColour, image, 3, GL10.GL_TRIANGLES);
	}
	
}