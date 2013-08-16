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

import org.simplecorporation.myengine.core.gui.GUIComponent;

public abstract class GUILoadingBar extends GUIComponent {
	
	/* The method called when the current stage has changed */
	public abstract void stageChanged();
	
	/* The number of stages in the loading bar */
	public int loadingStages;
	
	/* The current stage in the loading bar */
	public int currentLoadingStage;
	
	/* The constructor */
	public GUILoadingBar(String name , int loadingStages) {
		//Call the super constructor
		super(name);
		//Assign the variables
		this.loadingStages = loadingStages;
		this.currentLoadingStage = 0;
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
		return (this.currentLoadingStage / this.loadingStages) * 100;
	}
	
}