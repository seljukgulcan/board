/**
 * Area class contains a bunch of tile objects.
 * 
 * @author Selcuk Gulcan
 * @version 2.0
 */

using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.Generic.List;

namespace Board
{
	public class Area : IEnumerable<Tile>
	{
		//A - Properties
		protected List<Tile> area;
		
		//B - Constructors
		public Area() {
			
			area = new List<Tile>();
		}

		public Area( Area other) {
			
			area = new List<Tile>();
			
			IEnumerator<Tile> it = other.GetEnumerator();
			while( it.MoveNext())
				area.Add( it.Current);
		}

		//C - Methods
		public void addTile( Tile tile) {
			
			area.Add( tile);
		}
		
		public void removeTile( int index) {
			
			area.RemoveAt( index);
		}
		
		public int size() {
			
			if( area != null)
				return area.Count;
			
			return 0;
		}
		
		public Tile getRandomTile() {

			Random rng = new Random ();
			int r = rng.Next( area.Count);
			return area[r];
		}
		
		public Area getRandomTiles() {

			Random rng = new Random ();
			return getRandomTiles( rng.Next ( 1, area.Count + 1));
			//return getRandomTiles( ((int)Math.random() * area.size()) + 1);
		}

		/*
		 * TODO: Codes above needs a check and correction, especially it is needed to add
		 * 
		 * original codes under c-sharp codes.
		 */

		public Area getRandomTiles( int number) {

			Random rng = new Random ();

			int n = size();
			//TODO: Exception should be translated into c-sharp
			if (number > n)
				throw new ArgumentException ( "number of random numbers is greater than total number of tiles.");
				//throw new RuntimeException( "number of random numbers is greater than total number of tiles.");
			
			int[] arr = new int[ n];
			int r;
			Area areaToReturn = new Area();
			
			for( int i = 0; i < n; i++)
				arr[i] = i;
			for( int i = 0; i < number; i++) {

				r = rng.Next( n);
				//r = (int)(Math.random() * n);
				areaToReturn.addTile( getTile( arr[r]));
				arr[r] = arr[ n - 1];
				n--;
			}
			return areaToReturn;
		}
		
		public Tile getTile(int index) {

			return area[ index];
			//return area.get(index);
		}
		
		public Area find( String key, int state) {
			
			Area areaToReturn = new Area();
			IEnumerator<Tile> it = GetEnumerator();
			//Iterator<Tile> it = iterator();
			while( it.MoveNext()) {
			//while( it.hasNext()) {
				
				Tile tile = it.Current;
				//Tile tile = it.next();
				if( tile.getState(key) == state)
					areaToReturn.addTile(tile);
			}
			return areaToReturn;
		}

		public Area find( string key, Object obj) {
		//public Area find( String key, Object object) {
			
			Area areaToReturn = new Area();
			IEnumerator<Tile> it = GetEnumerator();
			//Iterator<Tile> it = iterator();
			while( it.MoveNext()) {
			//while( it.hasNext()) {
				
				Tile tile = it.Current;
				//Tile tile = it.next();
				if( tile.get(key) == obj)
				//if( tile.get(key) == object)
					areaToReturn.addTile(tile);
			}
			return areaToReturn;
		}

		public void setState( string key, int state) {
		//public void setState( String key, int state) {

			IEnumerator<Tile> it = GetEnumerator();
			//Iterator<Tile> it = iterator();
			while( it.MoveNext())
			//while( it.hasNext())
				it.Current.setState(key, state);
				//it.next().setState(key, state);
		}
		
		//@Override
		public IEnumerator<Tile> GetEnumerator() {
		//public Iterator<Tile> iterator() {
			
			return area.GetEnumerator();
			//return area.iterator();
		}
		
		public void showTiles() {
			
			//TODO: This is just a test function
			IEnumerator<Tile> it = GetEnumerator();
			//Iterator<Tile> it = iterator();
			Console.WriteLine (area.Count);
			while( it.MoveNext()) {
				Tile temp = it.Current;
				Console.Write( "{0},{1}\t", temp.row, temp.col);
			}
			Console.WriteLine ();

			/*
			System.out.println( area.size());
			while( it.hasNext()) {
				Tile temp = it.next();
				System.out.print( temp.row + "," + temp.col + "\t");
			}
			System.out.println();
			 */
		}
	}
}

