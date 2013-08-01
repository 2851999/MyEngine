package org.simplecorporation.myengine.utils.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import org.simplecorporation.myengine.utils.logger.Logger;

public class TextFile {
	
	/* The path of the text file */
	public String filePath;
	
	/* The linked list that stores a file's text */
	public LinkedList<String> fileText = new LinkedList<String>();
	
	/* The constructor */
	public TextFile(String filePath) {
		//Assign the file path
		this.filePath = filePath;
	}
	
	/* The method to read the text file */
	public void read() {
		//Check if the path exists
		if (FileUtils.doesFileExist(this.filePath)) {
			//Check if the file is a file
			if (FileUtils.isFile(this.filePath)) {
				try {
					//The file reader object
					FileReader fileReader = new FileReader(new File(FileUtils.asFileString(this.filePath)));
					//The buffered reader
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					//The current line of the file
					String line = "";
					//Read the file
					while ((line = bufferedReader.readLine()) != null) {
						//Add the line to the file text
						this.fileText.add(line);
					}
					//Close the buffered reader
					bufferedReader.close();
				} catch (FileNotFoundException e) {
					//Log a message
					Logger.log("TextFile read()" , "Exception when reading a file " + this.filePath);
					e.printStackTrace();
				} catch (IOException e) {
					Logger.log("TextFile read()" , "Exception when reading a file " + this.filePath);
					e.printStackTrace();
				}
			} else {
				//Log a message
				Logger.log("TextFile read()" , "File path " + this.filePath + " is not a file");
			}
		} else {
			//Log a message
			Logger.log("TextFile read()" , "File path " + this.filePath + " does not exist!");
		}
	}
	
	/* The method to write the file */
	public void write() {
		try {
			//The file writer
			FileWriter fileWriter = new FileWriter(new File(FileUtils.asFileString(this.filePath)));
			//The buffered writer
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			//Write the first line
			bufferedWriter.write(this.fileText.get(0));
			//Loop the rest of then file text
			for (int a = 1; a < this.fileText.size(); a++) {
				//Start a new line
				bufferedWriter.newLine();
				//Write the current line
				bufferedWriter.write(this.fileText.get(a));
			}
			//Close the buffer
			bufferedWriter.close();
		} catch (IOException e) {
			//Log a message
			Logger.log("TextFile save()" , "Exception when writing a file " + this.filePath);
			e.printStackTrace();
		}
	}
	
}