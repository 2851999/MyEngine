package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.engine.loop.EngineLoop;
import org.simplecorporation.myengine.core.gui.builder.GUIBuilder;
import org.simplecorporation.myengine.core.gui.dialogbox.GUIInputDialogBox;
import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.gui.window.GUIRenderableWindow;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.font.FontUtils;

public class DialogBoxTest extends EngineLoop {
	
	GUIInputDialogBox dialogBox;
	
	public DialogBoxTest() {
		Settings.Video.OpenGL = false;
		create();
	}
	
	public static void main(String[] args) {
		new DialogBoxTest();
	}

	@Override
	public void engineCreated() {
		// TODO Auto-generated method stub
		GUIFont font = FontUtils.buildGUIFont("Arial", Colour.BLACK, 20);
		GUIRenderableWindow window = new GUIRenderableWindow("" , "TITLE" , font ,
				GUIBuilder.createRenderableButton("NAME" , "" , new Colour[] { Colour.RED ,  Colour.BLACK ,  Colour.BLACK } , font , 0 , 0 , 30, 30) ,
				40 , 100 , 100 , 300 , 200 , Colour.WHITE , Colour.GREEN);
		dialogBox = new GUIInputDialogBox("DialogBox" , "This is a message box" , font , window ,
				GUIBuilder.createRenderableButton("NAME" , "Confirm" , new Colour[] { Colour.RED ,  Colour.BLACK ,  Colour.BLACK } , font , 0 , 0 , 100, 30) ,
				GUIBuilder.createRenderableButton("NAME" , "Cancel" , new Colour[] { Colour.RED ,  Colour.BLACK ,  Colour.BLACK } , font , 0 , 0 , 100, 30) ,
				GUIBuilder.createRenderableTextBox("NAME" , Colour.WHITE , Colour.BLACK , font , 0 , 0 , 100 , 30));
		dialogBox.window.showPanel();
	}

	@Override
	public void engineStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineUpdate() {
		// TODO Auto-generated method stub
		dialogBox.update();
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
		dialogBox.render();
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