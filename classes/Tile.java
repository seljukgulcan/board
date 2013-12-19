import java.util.Properties;

/**
 * Tile class represents a single piece in the board.
 * 
 * @author Selçuk Gülcan
 * @version 1
 */

public class Tile {

	//A - Properties
	private final int INCREMENT = 1;
	
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
	
	public int noStates() {
		
		return noStates;
	}
	
	//C.2 - Set Methods
	public boolean setState( int index, int state) {
		
		if( index < 0 || index >= noStates)
			return false;
		
		states[ index] = state;
		return true;
	}
	
	//C.2 - Other Methods
	public void addState( int state) {
		
		if( noStates == 0) {
			
			states = new int[1];
			noStates = 1;
		}
		
		else {
			
			int[] temp = new int[ noStates];
			for( int i = 0; i < noStates; i++)
				temp[i] = states[i];
			
			states = new int[ noStates + INCREMENT];
			
			for( int i = 0; i < noStates; i++)
				states[i] = temp[i];
		}
		
		states[ noStates + 1] = state;
		noStates++;
	}
}
