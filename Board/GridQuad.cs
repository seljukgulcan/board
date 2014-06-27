using System;
namespace Board
{
	public class GridQuad : Grid
	{
		//Properties
		public static readonly int[][] DIR = new int[4][] {
			new int[2]{-1, 0},
			new int[2]{0, 1},
			new int[2]{1, 0},
			new int[2]{0, -1}
		};

		public static readonly int[] UP = DIR[0];
		public static readonly int[] RIGHT = DIR[1];
		public static readonly int[] DOWN = DIR[2];
		public static readonly int[] LEFT = DIR[3];

		public static readonly int[][] DIAGONAL_DIR = new int[4][] {

			new int[2] {-1, 1},
			new int[2] {1, 1},
			new int[2] {1, -1},
			new int[2] {-1, -1}
		};
		public static readonly int[] RIGHT_UP = DIAGONAL_DIR[0];
		public static readonly int[] RIGHT_DOWN = DIAGONAL_DIR[1];
		public static readonly int[] LEFT_DOWN = DIAGONAL_DIR[2];
		public static readonly int[] LEFT_UP = DIAGONAL_DIR[3];

		public GridQuad ( int row, int col) : base( row, col) {

			direction = DIR;
		}

		//Methods

		public int[][] getStateMap( string state) {
			
			int[][] map = new int[rows][];
			
			for (int i = 0; i < rows; i++) {

				map[rows] = new int[cols];
				for (int j = 0; j < cols; j++)
					map[i][j] = this.map[i][j].getState( state);
			}
			
			return map;
		}
	}
}
