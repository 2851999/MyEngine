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

import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.gui.button.GUIImageButton;
import org.simplecorporation.myengine.core.gui.button.GUIRenderableButton;
import org.simplecorporation.myengine.core.gui.checkbox.GUIImageCheckBox;
import org.simplecorporation.myengine.core.gui.checkbox.GUIRenderableCheckBox;
import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.gui.loadingbar.GUIImageLoadingBar;
import org.simplecorporation.myengine.core.gui.loadingbar.GUIRenderableLoadingBar;
import org.simplecorporation.myengine.core.gui.scrollbar.GUIImageScrollBar;
import org.simplecorporation.myengine.core.gui.scrollbar.GUIRenderableScrollBar;
import org.simplecorporation.myengine.core.gui.slider.GUIImageSlider;
import org.simplecorporation.myengine.core.gui.slider.GUIRenderableSlider;
import org.simplecorporation.myengine.core.gui.textbox.GUIImageTextBox;
import org.simplecorporation.myengine.core.gui.textbox.GUIRenderableTextBox;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIBuilder {
	
	/* The method to create an image button given
	   its name, text, images, position, width and height */
	public static GUIImageButton createImageButton(String name , String text , Image[] images ,
			double x , double y , double width , double height) {
		return GUIButtonBuilder.createImageButton(name, text, images, x, y, width, height);
	}
	
	/* The method to create an image button given
	   its name, text, image path, number of images, position, width and height */
	public static GUIImageButton createImageButton(String name , String text , String imagePath ,
			int numberOfImages , double x , double y , double width , double height) {
		return GUIButtonBuilder.createImageButton(name, text, imagePath, numberOfImages, x, y, width, height);
	}
	
	/* The method to create an image button given
	   its name, text, images, font, position, width and height */
	public static GUIImageButton createImageButton(String name , String text , Image[] images , GUIFont font ,
			double x , double y , double width , double height) {
		return GUIButtonBuilder.createImageButton(name, text, images, font, x, y, width, height);
	}
	
	/* The method to create an image button given
	   its name, text, image path, number of images, font, position, width and height */
	public static GUIImageButton createImageButton(String name , String text , String imagePath , GUIFont font ,
			int numberOfImages , double x , double y , double width , double height) {
		return GUIButtonBuilder.createImageButton(name, text, imagePath, font, numberOfImages, x, y, width, height);
	}
	
	/* The method to create a renderable button given
	   its name, text, images, font, position, width and height */
	public static GUIRenderableButton createRenderableButton(String name , String text , Colour[] colours , GUIFont font ,
			double x , double y , double width , double height) {
		return GUIButtonBuilder.createRenderableButton(name, text, colours, font, x, y, width, height);
	}
	
	/* The method to create a renderable check box button
	   given the name, check box colour, check colour, x and y position,
	   width and height */
	public static GUIRenderableCheckBox createRenderableCheckBox(String name ,
			Colour checkBoxColour , Colour checkColour , double x , double y , double width , double height) {
		return GUICheckBoxBuilder.createRenderableCheckBox(name, checkBoxColour, checkColour, x, y, width, height);
	}
	
	/* The method to create a renderable check box button
	   given the name, check box colour, check colour, check width, check height, x and y position,
	   width and height */
	public static GUIRenderableCheckBox createRenderableCheckBox(String name ,
			Colour checkBoxColour , Colour checkColour , double checkWidth , double checkHeight , double x , double y ,
			double width , double height) {
		return GUICheckBoxBuilder.createRenderableCheckBox(name, checkBoxColour, checkColour, checkWidth, checkHeight, x, y, width, height);
	}
	
	/* The method to create an image check box button
	   given the name, images, x and y position,
	   width and height */
	public static GUIImageCheckBox createImageCheckBox(String name ,
			Image[] images , double x , double y , double width , double height) {
		return GUICheckBoxBuilder.createImageCheckBox(name, images, x, y, width, height);
	}
	
	/* The method to create an image check box button
	   given the name, image path, number of images, x and y position,
	   width and height */
	public static GUIImageCheckBox createImageCheckBox(String name ,
			String imagePath , int numberOfImages , double x , double y , double width , double height) {
		return GUICheckBoxBuilder.createImageCheckBox(name, imagePath, numberOfImages, x, y, width, height);
	}
	
	/* The method to create a renderable loading bar given
	   its name, background colour, bar colour, loading stages, x and y position,
	   width and height */
	public static GUIRenderableLoadingBar createRenderableLoadingBar(String name , Colour backgroundColour ,
			Colour barColour , int loadingStages , double x , double y , double width , double height) {
		return GUILoadingBarBuilder.createRenderableLoadingBar(name, backgroundColour, barColour, loadingStages, x, y, width, height);
	}
	
	/* The method to create an image loading bar given
	   its name, background image , bar image , loading stages, x and y position,
	   width and height */
	public static GUIImageLoadingBar createImageLoadingBar(String name , Image backgroundImage ,
			Image barImage , int loadingStages , double x , double y , double width , double height) {
		return GUILoadingBarBuilder.createImageLoadingBar(name, backgroundImage, barImage, loadingStages, x, y, width, height);
	}
	
	/* The method to create an image loading bar given
	   its name, image path , loading stages, x and y position,
	   width and height */
	public static GUIImageLoadingBar createImageLoadingBar(String name , String imagePath ,
			int loadingStages , double x , double y , double width , double height) {
		return GUILoadingBarBuilder.createImageLoadingBar(name, imagePath, loadingStages, x, y, width, height);
	}
	
	/* The method to create a renderable text box given its
	   name, background colour, outline colour, font, x and y position,
	   width and height */
	public static GUIRenderableTextBox createRenderableTextBox(String name , Colour backgroundColour ,
			Colour outlineColour , GUIFont font , double x , double y , double width , double height) {
		return GUITextBoxBuilder.createRenderableTextBox(name, backgroundColour, outlineColour, font, x, y, width, height);
	}
	
	/* The method to create a renderable text box given its
	   name, background colour, outline colour, font, mask character, x and y position,
	   width and height */
	public static GUIRenderableTextBox createRenderableTextBox(String name , Colour backgroundColour ,
			Colour outlineColour , GUIFont font , String maskCharacter , double x , double y , double width , double height) {
		return GUITextBoxBuilder.createRenderableTextBox(name, backgroundColour, outlineColour, font, maskCharacter, x, y, width, height);
	}
	
	/* The method to create an image text box given its
	   name, image, font, x and y position,
	   width and height */
	public static GUIImageTextBox createImageTextBox(String name , Image image ,
			GUIFont font , double x , double y , double width , double height) {
		return GUITextBoxBuilder.createImageTextBox(name, image, font, x, y, width, height);
	}
	
	/* The method to create an image text box given its
	   name, image, font, mask character, x and y position,
	   width and height */
	public static GUIImageTextBox createImageTextBox(String name , Image image ,
			GUIFont font , String maskCharacter , double x , double y , double width , double height) {
		return GUITextBoxBuilder.createImageTextBox(name, image, font, maskCharacter, x, y, width, height);
	}
	
	/* The method to create an image slider given
	   its name, slider image, slider button, slider direction, position, width and height */
	public static GUIImageSlider createImageSlider(String name , Image sliderImage , GUIButton sliderButton ,
			int sliderDirection , double x , double y , double width , double height) {
		return GUISliderBuilder.createImageSlider(name, sliderImage, sliderButton, sliderDirection, x, y, width, height);
	}
	
	/* The method to create an image slider given
	   its name, slider image, slider button, slider direction, slider button width
	   slider button height , position, width and height */
	public static GUIImageSlider createImageSlider(String name , Image sliderImage , GUIButton sliderButton ,
			int sliderDirection , double buttonWidth , double buttonHeight , double x , double y , double width , double height) {
		return GUISliderBuilder.createImageSlider(name, sliderImage, sliderButton, sliderDirection, buttonWidth, buttonHeight, x, y, width, height);
	}
	
	/* The method to create a renderable slider given
	   its name, slider colour, slider button, slider direction, position, width and height */
	public static GUIRenderableSlider createRenderableSlider(String name , Colour sliderColour , GUIButton sliderButton ,
			int sliderDirection , double x , double y , double width , double height) {
		return GUISliderBuilder.createRenderableSlider(name, sliderColour, sliderButton, sliderDirection, x, y, width, height);
	}
	
	/* The method to create a renderable slider given
	   its name, slider colour, slider button, slider direction, slider button width
	   slider button height , position, width and height */
	public static GUIRenderableSlider createRendeableSlider(String name , Colour sliderColour , GUIButton sliderButton ,
			int sliderDirection , double buttonWidth , double buttonHeight , double x , double y , double width , double height) {
		return GUISliderBuilder.createRendeableSlider(name, sliderColour, sliderButton, sliderDirection, buttonWidth, buttonHeight, x, y, width, height);
	}
	
	/* The method to create an image scroll bar given
	   its name, scroll bar image, scroll bar button, scroll bar direction, scroll amount , position, width and height */
	public static GUIImageScrollBar createImageScrollBar(String name , Image scrollBarImage , GUIButton scrollBarButton ,
			int scrollBarDirection , double scrollAmount , double x , double y , double width , double height) {
		return GUIScrollBarBuilder.createImageScrollBar(name, scrollBarImage, scrollBarButton, scrollBarDirection, scrollAmount, x, y, width, height);
	}
	
	/* The method to create an image scroll bar given
	   its name, slider image, slider button, slider direction, scroll amount , slider button width
	   slider button height , position, width and height */
	public static GUIImageScrollBar createImageScrollBar(String name , Image scrollBarImage , GUIButton scrollBarButton ,
			int scrollBarDirection , double scrollAmount , double buttonWidth , double buttonHeight , double x , double y , double width , double height) {
		return GUIScrollBarBuilder.createImageScrollBar(name, scrollBarImage, scrollBarButton, scrollBarDirection, scrollAmount, buttonWidth, buttonHeight, x, y, width, height);
	}
	
	/* The method to create a renderable scroll bar given
	   its name, scroll bar colour, scroll bar button, scroll bar direction, scroll amount , position, width and height */
	public static GUIRenderableScrollBar createRenderableSliderScrollBar(String name , Colour scrollBarColour , GUIButton scrollBarButton ,
			int scrollBarDirection , double scrollAmount , double x , double y , double width , double height) {
		return GUIScrollBarBuilder.createRenderableSliderScrollBar(name, scrollBarColour, scrollBarButton, scrollBarDirection, scrollAmount, x, y, width, height);
	}
	
	/* The method to create a renderable scroll bar given
	   its name, scroll bar colour, scroll bar button, scroll bar direction, scroll amount , scroll bar button width
	   scroll bar button height , position, width and height */
	public static GUIRenderableScrollBar createRendeableSliderScrollBar(String name , Colour scrollBarColour , GUIButton scrollBarButton ,
			int scrollBarDirection , double scrollAmount , double buttonWidth , double buttonHeight , double x , double y , double width , double height) {
		return GUIScrollBarBuilder.createRendeableSliderScrollBar(name, scrollBarColour, scrollBarButton, scrollBarDirection, scrollAmount, buttonWidth, buttonHeight, x, y, width, height);
	}
	
}