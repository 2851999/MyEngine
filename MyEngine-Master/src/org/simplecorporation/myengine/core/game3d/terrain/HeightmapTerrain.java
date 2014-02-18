/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game3d.terrain;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.simplecorporation.myengine.utils.file.FileUtils;
import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

import static org.lwjgl.opengl.GL11.*;

public class HeightmapTerrain {
	
	/* The data in the height map */
	public float[][] data;
	
	/* The constructor */
	public HeightmapTerrain() {
		//Assign the variables
		this.data = null;
	}
	
	/* The constructor with the file path and inFolder value given */
	public HeightmapTerrain(String filePath,  boolean inFolder) {
		//Load the terrain
		this.load(filePath, inFolder);
	}
	
	/* The method used to load the terrain */
	public void load(String filePath, boolean inFolder) {
		try {
			//Define the buffered image
			BufferedImage heightmap = null;
			//Check to see whether the file is in a folder
			if (inFolder)
				//Create the buffered image
				heightmap = ImageIO.read(new File(FileUtils.asFileString(filePath)));
			else
				//Create the buffered image
				heightmap = ImageIO.read(FileUtils.class.getResourceAsStream(filePath));
			//Create the data float array
			data = new float[heightmap.getWidth()][heightmap.getHeight()];
			//The colour
			Color colour = null;
			//Iterate over the pixels in the image on the x axis
			for (int z = 0; z < data.length; z++) {
				//Iterate over the pixels in the image on the y axis
				for (int x = 0; x < data[z].length; x++) {
					//Retrieve the colour at the current location
					colour = new Color(heightmap.getRGB(z, x));
					//Store the value in the data (Can use any channel)
					data[z][x] = colour.getRed();
				}
			}
		} catch (IOException e) {
			//Log an error
			Logger.log(new Log("HeightmapTerrain", "Error reading the image " + filePath, LogType.ERROR));
			e.printStackTrace();
		}
	}
	
	/* The method used to render the terrain */
	public void render() {
		//Iterate over the 'strips' of data
		for (int z = 0; z < data.length - 1; z++) {
			glBegin(GL_TRIANGLE_STRIP);
			//Iterate over the rows of the current 'strip'
			for (int x = 0; x < data[z].length; x++) {
				glTexCoord2d(0, 0);
				//Take a vertex from the current strip
				glVertex3f(x, data[z][x], z);
				glTexCoord2d(1, 1);
				//Take a vertex from the next strip
				glVertex3d(x, data[z + 1][x], z + 1);
			}
			glEnd();
		}
	}
	
}