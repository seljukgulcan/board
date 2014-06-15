package board;

public class GridQuad extends Grid {

	//Properties
	public final static int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public final static int[] UP = DIR[0];
	public final static int[] RIGHT = DIR[1];
	public final static int[] DOWN = DIR[2];
	public final static int[] LEFT = DIR[3];
	
	public final static int[][] DIAGONAL_DIR = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
	public final static int[] RIGHT_UP = DIR[0];
	public final static int[] RIGHT_DOWN = DIR[1];
	public final static int[] LEFT_DOWN = DIR[2];
	public final static int[] LEFT_UP = DIR[3];
	
	//Constructors
	public GridQuad( int row, int col) {
		
		super( row, col);
		direction = DIR;
	}
	
	public int[][] getStateMap( String state) {
		
		int[][] map = new int[rows][cols];
		
		for( int i = 0; i < rows; i++)
			for( int j = 0; j < cols; j++)
				map[i][j] = this.map[i][j].getState( state);
		
		return map;
	}
	
	//Methods
}
