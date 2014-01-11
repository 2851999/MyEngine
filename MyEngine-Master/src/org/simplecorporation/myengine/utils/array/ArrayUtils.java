/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.utils.array;

import java.util.LinkedList;

public class ArrayUtils {
	
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