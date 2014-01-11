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

import java.util.Scanner;

public class ScriptConsole {
	
	/* The current version of the Scripting Language */
	public static final String ScriptingLanguageVersion = "ScriptingLanguage 1 (Build 4)";
	
	/* The constructor */
	public ScriptConsole() {
		//Start the console
		startConsole();
	}
	
	/* The method called to start the console */
	public void startConsole() {
		//Show a starting message
		System.out.println("Scripting Language Console");
		//The input given by the user
		String input = "";
		//Run the console until the input is equal to 'exit'
		while (! input.equalsIgnoreCase("exit")) {
			//Ask the user for a command
			System.out.println("Command: ");
			//Get the user's input
			input = read();
			//Check the command
			if (input.equalsIgnoreCase("help") || input.equals("?")) {
				//Display all of the commands
				System.out.println();
				System.out.println("------------------------------------Commands------------------------------------");
				System.out.println("help/?---------------------Displays all of the commands");
				System.out.println("info-----------------------Shows information about the Scripting Language");
				System.out.println("run FILENAME---------------Runs a script file");
				System.out.println("--------------------------------------------------------------------------------");
			} else if (input.equalsIgnoreCase("info")) {
				//Display information
				System.out.println(ScriptingLanguageVersion);
			} else if (input.toLowerCase().startsWith("run")) {
				//Split the commands
				String[] commands = input.split(" ");
				//Check the number of commands
				if (commands.length == 3) {
					//Create a new script file
					new Script(commands[1] , commands[2] , true);
				}
			} else if (! input.equalsIgnoreCase("exit")) {
				//Notify the user the command doesn't exist
				System.out.println("The command " + input + " doesn't exist");
			}
		}
	}
	
	/* The method to get input from the console the return it */
	public static String read() {
		//The scanner instance
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//Return the input
		return scanner.nextLine();
	}
	
}