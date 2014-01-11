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
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;

public class GUIImageWindow extends GUIWindow {
	
	/* The top bar image */
	public Image topBarImage;
	
	/* The window image */
	public Image windowImage;
	
	/* The constructor */
	public GUIImageWindow(String name , String windowTitle , GUIFont titleFont , GUIButton closeButton , int topBarHeight , double x , double y , double width , double height , Image topBarImage , Image windowImage) {
		//Call the super constructor
		super(name , windowTitle , titleFont , closeButton , topBarHeight , x , y , width , height);
		//Assign the variables
		this.topBarImage = topBarImage;
		this.windowImage = windowImage;
	}
	
	/* The method to render the window */
	public void render() {
		//Check that the window is showing
		if (this.showing) {
			//Render the window
			BasicRenderer.renderImage(this.windowImage , this.position.x , this.position.y , this.width , this.height);
			BasicRenderer.renderImage(this.topBarImage , this.position.x , this.position.y , this.width , this.topBarHeight);
			//Render the window title
			this.titleFont.render(this.windowTitle , this.position.x + 2 , this.position.y + 2);
			//Render the panel
			this.renderPanel();
		}
	}
	
}