/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.dialogbox;

import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.gui.button.event.GUIButtonEvent;
import org.simplecorporation.myengine.core.gui.button.listener.GUIButtonListener;
import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.gui.textdisplayarea.GUITextDisplayArea;
import org.simplecorporation.myengine.core.gui.window.GUIWindow;
import org.simplecorporation.myengine.utils.array.ArrayUtils;

public class GUIMessageDialogBox implements GUIButtonListener {
	
	/* The GUIWindow */
	public GUIWindow window;
	
	/* The constructor */
	public GUIMessageDialogBox(String name , String text , GUIFont font , GUIWindow window , GUIButton okButton) {
		//Assign the variables
		this.window = window;
		this.window.name = name + "/Window";
		//Setup the button
		okButton.name = this.window.name + "/OKButton";
		okButton.addListener(this);
		okButton.position.x = (this.window.width / 2) - (okButton.width / 2);
		okButton.position.y = (this.window.height - okButton.height - 2);
		this.window.add(okButton);
		//Setup the text area
		GUITextDisplayArea textArea = new GUITextDisplayArea(this.window.name + "/TextDisplayArea" , ArrayUtils.toStringLinkedList(new String[] { text }) , font , window.width);
		textArea.position.x = 0;
		textArea.position.y = this.window.topBarHeight + 2;
		this.window.add(textArea);
	}
	
	/* The method to update the dialog box */
	public void update() {
		//Update the window
		this.window.update();
	}
	
	/* The method to render the dialog box */
	public void render() {
		//Render the window
		this.window.render();
	}
	
	/* The method called when a button is clicked */
	public void buttonClicked(GUIButtonEvent e) {
		//Check what button was pressed
		if (e.getButtonName().equals(this.window.name + "/OKButton")) {
			//Hide the window
			this.window.hidePanel();
		}
	}
	
}