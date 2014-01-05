/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.input;

import org.simplecorporation.myengine.core.android.input.AndroidInput;
import org.simplecorporation.myengine.core.android.input.listener.AndroidGestureListener;
import org.simplecorporation.myengine.core.android.input.listener.AndroidTouchListener;
import org.simplecorporation.myengine.core.input.event.ScrollEvent;
import org.simplecorporation.myengine.core.input.event.TouchEvent;

import android.view.MotionEvent;

/**
 * The InputManagerAndroid <code>class</code> is used to manage input on
 * Android
 */
public class InputManagerAndroid extends AndroidGestureListener implements AndroidTouchListener {
	
	/**
	 * This method checks for input
	 */
	/* The method to check the input */
	public void checkInput() {
		
	}
	
	/**
	 * This method creates and sets up input to receive future input events
	 */
	/* The method to setup the input */
	public void create() {
		//Add this listener to the other listeners
		AndroidInput.androidTouchListeners.add(this);
	}
	
	/**
	 * This method destroys the input
	 */
	/* The method to destroy the keyboard and mouse */
	public void destroy() {
		
	}
	
	/**
	 * This method is called when a touch event has occurred
	 * @param e A motion event
	 */
	/* The onTouch method called when an event has occurred */
	public void onTouch(MotionEvent e) {
		//Get the event number
		int event = -1;
		if (e.getAction() == MotionEvent.ACTION_DOWN)
			event = 0;
		else if (e.getAction() == MotionEvent.ACTION_UP)
			event = 1;
		//Call a touch event
		Input.callOnTouch(new TouchEvent(event , e.getX() , e.getY()));
		
		//Set the MouseInput variables (For GUI)
		if (e.getAction() == MotionEvent.ACTION_DOWN)
			MouseInput.isLeftButtonDown = true;
		else if (e.getAction() == MotionEvent.ACTION_UP)
			MouseInput.isLeftButtonDown = false;
		
		MouseInput.lastX = MouseInput.x;
		MouseInput.lastY = MouseInput.y;
		MouseInput.x = e.getX();
		MouseInput.y = e.getY();
	}
	
	/**
	 * This method is called when a mouse dragged event has occurred
	 * @param e1 The first motion event
	 * @param e2 The second motion event
	 * @param distanceX The scroll distance along the x axis
	 * @param distanceY The scroll distance along the y axis
	 */
	/* Gesture event method */
	public boolean onScroll(MotionEvent e1 , MotionEvent e2 , float distanceX , float distanceY) {
		//Call a scroll event
		Input.callOnScroll(new ScrollEvent(distanceX , distanceY));
		return true;
	}
	
}