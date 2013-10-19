/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script.library;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.engine.script.file.ScriptFile;
import org.simplecorporation.myengine.core.engine.script.variable.ScriptVariable;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class LibraryBasicRenderer extends AbstractLibrary {
	
	/* The name of this library */
	public static final String NAME = "BasicRenderer";
	
	/* The description of this library */
	public static final String DESCRIPTION = "The BasicRenererer Library";
	
	/* The package of this library */
	public static final String PACKAGE = "org.simplecorporation.myengine.core.render.basic.BasicRenderer";
	
	/* The key word of this library */
	public static final String KEYWORD = "br";
	
	/* The constructor */
	public LibraryBasicRenderer() {
		//Call the super constructor
		super(NAME , DESCRIPTION , PACKAGE , KEYWORD);
	}
	
	/* The method called to parse a line of code */
	public void parseCode(ScriptFile currentFile , String currentLine , LinkedList<ScriptVariable> publicVariables , LinkedList<ScriptVariable> localVariables) {
		//Replace the variables
		currentLine = this.replaceVariables(currentFile , currentLine , publicVariables, localVariables);
		//Split up the line
		String[] splitLine = currentLine.split(currentFile.scriptSyntax.SYNTAX_KEY_WORD_SEPARATOR);
		//Check what the second key word is
		if (splitLine[1].equals("set")) {
			//Check what the third key word is
			if (splitLine[2].equals("colour")) {
				//Check what colour the basic renderer should be set to
				if (splitLine.length > 4) {
					//Check the length
					if (splitLine.length == 6) {
						//RGB
						BasicRenderer.setColour(new Colour(Double.parseDouble(splitLine[3]) ,
								Double.parseDouble(splitLine[4]) , Double.parseDouble(splitLine[5]) , 1.0d));
					} else if (splitLine.length == 7) {
						//RGBA
						BasicRenderer.setColour(new Colour(Double.parseDouble(splitLine[3]) ,
								Double.parseDouble(splitLine[4]) , Double.parseDouble(splitLine[5]) ,
								Double.parseDouble(splitLine[6])));
					}
				} else {
					//Check the colour name and set the colour
					if (splitLine[3].equalsIgnoreCase("black"))
						BasicRenderer.setColour(Colour.BLACK);
					else if (splitLine[3].equalsIgnoreCase("red"))
						BasicRenderer.setColour(Colour.RED);
					else if (splitLine[3].equalsIgnoreCase("yellow"))
						BasicRenderer.setColour(Colour.YELLOW);
					else if (splitLine[3].equalsIgnoreCase("pink"))
						BasicRenderer.setColour(Colour.PINK);
					else if (splitLine[3].equalsIgnoreCase("green"))
						BasicRenderer.setColour(Colour.GREEN);
					else if (splitLine[3].equalsIgnoreCase("lightblue"))
						BasicRenderer.setColour(Colour.LIGHT_BLUE);
					else if (splitLine[3].equalsIgnoreCase("blue"))
						BasicRenderer.setColour(Colour.BLUE);
					else if (splitLine[3].equalsIgnoreCase("white"))
						BasicRenderer.setColour(Colour.WHITE);
				}
			}
		} else if (splitLine[1].equals("render")) {
			//Check the next key word
			if (splitLine[2].equals("fill")) {
				//Check the length
				if (splitLine.length > 4) {
					//Check the next key word
					if (splitLine[3].equals("rectangle")) {
						//Render the rectangle
						BasicRenderer.renderFilledRectangle(
								Double.parseDouble(splitLine[4]) ,
								Double.parseDouble(splitLine[5]) ,
								Double.parseDouble(splitLine[6]) ,
								Double.parseDouble(splitLine[7]));
					}
				} else {
					//Check the next key word
					if (splitLine[3].equals("window"))
						//Fill the window
						BasicRenderer.renderFilledRectangle(0 , 0 ,
								Settings.Window.Size.Width , Settings.Window.Size.Height);
				}
			} else if (splitLine[2].equals("outline")) {
				//Check the length
				if (splitLine.length > 4) {
					//Check the next key word
					if (splitLine[3].equals("rectangle")) {
						//Render the rectangle
						BasicRenderer.renderRectangle(
								Double.parseDouble(splitLine[4]) ,
								Double.parseDouble(splitLine[5]) ,
								Double.parseDouble(splitLine[6]) ,
								Double.parseDouble(splitLine[7]));
					}
				} else {
					//Check the next key word
					if (splitLine[3].equals("window"))
						//Fill the window
						BasicRenderer.renderRectangle(0 , 0 ,
								Settings.Window.Size.Width , Settings.Window.Size.Height);
				}
			} else if (splitLine[2].equals("line")) {
				//Render a line
				BasicRenderer.renderLine(
						Double.parseDouble(splitLine[3]) ,
						Double.parseDouble(splitLine[4]) ,
						Double.parseDouble(splitLine[5]) ,
						Double.parseDouble(splitLine[6]));
			}
		}
	}
	
}