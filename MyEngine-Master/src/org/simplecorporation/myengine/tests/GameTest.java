package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.game.Game;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class GameTest extends Game {
	
	public GameTest() {
		
	}
	
	public void gameRender() {
		if (Settings.Video.OpenGL) {
			GL11.glMatrixMode(GL11.GL_PROJECTION);;
			GL11.glLoadIdentity();
			GL11.glOrtho(0 , Settings.Window.Size.Width , Settings.Window.Size.Height , 0, 1 , -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
		}
		BasicRenderer.setColour(Colour.WHITE);
		BasicRenderer.renderFilledRectangle(100 , 100 , 100 , 100);
	}
	
	public void onMouseClicked(MouseEvent e) {
		System.out.println("MouseClicked " + e.getButton());
	}
	
	public static void main(String[] args) {
		Settings.Window.Title = "Game Test";
		Settings.Video.OpenGL = false;
		new GameTest();
	}
	
	public void loadResources() {
		
	}
	
}