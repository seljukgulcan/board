import java.util.Iterator;

/**
 * Board class for general use in board based games.
 * 
 * @author Selçuk Gülcan
 * @version 1
 */

public class Board implements Iterator<Tile>, Iterable<Tile> {

	//A - Properties
	private int current = 0; //For implementation of iterator.
	
	//Direction Arrays
	public final static int[][] DIR = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
	public final static int[] UP = DIR[1];
	public final static int[] DOWN = DIR[6];
	public final static int[] RIGHT = DIR[4];
	public final static int[] LEFT = DIR[3];
	public final static int[][] STRAIGHT_DIR = {DIR[1], DIR[4], DIR[6], DIR[3]};
	
	protected int rows;
	protected int cols;
	protected Tile[][] map;
	
	//B - Constructors
	public Board( int rows, int cols) {
		
		this.rows = rows;
		this.cols = cols;
		map = new Tile[rows][cols];
		for( int i = 0; i < rows; i++)
			for( int j = 0; j < cols; j++)
				map[i][j] = new Tile( i, j);
	}
	
	//C - Methods
	//C.1 - Get Methods
	public int getRows() {
		
		return rows;
	}
	
	public int getCols() {
		
		return cols;
	}
	
	public Tile getTile( int row, int col) {
		
		if( row >= 0 && row < rows && col >= 0 && col < cols)
			return map[row][col];
		
		return null;
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
	
	public Area getAdjacentTiles( Tile tile) {
		
		return getAdjacentTiles( tile.row, tile.col);
	}
	
	public Area getAdjacentTiles( int row, int col) {
		
		Area areaToReturn = new Area();
		
		for( int i = 0; i < STRAIGHT_DIR.length; i++) {
			
			Tile tileToAdd = getTile( row + STRAIGHT_DIR[i][0], col + STRAIGHT_DIR[i][1]);
			if( tileToAdd != null)
				areaToReturn.addTile( tileToAdd);
		}
		
		return areaToReturn;
	}
	
	public Area getNearTiles( Tile tile) {
		
		return getNearTiles( tile.row, tile.col);
	}
	
	public Area getNearTiles( int row, int col) {
		
		Area areaToReturn = new Area();
		
		for( int i = 0; i < DIR.length; i++) {
			
			Tile tileToAdd = getTile( row + DIR[i][0], col + DIR[i][1]);
			if( tileToAdd != null)
				areaToReturn.addTile( tileToAdd);
		}
		
		return areaToReturn;
	}
	
	@Override
	public Iterator<Tile> iterator() {
		
		current = 0;
		return this;
	}

	@Override
	public boolean hasNext() {
		
		if( current < rows * cols)
			return true;
		
		return false;
	}

	@Override
	public Tile next() {
		
		current++;
		return map[ ( current - 1) / cols][ ( current - 1) % cols];
	}

	@Override
	public void remove() {
		
		//No remove operation is allowed in Board class.
	}
}
