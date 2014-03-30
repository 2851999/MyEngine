/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game3d.model;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.simplecorporation.myengine.core.game3d.vector.Vector3D;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.FileUtils;

public class MaterialLoader {
	
	/* The method used to load a material  and return it */
	public static List<Material> loadMaterialFile(String filePath, boolean inFolder, List<Material> materials) {
		//The file text
		LinkedList<String> fileText = FileUtils.read(filePath, inFolder);
		//The current material
		Material currentMaterial = null;
		//Go though each line in the material file
		for (int a = 0; a < fileText.size(); a++) {
			//Get the current line
			String line = fileText.get(a);
			//Check the beginning of the line
			if (line.startsWith("newmtl ")) {
				//Split up the line using a space
				String[] split = line.split(" ");
				//Check to see whether the current material has been set
				if (currentMaterial != null)
					//Add the current material to the list of materials
					materials.add(currentMaterial);
				//Create the new material
				currentMaterial = new Material(split[1]);
			} else if (line.startsWith("Ka ")) {
				//Get the vector values
				Vector3D values = ModelParserUtils.getVectorValue(line);
				//Set the ambient colour in the current material
				currentMaterial.ambientColour = new Colour(values.x, values.y, values.z);
			} else if (line.startsWith("Kd ")) {
				//Get the vector values
				Vector3D values = ModelParserUtils.getVectorValue(line);
				//Set the diffuse colour in the current material
				currentMaterial.diffuseColour = new Colour(values.x, values.y, values.z);
			} else if (line.startsWith("Ks ")) {
				//Get the vector values
				Vector3D values = ModelParserUtils.getVectorValue(line);
				//Set the specular colour in the current material
				currentMaterial.specularColour = new Colour(values.x, values.y, values.z);
			} else if (line.startsWith("Ns ")) {
				//Split up the current line
				String[] split = line.split(" ");
				//Get the shininess value
				double shininess = Double.parseDouble(split[1]);
				//Set the shininess colour in the current material
				currentMaterial.shininess = shininess;
			} else if (line.startsWith("d ") || line.startsWith("Tr ")) {
				//Split up the current line using a space
				String[] split = line.split(" ");
				//Get the alpha colour value
				double alphaColourValue = getValue(split[1]);
				//Set the alpha colour value in the current material
				currentMaterial.alphaColourValue = alphaColourValue;
			} else if (line.startsWith("map_d")) {
				//Split up the current line using a space
				String[] split = line.split(" ");
				//Get the this material's file name
				String fileName = new File(FileUtils.asFileString(filePath)).getName();
				//Get the file path of the material file
				String textureFilePath = filePath.replace(fileName, split[1]);
				//The texture format
				String textureFormat = split[1].substring(split[1].lastIndexOf(".")).toUpperCase();
				//Load the alpha texture map
				Image alphaTextureMap = new Image(textureFilePath, textureFormat, inFolder);
				//Set the alpha texture map in the current material
				currentMaterial.alphaTextureMap = alphaTextureMap;
			}
		}
		//Return the materials
		return materials;
	}
	
	/* The method used to get the double value of a string */
	public static double getValue(String value) {
		//Return the double
		return Double.parseDouble(value);
	}
	
}