/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.builder;

import org.simplecorporation.myengine.core.gui.button.GUIImageButton;
import org.simplecorporation.myengine.core.gui.button.GUIRenderableButton;
import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.font.FontUtils;

public class GUIButtonBuilder {
	
	/* The method to create an image button given
	   its name, text, images, position, width and height */
	public static GUIImageButton createImageButton(String name , String text , Image[] images ,
			double x , double y , double width , double height) {
		
		//Create the button
		GUIImageButton button = new GUIImageButton(name , text , images ,
				FontUtils.buildGUIFont("Arial" , Colour.WHITE , 30f));
		
		//Set the position, width and height
		button.position.x = x;
		button.position.y = y;
		button.width = width;
		button.height = height;
		
		//Return the button
		return button;
	}
	
	/* The method to create an image button given
	   its name, text, image path, number of images, position, width and height */
	public static GUIImageButton createImageButton(String name , String text , String imagePath ,
			int numberOfImages , double x , double y , double width , double height) {
		
		//The images
		Image[] images = new Image[numberOfImages];
		
		//Load all the images
		for (int a = 0; a < images.length; a++) {
			//Load the current image
			images[a] = new Image(imagePath + (a + 1) + ".png" , "PNG" , true);
		}
		
		//Create the button
		GUIImageButton button = new GUIImageButton(name , text , images ,
				FontUtils.buildGUIFont("Arial" , Colour.WHITE , 30f));
		
		//Set the position, width and height
		button.position.x = x;
		button.position.y = y;
		button.width = width;
		button.height = height;
		
		//Return the button
		return button;
	}
	
	/* The method to create an image button given
	   its name, text, images, font, position, width and height */
	public static GUIImageButton createImageButton(String name , String text , Image[] images , GUIFont font ,
			double x , double y , double width , double height) {
		
		//Create the button
		GUIImageButton button = new GUIImageButton(name , text , images ,
				font);
		
		//Set the position, width and height
		button.position.x = x;
		button.position.y = y;
		button.width = width;
		button.height = height;
		
		//Return the button
		return button;
	}
	
	/* The method to create an image button given
	   its name, text, image path, number of images, font, position, width and height */
	public static GUIImageButton createImageButton(String name , String text , String imagePath , GUIFont font ,
			int numberOfImages , double x , double y , double width , double height) {
		
		//The images
		Image[] images = new Image[numberOfImages];
		
		//Load all the images
		for (int a = 0; a < images.length; a++) {
			//Load the current image
			images[a] = new Image(imagePath + (a + 1) + ".png" , "PNG" , true);
		}
		
		//Create the button
		GUIImageButton button = new GUIImageButton(name , text , images ,
				font);
		
		//Set the position, width and height
		button.position.x = x;
		button.position.y = y;
		button.width = width;
		button.height = height;
		
		//Return the button
		return button;
	}
	
	/* The method to create a renderable button given
	   its name, text, images, font, position, width and height */
	public static GUIRenderableButton createRenderableButton(String name , String text , Colour[] colours , GUIFont font ,
			double x , double y , double width , double height) {
		
		//Create the button
		GUIRenderableButton button = new GUIRenderableButton(name , text , colours ,
				font);
		
		//Set the position, width and height
		button.position.x = x;
		button.position.y = y;
		button.width = width;
		button.height = height;
		
		//Return the button
		return button;
	}
	
}