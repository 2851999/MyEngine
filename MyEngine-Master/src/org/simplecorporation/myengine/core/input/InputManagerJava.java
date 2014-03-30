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
import org.simplecorporation.myengine.core.render.RenderVariablesJava;
import org.simplecorporation.myengine.core.window.JavaWindow;

/**
 * The InputManagerjava <code>class</code> is used to manage input on PC
 * using pure Java
 */
public class InputManagerJava implements MouseListener , MouseMotionListener , MouseWheelListener , KeyListener {
	
	/* The method to check the input */
	/**
	 * This method checks for input
	 */
	public void checkInput() {
		//Check the mouse
		checkMouse();
	}
	
	/* The method to check the mouse */
	/**
	 * This method checks for input for the mouse
	 */
	public void checkMouse() {
		
	}
	
	/* The method to setup the keyboard and mouse */
	/**
	 * This method creates and sets up input to receive future input events
	 */
	public void create() {
		//Add the input listeners
		RenderVariablesJava.container.addMouseListener(this);
		RenderVariablesJava.container.addMouseMotionListener(this);
		RenderVariablesJava.container.addMouseWheelListener(this);
		RenderVariablesJava.container.addKeyListener(this);
	}
	
	/* The method to destroy the keyboard and mouse */
	/**
	 * This method destroys the input
	 */
	public void destroy() {
		
	}
	
	/* Method for key/mouse listeners */
	/**
	 * This method is called when a key pressed event has occurred
	 * @param e The KeyEvent
	 */
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
	/**
	 * This method is called when a key released event has occurred
	 * @param e The KeyEvent
	 */
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
	/**
	 * This method is called when a key typed event has occurred
	 * @param e The KeyEvent
	 */
	public void keyTyped(KeyEvent e) {
		
	}
	
	/* Method for key/mouse listeners */
	/**
	 * This method is called when a mouse dragged event has occurred
	 * @param e The MouseEvent
	 */
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
	/**
	 * This method is called when a mouse moved event has occurred
	 * @param e The MouseEvent
	 */
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
	/**
	 * This method is called when a mouse clicked event has occurred
	 * @param e The MouseEvent
	 */
	public void mouseClicked(MouseEvent e) {
		/*
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
		*/
	}
	
	/* Method for key/mouse listeners */
	/**
	 * This method is called when a mouse entered event has occurred
	 * @param e The MouseEvent
	 */
	public void mouseEntered(MouseEvent e) {
		
	}
	
	/* Method for key/mouse listeners */
	/**
	 * This method is called when a mouse exited event has occurred
	 * @param e The MouseEvent
	 */
	public void mouseExited(MouseEvent e) {
		
	}
	
	/* Method for key/mouse listeners */
	/**
	 * This method is called when a mouse pressed event has occurred
	 * @param e The MouseEvent
	 */
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
		
		//Call a mouse pressed event
		Input.callMousePressed(new org.simplecorporation.myengine.core.input.event.MouseEvent(e.getButton() , x , y));
	}
	
	/* Method for key/mouse listeners */
	/**
	 * This method is called when a mouse released event has occurred
	 * @param e The MouseEvent
	 */
	public void mouseReleased(MouseEvent e) {
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
	
	/**
	 * This method is called when a mouse wheel moved event has occurred
	 * @param e The MouseWheelEvent
	 */
	/* Method for mouse wheel */
	public void mouseWheelMoved(MouseWheelEvent e) {
		//Call a scroll event (* to make sure it is negative when going towards user)
		Input.callOnScroll(new ScrollEvent(e.getScrollAmount() * e.getWheelRotation() , e.getScrollAmount() * e.getWheelRotation()));
	}
	
}