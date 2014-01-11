/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script;

import java.util.LinkedList;

import org.simplecorporation.myengine.utils.file.FileUtils;

public class ScriptFile {
	
	/* The file path */
	public String filePath;
	
	/* Is the file in a folder */
	public boolean inFolder;
	
	/* The file text */
	public LinkedList<String> fileText;
	
	/* The constructor */
	public ScriptFile(String filePath , boolean inFolder) {
		//Assign the variables
		this.filePath = filePath;
		this.inFolder = inFolder;
	}
	
	/* The method to read the file */
	public void read() {
		//Read the file and store its contents in the fileText linked list
		this.fileText = FileUtils.read(this.filePath , inFolder);
	}
	
}