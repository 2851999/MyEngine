package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.engine.loop.EngineLoop;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.settings.Settings;

public class ImageTest extends EngineLoop {
	
	private Image testImage;
	
	public ImageTest() {
		Settings.Video.OpenGL = true;
		create();
	}
	
	public static void main(String[] args) {
		new ImageTest();
	}

	@Override
	public void engineCreated() {
		// TODO Auto-generated method stub
		testImage = new Image(System.getenv("AppData") + "/SimpleCorporation/Platformer/Textures/grasstile1.png" , "PNG" , true);
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
		
		BasicRenderer.renderImage(this.testImage , 100 , 100);
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