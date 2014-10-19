package command;

import visual.Draw;

public class Commands {
	
	public static final int EXIT = -1;
	public static final int PROPER_END = 1;
	public static final int NO_COMMAND_FOUND = -2;
	public static final int NO_OF_ARGS_NOT_MATCHING = -3;
	public static final int WRONG_ARGS = -4;
	
	enum Command {exit, square, help, testargs};

	public static int execute( String command, int[] args) {
		
		Command commandEnum;
		try {
			
			commandEnum = Command.valueOf( command);
		}
		catch( IllegalArgumentException e) {
			
			return NO_COMMAND_FOUND;
		}
		switch( commandEnum) {
		
			case exit:
				
				return EXIT;
				
			case help:
				
				
				break;
				
			case square:
				
				if( args.length != 3)
					return NO_OF_ARGS_NOT_MATCHING;
				
				if( args[2] < 0)
					return WRONG_ARGS;
				
				Draw.square( args[0], args[1], args[2]);				
				
				break;
				
			case testargs:
				
				System.out.println( "Argument tester of the console");
				for( int i = 0; i < args.length; i++)
					System.out.println( args[i]);
				
				System.out.println( "Total number of arguments: " + args.length);
				
				break;
			
			default:
				return NO_COMMAND_FOUND;
		}
		
		return PROPER_END;
	}
}
