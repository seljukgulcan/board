package visual;

import org.lwjgl.util.Point;

public class Line extends Shape {

	public Point start, end;
	
	public Line( Point start, Point end) {
		
		this.start = start;
		this.end = end;
	}
	
	public Line( int x1, int y1, int x2, int y2) {
		
		this( new Point( x1, y1), new Point( x2, y2));
	}

	@Override
	public void draw() {
		
		Draw.line( start, end);
	}
	
}
