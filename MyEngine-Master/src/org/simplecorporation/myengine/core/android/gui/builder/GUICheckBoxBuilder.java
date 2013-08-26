/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android.gui.builder;

import org.simplecorporation.myengine.core.android.gui.checkbox.GUIImageCheckBox;
import org.simplecorporation.myengine.core.android.gui.checkbox.GUIRenderableCheckBox;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUICheckBoxBuilder {
	
	/* The method to create a renderable check box button
	   given the name, check box colour, check colour, x and y position,
	   width and height */
	public static GUIRenderableCheckBox createRenderableCheckBox(String name ,
			Colour checkBoxColour , Colour checkColour , double x , double y , double width , double height) {
		
		//Create the check box
		GUIRenderableCheckBox checkBox = new GUIRenderableCheckBox(name);
		
		//Set the variables of the check box
		checkBox.checkBoxColour = checkBoxColour;
		checkBox.checkColour = checkColour;
		checkBox.position.x = x;
		checkBox.position.y = y;
		checkBox.width = width;
		checkBox.height = height;
		
		//Return the check box
		return checkBox;
	}
	
	/* The method to create a renderable check box button
	   given the name, check box colour, check colour, check width, check height, x and y position,
	   width and height */
	public static GUIRenderableCheckBox createRenderableCheckBox(String name ,
			Colour checkBoxColour , Colour checkColour , double checkWidth , double checkHeight , double x , double y ,
			double width , double height) {
		
		//Create the check box
		GUIRenderableCheckBox checkBox = new GUIRenderableCheckBox(name);
		
		//Set the variables of the check box
		checkBox.checkBoxColour = checkBoxColour;
		checkBox.checkColour = checkColour;
		checkBox.checkWidth = checkWidth;
		checkBox.checkHeight = checkHeight;
		checkBox.position.x = x;
		checkBox.position.y = y;
		checkBox.width = width;
		checkBox.height = height;
		
		//Return the check box
		return checkBox;
	}
	
	/* The method to create an image check box button
	   given the name, images, x and y position,
	   width and height */
	public static GUIImageCheckBox createImageCheckBox(String name ,
			Image[] images , double x , double y , double width , double height) {
		
		//Create the check box
		GUIImageCheckBox checkBox = new GUIImageCheckBox(name , images);
		
		//Set the variables of the check box
		checkBox.position.x = x;
		checkBox.position.y = y;
		checkBox.width = width;
		checkBox.height = height;
		
		//Return the check box
		return checkBox;
	}
	
	/* The method to create an image check box button
	   given the name, image path, number of images, x and y position,
	   width and height */
	public static GUIImageCheckBox createImageCheckBox(String name ,
			String imagePath , int numberOfImages , double x , double y , double width , double height) {
		
		//The images
		Image[] images = new Image[numberOfImages];
		
		//Load all the images
		for (int a = 0; a < images.length; a++) {
			//Load the current image
			images[a] = new Image(imagePath + (a + 1) + ".png" , "PNG" , true);
		}
		
		//Create the check box
		GUIImageCheckBox checkBox = new GUIImageCheckBox(name , images);
		
		//Set the variables of the check box
		checkBox.position.x = x;
		checkBox.position.y = y;
		checkBox.width = width;
		checkBox.height = height;
		
		//Return the check box
		return checkBox;
	}
	
}