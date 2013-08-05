/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui;

import org.simplecorporation.myengine.core.game.entity.AbstractEntity2D;

public abstract class GUIComponent extends AbstractEntity2D {
	
	/* The name of the component */
	public String name;
	
	/* The boolean that represents whether the component is visible */
	public boolean visible;
	
	/* The abstract methods */
	public abstract void update();
	public abstract void render();
	
	/* The constructor */
	public GUIComponent(String name) {
		//Assign the name
		this.name = name;
		//Set visible to false
		this.visible = false;
	}
	
	public void entityUpdate() {
		//Check that the component is visible
		if (this.visible)
			//Update the component
			update();
	}
	
	public void entityRender() {
		//Check that the component is visible
		if (this.visible)
			//Render the component
			render();
	}
	
}