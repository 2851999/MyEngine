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

public class GUIConfirmDialogBox implements GUIButtonListener {
	
	/* The different results */
	public static final int RESULT_CONFIRM = 1;
	public static final int RESULT_CANCEL = 2;
	
	/* The result */
	public int result;
	
	/* The GUIWindow */
	public GUIWindow window;
	
	/* The buttons in the window */
	public GUIButton confirmButton;
	public GUIButton cancelButton;
	
	/* The constructor */
	public GUIConfirmDialogBox(String name , String text , GUIFont font , GUIWindow window , GUIButton confirmButton , GUIButton cancelButton) {
		//Assign the variables
		this.window = window;
		this.window.name = name + "/Window";
		//Setup the buttons
		confirmButton.name = this.window.name + "/ConfirmButton";
		confirmButton.addListener(this);
		confirmButton.position.x = (this.window.width / 2) - confirmButton.width - 1;
		confirmButton.position.y = (this.window.height - confirmButton.height - 2);
		this.window.add(confirmButton);
		cancelButton.name = this.window.name + "/CancelButton";
		cancelButton.addListener(this);
		cancelButton.position.x = (this.window.width / 2) + 1;
		cancelButton.position.y = (this.window.height - confirmButton.height - 2);
		this.window.add(cancelButton);
		//Setup the text area
		GUITextDisplayArea textArea = new GUITextDisplayArea(this.window.name + "/TextDisplayArea" , ArrayUtils.toStringLinkedList(new String[] { text }) , font , window.width);
		textArea.position.x = 0;
		textArea.position.y = this.window.topBarHeight + 2;
		this.window.add(textArea);
		//Set the result to 0
		this.result = 0;
		//Set the buttons
		this.confirmButton = confirmButton;
		this.cancelButton = cancelButton;
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
		if (e.getButtonName().equals(this.window.name + "/ConfirmButton")) {
			//Set the result
			this.result = RESULT_CONFIRM;
			//Hide the window
			this.window.hidePanel();
		} else if (e.getButtonName().equals(this.window.name + "/CancelButton")) {
			//Set the result
			this.result = RESULT_CANCEL;
			//Hide the window
			this.window.hidePanel();
		}
	}
	
}