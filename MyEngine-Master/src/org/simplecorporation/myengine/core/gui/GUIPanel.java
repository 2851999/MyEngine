/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.gui.builder.GUIBuilder;
import org.simplecorporation.myengine.core.gui.button.GUIRenderableButton;
import org.simplecorporation.myengine.core.gui.loadingbar.GUIRenderableLoadingBar;
import org.simplecorporation.myengine.core.gui.textbox.GUIRenderableTextBox;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.file.FileUtils;
import org.simplecorporation.myengine.utils.font.FontUtils;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class GUIPanel {
	
	/* The name of the panel */
	public String name;
	
	/* The components in the GUI */
	public LinkedList<GUIComponent> components;
	
	/* The constructor */
	public GUIPanel(String name) {
		//Assign the name
		this.name = name;
		//Create the linked list
		this.components = new LinkedList<GUIComponent>();
	}
	
	/* The method to update the GUI */
	public void updatePanel() {
		//Update all of the components
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).update();
	}
	
	/* The method to render the GUI */
	public void renderPanel() {
		//Render all of the components
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).render();
	}
	
	/* The method to show the GUI */
	public void showPanel() {
		//Set all of the components to show
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).visible = true;
	}
	
	/* The method to hide the GUI */
	public void hidePanel() {
		//Set all of the components to hide
		for (int a = 0; a < this.components.size(); a++)
			this.components.get(a).visible = false;
	}
	
	/* The method to add a component */
	public void add(GUIComponent component) {
		//Add the component to the linked list
		this.components.add(component);
	}
	
	/* The method to add components using a file */
	public void parseFile(String filePath) {
		//Read the file
		LinkedList<String> fileText = FileUtils.read(filePath);
		//Go through each line
		for (int a = 0; a < fileText.size(); a++) {
			//Parse the current line
			parseLine(fileText.get(a));
		}
	}
	
	/* The method to parse a line to add a component */
	public void parseLine(String line1) {
		//Split the line
		String[] line = line1.split(" ");
		//Check the first word says
		if (line[0].equals("GUIRenderableButton")) {
			
			/*
			 * CREATE A BUTTON LIKE THIS
			 * GUIRenderableButton name Test_Button Colour.RED Colour.GREEN Colour.BLUE Arial Colour.WHITE 20 100 100 200 200
			 */
			
			//Create the component and add it to this panel
			GUIRenderableButton button = GUIBuilder.createRenderableButton(
					line[1].replace('_' , ' ') , line[2].replace('_' , ' ') ,
					new Colour[] { parseColour(line[3]) , parseColour(line[4]) , parseColour(line[5]) } ,
					FontUtils.buildGUIFont(line[6] , parseColour(line[7]) , Integer.parseInt(line[8])) ,
					Integer.parseInt(line[9]) , Integer.parseInt(line[10]) , Integer.parseInt(line[11]) , Integer.parseInt(line[12]));
			//Add the component to the components
			this.add(button.getBase());
		} else if (line[0].equals("GUIImageButton")) {
		} else if (line[0].equals("GUIRenderableTextBox")) {
			//Check whether it should be masked or not
			if (line.length > 11) {
				//Create the component and add it to this panel
				GUIRenderableTextBox textbox = GUIBuilder.createRenderableTextBox(
						line[1].replace('_' , ' ') ,
						parseColour(line[2]) , parseColour(line[3]) ,
						FontUtils.buildGUIFont(line[4] , parseColour(line[5]) , Integer.parseInt(line[6])) , line[7].charAt(0) ,
						Integer.parseInt(line[8]) , Integer.parseInt(line[9]) , Integer.parseInt(line[10]) , Integer.parseInt(line[11]));
				//Add the component to the components
				this.add(textbox.getBase());
			} else {
				//Create the component and add it to this panel
				GUIRenderableTextBox textbox = GUIBuilder.createRenderableTextBox(
						line[1].replace('_' , ' ') ,
						parseColour(line[2]) , parseColour(line[3]) ,
						FontUtils.buildGUIFont(line[4] , parseColour(line[5]) , Integer.parseInt(line[6])) ,
						Integer.parseInt(line[7]) , Integer.parseInt(line[8]) , Integer.parseInt(line[9]) , Integer.parseInt(line[10]));
				//Add the component to the components
				this.add(textbox.getBase());
			}
		} else if (line[0].equals("GUIImageTextBox")) {
		} else if (line[0].equals("GUIRenderableLoadingBar")) {
			//Create the component and add it to this panel
			GUIRenderableLoadingBar loadingBar = GUIBuilder.createRenderableLoadingBar(
					line[1].replace('_' , ' ') ,
					parseColour(line[2]) , parseColour(line[3]) ,
					Integer.parseInt(line[4]) ,
					Integer.parseInt(line[5]) , Integer.parseInt(line[6]) , Integer.parseInt(line[7]) , Integer.parseInt(line[8]));
			//Add the component to the components
			this.add(loadingBar);
		} else if (line[0].equals("GUIImageLoadingBar")) {
		} else if (line[0].equals("GUIRenderbleCheckBox")) {
		} else if (line[0].equals("GUIImageCheckBox")) {
		}
	}
	
	/* The method to parse a colour and return it */
	private Colour parseColour(String line) {
		//The colour
		Colour colour = new Colour(0.0 , 0.0 , 0.0 , 0.0);
		//Check whether it starts with 'Colour.'
		if (line.startsWith("Colour.")) {
			//Split the line
			String colourString = line.split("Colour.")[1];
			//Check and set the colour
			if (colourString.equalsIgnoreCase("black"))
				colour = Colour.BLACK;
			else if (colourString.equalsIgnoreCase("grey"))
				colour = Colour.GREY;
			else if (colourString.equalsIgnoreCase("light_grey"))
				colour = Colour.LIGHT_GREY;
			else if (colourString.equalsIgnoreCase("red"))
				colour = Colour.RED;
			else if (colourString.equalsIgnoreCase("orange"))
				colour = Colour.ORANGE;
			else if (colourString.equalsIgnoreCase("yellow"))
				colour = Colour.YELLOW;
			else if (colourString.equalsIgnoreCase("pink"))
				colour = Colour.PINK;
			else if (colourString.equalsIgnoreCase("green"))
				colour = Colour.GREEN;
			else if (colourString.equalsIgnoreCase("blue"))
				colour = Colour.BLUE;
			else if (colourString.equalsIgnoreCase("light_blue"))
				colour = Colour.LIGHT_BLUE;
			else if (colourString.equalsIgnoreCase("white"))
				colour = Colour.WHITE;
		} else if (line.startsWith("rgb")) {
			//Get the trimmed value
			String rgbValue = line.substring(4 , line.length() - 1);
			//Split value
			String[] rgbSplit = rgbValue.split(",");
			//Get the r,g,b values and set the colour
			colour = new Colour((double) Integer.parseInt(rgbSplit[0]) / 255 ,
					(double) Integer.parseInt(rgbSplit[1]) / 255 ,
					(double) Integer.parseInt(rgbSplit[2]) /255 ,
					1.0d);
		} else if (line.startsWith("rgba")) {
			//Get the trimmed value
			String rgbaValue = line.substring(5 , line.length() - 1);
			//Split value
			String[] rgbaSplit = rgbaValue.split(",");
			//Get the r,g,b values and set the colour
			colour = new Colour((double) Integer.parseInt(rgbaSplit[0]) / 255 ,
					(double) Integer.parseInt(rgbaSplit[1]) / 255 ,
					(double) Integer.parseInt(rgbaSplit[2]) / 255 ,
					(double) Integer.parseInt(rgbaSplit[3]) / 255);
		}
		//Return the colour
		return colour;
	}
	
	/* The method that returns a component given its name */
	public GUIComponent get(String name) {
		//The component
		GUIComponent component = null;
		//Check the whole list
		for (int a = 0; a < this.components.size(); a++) {
			//Check if it has the right name
			if (this.components.get(a).name.equals(name))
				//Assign the component
				component = this.components.get(a);
		}
		//Check if the component is null
		if (component == null)
			//Log a message
			Logger.log(new Log("GUIPanel get()" , "The component with the name " + name + " was not found" , LogType.ERROR));
		//Return the component
		return component;
	}
	
}