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

import org.simplecorporation.myengine.core.engine.script.ScriptData;
import org.simplecorporation.myengine.core.engine.script.variable.ScriptVariable;
import org.simplecorporation.myengine.core.gui.GUIPanel;

public class LibraryGUIPanel extends AbstractLibrary {
	
	/* The name of this library */
	public static final String NAME = "GUIPanel";
	
	/* The description of this library */
	public static final String DESCRIPTION = "The GUI Panel Library";
	
	/* The package of this library */
	public static final String PACKAGE = "org.simplecorporation.myengine.core.gui.GUIPanel";
	
	/* The key word of this library */
	public static final String KEYWORD = "GUIPanel";
	
	/* The GUIPanel in this library */
	public GUIPanel guiPanel;
	
	/* The constructor */
	public LibraryGUIPanel() {
		//Call the super constructor
		super(NAME , DESCRIPTION , PACKAGE , KEYWORD);
	}
	
	/* The method called to parse a line of code */
	public void parseCode(String line , LinkedList<ScriptVariable> publicVariables , LinkedList<ScriptVariable> localVariables) {
		//Replace the variables
		line = this.replaceVariables(line , publicVariables, localVariables);
		//Split up the line
		String[] splitLine = line.split(ScriptData.SYNTAX_KEY_WORD_SEPERATOR);
		//Check what the second key word is
		if (splitLine[1].equals("create")) {
			//Create the GUIPanel
			this.guiPanel = new GUIPanel(splitLine[2]);
		} else if (splitLine[1].equals("add")) {
			//The line to parse
			String guiLine = splitLine[2];
			//Loop through all of the lines except the first 3
			for (int a = 3; a < splitLine.length; a++)
				//Add the current split line onto the gui line
				guiLine += " " + splitLine[a];
			//Trim the line
			guiLine.trim();
			//Parse the line
			this.guiPanel.parseLine(guiLine);
		} else if (splitLine[1].equals("show")) {
			//Show the GUIPanel
			this.guiPanel.showPanel();
		} else if (splitLine[1].equals("hide")) {
			//Hide the GUIPanel
			this.guiPanel.hidePanel();
		} else if (splitLine[1].equals("update")) {
			//Update the panel
			this.guiPanel.updatePanel();
		} else if (splitLine[1].equals("render")) {
			//Render the panel
			this.guiPanel.renderPanel();
		}
	}
	
}