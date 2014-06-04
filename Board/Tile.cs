/**
 * Tile class represents a single piece in the board.
 * Holds 2 type of data:
 *  - States (int value to show state of the tile).
 *  - Objects (Any object).
 * 
 * @author Selcuk Gulcan
 * @version 2.0
 */

using System;
using System.Collections;
using System.Collections.Generic;

namespace Board
{
	public class Tile
	{
		//A - Properties
		
		public int row;
		public int col;
		
		protected Hashtable		states;
		//protected Hashtable<String, Integer>	states;
		protected Hashtable		objects;
		//protected Hashtable<String, Object>	objects;

		public Tile ( int row, int col)	{

			this.row = row;
			this.col = col;
			states = null;
			objects = null;
		}

		public Tile( int row, int col, string key, int initialState) {
		//public Tile( int row, int col, String key, int initialState) {
			
			this.row = row;
			this.col = col;
			states = new Hashtable();
			//states = new Hashtable<String, Integer>( 5);
			states.Add(key, initialState);
			//states.put(key, initialState);
			objects = null;
		}

		//C - Methods
		//C.1 - Get Methods
		public int getState( string key) {
		//public int getState( String key) {

			//TODO: Exception
			if (states == null)
				throw new ArgumentNullException ();
				//throw new NullPointerException();
			
			if( !states.ContainsKey(key))
				throw new ArgumentNullException ();
				//throw new NullPointerException();

			return (int)states[key];
			//return states.get(key);
		}

		public int[] getAllStates() {
			
			int[] arr = new int[states.Count];
			//int[] arr = new int[states.size()];
			IEnumerator<int> it;
			it = (IEnumerator<int>)states.Values.GetEnumerator();
			//Iterator<Integer> it = states.values().iterator();
			for( int i = 0; it.MoveNext(); i++)
			//for( int i = 0; it.hasNext(); i++)
				arr[i] = it.Current;
				//arr[i] = it.next();
			
			return arr;
		}

		public Object get( string key) {
		//public Object get( String key) {
			
			if( objects == null)
				return null;

			return objects[ key];
			//return objects.get( key);
		}
		
		
		public int noStates() {
			
			if( states == null)
				return 0;

			return states.Count;
			//return states.size();
		}
		
		public int noObjects() {
			
			if( objects == null)
				return 0;

			return objects.Count;
			//return objects.size();
		}
		
		//C.2 - Set Methods
		public void setState( String key, int state) {
			
			if( states == null)
				states = new Hashtable();
				//states = new Hashtable<String, Integer>( 5);
			
			states.Add(key, state);
			//states.put(key, state);
		}

		public void set( String key, Object obj) {
		//public void set( String key, Object object) {
			
			if( objects == null)
				objects = new Hashtable();
				//objects = new Hashtable<String, Object>( 5);
			
			//objects.put(key, object);
			objects.Add(key, obj);
		}
	}
}
