package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.game.BaseGame;
import org.simplecorporation.myengine.core.gui.button.GUIRenderableButton;
import org.simplecorporation.myengine.core.gui.slider.GUIRenderableSlider;
import org.simplecorporation.myengine.core.gui.slider.GUISlider;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.font.FontUtils;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class SliderTest extends BaseGame {
	
	public GUIRenderableSlider verticalslider;
	public GUIRenderableSlider horizontalslider;
	
	public SliderTest() {
		Settings.Window.Title = "Slider Test";
		Settings.Video.OpenGL = false;
		Settings.Video.AntiAliasing = true;
		//Create
		createGame();
	}
	
	public void gameCreated() {
		GUIRenderableButton verticalsliderButton = new GUIRenderableButton("Button2" , "" , new Colour[] {
				Colour.ORANGE ,
				Colour.LIGHT_BLUE ,
				Colour.BLUE
		} , FontUtils.buildGUIFont("Segoe UI" , Colour.WHITE , 20f));
		verticalsliderButton.width = 100;
		verticalsliderButton.height = 20;
		verticalsliderButton.visible = true;
		
		verticalslider = new GUIRenderableSlider("Slider1" , Colour.RED , verticalsliderButton , GUISlider.DIRECTION_VERTICAL);
		
		verticalslider.visible = true;
		verticalslider.position.x = 200;
		verticalslider.position.y = 200;
		verticalslider.width = 30;
		verticalslider.height = 100;
		
		GUIRenderableButton horizontalsliderButton = new GUIRenderableButton("Button2" , "" , new Colour[] {
				Colour.ORANGE ,
				Colour.LIGHT_BLUE ,
				Colour.BLUE
		} , FontUtils.buildGUIFont("Segoe UI" , Colour.WHITE , 20f));
		horizontalsliderButton.width = 20;
		horizontalsliderButton.height = 100;
		horizontalsliderButton.visible = true;
		
		horizontalslider = new GUIRenderableSlider("Slider2" , Colour.RED , horizontalsliderButton , GUISlider.DIRECTION_HORIZONTAL);
		
		horizontalslider.visible = true;
		horizontalslider.position.x = 300;
		horizontalslider.position.y = 300;
		horizontalslider.width = 100;
		horizontalslider.height = 30;
		
	}
	
	public void gameUpdate() {
		verticalslider.update();
		horizontalslider.update();
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
		verticalslider.render();
		horizontalslider.render();
	}
	
	public static void main(String[] args) {
		new SliderTest();
	}
	
}