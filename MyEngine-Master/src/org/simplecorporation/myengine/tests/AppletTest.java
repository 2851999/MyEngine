package org.simplecorporation.myengine.tests;

import org.simplecorporation.myengine.core.game.BaseGame;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class AppletTest extends BaseGame {
	
	public AppletTest() {
		Settings.Applet = true;
		Settings.Video.OpenGL = true;
		createGame();
	}
	
	public void gameRender() {
		BasicRenderer.setColour(Colour.BLUE);
		BasicRenderer.renderFilledRectangle(10, 10, 20, 20);
	}
	
	public static void main(String[] args) {
		new AppletTest();
	}
	
}