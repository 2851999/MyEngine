/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.audio.clip;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.file.FileUtils;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class JavaAudio {
	
	/* The audio clip for java */
	public Clip javaAudioClip;
	
	/* The audio clip for OpenAL */
	public Audio javaOpenALClip;
	
	/* Should the audio loop (Music) */
	public boolean loop;
	
	/* Is the audio music */
	public boolean music;
	
	/* The constructor */
	public JavaAudio() {
		//Assign the variables
		this.loop = false;
		this.music = false;
	}
	
	/* The constructor with the file path given */
	public JavaAudio(String filePath , String fileFormat , boolean loop , boolean music) {
		//Assign the variables
		this.loop = loop;
		this.music = music;
		//Load the audio
		this.load(filePath , fileFormat);
	}
	
	/* The method to start then audio playing */
	public void play() {
		//Check which sound to start
		if (! Settings.Video.OpenGL) {
			this.javaAudioClip.start();
			//Check if it should loop
			if (this.loop)
				this.javaAudioClip.loop(Clip.LOOP_CONTINUOUSLY);
		} else if (Settings.Video.OpenGL) {
			//Check if this file should be played as music
			if (this.music)
				this.javaOpenALClip.playAsMusic(1.0f , (float)((double)Settings.Audio.SoundEffectVolume / (double)100) , this.loop);
			else if (! this.music)
				this.javaOpenALClip.playAsSoundEffect(1.0f , (float)((double)Settings.Audio.SoundEffectVolume / (double)100) , this.loop);
		}
	}
	
	/* The method to start then audio playing with an x and y */
	public void play(double x , double y , double z) {
		if (Settings.Video.OpenGL) {
			if (! this.music)
				this.javaOpenALClip.playAsSoundEffect(1.0f , (float)((double)Settings.Audio.SoundEffectVolume / (double)100) , this.loop , (float)x , (float)y , (float)z);
		}
	}
	
	/* The method it stop the audio playing */
	public void stop() {
		if (! Settings.Video.OpenGL)
			this.javaAudioClip.stop();
		else if (Settings.Video.OpenGL)
			this.javaOpenALClip.stop();
	}
	
	/* The method to load the audio */
	public void load(String filePath , String fileFormat) {
		//Check whether OpenGL is being used
		if (! Settings.Video.OpenGL) {
			//Load the audio clip for java
			try {
				this.javaAudioClip = AudioSystem.getClip();
				AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(FileUtils.asFileString(filePath)));
				this.javaAudioClip.open(inputStream);
			} catch (LineUnavailableException e) {
				//Log an error
				Logger.log(new Log("JavaAudio load()" , "LineUnavailableException " + filePath , LogType.ERROR));
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				//Log an error
				Logger.log(new Log("JavaAudio load()" , "UnsupportedAudioFileException " + filePath , LogType.ERROR));
				e.printStackTrace();
			} catch (IOException e) {
				//Log an error
				Logger.log(new Log("JavaAudio load()" , "IOException " + filePath , LogType.ERROR));
				e.printStackTrace();
			}
		} else if (Settings.Video.OpenGL) {
			//Load the audio clip for OpenAL
			try {
				this.javaOpenALClip = AudioLoader.getAudio(fileFormat , ResourceLoader.getResourceAsStream(FileUtils.asFileString(filePath)));
			} catch (IOException e) {
				//Log an error
				Logger.log(new Log("JavaAudio load()" , "IOException " + filePath , LogType.ERROR));
				e.printStackTrace();
			}
		}
	}
	
	/* The method that returns whether the audio is playing */
	public boolean isPlaying() {
		//Check whether OpenGL is being used
		if (! Settings.Video.OpenGL)
			return this.javaAudioClip.isRunning();
		else if (Settings.Video.OpenGL)
			return this.javaOpenALClip.isPlaying();
		else
			return false;
	}
}