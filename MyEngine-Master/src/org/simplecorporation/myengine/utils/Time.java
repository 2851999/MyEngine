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

import java.util.GregorianCalendar;

public class Time {
	
	/* The different time formats */
	public static final int FORMAT_12_HOUR = 1;
	public static final int FORMAT_24_HOUR = 2;
	
	/* The static method used to get the current time as a string in the format of
	 * HH:MM:SS using the Gregorian Calendar where the hour is represented in the
	 * format given */
	public static String getTimeHHMMSS(int format) {
		//Return the value of getting the time separated by a ":"
		return getTimeHHMMSS(":", format);
	}
	
	/* The static method used to get the current time as a string in the format of
	 * HH:MM:SS using the Gregorian Calendar where the hour is represented in the
	 * format given */
	public static String getTimeHHMMSS(String separator, int format) {
		//The time string
		String time = "";
		//Set the hours
		time += getHour(format) + separator;
		time += getMinute() + separator;
		time += getSecond();
		//Return the time
		return time;
	}
	
	/* The static method used to get the current hour in the format given */
	public static int getHour(int format) {
		//Check the format
		if (format == FORMAT_12_HOUR)
			//Return the hour in 12 - Hour format
			return getHour12();
		else if (format == FORMAT_24_HOUR)
			//Return the hour in 24 - Hour format
			return getHour24();
		else
			//The format given was not defined therefore return nothing
			return 0;
	}
	
	/* The static method used to get the current hour in 12 - Hour format */
	public static int getHour12() {
		//Return the hour
		return getCalendar().get(GregorianCalendar.HOUR);
	}
	
	/* The static method used to get the current hour in 24 - Hour format */
	public static int getHour24() {
		//Return the hour
		return getCalendar().get(GregorianCalendar.HOUR_OF_DAY);
	}
	
	/* The static method used to get the current minute */
	public static int getMinute() {
		//Return the minute
		return getCalendar().get(GregorianCalendar.MINUTE);
	}
	
	/* The static method used to get the current second */
	public static int getSecond() {
		//Return the second
		return getCalendar().get(GregorianCalendar.SECOND);
	}
	
	/* The static method used to return the time in milliseconds */
	public static long getMillisecond() {
		//Return the current millisecond
		return System.currentTimeMillis();
	}
	
	/* The static method used to create and return an instance of the Gregorian Calendar */
	public static GregorianCalendar getCalendar() {
		//Return a new instance of the Gregorian Calendar
		return new GregorianCalendar();
	}
	
}