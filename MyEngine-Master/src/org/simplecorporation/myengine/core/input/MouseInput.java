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

public class MouseInput {
	
	/* Is a mouse button down */
	public static boolean isLeftButtonDown = false;
	public static boolean isMiddleButtonDown = false;
	public static boolean isRightButtonDown = false;
	
	/* The last and current position of the mouse */
	public static double lastX = -1;
	public static double lastY = -1;
	public static double x = -1;
	public static double y = -1;
	
	/* Method to check if a button is down */
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