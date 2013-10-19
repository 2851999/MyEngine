/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.gui.font;

import java.awt.Font;
import java.awt.FontMetrics;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.core.window.JavaWindow;
import org.simplecorporation.myengine.settings.Settings;

public class JavaGUIFont {
	
	/* The font */
	public Font font;
	public TrueTypeFont ttfFont;
	
	/* The font size */
	public double size;
	
	/* The colour */
	public Colour colour;
	
	/* The constructor of the font */
	public JavaGUIFont(Font font , Colour colour , double size) {
		//Set the font
		this.font = font;
		
		if (Settings.Video.OpenGL)
			ttfFont = new TrueTypeFont(this.font.deriveFont((float)size) , Settings.Video.AntiAliasing);
		
		//Set the colour and size
		this.colour = colour;
		this.size = size;
	}
	
	/* The method that renders the font */
	public void render(String text , double x , double y) {
		//Check what rendering mode to use
		if (! Settings.Android && Settings.Video.OpenGL) {
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			//Render the text
			ttfFont.drawString((float)x , (float)y , text , new Color((float)this.colour.r , (float)this.colour.g , (float)this.colour.b , (float)this.colour.a));
			GL11.glDisable(GL11.GL_TEXTURE_2D);
		} else if (! Settings.Android && ! Settings.Video.OpenGL) {
			//Set the colour
			BasicRenderer.setColour(this.colour);
			//Set the font
			JavaWindow.g2d.setFont(this.font.deriveFont((float)size));
			//Render the text
			JavaWindow.g2d.drawString(text , (float) x , (float) y);
		}
	}
	
	/* The method to get the width of a string */
	public double getWidth(String text) {
		if (! Settings.Android && Settings.Video.OpenGL) {
			return ttfFont.getWidth(text);
		} else if (! Settings.Android && ! Settings.Video.OpenGL) {
			FontMetrics metrics = JavaWindow.g2d.getFontMetrics(font.deriveFont((float)size));
			return metrics.getStringBounds(text , JavaWindow.g2d).getWidth();
		} else
			return 0;
	}
	
	/* The method to get the height of a string */
	public double getHeight(String text) {
		if (! Settings.Android && Settings.Video.OpenGL) {
			return ttfFont.getHeight(text);
		} else if (! Settings.Android && ! Settings.Video.OpenGL) {
			FontMetrics metrics = JavaWindow.g2d.getFontMetrics(font.deriveFont((float)size));
			return metrics.getStringBounds(text , JavaWindow.g2d).getHeight();
		} else
			return 0;
	}
	
	
}