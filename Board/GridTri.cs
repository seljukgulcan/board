using System;
namespace Board
{
	public class GridTri : Grid	{

		//Properties
		public static readonly int[][] DIRECTION_EVEN = new int[3][] {
			new int[2]{0, 1},
			new int[2]{1, 0},
			new int[2]{0, -1}
		};

		public static readonly int[][] DIRECTION_ODD = new int[3][] {
			new int[2]{-1, 0},
			new int[2]{0, 1},
			new int[2]{0, -1}
		};
		
		//Constructors
		public GridTri ( int row, int col) : base( row, col) {}

		//Methods
		public override Area getAdjacentTiles( int row, int col) {
			
			if( !isIn(row, col))
				throw new ArgumentException( "Exception: Invalid number of rows or cols (02)");
			
			Area areaToReturn = new Area();
			int[][] traverseArr = null;
			
			if( col % 2 == 0)
				traverseArr = DIRECTION_EVEN;
			
			else
				traverseArr = DIRECTION_ODD;
			
			for( int i = 0; i < traverseArr.Length; i++) {
				
				Tile tileToAdd = getTile( row + traverseArr[i][0], col + traverseArr[i][1]);
				if( tileToAdd != null)
					areaToReturn.addTile( tileToAdd);
			}
			
			return areaToReturn;
		}
	}
}
