/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui;

import org.simplecorporation.myengine.core.game2d.entity.AbstractEntity2D;
import org.simplecorporation.myengine.core.input.Input;
import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.input.event.MouseMotionEvent;
import org.simplecorporation.myengine.core.input.event.ScrollEvent;
import org.simplecorporation.myengine.core.input.event.TouchEvent;
import org.simplecorporation.myengine.core.input.listener.InputListener;

public abstract class GUIComponent extends AbstractEntity2D implements InputListener {
	
	/* The name of the component */
	public String name;
	
	/* The boolean that represents whether the component is visible */
	public boolean visible;
	
	/* The boolean that represents whether the component is selected */
	public boolean selected;
	
	/* The abstract methods */
	protected abstract void updateComponent();
	protected abstract void renderComponent();
	
	/* The constructor */
	public GUIComponent(String name) {
		//Assign the name
		this.name = name;
		//Set visible to false
		this.visible = false;
		//Set selected to false
		this.selected = false;
		//Add the listener
		Input.addListener(this);
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
	
	/* Method inherited from InputListener */
	public void onMousePressed(MouseEvent e) {
		
	}
	
	/* Method inherited from InputListener */
	public void onMouseReleased(MouseEvent e) {
		
	}
	
	/* Method inherited from InputListener */
	public void onMouseClicked(MouseEvent e) {
		
	}
	
	/* Method inherited from InputListener */
	public void onMouseMoved(MouseMotionEvent e) {
		
	}
	
	/* Method inherited from InputListener */
	public void onKeyPressed(KeyboardEvent e) {
		
	}
	
	/* Method inherited from InputListener */
	public void onKeyReleased(KeyboardEvent e) {
		
	}
	
	/* Method inherited from InputListener */
	public void onKeyTyped(KeyboardEvent e) {
		
	}
	
	/* Method inherited from InputListener */
	public void onScroll(ScrollEvent e) {
		
	}
	
	/* Method inherited from InputListener */
	public void onTouch(TouchEvent e) {
		
	}
	
}