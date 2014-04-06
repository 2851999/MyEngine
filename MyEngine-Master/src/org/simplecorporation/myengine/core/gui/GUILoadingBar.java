/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui;


public class GUILoadingBar extends GUIComponent {
	
	/* The number of stages in the loading bar */
	public int loadingStages;
	
	/* The current stage in the loading bar */
	public int currentLoadingStage;
	
	/* The constructor */
	public GUILoadingBar(String name , int loadingStages, GUIRenderer renderer) {
		//Call the super constructor
		super(name, renderer);
		//Assign the variables
		this.loadingStages = loadingStages;
		this.currentLoadingStage = 0;
	}
	
	/* The overrideable method called when the current stage has changed */
	public void stageChanged() {
		
	}
	
	/* The method to update the loading bar */
	protected void updateComponent() {
		
	}
	
	/* The method used render the loading bar */
	protected void renderComponent() {
		//Set the render index to 0
		this.renderIndex = 0;
		//Render the background
		this.renderer.render(this);
		
		//Get the width of the bar
		double barWidth = (this.width / this.loadingStages) * this.currentLoadingStage;
		
		//Set the render index to 1
		this.renderIndex = 1;
		//Render the loading bar
		this.renderer.render(this.position, barWidth, this.height, 1);
	}
	
	/* The method to increase the current stage */
	public void completedStage() {
		//Check the current stage
		if (this.currentLoadingStage != this.loadingStages) {
			//Increase the current loading stage
			this.currentLoadingStage ++;
			//Call the stage changed method
			this.stageChanged();
		}
	}
	
	/* Returns a boolean value which states whether the
	   loading bar has finished */
	public boolean hasCompleted() {
		//Return the correct value
		return this.currentLoadingStage == this.loadingStages;
	}
	
	/* Returns the percentage of the process that is completed */
	public double getPercentageComplete() {
		//Return the percentage
		return (double)((double)this.currentLoadingStage / (double)this.loadingStages) * 100;
	}
	
}