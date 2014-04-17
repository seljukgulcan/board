package board;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Area class contains bunch of tile objects.
 * 
 * @author Selcuk Gulcan
 * @version 2.0
 */

public class Area implements Iterable<Tile> {

	//A - Properties
	protected ArrayList<Tile> area;
	
	//B - Constructors
	public Area() {
		
		area = new ArrayList<Tile>();
	}
	
	public Area( Area other) {
		
		area = new ArrayList<Tile>();
		
		Iterator<Tile> it = other.iterator();
		while( it.hasNext())
			area.add( it.next());
	}
	
	//C - Methods
	public void addTile( Tile tile) {
		
		area.add( tile);
	}
	
	public void removeTile( int index) {
		
		area.remove(index);
	}
	
	public int size() {
		
		if( area != null)
			return area.size();
		
		return 0;
	}
	
	public Tile getRandomTile() {
		
		int r = (int)( Math.random() * area.size());
		return area.get( r);
	}
	
	public Area getRandomTiles() {
		
		return getRandomTiles( ((int)Math.random() * area.size()) + 1);
	}
	
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
	
	public Tile getTile(int index) {
		
		return area.get(index);
	}

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
	
	public void setState( String key, int state) {
		
		Iterator<Tile> it = iterator();
		while( it.hasNext())
			it.next().setState(key, state);
	}

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
