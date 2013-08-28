/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.textbox;

import org.simplecorporation.myengine.core.gui.GUIComponent;

public abstract class GUITextBoxBase extends GUIComponent {
	
	/* The text in the box */
	public String text;
	
	/* The text shown if nothing is entered */
	public String defaultText;
	
	/* Is the text box selected */
	public boolean selected;
	
	/* Should the box hide the characters inside */
	public boolean hideCharacters;
	
	/* The char to replace the characters with */
	public char maskCharacter;
	
	/* The boolean which states whether the cursor can be seen */
	public boolean cursorShown;
	
	/* The last blink of the cursor */
	public long cursorLastBlink;
	
	/* The time between blinks */
	public long timeBetweenBlink;
	
	/* Is backspace pressed */
	public boolean backspace;
	
	/* The last time backspace was pressed */
	public long backspaceLastPressed;
	
	/* The time between backspace being pressed */
	public long timeBetweenBackspace;
	
	/* Is another character pressed that is unknown */
	public boolean unknowncharacter;
	
	/* Is shift pressed*/
	public boolean shift;
	
	/* Already had shift event */
	public boolean alreadyHadShift;
	
	/* Is the shift key being released */
	public boolean releasedShiftKey;
	
	/* The constructor */
	public GUITextBoxBase(String name) {
		//Call the super constructor
		super(name);
		//Set the variables
		this.text = "";
		this.defaultText = "";
		this.selected = false;
		this.hideCharacters = false;
		this.maskCharacter = '*';
		this.cursorShown = false;
		this.cursorLastBlink = System.currentTimeMillis();
		this.timeBetweenBlink = 500;
		this.backspace = false;
		this.timeBetweenBackspace = 50;
		this.backspaceLastPressed = System.currentTimeMillis();
		this.unknowncharacter = false;
		this.shift = false;
		this.alreadyHadShift = false;
		this.releasedShiftKey = false;
	}
	
	/* The methods to get / set the variables */
	public void setText(String text) { this.text = text; }
	public String getText() { return this.text; }
	
	public void setDefaultText(String defaultText) { this.defaultText = defaultText; }
	public String getDefaultText() { return this.defaultText; }
	
	public void setSelected(boolean selected) { this.selected = selected; }
	public boolean isSelected() { return this.selected; }
	
	public void hideCharacters(boolean hideCharacters) { this.hideCharacters = hideCharacters; }
	public boolean areCharactersHidden() { return this.hideCharacters; }
	
	public void setMaskCharacter(char maskCharacter) { this.maskCharacter = maskCharacter; }
	public char getMaskCharacter() { return this.maskCharacter; }
	
}