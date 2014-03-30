/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui;

import org.simplecorporation.myengine.core.input.MouseInput;
import org.simplecorporation.myengine.core.rectangle.Rectangle;
import org.simplecorporation.myengine.core.window.WindowSizeChangedEvent;

public class GUIWindow extends GUIPanel implements GUIButtonListener {
	
	/* The title of the window */
	public String windowTitle;
	
	/* The close button */
	public GUIButton closeButton;
	
	/* The height of the top bar */
	public int topBarHeight;
	
	/* The GUIRenderer */
	public GUIRenderer renderer;
	
	/* The constructor */
	public GUIWindow(String name , String windowTitle , GUIButton closeButton , int topBarHeight , double x , double y , double width , double height, GUIRenderer renderer) {
		//Call the super constructor
		super(name);
		//Assign the variables
		this.windowTitle = windowTitle;
		this.topBarHeight = topBarHeight;
		this.position.x = x;
		this.position.y = y;
		this.width = width;
		this.height = height;
		this.renderer = renderer;
		//Make sure the close button isn't null
		if (closeButton != null) {
			//Assign the close button
			this.closeButton = closeButton;
			//Set the button name
			this.closeButton.name = this.name + "/" + this.closeButton.name;
			//Set the position of the close button
			this.closeButton.position.x = this.width - this.closeButton.width - 2;
			this.closeButton.position.y = 2;
			//Set the size of the close button
			this.closeButton.height = this.topBarHeight - 4;
			//Add this button listener
			this.closeButton.addListener(this);
			//Add the button to the panel
			this.add(this.closeButton);
		}
	}
	
	/* The method to update the window */
	public void update() {
		//Update the panel
		this.updatePanel();
		//Check the mouse position
		if (MouseInput.isLeftButtonDown) {
			//Check if the top bar is selected
			if (new Rectangle(this.position.x , this.position.y , this.width , this.topBarHeight).contains(MouseInput.x , MouseInput.y)) {
				//Check if the mouse has moved
				if (MouseInput.x != MouseInput.lastX || MouseInput.y != MouseInput.lastY) {
					//Move the window
					this.movePanel(MouseInput.x - MouseInput.lastX , MouseInput.y - MouseInput.lastY);
				}
			}
		}
	}
	
	/* The method to render the window */
	public void render() {
		//Check that the window is showing
		if (this.showing) {
			//Render the window
			this.renderer.render(this.position, this.width, this.height, 0);
			//Render the top bar
			this.renderer.render(this.position, this.width, this.topBarHeight, 1);
			//Render the window title
			this.renderer.font.render(this.windowTitle , this.position.x + 2 , this.position.y + 2);
			//Render the panel
			this.renderPanel();
		}
	}
	
	/* The method called when a button is clicked */
	public void buttonClicked(GUIButtonEvent e) {
		//Check what button was pressed
		if (e.buttonName.equals(this.closeButton.name)) {
			//Hide this panel
			this.hidePanel();
		}
	}
	
	/* The method called when the window's size is changed */
	public void windowSizeChanged(WindowSizeChangedEvent e) {
		
	}
	
}