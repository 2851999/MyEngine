/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.window;

import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIRenderableWindow extends GUIWindow {
	
	/* The top bar colour */
	public Colour topBarColour;
	
	/* The window colour */
	public Colour windowColour;
	
	/* The constructor */
	public GUIRenderableWindow(String name , String windowTitle , GUIFont titleFont , GUIButton closeButton , int topBarHeight , double x , double y , double width , double height , Colour topBarColour , Colour windowColour) {
		//Call the super constructor
		super(name , windowTitle , titleFont , closeButton , topBarHeight , x , y , width , height);
		//Assign the variables
		this.topBarColour = topBarColour;
		this.windowColour = windowColour;
	}
	
	/* The method to render the window */
	public void render() {
		//Check that the window is showing
		if (this.showing) {
			//Render the window
			BasicRenderer.setColour(this.windowColour);
			BasicRenderer.renderFilledRectangle(this.position.x , this.position.y , this.width , this.height);
			//Make sure the top bar is visible
			BasicRenderer.setColour(this.topBarColour);
			BasicRenderer.renderFilledRectangle(this.position.x , this.position.y , this.width , this.topBarHeight);
			//Render the window title
			this.titleFont.render(this.windowTitle , this.position.x + 2 , this.position.y + 2);
			//Render the panel
			this.renderPanel();
		}
	}
	
}