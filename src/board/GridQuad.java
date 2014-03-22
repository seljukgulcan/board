package board;

public class GridQuad extends Grid {

	//Properties
	public final static int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public final static int[] UP = DIR[0];
	public final static int[] RIGHT = DIR[1];
	public final static int[] DOWN = DIR[2];
	public final static int[] LEFT = DIR[3];
	
	//Constructors
	public GridQuad( int row, int col) {
		
		super( row, col);
		direction = DIR;
	}
	
	//Methods
}
