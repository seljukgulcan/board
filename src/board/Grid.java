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
		
		return getTile( base.row + direction[0], base.col + direction[1]);
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
		
		Iterator<Tile> it = iterator();
		while( it.hasNext())
			it.next().setState(key, state);
	}
	
	public void set( String key, Object object) {
		
		Iterator<Tile> it = iterator();
		while( it.hasNext())
			it.next().set(key, object);
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
		
		if( tile == null)
			return false;
		
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
	
	public Area getRange( int row, int col, int radius) {
		
		return getRange( getTile( row, col), radius);
	}
	
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
	
	public Area getRange( int row, int col, int radiusStart, int radiusEnd) {
		
		return getRange( getTile(row, col), radiusStart, radiusEnd);
	}
	
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
	
	public Area getLine( int row, int col, int[] direction) {
		
		return getLine( getTile( row, col), direction);
	}
	
	
	public Area getLine( Tile base, int[] direction, int length) {
		
		Area areaToReturn = new Area();
		for( int i = 0; i < length; i++) {
			
			Tile tileToAdd = getTile( base.row + i * direction[0], base.col + i * direction[1]);
			
			if( isIn( tileToAdd))
				areaToReturn.addTile( tileToAdd);
		}
		
		return areaToReturn;
	}
	
	public Area getLine( int row, int col, int[] direction, int length) {
		
		return getLine( getTile( row, col), direction, length);
	}
	
	public Area getLine( Tile base, int[] direction, int startPoint, int endPoint) {
		
		Area areaToReturn = new Area();
		for( int i = startPoint; i < endPoint; i++) {
			
			Tile tileToAdd = getTile( base.row + i * direction[0], base.col + i * direction[1]);
			if( isIn( tileToAdd))
				areaToReturn.addTile( tileToAdd);
		}
		
		return areaToReturn;
	}
	
	public Area getLine( int row, int col, int[] direction, int startPoint, int endPoint) {
		
		return getLine( getTile( row, col), direction, startPoint, endPoint);
	}
	
	public Tile getRandomTile() {
		
		int rand = (int) (Math.random() * rows * cols);
		return getTile( rand / cols, rand & cols);
	}
	
	public Area getRandomTiles() {
		
		return getRandomTiles( ((int)Math.random() * rows * cols) + 1);
	}
	
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
