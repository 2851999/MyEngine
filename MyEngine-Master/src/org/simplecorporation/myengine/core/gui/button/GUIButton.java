/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.button;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.audio.clip.AudioClip;
import org.simplecorporation.myengine.core.gui.GUIComponent;
import org.simplecorporation.myengine.core.gui.button.event.GUIButtonEvent;
import org.simplecorporation.myengine.core.gui.button.listener.GUIButtonListener;
import org.simplecorporation.myengine.core.input.MouseInput;
import org.simplecorporation.myengine.core.input.event.TouchEvent;
import org.simplecorporation.myengine.settings.Settings;

public abstract class GUIButton extends GUIComponent {
	
	/* Is the button selected */
	public boolean buttonSelected;
	
	/* Is the button clicked */
	public boolean clicked;
	
	/* The button listeners */
	public LinkedList<GUIButtonListener> listeners;
	
	/* The sound to be played when the button is clicked */
	public AudioClip soundEffect;
	
	/* The text in the button */
	public String text;
	
	/* The constructor */
	public GUIButton(String name) {
		//Call the super constructor
		super(name);
		//Set selected and clicked to false
		this.buttonSelected = false;
		this.clicked = false;
		//Create the linked list
		this.listeners = new LinkedList<GUIButtonListener>();
	}
	
	/* The update method */
	protected void updateComponent() {
		//Check if using android
		if (! Settings.Android) {
			//Check whether the button is selected
			if (this.getBounds().contains(MouseInput.x , MouseInput.y))
				//Set selected to true
				this.buttonSelected = true;
			else {
				//Set selected to false
				this.buttonSelected = false;
				//Check if the button is clicked
				if (this.clicked)
					//Set clicked to false
					this.clicked = false;
			}
			
			//Check if the button is down
			if (MouseInput.isButtonDown(0) && this.buttonSelected) {
				//Check if the sound effect is null
				if (this.soundEffect != null) {
					if (! this.soundEffect.isPlaying())
						this.soundEffect.play();
				}
				//Set clicked to true
				this.clicked = true;
				//Call the event
				for (int a = 0; a < this.listeners.size(); a++) {
					this.listeners.get(a).buttonClicked(new GUIButtonEvent(this.name));
				}
			} else
				//Set clicked to false
				this.clicked = false;
		}
	}
	
	/* The method that returns whether the button is selected */
	public boolean isButtonSelected() {
		//Check whether the button is visible
		if (this.visible)
			//Return the value
			return this.buttonSelected;
		else
			//Return false
			return false;
	}
	
	/* The method that returns whether the button is clicked */
	public boolean isClicked() {
		//Check whether the button is visible
		if (this.visible) {
			//Check if the button has been clicked
			if (this.clicked) {
				//Set clicked to false then return true
				this.clicked = false;
				return true;
			} else {
				//Return false
				return false;
			}
		} else
			//Return false
			return false;
	}
	
	/* The onTouch event */
	public void onTouch(TouchEvent e) {
		//Check if this button was clicked
		if (this.visible) {
			if (e.getEvent() == TouchEvent.EVENT_DOWN) {
				if (this.getBounds().contains((int)e.x , (int)e.y)) {
					//Set clicked to true
					this.clicked = true;
					//Call the event
					for (int a = 0; a < this.listeners.size(); a++) {
						this.listeners.get(a).buttonClicked(new GUIButtonEvent(this.name));
					}
				} else
					//Set clicked to false
					this.clicked = false;
				} else if (e.getEvent() == TouchEvent.EVENT_UP) {
					//Set clicked to false
					this.clicked = false;
				}
			}
		}
	
	/* The method to add a listener to the button */
	public void addListener(GUIButtonListener listener) {
		//Add the listener to the linked list
		this.listeners.add(listener);
	}
	
}