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

import org.simplecorporation.myengine.settings.Settings;

public class AudioClip {
	
	/* The java audio */
	public JavaAudio javaAudio;
	
	/* The android audio */
	public AndroidAudio androidAudio;
	
	/* The constructor */
	public AudioClip() {
		//Check what audio to create
		if (! Settings.Android)
			this.javaAudio = new JavaAudio();
		else if (Settings.Android)
			this.androidAudio = new AndroidAudio();
	}
	
	/* The constructor for java */
	public AudioClip(String filePath , String fileFormat , boolean loop , boolean music) {
		//Check if android is enabled
		if (! Settings.Android)
			this.javaAudio = new JavaAudio(filePath , fileFormat , loop , music);
	}
	
	/* The constructor for android */
	public AudioClip(int id , boolean loop , boolean music) {
		//Check if android is enabled
		if (Settings.Android)
			this.androidAudio = new AndroidAudio(id , loop , music);
	}
	
	/* The method to start then audio playing */
	public void play() {
		//Check if android is enabled
		if (! Settings.Android)
			this.javaAudio.play();
		else if (Settings.Android)
			this.androidAudio.play();
	}
	
	/* The method to start then audio playing with an x and y */
	public void play(double x , double y , double z) {
		//Check if android is enabled
		if (! Settings.Android)
			this.javaAudio.play(x , y , z);
	}
	
	/* The method it stop the audio playing */
	public void stop() {
		//Check if android is enabled
		if (! Settings.Android)
			this.javaAudio.stop();
		else if (Settings.Android)
			this.androidAudio.stop();
	}
	
	/* The method to load the audio for Java */
	public void load(String filePath , String fileFormat) {
		//Check if android is enabled
		if (! Settings.Android)
			this.javaAudio.load(filePath , fileFormat);
	}
	
	/* The method to load the audio for Android */
	public void load(int id) {
		//Check if android is enabled
		if (Settings.Android)
			this.androidAudio.load(id);
	}
	
	/* The method that returns whether the audio is playing */
	public boolean isPlaying() {
		//Check if android is enabled
		if (! Settings.Android)
			return this.javaAudio.isPlaying();
		else if (Settings.Android)
			return this.androidAudio.isPlaying();
		else
			return false;
	}
	
}