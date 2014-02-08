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

import static org.lwjgl.opengl.GL11.*;

import org.simplecorporation.myengine.core.game3d.vector.Vector3D;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class BasicRenderer3DOpenGL {
	
	/* The method used to render a rectangle using the top right and bottom
	 * left co-ordinates given as 3D Vectors */
	public static void renderRectangle(Vector3D tl, Vector3D br) {
		//Render the rectangle in the 3D world
		glBegin(GL_LINES);
		glVertex3d(tl.x, tl.y, tl.z);
		glVertex3d(br.x, tl.y, tl.z + ((br.z - tl.z) / 2));
		glVertex3d(br.x, br.y, br.z);
		glVertex3d(tl.x, br.y, tl.z + ((br.z - tl.z) / 2));
		glVertex3d(tl.x, tl.y, tl.z);
		glEnd();
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
		//Render the filled rectangle in the 3D world
		glBegin(GL_QUADS);
		glVertex3d(tl.x, tl.y, tl.z);
		glVertex3d(br.x, tl.y, tl.z + ((br.z - tl.z) / 2));
		glVertex3d(br.x, br.y, br.z);
		glVertex3d(tl.x, br.y, tl.z + ((br.z - tl.z) / 2));
		glVertex3d(tl.x, tl.y, tl.z);
		glEnd();
	}
	
	/* The method used to render a filled rectangle using the position vector,
	 * width and height */
	public static void renderFilledRectangle(Vector3D position, double width, double height) {
		//Render the rectangle in the 3D world
		renderFilledRectangle(position, new Vector3D(position.x + width, position.y + height, position.z));
	}
	
	/* The method used to render a 3D cube given its position, width, height and depth */
	public static void renderCube(Vector3D position, double width, double height, double depth) {
		//Render the 3D cube
		glBegin(GL_LINES);
		
		renderCubeTop(position, width, height, depth);
		renderCubeBottom(position, width, height, depth);
		renderCubeFront(position, width, height, depth);
		renderCubeBack(position, width, height, depth);
		renderCubeLeft(position, width, height, depth);
		renderCubeRight(position, width, height, depth);
		
		glEnd();
	}
	
	/* The method used to render a filled 3D cube given its position, width, height and depth */
	public static void renderFilledCube(Vector3D position, double width, double height, double depth) {
		//Render the 3D cube
		glBegin(GL_QUADS);
		
		renderCubeTop(position, width, height, depth);
		renderCubeBottom(position, width, height, depth);
		renderCubeFront(position, width, height, depth);
		renderCubeBack(position, width, height, depth);
		renderCubeLeft(position, width, height, depth);
		renderCubeRight(position, width, height, depth);
		
		glEnd();
	}
	
	/* The method used to render a filled 3D cube given its position, width, height, depth and colours */
	public static void renderFilledCube(Vector3D position, double width, double height, double depth, Colour[] colours) {
		//Render the 3D cube
		glBegin(GL_QUADS);
		
		BasicRenderer.setColour(colours[0]);
		renderCubeTop(position, width, height, depth);
		BasicRenderer.setColour(colours[1]);
		renderCubeBottom(position, width, height, depth);
		BasicRenderer.setColour(colours[2]);
		renderCubeFront(position, width, height, depth);
		BasicRenderer.setColour(colours[3]);
		renderCubeBack(position, width, height, depth);
		BasicRenderer.setColour(colours[4]);
		renderCubeLeft(position, width, height, depth);
		BasicRenderer.setColour(colours[5]);		
		renderCubeRight(position, width, height, depth);
		
		glEnd();
	}
	
	/* The method used to render a textured 3D cube given its texture, position, width, height and depth */
	public static void renderTexturedCube(Image image, Vector3D position, double width, double height, double depth) {
		//Render the 3D cube
		image.getOpenGLImage().bind();
		glBegin(GL_QUADS);
		
		renderTexturedCubeTop(position, width, height, depth);
		renderTexturedCubeBottom(position, width, height, depth);
		renderTexturedCubeFront(position, width, height, depth);
		renderTexturedCubeBack(position, width, height, depth);
		renderTexturedCubeLeft(position, width, height, depth);
		renderTexturedCubeRight(position, width, height, depth);
		
		glEnd();
	}
	
	/* The method used to render a textured 3D cube given its textures, position, width, height and depth */
	public static void renderTexturedCube(Image[] images, Vector3D position, double width, double height, double depth) {
		//Render the 3D cube
		glBegin(GL_QUADS);
		
		images[0].getOpenGLImage().bind();
		renderTexturedCubeTop(position, width, height, depth);
		images[1].getOpenGLImage().bind();
		renderTexturedCubeBottom(position, width, height, depth);
		images[2].getOpenGLImage().bind();
		renderTexturedCubeFront(position, width, height, depth);
		images[3].getOpenGLImage().bind();
		renderTexturedCubeBack(position, width, height, depth);
		images[4].getOpenGLImage().bind();
		renderTexturedCubeLeft(position, width, height, depth);
		images[5].getOpenGLImage().bind();
		renderTexturedCubeRight(position, width, height, depth);
		
		glEnd();
	}
	
	/* The method used to render a side of a cube */
	private static void renderCubeTop(Vector3D position, double width, double height, double depth) {
		glVertex3d(position.x, position.y + height, position.z);
		glVertex3d(position.x + width, position.y + height, position.z);
		glVertex3d(position.x + width, position.y + height, position.z + depth);
		glVertex3d(position.x, position.y + height, position.z + depth);
	}
	
	/* The method used to render a side of a cube */
	private static void renderCubeBottom(Vector3D position, double width, double height, double depth) {
		glVertex3d(position.x, position.y, position.z);
		glVertex3d(position.x + width, position.y, position.z);
		glVertex3d(position.x + width, position.y, position.z + depth);
		glVertex3d(position.x, position.y, position.z + depth);
	}
	
	/* The method used to render a side of a cube */
	private static void renderCubeFront(Vector3D position, double width, double height, double depth) {
		glVertex3d(position.x, position.y, position.z + depth);
		glVertex3d(position.x + width, position.y, position.z + depth);
		glVertex3d(position.x + width, position.y + height, position.z + depth);
		glVertex3d(position.x, position.y + height, position.z + depth);
	}
	
	/* The method used to render a side of a cube */
	private static void renderCubeBack(Vector3D position, double width, double height, double depth) {
		glVertex3d(position.x, position.y, position.z);
		glVertex3d(position.x + width, position.y, position.z);
		glVertex3d(position.x + width, position.y + height, position.z);
		glVertex3d(position.x, position.y + height, position.z);
	}
	
	/* The method used to render a side of a cube */
	private static void renderCubeLeft(Vector3D position, double width, double height, double depth) {
		glVertex3d(position.x, position.y, position.z);
		glVertex3d(position.x, position.y + height, position.z);
		glVertex3d(position.x, position.y + height, position.z + depth);
		glVertex3d(position.x, position.y, position.z + depth);
	}
	
	/* The method used to render a side of a cube */
	private static void renderCubeRight(Vector3D position, double width, double height, double depth) {
		glVertex3d(position.x + width, position.y, position.z);
		glVertex3d(position.x + width, position.y + height, position.z);
		glVertex3d(position.x + width, position.y + height, position.z + depth);
		glVertex3d(position.x + width, position.y, position.z + depth);
	}
	
	/* The method used to render a side of a cube */
	private static void renderTexturedCubeTop(Vector3D position, double width, double height, double depth) {
		glTexCoord2d(0, 0);
		glVertex3d(position.x, position.y + height, position.z);
		glTexCoord2d(1, 0);
		glVertex3d(position.x + width, position.y + height, position.z);
		glTexCoord2d(1, 1);
		glVertex3d(position.x + width, position.y + height, position.z + depth);
		glTexCoord2d(0, 1);
		glVertex3d(position.x, position.y + height, position.z + depth);
	}
	
	/* The method used to render a side of a cube */
	private static void renderTexturedCubeBottom(Vector3D position, double width, double height, double depth) {
		glTexCoord2d(0, 0);
		glVertex3d(position.x, position.y, position.z);
		glTexCoord2d(1, 0);
		glVertex3d(position.x + width, position.y, position.z);
		glTexCoord2d(1, 1);
		glVertex3d(position.x + width, position.y, position.z + depth);
		glTexCoord2d(0, 1);
		glVertex3d(position.x, position.y, position.z + depth);
	}
	
	/* The method used to render a side of a cube */
	private static void renderTexturedCubeFront(Vector3D position, double width, double height, double depth) {
		glTexCoord2d(0, 1);
		glVertex3d(position.x, position.y, position.z + depth);
		glTexCoord2d(1, 1);
		glVertex3d(position.x + width, position.y, position.z + depth);
		glTexCoord2d(1, 0);
		glVertex3d(position.x + width, position.y + height, position.z + depth);
		glTexCoord2d(0, 0);
		glVertex3d(position.x, position.y + height, position.z + depth);
	}
	
	/* The method used to render a side of a cube */
	private static void renderTexturedCubeBack(Vector3D position, double width, double height, double depth) {
		glTexCoord2d(0, 1);
		glVertex3d(position.x, position.y, position.z);
		glTexCoord2d(1, 1);
		glVertex3d(position.x + width, position.y, position.z);
		glTexCoord2d(1, 0);
		glVertex3d(position.x + width, position.y + height, position.z);
		glTexCoord2d(0, 0);
		glVertex3d(position.x, position.y + height, position.z);
	}
	
	/* The method used to render a side of a cube */
	private static void renderTexturedCubeLeft(Vector3D position, double width, double height, double depth) {
		glTexCoord2d(1, 1);
		glVertex3d(position.x, position.y, position.z);
		glTexCoord2d(1, 0);
		glVertex3d(position.x, position.y + height, position.z);
		glTexCoord2d(0, 0);
		glVertex3d(position.x, position.y + height, position.z + depth);
		glTexCoord2d(0, 1);
		glVertex3d(position.x, position.y, position.z + depth);		glTexCoord2d(0, 0);
	}
	
	/* The method used to render a side of a cube */
	private static void renderTexturedCubeRight(Vector3D position, double width, double height, double depth) {
		glTexCoord2d(1, 1);
		glVertex3d(position.x + width, position.y, position.z);
		glTexCoord2d(1, 0);
		glVertex3d(position.x + width, position.y + height, position.z);
		glTexCoord2d(0, 0);
		glVertex3d(position.x + width, position.y + height, position.z + depth);
		glTexCoord2d(0, 1);
		glVertex3d(position.x + width, position.y, position.z + depth);
	}
	
	/* The method used to render an image using the top right and bottom
	 * left co-ordinates given as 3D Vectors */
	public static void renderImage(Image image, Vector3D tl, Vector3D br) {
		//Bind the image
		image.getOpenGLImage().bind();
		//Render the image in the 3D world
		//Use opposite texture co-ordinates
		glBegin(GL_QUADS);
		glTexCoord2d(1, 1);
		glVertex3d(tl.x, tl.y, tl.z);
		glTexCoord2d(0, 1);
		glVertex3d(br.x, tl.y, tl.z + ((br.z - tl.z) / 2));
		glTexCoord2d(0, 0);
		glVertex3d(br.x, br.y, br.z);
		glTexCoord2d(1, 0);
		glVertex3d(tl.x, br.y, tl.z + ((br.z - tl.z) / 2));
		glVertex3d(tl.x, tl.y, tl.z);
		glEnd();
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
	
}