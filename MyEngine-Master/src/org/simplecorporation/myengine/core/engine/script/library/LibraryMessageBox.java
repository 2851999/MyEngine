/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.engine.script.library;

import java.util.LinkedList;

import org.simplecorporation.myengine.core.engine.script.file.ScriptFile;
import org.simplecorporation.myengine.core.engine.script.variable.ScriptVariable;
import org.simplecorporation.myengine.utils.messagebox.MessageBox;

public class LibraryMessageBox extends AbstractLibrary {
	
	/* The name of this library */
	public static final String NAME = "MessageBox";
	
	/* The description of this library */
	public static final String DESCRIPTION = "The MessageBox Library";
	
	/* The package of this library */
	public static final String PACKAGE = "org.simplecorporation.myengine.utils.messagebox.MessageBox";
	
	/* The key word of this library */
	public static final String KEYWORD = "MsgBox";
	
	/* The constructor */
	public LibraryMessageBox() {
		//Call the super constructor
		super(NAME , DESCRIPTION , PACKAGE , KEYWORD);
	}
	
	/* The method called to parse a line of code */
	public void parseCode(ScriptFile currentFile , String currentLine , LinkedList<ScriptVariable> publicVariables , LinkedList<ScriptVariable> localVariables) {
		//Replace the variables
		currentLine = this.replaceVariables(currentFile , currentLine , publicVariables, localVariables);
		//Split up the line
		String[] splitLine = currentLine.split(currentFile.scriptSyntax.SYNTAX_KEY_WORD_SEPARATOR);
		//Check what the second key word is
		if (splitLine[1].equals("show")) {
			//Check the next key word
			if (splitLine[2].equals("info") || splitLine[2].equals("information")) {
				//Show an information message box
				MessageBox.showInformationMessage(getVariableValue(splitLine , 1) , getVariableValue(splitLine , 2));
			} else if (splitLine[2].equals("warning")) {
				//Show an information message box
				MessageBox.showWarningMessage(getVariableValue(splitLine , 1) , getVariableValue(splitLine , 2));
			} else if (splitLine[2].equals("error")) {
				//Show an information message box
				MessageBox.showErrorMessage(getVariableValue(splitLine , 1) , getVariableValue(splitLine , 2));
			}
		}
	}
	
}