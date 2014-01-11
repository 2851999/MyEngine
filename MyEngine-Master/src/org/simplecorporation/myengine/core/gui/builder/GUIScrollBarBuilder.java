/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.builder;

import org.simplecorporation.myengine.core.gui.button.GUIButton;
import org.simplecorporation.myengine.core.gui.scrollbar.GUIImageScrollBar;
import org.simplecorporation.myengine.core.gui.scrollbar.GUIRenderableScrollBar;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.render.colour.Colour;

public class GUIScrollBarBuilder {
	
	/* The method to create an image scroll bar given
	   its name, scroll bar image, scroll bar button, scroll bar direction, scroll amount , position, width and height */
	public static GUIImageScrollBar createImageScrollBar(String name , Image scrollBarImage , GUIButton scrollBarButton ,
			int scrollBarDirection , double scrollAmount , double x , double y , double width , double height) {
		
		//Create the scroll bar
		GUIImageScrollBar scrollBar = new GUIImageScrollBar(name , scrollBarImage ,  scrollBarButton , scrollBarDirection , scrollAmount);
		
		//Set the position, width and height
		scrollBar.position.x = x;
		scrollBar.position.y = y;
		scrollBar.width = width;
		scrollBar.height = height;
		
		//Return the scroll bar
		return scrollBar;
	}
	
	/* The method to create an image scroll bar given
	   its name, slider image, slider button, slider direction, scroll amount , slider button width
	   slider button height , position, width and height */
	public static GUIImageScrollBar createImageScrollBar(String name , Image scrollBarImage , GUIButton scrollBarButton ,
			int scrollBarDirection , double scrollAmount , double buttonWidth , double buttonHeight , double x , double y , double width , double height) {
		
		//Set the scroll bar button's width and height
		scrollBarButton.width = buttonWidth;
		scrollBarButton.height = buttonHeight;
		
		//Create the scroll bar
		GUIImageScrollBar scrollBar = new GUIImageScrollBar(name , scrollBarImage ,  scrollBarButton , scrollBarDirection , scrollAmount);
		
		//Set the position, width and height
		scrollBar.position.x = x;
		scrollBar.position.y = y;
		scrollBar.width = width;
		scrollBar.height = height;
		
		//Return the scroll bar
		return scrollBar;
	}
	
	/* The method to create a renderable scroll bar given
	   its name, scroll bar colour, scroll bar button, scroll bar direction, scroll amount , position, width and height */
	public static GUIRenderableScrollBar createRenderableSliderScrollBar(String name , Colour scrollBarColour , GUIButton scrollBarButton ,
			int scrollBarDirection , double scrollAmount , double x , double y , double width , double height) {
		
		//Create the scroll bar
		GUIRenderableScrollBar scrollBar = new GUIRenderableScrollBar(name , scrollBarColour ,  scrollBarButton , scrollBarDirection , scrollAmount);
		
		//Set the position, width and height
		scrollBar.position.x = x;
		scrollBar.position.y = y;
		scrollBar.width = width;
		scrollBar.height = height;
		
		//Return the scroll bar
		return scrollBar;
	}
	
	/* The method to create a renderable scroll bar given
	   its name, scroll bar colour, scroll bar button, scroll bar direction, scroll amount , scroll bar button width
	   scroll bar button height , position, width and height */
	public static GUIRenderableScrollBar createRendeableSliderScrollBar(String name , Colour scrollBarColour , GUIButton scrollBarButton ,
			int scrollBarDirection , double scrollAmount , double buttonWidth , double buttonHeight , double x , double y , double width , double height) {
		
		//Set the scroll bar button's width and height
		scrollBarButton.width = buttonWidth;
		scrollBarButton.height = buttonHeight;
		
		//Create the scroll bar
		GUIRenderableScrollBar scrollBar = new GUIRenderableScrollBar(name , scrollBarColour ,  scrollBarButton , scrollBarDirection , scrollAmount);
		
		//Set the position, width and height
		scrollBar.position.x = x;
		scrollBar.position.y = y;
		scrollBar.width = width;
		scrollBar.height = height;
		
		//Return the scroll bar
		return scrollBar;
	}
	
}