package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.simplecorporation.myengine.core.engine.loop.EngineLoop;
import org.simplecorporation.myengine.core.opengl.shader.Shader;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.opengl.shader.OpenGLShaderUtils;

public class ShaderTest extends EngineLoop {
	
	public Shader shader;
	
	public ShaderTest() {
		Settings.Video.OpenGL = true;
		create();
	}
	
	public static void main(String[] args) {
		new ShaderTest();
	}

	@Override
	public void engineCreated() {
		// TODO Auto-generated method stub
		shader = new Shader();
		shader.attachShader(OpenGLShaderUtils.createShader("/shader.vert", GL20.GL_VERTEX_SHADER, false));
		shader.attachShader(OpenGLShaderUtils.createShader("/shader.frag", GL20.GL_FRAGMENT_SHADER, false));
	}

	@Override
	public void engineStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineRender() {
		if (Settings.Video.OpenGL) {
			GL11.glMatrixMode(GL11.GL_PROJECTION);;
			GL11.glLoadIdentity();
			GL11.glOrtho(0 , Settings.Window.Size.Width , Settings.Window.Size.Height , 0, 1 , -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
		}
		shader.useShader();
		BasicRenderer.setColour(Colour.BLUE);
		BasicRenderer.renderRectangle(100 , 100 , 100 , 100);
		shader.stopUsingShader();
	}

	@Override
	public void engineStopped() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineClosing() {
		// TODO Auto-generated method stub
		
	}
	
}