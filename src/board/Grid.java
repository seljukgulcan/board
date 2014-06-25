package board;

import java.util.Iterator;

/**
 * Grid parent class
 * Contains shared methods used by sub grid classes.
 * 
 * @author Selcuk Gulcan
 */

public abstract class Grid implements Iterator<Tile>, Iterable<Tile> {

	//A - Properties & Constants
	private int current = 0; //For implementation of iterator.
	
	protected int[][] 	direction;
	protected int 		rows;
	protected int 		cols;
	protected Tile[][] 	map;
	
	//Static Methods
	
	/**
	 * 
	 * @param rows number of rows of the grid.
	 * @param cols number of columns of the grid.
	 */
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
	/**
	 * Returns the number of rows.
	 * 
	 * @return
	 */
	public int getRows() {
		
		return rows;
	}
	
	/**
	 * Returns the number of columns.
	 * 
	 * @return
	 */
	public int getCols() {
		
		return cols;
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return Tile object or null if row and column indexes are not matched with any tile in the grid.
	 */
	public Tile getTile( int row, int col) {
		
		if( row >= 0 && row < rows && col >= 0 && col < cols)
			return map[row][col];
		
		return null;
	}
	
	/**
	 * Return tile object at given direction according to base Tile object.
	 * 
	 * @param base
	 * @param direction
	 * @return Tile object or null if no tile objects match with the given condition.
	 */
	public Tile getTile( Tile base, int[] direction) {
		
		return getTile( base.row + direction[0], base.col + direction[1]);
	}
	
	/**
	 * 
	 * @param tile
	 * @param key
	 * @return
	 * @exception NullPointerException if there is no state with given key.
	 */
	public int getState( Tile tile, String key) {
		
		return tile.getState( key);
	}
	
	/**
	 * Overloaded version of getState( Tile, String) 
	 * 
	 * @see #getState(Tile, String)
	 */
	public int getState( int row, int col, String key) {
		
		return getTile( row, col).getState( key);
	}
	
	/**
	 * Returns all states of a tile.
	 * 
	 * @param tile
	 * @return array of integers containing states of given tile or null if tile has not contain a state.
	 */
	public int[] getAllStates( Tile tile) {
		
		return tile.getAllStates();
	}
	
	/**
	 * Overloaded version of getAllStates( Tile)
	 * 
	 * @see #getAllStates(Tile)
	 */
	public int[] getAllStates( int row, int col) {
		
		return getTile( row, col).getAllStates();
	}
	
	/**
	 * 
	 * @param tile
	 * @param key
	 * @return
	 * @exception NullPointerException if there is no object with given key.
	 */
	public Object get( Tile tile, String key) {
		
		return tile.get(key);
	}
	
	/**
	 * Overloaded version of get( Tile, String)
	 * 
	 * @see #get(Tile, String)
	 */
	public Object get( int row, int col, String key) {
		
		return getTile( row, col).get( key);
	}
	
	//C.2 - Set Methods
	/**
	 * Sets state of all tiles.
	 * 
	 * @param key
	 * @param state
	 */
	public void setState( String key, int state) {
		
		Iterator<Tile> it = iterator();
		while( it.hasNext())
			it.next().setState(key, state);
	}
	
	/**
	 * Sets object of all tiles.
	 * 
	 * @param key
	 * @param object
	 */
	public void set( String key, Object object) {
		
		Iterator<Tile> it = iterator();
		while( it.hasNext())
			it.next().set(key, object);
	}
	
	/**
	 * Sets state of a particular tile.
	 * 
	 * @param tile
	 * @param name
	 * @param state
	 */
	public void setState( Tile tile, String name, int state) {
		
		tile.setState( name, state);
	}
	
	/**
	 * Overloaded version of setState( Tile, String, int)
	 * 
	 * @see #setState(Tile, String, int)
	 */
	public void setState( int row, int col, String key, int state) {
		
		getTile( row, col).setState( key, state);
	}
	
	/**
	 * Sets object of a particular tile.
	 * 
	 * @param tile
	 * @param key
	 * @param object
	 */
	public void set( Tile tile, String key, Object object) {
		
		tile.set(key, object);
	}
	
	/**
	 * Overloaded version of setState( Tile, String, Object)
	 * 
	 * @see #set(Tile, String, Object)
	 */
	public void set( int row, int col, String key, Object object) {
		
		getTile(row, col).set(key, object);
	}
	
	//C.3 - Other Methods
	/**
	 * Works as the same as isIn( int, int)
	 * 
	 * @see #isIn(int, int)
	 */
	public boolean isIn( Tile tile) {
		
		if( tile == null)
			return false;
		
		return isIn( tile.row, tile.col);
	}
	
	/**
	 * Checks whether a tile with given row and column values is in the grid or not.
	 * 
	 * @param row row value
	 * @param col column value
	 * @return
	 */
	public boolean isIn( int row, int col) {
		
		return row >= 0 && col >= 00 && row < this.rows && col < this.cols; 
	}
	
	/**
	 * 
	 * @param tile
	 * @param name
	 * @param state
	 */
	public void addState( Tile tile, String name, int state ) {
		
		setState( tile, name, state);
	}
	
	/**
	 * Overloaded version of addState( Tile, String, int)
	 * 
	 * @see #addState(Tile, String, int)
	 */
	public void addState( int row, int col, String name, int state) {
		
		setState( row, col, name, state);
	}
	
	/**
	 * 
	 * @param tile base Tile object.
	 * @return
	 */
	public Area getAdjacentTiles( Tile tile) {
		
		return getAdjacentTiles( tile.row, tile.col);
	}
	
	/**
	 * Overloaded version of getAdjacentTiles( Tile)
	 * 
	 * @see #getAdjacentTiles(Tile)
	 */
	
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
	
	/**
	 * 
	 * @param center
	 * @param radius
	 * @return
	 */
	public Area getRange( Tile center, int radius) {
		
		Tile tileOnLine;
		int rowOnLine, colOnLine;
		int row = center.row;
		int col = center.col;
		Area area = new Area();
		area.addTile( center);
		for( int i = 0; i < direction.length; i++) {
			
			for( int j = 1; j < radius; j++) {
				
				tileOnLine = getTile( row + j * direction[i][0], col + j * direction[i][1]);
				area.addTile( tileOnLine);
				rowOnLine = tileOnLine.row;
				colOnLine = tileOnLine.col;
				
				for( int k = 1; k < j; k++) {
					
					area.addTile( getTile( rowOnLine + k * direction[ ( i + 2) % direction.length][0],
								  		   colOnLine + k * direction[ ( i + 2) % direction.length][1]));
				}
			}
		}
		
		return area;
	}
	
	/**
	 * Overloaded version of getRange( Tile, int)
	 * 
	 * @see #getRange(Tile, int)
	 */
	public Area getRange( int row, int col, int radius) {
		
		return getRange( getTile( row, col), radius);
	}
	
	/**
	 * Gets all tile with given range.
	 * 
	 * @param center base Tile object.
	 * @param radiusStart Starting radius value.
	 * @param radiusEnd Ending radius value.
	 * @return
	 * @see #getRange(Tile, int)
	 */
	public Area getRange( Tile center, int radiusStart, int radiusEnd) {
		
		if( radiusStart == 0)
			return getRange( center, radiusEnd + 1);
		
		Tile tileOnLine;
		int rowOnLine, colOnLine;
		int row = center.row;
		int col = center.col;
		Area area = new Area();
		for( int i = 0; i < direction.length; i++) {
			
			for( int j = radiusStart; j < radiusEnd; j++) {
				
				tileOnLine = getTile( row + j * direction[i][0], col + j * direction[i][1]);
				area.addTile( tileOnLine);
				rowOnLine = tileOnLine.row;
				colOnLine = tileOnLine.col;
				
				for( int k = 1; k < j; k++) {
					
					area.addTile( getTile( rowOnLine + k * direction[ ( i + 2) % direction.length][0],
								  		   colOnLine + k * direction[ ( i + 2) % direction.length][1]));
				}
			}
		}
		
		return area;
	}
	
	/**
	 * Overloaded version of getRange( Tile, int, int)
	 * 
	 * @see #getRange(Tile, int, int)
	 */
	public Area getRange( int row, int col, int radiusStart, int radiusEnd) {
		
		return getRange( getTile(row, col), radiusStart, radiusEnd);
	}
	
	/**
	 * Returns Area object holding all tiles in given line.
	 * 
	 * @param base base Tile.
	 * @param direction
	 * @return
	 */
	public Area getLine( Tile base, int[] direction) {
		
		Area areaToReturn = new Area();
		Tile tileToAdd = base;
		while( isIn( tileToAdd)) {
			
			areaToReturn.addTile( tileToAdd);
			tileToAdd = getTile( 	tileToAdd.row + direction[0],
									tileToAdd.col + direction[1]);
		}
		
		return areaToReturn;
	}
	
	/**
	 * Overloaded version of getLine( Tile, int[])
	 * 
	 * @see #getLine(Tile, int[])
	 */
	public Area getLine( int row, int col, int[] direction) {
		
		return getLine( getTile( row, col), direction);
	}
	
	/**
	 * Overloaded version of getLine( Tile, int[]) except the length of the line can be determined.
	 * 
	 * @see #getLine(Tile, int[])
	 */
	public Area getLine( Tile base, int[] direction, int length) {
		
		Area areaToReturn = new Area();
		for( int i = 0; i < length; i++) {
			
			Tile tileToAdd = getTile( base.row + i * direction[0], base.col + i * direction[1]);
			
			if( isIn( tileToAdd))
				areaToReturn.addTile( tileToAdd);
		}
		
		return areaToReturn;
	}
	
	/**
	 * Overloaded version of getLine( Tile, int[]) except the length of the line can be determined.
	 * 
	 * @see #getLine(Tile, int[])
	 */
	public Area getLine( int row, int col, int[] direction, int length) {
		
		return getLine( getTile( row, col), direction, length);
	}
	
	/**
	 * Overloaded version of getLine( Tile, int[]) except the start and end points can be determined.
	 * 
	 * @see #getLine(Tile, int[])
	 */
	public Area getLine( Tile base, int[] direction, int startPoint, int endPoint) {
		
		Area areaToReturn = new Area();
		for( int i = startPoint; i < endPoint; i++) {
			
			Tile tileToAdd = getTile( base.row + i * direction[0], base.col + i * direction[1]);
			if( isIn( tileToAdd))
				areaToReturn.addTile( tileToAdd);
		}
		
		return areaToReturn;
	}
	
	/**
	 * Overloaded version of getLine( Tile, int[]) except the start and end points can be determined.
	 * 
	 * @see #getLine(Tile, int[])
	 */
	public Area getLine( int row, int col, int[] direction, int startPoint, int endPoint) {
		
		return getLine( getTile( row, col), direction, startPoint, endPoint);
	}
	
	/**
	 * Returns a random tile.
	 * 
	 * @return Tile object or null if grid is empty.
	 */
	public Tile getRandomTile() {
		
		int rand = (int) (Math.random() * rows * cols);
		return getTile( rand / cols, rand & cols);
	}
	
	/**
	 * Works like getRandomTiles( int) except the number of random tiles is also random.
	 * 
	 * @return
	 * @see #getRandomTiles(int)
	 */
	public Area getRandomTiles() {
		
		return getRandomTiles( ((int)Math.random() * rows * cols) + 1);
	}
	
	/**
	 * Returns random tiles whose number is specified in parameters.
	 * @param number the number of random tiles.
	 * @return
	 */
	public Area getRandomTiles( int number) {
		int n = rows * cols;
		if( number > n)
			throw new RuntimeException( "number of random numbers is greater than total number of tiles.");
		
		int[] arr = new int[ n];
		int r;
		Area areaToReturn = new Area();
		
		for( int i = 0; i < n; i++)
			arr[i] = i;
		
		for( int i = 0; i < number; i++) {
			
			r = (int)(Math.random() * n);
			areaToReturn.addTile( getTile( arr[r] / cols, arr[r] % cols));
			arr[r] = arr[ n - 1];
			n--;
		}
		
		return areaToReturn;
	}
	
	/**
	 * Returns area of tiles whose states are matched with given condition.
	 * 
	 * @param key
	 * @param state
	 * @return
	 */
	public Area find( String key, int state) {
		
		Area areaToReturn = new Area();
		Iterator<Tile> it = iterator();
		while( it.hasNext()) {
			
			Tile tile = it.next();
			if( tile.getState( key) == state)
				areaToReturn.addTile( tile);
		}
		
		return areaToReturn;
	}
	
	/**
	 * Returns area of tiles whose objects are matched with given condition.
	 * 
	 * @param key
	 * @param object
	 * @return
	 */
	public Area find( String key, Object object) {
		
		Area areaToReturn = new Area();
		Iterator<Tile> it = iterator();
		while( it.hasNext()) {
			
			Tile tile = it.next();
			if( tile.get( key) == object)
				areaToReturn.addTile( tile);
		}
		
		return areaToReturn;
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
