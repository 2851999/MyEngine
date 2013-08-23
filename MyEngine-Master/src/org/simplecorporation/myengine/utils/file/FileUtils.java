/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class FileUtils {
	
	/* The method that returns the string of a file path */
	public static String asFileString(String filePath) {
		return new File(filePath).toPath().toString();
	}
	
	/* The method that returns whether a file exists */
	public static boolean doesExist(String filePath) {
		return new File(asFileString(filePath)).exists();
	}
	
	/* The method that returns whether a file is a file */
	public static boolean isFile(String filePath) {
		return new File(asFileString(filePath)).isFile();
	}
	
	/* The method that returns whether a file is a directory */
	public static boolean isDirectory(String filePath) {
		return new File(asFileString(filePath)).isDirectory();
	}
	
	/* The method that returns whether a file is hidden */
	public static boolean isHidden(String filePath) {
		return new File(asFileString(filePath)).isHidden();
	}
	
	/* The method that returns whether a file can be read */
	public static boolean canRead(String filePath) {
		return new File(asFileString(filePath)).canRead();
	}
	
	/* The method that returns whether a file can be written in */
	public static boolean canWrite(String filePath) {
		//If it returns false it may be because the file doesn't exist
		//in the first place
		return new File(asFileString(filePath)).canWrite();
	}
	
	/* The method that reads a file */
	public static LinkedList<String> read(String filePath) {
		//The file text
		LinkedList<String> fileText = new LinkedList<String>();
		//Check whether the file exists
		if (doesExist(filePath)) {
			//Check whether the file is a file
			if (isFile(filePath)) {
				//Check whether the file can be read
				if (canRead(filePath)) {
					//Read the file and set the text in the linked list
					try {
						FileReader fileReader = new FileReader(asFileString(filePath));
						BufferedReader bufferedReader = new BufferedReader(fileReader);
						String line = "";
						while ((line = bufferedReader.readLine()) != null) {
							fileText.add(line);
						}
						bufferedReader.close();
						fileReader.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					//Log a message
					Logger.log(new Log("FileUtils read()" , "File cant be read " + filePath , LogType.ERROR));
				}
			} else {
				//Log a message
				Logger.log(new Log("FileUtils read()" , "File not a file " + filePath , LogType.ERROR));
			}
		} else {
			//Log a message
			Logger.log(new Log("FileUtils read()" , "File not found " + filePath , LogType.ERROR));
		}
		//Return the file text
		return fileText;
	}
	
	public static void write(String filePath , LinkedList<String> fileText) {
		//Check if the file path already exists
		if (doesExist(filePath)) {
			//Log a message
			Logger.log(new Log("FileUtils write()" , "File already exists so will be overwritten " + filePath , LogType.WARNING));
		}
		
		try {
			//Write the file
			FileWriter fileWriter = new FileWriter(asFileString(filePath));
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			//Write the first line
			bufferedWriter.write(fileText.get(0));
			for (int a = 1; a < fileText.size(); a++) {
				bufferedWriter.newLine();
				bufferedWriter.write(fileText.get(a));
			}
			
			//Close the objects
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			//Log a message
			Logger.log(new Log("FileUtils write()" , "IOException writing the file " + filePath , LogType.ERROR));
			e.printStackTrace();
		}
	}
	
}