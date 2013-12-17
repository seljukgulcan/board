/**
 * Board class for general use in board based games.
 * 
 * @author Selçuk Gülcan
 * @version 1
 */

public class Board {

	//A - Properties
	protected int width;
	protected int height;
	protected Tile[][] map;
	
	//B - Constructors
	public Board( int width, int height) {
		
		this.width = width;
		this.height = height;
		map = new Tile[width][height];
		for( int i = 0; i < width; i++)
			for( int j = 0; j < height; j++)
				map[i][j] = new Tile();
	}
	
	//C - Methods
	//C.1 - Get Methods
	public int getWidth() {
		
		return width;
	}
	
	public int getHeight() {
		
		return height;
	}
	
	public Tile getTile( int row, int col) {
		
		return map[row][col];
	}
	
	public int getState( Tile tile, int index) {
		
		return tile.getState( index);
	}
	
	public int getState( int row, int col, int index) {
		
		return getTile( row, col).getState( index);
	}
	
	public int[] getAllStates( Tile tile) {
		
		return tile.getAllStates();
	}
	
	public int[] getAllStates( int row, int col) {
		
		return getTile( row, col).getAllStates();
	}
}
