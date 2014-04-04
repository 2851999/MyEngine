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
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.font.FontUtils;

public class GUIRenderer {
	
	/* The array of colours */
	public Colour[] colours;
	
	/* The array of images */
	public Image[] images;
	
	/* The font */
	public GUIFont font;
	
	/* The constructor with the colours given */
	public GUIRenderer(Colour[] colours) {
		//Assign the variables
		this.colours = colours;
		this.font = FontUtils.buildGUIFont("Arial", Colour.BLACK, 12);
	}
	
	/* The constructor with the images given */
	public GUIRenderer(Image[] images) {
		//Assign the variables
		this.images = images;
		this.font = FontUtils.buildGUIFont("Arial", Colour.BLACK, 12);
	}
	
	/* The constructor with the colours and font given */
	public GUIRenderer(Colour[] colours, GUIFont font) {
		//Assign the variables
		this.colours = colours;
		this.font = font;
	}
	
	/* The constructor with the images and font given */
	public GUIRenderer(Image[] images, GUIFont font) {
		//Assign the variables
		this.images = images;
		this.font = font;
	}
	
	/* The method used to render the image or colour, filled rectangle
	 * based on the index given by the component given */
	public void render(GUIComponent component) {
		//Render the image or colour filled rectangle
		this.render(component.position, component.width, component.height, component.renderIndex);
	}
	
	/* The method used to render the image or colour, filled rectangle
	 * based on the position, width, height, and render index given */
	public void render(Vector2D position, double width, double height, int renderIndex) {
		//Check whether to use the image or colour
		if (this.useImage()) {
			//Set the colour to white
			BasicRenderer.setColour(Colour.WHITE);
			//Render the image
			BasicRenderer.renderImage(
					this.images[renderIndex],
					position.x,
					position.y,
					width,
					height);
		} else {
			//Set the colour
			BasicRenderer.setColour(this.colours[renderIndex]);
			//Render the filled rectangle
			BasicRenderer.renderFilledRectangle(
					position.x,
					position.y,
					width,
					height);
		}
	}
	
	/* The method used to get the length of the appropriate array */
	public int getLength() {
		//The length
		int length = 0;
		//Check to see whether we should use the images array's length
		if (useImage())
			length = this.images.length;
		else
			length = this.colours.length;
		//Return the length
		return length;
	}
	
	/* The method which states whether to use the images */
	public boolean useImage() {
		//Return true if the images have been set
		return this.images != null;
	}
	
	/* The method used to get an image given its index */
	public Image getImage(int index) {
		//Return the image
		return this.images[index];
	}
	
	/* The method used to get a colour given its index */
	public Colour getColour(int index) {
		//Return the colour
		return this.colours[index];
	}
	
}