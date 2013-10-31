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
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;

import org.simplecorporation.myengine.utils.array.ArrayUtils;
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
	
	/* The method to delete a file and return whether it was deleted */
	public static boolean delete(String filePath) {
		return new File(asFileString(filePath)).delete();
	}
	
	/* The method to copy a file and returns whether it was successful*/
	public static boolean copy(String filePath1, String filePath2) {
		try {
			Files.copy(new File(asFileString(filePath1)).toPath(),
					new File(asFileString(filePath2)).toPath(), StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			//Log a message
			Logger.log(new Log("FileUtils copy()", "Error copying file/folder: " + filePath1 + " to " + filePath2 ,
					LogType.ERROR));
			e.printStackTrace();
			return false;
		}
	}
	
	/* The method to move a file and returns whether it was successful*/
	public static boolean move(String filePath1, String filePath2) {
		try {
			Files.move(new File(asFileString(filePath1)).toPath(),
					new File(asFileString(filePath2)).toPath(), StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			//Log a message
			Logger.log(new Log("FileUtils move()", "Error moving file/folder: " + filePath1 + " to " + filePath2 ,
					LogType.ERROR));
			e.printStackTrace();
			return false;
		}
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
	
	/* The method to create a directory and return whether it was successful */
	public static boolean createDir(String dir) {
		return new File(asFileString(dir)).mkdir();
	}
	
	/* The method to create directories and return whether it was successful */
	public static boolean createDirs(String dirs) {
		return new File(asFileString(dirs)).mkdirs();
	}
	
	/* The method to copy a directory and all of its contents */
	public static boolean copyDir(String filePath1 , String filePath2) {
		//The boolean that represents whether it was successful
		boolean wasSuccessful = true;
		
		//All of the individual files to be copied
		LinkedList<String> filesToCopy = new LinkedList<String>();
		
		//All of the individual folders to be created
		LinkedList<String> foldersToCreate = new LinkedList<String>();
		
		//Add all of the files to the list
		addAllFiles(filePath1 , "" , filesToCopy , foldersToCreate);
		
		//Make all of the needed directories
		for (int a = 0; a < foldersToCreate.size(); a++) {
			//Create the current directory
			wasSuccessful = createDirs(filePath2 + foldersToCreate.get(a));
		}
		
		//Try and copy all of the files
		for (int a = 0; a < filesToCopy.size(); a++) {
			//Copy the current file
			wasSuccessful = copy(filePath1 + filesToCopy.get(a) , filePath2 + filesToCopy.get(a));
		}
		
		//Return whether the move went successfully
		return wasSuccessful;
	}
	
	/* The method to copy a directory and all of its contents */
	public static boolean moveDir(String filePath1 , String filePath2) {
		//The boolean that represents whether it was successful
		boolean wasSuccessful = true;
		
		//All of the individual files to be moved
		LinkedList<String> filesToMove = new LinkedList<String>();
		
		//All of the individual folders to be created
		LinkedList<String> foldersToMove = new LinkedList<String>();
		
		//Add all of the files to the list
		addAllFiles(filePath1 , "" , filesToMove , foldersToMove);
		
		//Make all of the needed directories
		for (int a = 0; a < foldersToMove.size(); a++) {
			//Create the current directory
			wasSuccessful = createDirs(filePath2 + foldersToMove.get(a));
		}
		
		//Try and move all of the files
		for (int a = 0; a < filesToMove.size(); a++) {
			//Move the current file
			wasSuccessful = move(filePath1 + filesToMove.get(a) , filePath2 + filesToMove.get(a));
		}
		
		//Return whether the move went successfully
		return wasSuccessful;
	}
	
	/* The method to add all of the file paths in a folder to a linked list */
	public static void addAllFiles(String originalFolderPath , String folderPath , LinkedList<String> files , LinkedList<String> folders) {
		//The list of files in the current directory
		LinkedList<String> filesInCurrentDir = listFiles(originalFolderPath + folderPath);
		
		//Look at all of the files in the current directory
		for (int a = 0; a < filesInCurrentDir.size(); a++) {
			//Get the current files path
			String filePath = folderPath + "/" + filesInCurrentDir.get(a);
			//Check if the current file is a directory
			if (isDirectory(originalFolderPath + "/" + filePath)) {
				//Add the folder to the folders list
				folders.add(filePath);
				//The current file is another directory so recall this method
				addAllFiles(originalFolderPath , filePath , files , folders);
			} else {
				//The current file is a file to be copied so add the current
				//files's path to the files list
				files.add(filePath);
			}
		}
	}
	
	/* The method that returns a list of files in a directory */
	public static LinkedList<String> listFiles(String filePath) {
		//The linked list with the list of the folders contents
		LinkedList<String> listOfFiles = new LinkedList<String>();
		
		//Set the list of files
		listOfFiles = ArrayUtils.toStringLinkedList(new File(asFileString(filePath)).list());
		
		//Return the list of files in the directory
		return listOfFiles;
	}
	
}