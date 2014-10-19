package visual;

import org.lwjgl.util.Point;

public class Triangle extends Shape{

	public Point center;
	public int size;
	
	public Triangle( Point center, int size) {
		
		this.center = center;
		this.size = size;
	}
	
	public Triangle( int x, int y, int size) {
		
		this( new Point( x, y), size);
	}

	@Override
	public void draw() {
	
		Draw.triangle( center, size);
	}
}
