package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.game.BaseGame;
import org.simplecorporation.myengine.core.gui.checkbox.GUIRenderableCheckBox;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class CheckBoxButtonTest extends BaseGame {
	
	public GUIRenderableCheckBox checkBox;
	
	public CheckBoxButtonTest() {
		Settings.Window.Title = "CheckBox Test";
		Settings.Video.OpenGL = true;
		//Create
		createGame();
	}
	
	public void gameCreated() {
		checkBox = new GUIRenderableCheckBox("CheckBox" , Colour.WHITE , Colour.BLUE);
		checkBox.visible = true;
		checkBox.position.x = 100;
		checkBox.position.y = 100;
		checkBox.width = 20;
		checkBox.height = 20;
		checkBox.checkWidth = 10;
		checkBox.checkHeight = 10;
	}
	
	public void gameUpdate() {
		checkBox.update();
	}
	
	public void gameRender() {
		if (Settings.Video.OpenGL) {
			OpenGLSetupUtils.setupOrtho(1 , -1);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA , GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		}
		BasicRenderer.setColour(Colour.BLACK);
		BasicRenderer.renderFilledRectangle(0 , 0 , 640 , 480);
		BasicRenderer.setColour(Colour.WHITE);
		checkBox.render();
	}
	
	public static void main(String[] args) {
		new CheckBoxButtonTest();
	}
	
}