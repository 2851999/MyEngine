/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.opengl.shader;

import org.lwjgl.opengl.ARBShaderObjects;
import org.simplecorporation.myengine.utils.array.ArrayUtils;
import org.simplecorporation.myengine.utils.file.FileUtils;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class OpenGLShaderUtils {
	
	/* The method to create a shader */
	public static int createShader(String shaderFile , int shaderType) {
		//The shader
		int shader = 0;
		//Try and catch statement
		try {
			//Create the shader
			shader = ARBShaderObjects.glCreateShaderObjectARB(shaderType);
			//Check the shader was created
			if (shader == 0) {
				//Log an error
				Logger.log(new Log("MyEngine OpenGLShaderUtils createShader()" , "Error when creating shader with the type " + shaderType , LogType.ERROR));
				//Return 0
				return 0;
			}
			//Load the shader file
			ARBShaderObjects.glShaderSourceARB(shader , ArrayUtils.toStringArray(FileUtils.read(shaderFile)));
			//Compile the shader
			ARBShaderObjects.glCompileShaderARB(shader);
		} catch (Exception e) {
			//Log an error
			Logger.log(new Log("MyEngine OpenGLShaderUtils createShader()" , "Error when creating shader with the file " + shaderFile , LogType.ERROR));
		}
		
		//Return the shader
		return shader;
	}
	
}