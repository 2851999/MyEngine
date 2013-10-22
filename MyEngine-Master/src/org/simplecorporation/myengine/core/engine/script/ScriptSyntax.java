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

import java.io.File;
import java.util.LinkedList;

import org.simplecorporation.myengine.utils.file.FileUtils;

public class ScriptSyntax {
	
	/* Script syntax contains key words and basic syntax so that
	   the scripting language can be easily changed to make it
	   simpler and easier to use. */
	
	/*---------------The default basic syntax---------------*/
	
	/* The import key word */
	public static final String DEFAULT_SYNTAX_KEY_WORD_IMPORT = "uses";
	/* The call key word */
	public static final String DEFAULT_SYNTAX_KEY_WORD_CALL = "call";
	/* The comment key word */
	public static final String DEFAULT_SYNTAX_KEY_WORD_COMMENT = "#";
	/* The method key word */
	public static final String DEFAULT_SYNTAX_KEY_WORD_METHOD = "method";
	/* The end method key word */
	public static final String DEFAULT_SYNTAX_KEY_WORD_METHOD_END = "endmethod";
	/* The key word used after a method declaration */
	public static final String DEFAULT_SYNTAX_KEY_WORD_METHOD_DECLARATION = ":";
	/* The key word separator */
	public static final String DEFAULT_SYNTAX_KEY_WORD_SEPARATOR = " ";
	/* The key word to define a variable */
	public static final String DEFAULT_SYNTAX_KEY_WORD_VARIABLE_DECLARATION = "var";
	/* The key word to reference a variable */
	public static final String DEFAULT_SYNTAX_KEY_WORD_VARIABLE_REFERENCE = "var:";
	
	/*---------------The basic syntax---------------*/
	
	/* The import key word */
	public String SYNTAX_KEY_WORD_IMPORT;
	/* The call key word */
	public String SYNTAX_KEY_WORD_CALL;
	/* The comment key word */
	public String SYNTAX_KEY_WORD_COMMENT;
	/* The method key word */
	public String SYNTAX_KEY_WORD_METHOD;
	/* The end method key word */
	public String SYNTAX_KEY_WORD_METHOD_END;
	/* The key word used after a method declaration */
	public String SYNTAX_KEY_WORD_METHOD_DECLARATION;
	/* The key word separator */
	public String SYNTAX_KEY_WORD_SEPARATOR;
	/* The key word to define a variable */
	public String SYNTAX_KEY_WORD_VARIABLE_DECLARATION;
	/* The key word to reference a variable */
	public String SYNTAX_KEY_WORD_VARIABLE_REFERENCE;
	
	/* The constructor */
	public ScriptSyntax() {
		//Set all of the key words to the default ones
		
		//Basic syntax
		this.SYNTAX_KEY_WORD_IMPORT = DEFAULT_SYNTAX_KEY_WORD_IMPORT;
		this.SYNTAX_KEY_WORD_CALL = DEFAULT_SYNTAX_KEY_WORD_CALL;
		this.SYNTAX_KEY_WORD_COMMENT = DEFAULT_SYNTAX_KEY_WORD_COMMENT;
		this.SYNTAX_KEY_WORD_METHOD = DEFAULT_SYNTAX_KEY_WORD_METHOD;
		this.SYNTAX_KEY_WORD_METHOD_END = DEFAULT_SYNTAX_KEY_WORD_METHOD_END;
		this.SYNTAX_KEY_WORD_METHOD_DECLARATION = DEFAULT_SYNTAX_KEY_WORD_METHOD_DECLARATION;
		this.SYNTAX_KEY_WORD_SEPARATOR = DEFAULT_SYNTAX_KEY_WORD_SEPARATOR;
		this.SYNTAX_KEY_WORD_VARIABLE_DECLARATION = DEFAULT_SYNTAX_KEY_WORD_VARIABLE_DECLARATION;
		this.SYNTAX_KEY_WORD_VARIABLE_REFERENCE = DEFAULT_SYNTAX_KEY_WORD_VARIABLE_REFERENCE;
	}
	
	/* The method to set the syntax given the line with the syntax on it */
	public void setSyntax(String filePath , String syntaxLine) {
		//Remove the word 'syntax' and the space that follows
		syntaxLine = syntaxLine.substring(7);
		//Set the path of the syntax file
		String syntaxFilePath = filePath.replace(new File(filePath).getName() , syntaxLine);
		//Read the file
		LinkedList<String> syntaxFileText = FileUtils.read(syntaxFilePath);
		//Loop though the syntax file's text
		for (int a = 0; a < syntaxFileText.size(); a++) {
			//Split the current line
			String[] split = syntaxFileText.get(a).split("::");
			//Check what the current line should set
			if (split[0].equals("SYNTAX_KEY_WORD_IMPORT"))
				//Set the key word
				this.SYNTAX_KEY_WORD_IMPORT = split[1];
			else if (split[0].equals("SYNTAX_KEY_WORD_CALL"))
				//Set the key word
				this.SYNTAX_KEY_WORD_CALL = split[1];
			else if (split[0].equals("SYNTAX_KEY_WORD_COMMENT"))
				//Set the key word
				this.SYNTAX_KEY_WORD_COMMENT = split[1];
			else if (split[0].equals("SYNTAX_KEY_WORD_METHOD"))
				//Set the key word
				this.SYNTAX_KEY_WORD_METHOD = split[1];
			else if (split[0].equals("SYNTAX_KEY_WORD_METHOD_END"))
				//Set the key word
				this.SYNTAX_KEY_WORD_METHOD_END = split[1];
			else if (split[0].equals("SYNTAX_KEY_WORD_METHOD_DECLARATION"))
				//Set the key word
				this.SYNTAX_KEY_WORD_METHOD_DECLARATION = split[1];
			else if (split[0].equals("SYNTAX_KEY_WORD_SEPARATOR"))
				//Set the key word
				this.SYNTAX_KEY_WORD_SEPARATOR = split[1];
			else if (split[0].equals("SYNTAX_KEY_WORD_VARIABLE_DECLARATION"))
				//Set the key word
				this.SYNTAX_KEY_WORD_VARIABLE_DECLARATION = split[1];
			else if (split[0].equals("SYNTAX_KEY_WORD_VARIABLE_REFERENCE"))
				//Set the key word
				this.SYNTAX_KEY_WORD_VARIABLE_REFERENCE = split[1];
		}
	}
	
}