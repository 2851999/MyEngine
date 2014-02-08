/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.settings;

import java.util.LinkedList;

import org.simplecorporation.myengine.utils.file.FileUtils;

public class Settings {
	
	/* The version of the engine goes up 1 every development build */
	public static final String EngineVersion = "V1.0.5.4";
	
	/* The type of build this version of the engine is*/
	public static final String EngineBuild = "Development";
	
	/* Is using android */
	public static boolean Android = false;
	
	/* Is an applet */
	public static boolean Applet = false;
	
	/* The window settings */
	public static class Window {
		/* The title of the window */
		public static String Title = "Window Title Here";
		/* Should the window be full screen */
		public static boolean Fullscreen = false;
		/* Should the window have a border (NOTE: Only works for Java)
		 * if you wish to run in borderless mode when using OpenGL, when executing the code add
		 * this parameter: -Dorg.lwjgl.opengl.Window.undecorated=true */
		public static boolean Border = true;
		/* The size of the window */
		public static class Size {
			/* The width */
			public static float Width = 640;
			/* The height of the window */
			public static float Height = 480;
		}
	}
	
	/* The settings for video */
	public static class Video {
		/* The maximum FPS */
		public static int MaxFPS = 60;
		/* Is VSync enabled */
		public static boolean VSync = true;
		/* Is OpenGL being used */
		public static boolean OpenGL = false;
		/* Should anti aliasing be used */
		public static boolean AntiAliasing = false;
	}
	
	/* The settings for audio */
	public static class Audio {
		/* The sound effect volume */
		public static int SoundEffectVolume = 100;
		/* The music volume */
		public static int MusicVolume = 100;
	}
	
	/* The settings for debugging */
	public static class Debugging {
		/* The variable that states whether the debug info should be drawn
		 * on the screen */
		public static boolean ShowInfo = true;
		/* The variable that states whether to render boxes around images */
		public static boolean ShowImageBoxes = true;
	}
	
	/* The method to read a configuration file to set all of the settings */
	public static void readConfig(String filePath , boolean inFolder) {
		//Read the file
		LinkedList<String> fileText = FileUtils.read(filePath , inFolder);
		//Look at each string in the list
		for (int a = 0; a < fileText.size(); a++) {
			//Split the current line into its setting and value
			String[] split = fileText.get(a).split(": ");
			//Check what the current line is setting
			if (split[0].equals("Android"))
				//Set the value
				Settings.Android = split[1].equals("true");
			else if (split[0].equals("Window.Title"))
				//Set the value
				Settings.Window.Title = split[1];
			else if (split[0].equals("Window.Fullscreen"))
				//Set the value
				Settings.Window.Fullscreen = split[1].equals("true");
			else if (split[0].equals("Window.Border"))
				//Set the value
				Settings.Window.Border = split[1].equals("true");
			else if (split[0].equals("Window.Size.Width"))
				//Set the value
				Settings.Window.Size.Width = Float.parseFloat(split[1]);
			else if (split[0].equals("Window.Size.Height"))
				//Set the value
				Settings.Window.Size.Height = Float.parseFloat(split[1]);
			else if (split[0].equals("Video.MaxFPS"))
				//Set the value
				Settings.Video.MaxFPS = Integer.parseInt(split[1]);
			else if (split[0].equals("Video.VSync"))
				//Set the value
				Settings.Video.VSync = split[1].equals("true");
			else if (split[0].equals("Video.OpenGL"))
				//Set the value
				Settings.Video.OpenGL = split[1].equals("true");
			else if (split[0].equals("Video.AntiAliasing"))
				//Set the value
				Settings.Video.AntiAliasing = split[1].equals("true");
			else if (split[0].equals("Audio.SoundEffectVolume"))
				//Set the value
				Settings.Audio.SoundEffectVolume = Integer.parseInt(split[1]);
			else if (split[0].equals("Audio.MusicVolume"))
				//Set the value
				Settings.Audio.MusicVolume = Integer.parseInt(split[1]);
		}
	}
	
	/* The method to save the configuration file of all of the settings */
	public static void writeConfig(String filePath) {
		//The linked list with all of the configuration data
		LinkedList<String> fileText = new LinkedList<String>();
		//Add all for the settings to the linked list
		fileText.add("Android: " + Settings.Android);
		fileText.add("Window.Title: " + Settings.Window.Title);
		fileText.add("Window.Fullscreen: " + Settings.Window.Fullscreen);
		fileText.add("Window.Border: " + Settings.Window.Border);
		fileText.add("Window.Size.Width: " + Settings.Window.Size.Width);
		fileText.add("Window.Size.Height: " + Settings.Window.Size.Height);
		fileText.add("Video.MaxFPS: " + Settings.Video.MaxFPS);
		fileText.add("Video.VSync: " + Settings.Video.VSync);
		fileText.add("Video.OpenGL: " + Settings.Video.OpenGL);
		fileText.add("Video.AntiAliasing: " + Settings.Video.AntiAliasing);
		fileText.add("Audio.SoundEffectVolume: " + Settings.Audio.SoundEffectVolume);
		fileText.add("Audio.MusicVolume: " + Settings.Audio.MusicVolume);
		//Save the file
		FileUtils.write(filePath , fileText);
	}
	
}