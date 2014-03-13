import board.*;

public class Test {

	public static void main( String args[]) {
		
		Grid board = Board.createGridHex( 9, 4);
		board.getAdjacentTiles( 3, 3).showTiles();
	}
}
