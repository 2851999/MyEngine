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

import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class GUIRenderableButton {
	
	/* The java GUIRenderableButton */
	public JavaGUIRenderableButton javaGUIRenderableButton;
	
	/* The android GUIRenderableButton */
	public AndroidGUIRenderableButton androidGUIRenderableButton;
	
	/* The constructor */
	public GUIRenderableButton(String name , String text , Colour[] colours , GUIFont font) {
		//Create the right GUIImageCheckBox
		if (! Settings.Android)
			this.javaGUIRenderableButton = new JavaGUIRenderableButton(name , text , colours , font);
		else if (Settings.Android)
			this.androidGUIRenderableButton = new AndroidGUIRenderableButton(name , text , colours , font);
	}
	
	/* The update method */
	public void update() {
		//Update the right GUIImageTextBox
		if (! Settings.Android)
			this.javaGUIRenderableButton.update();
		else if (Settings.Android)
			this.androidGUIRenderableButton.update();
	}
	
	/* The render method */
	public void render() {
		//Render the right GUIImageTextBox
		if (! Settings.Android)
			this.javaGUIRenderableButton.render();
		else if (Settings.Android)
			this.androidGUIRenderableButton.render();
	}
	
	/* The method to get the base */
	public GUIButtonBase getBase() {
		if (! Settings.Android)
			return this.javaGUIRenderableButton;
		else if (Settings.Android)
			return this.androidGUIRenderableButton;
		else
			return null;
	}
	
}