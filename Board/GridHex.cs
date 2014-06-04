using System;
namespace Board
{
	public class GridHex : Grid
	{

		//Properties
		public static readonly int[][] DIR = new int[6][]{
			new int[2]{-1, 0},
			new int[2]{-1, 1},
			new int[2]{0, 1},
			new int[2]{1, 0},
			new int[2]{1, -1},
			new int[2]{0, -1}
		};

		public GridHex ( int row, int col) : base(row, col) {

			direction = DIR;
		}

		//Methods
	}
}
