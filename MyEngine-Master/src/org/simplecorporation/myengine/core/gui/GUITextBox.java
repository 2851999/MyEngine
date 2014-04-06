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

import org.simplecorporation.myengine.core.game2d.vector.Vector2D;
import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.input.KeyboardInput;
import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.Timer;
import org.simplecorporation.myengine.utils.font.FontUtils;

/* NOTES FROM DEVELOPMENT
 * 
 * Creating textboxes so far has been a complete nightmare.
 * 
 * - To avoid problems with text being inputed in the wrong place,
 *   be sure to update the text to render, when something is changed
 * 
 * - To avoid problems with flickering of text while typing, be sure
 *   to update the text to render, before rendering the text
 *   
 * - To add a cursor, to get the index of the cursor from the
 *   textToRender, use cursorPlace - viewIndexStart
 *   NOTE: This does not print out a constant value, therefore
 *   could cause bugs, look for fix while implementing
 *   rendering of the cursor
 * */

public class GUITextBox extends GUIComponent {
	
	/* The text in this text box */
	public String text;
	public String textToRender;
	
	/* The required things for a masked text box */
	public boolean masked;
	public String maskString;
	
	/* The required things for moving the cursor */
	public int cursorPlace;
	
	/* The index of then start and end of the viewable text 
	 * within the text */
	private int viewIndexStart;
	private int viewIndexEnd;
	
	/* The required things for rendering the cursor */
	public Timer cursorTimer;
	public long cursorTimeBetweenFlash;
	public double cursorWidth;
	public Colour cursorColour;
	public boolean cursorShowing;
	
	/* The required things for rendering the default text */
	public String defaultText;
	public GUIFont defaultTextFont;
	
	/* The constructor */
	public GUITextBox(String name, GUIRenderer renderer) {
		//Call the super constructor
		super(name, renderer);
		
		//Assign the default values for the text
		this.text = "";
		this.textToRender = "";
		
		//Assign the default values for the mask
		this.masked = false;
		this.maskString = "*";
		
		//Assign the default value for moving the cursor
		this.cursorPlace = 0;
		
		//Assign the default index values for the viewable text
		this.viewIndexStart = 0;
		this.viewIndexEnd = 0;
		
		//Assign the default values for rendering the cursor
		this.cursorTimer = new Timer();
		this.cursorTimeBetweenFlash = 500;
		this.cursorWidth = 1;
		this.cursorColour = Colour.BLACK;
		this.cursorShowing = false;
		
		//Assign the default values for the default text
		this.defaultText = "";
		this.defaultTextFont = FontUtils.buildGUIFont("Arial", new Colour(0, 0, 0, 0.5), 12);
	}
	
	/* The method to update the text box */
	protected void updateComponent() {
		
	}
	
	/* The method to render the text box */
	protected void renderComponent() {
		//Render the outline
		this.renderIndex = 0;
		this.renderer.render(this);
		//Render the fill
		this.renderer.render(new Vector2D(this.position.x + 1, this.position.y + 1), this.width - 2, this.height - 2, 1);
		
		//Render the text
		this.renderText();
		
		//Check and render the cursor if necessary
		this.checkCursor();
	}
	
	/* The method used to render the text */
	private void renderText() {
		//Update the text to render for rendering
		this.updateTextToRender();
		//Render the text
		//x = current position with an offset of 2
		//y = current position + (height - height of text) with an offset of 4
		//to make sure the text is rendered with the bottom of the text box being the bottom
		//line
		this.getCurrentFont().render(this.textToRender,
				this.position.x + 2,
				this.position.y + (this.height - this.renderer.font.getHeight(this.textToRender)) - 4);
	}
	
	/* The method used to render the cursor */
	private void renderCursor() {
		//Update the text to render for rendering
		this.updateTextToRender();
		//The text before the cursor
		String textBeforeCursor = this.textToRender.substring(0, this.cursorPlace - this.viewIndexStart);
		
		//The x position of the cursor
		double cursorX = this.position.x + this.renderer.font.getWidth(textBeforeCursor) + 4;
		double cursorY = (this.position.y + this.height) - this.renderer.font.getHeight(textBeforeCursor) - 2;
		double cursorHeight = this.height - 4;
		
		//Set the colour
		BasicRenderer.setColour(this.cursorColour);
		
		//Render the cursor
		BasicRenderer.renderFilledRectangle(cursorX, cursorY, cursorWidth, cursorHeight);
	}
	
