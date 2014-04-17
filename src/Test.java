import board.*;

public class Test {

	public static void main( String args[]) {
		
		Grid board = new GridHex( 8, 8);
		printGridHex(board);
		
		System.out.println();
		System.out.println( "board.getAdjacentTiles( 4, 4)");
		board.getAdjacentTiles( 4, 4).showTiles();
		
		System.out.println();
		System.out.println( "board.getLine( 4, 4, Board.DIR6[4], 3)");
		board.getLine( 4, 4, Board.DIR6[4], 3).showTiles();
		
		System.out.println();
		System.out.println( "board.getRange( 4, 4, 3).showTiles()");
		board.getRange( 4, 4, 3).showTiles();
		
		Grid board2 = new GridQuad( 8, 8);
		printGridQuad(board2);
		
		System.out.println();
		System.out.println( "board2.getAdjacentTiles( 4, 4)");
		board2.getAdjacentTiles( 4, 4).showTiles();
		
		System.out.println();
		System.out.println( "board2.getLine( 4, 4, Board.DIR4[0], 3)");
		board.getLine( 4, 4, Board.DIR4[0], 3).showTiles();
	}
	
	public static void printGridHex( Grid board) {
		
		String gap = "   ";
		
		for( int i = 0; i < board.getRows(); i++) {
			
			for( int j = 0; j < board.getCols(); j++) {
				
				System.out.print( board.getTile( i, j).row + "," + 
						board.getTile( i, j).col + gap);
			}
			System.out.println( "\n");
			printTimes( gap, i+ 1);
		}
	}
	
	public static void printGridQuad( Grid board) {
		
		for( int i = 0; i < board.getRows(); i++) {
			
			for( int j = 0; j < board.getCols(); j++) {
				
				System.out.print( board.getTile( i, j).row + "," + 
						board.getTile( i, j).col + "\t");
			}
			System.out.println( "\n");
		}
	}
	
	public static void printTimes( String value, int times) {
		
		for( int i = 0; i < times; i++)
			System.out.print( value);
	}
}
