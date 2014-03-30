/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils;

public class SystemInfo {
	
	/* The method to get the number of available processors */
	public static int getAvailableProcessors() {
		return Runtime.getRuntime().availableProcessors();
	}
	
	/* The method to get the total memory */
	public static long getTotalMemory() {
		return Runtime.getRuntime().totalMemory();
	}
	
	/* The method to get the free memory */
	public static long getFreeMemory() {
		return Runtime.getRuntime().freeMemory();
	}
	
	/* The method to get the maximum memory that can be used */
	public static long getMaxMemory() {
		return Runtime.getRuntime().maxMemory();
	}
	
}