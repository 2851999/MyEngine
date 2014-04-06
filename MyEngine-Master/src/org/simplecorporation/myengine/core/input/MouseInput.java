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

/**
 * The MouseInput <code>class</code> contains information about the current
 * status of the Mouse
 */
public class MouseInput {
	
	/* Is a mouse button down */
	/**
	 * This value represents whether the left mouse button is currently pressed
	 */
	public static boolean isLeftButtonDown = false;
	/**
	 * This value represents whether the middle mouse button is currently pressed
	 */
	public static boolean isMiddleButtonDown = false;
	/**
	 * This value represents whether the right mouse button is currently pressed
	 */
	public static boolean isRightButtonDown = false;
	
	/* The last and current position of the mouse */
	/**
	 * This value represents the last x position of the mouse
	 */
	public static double lastX = -1;
	/**
	 * This value represents the last y position of the mouse
	 */
	public static double lastY = -1;
	/**
	 * This value represents the current x position of the mouse
	 */
	public static double x = -1;
	/**
	 * This value represents the current y position of the mouse
	 */
	public static double y = -1;
	
	/* Method to check if a button is down */
	/**
	 * This method uses an integer representing a button  and returns whether that
	 * mouse button is currently pressed. left = 0, right = 1, middle = 2
	 * @param button
	 * @return
	 */
	public static boolean isButtonDown(int button) {
		//Check what button it is then return the value
		if (button == 0)
			return isLeftButtonDown;
		else if (button == 1)
			return isRightButtonDown;
		else if (button == 2)
			return isMiddleButtonDown;
		else
			return false;
	}
	
}