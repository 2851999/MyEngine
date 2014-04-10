/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android;

import java.util.ArrayList;
import java.util.List;

import org.simplecorporation.myengine.core.Settings;
import org.simplecorporation.myengine.core.game.BaseGame;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

public abstract class AndroidActivity extends Activity {
	
	/* The list of listeners */
	public static List<AndroidActivityListenerInterface> activityListeners = new ArrayList<AndroidActivityListenerInterface>();
	
	/* The abstract methods*/
	public abstract void activityCreated();
	public abstract void activityPaused();
	public abstract void activityResumed();
	public abstract void activityStopped();
	public abstract void activityRestarted();
	public abstract void activityDestroy();
	
	/* The android display */
	public AndroidDisplay androidDisplay;
	
	/* The android OpenGL ES display */
	public AndroidDisplayOpenGLES androidDisplayOpenGLES;
	
	/* The onCreate method */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Set the title
		this.setTitle(Settings.Window.Title);
		//Check the orientation and set it
		if (AndroidSettings.ScreenOrientation == AndroidSettings.SCREEN_ORIENTATION_PORTRAIT)
			this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		else if (AndroidSettings.ScreenOrientation == AndroidSettings.SCREEN_ORIENTATION_LANDSCAPE)
			this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		//Check if the activity should be fullscreen
		if (Settings.Window.Fullscreen) {
			//Get rid of the title bar
			this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			//Make the activity fullscreen
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
		}
	}
	
	/* The onCreate method */
	protected void onCreate(BaseGame androidGame , Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Set the title
		this.setTitle(Settings.Window.Title);
		//Check the orientation and set it
		if (AndroidSettings.ScreenOrientation == AndroidSettings.SCREEN_ORIENTATION_PORTRAIT)
			this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		else if (AndroidSettings.ScreenOrientation == AndroidSettings.SCREEN_ORIENTATION_LANDSCAPE)
			this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		//Check if the activity should be fullscreen
		if (Settings.Window.Fullscreen) {
			//Get rid of the title bar
			this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			//Make the activity fullscreen
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
		}
		//Check the OpenGL setting
		if (! Settings.Video.OpenGL) {
			//Create the display
			this.androidDisplay = new AndroidDisplay(this , androidGame);
			//Set the content view
			this.setContentView(this.androidDisplay);
		} else if (Settings.Video.OpenGL) {
			if (this.androidDisplayOpenGLES == null) {
				//Create the OpenGL ES display
				this.androidDisplayOpenGLES = new AndroidDisplayOpenGLES(this, androidGame);
				//Set the content view
				this.setContentView(this.androidDisplayOpenGLES);
			}
		}
		//Go though all of the activity listeners
		for (AndroidActivityListenerInterface listener : activityListeners)
			//Call the method in the current listener
			listener.activityCreated();
		//Call the activity create method
		this.activityCreated();
	}
	
	/* Called when the activity is paused */
	public void onPause() {
		super.onPause();
		//Check the OpenGL setting
		if (! Settings.Video.OpenGL)
			//Pause the thread
			this.androidDisplay.androidGameThread.paused = true;
		else if (Settings.Video.OpenGL) {
			
			/* NOTE
			 * The error: IllegalStateException cause by EGLSurface not being valid
			 * seems to be fixed by removing the surface when paused and then adding
			 * it again when resumed */
			
			//Get the frame layout which has the AndroidDisplayOpenGLES instance in it
			FrameLayout layout = (FrameLayout) this.androidDisplayOpenGLES.getParent();
			//Remove the instance of AndroidDisplayOpenGLES
			layout.removeView(this.androidDisplayOpenGLES);
			//Pause the OpenGL ES display
			this.androidDisplayOpenGLES.onPause();
		}
		//Go though all of the activity listeners
		for (AndroidActivityListenerInterface listener : activityListeners)
			//Call the method in the current listener
			listener.activityPaused();
		//Call the method
		this.activityPaused();
	}
	
	/* Called when the activity is resumed */
	public void onResume() {
		super.onResume();
		//Check the OpenGL setting
		if (! Settings.Video.OpenGL)
			//Resume the thread
			this.androidDisplay.androidGameThread.paused = false;
		else if (Settings.Video.OpenGL) {
			this.setContentView(this.androidDisplayOpenGLES);
			//Resume the OpenGL ES display
			this.androidDisplayOpenGLES.onResume();
		}
		//Go though all of the activity listeners
		for (AndroidActivityListenerInterface listener : activityListeners)
			//Call the method in the current listener
			listener.activityResumed();
		//Call the method
		this.activityResumed();
	}
	
	/* Called when the activity is stopped */
	public void onStop() {
		super.onStop();
		//Go though all of the activity listeners
		for (AndroidActivityListenerInterface listener : activityListeners)
			//Call the method in the current listener
			listener.activityStopped();
		//Call the method
		this.activityStopped();
	}
	
	/* Called when the activity is restarted */
	public void onRestart() {
		super.onRestart();
		//Go though all of the activity listeners
		for (AndroidActivityListenerInterface listener : activityListeners)
			//Call the method in the current listener
			listener.activityRestarted();
		//Call the method
		this.activityRestarted();
	}
	
	/* Called when the activity is destroyed */
	public void onDestroy() {
		super.onDestroy();
		//Go though all of the activity listeners
		for (AndroidActivityListenerInterface listener : activityListeners)
			//Call the method in the current listener
			listener.activityDestroy();
		//Call the method
		this.activityDestroy();
		//Destroy
		this.finish();
	}
	
	/* The static method used to add an AndroidActivityListener to the list */
	public static void addListener(AndroidActivityListener listener) {
		//Add the listener to the list of listeners
		activityListeners.add(listener);
	}
	
}