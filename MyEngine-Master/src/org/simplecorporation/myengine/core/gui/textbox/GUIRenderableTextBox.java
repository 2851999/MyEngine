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
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class GUIRenderableTextBox {
	
	/* The java GUIRenderableTextBox */
	public JavaGUIRenderableTextBox javaGUIRenderableTextbox;
	
	/* The constructor */
	public GUIRenderableTextBox(String name , Colour backgroundColour , Colour outlineColour , GUIFont font) {
		//Create the right GUIImageCheckBox
		if (! Settings.Android) {
			this.javaGUIRenderableTextbox = new JavaGUIRenderableTextBox(name , font);
			this.javaGUIRenderableTextbox.backgroundColour = backgroundColour;
			this.javaGUIRenderableTextbox.outlineColour = outlineColour;
		} else if (Settings.Android) {
			
		}
	}
	
	/* The constructor */
	public GUIRenderableTextBox(String name , Colour backgroundColour , Colour outlineColour , GUIFont font , char maskCharacter) {
		//Create the right GUIImageCheckBox
		if (! Settings.Android) {
			this.javaGUIRenderableTextbox = new JavaGUIRenderableTextBox(name , font);
			this.javaGUIRenderableTextbox.backgroundColour = backgroundColour;
			this.javaGUIRenderableTextbox.outlineColour = outlineColour;
			this.javaGUIRenderableTextbox.maskCharacter = maskCharacter;
			this.javaGUIRenderableTextbox.hideCharacters = true;
		} else if (Settings.Android) {
			
		}
	}
	
	/* The update method */
	public void update() {
		//Update the right GUIImageTextBox
		if (! Settings.Android)
			this.javaGUIRenderableTextbox.update();
		else if (Settings.Android) {
			
		}
	}
	
	/* The render method */
	public void render() {
		//Render the right GUIImageTextBox
		if (! Settings.Android)
			this.javaGUIRenderableTextbox.render();
		else if (Settings.Android) {
			
		}
	}
	
	/* The method to get the base */
	public GUITextBoxBase getBase() {
		if (! Settings.Android)
			return this.javaGUIRenderableTextbox;
		else if (Settings.Android)
			return null;
		else
			return null;
	}
	
}