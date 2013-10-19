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

import org.simplecorporation.myengine.core.gui.button.listener.GUIButtonListener;
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
	public void setClicked(boolean clicked) { this.getBase().clicked = clicked; }
	public void addListener(GUIButtonListener listener) { this.getBase().addListener(listener); }
	
	public boolean isSelected() { return this.getBase().selected; }
	public boolean isClicked() { return this.getBase().isClicked(); }
	
	
}