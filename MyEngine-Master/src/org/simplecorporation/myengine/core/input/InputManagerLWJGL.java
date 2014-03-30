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

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.input.event.MouseMotionEvent;
import org.simplecorporation.myengine.core.input.event.ScrollEvent;
import org.simplecorporation.myengine.core.logger.Log;
import org.simplecorporation.myengine.core.logger.LogType;
import org.simplecorporation.myengine.core.logger.Logger;

/**
 * The InputManagerLWJGL <code>class</code> is used to manage input for LWJGL
 */
public class InputManagerLWJGL {
	
	/* The method to check the input */
	/**
	 * This method checks for input
	 */
	public static void checkInput() {
		//Check the mouse
		checkMouse();
		//Check the keyboard
		checkKeyboard();
	}
	
	/* The method to check the mouse */
	/**
	 * This method checks for input for the mouse
	 */
	public static void checkMouse() {
		//Check if a mouse button is down
		
		//Left
		if (Mouse.isButtonDown(0)) {
			MouseInput.isLeftButtonDown = true;
			Input.callMousePressed(new MouseEvent(0 , Mouse.getX() , Settings.Window.Size.Height - Mouse.getY()));
		} else if (MouseInput.isLeftButtonDown) {
			MouseInput.isLeftButtonDown = false;
			Input.callMouseReleased(new MouseEvent(0 , Mouse.getX() , Settings.Window.Size.Height - Mouse.getY()));
			Input.callMouseClicked(new MouseEvent(0 , Mouse.getX() , Settings.Window.Size.Height - Mouse.getY()));
		}
		
		//Right
		if (Mouse.isButtonDown(1)) {
			MouseInput.isRightButtonDown = true;
			Input.callMousePressed(new MouseEvent(1 , Mouse.getX() , Settings.Window.Size.Height - Mouse.getY()));
		} else if (MouseInput.isRightButtonDown) {
			MouseInput.isRightButtonDown = false;
			Input.callMouseReleased(new MouseEvent(1 , Mouse.getX() , Settings.Window.Size.Height - Mouse.getY()));
			Input.callMouseClicked(new MouseEvent(1 , Mouse.getX() , Settings.Window.Size.Height - Mouse.getY()));
		}
		
		//Middle
		if (Mouse.isButtonDown(2)) {
			MouseInput.isMiddleButtonDown = true;
			Input.callMousePressed(new MouseEvent(2 , Mouse.getX() , Settings.Window.Size.Height - Mouse.getY()));
		} else if (MouseInput.isMiddleButtonDown) {
			MouseInput.isMiddleButtonDown = false;
			Input.callMouseReleased(new MouseEvent(2 , Mouse.getX() , Settings.Window.Size.Height - Mouse.getY()));
			Input.callMouseClicked(new MouseEvent(2 , Mouse.getX() , Settings.Window.Size.Height - Mouse.getY()));
		}
		
		//Check if the current mouse position is bigger/smaller than the last
		if (MouseInput.lastX != Mouse.getX() ||
				MouseInput.lastY != Settings.Window.Size.Height - Mouse.getY()) {
			//Set the last x and y position
			MouseInput.lastX = MouseInput.x;
			MouseInput.lastY = MouseInput.y;
			MouseInput.x = Mouse.getX();
			MouseInput.y = Settings.Window.Size.Height - Mouse.getY();
			
			//Call a mouse moved event
			Input.callMouseMoved(new MouseMotionEvent(MouseInput.x , MouseInput.y ,
					MouseInput.lastX , MouseInput.lastY));
		}
		
		//Check the scroll wheel
		int dWheel = Mouse.getDWheel();
		if (dWheel != 0)
			//Call a scroll event
			Input.callOnScroll(new ScrollEvent(dWheel , dWheel));
	}
	
	
	/* The method to check the keyboard */
	/**
	 * This method checks for input for the keyboard
	 */
	public static void checkKeyboard() {
		//Enable repeat events (To allow for holding down keys etc.)
		Keyboard.enableRepeatEvents(true);
		//Check for an event
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				//Get the correct key code
				int keyCode = KeyboardInput.convertKeyCode(Keyboard.getEventKey());
				//Call the key event
				KeyboardInput.onKeyPressed(new KeyboardEvent(Keyboard.getEventCharacter() , keyCode));
				//Call a keyboard event
				Input.callKeyPressed(new KeyboardEvent(Keyboard.getEventCharacter() , keyCode));
				KeyboardInput.lastKeyboardEvent = new KeyboardEvent(Keyboard.getEventCharacter() , keyCode);
			} else {
				//Get the correct key code
				int keyCode = KeyboardInput.convertKeyCode(Keyboard.getEventKey());
				//Call the key event
				KeyboardInput.onKeyReleased(new KeyboardEvent(Keyboard.getEventCharacter() , keyCode));
				//Call a keyboard event
				Input.callKeyTyped(KeyboardInput.lastKeyboardEvent);
				Input.callKeyReleased(KeyboardInput.lastKeyboardEvent);
			}
		}
	}
	
	/**
	 * This method creates and sets up input to receive future input events
	 */
	/* The method to setup the keyboard and mouse */
	public static void create() {
		try {
			//Create the keyboard and mouse
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e) {
			//Log a message
			Logger.log(new Log("InputManagerLWJGL create()" , "LWJGLException" , LogType.ERROR));
			e.printStackTrace();
		}
	}
	
	/**
	 * This method destroys the input
	 */
	/* The method to destroy the keyboard and mouse */
	public static void destroy() {
		//Destroy the keyboard and mouse
		Keyboard.destroy();
		Mouse.destroy();
	}
	
}