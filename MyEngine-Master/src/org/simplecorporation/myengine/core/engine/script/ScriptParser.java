/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script;

import java.util.LinkedList;

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class ScriptParser {
	
	/* The constructor */
	public ScriptParser() {
		
	}
	
	/* The method to parse a line of code */
	public void parseCode(String line , ScriptModule scriptModule , ScriptClass scriptClass , ScriptMethod scriptMethod ,
			LinkedList<ScriptVariable> variables , boolean inMethod) {
		//Check if the current line is a comment
		if (! line.startsWith(scriptModule.syntax.SYNTAX_COMMENT)) {
			//Split up the current line of code
			String[] split = line.split(" ");
			//Check each element in the list
			for (int a = 0; a < split.length; a++) {
				//Check if the current split is defining a variable
				//Make sure that $variable1 = $variable2 doesn't become "Value1" = "Value2"
				if (split[a].startsWith(scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_REFERNCE) && a != 0) {
					//Find the variable and put its value in the correct place
					split[a] = this.getVariable(split[a].substring(scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_REFERNCE.length()) ,
							scriptMethod.localVariables , scriptClass.publicVariables).value;
				}
			}
			//Check for a key word
			if ((split.length > 0 && split[0].equals(scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_DECLARATION)) ||
					(split.length > 1 && split[1].equals(scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_DECLARATION))) {
				//Parse the variable
				this.parseVariable(split , variables , scriptModule.syntax , inMethod);
			} else {
				//Check the imported libraries for a key word
				for (int a = 0; a < scriptModule.importedLibraries.size(); a++) {
					//Check the current libraries key word against the first split of the code
					if (scriptModule.importedLibraries.get(a).libraryReference.equals(split[0]) ||
							scriptModule.importedLibraries.get(a).libraryShortReference.equals(split[0])) {
						//Recreate the line
						line = split[0];
						//Check if the list length is more than 1
						if (split.length > 1) {
							//Loop while there is more of the split left
							for (int b = 1; b < split.length; b++) {
								//Add onto the line
								line += " " + split[b];
							}
						}
						//Run the current line of code with the current library
						scriptModule.importedLibraries.get(a).parseCode(line);
					}
				}
			}
		}
	}
	
	/* The method to parse a variable */
	public void parseVariable(String[] split , LinkedList<ScriptVariable> variables , ScriptSyntax syntax , boolean inMethod) {
		//Get the variable name
		String variableName = "";
		//The variable value
		String variableValue = "";
		//The variable visibility
		ScriptObject.Visibility variableVisibility = ScriptObject.Visibility.PRIVATE;
		//Check if in a method
		if (! inMethod) {
			//Check to see if the variable should be public or private
			if (! split[1].equals(syntax.SYNTAX_KEY_WORD_VARIABLE_DECLARATION)) {
				//Set the variable name
				variableName = split[2];
				//Check what visibility the variable should be
				if (split[1].equals(syntax.SYNTAX_KEY_WORD_PUBLIC))
					//Set the variable visibility to public
					variableVisibility = ScriptObject.Visibility.PUBLIC;
			} else {
				//Set the variable name
				variableName = split[1];
			}
		} else {
			//Set the variable name
			variableName = split[1];
		}
		//Check if the value should be set
		if (split.length > 2) {
			//Set the variable value
			variableValue = split[3];
			//Check if there is more
			if (split.length > 4) {
				//Keep adding the values onto the end so that "Hello World" will stay the same instead
				//of being separated into "Hello
				for (int a = 4; a < split.length; a++)
					//Add the current value onto the end
					variableValue += " " + split[a];
			}
		}
		//Create a variable
		ScriptVariable variable = new ScriptVariable(variableName , variableVisibility);
		//Set the variable value
		variable.value = variableValue;
		//Add the variable to the variables list
		variables.add(variable);
	}
	
	/* The method to parse and create classes */
	public LinkedList<ScriptClass> parseClasses(LinkedList<String> moduleCode , ScriptSyntax syntax , ScriptModule scriptModule) {
		//The classes linked list
		LinkedList<ScriptClass> classes = new LinkedList<ScriptClass>();
		//Go though all of the module code
		for (int a = 0; a < moduleCode.size(); a++) {
			//Check if the current line is defining a class
			if (moduleCode.get(a).startsWith(syntax.SYNTAX_KEY_WORD_PUBLIC + " " + syntax.SYNTAX_KEY_WORD_CLASS) ||
					moduleCode.get(a).startsWith(syntax.SYNTAX_KEY_WORD_PRIVATE + " " + syntax.SYNTAX_KEY_WORD_CLASS)) {
				//The class name
				String className = moduleCode.get(a).split(" ")[2];
				//The visibility of the class
				ScriptObject.Visibility classVisibility = ScriptObject.Visibility.PRIVATE;
				//Check the visibility of the class
				if (moduleCode.get(a).startsWith(syntax.SYNTAX_KEY_WORD_PUBLIC))
					//Set the visibility of the class
					classVisibility = ScriptObject.Visibility.PUBLIC;
				else if (moduleCode.get(a).startsWith(syntax.SYNTAX_KEY_WORD_PRIVATE))
					//Set the visibility of the class
					classVisibility = ScriptObject.Visibility.PRIVATE;
				//The code within the class
				LinkedList<String> classCode = new LinkedList<String>();
				//Add one to the current count
				a++;
				//Loop until the end of the class is reached
				while (! moduleCode.get(a).equals(syntax.SYNTAX_KEY_WORD_END_CLASS)) {
					//Add the current line of code into the class code list
					classCode.add(moduleCode.get(a));
					//Add one to the current count
					a++;
				}
				//Add a new class
				classes.add(new ScriptClass(className , classVisibility , scriptModule , classCode));
			}
		}
		//Return the linked list
		return classes;
	}
	
	/* The method to parse and create methods */
	public LinkedList<ScriptMethod> parseMethods(LinkedList<String> classCode , ScriptSyntax syntax , ScriptClass scriptClass) {
		//The methods linked list
		LinkedList<ScriptMethod> methods = new LinkedList<ScriptMethod>();
		//Go though all of the module code
		for (int a = 0; a < classCode.size(); a++) {
			//Check if the current line is defining a method
			if (classCode.get(a).startsWith(syntax.SYNTAX_KEY_WORD_PUBLIC + " " + syntax.SYNTAX_KEY_WORD_METHOD) ||
					classCode.get(a).startsWith(syntax.SYNTAX_KEY_WORD_PRIVATE + " " + syntax.SYNTAX_KEY_WORD_METHOD)) {
				//The method name
				String methodName = classCode.get(a).split(" ")[2].substring(0 , classCode.get(a).split(" ")[2].indexOf('('));
				//The visibility of the method
				ScriptObject.Visibility methodVisibility = ScriptObject.Visibility.PRIVATE;
				//Check the visibility of the method
				if (classCode.get(a).startsWith(syntax.SYNTAX_KEY_WORD_PUBLIC))
					//Set the visibility of the method
					methodVisibility = ScriptObject.Visibility.PUBLIC;
				else if (classCode.get(a).startsWith(syntax.SYNTAX_KEY_WORD_PRIVATE))
					//Set the visibility of the method
					methodVisibility = ScriptObject.Visibility.PRIVATE;
				//The code within the method
				LinkedList<String> methodCode = new LinkedList<String>();
				//Add one to the current count
				a++;
				//Loop until the end of the class is reached
				while (! classCode.get(a).equals(syntax.SYNTAX_KEY_WORD_END_METHOD)) {
					//Add the current line of code into the class code list
					methodCode.add(classCode.get(a));
					//Add one to the current count
					a++;
				}
				//Add a new method
				methods.add(new ScriptMethod(methodName , methodVisibility , scriptClass , classCode));
			}
		}
		//Return the linked list
		return methods;
	}
	
	/* The method to find a variable given its name */
	public ScriptVariable getVariable(String variableName , LinkedList<ScriptVariable> localVariables , LinkedList<ScriptVariable> publicVariables) {
		//The script variable
		ScriptVariable scriptVariable = null;
		//The boolean that represents whether the variable has been found
		boolean found = false;
		//Look at every local variable
		for (int a = 0; a < localVariables.size(); a++) {
			//Check the name of the current variable
			if (localVariables.get(a).name.equals(variableName)) {
				//Set the script variable
				scriptVariable = localVariables.get(a);
				//Set found to true
				found = true;
			}
		}
		//Check if the variable has already been found
		if (! found) {
			//Look at every public variable
			for (int a = 0; a < publicVariables.size(); a++) {
				//Check the name of the current variable
				if (publicVariables.get(a).name.equals(variableName)) {
					//Set the script variable
					scriptVariable = publicVariables.get(a);
					//Set found to true
					found = true;
				}
			}
		}
		//Check whether the script variable equals null
		if (scriptVariable == null) {
			//Log an error
			Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion , "ScriptParser getVariable() The variable with the name " + variableName + " was not found" , LogType.ERROR));
		}
		//Return the script variable
		return scriptVariable;
	}
	
}