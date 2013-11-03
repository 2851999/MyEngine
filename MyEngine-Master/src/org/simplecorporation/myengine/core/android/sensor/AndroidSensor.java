/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.android.sensor;

import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class AndroidSensor implements SensorEventListener {
	
	/* The constructor */
	public AndroidSensor(int sensor) {
		//Create the sensor
		SensorManager manager = (SensorManager) AndroidStore.gameActivity.getSystemService(Context.SENSOR_SERVICE);
		Sensor accelerometer = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		if (! manager.registerListener(this, accelerometer , SensorManager.SENSOR_DELAY_GAME)) {
			//An error occurred so log a message
			Logger.log(new Log("AndroidSensorAccelerometer constructor" , "Error registering a listener" , LogType.ERROR));
		}
	}
	
	/* A sensor method */
	public void onAccuracyChanged(Sensor sensor , int accuracy) {
		
	}
	
	/* Called when the sensor has changed a value */
	public void onSensorChanged(SensorEvent event) {
		
	}
	
}