/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.audio.clip.AudioStore;
import org.simplecorporation.myengine.core.gui.font.FontStore;
import org.simplecorporation.myengine.core.image.ImageStore;

public class Game extends BaseGame {
	
	/* The image resource packs */
	public LinkedList<GameImageResourcePack> imageResourcePacks;
	
	/* The audio resource packs */
	public LinkedList<GameAudioResourcePack> audioResourcePacks;
	
	/* The constructor */
	public Game() {
		//Create the linked lists
		this.imageResourcePacks = new LinkedList<GameImageResourcePack>();
		this.audioResourcePacks = new LinkedList<GameAudioResourcePack>();
		
		////////////////LOAD THE GAME////////////////
		
		//Look at all of the image resource packs
		for (int a = 0; a < this.imageResourcePacks.size(); a++) {
			//Add the resource pack to the image store
			ImageStore.add(this.imageResourcePacks.get(a).getImagePack(a));
		}
		
		//Look at all of the audio resource packs
		for (int a = 0; a < this.audioResourcePacks.size(); a++) {
			//Add the audio pack to the image store
			AudioStore.add(this.audioResourcePacks.get(a).getAudioPack(a));
		}
		
		
		//Load the fonts and images
		FontStore.load();
		ImageStore.load();
		
		//Create the game
		this.createGame();
	}
	
	/* The method used to add an image resource pack */
	public void addResourcePack(GameImageResourcePack resourcePack) {
		//Add the pack to the correct list
		this.imageResourcePacks.addLast(resourcePack);
	}
	
	/* The method used to add an audio resource pack */
	public void addResourcePack(GameAudioResourcePack resourcePack) {
		//Add the pack to the correct list
		this.audioResourcePacks.add(resourcePack);
	}
	
}