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

import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.simplecorporation.myengine.core.logger.Log;
import org.simplecorporation.myengine.core.logger.LogType;
import org.simplecorporation.myengine.core.logger.Logger;
import org.simplecorporation.myengine.utils.FileUtils;

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
			List<String> shaderFileText = FileUtils.read(shaderFile , inFolder);
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
			
			//Check for an error
			if (GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
				//Log an error message
				Logger.log(new Log("MyEngine OpenGLShaderUtils createShader()", "Error compiling the shader " + shaderFile, LogType.ERROR));
				Logger.log(new Log("ShaderInformation", getLogInformation(shader), LogType.ERROR));
			}
		} catch (Exception e) {
			e.printStackTrace();
			//Log an error
			Logger.log(new Log("MyEngine OpenGLShaderUtils createShader()" , "Error when creating shader with the file " + shaderFile , LogType.ERROR));
		}
		
		//Check to see whether the shader was created
		if (shader == 0)
			//Log an error
			Logger.log(new Log("MyEngine OpenGLShaderUtils createShader()", "Error creating shader " + shaderFile, LogType.ERROR));
		
		//Return the shader
		return shader;
	}
	
	/* The method used to get any log information */
	public static String getLogInformation(int shader) {
		//Return the information
		return GL20.glGetShaderInfoLog(shader, 1000);
	}
	
}