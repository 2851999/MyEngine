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

import java.awt.event.KeyEvent;

import org.lwjgl.input.Keyboard;
import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.gui.slider.GUISlider;
import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.ScrollEvent;
import org.simplecorporation.myengine.settings.Settings;

public abstract class GUIScrollBar extends GUISlider {
	
	/* The scroll amount */
	public double scrollAmount;
	
	/* Is the shift key pressed */
	public boolean shift;
	
	/* The constructor */
	public GUIScrollBar(String name , GUIButton button , int scrollDirection , double scrollAmount) {
		//Call the super constructor
		super(name , button , scrollDirection);
		//Assign the variables
		this.scrollAmount = scrollAmount;
		this.shift = false;
	}
	
	/* The onScroll method */
	public void onScroll(ScrollEvent e) {
		//Check this scroll bar is visible
		if (this.visible) {
			//Check the scroll direction
			if (this.sliderDirection == GUISlider.DIRECTION_VERTICAL && ! this.shift) {
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
			} else if (this.sliderDirection == GUISlider.DIRECTION_HORIZONTAL && this.shift && !Settings.Android) {
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
			} else if (this.sliderDirection == GUISlider.DIRECTION_HORIZONTAL && Settings.Android) {
				//On android (Scroll only if horizontal)
				//Check which direction to scroll
				if (e.distancex > 0)
					//Change the slider value
					this.sliderValue += this.scrollAmount;
				else if (e.distancex < 0)
					//Change the slider value
					this.sliderValue -= this.scrollAmount;
				
				//Check the slider value
				if (this.sliderValue < 0)
					//Set the slider value
					this.sliderValue = 0;
				else if (this.sliderValue > 100)
					//Set the slider value
					this.sliderValue = 100;
			}
		}
	}
	
	/* Called when a key is pressed */
	public void onKeyPressed(KeyboardEvent e) {
		//Check whether this is visible
		if (this.visible) {
			//Check whether OpenGL is being used
			if (! Settings.Video.OpenGL && ! Settings.Android) {
				//Check what key was pressed
				if (e.getCode() == KeyEvent.VK_SHIFT)
					//Set shift to true
					this.shift = true;
			} else if (Settings.Video.OpenGL && ! Settings.Android) {
				//Check what key was pressed
				if (e.getCode() == Keyboard.KEY_LSHIFT || e.getCode() == Keyboard.KEY_RSHIFT)
					//Set shift to true
					this.shift = true;
			}
		}
	}
	
	/* Called when a key is released */
	public void onKeyReleased(KeyboardEvent e) {
		//Check whether this is visible
		if (this.visible) {
			//Check whether OpenGL is being used
			if (! Settings.Video.OpenGL && ! Settings.Android) {
				//Check what key was released
				if (e.getCode() == KeyEvent.VK_SHIFT)
					//Set shift to false
					this.shift = false;
			} else if (Settings.Video.OpenGL && ! Settings.Android) {
				//Check what key was released
				if (e.getCode() == Keyboard.KEY_LSHIFT || e.getCode() == Keyboard.KEY_RSHIFT)
					//Set shift to false
					this.shift = false;
			}
		}
	}
	
}