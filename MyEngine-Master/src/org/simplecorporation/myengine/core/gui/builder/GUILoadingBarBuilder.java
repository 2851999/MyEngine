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

import org.simplecorporation.myengine.core.gui.loadingbar.GUIImageLoadingBar;
import org.simplecorporation.myengine.core.gui.loadingbar.GUIRenderableLoadingBar;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUILoadingBarBuilder {
	
	/* The method to create a renderable loading bar given
	   its name, background colour, bar colour, loading stages, x and y position,
	   width and height */
	public static GUIRenderableLoadingBar createRenderableLoadingBar(String name , Colour backgroundColour ,
			Colour barColour , int loadingStages , double x , double y , double width , double height) {
		
		//Create the loading bar
		GUIRenderableLoadingBar loadingBar = new GUIRenderableLoadingBar(name , loadingStages);
		
		//Set the variables in the loading bar
		loadingBar.backgroundColour = backgroundColour;
		loadingBar.barColour = barColour;
		loadingBar.position.x = x;
		loadingBar.position.y = y;
		loadingBar.width = width;
		loadingBar.height = height;
		
		//Return the loading bar
		return loadingBar;
	}
	
	/* The method to create an image loading bar given
	   its name, background image , bar image , loading stages, x and y position,
	   width and height */
	public static GUIImageLoadingBar createImageLoadingBar(String name , Image backgroundImage ,
			Image barImage , int loadingStages , double x , double y , double width , double height) {
		
		//Create the loading bar
		GUIImageLoadingBar loadingBar = new GUIImageLoadingBar(name , loadingStages , backgroundImage , barImage);
		
		//Set the variables in the loading bar
		loadingBar.position.x = x;
		loadingBar.position.y = y;
		loadingBar.width = width;
		loadingBar.height = height;
		
		//Return the loading bar
		return loadingBar;
	}
	
	/* The method to create an image loading bar given
	   its name, image path , loading stages, x and y position,
	   width and height */
	public static GUIImageLoadingBar createImageLoadingBar(String name , String imagePath ,
			int loadingStages , double x , double y , double width , double height) {
		
		//Create the images
		Image backgroundImage = new Image(imagePath + "Background.png" , "PNG" , true);
		Image barImage = new Image(imagePath + "Bar.png" , "PNG" , true);
		
		//Create the loading bar
		GUIImageLoadingBar loadingBar = new GUIImageLoadingBar(name , loadingStages , backgroundImage , barImage);
		
		//Set the variables in the loading bar
		loadingBar.position.x = x;
		loadingBar.position.y = y;
		loadingBar.width = width;
		loadingBar.height = height;
		
		//Return the loading bar
		return loadingBar;
	}
	
}