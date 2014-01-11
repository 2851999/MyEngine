/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.screen;

import java.awt.Toolkit;

import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.settings.Settings;

import android.util.DisplayMetrics;

public class ScreenUtils {
	
	/* The method to get the current screens width */
	public static int getScreenWidth() {
		//Check if android is enabled or not
		if (! Settings.Android)
			//Return the displays width
			return Toolkit.getDefaultToolkit().getScreenSize().width;
		else if (Settings.Android) {
			//The display metrics
			DisplayMetrics displayMetrics = new DisplayMetrics();
			//Set the display metrics
			AndroidStore.gameActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
			//Return the width of the screen
			return displayMetrics.widthPixels;
		} else
			return 0;
	}
	
	/* The method to get the current screens height */
	public static int getScreenHeight() {
		//Check if android is enabled or not
		if (! Settings.Android)
			//Return the displays height
			return Toolkit.getDefaultToolkit().getScreenSize().height;
		else if (Settings.Android) {
			//The display metrics
			DisplayMetrics displayMetrics = new DisplayMetrics();
			//Set the display metrics
			AndroidStore.gameActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
			//Return the height of the screen
			return displayMetrics.heightPixels;
		} else
			return 0;
	}
	
}