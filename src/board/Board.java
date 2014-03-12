package board;

import java.util.Iterator;

/**
 * Board class for general use in board based games.
 * For more information, visit Github page:
 * https://github.com/Shathra/board
 * 
 * @author Selcuk Gulcan
 * @version 2.0
 */

public class Board implements Iterator<Tile>, Iterable<Tile> {

	//A - Properties & Constants
	private int current = 0; //For implementation of iterator.
	
	//Constants
	public final static int QUADRATIC = 0;
	public final static int HEXAGONAL = 1;
	public final static int TRIANGULAR = 2;
	
	//Direction Arrays
	public final static int[][] DIR4 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public final static int[][] DIR6_EVEN = {{-2,0}, {-1,1}, {1,1}, {2,0}, {1,0}, {-1,0}};
	public final static int[][] DIR6_ODD = {{-2,0}, {-1,0}, {1,0}, {2,0}, {1,-1}, {-1,-1}};
	public final static int[][] DIR3_EVEN = {{0, 1}, {1, 0}, {0, -1}};
	public final static int[][] DIR3_ODD = {{-1, 0}, {0, 1}, {0, -1}};
	
	protected int rows;
	protected int cols;
	protected Tile[][] map;
	
	//Static Methods
	public static Board createQuadBoard( int rows, int cols) {
		
		return new BoardQuad( rows, cols);
	}
	
	public static Board createTriBoard( int rows, int cols) {
		
		return new BoardTri( rows, cols);
	}
	
	public static Board createHexBoard( int rows, int cols) {
		
		return new BoardHex( rows, cols);
	}
	
	public Board( int rows, int cols) {
		
		
		if( rows <= 0 || cols <= 0)
			throw new RuntimeException( "Exception: Invalid number of rows or cols (02)");
		
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
	public boolean isIn( Tile tile) {
		
		return isIn( tile.row, tile.col);
	}
	
	public boolean isIn( int row, int col) {
		
		return row >= 0 && col >= 00 && row < this.rows && col < this.cols; 
	}
	
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
		
		if( !isIn(row, col))
			throw new RuntimeException( "Exception: Invalid number of rows or cols (02)");
			
		Area areaToReturn = new Area();
		int[][] traverseArr = DIR4;
		
		for( int i = 0; i < traverseArr.length; i++) {

			Tile tileToAdd = getTile( row + traverseArr[i][0], col + traverseArr[i][1]);
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
