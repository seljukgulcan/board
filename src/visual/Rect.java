package visual;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class Rect extends Shape {
	
	public Rectangle rect;
	
	public Rect( Rectangle rect) {
		
		this.rect = rect;
	}
	
	public Rect( int x, int y, int width, int height) {
		
		rect = new Rectangle( x, y, width, height);
	}
	
	public Rect( Point leftBottom, int width, int height) {
		
		rect = new Rectangle( leftBottom.getX(), leftBottom.getY(), width, height);
	}

	@Override
	public void draw() {
		
		Draw.square( rect);
	}
}
