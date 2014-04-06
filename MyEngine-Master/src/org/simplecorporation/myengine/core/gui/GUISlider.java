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

import org.simplecorporation.myengine.core.input.MouseInput;

public class GUISlider extends GUIComponent {
	
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
	public GUISlider(String name , GUIButton sliderButton , int sliderDirection, GUIRenderer renderer) {
		//Call the super constructor
		super(name, renderer);
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
				if (this.sliderButton.position.x < this.position.x)
					//Set the slider button's position
					sliderButton.position.x = this.position.x;
				else if (this.sliderButton.position.x > this.position.x + this.width)
					//Set the slider button's position
					sliderButton.position.x = this.position.x + this.width;
				else
					//Set the slider button's position
					sliderButton.position.x = MouseInput.x - sliderButton.width / 2;
				//Set the slider value
				this.sliderValue = ((this.sliderButton.position.x - this.position.x) * (this.width / 100));
			}
			//Put the slider button into the middle of this slider
			this.sliderButton.position.y = (this.position.y + (this.height / 2)) - (this.sliderButton.height / 2);
			//Put the slider into its correct position for the current slider value
			this.sliderButton.position.x = this.position.x + ((this.width / 100) * this.sliderValue);
		} else if (this.sliderDirection == DIRECTION_VERTICAL) {
			//Check if the button is clicked
			if (this.sliderButton.clicked) {
				//Check the mouse position
				if (this.sliderButton.position.y < this.position.y)
					//Set the slider button's position
					this.sliderButton.position.y = this.position.y;
				else if (this.sliderButton.position.y > this.position.y + this.height)
					//Set the slider button's position
					this.sliderButton.position.y = this.position.y + this.height;
				else
					//Set the slider button's position
					this.sliderButton.position.y = MouseInput.y - sliderButton.height / 2;
				//Set the slider value
				this.sliderValue = ((this.position.y + this.height) - this.sliderButton.position.y) / (this.height / 100);
			}
			//Put the slider button into the middle of this slider
			this.sliderButton.position.x = (this.position.x + (this.width / 2)) - (this.sliderButton.width / 2);
			//Put the slider into its correct position for the current slider value
			this.sliderButton.position.y = ((this.position.y + this.height) - ((this.height / 100)) * this.sliderValue);
		}
		//Make sure the slider value is not < 0 or > 100
		if (this.sliderValue < 0)
			//Set the slider value to 0
			this.sliderValue = 0;
		else if (this.sliderValue > 100)
			//Set the slider value to 100
			this.sliderValue = 100;
		//Update the slider button
		this.sliderButton.update();
	}
	
	/* The method to render the component */
	protected void renderComponent() {
		//Set the render index to 0
		this.renderIndex = 0;
		//Render the slider bar
		this.renderer.render(this);
		//Render the button
		this.sliderButton.render();
	}
	
}