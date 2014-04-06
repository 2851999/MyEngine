/* ********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.logger.Log;
import org.simplecorporation.myengine.core.logger.LogType;
import org.simplecorporation.myengine.core.logger.Logger;

public class FileUtils {
	
	/* The static method used to get a file */
	public static File getFile(String filePath) {
		//Check the Android setting
		if (Settings.Android)
			//Return the file
			return new File(filePath);
		else
			//Return the file
			return new File(asFileString(filePath));
	}
	
	/* The static method that returns the string of a file path */
	public static String asFileString(String filePath) {
		return new File(filePath).toPath().toString();
	}

	/* The static method that returns whether a file exists */
	public static boolean doesExist(String filePath) {
		return getFile(filePath).exists();
	}

	/* The static method that returns whether a file is a file */
	public static boolean isFile(String filePath) {
		return getFile(filePath).isFile();
	}

	/* The static method that returns whether a file is a directory */
	public static boolean isDirectory(String filePath) {
		return getFile(filePath).isDirectory();
	}

	/* The static method that returns whether a file is hidden */
	public static boolean isHidden(String filePath) {
		return getFile(filePath).isHidden();
	}

	/* The static method that returns whether a file can be read */
	public static boolean canRead(String filePath) {
		return getFile(filePath).canRead();
	}

	/* The static method that returns whether a file can be written in */
	public static boolean canWrite(String filePath) {
		//If it returns false it may be because the file doesn't exist
		//in the first place
		return getFile(filePath).canWrite();
	}

	/* The static method to delete a file and return whether it was deleted */
	public static boolean delete(String filePath) {
		return getFile(filePath).delete();
	}

	/* The static method to copy a file and returns whether it was successful*/
	public static boolean copy(String filePath1, String filePath2) {
		try {
			Files.copy(getFile(filePath1).toPath(),
					getFile(filePath2).toPath(), StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			//Log a message
			Logger.log(new Log("FileUtils copy()", "Error copying file/folder: " + filePath1 + " to " + filePath2 ,
					LogType.ERROR));
			e.printStackTrace();
			return false;
		}
	}

	/* The static method to move a file and returns whether it was successful*/
	public static boolean move(String filePath1, String filePath2) {
		try {
			Files.move(getFile(filePath1).toPath(),
					getFile(filePath2).toPath(), StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			//Log a message
			Logger.log(new Log("FileUtils move()", "Error moving file/folder: " + filePath1 + " to " + filePath2 ,
					LogType.ERROR));
			e.printStackTrace();
			return false;
		}
	}

	/* The static method that reads a file */
	public static List<String> read(String filePath , boolean inFolder) {
		//The file text
		List<String> fileText = new ArrayList<String>();
		//Make sure this isn't on Android
		if (! Settings.Android) {
			//Check if it is in a folder
			if (inFolder) {
				//Check whether the file exists
				if (doesExist(filePath)) {
					//Check whether the file is a file
					if (isFile(filePath)) {
						//Check whether the file can be read
						if (canRead(filePath)) {
							//Read the file and set the text in the linked list
							try {
								//Assign the file path
								filePath = asFileString(filePath);
								FileReader fileReader = new FileReader(filePath);
								//Read the file
								fileText = read(new BufferedReader(fileReader));
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
			} else {
				//Read the file and set the text in the linked list
				try {
					//Read the file
					fileText = read(new BufferedReader(new InputStreamReader(FileUtils.class.getResourceAsStream(filePath))));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			//Read the file
			fileText = AndroidFileUtils.read(filePath, ! inFolder);
		}
		//Return the file text
		return fileText;
	}

	public static void write(String filePath , List<String> fileText) {
		//Check if the file path already exists
		if (doesExist(filePath)) {
			//Log a message
			Logger.log(new Log("FileUtils write()" , "File already exists so will be overwritten " + filePath , LogType.WARNING));
		}
		
		//Make sure this is not on Android
		if (! Settings.Android) {
			try {
				//Assign the file path
				filePath = asFileString(filePath);
				//Write the file
				FileWriter fileWriter = new FileWriter(filePath);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

				//Make sure there is text to save (Prevents IndexOutOfBoundsException)
				if (fileText.size() > 0) {
					//Write the first line
					bufferedWriter.write(fileText.get(0));
					for (int a = 1; a < fileText.size(); a++) {
						bufferedWriter.newLine();
						bufferedWriter.write(fileText.get(a));
					}
				}

				//Close the objects
				bufferedWriter.close();
				fileWriter.close();
			} catch (IOException e) {
				//Log a message
				Logger.log(new Log("FileUtils write()" , "IOException writing the file " + filePath , LogType.ERROR));
				e.printStackTrace();
			}
		} else {
			//Write the file on Android using the default mode
			AndroidFileUtils.write(filePath, fileText);
		}
	}

	/* The static method to create a directory and return whether it was successful */
	public static boolean createDir(String dir) {
		return getFile(dir).mkdir();
	}

	/* The static method to create directories and return whether it was successful */
	public static boolean createDirs(String dirs) {
		return getFile(dirs).mkdirs();
	}

	/* The static method to copy a directory and all of its contents */
	public static boolean copyDir(String filePath1 , String filePath2) {
		//The boolean that represents whether it was successful
		boolean wasSuccessful = true;

		//All of the individual files to be copied
		List<String> filesToCopy = new ArrayList<String>();

		//All of the individual folders to be created
		List<String> foldersToCreate = new ArrayList<String>();

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

	/* The static method to copy a directory and all of its contents */
	public static boolean moveDir(String filePath1 , String filePath2) {
		//The boolean that represents whether it was successful
		boolean wasSuccessful = true;

		//All of the individual files to be moved
		List<String> filesToMove = new ArrayList<String>();

		//All of the individual folders to be created
		List<String> foldersToMove = new ArrayList<String>();

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

	/* The static method to add all of the file paths in a folder to a linked list */
	public static void addAllFiles(String originalFolderPath , String folderPath , List<String> files , List<String> folders) {
		//The list of files in the current directory
		List<String> filesInCurrentDir = listFiles(originalFolderPath + folderPath);

		//Look at all of the files in the current directory
		for (int a = 0; a < filesInCurrentDir.size(); a++) {
			//Get the current files path
			String filePath = folderPath + "/" + filesInCurrentDir.get(a);
			//Check if the current file is a directory
			if (isDirectory(originalFolderPath + "/" + filePath)) {
				//Add the folder to the folders list
				folders.add(filePath);
				//The current file is another directory so recall this static method
				addAllFiles(originalFolderPath , filePath , files , folders);
			} else {
				//The current file is a file to be copied so add the current
				//files's path to the files list
				files.add(filePath);
			}
		}
	}

	/* The static method that returns a list of files in a directory */
	public static List<String> listFiles(String filePath) {
		//The list with the list of the folders contents
		List<String> listOfFiles = ArrayUtils.toStringList(getFile(filePath).list());

		//Return the list of files in the directory
		return listOfFiles;
	}
	
	/* The static method used to read some text using a buffered reader */
	public static List<String> read(BufferedReader bufferedReader) throws IOException {
		//The file text list
		List<String> fileText = new ArrayList<String>();
		//The current line being read
		String line = "";
		//Keep going until the end of the file
		while ((line = bufferedReader.readLine()) != null)
			//Add the current line to the file text list
			fileText.add(line);
		bufferedReader.close();
		//Return the file text
		return fileText;
	}
	
}