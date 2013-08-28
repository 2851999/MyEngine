/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.builder;

import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.gui.textbox.GUIImageTextBox;
import org.simplecorporation.myengine.core.gui.textbox.GUIRenderableTextBox;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUITextBoxBuilder {
	
	/* The method to create a renderable text box given its
	   name, background colour, outline colour, font, x and y position,
	   width and height */
	public static GUIRenderableTextBox createRenderableTextBox(String name , Colour backgroundColour ,
			Colour outlineColour , GUIFont font , double x , double y , double width , double height) {
		
		//Create the text box
		GUIRenderableTextBox textBox = new GUIRenderableTextBox(name , backgroundColour , outlineColour , font);
		
		//Set the variables in the text box
		textBox.getBase().position.x = x;
		textBox.getBase().position.y = y;
		textBox.getBase().width = width;
		textBox.getBase().height = height;
		
		//Return the text box
		return textBox;
	}
	
	/* The method to create a renderable text box given its
	   name, background colour, outline colour, font, mask character, x and y position,
	   width and height */
	public static GUIRenderableTextBox createRenderableTextBox(String name , Colour backgroundColour ,
			Colour outlineColour , GUIFont font , char maskCharacter , double x , double y , double width , double height) {
		
		//Create the text box
		GUIRenderableTextBox textBox = new GUIRenderableTextBox(name , backgroundColour , outlineColour , font);
		
		//Set the variables in the text box
		textBox.getBase().maskCharacter = maskCharacter;
		textBox.getBase().hideCharacters = true;
		textBox.getBase().position.x = x;
		textBox.getBase().position.y = y;
		textBox.getBase().width = width;
		textBox.getBase().height = height;
		
		//Return the text box
		return textBox;
	}
	
	/* The method to create an image text box given its
	   name, image, font, x and y position,
	   width and height */
	public static GUIImageTextBox createImageTextBox(String name , Image image ,
			GUIFont font , double x , double y , double width , double height) {
		
		//Create the text box
		GUIImageTextBox textBox = new GUIImageTextBox(name , image , font);
		
		//Set the variables in the text box
		textBox.getBase().position.x = x;
		textBox.getBase().position.y = y;
		textBox.getBase().width = width;
		textBox.getBase().height = height;
		
		//Return the text box
		return textBox;
	}
	
	/* The method to create an image text box given its
	   name, image, font, mask character, x and y position,
	   width and height */
	public static GUIImageTextBox createImageTextBox(String name , Image image ,
			GUIFont font , char maskCharacter , double x , double y , double width , double height) {
		
		//Create the text box
		GUIImageTextBox textBox = new GUIImageTextBox(name , image , font);
		
		//Set the variables in the text box
		textBox.getBase().maskCharacter = maskCharacter;
		textBox.getBase().hideCharacters = true;
		textBox.getBase().position.x = x;
		textBox.getBase().position.y = y;
		textBox.getBase().width = width;
		textBox.getBase().height = height;
		
		//Return the text box
		return textBox;
	}
	
}