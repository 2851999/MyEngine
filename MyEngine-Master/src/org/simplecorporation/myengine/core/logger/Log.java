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

import org.simplecorporation.myengine.utils.Time;

public class Log {
	
	/* The source of this log */
	public String source;
	
	/* The message in this log */
	public String message;
	
	/* The type of log this is */
	public LogType type;
	
	/* The part of the log to ignore */
	public LogIgnore ignore;
	
	/* The constructor */
	public Log(String source, String message, LogType type) {
		//Assign the variables
		this.source = source;
		this.message = message;
		this.type = type;
		this.ignore = LogIgnore.NONE;
	}
	
	/* The constructor with the LogIgnore instance given */
	public Log(String source, String message, LogType type, LogIgnore ignore) {
		//Assign the variables
		this.source = source;
		this.message = message;
		this.type = type;
		this.ignore = ignore;
	}
	
	/* The method used to get the string value of this log */
	public String getLog() {
		//The string value of this log
		String log = "";
		//Check the ignore value and set the log to appropriate value
		if (this.ignore == LogIgnore.ALL)
			log = this.message;
		else if (this.ignore == LogIgnore.NONE)
			log = "[" + Time.getTimeHHMMSS(Time.FORMAT_24_HOUR) + "][" + this.getTypeString() + "][" + this.source + "] " + message;
		else if (this.ignore == LogIgnore.SOURCE)
			log = "[" + Time.getTimeHHMMSS(Time.FORMAT_24_HOUR) + "][" + this.getTypeString() + "] " + this.message;
		else if (this.ignore == LogIgnore.SOURCE_AND_TYPE)
			log = "[" + Time.getTimeHHMMSS(Time.FORMAT_24_HOUR) + "] " + this.message;
		else if (this.ignore == LogIgnore.TIME)
			log = "[" + this.getTypeString() + "][" + this.source + "] " + this.message;
		else if (this.ignore == LogIgnore.TIME_AND_SOURCE)
			log = "[" + this.getTypeString() + "] " + this.message;
		else if (this.ignore == LogIgnore.TIME_AND_TYPE)
			log = "[" + this.source + "] " + this.message;
		else if (this.ignore == LogIgnore.TYPE)
			log = "[" + Time.getTimeHHMMSS(Time.FORMAT_24_HOUR) + "][" + this.source + "] " + this.message;
		//Return the log
		return log;
	}
	
	/* The method used to get the string value of a log type */
	public String getTypeString() {
		//Check the kind of log this is and return the appropriate value
		if (this.type == LogType.DEBUG)
			return "DEBUG";
		else if (this.type == LogType.ERROR)
			return "ERROR";
		else if (this.type == LogType.INFORMATION)
			return "INFORMATION";
		else if (this.type == LogType.WARNING)
			return "WARNING";
		else
			return "";
	}
	
	/* The 'getter' methods */
	public String getSource() { return this.source; }
	public String getMessage() { return this.message; }
	public LogType getType() { return this.type; }
	
}