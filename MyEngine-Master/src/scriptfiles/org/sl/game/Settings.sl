package org.sl.game

uses org.sl.java.game.Settings

global class Settings
	
	#Method to set the window title
	global method setWindowTitle($title)
		Settings set Window Title $title
	endmethod
	
	#Method to set the window border (boolean)
	global method setWindowBorder($border)
		Settings set Window Border $border
	endmethod
	
	#Method to set the window fullscreen (boolean)
	global method setWindowFullscreen($fullscreen)
		Settings set Window Fullscreen $fullscreen
	endmethod
	
	#Method to set the window width (integer/float)
	global method setWindowWidth($width)
		Settings set Window Size Width $width
	endmethod

	#Method to set the window height (integer/float)
	global method setWindowHeight($height)
		Settings set Window Size Height $height
	endmethod
	
	#Method to set the window size (integer/float)
	global method setWindowSize($width,$height)
		Settings set Window Size Width $width
		Settings set Window Size Height $height
	endmethod
	
	#Method to set video (AntiAliasing) (boolean)
	global method setVideoAntiAliasing($antiAliasing)
		Settings set Video AntiAliasing antiAliasing
	endmethod
	
	#Method to set video (OpenGL) (boolean)
	global method setVideoOpenGL($openGL)
		Settings set Video OpenGL openGL
	endmethod
	
	#Method to set video (VSync) (boolean)
	global method setVideoVSync($vSync)
		Settings set Video VSync vSync
	endmethod
	
	#Method to set video (MaxFPS) (integer)
	global method setVideoMaxFPS($maxFPS)
		Settings set Video MaxFPS maxFPS
	endmethod
	
	#Method to set music (MusicVolume) (integer)
	global method setAudioMusicVolume($musicVolume)
		Settings set Audio MusicVolume musicVolume
	endmethod
	
	#Method to set music (SoundEffectVolume) (integer)
	global method setAudioSoundEffectVolume($soundEffectVolume)
		Settings set Audio SoundEffectVolume soundEffectVolume
	endmethod
	
endclass 