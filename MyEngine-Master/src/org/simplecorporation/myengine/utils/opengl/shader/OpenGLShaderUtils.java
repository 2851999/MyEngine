/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.opengl.shader;

import java.util.LinkedList;

import org.lwjgl.opengl.GL20;
import org.simplecorporation.myengine.utils.file.FileUtils;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class OpenGLShaderUtils {
	
	/* The method to create a shader */
	public static int createShader(String shaderFile , int shaderType , boolean inFolder) {
		//The shader
		int shader = 0;
		//Try and catch statement
		try {
			//Create the shader
			shader = GL20.glCreateShader(shaderType);
			//Check the shader was created
			if (shader == 0) {
				//Log an error
				Logger.log(new Log("MyEngine OpenGLShaderUtils createShader()" , "Error when creating shader with the type " + shaderType , LogType.ERROR));
				//Return 0
				return 0;
			}
			//Read the file
			LinkedList<String> shaderFileText = FileUtils.read(shaderFile , inFolder);
			//The shader source
			StringBuilder shaderSource = new StringBuilder();
			//Look at all of the shader file text
			for (int a = 0; a < shaderFileText.size(); a++) {
				//Add onto the shader source
				shaderSource.append(shaderFileText.get(a)).append("\n");
			}
			//Load the shader file
			GL20.glShaderSource(shader , shaderSource);
			//Compile the shader
			GL20.glCompileShader(shader);
		} catch (Exception e) {
			e.printStackTrace();
			//Log an error
			Logger.log(new Log("MyEngine OpenGLShaderUtils createShader()" , "Error when creating shader with the file " + shaderFile , LogType.ERROR));
		}
		
		//Return the shader
		return shader;
	}
	
}