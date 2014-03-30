/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game3d.model;

import org.simplecorporation.myengine.core.game3d.vector.Vector3D;

public class ModelParserUtils {
	
	/* The method used to get the vector value of a line */
	public static Vector3D getVectorValue(String line) {
		//Split up the line using a space
		String[] split = line.split(" ");
		//Get the vector values
		double vectorX = getValue(split[1]);
		double vectorY = getValue(split[2]);
		double vectorZ = 0;
		//Check to see whether there is a third split (Texture coordinates
		//may only have two values)
		if (split.length == 4)
			vectorZ = getValue(split[3]);
		//Create the vector
		Vector3D vector = new Vector3D(vectorX, vectorY, vectorZ);
		//Return the vector
		return vector;
	}
	
	/* The method used to get the double value of a string */
	public static double getValue(String value) {
		//Return the double
		return Double.parseDouble(value);
	}
	
}