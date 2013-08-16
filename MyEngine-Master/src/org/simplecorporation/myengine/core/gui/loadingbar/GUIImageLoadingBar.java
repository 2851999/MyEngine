/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.loadingbar;

import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIImageLoadingBar extends GUILoadingBar {
	
	/* The background image */
	public Image backgroundImage;
	
	/* The bar image */
	public Image barImage;
	
	/* The constructor */
	public GUIImageLoadingBar(String name , int loadingStages , Image backgroundImage , Image barImage) {
		//Call the super constructor
		super(name , loadingStages);
		//Assign the images
		this.backgroundImage = backgroundImage;
		this.barImage = barImage;
	}
	
	/* The method to update the loading bar */
	public void updateComponent() {
		
	}
	
	/* The method to render the loading bar */
	public void renderComponent() {
		//Set the colour and render the background
		BasicRenderer.setColour(Colour.WHITE);
		BasicRenderer.renderImage(this.backgroundImage , this.position.x , this.position.y ,
				this.width , this.height);
		
		//The width the bar should be
		double barWidth = (this.width / this.loadingStages) * this.currentLoadingStage;
		
		//Render the loading bar
		BasicRenderer.renderImage(this.barImage , this.position.x , this.position.y ,
				barWidth , this.height);
	}
	
	/* The method called when the current stage has changed */
	public void stageChanged() {
		
	}
	
}