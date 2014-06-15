package board;

/**
 * Board class for general use in board based games.
 * For more information, visit Github page:
 * https://github.com/Shathra/board
 * 
 * @author Selcuk Gulcan
 * @version 2.0
 */

public abstract class Board {
	
	//Constants
	
	//Direction Arrays
	public final static int[][] DIR4 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public final static int[][] DIR6 = {{-1, 0}, {-1, 1}, {0, 1}, {1, 0}, {1, -1}, {0, -1}};
	public final static int[][] DIR3_EVEN = {{0, 1}, {1, 0}, {0, -1}};
	public final static int[][] DIR3_ODD = {{-1, 0}, {0, 1}, {0, -1}};
	
	//Static Methods
	public static GridQuad createGridQuad( int rows, int cols) {
		
		return new GridQuad( rows, cols);
	}
	
	public static GridTri createGridTri( int rows, int cols) {
		
		return new GridTri( rows, cols);
	}
	
	public static GridHex createGridHex( int rows, int cols) {
		
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