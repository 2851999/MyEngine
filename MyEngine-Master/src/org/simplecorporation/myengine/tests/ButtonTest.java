package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.game.Game;
import org.simplecorporation.myengine.core.gui.button.GUIImageButton;
import org.simplecorporation.myengine.core.gui.button.GUIRenderableButton;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.font.FontUtils;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class ButtonTest extends Game {
	
	public GUIImageButton button;
	public GUIRenderableButton button2;
	
	public ButtonTest() {
		Settings.Window.Title = "Button Test";
		Settings.Video.OpenGL = true;
		Settings.Video.AntiAliasing = true;
		//Create
		createGame();
	}
	
	public void gameCreated() {
		button = new GUIImageButton("Button" , "Test" , new Image[] {
				new Image(System.getenv("AppData") + "/SimpleCorporation/MyEngine/MainMenuButton1.png" , "PNG" , true) ,
				new Image(System.getenv("AppData") + "/SimpleCorporation/MyEngine/MainMenuButton2.png" , "PNG" , true) , 
				new Image(System.getenv("AppData") + "/SimpleCorporation/MyEngine/MainMenuButton3.png" , "PNG" , true)
		} , FontUtils.buildGUIFont("Segoe UI" , Colour.WHITE , 20f));
		button.visible = true;
		button.position.x = 100;
		button.position.y = 100;
		button.width = 100;
		button.height = 30;
		
		button2 = new GUIRenderableButton("Button2" , "Test2" , new Colour[] {
				Colour.ORANGE ,
				Colour.LIGHT_BLUE ,
				Colour.BLUE
		} , FontUtils.buildGUIFont("Segoe UI" , Colour.WHITE , 20f));
		
		button2.visible = true;
		button2.position.x = 200;
		button2.position.y = 200;
		button2.width = 100;
		button2.height = 30;
		
	}
	
	public void gameUpdate() {
		button.update();
		button2.update();
		if (button.isClicked() || button2.isClicked()) {
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
		button2.render();
	}
	
	public static void main(String[] args) {
		new ButtonTest();
	}
	
}