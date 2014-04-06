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

public enum LogLevel {
	ALL,
	INFORMATION,
	WARNING,
	ERROR,
	DEBUG,
	NONE,
	
	INFORMATION_AND_WARNING,
	INFORMATION_AND_ERROR,
	INFORMATION_AND_WARNING_AND_ERROR,
	INFORMATION_AND_DEBUG,
	INFORMATION_AND_ERROR_AND_DEBUG,
	
	WARNING_AND_ERROR,
	WARNING_AND_DEBUG,
	WARNING_AND_ERROR_AND_DEBUG,
	
	ERROR_AND_DEBUG
}