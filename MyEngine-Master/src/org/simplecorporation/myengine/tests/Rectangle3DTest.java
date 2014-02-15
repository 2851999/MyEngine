package org.simplecorporation.myengine.tests;

import org.lwjgl.input.Mouse;
import org.simplecorporation.myengine.core.game.BaseGame;
import org.simplecorporation.myengine.core.game.GameValues;
import org.simplecorporation.myengine.core.game3d.camera.Camera;
import org.simplecorporation.myengine.core.game3d.vector.Vector3D;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.input.KeyboardInput;
import org.simplecorporation.myengine.core.input.event.MouseMotionEvent;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer3DOpenGL;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.opengl.DisplayList;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;
import org.simplecorporation.myengine.utils.opengl.OpenGLUtils;

public class Rectangle3DTest extends BaseGame {
	
	public Camera camera;
	public Image texture;
	public boolean changeCursorPos;
	public int draw;
	
	public Rectangle3DTest() {
		Settings.Window.Title = "Rectangle 3D Test";
		Settings.Video.OpenGL = true;
		Settings.Video.VSync = false;
		Settings.Video.MaxFPS = 0;
		this.changeCursorPos = false;
		createGame();
	}
	
	public void gameCreated() {
		this.texture = new Image("C:\\grass1.png", "PNG", true);
		this.camera = new Camera();
		this.draw = DisplayList.generate();
		BasicRenderer.setColour(Colour.WHITE);
		BasicRenderer3DOpenGL.renderImage(this.texture, new Vector3D(0,0,-2), 1, 1);
		DisplayList.end();
	}
	
	public void gameRender() {
		if (KeyboardInput.KEY_UP)
			this.camera.rotation.x -= GameValues.CURRENT_DELTA * 0.2;
		if (KeyboardInput.KEY_DOWN)
			this.camera.rotation.x += GameValues.CURRENT_DELTA * 0.2;
		if (KeyboardInput.KEY_LEFT)
			this.camera.rotation.y -= GameValues.CURRENT_DELTA * 0.2;
		if (KeyboardInput.KEY_RIGHT)
			this.camera.rotation.y += GameValues.CURRENT_DELTA * 0.2;
		
		if (KeyboardInput.KEY_W)
			this.camera.moveZ(GameValues.CURRENT_DELTA * 0.01);
		if (KeyboardInput.KEY_S)
			this.camera.moveZ(-GameValues.CURRENT_DELTA * 0.01);
		if (KeyboardInput.KEY_A)
			this.camera.moveX(GameValues.CURRENT_DELTA * 0.01);
		if (KeyboardInput.KEY_D)
			this.camera.moveX(-GameValues.CURRENT_DELTA * 0.01);
		
		OpenGLSetupUtils.setupPerspective(70, 1, 1000);
		OpenGLSetupUtils.setupDepthTest();
		OpenGLUtils.clearColourBuffer();
		OpenGLUtils.clearDepthBuffer();
		this.camera.useView();
		this.texture.getOpenGLImage().bind();
		DisplayList.render(this.draw);
	}
	
	public void onMouseMoved(MouseMotionEvent event) {
		Mouse.setGrabbed(true);
		if (this.changeCursorPos)
			this.changeCursorPos = false;
		else {
			this.camera.rotation.y -= GameValues.CURRENT_DELTA * (event.dx / 10);
			this.camera.rotation.x -= GameValues.CURRENT_DELTA * (event.dy / 10);
		}
		
		if (event.endx <= 0 || event.endx >= Settings.Window.Size.Width || event.endy <= 0 || event.endy >= Settings.Window.Size.Height - 10) {
			Mouse.setCursorPosition((int) Settings.Window.Size.Width / 2, (int) Settings.Window.Size.Height / 2);
			this.changeCursorPos = true;
		}
	}
	
	public static void main(String[] args) {
		new Rectangle3DTest();
	}
	
}