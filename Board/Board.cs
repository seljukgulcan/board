/**
 * Board class for general use in board based games.
 * For more information, visit Github page:
 * https://github.com/Shathra/board
 * 
 * @author Selcuk Gulcan
 * @version 2.0
 */

using System;

namespace Board
{
	public abstract class Board
	{
		//Constants
		
		//Direction Arrays
		public static readonly int[][] DIR4 = new int[4][] {
			new int[2]{-1, 0},
			new int[2]{0, 1},
			new int[2]{1, 0},
			new int[2]{0, -1}
		};

		public static readonly int[][] DIR6 = new int[6][] {
			new int[2]{-1, 0},
			new int[2]{-1, 1}, 
			new int[2]{0, 1},
			new int[2]{1, 0},
			new int[2]{1, -1},
			new int[2]{0, -1}
		};
		public static readonly int[][] DIR3_EVEN = new int[3][] {
			new int[2]{0, 1},
			new int[2]{1, 0},
			new int[2]{0, -1}
		};

		public static readonly int[][] DIR3_ODD = new int[3][] {
			new int[2]{-1, 0},
			new int[2]{0, 1},
			new int[2]{0, -1}
		};

		//TODO: Is 'readonly' the same as 'final'?
		//public final static int[][] DIR3_ODD = {{-1, 0}, {0, 1}, {0, -1}};
		
		//Static Methods
		public static Grid createGridQuad( int rows, int cols) {
			
			return new GridQuad( rows, cols);
		}
		
		public static Grid createGridTri( int rows, int cols) {
			
			return new GridTri( rows, cols);
		}
		
		public static Grid createGridHex( int rows, int cols) {
			
			return new GridHex( rows, cols);
		}

		/*public static Grid createBasicGridQuad( int rows, int cols) {
		
			//TODO: Fill the method
			return null;
		}
		
		public static Grid createBasicGridTri( int rows, int cols) {
			
			//TODO: Fill the method
			return null;
		}
		
		public static Grid createBasicGridHex( int rows, int cols) {
			
			//TODO: Fill the method
			return null;
		}*/
	}
}
