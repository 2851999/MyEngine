/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.physics2d;

import org.simplecorporation.myengine.core.game2d.vector.Vector2D;

public class PhysicsUtils {
	
	/* The method used to calculate the dot product of two vectors */
	public static double calculateDotProduct(Vector2D vector1, Vector2D vector2) {
		//Calculate and return the dot product
		return (vector1.x * vector2.x + vector1.y * vector2.y);
	}
	
	/* The method used to clamp a value */
	public static double clampValue(double min, double max, double value) {
		//Check the value against the minimum and maximum values
		if (value < min) return min;
		else if (value > max) return max;
		//Return 0
		return 0;
	}
	
}