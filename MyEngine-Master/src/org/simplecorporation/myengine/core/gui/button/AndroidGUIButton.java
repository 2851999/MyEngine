/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.button;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.android.input.AndroidInput;
import org.simplecorporation.myengine.core.android.input.listener.AndroidTouchListener;
import org.simplecorporation.myengine.core.gui.button.event.GUIButtonEvent;
import org.simplecorporation.myengine.core.gui.button.listener.GUIButtonListener;

import android.view.MotionEvent;

public abstract class AndroidGUIButton extends GUIButtonBase implements AndroidTouchListener {
	
	/* The constructor */
	public AndroidGUIButton(String name) {
		//Call the super constructor
		super(name);
		//Set clicked to false
		this.clicked = false;
		//Create the linked list
		this.listeners = new LinkedList<GUIButtonListener>();
		//Add the listener
		AndroidInput.androidTouchListeners.add(this);
	}
	
	/* The update method */
	protected void updateComponent() {
		
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
						this.listeners.get(a).buttonClicked(new GUIButtonEvent(this.name));
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