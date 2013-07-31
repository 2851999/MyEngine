package org.simplecorporation.myengine.utils.messagebox;

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
	
}