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
import org.simplecorporation.myengine.core.input.KeyboardInput;
import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.Timer;

public class GUITextBox extends GUIComponent {
	
	/* The variables needed by the text box */
	public String text;                 //The text in this text box
	public String defaultText;          //The text displayed when there is no text
	public String renderText;           //The text that should be rendered
	public int visibleTextStartIndex;   //The start index of the viewable text
	public int visibleTextEndIndex;     //The end index of the viewable text
	public long timeBetweenCursorFlash; //The time between each flash of the cursor
	public Timer timer;                 //The timer used to check the time before the next cursor flash
	public boolean cursorShowing;       //Is the cursor showing right now
	public double cursorWidth;          //The width of the cursor
	public int cursorPlace;             //The place within the render text the cursor is
	public Colour cursorColour;         //The colour of the cursor
	public boolean hideCharacters;      //Should the text be masked
	public String maskCharacter;        //The character used to mask the text
	
	/* The constructor */
	public GUITextBox(String name, GUIRenderer renderer) {
		//Call the super constructor
		super(name, renderer);
		//Assign variables
		this.text = "";
		this.defaultText = "";
		this.renderText = "";
		this.visibleTextStartIndex = 0;
		this.visibleTextEndIndex = 0;
		this.timeBetweenCursorFlash = 550;
		this.timer = new Timer();
		this.cursorShowing = true;
		this.cursorWidth = 2;
		this.cursorPlace = 0;
		this.cursorColour = Colour.BLACK;
		this.hideCharacters = false ;
		this.maskCharacter = "*";
	}
	
	/* The method to update the text box */
	protected void updateComponent() {
		//Check to see whether this component is visible
		if (this.visible) {
			//Calculate the view index
			this.calculateViewIndex();
			//Set the render text
			this.setRenderText();
		}
		//Check to see whether this component is visible and selected
		if (this.visible && this.selected) {
			//Check the time
			if (this.timer.hasTimePassed(this.timeBetweenCursorFlash)) {
				//Invert the cursor show boolean
				this.cursorShowing = ! this.cursorShowing;
				//Restart the timer
				this.timer.start();
			}
			//Check the cursor place
			if (this.cursorPlace > this.renderText.length() && this.renderText.length() != 0) {
				//Set the cursor place
				this.cursorPlace = this.renderText.length() + 1;
			}
		}
	}
	
	/* The method to render the text box */
	protected void renderComponent() {
		if (this.visible) {
			//Render the box
			
			//Render the outline
			this.renderIndex = 0;
			this.renderer.render(this);
			
			//Check to see whether to use images
			if (! this.renderer.useImage()) {
				//Render the middle
				this.renderer.render(new Vector2D(this.position.x + 1, this.position.y + 1), this.width - 2, this.height - 2, 1);
			}
			
			//The colour of the text
			Colour renderColour = Colour.WHITE;
			
			//Check if the java font is null
			if (this.renderer.font.javaGUIFont != null)
				//Get the colour
				renderColour = this.renderer.font.javaGUIFont.colour;
			
			//Render the cursor
			this.renderCursor();
			
			//Check if the java font  is null
			if (this.renderer.font.javaGUIFont != null)
				//Set the colour of the font
				this.renderer.font.javaGUIFont.colour = renderColour;
			
			//Render the text
			this.renderer.font.render(this.renderText , this.position.x + 4 ,
					(this.position.y + (this.height / 2)) - (this.renderer.font.getHeight(this.text) / 2));
		}
	}
	
	/* The mouse pressed event */
	public void onMousePressed(MouseEvent e) {
		//Check to see whether this is selected
		if (this.selected) {
			//Check the position of the event
			if (! this.getBounds().contains(e.x, e.y)) {
				//Set selected to false
				this.selected = false;
				//Calculate the view start/end index
				this.calculateViewIndex();
				//Stop and reset the timer
				this.timer.stop();
				this.timer.reset();
			}
		}
	}
	
	/* The mouse clicked event */
	public void onMouseClicked(MouseEvent e) {
		///Check to see whether this is selected
		if (! this.selected) {
			//Check the position of the event
			if (this.getBounds().contains(e.x, e.y)) {
				//Set selected to true
				this.selected = true;
				//Calculate the view start/end index
				this.calculateViewIndex();
				//Set the cursor place
				this.cursorPlace = this.renderText.length();
				//Check to make sure the cursor place is more than or equal to 0
				if (this.cursorPlace <= 0)
					//Substring error's 0 - 1 = -1, 1 - 1 = 0
					this.cursorPlace = 1;
				//Start the timer
				this.timer.start();
			}
		}
	}
	
