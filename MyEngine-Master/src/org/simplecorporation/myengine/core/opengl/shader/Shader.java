/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.opengl.shader;

import org.lwjgl.opengl.ARBShaderObjects;

public class Shader {
	
	/* The shader program */
	public int shaderProgram;
	
	/* The constructor */
	public Shader() {
		//Set the shader program
		this.shaderProgram = ARBShaderObjects.glCreateProgramObjectARB();
	}
	
	/* The method to use the shader */
	public void useShader() {
		//Use the current shader program
		ARBShaderObjects.glUseProgramObjectARB(this.shaderProgram);
	}
	
	/* The method to stop using this shader */
	public void stopUsingShader() {
		//Set the current shader program to 0
		ARBShaderObjects.glUseProgramObjectARB(0);
	}
	
	/* The method to attach a shader */
	public void attachShader(int shader) {
		//Attach the shader to the program
		ARBShaderObjects.glAttachObjectARB(this.shaderProgram , shader);
	}
	
}