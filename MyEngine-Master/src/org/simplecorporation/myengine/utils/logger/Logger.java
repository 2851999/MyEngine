package org.simplecorporation.myengine.utils.logger;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Logger {
	
	/* The method to log a message */
	public static void log(String source , String message) {
		GregorianCalendar date = new GregorianCalendar();
		int seconds = date.get(Calendar.SECOND);
		int minutes = date.get(Calendar.MINUTE);
		int hours   = date.get(Calendar.HOUR);
		//Print the message
		System.out.println("[" + hours + ":" + minutes + ":" + seconds + "]" + "[" + source + "] " + message);
	}
	
}