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

public class AndroidActivityListener implements AndroidActivityListenerInterface {
	
	/* The default constructor */
	public AndroidActivityListener() {
		//Add this listener to the list of listeners in AndroidActivity
		AndroidActivity.addListener(this);
	}
	
	/* The basic Android activity methods */
	public void activityCreated() {}
	public void activityPaused() {}
	public void activityResumed() {}
	public void activityStopped() {}
	public void activityRestarted() {}
	public void activityDestroy() {}
	
	
}