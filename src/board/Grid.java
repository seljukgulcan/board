package board;

import java.util.Iterator;

/**
 * Grid parent class
 * TODO: Add description
 * 
 * @author Selcuk Gulcan
 */

public abstract class Grid implements Iterator<Tile>, Iterable<Tile> {

	//A - Properties & Constants
	private int current = 0; //For implementation of iterator.
	
	//Constants
	
	//Direction Arrays
	public final static int[][] DIR4 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public final static int[][] DIR6 = {{-1,1}, {0,1}, {1,0}, {1,-1}, {0,-1}, {-1,0}};
	/*public final static int[][] DIR3_EVEN = {{0, 1}, {1, 0}, {0, -1}};
	public final static int[][] DIR3_ODD = {{-1, 0}, {0, 1}, {0, -1}};*/
	
	protected int[][] 	direction;
	protected int 		rows;
	protected int 		cols;
	protected Tile[][] 	map;
	
	//Static Methods
	
	public Grid( int rows, int cols) {
		
		
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
	
	public Tile getTile( Tile base, int[] direction) {
		
		//TODO: Fill the method
		return null;
	}
	
	public int getState( Tile tile, String key) {
		
		return tile.getState( key);
	}
	
	public int getState( int row, int col, String key) {
		
		return getTile( row, col).getState( key);
	}
	
	public int[] getAllStates( Tile tile) {
		
		return tile.getAllStates();
	}
	
	public int[] getAllStates( int row, int col) {
		
		return getTile( row, col).getAllStates();
	}
	
	public Object get( Tile tile, String key) {
		
		return tile.get(key);
	}
	
	public Object get( int row, int col, String key) {
		
		return getTile( row, col).get( key);
	}
	
	//C.2 - Set Methods
	public void setState( String key, int state) {
		
		//TODO: Fill the method
	}
	
	public void set( String key, Object object) {
		
		//TODO: Fill the method
	}
	
	public void setState( Tile tile, String name, int state) {
		
		tile.setState( name, state);
	}
	
	public void setState( int row, int col, String key, int state) {
		
		getTile( row, col).setState( key, state);
	}
	
	public void set( Tile tile, String key, Object object) {
		
		tile.set(key, object);
	}
	
	public void set( int row, int col, String key, Object object) {
		
		getTile(row, col).set(key, object);
	}
	
	//C.3 - Other Methods
	public boolean isIn( Tile tile) {
		
		return isIn( tile.row, tile.col);
	}
	
	public boolean isIn( int row, int col) {
		
		return row >= 0 && col >= 00 && row < this.rows && col < this.cols; 
	}
	
	public void addState( Tile tile, String name, int state ) {
		
		setState( tile, name, state);
	}
	
	public void addState( int row, int col, String name, int state) {
		
		setState( row, col, name, state);
	}
	
	public Area getAdjacentTiles( Tile tile) {
		
		return getAdjacentTiles( tile.row, tile.col);
	}
	
	public Area getAdjacentTiles( int row, int col) {
		
		if( !isIn(row, col))
			throw new RuntimeException( "Exception: Invalid number of rows or cols (02)");
			
		Area areaToReturn = new Area();
		
		for( int i = 0; i < direction.length; i++) {

			Tile tileToAdd = getTile( row + direction[i][0], col + direction[i][1]);
			if( tileToAdd != null)
				areaToReturn.addTile( tileToAdd);
		}
		
		return areaToReturn;
	}
	
	public Area getRange( Tile center, int radius) {
		
		//TODO: Fill the method
		return null;
	}
	
	public Area getRange( int row, int col, int radius) {
		
		//TODO: Fill the method
		return null;
	}
	
	public Area getRange( Tile center, int radiusStart, int radiusEnd) {
		
		//TODO: Fill the method
		return null;
	}
	
	public Area getRange( int row, int col, int radiusStart, int radiusEnd) {
		
		//TODO: Fill the method
		return null;
	}
	
	public Area getLine( Tile base, int length) {
		
		//TODO: Fill the method
		return null;
	}
	
	public Area getLine( int row, int col, int length) {
		
		//TODO: Fill the method
		return null;
	}
	
	public Area getLine( Tile base, int startPoint, int endPoint) {
		
		//TODO: Fill the method
		return null;
	}
	
	public Area getLine( int row, int col, int startPoint, int endPoint) {
		
		//TODO: Fill the method
		return null;
	}
	
	public Tile getRandomTile() {
		
		//TODO: Fill the method
		return null;
	}
	
	public Area getRandomTiles() {
		
		//TODO: Fill the method
		return null;
	}
	
	public Area getRandomTiles( int number) {
		
		//TODO: Fill the method
		return null;
	}
	
	public Area find( String key, int state) {
		
		//TODO: Fill the method
		return null;
	}
	
	public Area find( String key, Object object) {
		
		//TODO: Fill the method
		return null;
	}
	
	//Iterator methods
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
