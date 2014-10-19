package visual;

import org.lwjgl.util.Point;

public class Square extends Rect {

	public Square( Point leftBottom, int width) {
		
		super( leftBottom, width, width);
	}
	
	public Square( int x, int y, int width) {
		
		super( x, y, width, width);
	}
}
