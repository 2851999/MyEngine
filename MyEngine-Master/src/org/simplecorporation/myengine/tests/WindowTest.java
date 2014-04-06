package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.engine.loop.EngineLoop;
import org.simplecorporation.myengine.core.gui.GUIRenderer;
import org.simplecorporation.myengine.core.gui.GUIWindow;
import org.simplecorporation.myengine.core.gui.builder.GUIBuilder;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.font.FontUtils;

public class WindowTest extends EngineLoop {
	
	GUIWindow window;
	
	public WindowTest() {
		Settings.Video.OpenGL = true;
		create();
	}
	
	public static void main(String[] args) {
		new WindowTest();
	}

	@Override
	public void engineCreated() {
		// TODO Auto-generated method stub
		window = new GUIWindow("Window" , "TITLE" ,
				GUIBuilder.createButton("NAME" , "" , new Colour[] { Colour.RED ,  Colour.BLACK ,  Colour.BLACK } , FontUtils.buildGUIFont("Arial", Colour.BLACK, 10) , 0 , 0 , 30, 30) ,
				40 , 100 , 100 , 300 , 200 , new GUIRenderer(new Colour[] { Colour.WHITE , Colour.GREEN }, FontUtils.buildGUIFont("Arial", Colour.BLACK, 10)));
		window.showPanel();
	}

	@Override
	public void engineStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineUpdate() {
		// TODO Auto-generated method stub
		window.update();
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
		BasicRenderer.renderFilledRectangle(0 , 0 , Settings.Window.Size.Width , Settings.Window.Size.Height);
		window.render();
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