	/* The mouse pressed event */
	public void onMousePressed(MouseEvent e) {
		//Check to see whether this is visible and selected
		if (this.visible && this.selected) {
			//Check to see whether this has been clicked
			if (! this.getBounds().contains(e.x, e.y)) {
				//Set selected to false since something else was clicked
				this.selected = false;
				//Stop and reset the timer
				this.cursorTimer.stop();
				this.cursorTimer.reset();
				//Make sure the cursor is hidden
				this.cursorShowing = false;
			} else {
				//Move the cursor
				this.moveCursor(e.x);
			}
		} else if (this.visible) {
			//Check to see whether this has been clicked
			if (this.getBounds().contains(e.x, e.y)) {
				//Set selected to true since the click occurred
				//within this textbox's bounds
				this.selected = true;
				//Stop, reset and start the timer
				this.cursorTimer.stop();
				this.cursorTimer.reset();
				this.cursorTimer.start();
				//Move the cursor to the correct position
				this.moveCursor(e.x);
				//Make sure the cursor is showing
				this.cursorShowing = true;
			}
		}
	}
	
	/* The mouse clicked event */
	public void onMouseClicked(MouseEvent e) {
		
	}
	
	/* The key pressed event */
	public void onKeyPressed(KeyboardEvent e) {
		//Makes sure this textbox is visible and selected
		if (this.visible && this.selected) {
			//Make sure the character for the current letter is
			//not unwanted
			if (! this.isUnwantedCharacter(e.getCharacter())) {
				//Get the first part of the text
				String first = this.text.substring(0, this.cursorPlace);
				//Get the second part of the text
				String second = this.text.substring(this.cursorPlace);
				//Add onto the text in this textbox
				this.text = first + e.getCharacter() + second;
				
				//Update the text to render
				this.updateTextToRender();
				
				//Make sure the text will fit in the textbox
				if (this.doesFit(this.text))
					//Add onto the cursor place
					this.cursorPlace++;
				//Update the text
				this.updateTextToRender();
			} else if (e.getCode() == KeyboardInput.KEY_BACKSPACE_CODE) {
				//Get the first part of the text
				String first = this.text.substring(0, this.cursorPlace);
				//Get the second part of the text
				String second = this.text.substring(this.cursorPlace);
				//Remove the last character in the text in this textbox if there is any before the cursor
				if (first.length() > 0) {
					//Remove a character of the text from this textbox
					this.text = first.substring(0, first.length() - 1) + second;
					
					//Check the viewing index's start
					if (this.viewIndexStart > 0) {
						//Shift the viewing index to the left by 1
						this.shiftViewingIndex(-1);
						
						//This because the cursor is the position from within the
						//text and not the textToRender
						this.cursorPlace--;
					} else {
						//Subtract from the cursor place
						this.cursorPlace--;
						
						//Subtract from the end index
						this.viewIndexEnd--;
					}
					
					//Update the text to render
					this.updateTextToRender();
				}
			} else if (e.getCode() == KeyboardInput.KEY_DELETE_CODE) {
				//Get the first part of the text
				String first = this.text.substring(0, this.cursorPlace);
				//Get the second part of the text
				String second = this.text.substring(this.cursorPlace);
				//Remove the next character in the text in this textbox if there is any after the cursor
				if (second.length() > 0) {
					//Remove a character of the text from this textbox
					this.text = first + second.substring(1);
					
					//Check the start index
					if (this.viewIndexStart > 0)
						//Shift the viewing index left by 1
						this.shiftViewingIndex(-1);
					else
						//Subtract from the end index
						this.viewIndexEnd--;
					
					//Update the text to render
					this.updateTextToRender();
				}
			} else if (e.getCode() == KeyboardInput.KEY_LEFT_CODE) {
				//Update the text
				this.updateTextToRender();
				
				//Get the first part of the text
				String first = this.text.substring(0, this.cursorPlace);
				
				//Check the length of the first part of the text and the cursor
				//is more than the start of the text currently being rendered
				if (first.length() > 0 && this.cursorPlace > this.viewIndexStart) {
					//Move the cursor to the left
					this.cursorPlace--;
				} else if (this.viewIndexStart > 0) {
					//Shift the viewing index to the left by 1
					this.shiftViewingIndex(-1);
					//Make sure the cursor place is more than 0
					if (this.cursorPlace > 0)
						//Move the cursor backwards since the cursor place is for the
						//text and not the text to render
						this.cursorPlace--;
				}
				
				//Update the text
				this.updateTextToRender();
			} else if (e.getCode() == KeyboardInput.KEY_RIGHT_CODE) {
				//Update the text
				this.updateTextToRender();
				
				//Get the last part of the text
				String second = this.text.substring(this.cursorPlace);
				//Check the length of the second part of the text and the cursor
				//is less than the end of the text currently being rendered
				if (second.length() > 0 && this.cursorPlace < this.viewIndexEnd)
					//Move the cursor to the right
					this.cursorPlace++;
				else if (this.viewIndexEnd > this.text.length()) {
					//Shift the viewing index to the right by 1
					this.shiftViewingIndex(1);
					//Make sure the cursor place is less than the length of the text
					if (this.cursorPlace < this.text.length())
						//Move the cursor forwards since the cursor place is for the
						//text and not the text to render
						this.cursorPlace++;
				}
				
				//Update the text
				this.updateTextToRender();
			}
		}
	}
	
