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

		public GridQuad ( int row, int col) : base( row, col) {

			direction = DIR;
		}

		//Methods
	}
}
