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