package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.game.BaseGame;
import org.simplecorporation.myengine.core.gui.GUIRenderer;
import org.simplecorporation.myengine.core.gui.GUITextBox;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.font.FontUtils;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class TextBoxTest extends BaseGame {
	
	public GUITextBox textBox;
	
	public TextBoxTest() {
		Settings.Window.Title = "TextBox Test";
		Settings.Video.OpenGL = false;
		//Create
		createGame();
	}
	
	public void gameCreated() {
		textBox = new GUITextBox("TextBox" , new GUIRenderer(new Colour[] { Colour.GREEN, Colour.WHITE } , FontUtils.buildGUIFont("Arial" , Colour.RED , 20f)));
		textBox.position.x = 100;
		textBox.position.y = 100;
		textBox.width = 200;
		textBox.height = 30;
		//textBox.setDefaultText("This is a text box!");
		//textBox.setText("e");
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