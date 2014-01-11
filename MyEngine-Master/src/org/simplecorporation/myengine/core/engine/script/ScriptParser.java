/* *********************************************
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

public class ScriptParser {
	
	/* The method to parse a variable */
	public static void parseVariable(String[] split , LinkedList<ScriptVariable> variables , ScriptSyntax syntax , boolean inMethod) {
		//Get the variable name
		String variableName = "";
		//The variable value
		String variableValue = "";
		//The variable visibility
		ScriptObject.Visibility variableVisibility = ScriptObject.Visibility.PRIVATE;
		//Check if in a method
		if (! inMethod) {
			//Check to see if the variable should be public or private
			if (split[1].equals(syntax.SYNTAX_KEY_WORD_VARIABLE_DECLARATION)) {
				//Set the variable name
				variableName = split[2];
				//Check what visibility the variable should be
				if (split[0].equals(syntax.SYNTAX_KEY_WORD_PUBLIC))
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
			if (inMethod)
				variableValue = split[3];
			else
				variableValue = split[4];
			//Check if there is more
			if (split.length > 4) {
				//Keep adding the values onto the end so that "Hello World" will stay the same instead
				//of being separated into "Hello
				if (! inMethod)
					for (int a = 5; a < split.length; a++)
						//Add the current value onto the end
						variableValue += " " + split[a];
				else
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
	public static LinkedList<ScriptClass> parseClasses(LinkedList<String> moduleCode , ScriptSyntax syntax , ScriptModule scriptModule) {
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
	public static LinkedList<ScriptMethod> parseMethods(LinkedList<String> classCode , ScriptSyntax syntax , ScriptClass scriptClass) {
		//The methods linked list
		LinkedList<ScriptMethod> methods = new LinkedList<ScriptMethod>();
		//Go though all of the module code
		for (int a = 0; a < classCode.size(); a++) {
			//Check if the current line is defining a method
			if (classCode.get(a).startsWith(syntax.SYNTAX_KEY_WORD_PUBLIC + " " + syntax.SYNTAX_KEY_WORD_METHOD) ||
					classCode.get(a).startsWith(syntax.SYNTAX_KEY_WORD_PRIVATE + " " + syntax.SYNTAX_KEY_WORD_METHOD)) {
				//The method name
				String methodName = classCode.get(a).split(" ")[2];
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
				methods.add(new ScriptMethod(methodName , methodVisibility , scriptClass , methodCode));
			}
		}
		//Return the linked list
		return methods;
	}
	
}