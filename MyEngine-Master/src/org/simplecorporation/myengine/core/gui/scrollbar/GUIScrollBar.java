/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.scrollbar;

import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.gui.slider.GUISlider;
import org.simplecorporation.myengine.core.input.event.ScrollEvent;
import org.simplecorporation.myengine.settings.Settings;

public abstract class GUIScrollBar extends GUISlider {
	
	/* The scroll amount */
	public double scrollAmount;
	
	/* The constructor */
	public GUIScrollBar(String name , GUIButton button , int scrollDirection , double scrollAmount) {
		//Call the super constructor
		super(name , button , scrollDirection);
		//Assign the variables
		this.scrollAmount = scrollAmount;
	}
	
	/* The onScroll method */
	public void onScroll(ScrollEvent e) {
		//Check this scroll bar is visible
		if (this.visible) {
			//Check the scroll direction
			if (this.sliderDirection == GUISlider.DIRECTION_VERTICAL || ! Settings.Android) {
				//Check which direction to scroll
				if (e.distancey > 0)
					//Change the slider value
					this.sliderValue += this.scrollAmount;
				else if (e.distancey < 0)
					//Change the slider value
					this.sliderValue -= this.scrollAmount;
				
				//Check the slider value
				if (this.sliderValue < 0)
					//Set the slider value
					this.sliderValue = 0;
				else if (this.sliderValue > 100)
					//Set the slider value
					this.sliderValue = 100;
			} else if (this.sliderDirection == GUISlider.DIRECTION_HORIZONTAL) {
				//On android (Scroll only if horizontal)
			}
		}
	}
	
}