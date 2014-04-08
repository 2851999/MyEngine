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

import java.io.FileInputStream;
import java.io.IOException;

import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.android.AndroidActivityListener;
import org.simplecorporation.myengine.core.android.AndroidSettings;
import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.core.logger.Log;
import org.simplecorporation.myengine.core.logger.LogType;
import org.simplecorporation.myengine.core.logger.Logger;
import org.simplecorporation.myengine.utils.AndroidFileUtils;

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
	
	/* The constructor with the file id given */
	public AndroidAudio(int id , boolean loop , boolean music) {
		//Assign the variables
		this.loop = loop;
		this.music = music;
		this.wasPlayingBeforePause = false;
		//Load the audio
		this.load(id);
	}
	
	/* The constructor with the filePath given */
	public AndroidAudio(String filePath , boolean loop , boolean music) {
		//Assign the variables
		this.loop = loop;
		this.music = music;
		this.wasPlayingBeforePause = false;
		//Load the audio
		this.load(filePath);
	}
	
	/* The constructor with the filePath and external boolean value given */
	public AndroidAudio(String filePath, boolean external, boolean loop , boolean music) {
		//Assign the variables
		this.loop = loop;
		this.music = music;
		this.wasPlayingBeforePause = false;
		//Load the audio
		this.load(filePath, external);
	}
	
	/* The method to start then audio playing */
	public void play() {
		//Check which sound to start
		if (this.music)
			//Set the music volume
			this.androidAudioClip.setVolume((float)((double)Settings.Audio.MusicVolume / (double)100) , (float)((double)Settings.Audio.MusicVolume / (double)100));
		else if (! this.music)
			//Set the sound effect volume
			this.androidAudioClip.setVolume((float)((double)Settings.Audio.SoundEffectVolume / (double)100) , (float)((double)Settings.Audio.SoundEffectVolume / (double)100));
		//Make sure the clip loops if needed
		this.androidAudioClip.setLooping(loop);
		//Start the audio clip
		this.androidAudioClip.start();
	}
	
	/* The method it stop the audio playing */
	public void stop() {
		//Stop the audio clip
		this.androidAudioClip.stop();
	}
	
	/* The method to load the audio */
	public void load(int id) {
		//Create the audio clip
		this.androidAudioClip = MediaPlayer.create(AndroidStore.gameActivity , id);
	}
	
	/* The method used to load the audio using the file path */
	public void load(String filePath) {
		//Create the media player
		this.androidAudioClip = new MediaPlayer();
		//Try and catch statement
		try {
			//Set the data source of the audio clip
			this.androidAudioClip.setDataSource(new FileInputStream(filePath).getFD());
			//Prepare the audio
			this.androidAudioClip.prepare();
		} catch (IllegalArgumentException e) {
			//Log an error
			Logger.log(new Log("AndroidAudio load(String filePath)", "IllegalArgumentException when loading the file " + filePath, LogType.ERROR));
		} catch (SecurityException e) {
			//Log an error
			Logger.log(new Log("AndroidAudio load(String filePath)", "SecurityException when loading the file " + filePath, LogType.ERROR));
		} catch (IllegalStateException e) {
			//Log an error
			Logger.log(new Log("AndroidAudio load(String filePath)", "IllegalStateException when loading the file " + filePath, LogType.ERROR));
		} catch (IOException e) {
			//Log an error
			Logger.log(new Log("AndroidAudio load(String filePath)", "IOException when loading the file " + filePath, LogType.ERROR));
		}
	}
	
	/* The method used to load the audio using the file path and whether the file
	 * is external */
	public void load(String filePath, boolean external) {
		//Load the audio
		this.load(AndroidFileUtils.getFile(filePath, external).toString());
	}
	
	/* The method that returns whether the audio is playing */
	public boolean isPlaying() {
		return this.androidAudioClip.isPlaying();
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