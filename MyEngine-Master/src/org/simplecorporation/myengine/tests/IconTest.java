package org.simplecorporation.myengine.tests;

import org.simplecorporation.myengine.core.game.Game;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.core.window.Window;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class IconTest extends Game {
	
	public IconTest() {
		Settings.Window.Title = "Icon Test";
		Settings.Video.OpenGL = true;
		Settings.Audio.SoundEffectVolume = 20;
		//Create
		createGame();
	}
	
	public void gameCreated() {
		System.out.println("HELLO");
		Window.setIcon(new Image[] { new Image("C://computinghwkplatform16.png" , "PNG" , true) , new Image("C://computinghwkplatform32.png" , "PNG" , true) });
	}
	
	public void gameRender() {
		if (Settings.Video.OpenGL) {
			OpenGLSetupUtils.setupOrtho(1 , -1);
		}
		BasicRenderer.setColour(Colour.WHITE);
		BasicRenderer.renderFilledRectangle(100 , 100 , 100 , 100);
	}
	
	public static void main(String[] args) {
		new IconTest();
	}
	
}