package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.game.BaseGame;
import org.simplecorporation.myengine.core.gui.loadingbar.GUIRenderableLoadingBar;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class LoadingBarTest extends BaseGame {
	
	public GUIRenderableLoadingBar loadingBar;
	public long lastTime;
	
	public LoadingBarTest() {
		Settings.Window.Title = "LoadingBar Test";
		Settings.Video.OpenGL = true;
		createGame();
	}
	
	public void gameCreated() {
		loadingBar = new GUIRenderableLoadingBar("LoadingBar" , 103);
		loadingBar.position.x = 100;
		loadingBar.position.y = 100;
		loadingBar.width = 200;
		loadingBar.height = 20;
		lastTime = System.currentTimeMillis();
	}
	
	public void gameUpdate() {
		loadingBar.update();
		if (System.currentTimeMillis() - lastTime > 90) {
			loadingBar.completedStage();
			lastTime = System.currentTimeMillis();
			System.out.println(loadingBar.getPercentageComplete());
		}
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
		
		loadingBar.render();
	}
	
	public static void main(String[] args) {
		new LoadingBarTest();
	}
	
}