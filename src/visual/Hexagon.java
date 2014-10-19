package visual;

import org.lwjgl.util.Point;

public class Hexagon extends Shape {
	
	public int size;
	public Point center;
	
	public Hexagon( Point center, int size) {
		
		this.center = center;
		this.size = size;
	}
	
	public Hexagon( int x, int y, int size) {
		
		this.center = new Point( x, y);
		this.size = size;
	}

	@Override
	public void draw() {

		Draw.hexagon( center, size);
	}
}
