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
	
	/* Methods to set and return things in the base */
	public void setX(double x) { this.getBase().position.x = x; }
	public void setY(double y) { this.getBase().position.y = y; }
	public void setWidth(double width) { this.getBase().width = width; }
	public void setHeight(double height) { this.getBase().height = height; }
	public void setVisible(boolean visible) { this.getBase().visible = visible; }
	
	public double getX() { return this.getBase().position.x; }
	public double getY() { return this.getBase().position.y; }
	public double getWidth() { return this.getBase().width; }
	public double getHeight() { return this.getBase().height; }
	public String getName() { return this.getBase().name; }
	public boolean isVisible() { return this.getBase().visible; }
	
	//Base specific
	public void setSelected(boolean selected) { this.getBase().selected = selected; }
	
	public boolean isSelected() { return this.getBase().selected; }
	
}