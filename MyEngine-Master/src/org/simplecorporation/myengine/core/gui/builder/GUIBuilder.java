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

import org.simplecorporation.myengine.core.gui.GUIButton;
import org.simplecorporation.myengine.core.gui.GUICheckBox;
import org.simplecorporation.myengine.core.gui.GUILoadingBar;
import org.simplecorporation.myengine.core.gui.GUIScrollBar;
import org.simplecorporation.myengine.core.gui.GUISlider;
import org.simplecorporation.myengine.core.gui.GUITextBox;
import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIBuilder {
	
	/* The method to create an image button given
	   its name, text, images, position, width and height */
	public static GUIButton createButton(String name , String text , Image[] images ,
			double x , double y , double width , double height) {
		return GUIButtonBuilder.createButton(name, text, images, x, y, width, height);
	}
	
	/* The method to create an image button given
	   its name, text, image path, number of images, position, width and height */
	public static GUIButton createButton(String name , String text , String imagePath ,
			int numberOfImages , double x , double y , double width , double height) {
		return GUIButtonBuilder.createButton(name, text, imagePath, numberOfImages, x, y, width, height);
	}
	
	/* The method to create an image button given
	   its name, text, images, font, position, width and height */
	public static GUIButton createButton(String name , String text , Image[] images , GUIFont font ,
			double x , double y , double width , double height) {
		return GUIButtonBuilder.createButton(name, text, images, font, x, y, width, height);
	}
	
	/* The method to create an image button given
	   its name, text, image path, number of images, font, position, width and height */
	public static GUIButton createButton(String name , String text , String imagePath , GUIFont font ,
			int numberOfImages , double x , double y , double width , double height) {
		return GUIButtonBuilder.createButton(name, text, imagePath, font, numberOfImages, x, y, width, height);
	}
	
	/* The method to create a renderable button given
	   its name, text, images, font, position, width and height */
	public static GUIButton createButton(String name , String text , Colour[] colours , GUIFont font ,
			double x , double y , double width , double height) {
		return GUIButtonBuilder.createButton(name, text, colours, font, x, y, width, height);
	}
	
	/* The method to create a renderable check box button
	   given the name, check box colour, check colour, x and y position,
	   width and height */
	public static GUICheckBox createCheckBox(String name ,
			Colour checkBoxColour , Colour checkColour , double x , double y , double width , double height) {
		return GUICheckBoxBuilder.createCheckBox(name, checkBoxColour, checkColour, x, y, width, height);
	}
	
	/* The method to create a renderable check box button
	   given the name, check box colour, check colour, check width, check height, x and y position,
	   width and height */
	public static GUICheckBox createCheckBox(String name ,
			Colour checkBoxColour , Colour checkColour , double checkWidth , double checkHeight , double x , double y ,
			double width , double height) {
		return GUICheckBoxBuilder.createCheckBox(name, checkBoxColour, checkColour, checkWidth, checkHeight, x, y, width, height);
	}
	
	/* The method to create an image check box button
	   given the name, images, x and y position,
	   width and height */
	public static GUICheckBox createCheckBox(String name ,
			Image[] images , double x , double y , double width , double height) {
		return GUICheckBoxBuilder.createCheckBox(name, images, x, y, width, height);
	}
	
	/* The method to create an image check box button
	   given the name, image path, number of images, x and y position,
	   width and height */
	public static GUICheckBox createCheckBox(String name ,
			String imagePath , int numberOfImages , double x , double y , double width , double height) {
		return GUICheckBoxBuilder.createCheckBox(name, imagePath, numberOfImages, x, y, width, height);
	}
	
	/* The method to create a renderable loading bar given
	   its name, background colour, bar colour, loading stages, x and y position,
	   width and height */
	public static GUILoadingBar createLoadingBar(String name , Colour backgroundColour ,
			Colour barColour , int loadingStages , double x , double y , double width , double height) {
		return GUILoadingBarBuilder.createLoadingBar(name, backgroundColour, barColour, loadingStages, x, y, width, height);
	}
	
	/* The method to create an image loading bar given
	   its name, background image , bar image , loading stages, x and y position,
	   width and height */
	public static GUILoadingBar createLoadingBar(String name , Image backgroundImage ,
			Image barImage , int loadingStages , double x , double y , double width , double height) {
		return GUILoadingBarBuilder.createLoadingBar(name, backgroundImage, barImage, loadingStages, x, y, width, height);
	}
	
	/* The method to create an image loading bar given
	   its name, image path , loading stages, x and y position,
	   width and height */
	public static GUILoadingBar createLoadingBar(String name , String imagePath ,
			int loadingStages , double x , double y , double width , double height) {
		return GUILoadingBarBuilder.createLoadingBar(name, imagePath, loadingStages, x, y, width, height);
	}
	
	/* The method to create a renderable text box given its
	   name, background colour, outline colour, font, x and y position,
	   width and height */
	public static GUITextBox createTextBox(String name , Colour backgroundColour ,
			Colour outlineColour , GUIFont font , double x , double y , double width , double height) {
		return GUITextBoxBuilder.createTextBox(name, backgroundColour, outlineColour, font, x, y, width, height);
	}
	
	/* The method to create a renderable text box given its
	   name, background colour, outline colour, font, mask character, x and y position,
	   width and height */
	public static GUITextBox createTextBox(String name , Colour backgroundColour ,
			Colour outlineColour , GUIFont font , String maskCharacter , double x , double y , double width , double height) {
		return GUITextBoxBuilder.createTextBox(name, backgroundColour, outlineColour, font, maskCharacter, x, y, width, height);
	}
	
	/* The method to create an image text box given its
	   name, image, font, x and y position,
	   width and height */
	public static GUITextBox createTextBox(String name , Image image ,
			GUIFont font , double x , double y , double width , double height) {
		return GUITextBoxBuilder.createTextBox(name, image, font, x, y, width, height);
	}
	
	/* The method to create an image text box given its
	   name, image, font, mask character, x and y position,
	   width and height */
	public static GUITextBox createTextBox(String name , Image image ,
			GUIFont font , String maskCharacter , double x , double y , double width , double height) {
		return GUITextBoxBuilder.createTextBox(name, image, font, maskCharacter, x, y, width, height);
	}
	
	/* The method to create an image slider given
	   its name, slider image, slider button, slider direction, position, width and height */
	public static GUISlider createSlider(String name , Image sliderImage , GUIButton sliderButton ,
			int sliderDirection , double x , double y , double width , double height) {
		return GUISliderBuilder.createSlider(name, sliderImage, sliderButton, sliderDirection, x, y, width, height);
	}
	
	/* The method to create an image slider given
	   its name, slider image, slider button, slider direction, slider button width
	   slider button height , position, width and height */
	public static GUISlider createSlider(String name , Image sliderImage , GUIButton sliderButton ,
			int sliderDirection , double buttonWidth , double buttonHeight , double x , double y , double width , double height) {
		return GUISliderBuilder.createSlider(name, sliderImage, sliderButton, sliderDirection, buttonWidth, buttonHeight, x, y, width, height);
	}
	
	/* The method to create a renderable slider given
	   its name, slider colour, slider button, slider direction, position, width and height */
	public static GUISlider createSlider(String name , Colour sliderColour , GUIButton sliderButton ,
			int sliderDirection , double x , double y , double width , double height) {
		return GUISliderBuilder.createSlider(name, sliderColour, sliderButton, sliderDirection, x, y, width, height);
	}
	
	/* The method to create a renderable slider given
	   its name, slider colour, slider button, slider direction, slider button width
	   slider button height , position, width and height */
	public static GUISlider createRendeableSlider(String name , Colour sliderColour , GUIButton sliderButton ,
			int sliderDirection , double buttonWidth , double buttonHeight , double x , double y , double width , double height) {
		return GUISliderBuilder.createSlider(name, sliderColour, sliderButton, sliderDirection, buttonWidth, buttonHeight, x, y, width, height);
	}
	
	/* The method to create an image scroll bar given
	   its name, scroll bar image, scroll bar button, scroll bar direction, scroll amount , position, width and height */
	public static GUIScrollBar createScrollBar(String name , Image scrollBarImage , GUIButton scrollBarButton ,
			int scrollBarDirection , double scrollAmount , double x , double y , double width , double height) {
		return GUIScrollBarBuilder.createScrollBar(name, scrollBarImage, scrollBarButton, scrollBarDirection, scrollAmount, x, y, width, height);
	}
	
	/* The method to create an image scroll bar given
	   its name, slider image, slider button, slider direction, scroll amount , slider button width
	   slider button height , position, width and height */
	public static GUIScrollBar createScrollBar(String name , Image scrollBarImage , GUIButton scrollBarButton ,
			int scrollBarDirection , double scrollAmount , double buttonWidth , double buttonHeight , double x , double y , double width , double height) {
		return GUIScrollBarBuilder.createScrollBar(name, scrollBarImage, scrollBarButton, scrollBarDirection, scrollAmount, buttonWidth, buttonHeight, x, y, width, height);
	}
	
	/* The method to create a renderable scroll bar given
	   its name, scroll bar colour, scroll bar button, scroll bar direction, scroll amount , position, width and height */
	public static GUIScrollBar createSliderScrollBar(String name , Colour scrollBarColour , GUIButton scrollBarButton ,
			int scrollBarDirection , double scrollAmount , double x , double y , double width , double height) {
		return GUIScrollBarBuilder.createSliderScrollBar(name, scrollBarColour, scrollBarButton, scrollBarDirection, scrollAmount, x, y, width, height);
	}
	
	/* The method to create a renderable scroll bar given
	   its name, scroll bar colour, scroll bar button, scroll bar direction, scroll amount , scroll bar button width
	   scroll bar button height , position, width and height */
	public static GUIScrollBar createRendeableSliderScrollBar(String name , Colour scrollBarColour , GUIButton scrollBarButton ,
			int scrollBarDirection , double scrollAmount , double buttonWidth , double buttonHeight , double x , double y , double width , double height) {
		return GUIScrollBarBuilder.createSliderScrollBar(name, scrollBarColour, scrollBarButton, scrollBarDirection, scrollAmount, buttonWidth, buttonHeight, x, y, width, height);
	}
	
}