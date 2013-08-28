/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.textdisplayarea;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.gui.GUIComponent;
import org.simplecorporation.myengine.core.gui.font.JavaGUIFont;

public class JavaGUITextDisplayArea extends GUIComponent {
	
	/* The text in the display area */
	private LinkedList<String> text;
	
	/* The font */
	private JavaGUIFont font;
	
	public JavaGUITextDisplayArea(String name , LinkedList<String> textToDisplay , JavaGUIFont font , int width) {
		//Call the super constructor
		super(name);
		//Assign the variables
		this.font = font;
		this.width = width;
		//Setup the word wrap
		this.wordWrap(textToDisplay);
	}
	
	/* The method to update the display area */
	protected void updateComponent() {
		
	}
	
	protected void renderComponent() {
		//The position
		double xPos = this.position.x;
		double yPos = this.position.y;
		//Render all of the text
		for (int a = 0; a < text.size(); a++) {
			font.render(text.get(a) , xPos , yPos);
			yPos += font.getHeight(text.get(a));
		}
	}
	
	/* The method to setup word wrap */
	public void wordWrap(LinkedList<String> textToDisplay) {
		text = new LinkedList<String>();
		//The current line of the new text
		int currentLine = -1;
		for (int a = 0; a < textToDisplay.size(); a++) {
			//Add one
			currentLine ++;
			//Split up the current line of text into words
			String[] line = textToDisplay.get(a).split(" ");
			//Add a new line
			text.add("");
			//Loop for the current line's words
			for (int b = 0; b < line.length; b++) {
				//Check if the line needs wrapping
				if ((font.getWidth(text.get(currentLine) + " " + line[b]) > width)) {
					//Add one
					currentLine ++;
					//Add a new line with the next word
					text.add(" " + line[b]);
				} else {
					//Extend the current line with the next word
					text.set(currentLine , text.get(currentLine) + " " + line[b]);
				}
			}
		}
	}
	
}