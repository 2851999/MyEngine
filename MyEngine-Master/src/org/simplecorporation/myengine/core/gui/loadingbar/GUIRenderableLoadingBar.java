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

import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIRenderableLoadingBar extends GUILoadingBar {
	
	/* The background colour */
	public Colour backgroundColour;
	
	/* The bar colour */
	public Colour barColour;
	
	/* The constructor */
	public GUIRenderableLoadingBar(String name , int loadingStages) {
		//Call the super constructor
		super(name , loadingStages);
		//Assign the default colours
		this.backgroundColour = Colour.WHITE;
		this.barColour = Colour.YELLOW;
	}
	
	/* The method to update the loading bar */
	protected void updateComponent() {
		
	}
	
	/* The method to render the loading bar */
	protected void renderComponent() {
		//Set the colour and render the background
		BasicRenderer.setColour(this.backgroundColour);
		BasicRenderer.renderFilledRectangle(this.position.x , this.position.y ,
				this.width , this.height);
		
		//The width the bar should be
		double barWidth = (this.width / this.loadingStages) * this.currentLoadingStage;
		
		//Set the colour and render the loading bar
		BasicRenderer.setColour(this.barColour);
		BasicRenderer.renderFilledRectangle(this.position.x , this.position.y ,
				barWidth , this.height);
	}
	
	/* The method called when the current stage has changed */
	public void stageChanged() {
		
	}
	
}