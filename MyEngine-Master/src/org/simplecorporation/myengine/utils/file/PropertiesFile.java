package org.simplecorporation.myengine.utils.file;

public class PropertiesFile {
	
	/* The text file object */
	public TextFile textFile;
	
	/* The constructor */
	public PropertiesFile(String filePath) {
		//Create the text file
		this.textFile = new TextFile(filePath);
	}
	
	/* Method to read the file */
	public void read() {
		//Read the text file
		this.textFile.read();
	}
	
	/* Method to write the file */
	public void write() {
		//Write the text file
		this.textFile.write();
	}
	
	/* Method to get a property's line */
	public int getPropertyLine(String key) {
		//The property value
		int propertyLine = 0;
		//Go through the text file's text to find the property
		for (int a = 0; a < this.textFile.fileText.size(); a++) {
			//Check if the current line starts with the right key
			if (this.textFile.fileText.get(a).startsWith(key + ": ")) {
				//Set the line to the current line
				propertyLine = a;
			}
		}
		return propertyLine;
	}
	
	/* Method to get a property's value */
	public String getPropertyValue(String key) {
		//Return the value
		return this.textFile.fileText.get(getPropertyLine(key)).split(": ")[1];
	}
	
	/* Method to set a property's value */
	public void setPropertyValue(String key , String value) {
		//Find and set property
		this.textFile.fileText.set(getPropertyLine(key) , key + ": " + value);
	}
	
	/* Method to add a property */
	public void addProperty(String key , String value) {
		//Add the property to the file
		this.textFile.fileText.add(key + ": " + value);
	}
	
}