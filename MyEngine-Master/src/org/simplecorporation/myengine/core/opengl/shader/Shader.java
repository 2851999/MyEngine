/***********************************************
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
	
}