/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.input.listener;

import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.input.event.MouseMotionEvent;

public interface InputListener {
	
	/* The mouse pressed event */
	public void onMousePressed(MouseEvent e);
	
	/* The mouse released event */
	public void onMouseReleased(MouseEvent e);
	
	/* The mouse clicked event */
	public void onMouseClicked(MouseEvent e);
	
	/* The mouse moved event */
	public void onMouseMoved(MouseMotionEvent e);
	
	/* The mouse dragged event */
	public void onMouseDragged(MouseMotionEvent e);
	
	/* The key pressed event */
	public void onKeyPressed(KeyboardEvent e);
	
	/* The key released event */
	public void onKeyReleased(KeyboardEvent e);
	
	/* The key typed event */
	public void onKeyTyped(KeyboardEvent e);
	
}