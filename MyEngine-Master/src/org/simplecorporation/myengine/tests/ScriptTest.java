package org.simplecorporation.myengine.tests;

import org.simplecorporation.myengine.core.engine.script.Script;
import org.simplecorporation.myengine.core.engine.script.library.Library;
import org.simplecorporation.myengine.core.game.Game;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class ScriptTest extends Game {
	
	public Script script;
	
	public ScriptTest() {
		Settings.Window.Title = "Script Test";
		Settings.Video.OpenGL = true;
		createGame();
	}
	
	public void gameCreated() {
		Library.findAndAddLibraries();
		script = new Script("C:/Users/Joel/Documents/myenginescripttest.txt");
		script.parse();
		script.callMethod("setupPanel()");
	}
	
	public void gameUpdate() {
		
	}
	
	public void gameRender() {
		if (Settings.Video.OpenGL) {
			OpenGLSetupUtils.setupOrtho(1 , -1);
		}
		BasicRenderer.setColour(Colour.BLACK);
		BasicRenderer.renderFilledRectangle(0 , 0 , 640 , 480);
		
		script.callMethod("render()");
	}
	
	public static void main(String[] args) {
		new ScriptTest();
	}
	
}