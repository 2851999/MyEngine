/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script.file;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.engine.script.ScriptSyntax;
import org.simplecorporation.myengine.utils.file.FileUtils;

public class ScriptFile {
	
	/* The file path */
	public String filePath;
	
	/* The text in the file */
	public LinkedList<String> fileText;
	
	/* The syntax used in the file */
	public ScriptSyntax scriptSyntax;
	
	/* The constructor */
	public ScriptFile(String filePath) {
		//Assign the file path
		this.filePath = filePath;
		//Create the file text
		this.fileText = new LinkedList<String>();
		//Create the script syntax
		this.scriptSyntax = new ScriptSyntax();
	}
	
	/* The method to read the file */
	public void read() {
		//Read the file
		this.fileText = parseWhitespace(FileUtils.read(this.filePath));
		//Check the first line to see if it should use a specific syntax
		if (this.fileText.get(0).toLowerCase().startsWith("syntax"))
			//Set the syntax
			this.scriptSyntax.setSyntax(this.filePath , this.fileText.get(0));
	}
	
	/* The method to write the file */
	public void write() {
		//Write the file
		FileUtils.write(this.filePath , this.fileText);
	}
	
	/* The method that parses white space */
	public LinkedList<String> parseWhitespace(LinkedList<String> fileTextIn) {
		//The final linked list
		LinkedList<String> fileTextOut = new LinkedList<String>();
		//Loop through the file text in
		for (int a = 0; a < fileTextIn.size(); a++) {
			//Trim the current line and add it to the fileTextOut
			fileTextOut.add(fileTextIn.get(a).trim());
		}
		
		//Return the file text out
		return fileTextOut;
	}
	
	/* The method to set the file text */
	public void setFileText(LinkedList<String> fileText) {
		this.fileText = fileText;
	}
	
	/* The method that returns the file text */
	public LinkedList<String> getFileText() {
		return this.fileText;
	}
	
}