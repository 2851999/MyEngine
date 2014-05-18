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
	
	/* The method used to get the current user's username */
	public static String getUsername() {
		return System.getenv("USERNAME");
	}
	
	/* The method used to get the java class path */
	public static String getJavaClassPath() {
		return System.getProperty("java.class.path");
	}
	
	/* The method used to get the java home */
	public static String getJavaHome() {
		return System.getProperty("java.home");
	}
	
	/* The method used to get the java vendor */
	public static String getJavaVendor() {
		return System.getProperty("java.vendor");
	}
	
	/* The method used to get the java vendor url */
	public static String getJavaVendorURL() {
		return System.getProperty("java.vendor.url");
	}
	
	/* The method used to get the java version */
	public static String getJavaVersion() {
		return System.getProperty("java.version");
	}
	
	/* The method used to get the os architecture */
	public static String getOSArchitecture() {
		return System.getProperty("os.arch");
	}
	
	/* The method used to get the os name */
	public static String getOSName() {
		return System.getProperty("os.name");
	}
	
	/* The method used to get the os version */
	public static String getOSVersion() {
		return System.getProperty("os.version");
	}
	
	/* The method used to get the users working directory */
	public static String getUserDirectory() {
		return System.getProperty("user.dir");
	}
	
	/* The method used to get the users home directory */
	public static String getUserHome() {
		return System.getProperty("user.home");
	}
	
	/* The method used to get the users home directory */
	public static String getUserAccountName() {
		return System.getProperty("user.name");
	}
	
}