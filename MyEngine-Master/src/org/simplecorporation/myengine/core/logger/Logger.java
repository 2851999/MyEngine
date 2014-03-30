/* ********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.logger;

import java.util.ArrayList;
import java.util.List;

import org.simplecorporation.myengine.utils.Console;

public class Logger {
	
	/* The different lists of logs */
	public static List<String> logs = new ArrayList<String>();
	public static List<String> informationLogs = new ArrayList<String>();
	public static List<String> warningLogs = new ArrayList<String>();
	public static List<String> errorLogs = new ArrayList<String>();
	public static List<String> debugLogs = new ArrayList<String>();
	
	/* The last logs */
	public static String lastLog = "";
	public static String lastInformationLog = "";
	public static String lastWarningLog = "";
	public static String lastErrorLog = "";
	public static String lastDebugLog = "";
	
	/* The log level */
	public static LogLevel logLevel = LogLevel.ALL;
	
	/* The static method used to log a message given the log */
	public static void log(Log log) {
		//Check to see whether the log can be logged
		if (canBeLogged(log)) {
			//Assign the last log values and add the log onto the log lists
			assignLast(log);
			//Print out the log
			Console.println(log.getLog());
		}
	}
	
	/* The static method used to check to see whether the current log
	 * level allows a certain log to be logged */
	public static boolean canBeLogged(Log log) {
		//The boolean that states whether the log can be logged
		boolean canBeLogged = false;
		//Check each condition and assign the correct value
		if (logLevel == LogLevel.ALL)
			canBeLogged = true;
		else if ((
				logLevel == LogLevel.INFORMATION ||
				logLevel == LogLevel.INFORMATION_AND_DEBUG ||
				logLevel == LogLevel.INFORMATION_AND_ERROR ||
				logLevel == LogLevel.INFORMATION_AND_ERROR_AND_DEBUG ||
				logLevel == LogLevel.INFORMATION_AND_WARNING ||
				logLevel == LogLevel.INFORMATION_AND_WARNING_AND_ERROR
				&& log.getType() == LogType.INFORMATION))
			canBeLogged = true;
		else if ((
				logLevel == LogLevel.INFORMATION_AND_WARNING ||
				logLevel == LogLevel.INFORMATION_AND_WARNING_AND_ERROR ||
				logLevel == LogLevel.WARNING ||
				logLevel == LogLevel.WARNING_AND_DEBUG ||
				logLevel == LogLevel.WARNING_AND_ERROR ||
				logLevel == LogLevel.WARNING_AND_ERROR_AND_DEBUG
				&& log.getType() == LogType.WARNING))
			canBeLogged = true;
		else if ((
				logLevel == LogLevel.ERROR ||
				logLevel == LogLevel.INFORMATION_AND_ERROR ||
				logLevel == LogLevel.INFORMATION_AND_ERROR_AND_DEBUG ||
				logLevel == LogLevel.INFORMATION_AND_WARNING_AND_ERROR ||
				logLevel == LogLevel.WARNING_AND_ERROR ||
				logLevel == LogLevel.WARNING_AND_ERROR_AND_DEBUG
				&& log.getType() == LogType.ERROR))
			canBeLogged = true;
		else if ((
				logLevel == LogLevel.DEBUG ||
				logLevel == LogLevel.ERROR_AND_DEBUG ||
				logLevel == LogLevel.INFORMATION_AND_DEBUG ||
				logLevel == LogLevel.INFORMATION_AND_ERROR_AND_DEBUG ||
				logLevel == LogLevel.WARNING_AND_DEBUG ||
				logLevel == LogLevel.WARNING_AND_ERROR_AND_DEBUG
				&& log.getType() == LogType.DEBUG))
			canBeLogged = true;
		//Return the value
		return canBeLogged;
	}
	
	/* The static method used to assign the appropriate 'last' variables
	 * given the log that is about to be printed */
	private static void assignLast(Log log) {
		//For a small bit of performance get the log now
		String logValue = log.getLog();
		//Assign the last log
		lastLog = logValue;
		//Add the log to the list of logs
		logs.add(logValue);
		//Check the log type
		if (log.getType() == LogType.INFORMATION) {
			//Assign the appropriate last log
			lastInformationLog = logValue;
			//Add the log onto the appropriate list of logs
			informationLogs.add(logValue);
		} else if (log.getType() == LogType.WARNING) {
			//Assign the appropriate last log
			lastWarningLog = logValue;
			//Add the log onto the appropriate list of logs
			warningLogs.add(logValue);
		} else if (log.getType() == LogType.ERROR) {
			//Assign the appropriate last log
			lastErrorLog = logValue;
			//Add the log onto the appropriate list of logs
			errorLogs.add(logValue);
		} else if (log.getType() == LogType.DEBUG) {
			//Assign the appropriate last log
			lastDebugLog = logValue;
			//Add the log onto the appropriate list of logs
			debugLogs.add(logValue);
		}
	}
	
}