	/* The key pressed event */
	public void onKeyPressed(KeyboardEvent e) {
		//Make sure this object is visible and selected
		if (this.visible && this.selected) {
			//The length of the current string
			int oldLength = this.text.length();
			//The start view index
			int startViewIndex = this.visibleTextStartIndex;
			//The front of the text
			String front = this.text.substring(0, this.visibleTextStartIndex + (this.cursorPlace));
			//The end of the text
			String end = this.text.substring(this.visibleTextStartIndex + (this.cursorPlace), this.text.length());
			//Set the new text
			this.text = front + e.keyChar + end;
			//Check to see whether the key was backspace
			if (e.getCode() == KeyboardInput.KEY_BACKSPACE_CODE && front.length() > 1) {
				//Remove the character before the 
				this.text = front.substring(0, front.length() - 1) + end;
				//Check the start of the viewing index to decide whether
				//the cursor should be moved back
				if (this.visibleTextStartIndex == 0)
					//Move the cursor back by taking away 1
					this.cursorPlace --;
			}
			//Remove any unwanted characters
			this.removeUnwantedCharacters();
			//Calculate the view index (Causes a glitch)
			//this.calculateViewIndex();
			//Check to see whether the length has decreased
			if (this.text.length() > oldLength && startViewIndex == this.visibleTextStartIndex) {
				//Add 1 to the cursor place
				this.cursorPlace += 1;
			}
		}
	}
	
	/* The key released event */
	public void onKeyReleased(KeyboardEvent e) {
		
	}
	
	/* The key typed event */
	public void onKeyTyped(KeyboardEvent e) {
		
	}
	
	/* The method used to calculate the start and end of the view
	 * index for the end of the render text */
	public void calculateViewIndex() {
		//Check to see whether there is any text
		if (this.text.equals("") && ! this.selected) {
			//Set the start and the end index
			this.visibleTextStartIndex = 0;
			this.visibleTextEndIndex = this.defaultText.length() - 1;
		} else {
			//Set the start and the end index
			this.visibleTextStartIndex = 0;
			this.visibleTextEndIndex = this.text.length() - 1;
			//Set the render text
			this.setRenderText();
			//Continue the loop until the length of the substring is right
			while (this.renderer.font.getWidth(this.renderText) >= this.width - 2) {
				//Add 1 to the start index
				this.visibleTextStartIndex++;
				//Set the render text
				this.setRenderText();
			}
		}
	}
	
	/* The method used to set the render text */
	public void setRenderText() {
		//Check to see whether there is text in the box
		if (this.text.equals("") && ! this.selected)
			//Set the render text
			this.renderText = this.defaultText;
		else {
			//Set the render text
			this.renderText = this.text;
			//Check if the characters should be hidden
			if (this.hideCharacters) {
				//Set the rendered text to nothing
				String newText = "";
				//Loop the text's length
				for (int a = 0; a < this.renderText.length(); a++)
					//Add the masked character
					newText += this.maskCharacter;
				//Set the render text
				this.renderText = newText;
			}
		}
		//Set the render text using the visible text start/end indexes
		this.renderText = this.renderText.substring(this.visibleTextStartIndex, this.visibleTextEndIndex);
	}
	
	/* The method used to render the cursor if needed */
	public void renderCursor() {
		//Check to see whether the cursor should be rendered
		if (this.visible && this.selected && this.cursorShowing) {
			//Set the colour to black
			BasicRenderer.setColour(this.cursorColour);
			//Render the cursor
			BasicRenderer.renderFilledRectangle(this.position.x + this.renderer.font.getWidth(this.renderText.substring(0, this.cursorPlace - 1)) + 4, this.position.y + 2, cursorWidth, this.height - 4);
		}
	}
	
	/* The method used to remove any unwanted null characters in the text */
	public void removeUnwantedCharacters() {
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
	}
	
	/* The method used to set the text in this text box */
	public void setText(String text) {
		//Assign the text
		this.text = text;
		//Calculate the view index
		this.calculateViewIndex();
	}
	
	/* The method used to set the default text in this box */
	public void setDefaultText(String defaultText) {
		//Assign the text
		this.defaultText = defaultText;
		//Calculate the view index
		this.calculateViewIndex();
	}
	
}