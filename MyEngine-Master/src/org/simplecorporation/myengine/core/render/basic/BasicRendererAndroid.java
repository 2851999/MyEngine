/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.render.basic;

import org.simplecorporation.myengine.core.android.AndroidStore;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

public class BasicRendererAndroid {
	
	/* The method to set the colour */
	public static void setColour(Colour colour) {
		//Get the Paint object and set the colour
		AndroidStore.gamePaint.setColor(Color.argb((int)(colour.a * 255) , (int)(colour.r * 255) , (int)(colour.g * 255) , (int)(colour.b * 255)));
	}
	
	/* The method to render an unfilled rectangle */
	public static void renderRectangle(double x , double y , double width , double height) {
		//Render the rectangle
		AndroidStore.gamePaint.setStyle(Paint.Style.STROKE);
		AndroidStore.gameCanvas.drawRect((float)x , (float)y , (float)x + (float)width , (float)y + (float)height , AndroidStore.gamePaint);
		AndroidStore.gamePaint.setStyle(Paint.Style.FILL);
	}
	
	/* The method to render a filled rectangle */
	public static void renderFilledRectangle(double x , double y , double width , double height) {
		//Render the rectangle
		AndroidStore.gamePaint.setStyle(Paint.Style.FILL);
		AndroidStore.gameCanvas.drawRect((float)x , (float)y , (float)x + (float)width , (float)y + (float)height , AndroidStore.gamePaint);
	}
	
	/* The method to render a line */
	public static void renderLine(double startx , double starty , double endx , double endy) {
		//Render the line
		AndroidStore.gameCanvas.drawLine((float)startx , (float)starty , (float)endx , (float)endy , AndroidStore.gamePaint);
	}
	
	/* The method to render an image */
	public static void renderImage(Image image , double x , double y) {
		//Render the image
		AndroidStore.gameCanvas.drawBitmap(image.getAndroidImage() , (float)x , (float)y , AndroidStore.gamePaint);
	}
	
	/* The method to render an image with a specified width and height */
	public static void renderImage(Image image , double x , double y , double width , double height) {
		//Create the matrix
		Matrix matrix = new Matrix();
		matrix.setTranslate((float)x , (float)y);
		matrix.setScale((float)width / (float)image.getWidth() , (float)height / (float)image.getHeight());
		//Render the image
		AndroidStore.gameCanvas.drawBitmap(image.getAndroidImage() , matrix , AndroidStore.gamePaint);
	}
	
}