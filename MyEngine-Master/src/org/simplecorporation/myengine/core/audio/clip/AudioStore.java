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

import java.util.LinkedList;

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class AudioStore {
	
	/* The image packs */
	private static LinkedList<AudioPack> audioPacks = new LinkedList<AudioPack>();
	
	/* The method to add an audio pack */
	public static void add(AudioPack imagePack) {
		audioPacks.add(imagePack);
	}
	
	/* The method that returns an audio pack given its name */
	public static AudioPack getPackByName(String name) {
		//The audio pack
		AudioPack audioPack = null;
		//Loop
		for (int a = 0; a < audioPacks.size(); a++) {
			//Check if the current audio pack has the right name
			if (audioPacks.get(a).getPackName().equals(name)) {
				//Assign the audio pack
				audioPack = audioPacks.get(a);
				//Exit the loop
				break;
			}
		}
		//Check to see whether the audio pack was found
		if (audioPack == null)
			//Log an error
			Logger.log(new Log("AudioStore getPackByName()" , "The pack with the name " + name + " was not found" , LogType.ERROR));
		//Return the audio pack
		return audioPack;
	}
	
	/* The method that returns an audio pack given its id */
	public static AudioPack getPackById(int id) {
		//The audio pack
		AudioPack audioPack = null;
		//Loop
		for (int a = 0; a < audioPacks.size(); a++) {
			//Check if the current audio pack has the right id
			if (audioPacks.get(a).getPackId() == id) {
				//Assign the audio pack
				audioPack = audioPacks.get(a);
				//Exit the loop
				break;
			}
		}
		//Check to see whether the audio pack was found
		if (audioPack == null)
			//Log an error
			Logger.log(new Log("AudioStore getPackById()" , "The pack with the id " + id + " was not found" , LogType.ERROR));
		//Return the audio pack
		return audioPack;
	}
	
}