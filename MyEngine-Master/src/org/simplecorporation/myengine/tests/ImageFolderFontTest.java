package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.game.Game;
import org.simplecorporation.myengine.core.gui.button.GUIRenderableButton;
import org.simplecorporation.myengine.core.gui.font.GUIFont;
import org.simplecorporation.myengine.core.gui.font.image.ImageFolderFont;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class ImageFolderFontTest extends Game {
	
	public ImageFolderFont font;
	public GUIRenderableButton button;
	
	public ImageFolderFontTest() {
		Settings.Window.Title = "ImageFolderFont Test";
		Settings.Video.OpenGL = true;
		Settings.Video.AntiAliasing = true;
		//Create
		createGame();
	}
	
	public void gameCreated() {
		font = new ImageFolderFont("C:/Users/Joel/Documents/TestFont" , "PNG" , true , 30);
		button = new GUIRenderableButton("Button" , "Hello" , new Colour[] { Colour.WHITE , Colour.BLUE , Colour.ORANGE } , new GUIFont(font));
		button.getBase().visible = true;
		button.getBase().position.x = 200;
		button.getBase().position.y = 200;
		button.getBase().width = 100;
		button.getBase().height = 30;
	}
	
	public void gameUpdate() {
		button.update();
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
		font.render("Hello World" , 100 , 100);
		GL11.glDisable(GL11.GL_BLEND);
		button.render();
	}
	
	public static void main(String[] args) {
		new ImageFolderFontTest();
	}
	
}