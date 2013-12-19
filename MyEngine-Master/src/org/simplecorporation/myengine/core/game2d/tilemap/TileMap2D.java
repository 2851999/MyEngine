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

import org.simplecorporation.myengine.core.game2d.tilemap.Tile2D.Type;

public class TileMap2D {
	
	/* An array of image entities */
	public Tile2D[][] tiles;
	
	/* The tile size */
	public int tileSize;
	
	/* The starting y position */
	public int startY;
	
	/* The constructor */
	public TileMap2D(Tile2D[][] tiles, int tileSize , int startY) {
		//Assign the variables
		this.tiles = tiles;
		this.tileSize = tileSize;
		this.startY = startY;
		//Call the method to set all of the tile positions
		resetTilePositions();
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
	
	/* The method used to reset every tiles positions */
	public void resetTilePositions() {
		//The x and y position
		int x = 0;
		int y = startY;
		//Look at every tile in the 2D array
		for (int a = 0; a < this.tiles.length; a++) {
			for (int b = 0; b < this.tiles[a].length; b++) {
				//Set the x and y position of the current tile
				this.tiles[a][b].position.x = x;
				this.tiles[a][b].position.y = y;
				//Set the width and height of the current tile
				this.tiles[a][b].width = tileSize;
				this.tiles[a][b].height = tileSize;
				//Increment the current x position by the tile size
				x += tileSize;
			}
			//Reset the x position to 0
			x = 0;
			//Increment the current y position by the tile size
			y += tileSize;
		}
	}
	
	/* Check whether the right of a position is blocked */
	public boolean isRightBlocked(double x, double y) {
		//The boolean that states whether the position is blocked
		boolean blocked = false;
		//The current tile's position in the array
		int tempx = (int) x;
		int tempy = (int) y;
		//Set the correct temporary y position
		tempy = (int) (y - startY);
		//Calculate the column/row
		int column = (tempx / this.tileSize) + 1;
		int row = (tempy / this.tileSize);
		//Avoid an index out of bounds exception
		if (row < this.tiles.length && row >= 0 && column < this.tiles[0].length && column >= 0) {
			//Check the tile type of the left most tile
			blocked = this.tiles[row][column].type == Type.SOLID;
		}
		//Return the blocked value
		return blocked;
	}
	
	/* Check whether the left of a position is blocked */
	public boolean isLeftBlocked(double x, double y) {
		//The boolean that states whether the position is blocked
		boolean blocked = false;
		//The current tile's position in the array
		int tempx = (int) x;
		int tempy = (int) y;
		//Set the correct temporary y position
		tempy = (int) (y - startY);
		//Calculate the column/row
		int column = (tempx / this.tileSize) - 1;
		int row = (tempy / this.tileSize);
		//Avoid an index out of bounds exception
		if (row < this.tiles.length && row >= 0 && column < this.tiles[0].length && column >= 0) {
			//Check the tile type of the left most tile
			blocked = this.tiles[row][column].type == Type.SOLID;
		}
		//Return the blocked value
		return blocked;
	}
	
	/* Check whether the top of a position is blocked */
	public boolean isTopBlocked(double x, double y) {
		//The boolean that states whether the position is blocked
		boolean blocked = false;
		//The current tile's position in the array
		int tempx = (int) x;
		int tempy = (int) y;
		//Set the correct temporary y position
		tempy = (int) (y - startY);
		//Calculate the column/row
		int column = (tempx / this.tileSize);
		int row = (tempy / this.tileSize) - 1;
		//Avoid an index out of bounds exception
		if (row < this.tiles.length && row >= 0 && column < this.tiles[0].length && column >= 0) {
			//Check the tile type of the left most tile
			blocked = this.tiles[row][column].type == Type.SOLID;
		}
		//Return the blocked value
		return blocked;
	}
	
	/* Check whether the bottom of a position is blocked */
	public boolean isBottomBlocked(double x, double y) {
		//The boolean that states whether the position is blocked
		boolean blocked = false;
		//The current tile's position in the array
		int tempx = (int) x;
		int tempy = (int) y;
		//Set the correct temporary y position
		tempy = (int) (y - startY);
		//Calculate the column/row
		int column = (tempx / this.tileSize);
		int row = (tempy / this.tileSize) + 1;
		//Avoid an index out of bounds exception
		if (row < this.tiles.length && row >= 0 && column < this.tiles[0].length && column >= 0) {
			//Check the tile type of the left most tile
			blocked = this.tiles[row][column].type == Type.SOLID;
		}
		//Return the blocked value
		return blocked;
	}
	
	/* The method to set a certain tile */
	public void setTile(int x , int y , Tile2D tile) {
		//Set the title
		this.tiles[x][y] = tile;
	}
	
	/* The method that returns a certain tile */
	public Tile2D getTile(int x , int y) {
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