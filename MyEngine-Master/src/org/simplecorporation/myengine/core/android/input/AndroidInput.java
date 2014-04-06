/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android.input;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.android.input.listener.AndroidTouchListener;

import android.view.MotionEvent;

public class AndroidInput {
	
	/* The touch listeners */
	public static LinkedList<AndroidTouchListener> androidTouchListeners = new LinkedList<AndroidTouchListener>();
	
	/* The method call a touch event */
	public static void callTouchEvent(MotionEvent e) {
		//For loop
		for (int a = 0; a < androidTouchListeners.size(); a++) {
			//Call the event
			androidTouchListeners.get(a).onTouch(e);
		}
	}
	
}