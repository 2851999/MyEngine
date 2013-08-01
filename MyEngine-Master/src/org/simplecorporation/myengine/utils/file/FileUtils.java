package org.simplecorporation.myengine.utils.file;

import java.io.File;
import java.util.LinkedList;

public class FileUtils {
	
	/* Method to get a file path */
	public static String asFileString(String filePath) {
		return new File(filePath).toPath().toString();
	}
	
	/* Method to check if a file exists */
	public static boolean doesFileExist(String filePath) {
		return new File(asFileString(filePath)).exists();
	}
	
	/* Method to check if a file is a file */
	public static boolean isFile(String filePath) {
		return new File(asFileString(filePath)).isFile();
	}
	
	/* Method to check if a file is a directory */
	public static boolean isDirectory(String filePath) {
		return new File(asFileString(filePath)).isDirectory();
	}
	
	/* Method to read a file */
	public static LinkedList<String> read(String filePath) {
		//Create a text file object
		TextFile textFile = new TextFile(filePath);
		//Read the file
		textFile.read();
		//Return the file text
		return textFile.fileText;
	}
	
	/* Method to write a file */
	public static void write(LinkedList<String> fileText , String filePath) {
		//Create a text file object
		TextFile textFile = new TextFile(filePath);
		//Assign the file text
		textFile.fileText = fileText;
		//Write the file
		textFile.write();
	}
	
}