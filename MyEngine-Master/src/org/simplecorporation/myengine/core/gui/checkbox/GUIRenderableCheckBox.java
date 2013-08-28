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

import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class GUIRenderableCheckBox {
	
	/* The java GUIRenderableCheckBox */
	public JavaGUIRenderableCheckBox javaGUIImageCheckBox;
	
	/* The android GUIRenderableCheckBox */
	public AndroidGUIRenderableCheckBox androidGUIImageCheckBox;
	
	/* The constructor */
	public GUIRenderableCheckBox(String name , Colour checkBackgroundColour , Colour checkColour) {
		//Create the right GUIImageCheckBox
		if (! Settings.Android)
			this.javaGUIImageCheckBox = new JavaGUIRenderableCheckBox(name , checkBackgroundColour , checkColour);
		else if (Settings.Android)
			this.androidGUIImageCheckBox = new AndroidGUIRenderableCheckBox(name , checkBackgroundColour , checkColour);
	}
	
	/* The update method */
	public void update() {
		//Update the right GUIImageTextBox
		if (! Settings.Android)
			this.javaGUIImageCheckBox.update();
		else if (Settings.Android)
			this.androidGUIImageCheckBox.update();
	}
	
	/* The render method */
	public void render() {
		//Render the right GUIImageTextBox
		if (! Settings.Android)
			this.javaGUIImageCheckBox.render();
		else if (Settings.Android)
			this.androidGUIImageCheckBox.render();
	}
	
	/* The method to get the base */
	public GUICheckBoxBase getBase() {
		if (! Settings.Android)
			return this.javaGUIImageCheckBox;
		else if (Settings.Android)
			return this.androidGUIImageCheckBox;
		else
			return null;
	}
	
}