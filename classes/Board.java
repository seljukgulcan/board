/**
 * Board class for general use in board based games.
 * 
 * @author Selçuk Gülcan
 * @version 1
 */

public class Board {

	//A - Properties
	//Direction Arrays
	public final static int[][] DIR = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
	public final static int[] UP = DIR[1];
	public final static int[] DOWN = DIR[6];
	public final static int[] RIGHT = DIR[4];
	public final static int[] LEFT = DIR[3];
	
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
	
	//C.2 - Set Methods
	public boolean setState( Tile tile, int index, int state) {
		
		return tile.setState( index, state);
	}
	
	public boolean setState( int row, int col, int index, int state) {
		
		return getTile( row, col).setState( index, state);
	}
	
	//C.3 - Other Methods
	public void addState( Tile tile, int state) {
		
		tile.addState( state);
	}
	
	public void addState( int row, int col, int state) {
		
		getTile( row, col).addState( state);
	}
}
