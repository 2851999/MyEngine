/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.audio.clip;

import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.settings.Settings;

import android.media.MediaPlayer;

public class AndroidAudio {
	
	/* The audio clip for android */
	public MediaPlayer androidAudioClip;
	
	/* Should the audio loop (Music) */
	public boolean loop;
	
	/* Is the audio music */
	public boolean music;
	
	/* The constructor */
	public AndroidAudio() {
		//Assign the variables
		this.loop = false;
		this.music = false;
	}
	
	/* The constructor with the file path given */
	public AndroidAudio(int id , boolean loop , boolean music) {
		//Assign the variables
		this.loop = loop;
		this.music = music;
		//Load the audio
		this.load(id);
	}
	
	/* The method to start then audio playing */
	public void play() {
		//Check which sound to start
		if (! Settings.Video.OpenGL) {
			if (this.music)
				this.androidAudioClip.setVolume((float)((double)Settings.Audio.MusicVolume / (double)100) , (float)((double)Settings.Audio.MusicVolume / (double)100));
			else if (! this.music)
				this.androidAudioClip.setVolume((float)((double)Settings.Audio.SoundEffectVolume / (double)100) , (float)((double)Settings.Audio.SoundEffectVolume / (double)100));
			this.androidAudioClip.setLooping(loop);
			this.androidAudioClip.start();
		}
	}
	
	/* The method it stop the audio playing */
	public void stop() {
		if (! Settings.Video.OpenGL)
			this.androidAudioClip.stop();
	}
	
	/* The method to load the audio */
	public void load(int id) {
		//Check whether OpenGL is being used
		if (! Settings.Video.OpenGL)
			this.androidAudioClip = MediaPlayer.create(AndroidStore.gameActivity , id);
	}
	
	/* The method that returns whether the audio is playing */
	public boolean isPlaying() {
		//Check whether OpenGL is being used
		if (! Settings.Video.OpenGL)
			return this.androidAudioClip.isPlaying();
		else
			return false;
	}
	
}