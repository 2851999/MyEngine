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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.simplecorporation.myengine.core.game3d.vector.Vector3D;
import org.simplecorporation.myengine.utils.file.FileUtils;

public class OBJLoader {
	
	/* The method used to load a model and return it */
	public static Model loadModel(String filePath, boolean inFolder) {
		//The instance of the model
		Model model = new Model();
		try {
			//The buffered reader
			BufferedReader bufferedReader = null;
			//Check whether the file is in a folder
			if (inFolder) {
				//Setup the buffered reader
				FileReader fileReader = new FileReader(FileUtils.asFileString(filePath));
				bufferedReader = new BufferedReader(fileReader);
			} else {
				//Setup the buffered reader
				bufferedReader = new BufferedReader(new InputStreamReader(FileUtils.class.getResourceAsStream(filePath)));
			}
			
			//The current line
			String line = "";
			//Keep going though the file untill it reaches the end
			while ((line = bufferedReader.readLine()) != null) {
				//Check to see what part of the model the current line is part of
				if (line.startsWith("v ")) {
					//Split up the current line
					String[] split = line.split(" ");
					//Get the x, y and z values
					double x = Double.valueOf(split[1]);
					double y = Double.valueOf(split[2]);
					double z = Double.valueOf(split[3]);
					//Create the vertex
					Vector3D vertex = new Vector3D(x, y, z);
					//Add the vertex to the model
					model.vertices.add(vertex);
				} else if (line.startsWith("vn ")) {
					//Split up the current line
					String[] split = line.split(" ");
					//Get the x, y and z values
					double x = Double.valueOf(split[1]);
					double y = Double.valueOf(split[2]);
					double z = Double.valueOf(split[3]);
					//Create the normal
					Vector3D normal = new Vector3D(x, y, z);
					//Add the vertex to the model
					model.normals.add(normal);
				} else if (line.startsWith("f ")) {
					//Split up the current line
					String[] split = line.split(" ");
					//Get the value of each indices x, y and z for both the
					//vertex and the normal indices
					double vertexIndicesX = Double.valueOf(split[1].split("//")[0]);
					double normalIndicesX = Double.valueOf(split[1].split("//")[1]);
					double vertexIndicesY = Double.valueOf(split[2].split("//")[0]);
					double normalIndicesY = Double.valueOf(split[2].split("//")[1]);
					double vertexIndicesZ = Double.valueOf(split[3].split("//")[0]);
					double normalIndicesZ = Double.valueOf(split[3].split("//")[1]);
					//Create vertex and normal indices
					Vector3D vertexIndices = new Vector3D(vertexIndicesX, vertexIndicesY, vertexIndicesZ);
					Vector3D normalIndices = new Vector3D(normalIndicesX, normalIndicesY, normalIndicesZ);
					//Create a face using the vertex and normal indices
					Face face = new Face(vertexIndices, normalIndices);
					//Add the face to the model
					model.faces.add(face);
				}
			}
			
			//Close the buffered reader
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 		//Return the model
		return model;
	}
	
}