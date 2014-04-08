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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.core.logger.Log;
import org.simplecorporation.myengine.core.logger.LogType;
import org.simplecorporation.myengine.core.logger.Logger;

import android.content.Context;
import android.os.Environment;

public class AndroidFileUtils {
	
	/* The different write modes */
	public static final int MODE_INTERNAL_STORAGE = 1;
	public static final int MODE_EXTERNAL_STORAGE = 2;
	public static final int MODE_ASSETS = 3;
	
	/* The static method used to get an instance of a file */
	public static File getFile(String filePath, boolean external) {
		//The directory
		File directory = null;
		//Check to see whether the file is in the external storage
		if (! external)
			//Assign the directory
			directory = AndroidStore.gameActivity.getFilesDir();
		else if (external)
			//Assign the directory
			directory = Environment.getExternalStorageDirectory();
		//Return the file
		return new File(directory, filePath);
	}
	
	/* The static method used to check whether the external storage
	 * is available for read and write */
	public static boolean isExternalStorageWritable() {
		//Check the current external storage state and return the correct value
		return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
	}
	
	/* The static method used to check whether the external storage
	 * is able to read */
	public static boolean isExternalStorageReadable() {
		//Get the external storage state
		String state = Environment.getExternalStorageState();
		//Check the current external storage state and return the correct value
		return Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
	}
	
	/* The static method used to write a file to internal storage */
	public static void writeToInternalStorage(String filePath, List<String> fileText) {
		try {
			//Get the file output stream
			FileOutputStream fileOutputStream = AndroidStore.gameActivity.openFileOutput(filePath, Context.MODE_PRIVATE);
			//Look at all of the text 
			for (int a = 0; a < fileText.size(); a++)
				//Write the next bytes
				fileOutputStream.write(fileText.get(a).getBytes());
			//Close the file output stream
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	/* The static method used to read a file from internal storage */
	public static List<String> readFromInternalStorage(String filePath) {
		//The file text
		List<String> fileText = new ArrayList<String>();
		//Try and catch statement
		try {
			//Read the file
			fileText = FileUtils.read(new BufferedReader(new InputStreamReader(AndroidStore.gameActivity.openFileInput(filePath))));
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		//Return the file text
		return fileText;
	}
	
	/* The static method used to write a file to external storage */
	public static void writeToExternalStorage(String filePath, List<String> fileText) {
		//Make sure the external storage can be written to
		if (isExternalStorageWritable()) {
			//Get the root directory
			File rootDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
			//Get the file name of the file
			String fileName = new File(filePath).getName();
			//Get the file's directory
			File fileDir = new File(filePath.replace(fileName, ""));
			//Make the directories needed
			fileDir.mkdirs();
			//Assign the file directory again
			fileDir = new File(rootDir.getAbsolutePath() + "/" + fileDir);
			//Get the file
			File file = new File(fileDir, fileName);
			try {
				//Get the file output stream
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				//Look at all of the text 
				for (int a = 0; a < fileText.size(); a++) {
					//Write the next bytes
					fileOutputStream.write(fileText.get(a).getBytes());
				}
				//Close the file output stream
				fileOutputStream.close();
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				
			}
		} else {
			//Log an error because the external storage can't write any files
			Logger.log(new Log("AndroidFileUtils writeToInternalStorage()", "External storage not writeable", LogType.ERROR));
		}
	}
	
	/* The static method used to read a file from external storage */
	public static List<String> readFromExternalStorage(String filePath) {
		//The file text
		List<String> fileText = new ArrayList<String>();
		//Make sure the file can be read
		if (isExternalStorageReadable()) {
			//Get the root directory
			File rootDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
			//Get the file name of the file
			String fileName = new File(filePath).getName();
			//Get the file's directory
			File fileDir = new File(filePath.replace(fileName, ""));
			//Assign the file directory again
			fileDir = new File(rootDir.getAbsolutePath() + "/" + fileDir);
			//Get the file
			File file = new File(fileDir, fileName);
			//Try and catch statement
			try {
				//Read the file
				fileText = FileUtils.read(new BufferedReader(new FileReader(file)));
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				
			}
		} else {
			//Log an error because the external storage can't read any files
			Logger.log(new Log("AndroidFileUtils readFromExternalStorage()", "External storage not readable", LogType.ERROR));
		}
		//Return the file text
		return fileText;
	}
	
	/* The static method used to read a file from the assets */
	public static List<String> readFromAssets(String filePath) {
		//The file text
		List<String> fileText = new ArrayList<String>();
		//Try and catch statement
		try {
			//Read the file
			fileText = FileUtils.read(new BufferedReader(new InputStreamReader(AndroidStore.gameActivity.getAssets().open(filePath))));
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		//Return the file text
		return fileText;
	}
	
	/* The static method used to write a file given the mode */
	public static void write(String filePath, List<String> fileText, int mode) {
		//Check the mode
		if (mode == MODE_INTERNAL_STORAGE)
			//Write the file to internal storage
			writeToInternalStorage(filePath, fileText);
		else if (mode == MODE_EXTERNAL_STORAGE)
			//Write the file to external storage
			writeToExternalStorage(filePath, fileText);
		else
			//Log an error
			Logger.log(new Log("AndroidFileUtils write()", "The mode " + mode + " is not defined", LogType.ERROR));
	}
	
	/* The static method used to read a file given the mode */
	public static List<String> read(String filePath, int mode) {
		//Check the mode
		if (mode == MODE_INTERNAL_STORAGE)
			//Read the file from internal storage
			return readFromInternalStorage(filePath);
		else if (mode == MODE_EXTERNAL_STORAGE)
			//Read the file from external storage
			return readFromExternalStorage(filePath);
		else if (mode == MODE_ASSETS)
			//Read the file from the assets
			return readFromAssets(filePath);
		else {
			//Log an error
			Logger.log(new Log("AndroidFileUtils read()", "The mode " + mode + " is not defined", LogType.ERROR));
			//Return null
			return null;
		}
	}
	
	/* The static method used to read a file where isAsset is similar to inFolder */
	public static List<String> read(String filePath, boolean isAsset) {
		//Check to see whether to use the assets or internal storage
		if (isAsset)
			//Read the file from the assets
			return read(filePath, MODE_ASSETS);
		else
			//Read the file from internal storage
			return read(filePath, MODE_INTERNAL_STORAGE);
	}
	
	/* The static method used to write a file */
	public static void write(String filePath, List<String> fileText) {
		//Write in the default place which is the internal storage
		write(filePath, fileText, MODE_INTERNAL_STORAGE);
	}
	
}