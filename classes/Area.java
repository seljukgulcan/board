import java.util.Iterator;

/**
 * Area class contains bunch of tile objects.
 * 
 * @author Selçuk Gülcan
 * @version 1
 */

public class Area implements Iterator<Tile>, Iterable<Tile> {

	//A - Properties
	private final int INCREMENT = 1;
	private int current = 0; //For implementation of iterator.
	
	protected Tile[] area;
	protected int size;
	
	//B - Constructors
	public Area() {
		
		area = null;
		size = 0;
	}
	
	public Area( Area other) {
		
		//TODO complete method.
		this();
	}
	
	//C - Methods
	public void addTile( Tile tile) {
		
		if( size == 0) {
			
			area = new Tile[1];
		}
		
		else {
			
			Tile[] temp = new Tile[ size];
			for( int i = 0; i < size; i++)
				temp[i] = area[i];
			
			area = new Tile[ size + INCREMENT];
			
			for( int i = 0; i < size; i++)
				area[i] = temp[i];
		}
		
		area[ size] = tile;
		size++;
	}
	
	public boolean removeTile( int index) {
		
		//NOTE: Array size is not modified.
		
		if( index < 0 || index >= size)
			return false;
		
		for( int i = index; i < size - 1; i++)
			area[i] = area[ i + 1];
		
		return true;
	}

	//TODO: Exceptions should be added.
	@Override
	public Iterator<Tile> iterator() {
		
		current = 0;
		return this;
	}

	@Override
	public boolean hasNext() {
		
		if( current < size)
			return true;
		
		return false;
	}

	@Override
	public Tile next() {
		
		current++;
		return area[ current - 1];
	}

	@Override
	public void remove() {
		
		removeTile( current);
	}
}
