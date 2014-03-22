package board;

/**
 * Board class for general use in board based games.
 * For more information, visit Github page:
 * https://github.com/Shathra/board
 * 
 * @author Selcuk Gulcan
 * @version 2.0
 */

public class Board {
	
	//Constants
	
	//Direction Arrays
	//TODO: Check direction arrays
	public final static int[][] DIR4 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public final static int[][] DIR6_EVEN = {{-2,0}, {-1,1}, {1,1}, {2,0}, {1,0}, {-1,0}};
	public final static int[][] DIR6_ODD = {{-2,0}, {-1,0}, {1,0}, {2,0}, {1,-1}, {-1,-1}};
	public final static int[][] DIR3_EVEN = {{0, 1}, {1, 0}, {0, -1}};
	public final static int[][] DIR3_ODD = {{-1, 0}, {0, 1}, {0, -1}};
	
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
}