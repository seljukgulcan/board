package board;

public class GridTri extends Grid {

	//Properties
	public final static int[][] DIR_EVEN = {{0, 1}, {1, 0}, {0, -1}};
	public final static int[][] DIR_ODD = {{-1, 0}, {0, 1}, {0, -1}};
	
	//Constructors
	public GridTri( int row, int col) {
		
		super( row, col);
	}
	
	//Methods
	@Override
	public Area getAdjacentTiles( int row, int col) {
		
		if( !isIn(row, col))
			throw new RuntimeException( "Exception: Invalid number of rows or cols (02)");
		
		Area areaToReturn = new Area();
		int[][] traverseArr = null;
		
		if( col % 2 == 0)
			traverseArr = DIR_EVEN;
	
		else
			traverseArr = DIR_ODD;
		
		for( int i = 0; i < traverseArr.length; i++) {

			Tile tileToAdd = getTile( row + traverseArr[i][0], col + traverseArr[i][1]);
			if( tileToAdd != null)
				areaToReturn.addTile( tileToAdd);
		}
		
		return areaToReturn;
	}
}
