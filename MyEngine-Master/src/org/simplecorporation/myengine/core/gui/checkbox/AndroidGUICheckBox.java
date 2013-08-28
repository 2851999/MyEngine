/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.checkbox;

import org.simplecorporation.myengine.core.android.input.AndroidInput;
import org.simplecorporation.myengine.core.android.input.listener.AndroidTouchListener;
import org.simplecorporation.myengine.core.gui.button.event.GUICheckBoxEvent;

import android.view.MotionEvent;

public abstract class AndroidGUICheckBox extends GUICheckBoxBase implements AndroidTouchListener {
	
	/* The constructor */
	public AndroidGUICheckBox(String name) {
		//Call the super constructor
		super(name);
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
					//Check if the wait is over
					if (System.currentTimeMillis() - this.lastTimeClicked >= this.clickedWait) {
						//Set the last time
						this.lastTimeClicked = System.currentTimeMillis();
						//Set clicked to true
						this.clicked = true;
						//Set toggle checked
						this.checked = ! this.checked;
						//Call the event
						for (int a = 0; a < this.listeners.size(); a++) {
							this.listeners.get(a).checkBoxToggled(new GUICheckBoxEvent(this.name , this.checked));
						}
					}
				}
			}
		}
	}
	
}