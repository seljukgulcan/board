package command;

public class Commands {
	
	public static final int EXIT = -1;
	public static final int PROPER_END = 1;
	public static final int NO_COMMAND_FOUND = -2;
	public static final int NO_OF_ARGS_NOT_MATCHING = -3;
	
	enum Command {exit, help};

	public static int execute( String command, int[] args) {
		
		Command commandEnum = Command.valueOf( command);
		switch( commandEnum) {
		
			case exit:
				
				return EXIT;
				
			case help:
				
				
				break;
			
			default:
				return NO_COMMAND_FOUND;
		}
		
		return PROPER_END;
	}
}
