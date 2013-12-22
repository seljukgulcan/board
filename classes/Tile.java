import java.util.ArrayList;
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
	
	public int row;
	public int col;
	
	protected int[] 		states;
	protected int			noStates;
	protected Properties 	info;
	protected ArrayList<Placeable>		objects;
	
	//B - Constructors
	public Tile( int row, int col) {
		
		this.row = row;
		this.col = col;
		noStates = 0;
		states = null;
		info = null;
	}
	
	public Tile( int row, int col, int state) {
		
		this.row = row;
		this.col = col;
		noStates = 1;
		states = new int[1];
		states[0] = state;
		info = null;
	}
	
	public Tile( int row, int col, int[] states) {
		
		this.row = row;
		this.col = col;
		noStates = states.length;
		this.states = states;
		info = null;
	}
	
	public Tile( int row, int col, int state, Properties info) {
		
		this( row, col, state);
		this.info = info;
	}
	
	public Tile( int row, int col, int[] states, Properties prop) {
		
		this( row, col, states);
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
		}
		
		else {
			
			int[] temp = new int[ noStates];
			for( int i = 0; i < noStates; i++)
				temp[i] = states[i];
			
			states = new int[ noStates + INCREMENT];
			
			for( int i = 0; i < noStates; i++)
				states[i] = temp[i];
		}
		
		states[ noStates] = state;
		noStates++;
	}
}
