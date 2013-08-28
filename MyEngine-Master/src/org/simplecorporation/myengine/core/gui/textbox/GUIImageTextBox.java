/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.textbox;

import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.settings.Settings;

public class GUIImageTextBox {
	
	/* The java GUIImageTextBox */
	public JavaGUIImageTextBox javaGUIImageTextbox;
	
	/* The constructor */
	public GUIImageTextBox(String name , Image image , GUIFont font) {
		//Create the right GUIImageCheckBox
		if (! Settings.Android)
			this.javaGUIImageTextbox = new JavaGUIImageTextBox(name , image , font);
		else if (Settings.Android) {
			
		}
	}
	
	/* The constructor */
	public GUIImageTextBox(String name , Image image , GUIFont font , char maskCharacter) {
		//Create the right GUIImageCheckBox
		if (! Settings.Android) {
			this.javaGUIImageTextbox = new JavaGUIImageTextBox(name , image , font);
			this.javaGUIImageTextbox.maskCharacter = maskCharacter;
			this.javaGUIImageTextbox.hideCharacters = true;
		} else if (Settings.Android) {
			
		}
	}
	
	/* The update method */
	public void update() {
		//Update the right GUIImageTextBox
		if (! Settings.Android)
			this.javaGUIImageTextbox.update();
		else if (Settings.Android) {
			
		}
	}
	
	/* The render method */
	public void render() {
		//Render the right GUIImageTextBox
		if (! Settings.Android)
			this.javaGUIImageTextbox.render();
		else if (Settings.Android) {
			
		}
	}
	
	/* The method to get the base */
	public GUITextBoxBase getBase() {
		if (! Settings.Android)
			return this.javaGUIImageTextbox;
		else if (Settings.Android)
			return null;
		else
			return null;
	}
	
}