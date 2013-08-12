package org.simplecorporation.myengine.tests;

import java.awt.Font;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.game.Game;
import org.simplecorporation.myengine.core.gui.textbox.GUIRenderableTextBox;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.font.FontUtils;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class TextBoxTest extends Game {
	
	public GUIRenderableTextBox textBox;
	
	public TextBoxTest() {
		Settings.Window.Title = "TextBox Test";
		Settings.Video.OpenGL = false;
		//Create
		createGame();
	}
	
	public void gameCreated() {
		textBox = new GUIRenderableTextBox("TextBox" , FontUtils.buildGUIFont(new Font("Arial" , Font.PLAIN , 1) , Colour.RED , 20f));
		textBox.position.x = 100;
		textBox.position.y = 100;
		textBox.width = 200;
		textBox.height = 30;
		textBox.outlineColour = Colour.GREEN;
		textBox.defaultText = "This is a text box!";
		textBox.visible = true;
	}
	
	public void gameUpdate() {
		textBox.update();
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
		textBox.render();
	}
	
	public static void main(String[] args) {
		new TextBoxTest();
	}
	
}