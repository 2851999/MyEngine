/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.logger;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.file.FileUtils;

public class Logger {
	
	/* The current log level */
	public static LogLevel logLevel = LogLevel.LOG_LEVEL_ALL;
	
	/* Is debugging on */
	public static boolean debugging = false;
	
	/* The logs */
	public static LinkedList<String> logs = new LinkedList<String>();
	
	/* The information logs */
	public static LinkedList<String> informationLogs = new LinkedList<String>();
	
	/* The warning logs */
	public static LinkedList<String> warningLogs = new LinkedList<String>();
	
	/* The error logs logs */
	public static LinkedList<String> errorLogs = new LinkedList<String>();
	
	/* The debug logs */
	public static LinkedList<String> debugLogs = new LinkedList<String>();
	
	/* The last log */
	public static String lastLog = "";
	
	/* The last information log */
	public static String lastInformationLog = "";
	
	/* The last warning log */
	public static String lastWarningLog = "";
	
	/* The last error log */
	public static String lastErrorLog = "";
	
	/* The last debug log */
	public static String lastDebugLog = "";
	
	/* The method used to log a message */
	public static void log(Log log) {
		//Log the log using the IGNORE_NONE property
		log(log, LogIgnore.IGNORE_NONE);
	}
	
	/* The method used to log a message */
	public static void log(Log log, LogIgnore logIgnore) {
		GregorianCalendar date = new GregorianCalendar();
		int seconds = date.get(Calendar.SECOND);
		int minutes = date.get(Calendar.MINUTE);
		int hours   = date.get(Calendar.HOUR);
		//The message
		String message = "";
		//Check what type of log it is
		if (log.logType == LogType.INFORMATION) {
			//Check if the right log level is being used
			if (logLevel == LogLevel.LOG_LEVEL_ALL || logLevel == LogLevel.LOG_LEVEL_INFORMATION ||
					logLevel == LogLevel.LOG_LEVEL_INFORMATION_AND_WARNING || logLevel == LogLevel.LOG_LEVEL_INFORMATION_AND_ERROR) {
				//Set the message
				message = getMessage("[" + hours + ":" + minutes + ":" + seconds + "]", "[INFORMATION]", "[" + log.source + "]", log.message, logIgnore);
				//Add the message to the logs
				logs.add(message);
				informationLogs.add(message);
				//Set the last log
				lastLog = message;
				lastInformationLog = message;
				//Print out the message
				println(message);
			}
		} else if (log.logType == LogType.WARNING) {
			//Check if the right log level is being used
			if (logLevel == LogLevel.LOG_LEVEL_ALL || logLevel == LogLevel.LOG_LEVEL_WARNING ||
					logLevel == LogLevel.LOG_LEVEL_INFORMATION_AND_WARNING || logLevel == LogLevel.LOG_LEVEL_WARNING_AND_ERROR) {
				//Set the message
				message = getMessage("[" + hours + ":" + minutes + ":" + seconds + "]", "[WARNING]", "[" + log.source + "]", log.message, logIgnore);
				//Add the message to the logs
				logs.add(message);
				warningLogs.add(message);
				//Set the last log
				lastWarningLog = message;
				lastWarningLog = message;
				//Print out the message
				println(message);
			}
		} else if (log.logType == LogType.ERROR) {
			//Check if the right log level is being used
			if (logLevel == LogLevel.LOG_LEVEL_ALL || logLevel == LogLevel.LOG_LEVEL_ERROR ||
					logLevel == LogLevel.LOG_LEVEL_WARNING_AND_ERROR || logLevel == LogLevel.LOG_LEVEL_INFORMATION_AND_ERROR) {
				//Set the message
				//Set the message
				message = getMessage("[" + hours + ":" + minutes + ":" + seconds + "]", "[ERROR]", "[" + log.source + "]", log.message, logIgnore);
				//Add the message to the logs
				logs.add(message);
				errorLogs.add(message);
				//Set the last log
				lastLog = message;
				lastErrorLog = message;
				//Print out the message
				println(message);
			}
		} else if (log.logType == LogType.DEBUG) {
			//Check if debugging is enabled
			if (debugging) {
				//Set the message
				//Set the message
				message = getMessage("[" + hours + ":" + minutes + ":" + seconds + "]", "[DEBUG]", "[" + log.source + "]", log.message, logIgnore);
				//Add the message to the logs
				logs.add(message);
				debugLogs.add(message);
				//Set the last log
				lastLog = message;
				lastDebugLog = message;
				//Print out the message
				println(message);
			}
		}
	}
	
	/* The method used to determine the message using the LogIgnore */
	public static String getMessage(String time, String type, String source, String message, LogIgnore logIgnore) {
		//The new message
		String newMessage = "";
		//Check the log ignore
		if (logIgnore == LogIgnore.IGNORE_NONE)
			newMessage = time + type + source + " " + message;
		else if (logIgnore == LogIgnore.IGNORE_TIME)
			newMessage = type + source + " " + message;
		else if (logIgnore == LogIgnore.IGNORE_TYPE)
			newMessage = time + source + " " + message;
		else if (logIgnore == LogIgnore.IGNORE_SOURCE)
			newMessage = time + type + " " + message;
		else if (logIgnore == LogIgnore.IGNORE_TIME_AND_TYPE)
			newMessage = source + " " + message;
		else if (logIgnore == LogIgnore.IGNORE_TIME_AND_SOURCE)
			newMessage = type + " " + message;
		else if (logIgnore == LogIgnore.IGNORE_TYPE_AND_SOURCE)
			newMessage = time + " " + message;
		else if (logIgnore == LogIgnore.IGNORE_ALL)
			newMessage = message;
		//Return the new message
		return newMessage;
	}
	
	/* The method to print out a line */
	public static void println(String message) {
		//Check whether the engine is running on android
		if (Settings.Android)
			android.util.Log.d("MyEngine" , message);
		else if (! Settings.Android)
			System.out.println(message);
	}
	
	/* The method to save the logs */
	public static void saveLogs(String filePath) {
		FileUtils.write(filePath , logs);
	}
	
	/* The method to save the debug logs */
	public static void saveDebugLogs(String filePath) {
		FileUtils.write(filePath , debugLogs);
	}
	
	/* The method to save the information logs */
	public static void saveInformationLogs(String filePath) {
		FileUtils.write(filePath , informationLogs);
	}
	
	/* The method to save the warning logs */
	public static void saveWarningLogs(String filePath) {
		FileUtils.write(filePath , warningLogs);
	}
	
	/* The method to save the error logs */
	public static void saveErrorLogs(String filePath) {
		FileUtils.write(filePath , errorLogs);
	}
	
}