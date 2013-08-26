/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android.gui.checkbox;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.android.gui.GUIComponent;
import org.simplecorporation.myengine.core.android.gui.button.event.GUICheckBoxEvent;
import org.simplecorporation.myengine.core.android.gui.button.listener.GUICheckBoxListener;
import org.simplecorporation.myengine.core.input.event.MouseEvent;

import android.view.MotionEvent;

public abstract class GUICheckBox extends GUIComponent {
	
	/* Is the button clicked */
	public boolean clicked;
	
	/* Is this checked */
	public boolean checked;
	
	/* The last time clicked */
	public long lastTimeClicked;
	
	/* The wait time for being clicked */
	public long clickedWait;
	
	/* The button listeners */
	public LinkedList<GUICheckBoxListener> listeners;
	
	/* The constructor */
	public GUICheckBox(String name) {
		//Call the super constructor
		super(name);
		//Set clicked and checked to false
		this.clicked = false;
		this.checked = false;
		
		//Set the default clicked wait time
		this.clickedWait = 0;
		
		//Set the last time clicked to the current time
		this.lastTimeClicked = System.currentTimeMillis();
		
		//Create the linked list
		this.listeners = new LinkedList<GUICheckBoxListener>();
	}
	
	/* The update method */
	public void updateComponent() {
		
	}
	
	/* The mouse released event */
	public void onMouseReleased(MouseEvent e) {
		//Check that this is visible and selected
		if (this.visible) {
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
					this.listeners.get(a).checkBoxToggled(new GUICheckBoxEvent(this , this.name , this.checked));
				}
			}
		}
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
	
	/* The method that returns whether the button is checked */
	public boolean isChecked() {
		//Return the value
		return this.checked;
	}
	
	/* The method to add a listener to the button */
	public void addListener(GUICheckBoxListener listener) {
		//Add the listener to the linked list
		this.listeners.add(listener);
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
							this.listeners.get(a).checkBoxToggled(new GUICheckBoxEvent(this , this.name , this.checked));
						}
					}
				}
			}
		}
	}
	
}