package board;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Tile class represents a single piece in the board.
 * Holds 2 type of data:
 *  - States (int value to show state of the tile).
 *  - Objects (Any object).
 * 
 * @author Selcuk Gulcan
 * @version 2.0
 */

public class Tile {

	//A - Properties
	
	/**
	 * location in the grid.
	 */
	public int row;
	/**
	 * location in the grid.
	 */
	public int col;
	
	protected Hashtable<String, Integer>	states;
	protected Hashtable<String, Object>		objects;
	
	//B - Constructors
	/**
	 * @param row location in the grid.
	 * @param col location in the grid.
	 */
	public Tile( int row, int col) {
		
		this.row = row;
		this.col = col;
		states = null;
		objects = null;
	}
	
	/**
	 * 
	 * @param row location in the grid.
	 * @param col location in the grid.
	 * @param key key for the initial state
	 * @param initialState initial state.
	 */
	public Tile( int row, int col, String key, int initialState) {
		
		this.row = row;
		this.col = col;
		states = new Hashtable<String, Integer>( 5);
		states.put(key, initialState);
		objects = null;
	}
	
	//C - Methods
	//C.1 - Get Methods
	/**
	 * Returns the state of the tile.
	 * 
	 * @param key
	 * @return state of the tile with given key.
	 * @exception NullPointerException if there is no state with key.
	 */
	public int getState( String key) {
		
		if( states == null)
			throw new NullPointerException();
		
		if( states.get(key) == null)
			throw new NullPointerException();
		
		return states.get(key);
	}
	
	/**
	 * Returns all states of the tile.
	 * 
	 * @return array of integers or null if states have not initialized yet.
	 */
	public int[] getAllStates() {
		
		if( states == null)
			return null;
		
		int[] arr = new int[states.size()];
		Iterator<Integer> it = states.values().iterator();
		for( int i = 0; it.hasNext(); i++)
			arr[i] = it.next();
		
		return arr;
	}
	
	/**
	 * Returns the object with given key.
	 * 
	 * @param key
	 * @return object or null if there is no match with key.
	 */
	public Object get( String key) {
		
		if( objects == null)
			return null;
		
		return objects.get( key);
	}
	
	/**
	 * Returns the number of states.
	 * 
	 * @return
	 */
	public int noStates() {
		
		if( states == null)
			return 0;
		
		return states.size();
	}
	
	/**
	 * Returns the number of objects the tile holds.
	 * 
	 * @return
	 */
	public int noObjects() {
		
		if( objects == null)
			return 0;
		
		return objects.size();
	}
	
	//C.2 - Set Methods
	/**
	 * Sets state. It may add a new state or change previous state.
	 * 
	 * @param key
	 * @param state
	 */
	public void setState( String key, int state) {
		
		if( states == null)
			states = new Hashtable<String, Integer>( 5);
		
		states.put(key, state);
	}
	
	/**
	 * Sets object. It may add a new object or change previous object.
	 * 
	 * @param key
	 * @param object
	 */
	public void set( String key, Object object) {
		
		if( objects == null)
			objects = new Hashtable<String, Object>( 5);
		
		objects.put(key, object);
	}
}
