/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.timer;

public class Timer {
	
	/* The time the timer started */
	public long startTime;
	
	/* The constructor */
	public Timer() {
		
	}
	
	/* The method to get the current time */
	public long getTime() {
		return System.currentTimeMillis();
	}
	
	/* The method to get the time passed */
	public long getTimePasesed() {
		return this.getTime() - this.startTime;
	}
	
	/* The start method */
	public void start() {
		//Set the start time
		this.startTime = this.getTime();
	}
	
	/* The method to check whether a certain length of time
	   has passed */
	public boolean hasTimePassed(long time) {
		return this.getTime() - this.startTime >= time;
	}
	
}