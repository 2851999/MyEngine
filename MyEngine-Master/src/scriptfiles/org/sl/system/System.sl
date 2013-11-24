package org.sl.system

uses org.sl.java.system.System

global class System
	
	#Method called to print a message
	global method print($message)
		System print $message
	endmethod
	
	#Method called to print a message on a line
	global method println($message)
		System println $message
	endmethod
	
endclass