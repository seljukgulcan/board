package board;

import java.util.Hashtable;

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
	
	public int row;
	public int col;
	
	protected Hashtable<String, Integer>	states;
	protected Hashtable<String, Object>		objects;
	
	//B - Constructors
	public Tile( int row, int col) {
		
		this.row = row;
		this.col = col;
		states = null;
		objects = null;
	}
	
	public Tile( int row, int col, String key, int initialState) {
		
		this.row = row;
		this.col = col;
		states = new Hashtable<String, Integer>( 5);
		states.put(key, initialState);
		objects = null;
	}
	
	//C - Methods
	//C.1 - Get Methods
	public int getState( String key) {
		
		if( states == null)
			throw new NullPointerException();
		
		if( states.get(key) == null)
			throw new NullPointerException();
		
		return states.get(key);
	}
	
	public int[] getAllStates() {
		
		//TODO: Fill the method
		return null;
	}
	
	public Object get( String key) {
		
		if( objects == null)
			return null;
		
		return objects.get( key);
	}
	
	
	public int noStates() {
		
		if( states == null)
			return 0;
		
		return states.size();
	}
	
	public int noObjects() {
		
		if( objects == null)
			return 0;
		
		return objects.size();
	}
	
	//C.2 - Set Methods
	public void setState( String key, int state) {
		
		if( states == null)
			states = new Hashtable<String, Integer>( 5);
		
		states.put(key, state);
	}
	
	public void set( String key, Object object) {
		
		if( objects == null)
			objects = new Hashtable<String, Object>( 5);
		
		objects.put(key, object);
	}
}
