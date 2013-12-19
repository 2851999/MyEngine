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
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseMotionEvent;
import org.simplecorporation.myengine.core.input.event.ScrollEvent;
import org.simplecorporation.myengine.core.window.JavaWindow;

public class InputManagerJava implements MouseListener , MouseMotionListener , MouseWheelListener , KeyListener {
	
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
		JavaWindow.frame.addMouseWheelListener(this);
		JavaWindow.frame.addKeyListener(this);
	}
	
	/* The method to destroy the keyboard and mouse */
	public void destroy() {
		
	}
	
	/* Method for key/mouse listeners */
	public void keyPressed(KeyEvent e) {
		//Get the correct key code
		int keyCode = KeyboardInput.convertKeyCode(e.getKeyCode());
		//Call the key event
		KeyboardInput.onKeyPressed(new KeyboardEvent(e.getKeyChar() , keyCode));
		//Call the event
		Input.callKeyPressed(new KeyboardEvent(e.getKeyChar() , keyCode));
		//Set the keyboard event in the KeyboardInput class
		KeyboardInput.lastKeyboardEvent = new KeyboardEvent(e.getKeyChar() , keyCode);
	}
	
	/* Method for key/mouse listeners */
	public void keyReleased(KeyEvent e) {
		//Get the correct key code
		int keyCode = KeyboardInput.convertKeyCode(e.getKeyCode());
		//Call the key event
		KeyboardInput.onKeyReleased(new KeyboardEvent(e.getKeyChar() , keyCode));
		//Call the event
		Input.callKeyReleased(new KeyboardEvent(e.getKeyChar() , keyCode));
		//Call the event
		Input.callKeyTyped(new KeyboardEvent(e.getKeyChar() , keyCode));
	}
	
	/* Method for key/mouse listeners */
	public void keyTyped(KeyEvent e) {
		
	}
	
	/* Method for key/mouse listeners */
	public void mouseDragged(MouseEvent e) {
		//Get the x and y positions
		double x = e.getX() - JavaWindow.frame.getInsets().left;
		double y = e.getY() - JavaWindow.frame.getInsets().top;
		//Assign the values
		MouseInput.lastX = MouseInput.x;
		MouseInput.lastY = MouseInput.y;
		MouseInput.x = x;
		MouseInput.y = y;
	}
	
	/* Method for key/mouse listeners */
	public void mouseMoved(MouseEvent e) {
		//Get the x and y positions
		double x = e.getX() - JavaWindow.frame.getInsets().left;
		double y = e.getY() - JavaWindow.frame.getInsets().top;
		//Assign the values
		MouseInput.lastX = MouseInput.x;
		MouseInput.lastY = MouseInput.y;
		MouseInput.x = x;
		MouseInput.y = y;
		//Call the event
		Input.callMouseMoved(new MouseMotionEvent(MouseInput.x , MouseInput.y , MouseInput.lastX , MouseInput.lastY));
	}
	
	/* Method for key/mouse listeners */
	public void mouseClicked(MouseEvent e) {
		//Get the x and y positions
		double x = e.getX() - JavaWindow.frame.getInsets().left;
		double y = e.getY() - JavaWindow.frame.getInsets().top;
		//The id of the button
		int id = -1;
		//Check what button it is
		if (e.getButton() == MouseEvent.BUTTON1)
			id = 0;
		else if (e.getButton() == MouseEvent.BUTTON2)
			id = 2;
		else if (e.getButton() == MouseEvent.BUTTON3)
			id = 1;
		
		//Call a mouse clicked event
		Input.callMouseClicked(new org.simplecorporation.myengine.core.input.event.MouseEvent(id , x , y));
	}
	
	/* Method for key/mouse listeners */
	public void mouseEntered(MouseEvent e) {
		
	}
	
	/* Method for key/mouse listeners */
	public void mouseExited(MouseEvent e) {
		
	}
	
	/* Method for key/mouse listeners */
	public void mousePressed(MouseEvent e) {
		//Get the x and y positions
		double x = e.getX() - JavaWindow.frame.getInsets().left;
		double y = e.getY() - JavaWindow.frame.getInsets().top;
		//The id of the button
		int id = -1;
		//Check what button it is
		if (e.getButton() == MouseEvent.BUTTON1)
			id = 0;
		else if (e.getButton() == MouseEvent.BUTTON2)
			id = 2;
		else if (e.getButton() == MouseEvent.BUTTON3)
			id = 1;
		
		//Check what button it was and assign it
		if (id == 0)
			MouseInput.isLeftButtonDown = true;
		else if (id == 1)
			MouseInput.isRightButtonDown = true;
		else if (id == 2)
			MouseInput.isMiddleButtonDown = true;
		
		//Call a mouse clicked event
		Input.callMouseClicked(new org.simplecorporation.myengine.core.input.event.MouseEvent(id , x , y));
		
		//Call a mouse pressed event
		Input.callMousePressed(new org.simplecorporation.myengine.core.input.event.MouseEvent(e.getButton() , x , y));
	}
	
	/* Method for key/mouse listeners */
	public void mouseReleased(MouseEvent e) {
		//Get the x and y positions
		double x = e.getX() + JavaWindow.frame.getInsets().left;
		double y = e.getY() + JavaWindow.frame.getInsets().top;
		//The id of the button
		int id = -1;
		//Check what button it is
		if (e.getButton() == MouseEvent.BUTTON1)
			id = 0;
		else if (e.getButton() == MouseEvent.BUTTON2)
			id = 2;
		else if (e.getButton() == MouseEvent.BUTTON3)
			id = 1;
		
		//Check what button it was and assign it
		if (id == 0)
			MouseInput.isLeftButtonDown = false;
		else if (id == 1)
			MouseInput.isRightButtonDown = false;
		else if (id == 2)
			MouseInput.isMiddleButtonDown = false;
		
		//Call a mouse clicked event
		Input.callMouseClicked(new org.simplecorporation.myengine.core.input.event.MouseEvent(id , x , y));
		//Call a mouse released event
		Input.callMouseReleased(new org.simplecorporation.myengine.core.input.event.MouseEvent(e.getButton() , x , y));
	}
	
	/* Method for mouse wheel */
	public void mouseWheelMoved(MouseWheelEvent e) {
		//Call a scroll event (* to make sure it is negative when going towards user)
		Input.callOnScroll(new ScrollEvent(e.getScrollAmount() * e.getWheelRotation() , e.getScrollAmount() * e.getWheelRotation()));
	}
	
}