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

import java.util.LinkedList;

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class AudioPack {
	
	/* The name of the audio pack */
	private String packName;
	
	/* Id of the audio pack */
	private int packId;
	
	/* The images in the audio pack */
	private LinkedList<AudioClip> audio;
	
	/* The image names in the audio pack */
	private LinkedList<String> audioNames;
	
	/* The image id in the audio pack */
	private LinkedList<Integer> audioIds;
	
	/* The constructor of an audio pack */
	public AudioPack(String packName , int packId) {
		//Assign the variables
		this.packName = packName;
		this.packId = packId;
		this.audio = new LinkedList<AudioClip>();
	}
	
	/* The method to add an audio to the audio */
	public void add(String name , int id , AudioClip audio) {
		this.audioNames.add(name);
		this.audioIds.add(id);
		this.audio.add(audio);
	}
	
	/* The method to get an audio given its name */
	public AudioClip getAudioByName(String name) {
		//The audio
		AudioClip audio = null;
		//Loop
		for (int a = 0; a < this.audioNames.size(); a++) {
			//Check if the current name equals the name given
			if (this.audioNames.get(a).equals(name)) {
				//Assign the audio
				audio = this.audio.get(a);
				//Exit the loop
				break;
			}
		}
		//Check to see whether the audio was found
		if (audio == null)
			//Log an error
			Logger.log(new Log("AudioPack getAudioByName()" , "The audio with the name " + name + " was not found" , LogType.ERROR));
		//Return the audio
		return audio;
	}
	
	/* The method to get an audio given its id */
	public AudioClip getAudioById(int id) {
		//The audio
		AudioClip audio = null;
		//Loop
		for (int a = 0; a < this.audioIds.size(); a++) {
			//Check if the current id equals the id given
			if (this.audioIds.get(a) == id) {
				//Assign the audio
				audio = this.audio.get(a);
				//Exit the loop
				break;
			}
		}
		//Check to see whether the audio was found
		if (audio == null)
			//Log an error
			Logger.log(new Log("AudioPack getAudioById()" , "The audio with the id " + id + " was not found" , LogType.ERROR));
		//Return the audio
		return audio;
	}
	
	/* The method to get the pack name */
	public String getPackName() {
		return this.packName;
	}
	
	/* The method to get the pack id */
	public int getPackId() {
		return this.packId;
	}
	
}