	/* The key released event */
	public void onKeyReleased(KeyboardEvent e) {
		
	}
	
	/* The key typed event */
	public void onKeyTyped(KeyboardEvent e) {
		
	}
	
	/* The method used to check the cursor's timer and render the cursor if
	 * necessary */
	private void checkCursor() {
		//Make sure this textbox is visible and selected
		if (this.visible && this.selected) {
			//Check the timer
			if (this.cursorTimer.hasTimePassed(this.cursorTimeBetweenFlash)) {
				//Toggle the cursorShowing boolean
				this.cursorShowing = ! this.cursorShowing;
				//Stop, reset and start the timer
				this.cursorTimer.stop();
				this.cursorTimer.reset();
				this.cursorTimer.start();
			}
			
			//Check to see whether the cursor is showing
			if (this.cursorShowing)
				//Render the cursor
				this.renderCursor();
		}
	}
	
	/* The method used to check to see whether a character is unwanted */
	private boolean isUnwantedCharacter(char character) {
		//Check to see whether the character is unwanted
		if (character == '\u0000' ||
				! Character.isDefined(character) ||
				Character.isISOControl(character))
			//Return true
			return true;
		//Return false if this method has not already returned true
		return false;
	}
	
	/* The method used to get masked text */
	private String getMaskedText(String text, String maskString) {
		//The masked text
		String maskedText = "";
		//Repeat this process for the length of the text
		for (int a = 0; a < text.length(); a++)
			//Add the mask string onto the masked text
			maskedText += maskString;
		//Return the masked text
		return maskedText;
	}
	
	/* The method used to check to see whether some text will fit in this
	 * textbox */
	public boolean doesFit(String text) {
		return this.renderer.font.getWidth(textToRender) < this.width - 4;
	}
	
	/* The method used to update the text to render */
	private void updateTextToRender() {
		//Calculate the text to render
		this.calculateTextToRender();
		//Trim the text to render if needed
		this.trimTextToRender();
	}
	
	/* The method that calculates and sets the text to render */
	private void calculateTextToRender() {
		//Check to see whether default text should be used
		if (this.useDefaultText()) {
			//Set the text to be rendered
			this.textToRender = this.defaultText;
		} else {
			//Set text to be rendered
			this.textToRender = this.text.substring(this.viewIndexStart, this.viewIndexEnd);
			
			//Check to see whether this textbox is suppose to be masked
			if (this.masked)
				//Mask the text to be rendered
				this.textToRender = this.getMaskedText(this.textToRender, this.maskString);
		}
	}
	
