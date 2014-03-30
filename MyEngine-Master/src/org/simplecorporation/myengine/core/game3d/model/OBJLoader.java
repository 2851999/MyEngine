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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.simplecorporation.myengine.core.game3d.vector.Vector3D;
import org.simplecorporation.myengine.core.logger.Log;
import org.simplecorporation.myengine.core.logger.LogType;
import org.simplecorporation.myengine.core.logger.Logger;
import org.simplecorporation.myengine.utils.FileUtils;

public class OBJLoader {
	
	/* The method used to load and return an obj file */
	public static Model loadModel(String filePath, boolean inFolder) {
		//The model
		Model model = new Model();
		//Try
		try {
			//The buffered reader
			BufferedReader bufferedReader = null;
			//Check to see whether the file is in a folder
			if (inFolder) {
				//Create a file reader
				FileReader fileReader = new FileReader(FileUtils.asFileString(filePath));
				//Create the buffered reader
				bufferedReader = new BufferedReader(fileReader);
			} else {
				//Create the buffered reader
				bufferedReader = new BufferedReader(new InputStreamReader(FileUtils.class.getResourceAsStream(filePath)));
			}
			
			//The current line
			String line = "";
			//The current material
			Material currentMaterial = null;
			//Go through the file text
			while ((line = bufferedReader.readLine()) != null) {
				//Check the start of the current line
				if (line.startsWith("v "))
					//Add a vertex to the model
					model.addVertex(ModelParserUtils.getVectorValue(line));
				else if (line.startsWith("vn "))
					//Add a normal to the model
					model.addNormal(ModelParserUtils.getVectorValue(line));
				else if (line.startsWith("vt "))
					//Add a texture to the model
					model.addTexture(ModelParserUtils.getVectorValue(line));
				else if (line.startsWith("f "))
					//Add a face to the model
					model.addFace(getFace(line, currentMaterial));
				else if (line.startsWith("mtllib ")) {
					//Split up the line
					String[] split = line.split(" ");
					//Get the this object's file name
					String fileName = new File(FileUtils.asFileString(filePath)).getName();
					//Get the file path of the material file
					String materialFilePath = filePath.replace(fileName, split[1]);
					//Load the material
					model.materials = MaterialLoader.loadMaterialFile(materialFilePath, inFolder, model.materials);
				} else if (line.startsWith("usemtl ")) {
					//Split up the line
					String[] split = line.split(" ");
					//Set the current material
					currentMaterial = model.getMaterial(split[1]);
				}
			}
			
			//Close the buffer
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			//Log an error message
			Logger.log(new Log("OBJLoader loadModel()", "Error loading file (FileNotFoundExeption) " + filePath, LogType.ERROR));
			//Print the error
			e.printStackTrace();
		} catch (IOException e) {
			//Log an error message
			Logger.log(new Log("OBJLoader loadModel()", "Error loading file (IOException) " + filePath, LogType.ERROR));
			//Print the error
			e.printStackTrace();
		}
		//Return the model
		return model;
	}
	
	/* The method used to get a face from a line */
	public static Face getFace(String line, Material currentMaterial) {
		//Split up the line using a space 1//2 1//2 1//2
		String[] split = line.split(" ");
		
		//The vertices, normals and textures
		double vertexX = 0;
		double vertexY = 0;
		double vertexZ = 0;
		double normalX = 0;
		double normalY = 0;
		double normalZ = 0;
		double textureX = 0;
		double textureY = 0;
		double textureZ = 0;
		
		//Calculate the face values
		double[] p1 = calculateFaceValues(split[1]);
		double[] p2 = calculateFaceValues(split[2]);
		double[] p3 = calculateFaceValues(split[3]);
		
		//Assign the vertices, normals and textures
		vertexX = p1[0];
		vertexY = p2[0];
		vertexZ = p3[0];
		normalX = p1[1];
		normalY = p2[1];
		normalZ = p3[1];
		textureX = p1[2];
		textureY = p2[2];
		textureZ = p3[2];
		
		//The vectors for the vertices, normals and textures
		Vector3D vertices = null;
		Vector3D normals = null;
		Vector3D textures = null;
		
		//Check to see whether there are any vertex, normal or texture values
		if (vertexX != 0 && vertexY != 0 && vertexZ != 0)
			//Set the vertices
			vertices = new Vector3D(vertexX, vertexY, vertexZ);
		if (normalX != 0 && normalY != 0 && normalZ != 0)
			//Set the normals
			normals = new Vector3D(normalX, normalY, normalZ);
		if (textureX != 0 && textureY != 0 && textureZ != 0)
			//Set the textures
			textures = new Vector3D(textureX, textureY, textureZ);
		
		//Create the face
		Face face = new Face(vertices, normals, textures, currentMaterial);
		//Return the face
		return face;
	}
	
	/* The method used to calculate face values of a certain part of a face */
	public static double[] calculateFaceValues(String facePart) {
		//The values
		double[] values = new double[3];
		//Find the correct format of the current part of the face
		if (facePart.contains("//")) {
			//FORMAT V//VN
			
			//Split the face part using "//"
			String[] split = facePart.split("//");
			//Set the vertex and the normal
			values[0] = getValue(split[0]);
			values[1] = getValue(split[1]);
			values[2] = 0;
		} else if (facePart.contains("/")) {
			//FORMAT V/VT OR V/VT/VN
			
			//Split up the face part using a "/"
			String[] split = facePart.split("/");
			//Check the split length
			if (split.length == 2) {
				//FORMAT V/VT
				
				//Set the vertex and the texture
				values[0] = getValue(split[0]);
				values[1] = 0;
				values[2] = getValue(split[1]);
			} else if (split.length == 3) {
				//FORMAT V/VN/VT
				
				//Set the vertex, normal and the texture
				values[0] = getValue(split[0]);
				values[1] = getValue(split[2]);
				values[2] = getValue(split[1]);
			}
		} else {
			//FORMAT = V
			
			//Set the vertex
			values[0] = getValue(facePart);
			values[1] = 0;
			values[2] = 0;
		}
		//Return the values
		return values;
	}
	
	/* The method used to get the double value of a string */
	public static double getValue(String value) {
		//Return the double
		return Double.parseDouble(value);
	}
	
}