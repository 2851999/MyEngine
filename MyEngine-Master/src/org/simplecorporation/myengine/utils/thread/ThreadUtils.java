/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.thread;

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class ThreadUtils {
	
	/* Method to make the program wait a certain
	 * amount of milliseconds */
	public static void sleep(long milliseconds) {
		//Try and catch statement
		try {
			//Make the system sleep
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			//Log a message
			Logger.log(new Log("ThreadUtils sleep()" , "An interrupted exception has occurred" , LogType.ERROR));
		}
	}
	
}