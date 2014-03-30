package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.engine.loop.EngineLoop;
import org.simplecorporation.myengine.core.gui.builder.GUIBuilder;
import org.simplecorporation.myengine.core.gui.dropdownmenu.GUIRenderableDropDownMenu;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.font.FontUtils;

public class GUIDropDownMenuTest extends EngineLoop {
	
	GUIRenderableDropDownMenu menu;
	
	public GUIDropDownMenuTest() {
		Settings.Video.OpenGL = false;
		create();
	}
	
	public static void main(String[] args) {
		new GUIDropDownMenuTest();
	}

	@Override
	public void engineCreated() {
		// TODO Auto-generated method stub
		menu = new GUIRenderableDropDownMenu("DropDownMenu" , GUIBuilder.createRenderableButton("NAME" , "Menu" , new Colour[] { Colour.BLUE ,  Colour.BLACK ,  Colour.GREEN } , FontUtils.buildGUIFont("Segoe UI", Colour.WHITE, 20) , 0, 0, 0, 30) , Colour.GREY);
		menu.position.x = 100;
		menu.position.y = 100;
		menu.width = 100;
		menu.visible = true;
		menu.addButton(GUIBuilder.createRenderableButton("NAME" , "Button 1" , new Colour[] { Colour.BLUE ,  Colour.BLACK ,  Colour.GREEN } , FontUtils.buildGUIFont("Segoe UI", Colour.WHITE, 20) , 0, 0, 0, 30));
		menu.addButton(GUIBuilder.createRenderableButton("NAME" , "Button 2" , new Colour[] { Colour.BLUE ,  Colour.BLACK ,  Colour.GREEN } , FontUtils.buildGUIFont("Segoe UI", Colour.WHITE, 20) , 0, 0, 0, 30));
	}

	@Override
	public void engineStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineUpdate() {
		// TODO Auto-generated method stub
		menu.update();
	}

	@Override
	public void engineRender() {
		if (Settings.Video.OpenGL) {
			GL11.glMatrixMode(GL11.GL_PROJECTION);;
			GL11.glLoadIdentity();
			GL11.glOrtho(0 , Settings.Window.Size.Width , Settings.Window.Size.Height , 0, 1 , -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
		}
		
		BasicRenderer.setColour(Colour.GREEN);
		BasicRenderer.renderFilledRectangle(0 , 0 , Settings.Window.Size.Width , Settings.Window.Size.Height);
		menu.render();
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