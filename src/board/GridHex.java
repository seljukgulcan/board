package board;

public class GridHex extends Grid {

	//Properties
	public final static int[][] DIR = {{-1, 0}, {-1, 1}, {0, 1}, {1, 0}, {1, -1}, {0, -1}};
	
	//Constructors
	public GridHex( int row, int col) {
		
		super( row, col);
		direction = DIR;
	}
	
	//Methods
}
