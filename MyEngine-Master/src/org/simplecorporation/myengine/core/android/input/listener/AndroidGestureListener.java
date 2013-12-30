/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android.input.listener;

import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.core.android.input.AndroidInput;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class AndroidGestureListener implements GestureDetector.OnGestureListener , GestureDetector.OnDoubleTapListener , AndroidTouchListener {
	
	/* Gestures */
	public GestureDetector gestures;
	
	/* The constructor */
	public AndroidGestureListener() {
		//Create the gesture detector
		this.gestures = new GestureDetector(AndroidStore.gameActivity , this);
		//Add this input listener
		AndroidInput.androidTouchListeners.add(this);
	}
	
	/* Gesture event method */
	public boolean onDown(MotionEvent e) {
		return true;
	}
	
	/* Gesture event method */
	public boolean onFling(MotionEvent e1 , MotionEvent e2 , float velocityX , float velocityY) {
		return true;
	}
	
	/* Gesture event method */
	public void onLongPress(MotionEvent e) {
		
	}
	
	/* Gesture event method */
	public boolean onScroll(MotionEvent e1 , MotionEvent e2 , float distanceX , float distanceY) {
		return true;
	}
	
	/* Gesture event method */
	public void onShowPress(MotionEvent e) {
		
	}
	
	/* Gesture event method */
	public boolean onSingleTapUp(MotionEvent e) {
		return true;
	}
	
	/* Gesture event method */
	public boolean onDoubleTap(MotionEvent e) {
		return true;
	}
	
	/* Gesture event method */
	public boolean onDoubleTapEvent(MotionEvent e) {
		return true;
	}
	
	/* Gesture event method */
	public boolean onSingleTapConfirmed(MotionEvent e) {
		return true;
	}
	
	/* Gesture event method */
	public void onTouch(MotionEvent event) {
		this.gestures.onTouchEvent(event);
	}
	
}