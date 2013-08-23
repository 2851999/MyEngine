/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.logger;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Logger {
	
	/* The current log level */
	public static LogLevel logLevel;
	
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
	
	/* The method to log a message */
	public static void log(Log log) {
		GregorianCalendar date = new GregorianCalendar();
		int seconds = date.get(Calendar.SECOND);
		int minutes = date.get(Calendar.MINUTE);
		int hours   = date.get(Calendar.HOUR);
		//Print the message
		System.out.println("[" + hours + ":" + minutes + ":" + seconds + "]" + "[" + log.source + "] " + log.message);
		//The message
		String message = "";
		//Check what type of log it is
		if (log.logType == LogType.INFORMATION) {
			//Check if the right log level is being used
			if (logLevel == LogLevel.LOG_LEVEL_ALL || logLevel == LogLevel.LOG_LEVEL_INFORMATION ||
					logLevel == LogLevel.LOG_LEVEL_INFORMATION_AND_WARNING || logLevel == LogLevel.LOG_LEVEL_INFORMATION_AND_ERROR) {
				//Set the message
				message = "[" + hours + ":" + minutes + ":" + seconds + "]" + "[INFORMATION]" + "[" + log.source + "] " + log.message;
				//Add the message to the logs
				logs.add(message);
				informationLogs.add(message);
				//Set the last log
				lastLog = message;
				lastInformationLog = message;
				//Print out the message
				System.out.println(message);
			}
		} else if (log.logType == LogType.WARNING) {
			//Check if the right log level is being used
			if (logLevel == LogLevel.LOG_LEVEL_ALL || logLevel == LogLevel.LOG_LEVEL_WARNING ||
					logLevel == LogLevel.LOG_LEVEL_INFORMATION_AND_WARNING || logLevel == LogLevel.LOG_LEVEL_WARNING_AND_ERROR) {
				//Set the message
				message = "[" + hours + ":" + minutes + ":" + seconds + "]" + "[WARNING]" + "[" + log.source + "] " + log.message;
				//Add the message to the logs
				logs.add(message);
				warningLogs.add(message);
				//Set the last log
				lastWarningLog = message;
				lastWarningLog = message;
				//Print out the message
				System.out.println(message);
			}
		} else if (log.logType == LogType.ERROR) {
			//Check if the right log level is being used
			if (logLevel == LogLevel.LOG_LEVEL_ALL || logLevel == LogLevel.LOG_LEVEL_ERROR ||
					logLevel == LogLevel.LOG_LEVEL_WARNING_AND_ERROR || logLevel == LogLevel.LOG_LEVEL_INFORMATION_AND_ERROR) {
				//Set the message
				message = "[" + hours + ":" + minutes + ":" + seconds + "]" + "[ERROR]" + "[" + log.source + "] " + log.message;
				//Add the message to the logs
				logs.add(message);
				errorLogs.add(message);
				//Set the last log
				lastLog = message;
				lastErrorLog = message;
				//Print out the message
				System.out.println(message);
			}
		} else if (log.logType == LogType.DEBUG) {
			//Check if debugging is enabled
			if (debugging) {
				//Set the message
				message = "[" + hours + ":" + minutes + ":" + seconds + "]" + "[DEBUG]" + "[" + log.source + "] " + log.message;
				//Add the message to the logs
				logs.add(message);
				debugLogs.add(message);
				//Set the last log
				lastLog = message;
				lastDebugLog = message;
				//Print out the message
				System.out.println(message);
			}
		}
	}
	
}