	/* The method that trims the text to render */
	private void trimTextToRender() {
		//Check if the cursor is at the beginning of the render text
		if (this.viewIndexStart == this.cursorPlace) {
			//Set the view index start to the cursor place
			this.viewIndexStart = this.cursorPlace;
			//Set the end of the viewing index to the length of the string
			this.viewIndexEnd = this.text.length();
			//Keep going while the text is too big for this textbox
			while (! this.doesFit(this.textToRender)) {
				//Subtract 1 from the viewing index end
				this.viewIndexEnd--;
				//Re-calculate the text to render
				this.calculateTextToRender();
			}
		} else if (this.cursorPlace == this.viewIndexEnd) {
			//Set the view index start to 0
			this.viewIndexStart = 0;
			//Set the view index end to the cursor place
			this.viewIndexEnd = this.cursorPlace;
			//Calculate the text to render
			this.calculateTextToRender();
			//Keep going while then text is too big for this textbox
			while (! this.doesFit(this.textToRender)) {
				//Add 1 to the viewing index start
				this.viewIndexStart++;
				//Re-calculate the text to render
				this.calculateTextToRender();
			}
			//Add 1 to the viewing index start
			this.viewIndexStart++;
			//Re-calculate the text to render
			this.calculateTextToRender();
		} else {
			//Set the end of the viewing index to the length of the string
			this.viewIndexEnd = this.text.length();
			//Keep going while the text is too big for this textbox
			while (! this.doesFit(this.textToRender)) {
				//Increment the viewing index start
				this.viewIndexStart++;
				//Re-calculate the text to render
				this.calculateTextToRender();
			}
			//When calculating the position, the new text rendered could be smaller
			//in size than the previous because an 'm' might be removed while an
			//'l' is added therefore reducing the size, to battle this
			//loop continuously untill the cursorPlace is < the start index
			while (this.cursorPlace < this.viewIndexStart)
				//Add onto the cursor place
				this.cursorPlace++;
		}
	}
	
	/* The method used to shift the viewing index by a certain value */
	private void shiftViewingIndex(int amount) {
		//Shift the start and end viewing index's
		this.viewIndexStart += amount;
		this.viewIndexEnd += amount;
	}	

	/* The method used to move the cursor to a specific place given the x
	 * coordinate */
	public void moveCursor(double x) {
		//Update the textToRender for rendering since we need to look at
		//what the user can see
		this.updateTextToRender();
		//Get the text to render as an array
		char[] textValue = this.textToRender.toCharArray();
		//The current string
		String currentString = "";
		//The new cursor place
		int newPlace = 0;
		//Go through the texts
		for (int a = 0; a < textValue.length; a++) {
			//Add onto the current string
			currentString += textValue[a];
			
			//The x position to look for
			double lookX = 0;
			
			//The width of the string
			double widthOfString = this.renderer.font.getWidth(currentString);
			//The width of the last character
			double widthOfLastCharacter = this.renderer.font.getWidth(currentString.substring(currentString.length() - 1));
			
			//Add onto lookX the position this textbox starts rendering the text
			lookX += this.position.x + 2;
			//Add onto lookX the width of the string - (the width of the last character / 2)
			lookX += widthOfString - (widthOfLastCharacter / 2);
			
			//Check the width of the string against the x position
			if (lookX < x)
				//Add 1 to the new place
				newPlace++;
			else
				//Exit the loop
				break;
		}
		//Assign the cursor's position relative to all of the text
		//in this textbox
		this.cursorPlace = this.viewIndexStart + newPlace;
	}
	
	/* The method used to check whether the default text should be used */
	private boolean useDefaultText() {
		return (! this.selected && this.text.length() == 0 && this.defaultText.length() > 0);
	}
	
	/* The method used to get the correct font currently being used */
	public GUIFont getCurrentFont() {
		//Check the situation
		if (this.useDefaultText())
			//Return the default font
			return this.defaultTextFont;
		else 
			//Return the font defined in the renderer for this textbox
			return this.renderer.font;
	}
	
	/* The 'setter' and 'getter' methods */
	public void setText(String text) { this.text = text; this.updateTextToRender(); }
	public void setMasked(boolean masked) { this.masked = masked; }
	public void setMask(String mask) { this.maskString = mask; }
	public void setCursorTimeBetweenFlash(long time) { this.cursorTimeBetweenFlash = time; }
	public void setCursorWidth(double cursorWidth) { this.cursorWidth = cursorWidth; }
	public void setCursorColour(Colour cursorColour) { this.cursorColour = cursorColour; }
	public void setDefaultText(String defaultText) { this.defaultText = defaultText; }
	public void setDefaultTextFont(GUIFont defaultTextFont) { this.defaultTextFont = defaultTextFont; }
	
	public String getText() { return this.text; }
	public boolean isMasked() { return this.masked; }
	public String getMask() { return this.maskString; }
	public long getCursorTimeBetweenFlash() { return this.cursorTimeBetweenFlash; }
	public double getCursorWidth() { return this.cursorWidth; }
	public Colour getCursorColour() { return this.cursorColour; }
	public String getDefaultText() { return this.defaultText; }
	public GUIFont getDefaultTextFont() { return this.defaultTextFont; }
	
}