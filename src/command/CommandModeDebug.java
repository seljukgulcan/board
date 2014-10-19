package command;

import visual.Canvas;

public class CommandModeDebug {

	public static void main( String[] args) {
		
		CommandMode debug = new CommandMode();
		Canvas display = new Canvas();
		display.init( "Test", 800, 600);
		display.loop();
		debug.run();
	}
}
