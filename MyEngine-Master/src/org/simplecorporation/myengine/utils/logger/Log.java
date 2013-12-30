/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.logger;

public class Log {
	
	/* The source */
	public String source;
	
	/* The message */
	public String message;
	
	/* The type of message */
	public LogType logType;
	
	/* The constructor */
	public Log(String source , String message , LogType logType) {
		//Assign the variables
		this.source = source;
		this.message = message;
		this.logType = logType;
	}
	
}