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

import javax.swing.JOptionPane;

public class MessageBox {
	
	/* Shows an information box */
	public static void showInformationMessage(String title , String message) {
		JOptionPane.showMessageDialog(null , message , title , JOptionPane.INFORMATION_MESSAGE);
	}
	
	/* Shows a warning box */
	public static void showWarningMessage(String title , String message) {
		JOptionPane.showMessageDialog(null , message , title , JOptionPane.WARNING_MESSAGE);
	}
	
	/* Shows an error box */
	public static void showErrorMessage(String title , String message) {
		JOptionPane.showMessageDialog(null , message , title , JOptionPane.ERROR_MESSAGE);
	}
	
	/* The method to show a yes/no option and returns whether the answer was yes */
	public static boolean showYesNoOption(String title , String message) {
		return JOptionPane.showConfirmDialog(null , message , title , JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION;
	}
	
}