package org.simplecorporation.myengine.tests;

import org.simplecorporation.myengine.core.audio.clip.JavaAudio;
import org.simplecorporation.myengine.core.game.Game;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;

public class AudioTest extends Game {
	
	public JavaAudio audio;
	
	public AudioTest() {
		Settings.Window.Title = "Audio Test";
		Settings.Video.OpenGL = false;
		Settings.Audio.SoundEffectVolume = 20;
		audio = new JavaAudio("C://encode.wav" , "WAV" , false , false);
		audio.play();
		//Create
		createGame();
	}
	
	public void gameRender() {
		if (Settings.Video.OpenGL) {
			OpenGLSetupUtils.setupOrtho(1 , -1);
		}
		BasicRenderer.setColour(Colour.WHITE);
		BasicRenderer.renderFilledRectangle(100 , 100 , 100 , 100);
	}
	
	public static void main(String[] args) {
		new AudioTest();
	}
	
}