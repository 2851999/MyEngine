/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script;

import java.util.LinkedList;

import org.simplecorporation.myengine.utils.logger.Log;
import org.simplecorporation.myengine.utils.logger.LogType;
import org.simplecorporation.myengine.utils.logger.Logger;

public class ScriptInterpreter {
	
	/* The constructor */
	public ScriptInterpreter() {
		
	}
	
	/* The method to interpret a line of code */
	public void interpretCode(String line , Script script , ScriptModule scriptModule , ScriptClass scriptClass , ScriptMethod scriptMethod ,
			LinkedList<ScriptVariable> variables , boolean inMethod) {
		//Check if the current line is a comment
		if (! line.startsWith(scriptModule.syntax.SYNTAX_COMMENT) && ! line.equals("")) {
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
				ScriptParser.parseVariable(split , variables , scriptModule.syntax , inMethod);
			} else if (split[0].startsWith(scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_REFERNCE) && inMethod) {
				//Check the length of the split
				if (split.length > 2) {
					//Check the second value
					if (split[1].equals("=")) {
						//Run the calculation
						this.calculate(split , scriptModule.syntax , scriptMethod.localVariables , scriptClass.publicVariables);
					}
				}
			} else {
				//Has the right module been found
				boolean found = false;
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
						scriptModule.importedLibraries.get(a).parseCode(line , scriptClass);
						//Set found to true
						found = true;
					}
				}
				//Check if found
				if (! found) {
					//Run the correct method
					found = runMethod(line, script, scriptModule, scriptClass, scriptMethod, variables, inMethod);
				}
			}
		}
	}
	
	/* The method called to run a method */
	public boolean runMethod(String line , Script script , ScriptModule scriptModule , ScriptClass scriptClass , ScriptMethod scriptMethod ,
			LinkedList<ScriptVariable> variables , boolean inMethod) {
		//Check if the line contains an internal method name
		///Look at all of the methods in the current class
		for (int a = 0; a < scriptClass.methods.size(); a++) {
			ScriptMethod scriptMethod2;
			//Check if the current method has the same name
			if ((scriptMethod2 = scriptClass.getMethodByName(line)) != null) {
				//The arguments
				String[] argumentSplit = line.substring(line.indexOf("(") + 1 , line.length() - 1).split(",");
				//Look at each argument
				for (int b = 0; b < argumentSplit.length; b++) {
					//Check if the current argument is a variable
					if (argumentSplit[b].startsWith(scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_REFERNCE))
						//Replace the current argument with the correct value
						argumentSplit[b] = this.getVariable(argumentSplit[b].substring(1) , scriptMethod.localVariables , scriptClass.publicVariables).value;
				}
				//Run the script method
				scriptMethod2.run(argumentSplit);
				//Return true
				return true;
			}
		}
		//Split up the line using '.'
		String[] moduleSplit = line.split("\\.");
		//Check if the first line is a class in a module that has been imported
		ScriptClass scriptClass2 = null;
		scriptClass2 = script.getClassByName(moduleSplit[0]);
		//Check if the class was found
		if (scriptClass != null && scriptClass.visibility == ScriptObject.Visibility.PUBLIC) {
			//Get the method
			ScriptMethod scriptMethod2 = null;
			//Call the correct method in the class
			scriptMethod2 = scriptClass2.getMethodByName(moduleSplit[1]);
			//Check if the method was found
			if (scriptMethod2 != null && scriptMethod2.visibility == ScriptObject.Visibility.PUBLIC) {
				//The arguments
				String[] argumentSplit = moduleSplit[1].substring(moduleSplit[1].indexOf("(") + 1 , moduleSplit[1].length() - 1).split(",");
				//Look at each argument
				for (int a = 0; a < argumentSplit.length; a++) {
					//Check if the current argument is a variable
					if (argumentSplit[a].startsWith(scriptModule.syntax.SYNTAX_KEY_WORD_VARIABLE_REFERNCE))
						//Replace the current argument with the correct value
						argumentSplit[a] = this.getVariable(argumentSplit[a].substring(1) , scriptMethod.localVariables , scriptClass.publicVariables).value;
				}
				//Run the script method
				scriptMethod2.run(argumentSplit);
				//Return true
				return true;
			}
		}
		return false;
	}
	
	/* The method that makes an operation (=, +, -, /, *) */
	public void calculate(String[] split , ScriptSyntax syntax , LinkedList<ScriptVariable> localVariables , LinkedList<ScriptVariable> publicVariables) {
		//Get the variable
		ScriptVariable variable = this.getVariable(split[0].substring(syntax.SYNTAX_KEY_WORD_VARIABLE_REFERNCE.length()) , localVariables , publicVariables);
		//Check the length of the split
		if (split[1].equals("=") && ! split[2].startsWith("\""))
			//Set the variable value
			variable.value = split[2];
		else if (split[1].equals("=")) {
			//Set the variable value (String)
			variable.value = split[2];
			//Check if there is more to the value
			if (split.length > 2) {
				for (int a = 3; a < split.length; a++) {
					//Add onto the variable value
					variable.value += " " + split[a];
				}
			}
		}
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
	
	/* The method to get a string value from a split line */
	public static String getStringValue(String[] split , int start) {
		//The string
		String string = "";
		//Check if the string is a string
		if (split[start].startsWith("\"")) {
			//Set the first part of the string
			string = split[start];
			//Loop to add all of the other parts of the string
			for (int a = start + 1; a < split.length; a++) {
				//Add the next part of the string
				string += " " + split[a];
			}
			//Remove the ""
			string = string.substring(1 , string.length() - 1);
		} else {
			//Log an error
			Logger.log(new Log(ScriptConsole.ScriptingLanguageVersion , "The split " + split[start] + " is not part of a string" , LogType.ERROR));
		}
		//Return the string
		return string;
	}
	
}