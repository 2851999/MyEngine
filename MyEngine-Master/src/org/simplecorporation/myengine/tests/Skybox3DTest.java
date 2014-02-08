package org.simplecorporation.myengine.tests;

import org.lwjgl.input.Mouse;
import org.simplecorporation.myengine.core.game.BaseGame;
import org.simplecorporation.myengine.core.game.GameValues;
import org.simplecorporation.myengine.core.game3d.camera.Camera;
import org.simplecorporation.myengine.core.game3d.camera.skybox.Skybox;
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

public class Skybox3DTest extends BaseGame {
	
	public Camera camera;
	public Image texture;
	public Image sky;
	public Skybox skybox;
	public boolean changeCursorPos;
	public int draw;
	
	public Skybox3DTest() {
		Settings.Window.Title = "Skybox 3D Test";
		Settings.Window.Fullscreen = false;
		Settings.Window.Size.Width = 1024;
		Settings.Window.Size.Height = 600;
		Settings.Video.OpenGL = true;
		Settings.Video.VSync = false;
		Settings.Video.MaxFPS = 0;
		this.changeCursorPos = false;
		createGame();
	}
	
	public void gameCreated() {
		this.texture = new Image("C:\\grass1.png", "PNG", true);
		this.sky = new Image("C:\\sky.png", "PNG", true);
		this.camera = new Camera();
		this.skybox = new Skybox(100, 100, 100, this.sky, this.sky, this.sky, this.sky, this.sky, this.sky);
		this.draw = DisplayList.generate();
		BasicRenderer.setColour(Colour.WHITE);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, 0, -5), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(new Image("C:\\computinghwkplatform32.png", "PNG", true), new Vector3D(0, 0, -7), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, 0, -9), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, 0, -11), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, 0, -13), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, 2, -5), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, 2, -7), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, 2, -9), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, 2, -11), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, 2, -13), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, -2, -5), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, -2, -7), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, -2, -9), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, -2, -11), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(0, -2, -13), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, 0, -5), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, 0, -7), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, 0, -9), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, 0, -11), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, 0, -13), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, 2, -5), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, 2, -7), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, 2, -9), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, 2, -11), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, 2, -13), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, -2, -5), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, -2, -7), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, -2, -9), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, -2, -11), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(2, -2, -13), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, 0, -5), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, 0, -7), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, 0, -9), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, 0, -11), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, 0, -13), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, 2, -5), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, 2, -7), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, 2, -9), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, 2, -11), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, 2, -13), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, -2, -5), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, -2, -7), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, -2, -9), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, -2, -11), 1, 1, 1);
		BasicRenderer3DOpenGL.renderTexturedCube(this.texture, new Vector3D(-2, -2, -13), 1, 1, 1);
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
		//Colours wont work without disabling TEXTURE_2D
		OpenGLUtils.disableTexture2D();
		this.camera.useView();
		BasicRenderer.setColour(Colour.WHITE);
		this.texture.getOpenGLImage().bind();
		this.sky.getOpenGLImage().bind();
		this.skybox.render(this.camera.position);
		BasicRenderer3DOpenGL.renderTexturedTriangle(this.texture, new Vector3D(0,1,-2), new Vector3D(0, 0, -2), new Vector3D(-1, 0, -2));
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
		new Skybox3DTest();
	}
	
}