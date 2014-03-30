package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.engine.loop.EngineLoop;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class RectangleTest extends EngineLoop {
	
	public RectangleTest() {
		Settings.Video.OpenGL = false;
		create();
	}
	
	public static void main(String[] args) {
		new RectangleTest();
	}

	@Override
	public void engineCreated() {
		// TODO Auto-generated method stub
		
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
		
		BasicRenderer.setColour(Colour.BLUE);
		BasicRenderer.renderRectangle(100 , 100 , 100 , 100);
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