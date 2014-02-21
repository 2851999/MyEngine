package org.simplecorporation.myengine.tests;

import org.lwjgl.input.Mouse;
import org.simplecorporation.myengine.core.game.BaseGame;
import org.simplecorporation.myengine.core.game.GameValues;
import org.simplecorporation.myengine.core.game3d.camera.Camera;
import org.simplecorporation.myengine.core.game3d.camera.skybox.Skybox;
import org.simplecorporation.myengine.core.game3d.model.Model;
import org.simplecorporation.myengine.core.game3d.model.OBJLoader;
import org.simplecorporation.myengine.core.image.Image;
import org.simplecorporation.myengine.core.input.KeyboardInput;
import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseMotionEvent;
import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.opengl.DisplayList;
import org.simplecorporation.myengine.utils.opengl.OpenGLSetupUtils;
import org.simplecorporation.myengine.utils.opengl.OpenGLUtils;

public class OBJModelTest extends BaseGame {
	
	public Camera camera;
	public Image texture;
	public Image sky;
	public Skybox skybox;
	public boolean changeCursorPos;
	public Model model;
	public int drawModel;
	public boolean wireframeMode;
	
	public OBJModelTest() {
		Settings.Window.Title = "OBJ 3D Model Test";
		Settings.Window.Fullscreen = false;
		Settings.Window.Size.Width = 1024;
		Settings.Window.Size.Height = 600;
		Settings.Video.OpenGL = true;
		Settings.Video.VSync = false;
		Settings.Video.MaxFPS = 0;
		this.changeCursorPos = false;
		this.wireframeMode = false;
		createGame();
	}
	
	public void gameCreated() {
		this.texture = new Image("C:\\grass1.png", "PNG", true);
		this.sky = new Image("C:\\sky.png", "PNG", true);
		this.camera = new Camera();
		this.skybox = new Skybox(100, 100, 100, this.sky, this.sky, this.sky, this.sky, this.sky, this.sky);
		this.model = OBJLoader.loadModel("C:/Users/Joel/Documents/cup.obj", true);
		this.drawModel = DisplayList.generate();
		this.model.render();
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
		
		OpenGLSetupUtils.setupPerspective(70, 0.1f, 1000);
		OpenGLSetupUtils.setupDepthTest();
		OpenGLUtils.clearColourBuffer();
		OpenGLUtils.clearDepthBuffer();
		//Colours wont work without disabling TEXTURE_2D
		OpenGLUtils.disableTexture2D();
		this.camera.useView();
		BasicRenderer.setColour(Colour.WHITE);
		this.sky.getOpenGLImage().bind();
		this.skybox.render(this.camera.position);
		this.texture.getOpenGLImage().bind();
		System.out.println(this.model.faces.size() + " Polygons");
		//Wireframe mode
		if (this.wireframeMode)
			OpenGLUtils.enableWireframeMode();
		else
			OpenGLUtils.disableWireframeMode();
		DisplayList.render(this.drawModel);
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
	
	public void onKeyReleased(KeyboardEvent event) {
		if (event.keyCode == KeyboardInput.KEY_M_CODE)
			this.wireframeMode = ! this.wireframeMode;
	}
	
	public static void main(String[] args) {
		new OBJModelTest();
	}
	
}