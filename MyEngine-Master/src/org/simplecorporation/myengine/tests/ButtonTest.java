package org.simplecorporation.myengine.tests;

import java.awt.Font;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.game.Game;
import org.simplecorporation.myengine.core.gui.button.GUIImageButton;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.font.FontUtils;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class ButtonTest extends Game {
	
	public GUIImageButton button;
	
	public ButtonTest() {
		Settings.Window.Title = "Button Test";
		Settings.Video.OpenGL = false;
		//Create
		createGame();
	}
	
	public void gameCreated() {
		button = new GUIImageButton("Button" , "Test" , new Image[] {
				new Image(System.getenv("AppData") + "/SimpleCorporation/MyEngine/MainMenuButton1.png" , "PNG" , true) ,
				new Image(System.getenv("AppData") + "/SimpleCorporation/MyEngine/MainMenuButton2.png" , "PNG" , true) , 
				new Image(System.getenv("AppData") + "/SimpleCorporation/MyEngine/MainMenuButton3.png" , "PNG" , true)
		} , FontUtils.buildGUIFont(new Font("Segoe UI" , Font.PLAIN , 1) , Colour.WHITE , 20f));
		button.visible = true;
		button.position.x = 100;
		button.position.y = 100;
		button.width = 100;
		button.height = 30;
	}
	
	public void gameUpdate() {
		button.update();
		if (button.isClicked()) {
			System.out.println("CLICKED");
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
		BasicRenderer.setColour(Colour.WHITE);
		button.render();
	}
	
	public static void main(String[] args) {
		new ButtonTest();
	}
	
}