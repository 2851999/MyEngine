/* *********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013 - 2014
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.image;

import javax.microedition.khronos.opengles.GL10;

import org.simplecorporation.myengine.core.android.AndroidActivityListener;
import org.simplecorporation.myengine.core.android.AndroidStore;

import android.graphics.Bitmap;
import android.opengl.GLUtils;

public class AndroidOpenGLESImage extends AndroidActivityListener {
	
	/* The bitmap used in this image */
	public Bitmap bitmap;
	
	/* The id of the texture once binded */
	public int textureId;
	
	/* The boolean that states whether this image should be binded */
	public boolean shouldBind;
	
	/* The constructor */
	public AndroidOpenGLESImage() {
		//Assign the variables
		this.bitmap = null;
		this.textureId = -1;
		this.shouldBind = true;
	}
	
	/* The constructor with the image given*/
	public AndroidOpenGLESImage(Bitmap bitmap) {
		//Assign the variables
		this.bitmap = bitmap;
		this.textureId = -1;
		this.shouldBind = true;
	}
	
	/* The method used to bind this image */
	public void bind() {
		//Check to see whether this image should be binded
		if (this.shouldBind) {
			//Get the GL10 instance
			GL10 gl = AndroidStore.gl10;
			//Bind this image
			
			//Create the array to store the texture pointer
			int[] texturePointers = new int[1];
			//Generate the texture
			//1 = number of textures
			//0 = offset (Starting index in the array)
			gl.glGenTextures(1, texturePointers, 0);
			//Assign the id
			this.textureId = texturePointers[0];
			
			//Bind the texture pointer (id) to the array
			gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);
			
			//NOTE: Future, add video setting to change render quality
			//GL_LINEAR = blurred, better performance
			//GL_NEAREST = crisper, slower performance
			
			//Setup the parameters
			//MAG = Magnification
			//MIN = Minification (Opposite of MAG)
			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);
			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
			
			//Bind the bitmap to the texture id
			GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.bitmap, 0);
			
			//Set should bind to false since the image has just been bound
			this.shouldBind = false;
		}
	}
	
	/* The method used to release this image */
	public void release() {
		//Make sure shouldBind = false so that we know that the image should have
		//already been bound otherwise releasing may cause problems
		if (! this.shouldBind) {
			//Release the image by deleting the texture from memory
			AndroidStore.gl10.glDeleteTextures(1, new int[] { this.textureId }, 0);
			//Set should bind to true
			this.shouldBind = true;
		}
	}
	
	/* The method called when the activity is paused */
	public void activityPaused() {
		//When the activity pauses it appears that the textures in the memory are
		//cleared and so MyEngine will just display white areas where ever an
		//image should be rendered, for this reason when the activity pauses
		//'shouldBind' should be set to true so that the image is re-binded
		this.shouldBind = true;
	}
	
}