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

import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.game3d.vector.Vector3D;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class BasicRenderer3D {
	
	/* The method used to render a rectangle using the top right and bottom
	 * left co-ordinates given as 3D Vectors */
	public static void renderRectangle(Vector3D tl, Vector3D br) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderRectangle(tl, br);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderRectangle(tl, br);
	}
	
	/* The method used to render a rectangle using the position vector, width and
	 * height */
	public static void renderRectangle(Vector3D position, double width, double height) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderRectangle(position, width, height);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderRectangle(position, width, height);
	}
	
	/* The method used to render a filled rectangle using the top right and bottom
	 * left co-ordinates given as 3D Vectors */
	public static void renderFilledRectangle(Vector3D tl, Vector3D br) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderFilledRectangle(tl, br);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderFilledRectangle(tl, br);
	}
	
	/* The method used to render a filled rectangle using the position vector,
	 * width and height */
	public static void renderFilledRectangle(Vector3D position, double width, double height) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderFilledRectangle(position, width, height);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderFilledRectangle(position, width, height);
	}
	
	/* The method used to render a 3D cube given its position, width, height and depth */
	public static void renderCube(Vector3D position, double width, double height, double depth) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderCube(position, width, height, depth);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderCube(position, width, height, depth);
	}
	
	/* The method used to render a filled 3D cube given its position, width, height and depth */
	public static void renderFilledCube(Vector3D position, double width, double height, double depth) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderFilledCube(position, width, height, depth);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderFilledCube(position, width, height, depth);
	}
	
	/* The method used to render a filled 3D cube given its position, width, height, depth and colours */
	public static void renderFilledCube(Vector3D position, double width, double height, double depth, Colour[] colours) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderFilledCube(position, width, height, depth, colours);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderFilledCube(position, width, height, depth, colours);
	}
	
	/* The method used to render a textured 3D cube given its texture, position, width, height and depth */
	public static void renderTexturedCube(Image image, Vector3D position, double width, double height, double depth) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderTexturedCube(image, position, width, height, depth);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderTexturedCube(image, position, width, height, depth);
	}
	
	/* The method used to render a textured 3D cube given its textures, position, width, height and depth */
	public static void renderTexturedCube(Image[] images, Vector3D position, double width, double height, double depth) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderTexturedCube(images, position, width, height, depth);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderTexturedCube(images, position, width, height, depth);
	}
	
	/* The method used to render an image using the top right and bottom
	 * left co-ordinates given as 3D Vectors */
	public static void renderImage(Image image, Vector3D tl, Vector3D br) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderImage(image, tl, br);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderImage(image, tl, br);
	}
	
	/* The method used to render an image using the position vector, width and
	 * height */
	public static void renderImage(Image image, Vector3D position, double width, double height) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderImage(image, position, width, height);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderImage(image, position, width, height);
	}
	
	/* The method used to render an image using the position vector */
	public static void renderImage(Image image, Vector3D position) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderImage(image, position);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderImage(image, position);
	}
	
	/* The method used to render a triangle using its 3 vertices */
	public static void renderTriangle(Vector3D v1, Vector3D v2, Vector3D v3) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderTriangle(v1, v2, v3);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderTriangle(v1, v2, v3);
	}
	
	/* The method used to render a filled triangle using its 3 vertices */
	public static void renderFilledTriangle(Vector3D v1, Vector3D v2, Vector3D v3) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderFilledTriangle(v1, v2, v3);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderFilledTriangle(v1, v2, v3);
	}
	
	/* The method used to render a filled triangle using its 3 vertices */
	public static void renderTexturedTriangle(Image image, Vector3D v1, Vector3D v2, Vector3D v3) {
		//Check the settings
		if (! Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGL.renderTexturedTriangle(image, v1, v2, v3);
		else if (Settings.Android && Settings.Video.OpenGL)
			BasicRenderer3DOpenGLES.renderTexturedTriangle(image, v1, v2, v3);
	}
	
}