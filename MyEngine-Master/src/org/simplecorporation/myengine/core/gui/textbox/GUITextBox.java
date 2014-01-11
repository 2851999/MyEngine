/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.textbox;

import java.awt.event.KeyEvent;

import org.lwjgl.input.Keyboard;
import org.simplecorporation.myengine.core.gui.GUIComponent;
import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.settings.Settings;

public abstract class GUITextBox extends GUIComponent {
	
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
	
	/* Is another character pressed that is unknown */
	public boolean unknowncharacter;
	
	/* Is shift pressed*/
	public boolean shift;
	
	/* Already had shift event */
	public boolean alreadyHadShift;
	
	/* Is the shift key being released */
	public boolean releasedShiftKey;
	
	/* The constructor */
	public GUITextBox(String name) {
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
		this.unknowncharacter = false;
		this.shift = false;
		this.alreadyHadShift = false;
		this.releasedShiftKey = false;
	}
	
	/* The method to update the text box */
	protected void updateComponent() {
		//Check if this is visible and selected
		if (this.visible && this.selected) {
			//Check the time
			if (System.currentTimeMillis() - this.cursorLastBlink >= this.timeBetweenBlink) {
				//Set the last blink
				this.cursorLastBlink = System.currentTimeMillis();
				this.cursorShown = !this.cursorShown;
			}
			
			//Check and remove any unwanted characters
			for (int a = 0; a < this.text.length(); a++) {
				if (this.text.charAt(a) == '\u0000' || ! Character.isDefined(this.text.charAt(a))
						 || Character.isISOControl(this.text.charAt(a))) {
					//Remove the character
					String string = this.text;
					this.text = "";
					string = new StringBuilder(string).deleteCharAt(a).toString();
					this.text = string;
				}
			}
			
		} else {
			//Set the cursor shown to false
			this.cursorShown = false;
		}
	}
	
	/* The mouse pressed event */
	public void onMousePressed(MouseEvent e) {
		//Check if the button is selected and the mouse isn't inside this text box
		if (this.selected && ! this.getBounds().contains(e.x , e.y))
			//Set selected to false
			this.selected = false;
	}
	
	/* The mouse clicked event */
	public void onMouseClicked(MouseEvent e) {
		//Check if this is visible and not selected
		if (this.visible && ! this.selected) {
			//Check if this text box has been clicked
			if (this.getBounds().contains(e.x , e.y)) {
				//Set selected to true
				this.selected = true;
				//Set the last cursor blink time
				this.cursorLastBlink = System.currentTimeMillis();
			}
		}
	}
	
	/* The key pressed event */
	public void onKeyPressed(KeyboardEvent e) {
		//Check if this is visible and selected
		if (this.visible && this.selected) {
			//Check what rendering mode is being used
			if (Settings.Video.OpenGL) {
				//Check what key was pressed
				if (e.keyCode == Keyboard.KEY_BACK) {
					this.backspace = true;
					//Remove the last letter if there is one
					if (this.text.length() > 0)
						this.text = this.text.substring(0 , this.text.length() - 1);
				} else if (e.keyCode == Keyboard.KEY_LSHIFT || e.keyCode == Keyboard.KEY_RSHIFT) {
					this.shift = true;
					this.alreadyHadShift = false;
				}
			} else {
				//Check what key was pressed
				if (e.keyCode == KeyEvent.VK_BACK_SPACE) {
					this.backspace = true;
					//Remove the last letter if there is one
					if (this.text.length() > 0)
						this.text = this.text.substring(0 , this.text.length() - 1);
				}
			}
			
			if (e.keyChar == '\u0000')
				this.unknowncharacter = true;
			
			//Check if using backspace
			if (! this.backspace) {
				//Check the rendering mode
				if (Settings.Video.OpenGL){
					//Check it wasn't space
					if (e.keyCode == Keyboard.KEY_SPACE) {
						//Add a space
						this.text += " ";
					} else if (e.keyCode == Keyboard.KEY_RETURN) {
						
					} else if (this.shift) {
						if (! this.alreadyHadShift) {
							this.alreadyHadShift = true;
							this.text += e.keyChar;
						} else {
							this.alreadyHadShift = false;
							this.shift = false;
						}
					} else if (! this.releasedShiftKey && ! this.unknowncharacter && e.keyCode != Keyboard.KEY_BACK) {
						//Check if the the character was null
						if (e.keyChar != ' ' && (e.keyChar != '\u0000')) {
							//Add the character to the text
							this.text += e.keyChar;
							//Set the cursor time
							this.cursorShown = false;
							this.cursorLastBlink = System.currentTimeMillis();
						}
					} else {
						this.releasedShiftKey = false;
					}
				} else {
					//Check it wasn't space
					if (e.keyCode == KeyEvent.VK_SPACE) {
						//Add a space
						this.text += " ";
					} else if (e.keyCode == KeyEvent.VK_ENTER) {
						
					} else if (! this.releasedShiftKey && ! this.unknowncharacter && e.keyCode != KeyEvent.VK_BACK_SPACE) {
						//Check if the the character was null
						if (e.keyChar != ' ' && (e.keyChar != '\u0000')) {
							//Add the character to the text
							this.text += e.keyChar;
							//Set the cursor time
							this.cursorShown = false;
							this.cursorLastBlink = System.currentTimeMillis();
						}
					} else {
						this.releasedShiftKey = false;
					}
				}
			}
		}
	}
	
	/* The key released event */
	public void onKeyReleased(KeyboardEvent e) {
		//Check if this is visible and selected
		if (this.visible && this.selected) {
			//Check what rendering mode is being used
			if (Settings.Video.OpenGL) {
				//Check what key was pressed
				if (e.keyCode == Keyboard.KEY_BACK) {
					this.backspace = false;
				} else if (e.keyCode == Keyboard.KEY_LSHIFT || e.keyCode == Keyboard.KEY_RSHIFT) {
					this.releasedShiftKey = true;
					this.shift = false;
					this.alreadyHadShift = false;
				}
			} else {
				//Check what key was pressed
				if (e.keyCode == KeyEvent.VK_BACK_SPACE) {
					this.backspace = false;
				} else if (e.keyCode == KeyEvent.VK_SHIFT) {
					this.releasedShiftKey = true;
				}
			}
		}
	}
	
	/* The key typed event */
	public void onKeyTyped(KeyboardEvent e) {
		
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