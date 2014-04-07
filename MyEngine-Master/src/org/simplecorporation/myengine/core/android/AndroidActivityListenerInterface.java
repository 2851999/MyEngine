/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android;

public interface AndroidActivityListenerInterface {
	
	/* The basic Android activity methods */
	public void activityCreated();
	public void activityPaused();
	public void activityResumed();
	public void activityStopped();
	public void activityRestarted();
	public void activityDestroy();
	
}