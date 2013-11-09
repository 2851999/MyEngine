/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.slider;

import org.simplecorporation.myengine.core.gui.GUIComponent;
import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.input.MouseInput;

public abstract class GUISlider extends GUIComponent {
	
	/* The horizontal slider direction */
	public static final int DIRECTION_HORIZONTAL = 0;
	
	/* The vertical slider direction */
	public static final int DIRECTION_VERTICAL = 1;
	
	/* The variable which states which direction the slider should slide */
	public int sliderDirection;
	
	/* The slider button */
	public GUIButton sliderButton;
	
	/* The current slider value */
	public double sliderValue;
	
	/* The constructor */
	public GUISlider(String name , GUIButton sliderButton , int sliderDirection) {
		//Call the super constructor
		super(name);
		//Assign the variables
		this.sliderButton = sliderButton;
		this.sliderDirection = sliderDirection;
		this.sliderValue = 0;
	}
	
	/* The method to update the slider */
	protected void updateComponent() {
		//Check which direction the slider should be
		if (this.sliderDirection == DIRECTION_HORIZONTAL) {
			//Check if the button is clicked
			if (this.sliderButton.clicked) {
				//Check the mouse position
				if (MouseInput.x < this.position.x)
					//Set the slider button's position
					sliderButton.position.x = this.position.x;
				else if (MouseInput.x > this.position.x + this.width)
					//Set the slider button's position
					sliderButton.position.x = this.position.x + this.width;
				else
					//Set the slider button's position
					sliderButton.position.x = MouseInput.x;
				//Set the slider value
				this.sliderValue = ((this.position.x + this.width) - this.sliderButton.position.x) / (this.width / 100);
			}
			//Put the slider button into the middle of this slider
			this.sliderButton.position.y = (this.position.y + (this.height / 2)) - (this.sliderButton.height / 2);
			//Put the slider into its correct position for the current slider value
			this.sliderButton.position.x = ((this.position.x + this.width) - ((this.width / 100)) * this.sliderValue);
		} else if (this.sliderDirection == DIRECTION_VERTICAL) {
			//Check if the button is clicked
			if (this.sliderButton.clicked) {
				//Check the mouse position
				if (MouseInput.y < this.position.y)
					//Set the slider button's position
					sliderButton.position.y = this.position.y;
				else if (MouseInput.y > this.position.y + this.height)
					//Set the slider button's position
					sliderButton.position.y = this.position.y + this.height;
				else
					//Set the slider button's position
					sliderButton.position.y = MouseInput.y;
				//Set the slider value
				this.sliderValue = ((this.position.y + this.height) - this.sliderButton.position.y) / (this.height / 100);
			}
			//Put the slider button into the middle of this slider
			this.sliderButton.position.x = (this.position.x + (this.width / 2)) - (this.sliderButton.width / 2);
			//Put the slider into its correct position for the current slider value
			this.sliderButton.position.y = ((this.position.y + this.height) - ((this.height / 100)) * this.sliderValue);
		}
		//Update the slider button
		this.sliderButton.update();
	}
	
}