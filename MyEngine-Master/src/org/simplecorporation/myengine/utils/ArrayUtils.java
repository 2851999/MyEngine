/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayUtils {
	
	/* The method to turn a list into a string array */
	public static String[] toStringArray(List<String> list) {
		//Create the string array
		String[] stringArray = new String[list.size()];
		
		//Set all of the lines
		for (int a = 0; a < stringArray.length; a++)
			stringArray[0] = list.get(a);
		
		//Return the array
		return stringArray;
	}
	
	/* The method to turn a linked list into a string array */
	public static String[] toStringArray(LinkedList<String> linkedList) {
		//Create the string array
		String[] stringArray = new String[linkedList.size()];
		
		//Set all of the lines
		for (int a = 0; a < stringArray.length; a++)
			stringArray[0] = linkedList.get(a);
		
		//Return the array
		return stringArray;
	}
	
	/* The method to turn a string array into a list */
	public static List<String> toStringList(String[] stringArray) {
		//Create the list
		List<String> stringList = new ArrayList<String>();
		
		//Add all of the lines
		for (int a = 0; a < stringArray.length; a++)
			stringList.add(stringArray[a]);
		
		//Return the linked list
		return stringList;
	}
	
	/* The method to turn a string array into a linked list */
	public static LinkedList<String> toStringLinkedList(String[] stringArray) {
		//Create the linked list
		LinkedList<String> stringLinkedList = new LinkedList<String>();
		
		//Add all of the lines
		for (int a = 0; a < stringArray.length; a++)
			stringLinkedList.add(stringArray[a]);
		
		//Return the linked list
		return stringLinkedList;
	}
	
}