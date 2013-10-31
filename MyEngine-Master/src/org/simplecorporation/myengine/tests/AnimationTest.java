package org.simplecorporation.myengine.tests;

import org.simplecorporation.myengine.core.game.Game;
import org.simplecorporation.myengine.core.game2d.entity.AnimatedImageEntity2D;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class AnimationTest extends Game {
	
	public AnimatedImageEntity2D entity;
	
	public AnimationTest() {
		Settings.Window.Title = "Animation Test";
		Settings.Video.OpenGL = true;
		createGame();
	}
	
	public void gameCreated() {
		String path = "PATH";
		entity = new AnimatedImageEntity2D(new Image[] {
				new Image(path + "animationbox1.png" , "PNG" , true) ,
				new Image(path + "animationbox2.png" , "PNG" , true) ,
				new Image(path + "animationbox3.png" , "PNG" , true) ,
				new Image(path + "animationbox4.png" , "PNG" , true)
		} , 100);
		entity.position.x = 100;
		entity.position.y = 100;
		entity.width = 100;
		entity.height = 100;
		entity.repeat = true;
		entity.start();
	}
	
	public void gameUpdate() {
		entity.update();
	}
	
	public void gameRender() {
		if (Settings.Video.OpenGL) {
			OpenGLSetupUtils.setupOrtho(1 , -1);
		}
		BasicRenderer.setColour(Colour.BLACK);
		BasicRenderer.renderFilledRectangle(0 , 0 , 640 , 480);
		
		entity.render();
	}
	
	public static void main(String[] args) {
		new AnimationTest();
	}
	
}