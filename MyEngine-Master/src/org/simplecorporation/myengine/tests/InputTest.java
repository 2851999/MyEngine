package org.simplecorporation.myengine.tests;

import org.lwjgl.opengl.GL11;
import org.simplecorporation.myengine.core.engine.loop.EngineLoop;
import org.simplecorporation.myengine.core.input.Input;
import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.input.event.MouseMotionEvent;
import org.simplecorporation.myengine.core.input.listener.InputListener;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;

public class InputTest extends EngineLoop implements InputListener {
	
	public InputTest() {
		Settings.Video.OpenGL = true;
		Settings.Window.Title = "InputTest";
		create();
		Input.addListener(this);
	}
	
	public static void main(String[] args) {
		new InputTest();
	}

	@Override
	public void engineCreated() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineRender() {
		if (Settings.Video.OpenGL) {
			GL11.glMatrixMode(GL11.GL_PROJECTION);;
			GL11.glLoadIdentity();
			GL11.glOrtho(0 , Settings.Window.Size.Width , Settings.Window.Size.Height , 0, 1 , -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
		}
		
		BasicRenderer.setColour(Colour.BLUE);
		BasicRenderer.renderRectangle(100 , 100 , 100 , 100);
	}

	@Override
	public void engineStopped() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineClosing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMousePressed(MouseEvent e) {
		System.out.println("MousePressed " + e.x + " " + e.y);
	}

	@Override
	public void onMouseReleased(MouseEvent e) {
		System.out.println("MouseReleased " + e.x + " " + e.y);
	}

	@Override
	public void onMouseClicked(MouseEvent e) {
		System.out.println("MouseClicked " + e.x + " " + e.y);
	}

	@Override
	public void onMouseMoved(MouseMotionEvent e) {
		System.out.println("MouseMoved " + e.dx + " " + e.dy);
	}

	@Override
	public void onMouseDragged(MouseMotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPressed(KeyboardEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyReleased(KeyboardEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyTyped(KeyboardEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}