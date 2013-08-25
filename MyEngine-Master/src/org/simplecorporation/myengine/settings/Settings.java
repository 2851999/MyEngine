/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.settings;

public class Settings {
	
	/* The version of the engine goes up 1 every development build */
	public static final String EngineVersion = "V1.0.0.9";
	
	/* Is using android */
	public static boolean Android = false;
	
	/* The window settings */
	public static class Window {
		/* The title of the window */
		public static String Title = "Window Title Here";
		/* Should the window be full screen */
		public static boolean Fullscreen = false;
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
	
}