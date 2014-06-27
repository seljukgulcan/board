/**
 * Grid parent class
 * Contains shared methods used by sub grid classes.
 * 
 * @author Selcuk Gulcan
 */
using System;
using System.Collections;
using System.Collections.Generic;

namespace Board
{
	//public abstract class Grid implements Iterator<Tile>, Iterable<Tile> {
	public abstract class Grid : IEnumerator<Tile>, IEnumerable<Tile> {

		//A - Properties & Constants
		private int currentIndex = 0; //For implementation of iterator.
		
		//Constants
		
		//Direction Arrays
		public static readonly int[][] DIR4 = new int[4][] {
			new int[2]{-1, 0},
			new int[2]{0, 1},
			new int[2]{1, 0},
			new int[2]{0, -1}
		};
		
		public static readonly int[][] DIR6 = new int[6][] {
			new int[2]{-1, 0},
			new int[2]{-1, 1}, 
			new int[2]{0, 1},
			new int[2]{1, 0},
			new int[2]{1, -1},
			new int[2]{0, -1}
		};
		public static readonly int[][] DIR3_EVEN = new int[3][] {
			new int[2]{0, 1},
			new int[2]{1, 0},
			new int[2]{0, -1}
		};
		
		public static readonly int[][] DIR3_ODD = new int[3][] {
			new int[2]{-1, 0},
			new int[2]{0, 1},
			new int[2]{0, -1}
		};		//public final static int[][] DIR3_ODD = {{-1, 0}, {0, 1}, {0, -1}};
		
		protected int[][] 	direction;
		//protected int[][] 	direction;
		protected int 		rows;
		protected int 		cols;
		protected Tile[][] 	map;
		public Tile		Current {

			get;
			private set;
		}

		object IEnumerator.Current
		{
			get { return Current; }
		}

		//protected Tile[][] 	map;

		//Static Methods
		
