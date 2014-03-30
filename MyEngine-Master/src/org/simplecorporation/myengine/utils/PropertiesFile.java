/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils;

import java.util.LinkedList;

public class PropertiesFile {
	
	/* The file name */
	public String filePath;
	
	/* Is the file in a folder */
	public boolean inFolder;
	
	/* The text in the file */
	public LinkedList<String> fileText;
	
	/* The constructor */
	public PropertiesFile() {
		//Assign the values
		this.filePath = "";
		this.inFolder = true;
		this.fileText = new LinkedList<String>();
	}
	
	/* The constructor with the file name given */
	public PropertiesFile(String filePath , boolean inFolder) {
		//Assign the values
		this.filePath = filePath;
		this.inFolder = inFolder;
		this.fileText = new LinkedList<String>();
	}
	
	/* The method to read the file assuming the filePath has been set */
	public void read() {
		//Assign the file text
		this.fileText = FileUtils.read(this.filePath , this.inFolder);
	}
	
	/* The method to read the file given its path */
	public void read(String filePath , boolean inFolder) {
		//Assign the file text
		this.fileText = FileUtils.read(filePath , inFolder);
	}
	
	
	/* The method to save the file assuming the filePath has been set */
	public void write() {
		//Write the file
		FileUtils.write(this.filePath , this.fileText);
	}
	
	/* The method to save the file given its path */
	public void write(String filePath) {
		//Write the file to the file path
		FileUtils.write(filePath , this.fileText);
	}
	
	/* The method to add a property */
	public void addProperty(String propertyName , String propertyValue) {
		//Add the property to the file text
		this.fileText.add(propertyName + ": " + propertyValue);
	}
	
	/* The method to get a property */
	public String getProperty(String propertyName) {
		//The property's value
		String propertyValue = "";
		//Set the property's value
		propertyValue = this.fileText.get(this.getPropertyLine(propertyName)).split(propertyName + ": ")[1];
		//Return the property's value
		return propertyValue;
	}
	
	/* The method to get the line a property is on */
	private int getPropertyLine(String propertyName) {
		//The line the property is on
		int propertyLine = 0;
		//Loop through the file text
		for (int a = 0; a < this.fileText.size(); a++) {
			//Check if the property is on this line
			if (this.fileText.get(a).startsWith(propertyName + ": ")) {
				//Set the property line
				propertyLine = a;
				//Exit the loop
				break;
			}
		}
		//Return the line
		return propertyLine;
	}
	
	/* The method to set a property */
	public void setProperty(String propertyName , String propertyValue) {
		//The property's line
		int propertyLine = this.getPropertyLine(propertyName);
		//Set the value
		this.fileText.set(propertyLine , propertyName + ": " + propertyValue);
	}
	
	/* The method to set the file path */
	public void setFilePath(String filePath) {
		//Set the file path
		this.filePath = filePath;
	}
	
}