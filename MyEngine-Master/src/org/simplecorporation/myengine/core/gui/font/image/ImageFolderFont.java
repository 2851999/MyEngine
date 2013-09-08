/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.font.image;

import java.util.LinkedList;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.file.FileUtils;


public class ImageFolderFont {
	
	/* The font */
	public LinkedList<ImageLetter> letters;
	
	/* The font size */
	public double size;
	
	/* The constructor of the font */
	public ImageFolderFont(String folder , String imageFormat , boolean inFolder , double size) {
		//Load the font
		
		//Create the letters linked list
		this.letters = new LinkedList<ImageLetter>();
		
		//The file text
		LinkedList<String> fileText = FileUtils.read(folder + "/font.txt");
		
		//Load all of the images in the font
		for (int a = 0; a < fileText.size(); a++) {
			//Split the current line
			String[] split = fileText.get(a).split(" ");
			//Create the letter
			ImageLetter letter = new ImageLetter(split[0].charAt(0) , folder + "/" + split[1] , imageFormat , inFolder);
			//Add the letter to the letters
			this.letters.add(letter);
		}
		
		//Set the size
		this.size = size;
	}
	
	/* The method that renders the font */
	public void render(String text , double x , double y) {
		//Enable blending
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA , GL11.GL_ONE_MINUS_SRC_ALPHA);
		//Loop though the text
		for (int a = 0; a < text.length(); a++) {
			//Check if the current letter is a space
			if (text.charAt(a) == ' ') {
				x += this.size / 2;
			} else {
				//Set the colour, get the letter and render the letter image
				BasicRenderer.setColour(Colour.WHITE);
				ImageLetter letter = this.getLetter(text.charAt(a));
				//The width and height
				double width = 0;
				double height = 0;
				//Check the size
				if ((letter.getWidth() / letter.getHeight()) == 1) {
					width = size * (letter.getWidth() / letter.getHeight() * 1.5);
					height = size * (letter.getWidth() / letter.getHeight());
				} else {
					width = size * (letter.getHeight() / letter.getWidth());
					height = size * (letter.getHeight() / letter.getWidth());
				}
				BasicRenderer.renderImage(letter , x , y ,  width , height);
				//Add to the x position
				x += width / 2;
			}
		}
	}
	
	/* The method to get the width of a string */
	public double getWidth(String text) {
		//The width of the text
		double width = 0;
		//Loop though the text
		for (int a = 0; a < text.length(); a++) {
			//Get the letter
			ImageLetter letter = this.getLetter(text.charAt(a));
			//Add to the width
			width += size * (letter.getHeight() / letter.getWidth()) + 4;
		}
		//Return the width
		return width;
	}
	
	/* The method to get the height of a string */
	public double getHeight(String text) {
		//The height of the text
		double height = 0;
		//Loop though the text
		for (int a = 0; a < text.length(); a++) {
			//Get the letter
			ImageLetter letter = this.getLetter(text.charAt(a));
			//Check if the letters size is bigger
			if (letter.getWidth() * (letter.getHeight() / size) > height)
				height = letter.getWidth() * (letter.getHeight() / size);
		}
		//Return the height
		return height;
	}
	
	/* The method that returns a letter based on a char */
	public ImageLetter getLetter(char character) {
		//The letter
		ImageLetter letter = this.letters.get(0);
		
		//Loop though the letters
		for (int a = 0; a < this.letters.size(); a ++) {
			//Check if the current letter is the right one
			if (this.letters.get(a).character == character) {
				//Set the letter
				letter = this.letters.get(a);
				//Exit the loop
				break;
			}
		}
		
		//Return the letter
		return letter;
	}
	
}