		public Grid( int rows, int cols) {
			
			
			if( rows <= 0 || cols <= 0)
				throw new ArgumentException( "Exception: Invalid number of rows or cols (02)");
				//throw new RuntimeException( "Exception: Invalid number of rows or cols (02)");
			
			this.rows = rows;
			this.cols = cols;
			map = new Tile[rows][];
			for (int i = 0; i < rows; i++)
				map [i] = new Tile[cols];

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

		public Tile getTile( Tile center, int[] direction) {
		//public Tile getTile( Tile base, int[] direction) {

			return getTile( center.row + direction[0], center.col + direction[1]);
			//return getTile( base.row + direction[0], base.col + direction[1]);
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
			
			IEnumerator<Tile> it = GetEnumerator();
			while( it.MoveNext())
				it.Current.setState(key, state);
		}

		//public void set( String key, Object object) {
		public void set( String key, Object obj) {
			
			IEnumerator<Tile> it = GetEnumerator();
			while( it.MoveNext())
				it.Current.set(key, obj);
		}
		
		public void setState( Tile tile, String name, int state) {
			
			tile.setState( name, state);
		}
		
		public void setState( int row, int col, String key, int state) {
			
			getTile( row, col).setState( key, state);
		}
		
		public void set( Tile tile, String key, Object obj) {
			
			tile.set(key, obj);
		}
		
		public void set( int row, int col, String key, Object obj) {
			
			getTile(row, col).set(key, obj);
		}
		
		//C.3 - Other Methods
		public bool isIn( Tile tile) {
			
			return isIn( tile.row, tile.col);
		}
		
		public bool isIn( int row, int col) {
			
			return row >= 0 && col >= 00 && row < this.rows && col < this.cols; 
		}
		
		public void addState( Tile tile, String name, int state ) {
			
			setState( tile, name, state);
		}
		
		public void addState( int row, int col, String name, int state) {
			
			setState( row, col, name, state);
		}
		
		public virtual Area getAdjacentTiles( Tile tile) {
			
			return getAdjacentTiles( tile.row, tile.col);
		}
		
		public virtual Area getAdjacentTiles( int row, int col) {
			
			if( !isIn(row, col))
				throw new ArgumentException( "Exception: Invalid number of rows or cols (02)");
			
			Area areaToReturn = new Area();
			
			for( int i = 0; i < direction.Length; i++) {
				
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
			for( int i = 0; i < direction.Length; i++) {
				
				for( int j = 1; j < radius; j++) {
					
					tileOnLine = getTile( row + j * direction[i][0], col + j * direction[i][1]);
					area.addTile( tileOnLine);
					rowOnLine = tileOnLine.row;
					colOnLine = tileOnLine.col;
					
					for( int k = 1; k < j; k++) {
						
						area.addTile( getTile( rowOnLine + k * direction[ ( i + 2) % direction.Length][0],
						                      colOnLine + k * direction[ ( i + 2) % direction.Length][1]));
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
			for( int i = 0; i < direction.Length; i++) {
				
				for( int j = radiusStart; j < radiusEnd; j++) {
					
					tileOnLine = getTile( row + j * direction[i][0], col + j * direction[i][1]);
					area.addTile( tileOnLine);
					rowOnLine = tileOnLine.row;
					colOnLine = tileOnLine.col;
					
					for( int k = 1; k < j; k++) {
						
						area.addTile( getTile( rowOnLine + k * direction[ ( i + 2) % direction.Length][0],
						                      colOnLine + k * direction[ ( i + 2) % direction.Length][1]));
					}
				}
			}
			
			return area;
		}
		
		public Area getRange( int row, int col, int radiusStart, int radiusEnd) {
			
			return getRange( getTile(row, col), radiusStart, radiusEnd);
		}
		
		public Area getLine( Tile center, int[] direction) {
			
			Area areaToReturn = new Area();
			Tile tileToAdd = center;
			while (isIn( tileToAdd)) {

				areaToReturn.addTile( tileToAdd);
				tileToAdd = getTile( tileToAdd.row + direction[0],
				                     tileToAdd.col + direction[1]);
			}

			return areaToReturn;
		}

		public Area getLine( int row, int col, int[] direction) {
			
			return getLine( getTile( row, col), direction);
		}

		public Area getLine( Tile center, int[] direction, int length) {
			
			Area areaToReturn = new Area();
			for( int i = 0; i < length; i++) {
				
				Tile tileToAdd = getTile( center.row + i * direction[0], center.col + i * direction[1]);
				
				if( isIn( tileToAdd))
					areaToReturn.addTile( tileToAdd);
			}
			
			return areaToReturn;
		}
		
		public Area getLine( int row, int col, int[] direction, int length) {
			
			return getLine( getTile( row, col), direction, length);
		}
		
		public Area getLine( Tile center, int[] direction, int startPoint, int endPoint) {
			
			Area areaToReturn = new Area();
			for( int i = startPoint; i < endPoint; i++) {
				
				Tile tileToAdd = getTile( center.row + i * direction[0], center.col + i * direction[1]);
				if( isIn( tileToAdd))
					areaToReturn.addTile( tileToAdd);
			}
			
			return areaToReturn;

		}
		
		public Area getLine( int row, int col, int[] direction, int startPoint, int endPoint) {
			
			return getLine( getTile( row, col), direction, startPoint, endPoint);
		}
		
		public Tile getRandomTile() {

			Random rng = new Random ();
			int rand = rng.Next ( rows * cols);
			//int rand = (int) (Math.random() * rows * cols);
			return getTile( rand / cols, rand & cols);
		}
		
		public Area getRandomTiles() {

			Random rng = new Random ();
			int rand = rng.Next ( rows * cols);
			return getRandomTiles (rand + 1);
			//return getRandomTiles( ((int)Math.random() * rows * cols) + 1);
		}
		
		public Area getRandomTiles( int number) {
			int n = rows * cols;
			if( number > n)
				throw new ArgumentException( "number of random numbers is greater than total number of tiles.");

			Random rng = new Random ();

			int[] arr = new int[ n];
			int r;
			Area areaToReturn = new Area();
			
			for( int i = 0; i < n; i++)
				arr[i] = i;
			
			for( int i = 0; i < number; i++) {

				r = rng.Next( n);
				//r = (int)(Math.random() * n);
				areaToReturn.addTile( getTile( arr[r] / cols, arr[r] % cols));
				arr[r] = arr[ n - 1];
				n--;
			}
			
			return areaToReturn;
		}
		
		public Area find( String key, int state) {
			
			Area areaToReturn = new Area();
			IEnumerator<Tile> it = GetEnumerator();
			while( it.MoveNext()) {
				
				Tile tile = it.Current;
				if( tile.getState( key) == state)
					areaToReturn.addTile( tile);
			}
			
			return areaToReturn;
		}
		
		public Area find( String key, Object obj) {
			
			Area areaToReturn = new Area();
			IEnumerator<Tile> it = GetEnumerator();
			while( it.MoveNext()) {
				
				Tile tile = it.Current;
				if( tile.get( key) == obj)
					areaToReturn.addTile( tile);
			}
			
			return areaToReturn;
		}
		
		//Iterator methods
		public IEnumerator<Tile> GetEnumerator() {
			
			currentIndex = 0;
			if (rows > 0 && cols > 0)
				Current = map [0] [0];
			else
				Current = null;
			return this;
		}

		public void Reset() {

			currentIndex = 0;
			if (rows > 0 && cols > 0)
				Current = map [0] [0];
			else
				Current = null;
		}

		public bool MoveNext() {
			
			if (currentIndex < rows * cols) {

				currentIndex++;
				Current = map[ ( currentIndex - 1) / cols][ ( currentIndex - 1) % cols];
				return true;
			}
			
			return false;
		}

		System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
		{
			return this.GetEnumerator();
		}

		void IDisposable.Dispose() { }
	}
}
