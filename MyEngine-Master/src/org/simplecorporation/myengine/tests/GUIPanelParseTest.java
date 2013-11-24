package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.game.Game;
import org.simplecorporation.myengine.core.gui.GUIPanel;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class GUIPanelParseTest extends Game {
	
	public GUIPanel panel;
	
	public GUIPanelParseTest() {
		Settings.Window.Title = "GUIPanel Parse Test";
		Settings.Video.OpenGL = false;
		Settings.Video.VSync = true;
		Settings.Video.AntiAliasing = true;
		//Create
		createGame();
	}
	
	public void gameCreated() {
		String PATH = "";
		panel = new GUIPanel("TestPanel");
		panel.parseFile(PATH + "GUI.txt" , true);
		panel.showPanel();
	}
	
	public void gameUpdate() {
		panel.update();
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
		panel.render();
	}
	
	public static void main(String[] args) {
		new GUIPanelParseTest();
	}
	
}