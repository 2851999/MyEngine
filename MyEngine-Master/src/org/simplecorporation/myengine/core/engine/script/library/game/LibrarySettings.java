/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script.library.game;

import org.simplecorporation.myengine.core.engine.script.ScriptClass;
import org.simplecorporation.myengine.core.engine.script.ScriptInterpreter;
import org.simplecorporation.myengine.core.engine.script.ScriptLibrary;
import org.simplecorporation.myengine.settings.Settings;

public class LibrarySettings extends ScriptLibrary {
	
	/* The library name */
	public static final String LIBRARY_NAME = "LibrarySettings";
	
	/* The library description */
	public static final String LIBRARY_DESCRIPTION = "Library Settings (The settings library)";
	
	/* The library package */
	public static final String LIBRARY_PACKAGE = "org.sl.java.game.Settings";
	
	/* The library reference */
	public static final String LIBRARY_REFERENCE = "Settings";
	
	/* The library short reference */
	public static final String LIBRARY_SHORT_REFERENCE = "Settings";
	
	/* The constructor */
	public LibrarySettings() {
		//Call the super constructor
		super(LIBRARY_NAME , LIBRARY_DESCRIPTION , LIBRARY_PACKAGE , LIBRARY_REFERENCE , LIBRARY_SHORT_REFERENCE);
	}
	
	/* The method used to parse code */
	public void parseCode(String line , ScriptClass scriptClass) {
		//Split the current line
		String[] split = line.split(" ");
		//Check the second split
		if (split[1].equals("set")) {
			//Check the third split
			if (split[2].equals("Window")) {
				//Check the fourth split
				if (split[3].equals("Title")) {
					//Set the window title
					Settings.Window.Title = ScriptInterpreter.getStringValue(split , 4);
				} else if (split[3].equals("Fullscreen")) {
					//Set the window full screen
					Settings.Window.Fullscreen = split[4].equals("true");
				} else if (split[3].equals("Border")) {
					//Set the window border
					Settings.Window.Border = split[4].equals("true");
				} else if (split[3].equals("Size")) {
					//Check the fifth split
					if (split[4].equals("Width")) {
						//Set the window width
						Settings.Window.Size.Width = Float.parseFloat(split[5]);
					} else if (split[4].equals("Height"))
						//Set the window height
						Settings.Window.Size.Height = Float.parseFloat(split[5]);
				}
			} else if (split[2].equals("Video")) {
				//Check the fourth split
				if (split[3].equals("AntiAliasing")) {
					//Set AntiAliasing
					Settings.Video.AntiAliasing = split[4].equals("true");
				} else if (split[3].equals("OpenGL")) {
					//Set OpenGL
					Settings.Video.OpenGL = split[4].equals("true");
				} else if (split[3].equals("VSync")) {
					//Set VSync
					Settings.Video.VSync = split[4].equals("true");
				} else if (split[3].equals("MaxFPS")) {
					//Set MaxFPS
					Settings.Video.MaxFPS = Integer.parseInt(split[4]);
				}
			} else if (split[2].equals("Audio")) {
				//Check the fourth split
				if (split[3].equals("MusicVolume")) {
					//Set MusicVolume
					Settings.Audio.MusicVolume = Integer.parseInt(split[4]);
				}  else if (split[3].equals("SoundEffectVolume")) {
					//Set SoundEffectVolume
					Settings.Audio.SoundEffectVolume = Integer.parseInt(split[4]);
				}
			}
		}
	}
	
	/* The method used to return a new instance of this library */
	public ScriptLibrary getInstance() {
		return new LibrarySettings();
	}
	
}