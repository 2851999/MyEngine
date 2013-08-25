/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.android;

import org.simplecorporation.myengine.settings.Settings;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public abstract class AndroidActivity extends Activity {
	
	/* The abstract methods*/
	public abstract void activityCreated();
	public abstract void activityPaused();
	public abstract void activityResumed();
	public abstract void activityStopped();
	public abstract void activityRestarted();
	public abstract void activityDestroy();
	
	/* The android display */
	public AndroidDisplay androidDisplay;
	
	/* The onCreate method */
	protected void onCreate(String title , Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Set the title
		this.setTitle(title);
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
	protected void onCreate(String title , AndroidGame androidGame , Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Set the title
		this.setTitle(title);
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
		//Create the display
		androidDisplay = new AndroidDisplay(this , androidGame);
		//Set the content view
		this.setContentView(androidDisplay);
		//Call the activity create method
		this.activityCreated();
	}
	
	/* Called when the activity is paused */
	public void onPause() {
		//Call the method
		this.activityPaused();
	}
	
	/* Called when the activity is resumed */
	public void onResume() {
		//Call the method
		this.activityResumed();
	}
	
	/* Called when the activity is stopped */
	public void onStop() {
		//Call the method
		this.activityStopped();
	}
	
	/* Called when the activity is restarted */
	public void onRestart() {
		//Call the method
		this.activityRestarted();
	}
	
	/* Called when the activity is destroyed */
	public void onDestroy() {
		//Call the method
		this.activityDestroy();
		//Destroy
		this.finish();
	}
	
}