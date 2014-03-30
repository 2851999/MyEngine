/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game;

import org.simplecorporation.myengine.core.audio.clip.AudioClip;
import org.simplecorporation.myengine.core.audio.clip.AudioPack;

public class GameAudioResourcePack extends GameResourcePack {
	
	/* The audio file type */
	public String fileType;
	
	/* Should this audio loop */
	public boolean loop;
	
	/* Is this audio music */
	public boolean music;
	
	/* The constructor */
	public GameAudioResourcePack(String name, boolean inFolder, String fileType) {
		//Call the super constructor
		super(name, inFolder);
		//Assign the variables
		this.fileType = fileType;
	}
	
	/* The method to create the audio resource pack and return it */
	public AudioPack getAudioPack(int id) {
		//The audio pack
		AudioPack audioPack = new AudioPack(this.name, id);
		//Look at every directory in the directories list
		for (int a = 0; a < this.resources.size(); a++) {
			//Create and add the current resource to the image pack
			audioPack.add(this.resources.get(a).name, a, new AudioClip(this.resources.get(a).name, fileType, loop, music));
		}
		//Return the audio pack
		return audioPack;
	}
	
}