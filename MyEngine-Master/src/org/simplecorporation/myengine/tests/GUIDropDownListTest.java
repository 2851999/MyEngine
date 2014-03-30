package org.simplecorporation.myengine.tests;

import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.engine.loop.EngineLoop;
import org.simplecorporation.myengine.core.gui.builder.GUIBuilder;
import org.simplecorporation.myengine.core.gui.dropdownlist.GUIRenderableDropDownList;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.font.FontUtils;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;
import org.simplecorporation.myengine.utils.opengl.OpenGLUtils;

public class GUIDropDownListTest extends EngineLoop {
	
	GUIRenderableDropDownList list;
	
	public GUIDropDownListTest() {
		Settings.Video.OpenGL = true;
		create();
	}
	
	public static void main(String[] args) {
		new GUIDropDownListTest();
	}
	
	@Override
	public void engineCreated() {
		// TODO Auto-generated method stub
		list = new GUIRenderableDropDownList("DropDownList" , GUIBuilder.createRenderableButton("NAME" , "Menu" , new Colour[] { Colour.BLUE ,  Colour.BLACK ,  Colour.GREEN } , FontUtils.buildGUIFont("Segoe UI", Colour.WHITE, 20) , 0, 0, 0, 30), Colour.GREY);
		list.position.x = 100;
		list.position.y = 100;
		list.width = 100;
		list.visible = true;
		list.addButton(GUIBuilder.createRenderableButton("NAME1" , "Button 1" , new Colour[] { Colour.BLUE ,  Colour.BLACK ,  Colour.GREEN } , FontUtils.buildGUIFont("Segoe UI", Colour.WHITE, 20) , 0, 0, 0, 30));
		list.addButton(GUIBuilder.createRenderableButton("NAME2" , "Button 2" , new Colour[] { Colour.BLUE ,  Colour.BLACK ,  Colour.GREEN } , FontUtils.buildGUIFont("Segoe UI", Colour.WHITE, 20) , 0, 0, 0, 30));
	}

	@Override
	public void engineStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineUpdate() {
		// TODO Auto-generated method stub
		list.update();
	}

	@Override
	public void engineRender() {
		OpenGLSetupUtils.setupOrtho(-1 , 1);
		OpenGLSetupUtils.setupRemoveAlpha();
		OpenGLUtils.clearColourBuffer();
		
		BasicRenderer.setColour(Colour.GREEN);
		BasicRenderer.renderFilledRectangle(0 , 0 , Settings.Window.Size.Width , Settings.Window.Size.Height);
		list.render();
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