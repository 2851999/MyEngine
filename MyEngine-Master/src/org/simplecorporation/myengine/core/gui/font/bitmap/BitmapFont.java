/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.font.bitmap;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.settings.Settings;


public class BitmapFont {
	
	/* The image */
	public Image image;
	
	/* The font size */
	public double fontSize;
	
	/* The number of cells on the width */
	public double gridWidth;
	
	/* The number of cells on the height */
	public double gridHeight;
	
	/* The width of a cell */
	public double cellWidth;
	
	/* The height of a cell */
	public double cellHeight;
	
	/* The constructor of the font */
	public BitmapFont(Image image , double fontSize) {
		//Load the font image
		this.image = image;
		
		//Set the size
		this.fontSize = fontSize;
	}
	
	/* The method that renders the font */
	public void render(String text , double x , double y) {
		//Enable blending if using OpenGL
		if (! Settings.Android && Settings.Video.OpenGL) {
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA , GL11.GL_ONE_MINUS_SRC_ALPHA);
		}
		//Loop though the text
		for (int a = 0; a < text.length(); a++) {
			//Get the ASCII code of the character
			int asciiCode = (int) text.charAt(a);
			//Calculate the cell's size and set it
			this.cellWidth = this.image.getWidth() / this.gridWidth;
			this.cellHeight = this.image.getHeight() / this.gridHeight;
			
			//Calculate the cell's x position
			double cellX = ((int) asciiCode % this.gridWidth) * this.cellWidth; //8, 4.5
			//Calculate the cell's y position
			double cellY = (Math.floor((int) asciiCode / this.gridHeight)) * this.cellHeight;
			
			//Render the current letter
			BasicRenderer.renderImage(this.image , x , y , (this.cellWidth / this.cellHeight) * this.fontSize , this.fontSize , cellX , cellY , cellWidth , cellHeight);
			
			x += ((this.cellWidth / this.cellHeight) * this.fontSize) / 1.5;
		}
	}
	
	/* The method to get the width of a string */
	public double getWidth(String text) {
		//The width of the text
		double width = 0;
		return width;
	}
	
	/* The method to get the height of a string */
	public double getHeight(String text) {
		//The height of the text
		double height = 0;
		return height;
	}
	
}