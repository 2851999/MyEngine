package org.sl.render

uses org.sl.java.render.BasicRenderer

global class BasicRenderer
	
	#The method to set the colour
	global method setColour($colour)
		BasicRenderer set colour $colour
	endmethod
	
	#The method to render a line
	global method renderLine($startx,$starty,$endx,$endy)
		BasicRenderer render line $startx $starty $endx $endy
	endmethod
	
	#The method to render a rectangle
	global method renderRectangle($x,$y,$width,$height)
		BasicRenderer render rectangle $x $y $width $height
	endmethod
	
	#The method to render a filled rectangle
	global method renderRectangle($x,$y,$width,$height)
		BasicRenderer render filledrectangle $x $y $width $height
	endmethod
	
	#The method to render a fill
	global method renderRectangle($x,$y,$width,$height)
		BasicRenderer render filledrectangle $x $y $width $height
	endmethod
	
	#The method to fill the screen with a colour
	global method renderFill()
		BasicRenderer render fill
	endmethod
	
endclass 