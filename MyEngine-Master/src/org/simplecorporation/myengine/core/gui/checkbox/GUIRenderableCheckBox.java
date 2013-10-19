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

import org.simplecorporation.myengine.core.gui.button.listener.GUICheckBoxListener;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class GUIRenderableCheckBox {
	
	/* The java GUIRenderableCheckBox */
	public JavaGUIRenderableCheckBox javaGUIRenderableCheckBox;
	
	/* The android GUIRenderableCheckBox */
	public AndroidGUIRenderableCheckBox androidGUIRenderableCheckBox;
	
	/* The constructor */
	public GUIRenderableCheckBox(String name , Colour checkBackgroundColour , Colour checkColour) {
		//Create the right GUIImageCheckBox
		if (! Settings.Android)
			this.javaGUIRenderableCheckBox = new JavaGUIRenderableCheckBox(name , checkBackgroundColour , checkColour);
		else if (Settings.Android)
			this.androidGUIRenderableCheckBox = new AndroidGUIRenderableCheckBox(name , checkBackgroundColour , checkColour);
	}
	
	/* The update method */
	public void update() {
		//Update the right GUIImageTextBox
		if (! Settings.Android)
			this.javaGUIRenderableCheckBox.update();
		else if (Settings.Android)
			this.androidGUIRenderableCheckBox.update();
	}
	
	/* The render method */
	public void render() {
		//Render the right GUIImageTextBox
		if (! Settings.Android)
			this.javaGUIRenderableCheckBox.render();
		else if (Settings.Android)
			this.androidGUIRenderableCheckBox.render();
	}
	
	/* The method to get the base */
	public GUICheckBoxBase getBase() {
		if (! Settings.Android)
			return this.javaGUIRenderableCheckBox;
		else if (Settings.Android)
			return this.androidGUIRenderableCheckBox;
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
	public void addListener(GUICheckBoxListener listener) { this.getBase().addListener(listener); }
	
	public boolean isSelected() { return this.getBase().selected; }
	public boolean isClicked() { return this.getBase().isClicked(); }
	
}