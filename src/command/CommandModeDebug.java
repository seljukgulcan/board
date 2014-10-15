/*package command;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CommandModeDebug {

    public static void main(String[] args){

    	Scanner scanner = new Scanner( System.in);
        while (true) {

            Pattern pattern = 
            Pattern.compile( scanner.nextLine());

            Matcher matcher = 
            pattern.matcher( scanner.nextLine());

            boolean found = false;
            while (matcher.find()) {
            	System.out.println("I found the text " + matcher.group() +
                    " starting at " + matcher.start() +
                    " index and ending at index " + matcher.end());
                found = true;
            }
            if(!found){
                System.out.println("No match found.%n");
            }
        }
    }
}*/

package command;

public class CommandModeDebug {

	public static void main( String[] args) {
		
		CommandMode debug = new CommandMode();
		
		debug.run();
	}
}
