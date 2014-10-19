package command;

import java.util.Scanner;

/**
 * CommandMode.java
 * 
 * Creates a command based debug mode for board package.
 * 
 * @author shathra
 */

public class CommandMode {
	
	private static final int RUNNING = 1;
	private static final int STOPPED = 0;
	
	private int status;
	private Scanner scanner;
	
	public CommandMode() {
		
		scanner = new Scanner( System.in);
		status = STOPPED;
	}
	
	public void init() {
		
		//TODO:Fill the method
		
		//init a visual opengl object
	}

	public void run() {
		
		status = RUNNING;
		String in;
		ValidationPair validationResult;
		validationResult = new ValidationPair( 0, "");
		CommandPair command;
		
		while( status == RUNNING) {
			
			in = scanner.nextLine();
			
			command = InputValidator.validate( in, validationResult);
			if( command == null) {
				
				System.out.println( validationResult.message);
				continue;
			}
			
			int executeResult = execute( command);
			if( executeResult == Commands.EXIT)
				status = STOPPED;
			
			else if( executeResult == Commands.NO_COMMAND_FOUND) {
				
				System.out.println( command.command + " is not a valid board command.");
			}
			
			else if( executeResult == Commands.NO_OF_ARGS_NOT_MATCHING)
				System.out.println( "NO_OF_ARGS_NOT_MATCHING");
			
			else if( executeResult == Commands.WRONG_ARGS)
				System.out.println( "WRONG_ARGS");
		}
	}
	
	private int execute( CommandPair command) {
		
		return Commands.execute( command.command, command.args);
	}
}
