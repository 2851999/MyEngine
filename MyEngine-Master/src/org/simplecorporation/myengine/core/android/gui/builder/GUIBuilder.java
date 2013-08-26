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

import org.simplecorporation.myengine.core.android.gui.button.GUIImageButton;
import org.simplecorporation.myengine.core.android.gui.button.GUIRenderableButton;
import org.simplecorporation.myengine.core.android.gui.checkbox.GUIImageCheckBox;
import org.simplecorporation.myengine.core.android.gui.checkbox.GUIRenderableCheckBox;
import org.simplecorporation.myengine.core.android.gui.font.GUIFont;
import org.simplecorporation.myengine.core.android.gui.loadingbar.GUIImageLoadingBar;
import org.simplecorporation.myengine.core.android.gui.loadingbar.GUIRenderableLoadingBar;
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
	
}