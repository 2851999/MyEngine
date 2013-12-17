/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game2d.tilemap;

import org.simplecorporation.myengine.core.game2d.entity.ImageEntity2D;

public class TileMap2D {
	
	/* An array of image entities */
	public ImageEntity2D[][] tiles;
	
	/* The constructor */
	public TileMap2D(ImageEntity2D[][] tiles) {
		//Assign the tiles
		this.tiles = tiles;
	}
	
	/* The method to update all of the tiles */
	public void update() {
		//Look at every tile
		for (int a = 0; a < this.tiles.length; a++) {
			//Avoid NullPointerException
			if (this.tiles[a] != null) {
				for (int b = 0; b < this.tiles[a].length; b++) {
					//Avoid NullPointer Exception
					if (this.tiles[a][b] != null) {
						//Update the current tile
						this.tiles[a][b].update();
					}
				}
			}
		}
	}
	
	/* The method to render all of the tiles */
	public void render() {
		//Look at every tile
		for (int a = 0; a < this.tiles.length; a++) {
			//Avoid NullPointerException
			if (this.tiles[a] != null) {
				for (int b = 0; b < this.tiles[a].length; b++) {
					//Avoid NullPointer Exception
					if (this.tiles[a][b] != null) {
						//Render the current tile
						this.tiles[a][b].render();
					}
				}
			}
		}
	}
	
	/* The method to move the tiles a certain direction */
	public void move(double x , double y) {
		//Look at every tile
		for (int a = 0; a < this.tiles.length; a++) {
			//Avoid NullPointerException
			if (this.tiles[a] != null) {
				for (int b = 0; b < this.tiles[a].length; b++) {
					//Avoid NullPointer Exception
					if (this.tiles[a][b] != null) {
						//Move the current tile
						this.tiles[a][b].position.x += x;
						this.tiles[a][b].position.y += y;
					}
				}
			}
		}
	}
	
	/* The method to set a certain tile */
	public void setTile(int x , int y , ImageEntity2D tile) {
		//Set the title
		this.tiles[x][y] = tile;
	}
	
	/* The method that returns a certain tile */
	public ImageEntity2D getTile(int x , int y) {
		//Return the tile
		return this.tiles[x][y];
	}
	
	/* The method to get the map width */
	public int getMapWidth() {
		//Avoid NullPointer Exception
		int count = 0;
		while (this.tiles[count] == null) {
			count ++;
		}
		//Return the map width
		return this.tiles[count].length;
	}
	
	/* The method to get the map height */
	public int getMapHeight() {
		//Return the map height
		return this.tiles.length;
	}
	
}