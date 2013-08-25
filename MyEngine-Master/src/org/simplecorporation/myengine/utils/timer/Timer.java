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
	
	/* Is the timer running */
	public boolean running;
	
	/* The constructor */
	public Timer() {
		//Set running to false
		this.running = false;
	}
	
	/* The method to get the current time */
	public long getTime() {
		return System.currentTimeMillis();
	}
	
	/* The method to get the time passed */
	public long getTimePasesed() {
		//Check if the timer is running
		if (this.running)
			return this.getTime() - this.startTime;
		else
			return 0;
	}
	
	/* The start method */
	public void start() {
		//Set the start time
		this.startTime = this.getTime();
		//Set running to true
		this.running = true;
	}
	
	/* The reset method */
	public void reset() {
		//Set running to false
		this.running = false;
		//Set the time to 0
		this.startTime = 0;
	}
	
	/* The stop method */
	public void stop() {
		//Set running to false
		this.running = false;
	}
	
	/* The method to check whether a certain length of time
	   has passed */
	public boolean hasTimePassed(long time) {
		//Check if the timer is running
		if (this.running)
			return this.getTime() - this.startTime >= time;
		else
			return false;
	}
	
}