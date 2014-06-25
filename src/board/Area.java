package board;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Contains bunch of tile objects.
 * 
 * Area objects includes tile objects chosen from grid objects.
 * 
 * @author Selcuk Gulcan
 * @version 2.0
 */

public class Area implements Iterable<Tile> {

	//A - Properties
	protected ArrayList<Tile> area;
	
	//B - Constructors
	/**
	 * Default constructor. Creates an empty Area object.
	 */
	public Area() {
		
		area = new ArrayList<Tile>();
	}
	
	/**
	 * Creates a copy Area object.
	 * 
	 * @param other reference to the object which would be copied.
	 */
	public Area( Area other) {
		
		area = new ArrayList<Tile>();
		
		Iterator<Tile> it = other.iterator();
		while( it.hasNext())
			area.add( it.next());
	}
	
	//C - Methods
	/**
	 * Adds a tile.
	 * 
	 * @param tile Tile to be added.
	 */
	public void addTile( Tile tile) {
		
		area.add( tile);
	}
	
	/**
	 * Removes a tile at specific index.
	 * 
	 * index numbers are given to tile objects in order of adding them into area objects.
	 * 
	 * @param index index of tile to be removed.
	 * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	public void removeTile( int index) {
		
		area.remove(index);
	}
	
	/**
	 * Return number of tile objects the Area has.
	 * 
	 * @return number of tile objects the Area has.
	 * @see Tile
	 */
	public int size() {
		
		if( area != null)
			return area.size();
		
		return 0;
	}
	
	/**
	 * Gives a random Tile objects in the Area.
	 * 
	 * Uses Math.random method when getting a random Tile.
	 * 
	 * @return Tile object chosen randomly.
	 * @see Tile
	 * @exception IndexOutOfBoundsException if the area is empty ( size() == 0)
	 */
	public Tile getRandomTile() {
		
		int r = (int)( Math.random() * area.size());
		return area.get( r);
	}
	
	/**
	 * Works just like getRandomTiles(double, double) except the number of random tiles is always 
	 * presumed to be size(). 
	 *
	 * @see #getRandomTiles( int)
	 */
	public Area getRandomTiles() {
		
		return getRandomTiles( ((int)Math.random() * area.size()) + 1);
	}
	
	/**
	 * Returns Area with some Tile objects chosen randomly.
	 * 
	 * @param number the number of Tile objects that would be returned.
	 * @return Area object with random Tile objects.
	 * @exception RuntimeException if user requests more tiles than area has ( number > size())
	 */
	public Area getRandomTiles( int number) {
		
		int n = size();
		if( number > n)
			throw new RuntimeException( "number of random numbers is greater than total number of tiles.");
		
		int[] arr = new int[ n];
		int r;
		Area areaToReturn = new Area();
		
		for( int i = 0; i < n; i++)
			arr[i] = i;
		for( int i = 0; i < number; i++) {
			
			r = (int)(Math.random() * n);
			areaToReturn.addTile( getTile( arr[r]));
			arr[r] = arr[ n - 1];
			n--;
		}
		return areaToReturn;
	}
	
	/**
	 * Returns Tile objects at given index.
	 * 
	 * @param index Location of the Tile object.
	 * @return Tile
	 * @exception IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	public Tile getTile(int index) {
		
		return area.get(index);
	}

	/**
	 * Search for tiles whose keys equal to a particular state.
	 * 
	 * @param key The name of the key.
	 * @param state 
	 * @return Area whose tiles suit for given condition.
	 */
	public Area find( String key, int state) {
		
		Area areaToReturn = new Area();
		Iterator<Tile> it = iterator();
		while( it.hasNext()) {
			
			Tile tile = it.next();
			if( tile.getState(key) == state)
				areaToReturn.addTile(tile);
		}
		return areaToReturn;
	}
	
	/**
	 * Works just like find(key, state) except state is an object here. 
	 *
	 * @see #find( String, int)
	 */
	public Area find( String key, Object object) {
		
		Area areaToReturn = new Area();
		Iterator<Tile> it = iterator();
		while( it.hasNext()) {
			
			Tile tile = it.next();
			if( tile.get(key) == object)
				areaToReturn.addTile(tile);
		}
		return areaToReturn;
	}
	
	/**
	 * Set state with a key.
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
	 * Iterator method for Area class.
	 * 
	 * @return
	 */
	@Override
	public Iterator<Tile> iterator() {
		
		return area.iterator();
	}

	public void showTiles() {
		
		//TODO: This is just a test function
		Iterator<Tile> it = iterator();
		System.out.println( area.size());
		while( it.hasNext()) {
			Tile temp = it.next();
			System.out.print( temp.row + "," + temp.col + "\t");
		}
		System.out.println();
	}
}
