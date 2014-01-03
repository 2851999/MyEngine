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

public class InputManagerAndroid extends AndroidGestureListener implements AndroidTouchListener {
	
	/* The method to check the input */
	public void checkInput() {
		
	}
	
	/* The method to setup the input */
	public void create() {
		//Add this listener to the other listeners
		AndroidInput.androidTouchListeners.add(this);
	}
	
	/* The method to destroy the keyboard and mouse */
	public void destroy() {
		
	}
	
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
	
	/* Gesture event method */
	public boolean onScroll(MotionEvent e1 , MotionEvent e2 , float distanceX , float distanceY) {
		//Call a scroll event
		Input.callOnScroll(new ScrollEvent(distanceX , distanceY));
		return true;
	}
	
}