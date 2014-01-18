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

import org.simplecorporation.myengine.core.gui.GUIComponent;
import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.input.KeyboardInput;
import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.render.colour.Colour;

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
	
	/* The cursor colour */
	public Colour cursorColour;
	
	/* The edit place in the string */
	public int editPlace;
	
	/* The cursor's x position */
	public double cursorX;
	
	/* The font */
	public GUIFont font;
	
	/* The text to be rendered */
	public String renderText;
	
	/* The constructor */
	public GUITextBox(String name, GUIFont font) {
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
		this.cursorColour = Colour.BLACK;
		this.editPlace = 0;
		this.cursorX = 0;
		this.font = font;
		this.renderText = "";
	}
	
	/* The method to update the text box */
	protected void updateComponent() {
		//Check if this is visible
		if (this.visible) {
			//Check if the default text should be rendered
			if (this.text.equals("") && ! this.defaultText.equals("") && ! this.selected) {
				//Set the rendered text
				renderText = this.defaultText;
				//Set the colour
				//renderColour.a = renderColour.a / 2; THIS LINE STOPPED RENDERING (I DONT KNOW HOW TO FIX)
			}
		}
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
			
			//Set the render text
			this.renderText = this.text;
			
			//Check if the characters are hidden
			if (this.hideCharacters) {
				//Set the rendered text to nothing
				renderText = "";
				//Loop the text's length
				for (int a = 0; a < this.text.length(); a++)
					//Add the masked character
					renderText += this.maskCharacter;
			}
			
			int beginIndex = 1;
			//Check to see if the text fits in the box
			if (this.font.getWidth(renderText) > this.width - this.font.fontSize / 2) {
				//Set the render text
				beginIndex = 1;
				//While the text is too long
				while (this.font.getWidth(renderText.substring(beginIndex)) > this.width - this.font.fontSize / 2) {
					//Increase the begin index if possible
					if (renderText.length() > beginIndex + 1)
						beginIndex ++;
				}
				//Set the text
				renderText = renderText.substring(beginIndex);
			}
			
			//Get the front of the string
			String front = this.text.substring(0, this.editPlace);
			//Calculate the x position of the cursor
			this.cursorX = this.position.x + this.font.getWidth(front) + 4;
			
			//Check if the cursor is out of the text box
			if (this.cursorX > this.position.x + this.width && this.editPlace == this.text.length())
				//Calculate the x position of the cursor
				this.cursorX = this.position.x + this.font.getWidth(this.renderText) + 4;
			else if (this.cursorX > this.position.x + this.width) {
				//Get the character at the edit position
				char character = this.text.charAt(this.editPlace - 1);
				//The number of occurrences of this character
				int occurrences = 0;
				//Find the number of occurrences of the character inside of the string
				for (int a = beginIndex; a < this.editPlace; a++) {
					//Check if the current character is the same
					if (this.text.charAt(a) == character) {
						//Increment the occurrences
						occurrences++;
					}
				}
				//Get the front of the string
				String newFront = this.renderText.substring(0, this.renderText.indexOf(character, occurrences) + 1);
				System.out.println(occurrences);
				//Calculate the x position of the cursor
				this.cursorX = (this.position.x + this.font.getWidth(newFront) + 4);
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
				//Set the cursor's x position
				this.cursorX = this.position.x + this.font.getWidth(this.text + 4);
				//Set the edit place
				this.editPlace = this.text.length();
			}
		} else if (this.visible && this.selected) {
			//Set the last cursor blink time
			this.cursorLastBlink = System.currentTimeMillis();
		}
	}
	
	/* The key pressed event */
	public void onKeyPressed(KeyboardEvent e) {
		//Check if this is visible and selected
		if (this.visible && this.selected) {
			//Check what key was pressed
			if (e.keyCode == KeyboardInput.KEY_BACKSPACE_CODE) {
				this.backspace = true;
				//Remove the last letter if there is one
				if (this.text.length() > 0) {
					//Get the beginning and end of the string
					String front = this.text.substring(0, this.editPlace);
					String end = this.text.substring(this.editPlace);
					if (front.length() > 0) {
						this.text = front.substring(0 , front.length() - 1) + end;
						this.editPlace--;
					}
				}
			} else if (e.keyCode == KeyboardInput.KEY_LEFT_CODE) {
				//Check if the edit place is more than 0
				if (this.editPlace > 0) {
					//Change the edit place
					this.editPlace --;
				}
			} else if (e.keyCode == KeyboardInput.KEY_RIGHT_CODE) {
				//Check if the edit place is already at the end
				if (this.editPlace < this.text.length()) {
					//Change the edit place
					this.editPlace ++;
				}
			}
			
			//Make sure the key has a printable character
			if (e.keyChar == '\u0000')
				this.unknowncharacter = true;
			else
				this.unknowncharacter = false;
			
			//Check if using backspace
			if (! this.backspace) {
				//Check it wasn't space
				if (e.keyCode == KeyboardInput.KEY_SPACE_CODE) {
					//Get the beginning and end of the string
					String front = this.text.substring(0, this.editPlace);
					String end = this.text.substring(this.editPlace);
					//Add a space
					this.text = front + " " + end;
					this.editPlace++;
				} else if (e.keyCode == KeyboardInput.KEY_RETURN_CODE) {
					
				} else if (! this.unknowncharacter && e.keyCode != KeyboardInput.KEY_BACKSPACE_CODE) {
					//Check if the the character was null
					if (e.keyChar != ' ' && (e.keyChar != '\u0000')) {
						//Get the beginning and end of the string
						String front = this.text.substring(0, this.editPlace);
						String end = this.text.substring(this.editPlace);
						//Add the character to the text
						this.text = front + e.keyChar + end;
						this.editPlace++;
						//Set the cursor time
						this.cursorShown = false;
						this.cursorLastBlink = System.currentTimeMillis();
					}
				}
			}
		}
	}
	
	/* The key released event */
	public void onKeyReleased(KeyboardEvent e) {
		//Check if this is visible and selected
		if (this.visible && this.selected) {
			//Check what key was pressed
			if (e.keyCode == KeyboardInput.KEY_BACKSPACE_CODE) {
				this.backspace = false;
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