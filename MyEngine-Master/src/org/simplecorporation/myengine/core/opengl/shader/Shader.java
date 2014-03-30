/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.opengl.shader;

import org.lwjgl.opengl.GL20;
import org.simplecorporation.myengine.utils.opengl.OpenGLUtils;

public class Shader {
	
	/* The shader program */
	public int shaderProgram;
	
	/* The constructor */
	public Shader() {
		//Set the shader program
		this.shaderProgram = GL20.glCreateProgram();
	}
	
	/* The method to use the shader */
	public void useShader() {
		//Use the current shader program
		GL20.glUseProgram(this.shaderProgram);
	}
	
	/* The method to stop using this shader */
	public void stopUsingShader() {
		//Set the current shader program to 0
		GL20.glUseProgram(0);
	}
	
	/* The method to attach a shader */
	public void attachShader(int shader) {
		//Attach the shader to the program
		GL20.glAttachShader(this.shaderProgram , shader);
		GL20.glLinkProgram(this.shaderProgram);
		GL20.glValidateProgram(this.shaderProgram);
	}
	
	/* The method used to set a specific value in this shader */
	public void setValuef(String variableName, float v1) {
		//Set the value in the shader
		GL20.glUniform1f(GL20.glGetUniformLocation(this.shaderProgram, variableName), v1);
	}
	
	/* The method used to set a specific value in this shader */
	public void setValuef(String variableName, float v1, float v2) {
		//Set the value in the shader
		GL20.glUniform2f(GL20.glGetUniformLocation(this.shaderProgram, variableName), v1, v2);
	}
	
	/* The method used to set a specific value in this shader */
	public void setValuef(String variableName, float v1, float v2, float v3) {
		//Set the value in the shader
		GL20.glUniform3f(GL20.glGetUniformLocation(this.shaderProgram, variableName), v1, v2, v3);
	}
	
	/* The method used to set a specific value in this shader */
	public void setValuei(String variableName, int v1) {
		//Set the value in the shader
		GL20.glUniform1i(GL20.glGetUniformLocation(this.shaderProgram, variableName), v1);
	}
	
	/* The method used to set a specific value in this shader */
	public void setValuei(String variableName, int v1, int v2) {
		//Set the value in the shader
		GL20.glUniform2i(GL20.glGetUniformLocation(this.shaderProgram, variableName), v1, v2);
	}
	
	/* The method used to set a specific value in this shader */
	public void setValuei(String variableName, int v1, int v2, int v3) {
		//Set the value in the shader
		GL20.glUniform3i(GL20.glGetUniformLocation(this.shaderProgram, variableName), v1, v2, v3);
	}
	
	/* The method used to set a specific value in this shader */
	public void setValuei(String variableName, int[] arrayValues) {
		//Set the value in the shader
		GL20.glUniform1(GL20.glGetUniformLocation(this.shaderProgram, variableName), OpenGLUtils.getIntegerBuffer(arrayValues));
	}
	
	/* The method used to set a specific value in this shader */
	public void setValuef(String variableName, float[] arrayValues) {
		//Set the value in the shader
		GL20.glUniform1(GL20.glGetUniformLocation(this.shaderProgram, variableName), OpenGLUtils.getFloatBuffer(arrayValues));
	}
	
}