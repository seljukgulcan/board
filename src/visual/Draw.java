package visual;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class Draw {

	public static void square( Rectangle rect) {
		
		glBegin( GL_QUADS);
		{
			glVertex2f( rect.getX(), rect.getY());
			glVertex2f( rect.getX() + rect.getWidth(), rect.getY());
			glVertex2f( rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight());
			glVertex2f( rect.getX(), rect.getY() + rect.getHeight());
		}
		glEnd();
	}
	
	public static void square( Point leftBottom, int width, int height) {
		
		Rectangle rect = new Rectangle( leftBottom.getX(), leftBottom.getY(), width, height);
		square( rect);
	}
	
	public static void square( int x, int y, int width, int height) {
		
		Rectangle rect = new Rectangle( x, y, width, height);
		square( rect);
	}
	
	public static void line( Point start, Point end) {
		
		glBegin( GL_LINES);
		{
			glVertex2f( start.getX(), start.getY());
			glVertex2f( end.getX(), end.getY());
		}
		glEnd();
	}
	
	public static void line( int x1, int y1, int x2, int y2) {
		
		line( new Point( x1, y1), new Point( x2, y2));
	}
}
