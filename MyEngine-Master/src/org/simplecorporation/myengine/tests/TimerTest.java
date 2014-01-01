package org.simplecorporation.myengine.tests;

import org.simplecorporation.myengine.core.game.BaseGame;
import org.simplecorporation.myengine.core.input.MouseInput;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.timer.Timer;

public class TimerTest extends BaseGame {
	
	public Timer timer;
	
	public TimerTest() {
		Settings.Window.Title = "TimerTest";
		Settings.Video.OpenGL = false;
		
		timer = new Timer();
		timer.start();
		
		createGame();
	}
	
	public void gameUpdate() {
		if (MouseInput.isLeftButtonDown)
			timer.pause();
		else if (MouseInput.isRightButtonDown)
			timer.resume();
	}
	
	public void gameRender() {
		System.out.println(timer.getTimePassed());
	}
	
	public static void main(String[] args) {
		new TimerTest();
	}
	
}