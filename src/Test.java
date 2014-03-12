import board.*;

public class Test {

	public static void main( String args[]) {
		
		Board board = Board.createHexBoard( 9, 4);
		board.getAdjacentTiles( 3, 3).showTiles();
	}
}
