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

public class Timer {
	
	/* The time the timer started */
	public long startTime;
	
	/* The time the timer ended */
	public long endTime;
	
	/* Is the timer running */
	public boolean running;
	
	/* Is the timer paused */
	public boolean paused;
	
	/* The time this timer was paused */
	public long pauseStartTime;
	
	/* The total time this timer has been paused */
	public long totalPauseTime;
	
	/* The constructor */
	public Timer() {
		//Set running to false
		this.running = false;
		//Set paused to false
		this.paused = false;
		//Set the paused time to 0
		this.pauseStartTime = 0;
		//Set the total paused time to 0
		this.totalPauseTime = 0;
		//Set the end time to 0
		this.endTime = 0;
	}
	
	/* The method to get the current time */
	public long getTime() {
		return System.currentTimeMillis();
	}
	
	/* The method to get the time passed */
	public long getTimePassed() {
		//Check if the timer is running
		if (this.running) {
			//Check whether the timer is paused
			if (this.paused)
				return this.pauseStartTime - this.startTime;
			else
				return (this.getTime() - this.startTime) - this.totalPauseTime;
		} else
			return (this.endTime - startTime) - this.totalPauseTime;
	}
	
	/* The pause method */
	public void pause() {
		//Pause the timer
		this.paused = true;
		//Set the paused time
		this.pauseStartTime = this.getTime();
	}
	
	/* The resume method */
	public void resume() {
		//Add the time paused onto the total paused time
		this.totalPauseTime += (this.getTime() - this.totalPauseTime) - this.pauseStartTime;
		//Resume the timer
		this.paused = false;
	}
	
	/* The start method */
	public void start() {
		//Set paused to false
		this.paused = false;
		//Set the paused time to 0
		this.pauseStartTime = 0;
		//Set the total paused time to 0
		this.totalPauseTime = 0;
		//Set the end time to 0
		this.endTime = 0;
		//Set the time to the current time
		this.startTime = this.getTime();
		//Set running to true
		this.running = true;
	}
	
	/* The reset method */
	public void reset() {
		//Set running to false
		this.running = false;
		//Set paused to false
		this.paused = false;
		//Set the paused time to 0
		this.pauseStartTime = 0;
		//Set the total paused time to 0
		this.totalPauseTime = 0;
		//Set the time to 0
		this.startTime = 0;
		//Set the end time to 0
		this.endTime = 0;
	}
	
	/* The stop method */
	public void stop() {
		//Set the end time
		this.endTime = this.getTime();
		//Set running to false
		this.running = false;
	}
	
	/* The method to check whether a certain length of time
	   has passed */
	public boolean hasTimePassed(long time) {
		return this.getTimePassed() >= time;
	}
	
}