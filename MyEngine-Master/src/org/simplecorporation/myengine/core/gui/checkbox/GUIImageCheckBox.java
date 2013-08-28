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

import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.settings.Settings;

public class GUIImageCheckBox {
	
	/* The java GUIImageCheckBox */
	public JavaGUIImageCheckBox javaGUIImageCheckBox;
	
	/* The android GUIImageCheckBox */
	public AndroidGUIImageCheckBox androidGUIImageCheckBox;
	
	/* The constructor */
	public GUIImageCheckBox(String name , Image[] images) {
		//Create the right GUIImageCheckBox
		if (! Settings.Android)
			this.javaGUIImageCheckBox = new JavaGUIImageCheckBox(name , images);
		else if (Settings.Android)
			this.androidGUIImageCheckBox = new AndroidGUIImageCheckBox(name , images);
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