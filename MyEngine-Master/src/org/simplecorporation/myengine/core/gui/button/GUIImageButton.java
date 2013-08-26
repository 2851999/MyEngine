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
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.settings.Settings;

public class GUIImageButton {
	
	/* The java GUIImageButton */
	public JavaGUIImageButton javaGUIImageButton;
	
	/* The android GUIImageButton */
	public AndroidGUIImageButton androidGUIImageButton;
	
	/* The constructor */
	public GUIImageButton(String name , String text , Image[] images , GUIFont font) {
		//Create the right GUIImageCheckBox
		if (! Settings.Android)
			this.javaGUIImageButton = new JavaGUIImageButton(name , text , images , font);
		else if (Settings.Android)
			this.androidGUIImageButton = new AndroidGUIImageButton(name , text , images , font);
	}
	
	/* The update method */
	public void update() {
		//Update the right GUIImageTextBox
		if (! Settings.Android)
			this.javaGUIImageButton.update();
		else if (Settings.Android)
			this.androidGUIImageButton.update();
	}
	
	/* The render method */
	public void render() {
		//Render the right GUIImageTextBox
		if (! Settings.Android)
			this.javaGUIImageButton.render();
		else if (Settings.Android)
			this.androidGUIImageButton.render();
	}
	
	/* The method to get the base */
	public GUIButtonBase getBase() {
		if (! Settings.Android)
			return this.javaGUIImageButton;
		else if (Settings.Android)
			return this.androidGUIImageButton;
		else
			return null;
	}
	
}