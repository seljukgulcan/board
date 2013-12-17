import java.util.Properties;

/**
 * Tile class represents a single piece in the board.
 * 
 * @author Selçuk Gülcan
 * @version 1
 */

public class Tile {

	//A - Properties
	protected int[] 		states;
	protected int			noStates;
	protected Properties 	info;
	
	//B - Constructors
	public Tile() {
		
		noStates = 0;
		states = null;
		info = null;
	}
	
	public Tile( int state) {
		
		noStates = 1;
		states = new int[1];
		states[0] = state;
		info = null;
	}
	
	public Tile( int[] states) {
		
		noStates = states.length;
		this.states = states;
		info = null;
	}
	
	public Tile( int state, Properties info) {
		
		this( state);
		this.info = info;
	}
	
	public Tile( int[] states, Properties prop) {
		
		this( states);
		this.info = prop;
	}
	
	//C - Methods
	//C.1 - Get Methods
	public int getState( int index) {
		
		return states[index];
	}
	
	public int[] getAllStates() {
		
		return states;
	}
}
