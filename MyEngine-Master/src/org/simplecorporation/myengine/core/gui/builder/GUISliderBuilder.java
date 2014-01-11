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
import org.simplecorporation.myengine.core.gui.slider.GUIImageSlider;
import org.simplecorporation.myengine.core.gui.slider.GUIRenderableSlider;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUISliderBuilder {
	
	/* The method to create an image slider given
	   its name, slider image, slider button, slider direction, position, width and height */
	public static GUIImageSlider createImageSlider(String name , Image sliderImage , GUIButton sliderButton ,
			int sliderDirection , double x , double y , double width , double height) {
		
		//Create the slider
		GUIImageSlider slider = new GUIImageSlider(name , sliderImage ,  sliderButton , sliderDirection);
		
		//Set the position, width and height
		slider.position.x = x;
		slider.position.y = y;
		slider.width = width;
		slider.height = height;
		
		//Return the slider
		return slider;
	}
	
	/* The method to create an image slider given
	   its name, slider image, slider button, slider direction, slider button width
	   slider button height , position, width and height */
	public static GUIImageSlider createImageSlider(String name , Image sliderImage , GUIButton sliderButton ,
			int sliderDirection , double buttonWidth , double buttonHeight , double x , double y , double width , double height) {
		
		//Set the slider button's width and height
		sliderButton.width = buttonWidth;
		sliderButton.height = buttonHeight;
		
		//Create the slider
		GUIImageSlider slider = new GUIImageSlider(name , sliderImage ,  sliderButton , sliderDirection);
		
		//Set the position, width and height
		slider.position.x = x;
		slider.position.y = y;
		slider.width = width;
		slider.height = height;
		
		//Return the slider
		return slider;
	}
	
	/* The method to create a renderable slider given
	   its name, slider colour, slider button, slider direction, position, width and height */
	public static GUIRenderableSlider createRenderableSlider(String name , Colour sliderColour , GUIButton sliderButton ,
			int sliderDirection , double x , double y , double width , double height) {
		
		//Create the slider
		GUIRenderableSlider slider = new GUIRenderableSlider(name , sliderColour ,  sliderButton , sliderDirection);
		
		//Set the position, width and height
		slider.position.x = x;
		slider.position.y = y;
		slider.width = width;
		slider.height = height;
		
		//Return the slider
		return slider;
	}
	
	/* The method to create a renderable slider given
	   its name, slider colour, slider button, slider direction, slider button width
	   slider button height , position, width and height */
	public static GUIRenderableSlider createRendeableSlider(String name , Colour sliderColour , GUIButton sliderButton ,
			int sliderDirection , double buttonWidth , double buttonHeight , double x , double y , double width , double height) {
		
		//Set the slider button's width and height
		sliderButton.width = buttonWidth;
		sliderButton.height = buttonHeight;
		
		//Create the slider
		GUIRenderableSlider slider = new GUIRenderableSlider(name , sliderColour ,  sliderButton , sliderDirection);
		
		//Set the position, width and height
		slider.position.x = x;
		slider.position.y = y;
		slider.width = width;
		slider.height = height;
		
		//Return the slider
		return slider;
	}
	
}