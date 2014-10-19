package command;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputValidator {
	
	public static final int CORRECT = 1;
	public static final int NO_INPUT = 0;
	
	public static final int SYNTAX_WRONG = -1;
	public static final int NO_COMMAND_FOUND = -2;
	public static final int BAD_PARAMETERS = -3;
	
	private static final String syntaxRegex = "[a-z]+\\((-?\\d*|((-?\\d+,)+(-?\\d+)))\\)";
	private static final String argRegex = "-?\\d+";
	
	public static CommandPair validate( String in, ValidationPair validationResult) {
		
		//1. Trim spaces.
		in = in.replaceAll( " ", "");
		
		if( in.length() == 0) {
			
			validationResult.status = NO_INPUT;
			validationResult.message = "There is no input.";
			return null;
		}
		
		//2. Check whether the command is in valid syntax.
		Pattern commandPattern = Pattern.compile( syntaxRegex);
		Matcher command = commandPattern.matcher( in);
		
		if( !command.matches()) {
			
			validationResult.status = SYNTAX_WRONG;
			validationResult.message = "Syntax of this query is wrong.";
			return null;
		}
		
		//3. Move parameters to an array.
		
		Pattern argPattern = Pattern.compile( argRegex);
		Matcher argMatcher = argPattern.matcher( in);
		
		int noOfArg = 0;
		while( argMatcher.find())
			noOfArg++;
		
		int[] args = new int[noOfArg];
		
		int i = 0;
		
		argMatcher.reset();
		while( argMatcher.find()) {
			
			args[i] = Integer.parseInt( argMatcher.group());
			i++;
		}
		
		validationResult.status = CORRECT;
		validationResult.message = "Correct";
		String commandName = in.substring( 0, in.indexOf( '('));
		return new CommandPair( commandName, args);
	}
}
