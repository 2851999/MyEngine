/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseMotionEvent;
import org.simplecorporation.myengine.core.window.JavaWindow;

public class InputManagerJava implements MouseListener , MouseMotionListener , KeyListener {
	
	/* The method to check the input */
	public void checkInput() {
		//Check the mouse
		checkMouse();
	}
	
	/* The method to check the mouse */
	public void checkMouse() {
		
	}
	
	/* The method to setup the keyboard and mouse */
	public void create() {
		//Add the input listeners
		JavaWindow.frame.addMouseListener(this);
		JavaWindow.frame.addMouseMotionListener(this);
		JavaWindow.frame.addKeyListener(this);
	}
	
	/* The method to destroy the keyboard and mouse */
	public void destroy() {
		
	}
	
	/* Method for key/mouse listeners */
	public void keyPressed(KeyEvent e) {
		//Call the event
		Input.callKeyPressed(new KeyboardEvent(e.getKeyChar() , e.getKeyCode()));
	}
	
	/* Method for key/mouse listeners */
	public void keyReleased(KeyEvent e) {
		//Call the event
		Input.callKeyReleased(new KeyboardEvent(e.getKeyChar() , e.getKeyCode()));
	}
	
	/* Method for key/mouse listeners */
	public void keyTyped(KeyEvent e) {
		//Call the event
		Input.callKeyTyped(new KeyboardEvent(e.getKeyChar() , e.getKeyCode()));
	}
	
	/* Method for key/mouse listeners */
	public void mouseDragged(MouseEvent e) {
		
	}
	
	/* Method for key/mouse listeners */
	public void mouseMoved(MouseEvent e) {
		//Assign the values
		MouseInput.lastX = MouseInput.x;
		MouseInput.lastY = MouseInput.y;
		MouseInput.x = e.getX();
		MouseInput.y = e.getY();
		//Call the event
		Input.callMouseMoved(new MouseMotionEvent(MouseInput.x , MouseInput.y , MouseInput.lastX , MouseInput.lastY));
	}
	
	/* Method for key/mouse listeners */
	public void mouseClicked(MouseEvent e) {
		//Call a mouse clicked event
		Input.callMouseClicked(new org.simplecorporation.myengine.core.input.event.MouseEvent(e.getButton() , e.getX() , e.getY()));
	}
	
	/* Method for key/mouse listeners */
	public void mouseEntered(MouseEvent e) {
		
	}
	
	/* Method for key/mouse listeners */
	public void mouseExited(MouseEvent e) {
		
	}
	
	/* Method for key/mouse listeners */
	public void mousePressed(MouseEvent e) {
		//Check what button it was and assign it
		if (e.getButton() == 0)
			MouseInput.isLeftButtonDown = true;
		else if (e.getButton() == 1)
			MouseInput.isRightButtonDown = true;
		else if (e.getButton() == 2)
			MouseInput.isMiddleButtonDown = true;
		//Call a mouse pressed event
		Input.callMousePressed(new org.simplecorporation.myengine.core.input.event.MouseEvent(e.getButton() , e.getX() , e.getY()));
	}
	
	/* Method for key/mouse listeners */
	public void mouseReleased(MouseEvent e) {
		//Check what button it was and assign it
		if (e.getButton() == 0)
			MouseInput.isLeftButtonDown = false;
		else if (e.getButton() == 1)
			MouseInput.isRightButtonDown = false;
		else if (e.getButton() == 2)
			MouseInput.isMiddleButtonDown = false;
		//Call a mouse released event
		Input.callMouseReleased(new org.simplecorporation.myengine.core.input.event.MouseEvent(e.getButton() , e.getX() , e.getY()));
	}
	
}