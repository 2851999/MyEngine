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

import org.simplecorporation.myengine.utils.file.PropertiesFile;

public class ScriptSyntax {
	
	/********************************THE DEFAULT SYNTAX********************************/
	public static final String DEFAULT_SYNTAX_COMMENT = "#";
	public static final String DEFAULT_SYNTAX_KEY_WORD_IMPORT = "uses";
	public static final String DEFAULT_SYNTAX_KEY_WORD_EXTENDS = "inherits";
	public static final String DEFAULT_SYNTAX_KEY_WORD_PUBLIC = "global";
	public static final String DEFAULT_SYNTAX_KEY_WORD_PRIVATE = "private";
	public static final String DEFAULT_SYNTAX_KEY_WORD_STATIC = "static";
	public static final String DEFAULT_SYNTAX_KEY_WORD_FINAL = "final";
	public static final String DEFAULT_SYNTAX_KEY_WORD_METHOD = "method";
	public static final String DEFAULT_SYNTAX_KEY_WORD_END_METHOD = "endmethod";
	public static final String DEFAULT_SYNTAX_KEY_WORD_CLASS = "class";
	public static final String DEFAULT_SYNTAX_KEY_WORD_END_CLASS = "endclass";
	
	public static final String DEFAULT_SYNTAX_KEY_WORD_VARIABLE_DECLARATION = "var";
	public static final String DEFAULT_SYNTAX_KEY_WORD_VARIABLE_REFERNCE = "$";
	
	/********************************THE CURRENT SYNTAX********************************/
	public String SYNTAX_COMMENT;
	public String SYNTAX_KEY_WORD_IMPORT;
	public String SYNTAX_KEY_WORD_EXTENDS;
	public String SYNTAX_KEY_WORD_PUBLIC;
	public String SYNTAX_KEY_WORD_PRIVATE;
	public String SYNTAX_KEY_WORD_STATIC;
	public String SYNTAX_KEY_WORD_FINAL;
	public String SYNTAX_KEY_WORD_METHOD;
	public String SYNTAX_KEY_WORD_END_METHOD;
	public String SYNTAX_KEY_WORD_CLASS;
	public String SYNTAX_KEY_WORD_END_CLASS;
	
	public String SYNTAX_KEY_WORD_VARIABLE_DECLARATION;
	public String SYNTAX_KEY_WORD_VARIABLE_REFERNCE;
	
	/* The constructor */
	public ScriptSyntax() {
		//Set the current syntax to the default syntax
		this.SYNTAX_COMMENT = DEFAULT_SYNTAX_COMMENT;
		this.SYNTAX_KEY_WORD_IMPORT = DEFAULT_SYNTAX_KEY_WORD_IMPORT;
		this.SYNTAX_KEY_WORD_EXTENDS = DEFAULT_SYNTAX_KEY_WORD_EXTENDS;
		this.SYNTAX_KEY_WORD_PUBLIC = DEFAULT_SYNTAX_KEY_WORD_PUBLIC;
		this.SYNTAX_KEY_WORD_PRIVATE = DEFAULT_SYNTAX_KEY_WORD_PRIVATE;
		this.SYNTAX_KEY_WORD_STATIC = DEFAULT_SYNTAX_KEY_WORD_STATIC;
		this.SYNTAX_KEY_WORD_FINAL = DEFAULT_SYNTAX_KEY_WORD_FINAL;
		this.SYNTAX_KEY_WORD_METHOD = DEFAULT_SYNTAX_KEY_WORD_METHOD;
		this.SYNTAX_KEY_WORD_END_METHOD = DEFAULT_SYNTAX_KEY_WORD_END_METHOD;
		this.SYNTAX_KEY_WORD_CLASS = DEFAULT_SYNTAX_KEY_WORD_CLASS;
		this.SYNTAX_KEY_WORD_END_CLASS = DEFAULT_SYNTAX_KEY_WORD_END_CLASS;
		
		this.SYNTAX_KEY_WORD_VARIABLE_DECLARATION = DEFAULT_SYNTAX_KEY_WORD_VARIABLE_DECLARATION;
		this.SYNTAX_KEY_WORD_VARIABLE_REFERNCE = DEFAULT_SYNTAX_KEY_WORD_VARIABLE_REFERNCE;
	}
	
	/* The method to set the syntax */
	public void setSyntax(String filePath) {
		//Create the properties file
		PropertiesFile propertiesFile = new PropertiesFile(filePath);
		//Read the properties file
		propertiesFile.read();
		//Set the syntax
		this.SYNTAX_COMMENT = propertiesFile.getProperty("SYNTAX_COMMENT");
		this.SYNTAX_KEY_WORD_PUBLIC = propertiesFile.getProperty("SYNTAX_KEY_WORD_IMPORT");
		this.SYNTAX_KEY_WORD_PRIVATE = propertiesFile.getProperty("SYNTAX_KEY_WORD_EXTENDS");
		this.SYNTAX_KEY_WORD_PUBLIC = propertiesFile.getProperty("SYNTAX_KEY_WORD_PUBLIC");
		this.SYNTAX_KEY_WORD_PRIVATE = propertiesFile.getProperty("SYNTAX_KEY_WORD_PRIVATE");
		this.SYNTAX_KEY_WORD_STATIC = propertiesFile.getProperty("SYNTAX_KEY_WORD_STATIC");
		this.SYNTAX_KEY_WORD_FINAL = propertiesFile.getProperty("SYNTAX_KEY_WORD_FINAL");
		this.SYNTAX_KEY_WORD_METHOD = propertiesFile.getProperty("SYNTAX_KEY_WORD_METHOD");
		this.SYNTAX_KEY_WORD_END_METHOD = propertiesFile.getProperty("SYNTAX_KEY_WORD_END_METHOD");
		this.SYNTAX_KEY_WORD_CLASS = propertiesFile.getProperty("SYNTAX_KEY_WORD_CLASS");
		this.SYNTAX_KEY_WORD_END_CLASS = propertiesFile.getProperty("SYNTAX_KEY_WORD_END_CLASS");
		
		this.SYNTAX_KEY_WORD_VARIABLE_DECLARATION = propertiesFile.getProperty("SYNTAX_KEY_WORD_VARIABLE_DECLARATION");
	}
	
}