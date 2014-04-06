package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.game.BaseGame;
import org.simplecorporation.myengine.core.gui.GUIButton;
import org.simplecorporation.myengine.core.gui.GUIRenderer;
import org.simplecorporation.myengine.core.gui.GUIScrollBar;
import org.simplecorporation.myengine.core.gui.GUISlider;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.font.FontUtils;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class ScrollBarTest extends BaseGame {
	
	public GUIScrollBar verticalslider;
	public GUIScrollBar horizontalslider;
	
	public ScrollBarTest() {
		Settings.Window.Title = "Scroll Bar Test";
		Settings.Video.OpenGL = false;
		Settings.Video.AntiAliasing = true;
		//Create
		createGame();
	}
	
	public void gameCreated() {
		GUIButton verticalsliderButton = new GUIButton("Button2" , "" , new GUIRenderer(new Colour[] {
				Colour.ORANGE ,
				Colour.LIGHT_BLUE ,
				Colour.BLUE
		} , FontUtils.buildGUIFont("Segoe UI" , Colour.WHITE , 20f)));
		verticalsliderButton.width = 100;
		verticalsliderButton.height = 20;
		verticalsliderButton.visible = true;
		
		verticalslider = new GUIScrollBar("Slider1" , verticalsliderButton , GUISlider.DIRECTION_VERTICAL , 1, new GUIRenderer(new Colour[] { Colour.RED }));
		
		verticalslider.visible = true;
		verticalslider.position.x = 200;
		verticalslider.position.y = 200;
		verticalslider.width = 30;
		verticalslider.height = 100;
		
		GUIButton horizontalsliderButton = new GUIButton("Button2" , "" , new GUIRenderer(new Colour[] {
				Colour.ORANGE ,
				Colour.LIGHT_BLUE ,
				Colour.BLUE
		} , FontUtils.buildGUIFont("Segoe UI" , Colour.WHITE , 20f)));
		horizontalsliderButton.width = 20;
		horizontalsliderButton.height = 100;
		horizontalsliderButton.visible = true;
		
		horizontalslider = new GUIScrollBar("Slider2" , horizontalsliderButton , GUISlider.DIRECTION_HORIZONTAL , 1, new GUIRenderer(new Colour[] { Colour.RED }));
		
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
		new ScrollBarTest();
	}
	
}