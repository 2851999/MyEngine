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
import org.simplecorporation.myengine.core.gui.font.GUIFont;

public class GUITextDisplayArea extends GUIComponent {
	
	/* The text in the display area */
	private LinkedList<String> text;
	
	/* The font */
	private GUIFont font;
	
	public GUITextDisplayArea(String name , LinkedList<String> textToDisplay , GUIFont font , double width) {
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
		//Create the text linked list
		text = new LinkedList<String>();
		//Add an empty line to the text linked list
		this.text.add("");
		//The current line of the new text
		int currentLine = 0;
		for (int a = 0; a < textToDisplay.size(); a++) {
			//Split the current line
			String[] split = textToDisplay.get(a).split(" ");
			//Look at every word in the split
			for (int b = 0; b < split.length; b++) {
				//The next line's text
				String nextLineText = text.get(currentLine);
				//Check if the line doesn't contain any words
				if (! nextLineText.equals(""))
					//Add a space to the next line's text
					nextLineText += " ";
				//Check the length of the current with the next word added
				if (font.getWidth(nextLineText + split[b]) < this.width) {
					//Add the word onto the current line
					text.set(currentLine, nextLineText + split[b]);
				} else {
					//Add a new line to the text linked list
					this.text.add(split[b]);
					//Add 1 to the current line
					currentLine++;
				}
			}
		}
	}
	
}