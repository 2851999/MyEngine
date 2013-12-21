/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script.library.game;

import org.simplecorporation.myengine.core.engine.script.ScriptClass;
import org.simplecorporation.myengine.core.engine.script.ScriptLibrary;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class LibraryBasicRenderer extends ScriptLibrary {
	
	/* The library name */
	public static final String LIBRARY_NAME = "LibraryBasicRenderer";
	
	/* The library description */
	public static final String LIBRARY_DESCRIPTION = "Library BasicRenderer (The BasicRenderer library)";
	
	/* The library package */
	public static final String LIBRARY_PACKAGE = "org.sl.java.game.render.BasicRenderer";
	
	/* The library reference */
	public static final String LIBRARY_REFERENCE = "BasicRenderer";
	
	/* The library short reference */
	public static final String LIBRARY_SHORT_REFERENCE = "BR";
	
	/* The constructor */
	public LibraryBasicRenderer() {
		//Call the super constructor
		super(LIBRARY_NAME , LIBRARY_DESCRIPTION , LIBRARY_PACKAGE , LIBRARY_REFERENCE , LIBRARY_SHORT_REFERENCE);
	}
	
	/* The method used to parse code */
	public void parseCode(String line , ScriptClass scriptClass) {
		//Split the current line
		String[] split = line.split(" ");
		//Check the second split
		if (split[1].equals("set")) {
			//Check the third split
			if (split[2].equals("colour")) {
				//Set the colour
				BasicRenderer.setColour(this.getColourFromString(split[3]));
			}
		} else if (split[1].equals("render")) {
			//Check the third split
			if (split[2].equals("line")) {
				//Render a line
				BasicRenderer.renderLine(
						Double.parseDouble(split[3]) ,
						Double.parseDouble(split[4]) ,
						Double.parseDouble(split[5]) ,
						Double.parseDouble(split[6]));
			} else if (split[2].equals("rectangle")) {
				//Render a rectangle
				BasicRenderer.renderRectangle(
						Double.parseDouble(split[3]) ,
						Double.parseDouble(split[4]) ,
						Double.parseDouble(split[5]) ,
						Double.parseDouble(split[6]));
			} else if (split[2].equals("filledrectangle")) {
				//Render a filled rectangle
				BasicRenderer.renderFilledRectangle(
						Double.parseDouble(split[3]) ,
						Double.parseDouble(split[4]) ,
						Double.parseDouble(split[5]) ,
						Double.parseDouble(split[6]));
			} else if (split[2].equals("fill")) {
				//Render a filled rectangle
				BasicRenderer.renderFilledRectangle(
						0 ,
						0 ,
						Settings.Window.Size.Width ,
						Settings.Window.Size.Height);
			}
		}
	}
	
	/* The method to get a colour from a string */
	private Colour getColourFromString(String string) {
		//The colour
		Colour colour = new Colour(0 , 0 , 0 , 0);
		//Check whether the string is a colour
		if (string.equals("BLACK")) {
			//Set the colour
			colour = Colour.BLACK;
		} else if (string.equals("GREY")) {
			//Set the colour
			colour = Colour.GREY;
		} else if (string.equals("LIGHT_GREY")) {
			//Set the colour
			colour = Colour.LIGHT_GREY;
		} else if (string.equals("RED")) {
			//Set the colour
			colour = Colour.RED;
		} else if (string.equals("ORANGE")) {
			//Set the colour
			colour = Colour.ORANGE;
		} else if (string.equals("YELLOW")) {
			//Set the colour
			colour = Colour.YELLOW;
		} else if (string.equals("PINK")) {
			//Set the colour
			colour = Colour.PINK;
		} else if (string.equals("GREEN")) {
			//Set the colour
			colour = Colour.GREEN;
		} else if (string.equals("BLUE")) {
			//Set the colour
			colour = Colour.BLUE;
		} else if (string.equals("LIGHT_BLUE")) {
			//Set the colour
			colour = Colour.LIGHT_BLUE;
		} else if (string.equals("WHITE")) {
			//Set the colour
			colour = Colour.WHITE;
		} else if (string.startsWith("rgb(")) {
			//Get the colour split
			String[] colourSplit = string.substring(3 , string.length() - 1).split(",");
			//Set the colour
			colour = new Colour(
					Integer.parseInt(colourSplit[0]) ,
					Integer.parseInt(colourSplit[1]) ,
					Integer.parseInt(colourSplit[2]));
		} else if (string.startsWith("rgba(")) {
			//Get the colour split
			String[] colourSplit = string.substring(4 , string.length() - 1).split(",");
			//Set the colour
			colour = new Colour(
					Integer.parseInt(colourSplit[0]) ,
					Integer.parseInt(colourSplit[1]) ,
					Integer.parseInt(colourSplit[2]) ,
					Integer.parseInt(colourSplit[3]));
		}
		//Return the colour
		return colour;
	}
	
	/* The method used to return a new instance of this library */
	public ScriptLibrary getInstance() {
		return new LibraryBasicRenderer();
	}
	
}