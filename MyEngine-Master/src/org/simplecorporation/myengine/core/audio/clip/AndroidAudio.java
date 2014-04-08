/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.audio.clip;

import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.android.AndroidActivityListener;
import org.simplecorporation.myengine.core.android.AndroidSettings;
import org.simplecorporation.myengine.core.android.AndroidStore;

import android.media.MediaPlayer;

public class AndroidAudio extends AndroidActivityListener {
	
	/* The audio clip for android */
	public MediaPlayer androidAudioClip;
	
	/* Should the audio loop (Music) */
	public boolean loop;
	
	/* Is the audio music */
	public boolean music;
	
	/* Was the audio playing before pause */
	private boolean wasPlayingBeforePause;
	
	/* The constructor */
	public AndroidAudio() {
		//Assign the variables
		this.loop = false;
		this.music = false;
		this.wasPlayingBeforePause = false;
	}
	
	/* The constructor with the file path given */
	public AndroidAudio(int id , boolean loop , boolean music) {
		//Assign the variables
		this.loop = loop;
		this.music = music;
		this.wasPlayingBeforePause = false;
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
	
	/* The method called when the activity pauses */
	public void activityPaused() {
		//Check to see whether the PauseSoundsOnPause setting is enabled
		//and the audio is playing
		if (AndroidSettings.PauseSoundsOnPause && this.isPlaying()) {
			//Assign 'wasPlayingBeforePause' to true
			this.wasPlayingBeforePause = true;
			//Pause the audio clip
			this.androidAudioClip.pause();
		}
	}
	
	/* The method called when the activity resumes */
	public void activityResumed() {
		//Check to see whether the PauseSoundsOnPause setting is enabled
		//clip was playing before the activity was paused
		if (AndroidSettings.PauseSoundsOnPause && this.wasPlayingBeforePause) {
			//Assign 'wasPlayingBeforePause' to false
			this.wasPlayingBeforePause = false;
			//Resume the audio clip
			this.androidAudioClip.start();
		}
	}
	
}