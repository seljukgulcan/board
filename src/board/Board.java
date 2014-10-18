package board;

/**
 * Fundamental class of the board package, has some static properties and methods for creating grids and using those grids.
 * 
 * For more information, visit Github page:
 * https://github.com/Shathra/board
 * 
 * @author Selcuk Gulcan
 * @version 2.0
 */

public abstract class Board {
	
	//Constants
	
	//Direction Arrays
	/**
	 * Direction array for quadratic grids. Starts with UP direction and continues clockwise.
	 */
	public final static int[][] DIR4 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	/**
	 * Direction array for hexagonal grids.
	 */
	public final static int[][] DIR6 = {{-1, 0}, {-1, 1}, {0, 1}, {1, 0}, {1, -1}, {0, -1}};
	public final static int[][] DIR3_EVEN = {{0, 1}, {1, 0}, {0, -1}};
	public final static int[][] DIR3_ODD = {{-1, 0}, {0, 1}, {0, -1}};
	
	//Static Methods
	/**
	 * creates a quadratic grid with given rows and cols values.
	 * 
	 * @param rows number of rows grid has
	 * @param cols number of columns grid has
	 * @return a quadratic grid with given rows and columns values.
	 */
	public static GridQuad createGridQuad( int rows, int cols) {
		
		return new GridQuad( rows, cols);
	}

	/**
	 * creates a triangular grid with given rows and columns values.
	 * 
	 * @param rows number of rows grid has
	 * @param cols number of columns grid has
	 * @return a triangular grid with given rows and columns values.
	 */
	public static GridTri createGridTri( int rows, int cols) {
		
		return new GridTri( rows, cols);
	}
	
	/**
	 * creates a hexagonal grid with given rows and columns values.
	 * 
	 * @param rows number of rows grid has
	 * @param cols number of columns grid has
	 * @return a hexagonal grid with given rows and columns values.
	 */
	public static GridHex createGridHex( int rows, int cols) {
		
		return new GridHex( rows, cols);
	}
	
	public static void openConsole() {
		
		//TODO: Fill the method
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