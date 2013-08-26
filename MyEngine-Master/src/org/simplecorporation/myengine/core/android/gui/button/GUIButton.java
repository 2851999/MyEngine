/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android.gui.button;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.android.gui.GUIComponent;
import org.simplecorporation.myengine.core.android.gui.button.event.GUIButtonEvent;
import org.simplecorporation.myengine.core.android.gui.button.listener.GUIButtonListener;

import android.view.MotionEvent;

public abstract class GUIButton extends GUIComponent {
	
	/* Is the button clicked */
	public boolean clicked;
	
	/* The button listeners */
	public LinkedList<GUIButtonListener> listeners;
	
	/* The constructor */
	public GUIButton(String name) {
		//Call the super constructor
		super(name);
		//Set clicked to false
		this.clicked = false;
		//Create the linked list
		this.listeners = new LinkedList<GUIButtonListener>();
	}
	
	/* The update method */
	public void updateComponent() {
		
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
	
	/* The method to add a listener to the button */
	public void addListener(GUIButtonListener listener) {
		//Add the listener to the linked list
		this.listeners.add(listener);
	}
	
	/* The onTouch event */
	public void onTouch(MotionEvent e) {
		//Check if this button was clicked
		if (this.visible) {
			if (e.getAction() == MotionEvent.ACTION_DOWN) {
				if (this.getAndroidBounds().contains((int)e.getX() , (int)e.getY())) {
					//Set clicked to true
					this.clicked = true;
					//Call the event
					for (int a = 0; a < this.listeners.size(); a++) {
						this.listeners.get(a).buttonClicked(new GUIButtonEvent(this , this.name));
					}
				} else
					//Set clicked to false
					this.clicked = false;
			} else if (e.getAction() == MotionEvent.ACTION_UP) {
				//Set clicked to false
				this.clicked = false;
			}
		}
	}
	
}