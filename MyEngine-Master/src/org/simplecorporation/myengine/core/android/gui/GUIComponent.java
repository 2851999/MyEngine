/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android.gui;

import org.simplecorporation.myengine.core.android.input.AndroidInput;
import org.simplecorporation.myengine.core.android.input.listener.AndroidTouchListener;
import org.simplecorporation.myengine.core.game.entity.AbstractEntity2D;

import android.view.MotionEvent;

public abstract class GUIComponent extends AbstractEntity2D implements AndroidTouchListener {
	
	/* The name of the component */
	public String name;
	
	/* The boolean that represents whether the component is visible */
	public boolean visible;
	
	/* The abstract methods */
	public abstract void updateComponent();
	public abstract void renderComponent();
	
	/* The constructor */
	public GUIComponent(String name) {
		//Assign the name
		this.name = name;
		//Set visible to false
		this.visible = false;
		//Add the listener
		AndroidInput.androidTouchListeners.add(this);
	}
	
	/* Method inherited from AbstractEntity2D */
	public void entityUpdate() {
		//Check that the component is visible
		if (this.visible)
			//Update the component
			updateComponent();
	}
	
	/* Method inherited from AbstractEntity2D */
	public void entityRender() {
		//Check that the component is visible
		if (this.visible)
			//Render the component
			renderComponent();
	}
	
	/* The onTouch method */
	public void onTouch(MotionEvent e) {
		
	}
	
}