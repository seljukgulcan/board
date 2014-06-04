using System;
using Board;

namespace Test
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			Grid board = new GridHex( 8, 8);
			printGridHex(board);

			Console.WriteLine ();
			Console.WriteLine ( "board.getAdjacentTiles( 4, 4)");
			board.getAdjacentTiles( 4, 4).showTiles();
			
			Console.WriteLine ();
			Console.WriteLine( "board.getLine( 4, 4, Board.DIR6[4], 3)");
			board.getLine( 4, 4, Board.Board.DIR6[4], 3).showTiles();
			
			Console.WriteLine ();
			Console.WriteLine( "board.getRange( 4, 4, 3).showTiles()");
			board.getRange( 4, 4, 3).showTiles();
			
			Grid board2 = new GridQuad( 8, 8);
			printGridQuad(board2);
			
			Console.WriteLine ();
			Console.WriteLine( "board2.getAdjacentTiles( 4, 4)");
			board2.getAdjacentTiles( 4, 4).showTiles();

			//TODO: Issue: Board.Board !
			Console.WriteLine ();
			Console.WriteLine( "board2.getLine( 4, 4, Board.DIR4[0], 3)");
			board.getLine( 4, 4, Board.Board.DIR4[0], 3).showTiles();
		}

		public static void printGridHex( Grid board) {
			
			String gap = "   ";
			
			for( int i = 0; i < board.getRows(); i++) {
				
				for( int j = 0; j < board.getCols(); j++) {
					
					Console.Write( board.getTile( i, j).row + "," + 
					                 board.getTile( i, j).col + gap);
				}
				Console.WriteLine( "\n");
				printTimes( gap, i+ 1);
			}
		}
		
		public static void printGridQuad( Grid board) {
			
			for( int i = 0; i < board.getRows(); i++) {
				
				for( int j = 0; j < board.getCols(); j++) {
					
					Console.Write( board.getTile( i, j).row + "," + 
					                 board.getTile( i, j).col + "\t");
				}
				Console.WriteLine( "\n");
			}
		}
		
		public static void printTimes( String value, int times) {
			
			for( int i = 0; i < times; i++)
				Console.Write( value);
		}
	}
}
